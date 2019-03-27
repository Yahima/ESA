package org.dieschnittstelle.jee.esa.ejb.ejbmodule.crm.shopping;

import org.apache.logging.log4j.Logger;
import org.dieschnittstelle.jee.esa.ejb.ejbmodule.crm.*;
import org.dieschnittstelle.jee.esa.ejb.ejbmodule.erp.StockSystemRemote;
import org.dieschnittstelle.jee.esa.ejb.ejbmodule.erp.crud.ProductCRUDRemote;
import org.dieschnittstelle.jee.esa.ejb.ejbmodule.erp.crud.ProductCRUDStateless;
import org.dieschnittstelle.jee.esa.entities.crm.AbstractTouchpoint;
import org.dieschnittstelle.jee.esa.entities.crm.Customer;
import org.dieschnittstelle.jee.esa.entities.crm.CustomerTransaction;
import org.dieschnittstelle.jee.esa.entities.crm.ShoppingCartItem;
import org.dieschnittstelle.jee.esa.entities.erp.AbstractProduct;
import org.dieschnittstelle.jee.esa.entities.erp.Campaign;
import org.dieschnittstelle.jee.esa.entities.erp.IndividualisedProductItem;
import org.dieschnittstelle.jee.esa.entities.erp.ProductBundle;

import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import java.util.List;

@Stateful
public class ShoppingSessionFacadeStateful implements ShoppingSessionFacadeRemote{

    protected static Logger logger = org.apache.logging.log4j.LogManager.getLogger(ShoppingSessionFacadeStateful.class);

    /*
     * the three beans that are used
     */
    @EJB
    private ShoppingCartLocal shoppingCart;

    @EJB(name="customerTrackingSystem")
    private CustomerTrackingLocal customerTracking;

    @EJB
    private CampaignTrackingLocal campaignTracking;

    @EJB
    private ProductCRUDRemote productCRUD;

    @EJB
    private StockSystemRemote stockSystem;

    /**
     * the customer
     */
    private Customer customer;

    /**
     * the touchpoint
     */
    private AbstractTouchpoint touchpoint;

    private boolean purchaseDone = false;
    public ShoppingSessionFacadeStateful() {
        logger.info("<constructor>");
    }

    public void setTouchpoint(AbstractTouchpoint touchpoint) {
        this.touchpoint = touchpoint;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void addProduct(AbstractProduct product, int units) {
        this.shoppingCart.addItem(new ShoppingCartItem(product.getId(), units, product instanceof Campaign));
    }

    /*
     * verify whether campaigns are still valid
     */
    public void verifyCampaigns() throws ShoppingException {
        if (this.customer == null || this.touchpoint == null) {
            throw new RuntimeException("cannot verify campaigns! No touchpoint has been set!");
        }

        for (ShoppingCartItem item : this.shoppingCart.getItems()) {
            System.out.println(item + " ----------------------------------- ");
            if (item.isCampaign()) {
                int availableCampaigns = this.campaignTracking.existsValidCampaignExecutionAtTouchpoint(
                        item.getErpProductId(), this.touchpoint);
                System.out.println("is campaign ----------------------------------- ");
                logger.info("got available campaigns for product " + item.getErpProductId() + ": "
                        + availableCampaigns);
                // we check whether we have sufficient campaign items available
                if (availableCampaigns < item.getUnits()) {
                    throw new ShoppingException("verifyCampaigns() failed for productBundle " + item
                            + " at touchpoint " + this.touchpoint + "! Need " + item.getUnits()
                            + " instances of campaign, but only got: " + availableCampaigns);
                }
            }
        }
    }

    public void purchase()  throws ShoppingException {
        logger.info("purchase()");

        if (this.customer == null || this.touchpoint == null) {
            throw new RuntimeException(
                    "cannot commit shopping session! Either customer or touchpoint has not been set: " + this.customer
                            + "/" + this.touchpoint);
        }

        // verify the campaigns
        verifyCampaigns();

        // remove the products from stock
        checkAndRemoveProductsFromStock();

        // then we add a new customer transaction for the current purchase
        List<ShoppingCartItem> products = this.shoppingCart.getItems();
        CustomerTransaction transaction = new CustomerTransaction(this.customer, this.touchpoint, products);
        transaction.setCompleted(true);
        customerTracking.createTransaction(transaction);

        purchaseDone = true;
        logger.info("purchase(): done.\n");
    }

    /*
     * to be implemented as server-side method for PAT2
     */
    private void checkAndRemoveProductsFromStock() {
        logger.info("checkAndRemoveProductsFromStock");

        for (ShoppingCartItem item : this.shoppingCart.getItems()) {

            // TODO: ermitteln Sie das AbstractProduct für das gegebene ShoppingCartItem. Nutzen Sie dafür dessen erpProductId und die ProductCRUD EJB
            AbstractProduct prod = productCRUD.readProduct(item.getErpProductId());
            if (item.isCampaign()) {
                this.campaignTracking.purchaseCampaignAtTouchpoint(item.getErpProductId(), this.touchpoint,
                        item.getUnits());
                // TODO: wenn Sie eine Kampagne haben, muessen Sie hier
                // 1) ueber die ProductBundle Objekte auf dem Campaign Objekt iterieren, und
                for (ProductBundle productBundle : ((Campaign)prod).getBundles()) {
                    // 2) fuer jedes ProductBundle das betreffende Produkt in der auf dem Bundle angegebenen Anzahl, multipliziert mit dem Wert von
                    // item.getUnits() aus dem Warenkorb,
                    int units = productBundle.getUnits() * item.getUnits();
                    // - hinsichtlich Verfuegbarkeit ueberpruefen, und
                    int unitsOnStock = stockSystem.getUnitsOnStock(productBundle.getProduct(), this.touchpoint.getErpPointOfSaleId());
                    // - falls verfuegbar, aus dem Warenlager entfernen - nutzen Sie dafür die StockSystem EJB

                    System.out.println("Check " + productBundle.getProduct() + " units: " + units + " UnitsOnStock: " + unitsOnStock);
                    if (unitsOnStock >= units) {
                        stockSystem.removeFromStock(productBundle.getProduct(), this.touchpoint.getErpPointOfSaleId(), units);
                    } else {
                        System.out.println("campaign reicht nicht :P");
                    }
                }
                // (Anm.: item.getUnits() gibt Ihnen Auskunft darüber, wie oft ein Produkt, im vorliegenden Fall eine Kampagne, im
                // Warenkorb liegt)
            } else {
                // TODO: andernfalls (wenn keine Kampagne vorliegt) muessen Sie
                // 1) das Produkt in der in item.getUnits() angegebenen Anzahl hinsichtlich Verfuegbarkeit ueberpruefen und
                    int unitsOnStock = stockSystem.getUnitsOnStock((IndividualisedProductItem)prod, this.touchpoint.getErpPointOfSaleId());
                // 2) das Produkt, falls verfuegbar, in der entsprechenden Anzahl aus dem Warenlager entfernen
                System.out.println("Check " + prod + " units: " + item.getUnits() + " UnitsOnStock: " + unitsOnStock);

                    if(unitsOnStock >= item.getUnits()){
                        stockSystem.removeFromStock((IndividualisedProductItem)prod, this.touchpoint.getErpPointOfSaleId(), item.getUnits());
                    }else {
                        System.out.println("prod reicht nicht :P");
                    }
            }

        }
    }

    @PreDestroy
    public void preDestroy(){
        if(!purchaseDone){
              CustomerTransaction customerTransaction = new CustomerTransaction(customer, touchpoint, shoppingCart.getItems());
              customerTracking.createTransaction(customerTransaction);
        }
    }
}

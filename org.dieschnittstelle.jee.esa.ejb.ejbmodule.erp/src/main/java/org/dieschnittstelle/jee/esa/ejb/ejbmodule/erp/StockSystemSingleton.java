package org.dieschnittstelle.jee.esa.ejb.ejbmodule.erp;

import org.apache.logging.log4j.Logger;
import org.dieschnittstelle.jee.esa.ejb.ejbmodule.erp.crud.PointOfSaleCRUDLocal;
import org.dieschnittstelle.jee.esa.ejb.ejbmodule.erp.crud.PointOfSaleCRUDStateless;
import org.dieschnittstelle.jee.esa.ejb.ejbmodule.erp.crud.StockItemCRUDLocal;
import org.dieschnittstelle.jee.esa.ejb.ejbmodule.erp.crud.StockItemCRUDStateless;
import org.dieschnittstelle.jee.esa.entities.erp.IndividualisedProductItem;
import org.dieschnittstelle.jee.esa.entities.erp.PointOfSale;
import org.dieschnittstelle.jee.esa.entities.erp.StockItem;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class StockSystemSingleton implements StockSystemRemote, StockSystemLocal{
    protected static Logger logger = org.apache.logging.log4j.LogManager.getLogger(StockItemCRUDStateless.class);

    @EJB(beanName="stockItemCRUD")
    StockItemCRUDLocal stockItemCRUD;
    @EJB(beanName="PointOfSaleCRUD")
    PointOfSaleCRUDLocal posCRUD;

    @Override
    public void addToStock(IndividualisedProductItem product, long pointOfSaleId, int units) {
        PointOfSale pointOfSale = posCRUD.readPointOfSale(pointOfSaleId);
        StockItem stockItem = stockItemCRUD.readStockItem(product, pointOfSale);
        if(stockItem != null){
            if(stockItem.getUnits() + units < 0){
                stockItem.setUnits(0);
            }
            else {
                stockItem.setUnits(stockItem.getUnits() + units);

            }
            stockItemCRUD.updateStockItem(stockItem);
        }
        else {
            stockItem = new StockItem(product, pointOfSale, units);
            stockItemCRUD.createStockItem(stockItem);
        }

    }

    @Override
    public void removeFromStock(IndividualisedProductItem product, long pointOfSaleId, int units) {
        addToStock(product, pointOfSaleId, -units);
    }

    @Override
    public List<IndividualisedProductItem> getProductsOnStock(long pointOfSaleId) {
        PointOfSale pointOfSale = posCRUD.readPointOfSale(pointOfSaleId);
        List<StockItem> stockItemList = stockItemCRUD.readStockItemsForPointOfSale(pointOfSale);
        List<IndividualisedProductItem> ipiList = new ArrayList<IndividualisedProductItem>();
        for (StockItem si:stockItemList) {
            if(si.getUnits() > 0){
                ipiList.add(si.getProduct());
            }
        }
        return ipiList;
    }

    @Override
    public List<IndividualisedProductItem> getAllProductsOnStock() {
        System.out.println("SSS - getallprod posCRUD: " + posCRUD);
        List<PointOfSale> pointOfSaleList = posCRUD.readAllPointsOfSale();
        System.out.println("POS-List: " + pointOfSaleList);
        List<IndividualisedProductItem> ipiList = new ArrayList<IndividualisedProductItem>();
        for (PointOfSale pos : pointOfSaleList) {
            List<StockItem> stockItemList = stockItemCRUD.readStockItemsForPointOfSale(pos);

            for (StockItem si : stockItemList) {
                System.out.println("SI: " + si);
                if(!ipiList.contains(si.getProduct()) && si.getUnits() > 0){
                    System.out.println("add to list ");
                    ipiList.add(si.getProduct());
                } else {
                    System.out.println("SI: " + si);
                }
            }
        }
        return ipiList;
    }

    @Override
    public int getUnitsOnStock(IndividualisedProductItem product, long pointOfSaleId) {
        PointOfSale pointOfSale = posCRUD.readPointOfSale(pointOfSaleId);
        StockItem stockItem = stockItemCRUD.readStockItem(product, pointOfSale);
        if(stockItem != null){
            return stockItem.getUnits();
        }
        else {
            System.out.println("getUnitsOnStock: StockItem is null");
            return 0;
        }

    }

    @Override
    public int getTotalUnitsOnStock(IndividualisedProductItem product) {
        List<StockItem> stockItemList = stockItemCRUD.readStockItemsForProduct(product);
        int units = 0;
        for (StockItem si:stockItemList) {
            units += si.getUnits();
        }
        return units;
    }

    @Override
    public List<Long> getPointsOfSale(IndividualisedProductItem product) {
        List<StockItem> stockItemList = stockItemCRUD.readStockItemsForProduct(product);
        List<Long> posList = new ArrayList<Long>();
        for (StockItem si:stockItemList) {
            if(si.getUnits() > 0) {
                posList.add(si.getPos().getId());
            }
        }
        return posList;
    }

    @Override
    public List<StockItem> getCompleteStock() {
        List<PointOfSale> pointOfSaleList = posCRUD.readAllPointsOfSale();
        List<StockItem> stockItemList = new ArrayList<StockItem>();
        for (PointOfSale pos : pointOfSaleList) {
            List<StockItem> stockItemListPos = stockItemCRUD.readStockItemsForPointOfSale(pos);
            for (StockItem si : stockItemListPos) {
                if(si.getUnits() > 0){
                    stockItemList.add(si);
                }
            }
        }
        return stockItemList;
    }
}

package org.dieschnittstelle.jee.esa.ejb.ejbmodule.erp.crud;

import org.apache.logging.log4j.Logger;
import org.dieschnittstelle.jee.esa.ejb.ejbmodule.erp.StockSystemRemote;
import org.dieschnittstelle.jee.esa.entities.erp.IndividualisedProductItem;
import org.dieschnittstelle.jee.esa.entities.erp.PointOfSale;
import org.dieschnittstelle.jee.esa.entities.erp.ProductAtPosPK;
import org.dieschnittstelle.jee.esa.entities.erp.StockItem;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless(name="stockItemCRUD")
public class StockItemCRUDStateless implements StockItemCRUDLocal{
    protected static Logger logger = org.apache.logging.log4j.LogManager.getLogger(StockItemCRUDStateless.class);

    @PersistenceContext(unitName = "erp_PU")
    private EntityManager em;


    @Override
    public StockItem createStockItem(StockItem item) {
        em.merge(item);
        return item;
    }

    @Override
    public StockItem readStockItem(IndividualisedProductItem prod, PointOfSale pos) {
        return em.find(StockItem.class, new ProductAtPosPK(prod, pos));
    }

    @Override
    public StockItem updateStockItem(StockItem item) {
        item = em.merge(item);
        return item;
    }

    @Override
    public List<StockItem> readAllStockItems() {
        return em.createQuery("SELECT i FROM StockItem AS i").getResultList();
    }

    @Override
    public List<StockItem> readStockItemsForProduct(IndividualisedProductItem prod) {
        return em.createQuery("SELECT i FROM StockItem AS i WHERE i.product LIKE :prod").setParameter("prod", prod).getResultList();
    }

    @Override
    public List<StockItem> readStockItemsForPointOfSale(PointOfSale pos) {
        return em.createQuery("SELECT i FROM StockItem i WHERE i.pos LIKE :pos").setParameter("pos", pos).getResultList();
    }
}

package org.dieschnittstelle.jee.esa.ejb.ejbmodule.erp.crud;

import org.apache.logging.log4j.Logger;
import org.dieschnittstelle.jee.esa.entities.erp.AbstractProduct;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ProductCRUDStateless implements ProductCRUDRemote {

    protected static Logger logger = org.apache.logging.log4j.LogManager.getLogger(ProductCRUDStateless.class);

    @PersistenceContext(unitName = "erp_PU")
    private EntityManager em;

    @Override
    public AbstractProduct createProduct(AbstractProduct prod) {
        System.out.println("create Product - EM: " + prod);

        em.persist(prod);
        return prod;
    }

    @Override
    public List<AbstractProduct> readAllProducts() {
        return em.createQuery("SELECT p FROM AbstractProduct AS p").getResultList();
    }

    @Override
    public AbstractProduct updateProduct(AbstractProduct prod) {
        prod = em.merge(prod);
        return prod;
    }

    @Override
    public AbstractProduct readProduct(long productID) {
        AbstractProduct prod = em.find(AbstractProduct.class, productID);
        return prod;
    }

    @Override
    public boolean deleteProduct(long productID) {
        em.remove(em.find(AbstractProduct.class, productID));
        return true;
    }
}

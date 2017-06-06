/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.Product_Base;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author it207432
 */
@Repository
public class Product_BaseDAOImpl implements Product_BaseDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addProduct(Product_Base pbase) {
        getCurrentSession().save(pbase);
    }

    @Override
    public void updateProduct(Product_Base pbase) {
        Product_Base productToUpdate = getProduct(pbase.getPID());
        productToUpdate.setPRODUCT_CODE(pbase.getPRODUCT_CODE());
        productToUpdate.setPRODUCT_DESCRIPTION(pbase.getPRODUCT_DESCRIPTION());
        productToUpdate.setPRODUCT_NAME(pbase.getPRODUCT_NAME());
        productToUpdate.setWF_PRODUCT_CODE(pbase.getWF_PRODUCT_CODE());
        productToUpdate.setPRODUCT_CATEGORY_ID(pbase.getPRODUCT_CATEGORY_ID());
        getCurrentSession().update(productToUpdate);
    }

    @Override
    public Product_Base getProduct(int pid) {
        Product_Base pbase = (Product_Base) getCurrentSession().get(Product_Base.class, pid);
        return pbase;

    }

    @Override
    public void deleteProduct(int id) {
        Product_Base pbase = getProduct(id);
        if (pbase != null) {
            getCurrentSession().delete(pbase);
        }

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Product_Base> getProducts() {
        return getCurrentSession().createQuery("from Product_Base").list();
    }

}

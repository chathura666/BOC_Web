/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.ProductBase;
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
    public void addProduct(ProductBase pbase) {
        getCurrentSession().save(pbase);
    }

    @Override
    public void updateProduct(ProductBase pbase) {
        ProductBase productToUpdate = getProduct(pbase.getPid());
        productToUpdate.setPid(pbase.getPid());
        productToUpdate.setProductCode(pbase.getProductCode());
        productToUpdate.setProductDescription(pbase.getProductDescription());
        productToUpdate.setProductName(pbase.getProductName());
        productToUpdate.setWfProductCode(pbase.getWfProductCode());
        productToUpdate.setProductCategoryId(pbase.getProductCategoryId());
        getCurrentSession().update(productToUpdate);
    }

    @Override
    public ProductBase getProduct(int pid) {
        ProductBase pbase = (ProductBase) getCurrentSession().get(ProductBase.class, pid);
        return pbase;

    }

    @Override
    public void deleteProduct(int id) {
        ProductBase pbase = getProduct(id);
        if (pbase != null) {
            getCurrentSession().delete(pbase);
        }

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ProductBase> getProducts() {
        return getCurrentSession().createQuery("from ProductBase").list();
    }

}

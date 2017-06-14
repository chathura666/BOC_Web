/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.ProductCategoryBase;
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
public class Product_Category_BaseDAOImpl implements Product_Category_BaseDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addProductCategoryBase(ProductCategoryBase pcbase) {
        getCurrentSession().save(pcbase);
    }

    @Override
    public void updateProductCategoryBase(ProductCategoryBase pcbase) {
        ProductCategoryBase pcToUpdate = getProductCategoryBase(pcbase.getProductCategoryId());
        pcToUpdate.setProductCategoryId(pcbase.getProductCategoryId());
        pcToUpdate.setProductCategory(pcbase.getProductCategory());
        getCurrentSession().update(pcToUpdate);
    }

    @Override
    public ProductCategoryBase getProductCategoryBase(int pid) {
        ProductCategoryBase pcbase = (ProductCategoryBase) getCurrentSession().get(ProductCategoryBase.class, pid);
        return pcbase;

    }

    @Override
    public void deleteProductCategoryBase(int id) {
        ProductCategoryBase pcbase = getProductCategoryBase(id);
        if (pcbase != null) {
            getCurrentSession().delete(pcbase);
        }

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ProductCategoryBase> getProductCategoryBases() {
        return getCurrentSession().createQuery("from ProductCategoryBase").list();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.BsrProductBase;
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
public class BsrProductBaseDAOImpl implements BsrProductBaseDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addBsrProduct(BsrProductBase pbase) {
        getCurrentSession().save(pbase);
    }

    @Override
    public void updateBsrProduct(BsrProductBase pbase) {
        BsrProductBase productToUpdate = getBsrProduct(pbase.getProductId());
        productToUpdate.setCurrency(pbase.getCurrency());
        productToUpdate.setIfFcyAllowedEligibleProductTypes(pbase.getIfFcyAllowedEligibleProductTypes());
        productToUpdate.setProductCode(pbase.getProductCode());
        productToUpdate.setProductId(pbase.getProductId());
        productToUpdate.setProductName(pbase.getProductName());
        productToUpdate.setSoCreditsAllowed(pbase.getSoCreditsAllowed());
        productToUpdate.setSoDebitsAllowed(pbase.getSoDebitsAllowed());
        productToUpdate.setTfrToFcyAcAllowed(pbase.getTfrToFcyAcAllowed());
        productToUpdate.setTfrToLkrAcAllowed(pbase.getTfrToLkrAcAllowed());

        getCurrentSession().update(productToUpdate);
    }

    @Override
    public BsrProductBase getBsrProduct(int pid) {
        BsrProductBase pbase = (BsrProductBase) getCurrentSession().get(BsrProductBase.class, pid);
        return pbase;

    }

    @Override
    public void deleteBsrProduct(int id) {
        BsrProductBase pbase = getBsrProduct(id);
        if (pbase != null) {
            getCurrentSession().delete(pbase);
        }

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<BsrProductBase> getBsrProducts() {
        return getCurrentSession().createQuery("from BsrProductBase").list();
    }

}

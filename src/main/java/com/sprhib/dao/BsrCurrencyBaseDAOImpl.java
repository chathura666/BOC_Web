/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.BsrCurrencyBase;
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
public class BsrCurrencyBaseDAOImpl implements BsrCurrencyBaseDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addBsrCurrency(BsrCurrencyBase cbase) {
        getCurrentSession().save(cbase);
    }

    @Override
    public void updateBsrCurrency(BsrCurrencyBase cbase) {
        BsrCurrencyBase CurrencyToUpdate = getBsrCurrency(cbase.getCurrencyId());
        CurrencyToUpdate.setCurrencyId(cbase.getCurrencyId());
        CurrencyToUpdate.setCurrencyCode(cbase.getCurrencyCode());
        CurrencyToUpdate.setCurrencyName(cbase.getCurrencyName());
        CurrencyToUpdate.setCurrencyShortName(cbase.getCurrencyShortName());
        getCurrentSession().update(CurrencyToUpdate);
    }

    @Override
    public BsrCurrencyBase getBsrCurrency(int pid) {
        BsrCurrencyBase cbase = (BsrCurrencyBase) getCurrentSession().get(BsrCurrencyBase.class, pid);
        return cbase;

    }

    @Override
    public void deleteBsrCurrency(int id) {
        BsrCurrencyBase cbase = getBsrCurrency(id);
        if (cbase != null) {
            getCurrentSession().delete(cbase);
        }

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<BsrCurrencyBase> getBsrCurrencies() {
        return getCurrentSession().createQuery("from BsrCurrencyBase").list();
    }

}

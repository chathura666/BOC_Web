/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.BsrCurrencyBase;
import com.sprhib.model.CasCurrencyBase;
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
public class CasCurrencyBaseDAOImpl implements CasCurrencyBaseDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addCasCurrency(CasCurrencyBase cbase) {
        getCurrentSession().save(cbase);
    }

    @Override
    public void updateCasCurrency(CasCurrencyBase cbase) {
        CasCurrencyBase CurrencyToUpdate = getCasCurrency(cbase.getCurrencyId());
        CurrencyToUpdate.setCurrencyId(cbase.getCurrencyId());
        CurrencyToUpdate.setCurrencyCode(cbase.getCurrencyCode());
        CurrencyToUpdate.setCurrencyName(cbase.getCurrencyName());
        CurrencyToUpdate.setIsactive(cbase.getIsactive());
        getCurrentSession().update(CurrencyToUpdate);
    }
    

    @Override
    public CasCurrencyBase getCasCurrency(int pid) {
        CasCurrencyBase cbase = (CasCurrencyBase) getCurrentSession().get(CasCurrencyBase.class, pid);
        return cbase;

    }

    @Override
    public void deleteCasCurrency(int id) {
        CasCurrencyBase cbase = getCasCurrency(id);
        if (cbase != null) {
            getCurrentSession().delete(cbase);
        }

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<CasCurrencyBase> getCasCurrencies() {
        return getCurrentSession().createQuery("from CasCurrencyBase").list();
    }

}

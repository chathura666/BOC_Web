/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.CollateralBase;
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
public class CollateralBaseDAOImpl implements CollateralBaseDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addCollateralBase(CollateralBase cbase) {
        getCurrentSession().persist(cbase);
    }

    @Override
    public void updateCollateralBase(CollateralBase cbase) {
        CollateralBase CollateralToUpdate = getCollateralBase(cbase.getCid());
        CollateralToUpdate.setCid(cbase.getCid());
        CollateralToUpdate.setCollateralCode(cbase.getCollateralCode());
        CollateralToUpdate.setCollateralDescription(cbase.getCollateralDescription());
        getCurrentSession().update(CollateralToUpdate);
    }

    @Override
    public CollateralBase getCollateralBase(int pid) {
        CollateralBase cbase = (CollateralBase) getCurrentSession().get(CollateralBase.class, pid);
        return cbase;

    }

    @Override
    public void deleteCollateralBase(int id) {
        CollateralBase cbase = getCollateralBase(id);
        if (cbase != null) {
            getCurrentSession().delete(cbase);
        }

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<CollateralBase> getCollateralBases() {
        return getCurrentSession().createQuery("from CollateralBase").list();
    }


}

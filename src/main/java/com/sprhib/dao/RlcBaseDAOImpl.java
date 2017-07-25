/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.RlcBase;
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
public class RlcBaseDAOImpl implements RlcBaseDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addRlcBase(RlcBase rbase) {
        getCurrentSession().save(rbase);
    }

    @Override
    public void updateRlcBase(RlcBase rbase) {
        RlcBase RlcToUpdate = getRlcBase(rbase.getRlcId());
        RlcToUpdate.setRlcCode(rbase.getRlcCode());
        RlcToUpdate.setRlcId(rbase.getRlcId());
        RlcToUpdate.setRlcName(rbase.getRlcName());

        getCurrentSession().update(RlcToUpdate);
    }

    @Override
    public RlcBase getRlcBase(int pid) {
        RlcBase rbase = (RlcBase) getCurrentSession().get(RlcBase.class, pid);
        return rbase;

    }

    @Override
    public void deleteRlcBase(int id) {
        RlcBase rbase = getRlcBase(id);
        if (rbase != null) {
            getCurrentSession().delete(rbase);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<RlcBase> getRlcBases() {
        return getCurrentSession().createQuery("from RlcBase").list();
    }

}

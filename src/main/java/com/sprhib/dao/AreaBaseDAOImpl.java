/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.AreaBase;
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
public class AreaBaseDAOImpl implements AreaBaseDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addAreaBase(AreaBase abase) {
        getCurrentSession().persist(abase);
    }

    @Override
    public void updateAreaBase(AreaBase abase) {
        AreaBase AreaToUpdate = getAreaBase(abase.getAid());
        AreaToUpdate.setAid(abase.getAid());
        AreaToUpdate.setAreaCode(abase.getAreaCode());
        AreaToUpdate.setAreaName(abase.getAreaName());
        getCurrentSession().update(AreaToUpdate);
    }

    @Override
    public AreaBase getAreaBase(int pid) {
        AreaBase pbase = (AreaBase) getCurrentSession().get(AreaBase.class, pid);
        return pbase;

    }

    @Override
    public void deleteAreaBase(int id) {
        AreaBase abase = getAreaBase(id);
        if (abase != null) {
            getCurrentSession().delete(abase);
        }

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<AreaBase> getAreaBases() {
        return getCurrentSession().createQuery("from AreaBase").list();
    }


}

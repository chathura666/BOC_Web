/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.RlcBranchMapping;
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
public class RlcBranchMappingDAOImpl implements RlcBranchMappingDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addRlcBranchMapping(RlcBranchMapping rmap) {
        getCurrentSession().save(rmap);
    }

    @Override
    public void updateRlcBranchMapping(RlcBranchMapping rmap) {
        RlcBranchMapping mapToUpdate = getRlcBranchMapping(rmap.getRlcBrId());
        mapToUpdate.setBid(rmap.getBid());
        mapToUpdate.setRlcId(rmap.getRlcId());
        mapToUpdate.setRlcBrId(rmap.getRlcBrId());

        getCurrentSession().update(mapToUpdate);
    }

    @Override
    public RlcBranchMapping getRlcBranchMapping(int pid) {
        RlcBranchMapping rmap = (RlcBranchMapping) getCurrentSession().get(RlcBranchMapping.class, pid);
        return rmap;

    }

    @Override
    public void deleteRlcBranchMapping(int id) {
        RlcBranchMapping rmap = getRlcBranchMapping(id);
        if (rmap != null) {
            getCurrentSession().delete(rmap);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<RlcBranchMapping> getRlcBranchMappings() {
        return getCurrentSession().createQuery("from RlcBranchMapping").list();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.AreaBranchMapping;
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
public class AreaBranchMappingDAOImpl implements AreaBranchMappingDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addAreaBranchMap(AreaBranchMapping abmap) {
        getCurrentSession().save(abmap);
    }

    @Override
    public void updateAreaBranchMap(AreaBranchMapping abmap) {
        AreaBranchMapping MapToUpdate = getAreaBranchMap(abmap.getAreaBrId());
        MapToUpdate.setAreaBrId(abmap.getAreaBrId());
        MapToUpdate.setAid(abmap.getAid());
        MapToUpdate.setBid(abmap.getBid());
        getCurrentSession().update(MapToUpdate);
    }

    @Override
    public AreaBranchMapping getAreaBranchMap(int pid) {
        AreaBranchMapping abmap = (AreaBranchMapping) getCurrentSession().get(AreaBranchMapping.class, pid);
        return abmap;

    }

    @Override
    public void deleteAreaBranchMap(int id) {
        AreaBranchMapping abmap = getAreaBranchMap(id);
        if (abmap != null) {
            getCurrentSession().delete(abmap);
        }

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<AreaBranchMapping> getAreaBranchMaps() {
        return getCurrentSession().createQuery("from AreaBranchMapping").list();
    }


}

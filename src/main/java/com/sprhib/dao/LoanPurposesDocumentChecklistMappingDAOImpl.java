/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.LoanPurposesDocumentChecklistMapping;
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
public class LoanPurposesDocumentChecklistMappingDAOImpl implements LoanPurposesDocumentChecklistMappingDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addMapping(LoanPurposesDocumentChecklistMapping map) {
        getCurrentSession().persist(map);
    }

    @Override
    public void updateMapping(LoanPurposesDocumentChecklistMapping map) {
        LoanPurposesDocumentChecklistMapping mapToUpdate = getMapping(map.getPrpid());
        mapToUpdate.setPurposeId(map.getPurposeId());
        mapToUpdate.setDocumentId(map.getDocumentId());
        mapToUpdate.setScanRequired(map.getScanRequired());
        mapToUpdate.setMandatory(map.getMandatory());
        getCurrentSession().update(mapToUpdate);
    }

    @Override
    public LoanPurposesDocumentChecklistMapping getMapping(int pid) {
        LoanPurposesDocumentChecklistMapping map = (LoanPurposesDocumentChecklistMapping) getCurrentSession().get(LoanPurposesDocumentChecklistMapping.class, pid);
        return map;

    }

    @Override
    public void deleteMapping(int id) {
        LoanPurposesDocumentChecklistMapping map = getMapping(id);
        if (map != null) {
            getCurrentSession().delete(map);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<LoanPurposesDocumentChecklistMapping> getMappings() {
        return getCurrentSession().createQuery("from LoanPurposesDocumentChecklistMapping").list();
    }


}

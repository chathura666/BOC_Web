/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.LoanProductIndexIdMapping;
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
public class LoanProductIndexIdMappingDAOImpl implements LoanProductIndexIdMappingDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addLoanProductIndexIdMap(LoanProductIndexIdMapping ipdamp) {
        getCurrentSession().save(ipdamp);
    }

    @Override
    public void updateLoanProductIndexIdMap(LoanProductIndexIdMapping ipdamp) {
        LoanProductIndexIdMapping idToUpdate = getLoanProductIndexIdMap(ipdamp.getProdIndexId());
        idToUpdate.setProdIndexId(ipdamp.getProdIndexId());
        idToUpdate.setPid(ipdamp.getPid());
        idToUpdate.setIdxId(ipdamp.getIdxId());
        getCurrentSession().update(idToUpdate);
    }

    @Override
    public LoanProductIndexIdMapping getLoanProductIndexIdMap(int pid) {
        LoanProductIndexIdMapping pbase = (LoanProductIndexIdMapping) getCurrentSession().get(LoanProductIndexIdMapping.class, pid);
        return pbase;

    }

    @Override
    public void deleteLoanProductIndexIdMap(int id) {
        LoanProductIndexIdMapping idmap = getLoanProductIndexIdMap(id);
        if (idmap != null) {
            getCurrentSession().delete(idmap);
        }

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<LoanProductIndexIdMapping> getLoanProductIndexIdMaps() {
        return getCurrentSession().createQuery("from LoanProductIndexIdMapping").list();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.CasSequenceNumber;
import com.sprhib.model.CasSequenceNumberPK;
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
public class CasSequenceNumberDAOImpl implements CasSequenceNumberDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addSequenceNumber(CasSequenceNumber seqnum) {
        getCurrentSession().save(seqnum);
    }

    @Override
    public void updateSequenceNumber(CasSequenceNumber seqnum) {
        
        CasSequenceNumber casSequenceNumber = getSequenceNumber(seqnum.getCasSequenceNumberPK());
        casSequenceNumber.getCasSequenceNumberPK().setBranchCode(seqnum.getCasSequenceNumberPK().getBranchCode());
        casSequenceNumber.getCasSequenceNumberPK().setSequenceNo(seqnum.getCasSequenceNumberPK().getSequenceNo());
        casSequenceNumber.setCurrentYear(seqnum.getCurrentYear());
        
        getCurrentSession().update(casSequenceNumber);
    }

    @Override
    public CasSequenceNumber getSequenceNumber(CasSequenceNumberPK pid) {
        CasSequenceNumber pbase = (CasSequenceNumber) getCurrentSession().get(CasSequenceNumber.class, pid);
        return pbase;

    }

    @Override
    public void deleteSequenceNumber(CasSequenceNumber id) {
        CasSequenceNumber seqnum = getSequenceNumber(id.getCasSequenceNumberPK());
        if (seqnum != null) {
            getCurrentSession().delete(seqnum);
        }

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<CasSequenceNumber> getSequenceNumbers() {
        return getCurrentSession().createQuery("from CasSequenceNumber").list();
    }

}

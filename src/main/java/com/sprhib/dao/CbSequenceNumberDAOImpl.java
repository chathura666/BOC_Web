/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.AreaBase;
import com.sprhib.model.BranchBase;
import com.sprhib.model.CbSequenceNumber;
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
public class CbSequenceNumberDAOImpl implements CbSequenceNumberDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addCbSequenceNumber(CbSequenceNumber sqnum) {
        getCurrentSession().save(sqnum);
    }

    @Override
    public void updateCbSequenceNumber(CbSequenceNumber sqnum) {
        CbSequenceNumber seqToUpdate = getCbSequenceNumber(sqnum.getCbSequenceNumberPK().getSequenceNo());
        seqToUpdate.setCbSequenceNumberPK(sqnum.getCbSequenceNumberPK());
        getCurrentSession().update(seqToUpdate);
    }

    @Override
    public CbSequenceNumber getCbSequenceNumber(int pid) {
        CbSequenceNumber sqnum = (CbSequenceNumber) getCurrentSession().get(CbSequenceNumber.class, pid);
        return sqnum;

    }

    @Override
    public void deleteCbSequenceNumber(int id) {
        CbSequenceNumber sqnum = getCbSequenceNumber(id);
        if (sqnum != null) {
            getCurrentSession().delete(sqnum);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<CbSequenceNumber> getCbSequenceNumbers() {
        return getCurrentSession().createQuery("from CbSequenceNumber").list();
    }

}

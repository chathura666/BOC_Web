/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.AreaBase;
import com.sprhib.model.BsrPayeeBase;
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
public class BsrPayeeBaseDAOImpl implements BsrPayeeBaseDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addBsrPayee(BsrPayeeBase payee) {
        getCurrentSession().save(payee);
    }

    @Override
    public void updateBsrPayee(BsrPayeeBase payee) {
        BsrPayeeBase PayeeToUpdate = getBsrPayee(payee.getPayeeId());
        PayeeToUpdate.setPayeeId(payee.getPayeeId());
        PayeeToUpdate.setAccountNo(payee.getAccountNo());
        PayeeToUpdate.setComprofDrAcDd(payee.getComprofDrAcDd());
        PayeeToUpdate.setComprofDrAcSv(payee.getComprofDrAcSv());        
        PayeeToUpdate.setCurrency(payee.getCurrency());
        PayeeToUpdate.setFeePlan(payee.getFeePlan());
        PayeeToUpdate.setPayee(payee.getPayee());
        PayeeToUpdate.setPayeeType(payee.getPayeeType());        
        PayeeToUpdate.setTargetDescription(payee.getTargetDescription());
        PayeeToUpdate.setTargetType(payee.getTargetType());

        getCurrentSession().update(PayeeToUpdate);
    }

    @Override
    public BsrPayeeBase getBsrPayee(int pid) {
        BsrPayeeBase payee = (BsrPayeeBase) getCurrentSession().get(BsrPayeeBase.class, pid);
        return payee;

    }

    @Override
    public void deleteBsrPayee(int id) {
        BsrPayeeBase payee = getBsrPayee(id);
        if (payee != null) {
            getCurrentSession().delete(payee);
        }

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<BsrPayeeBase> getBsrPayees() {
        return getCurrentSession().createQuery("from BsrPayeeBase").list();
    }


}

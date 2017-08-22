/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.AreaBase;
import com.sprhib.model.LoanPurposes;
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
public class LoanPurposesDAOImpl implements LoanPurposesDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addLoanPurposes(LoanPurposes loan) {
        getCurrentSession().persist(loan);
    }

    @Override
    public void updateLoanPurposes(LoanPurposes loan) {
        LoanPurposes LoanPurposesToUpdate = getLoanPurposes(loan.getPid());
        LoanPurposesToUpdate.setPid(loan.getPid());
        LoanPurposesToUpdate.setLoanPurposes(loan.getLoanPurposes());
        LoanPurposesToUpdate.setProductCategoryId(loan.getProductCategoryId());
        getCurrentSession().update(LoanPurposesToUpdate);
    }

    @Override
    public LoanPurposes getLoanPurposes(int pid) {
        LoanPurposes pbase = (LoanPurposes) getCurrentSession().get(LoanPurposes.class, pid);
        return pbase;

    }

    @Override
    public void deleteLoanPurposes(int id) {
        LoanPurposes loan = getLoanPurposes(id);
        if (loan != null) {
            getCurrentSession().delete(loan);
        }

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<LoanPurposes> getLoanPurposes() {
        return getCurrentSession().createQuery("from LoanPurposes").list();
    }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.AreaBase;
import com.sprhib.model.LoanInterestRateVariance;
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
public class LoanInterestRateVarianceDAOImpl implements LoanInterestRateVarianceDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addVariance(LoanInterestRateVariance var) {
        getCurrentSession().persist(var);
    }

    @Override
    public void updateVariance(LoanInterestRateVariance var) {
        LoanInterestRateVariance VarianceToUpdate = getVariance(var.getLirvId());
        VarianceToUpdate.setLirvId(var.getLirvId());
        VarianceToUpdate.setPid(var.getPid());
        VarianceToUpdate.setVarianceFixed(var.getVarianceFixed());
        VarianceToUpdate.setVarianceRateVariable1(var.getVarianceRateVariable1());
        VarianceToUpdate.setVarianceRateVariable2(var.getVarianceRateVariable2());
        VarianceToUpdate.setMinRepaymentPeriod(var.getMinRepaymentPeriod());
        VarianceToUpdate.setMaxRepaymentPeriod(var.getMaxRepaymentPeriod());
        getCurrentSession().update(VarianceToUpdate);
    }

    @Override
    public LoanInterestRateVariance getVariance(int pid) {
        LoanInterestRateVariance var = (LoanInterestRateVariance) getCurrentSession().get(LoanInterestRateVariance.class, pid);
        return var;

    }

    @Override
    public void deleteVariance(int id) {
        LoanInterestRateVariance var = getVariance(id);
        if (var != null) {
            getCurrentSession().delete(var);
        }

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<LoanInterestRateVariance> getVariances() {
        return getCurrentSession().createQuery("from LoanInterestRateVariance").list();
    }

}

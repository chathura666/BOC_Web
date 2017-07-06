/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.CcCardCategoryWiseCreditLimits;
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
public class CcardCategoryWiseCreditLimitDAOImpl implements CcardCategoryWiseCreditLimitDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addCCWiseCreditLimit(CcCardCategoryWiseCreditLimits CCClimit) {
        getCurrentSession().save(CCClimit);
    }

    @Override
    public void updateCCWiseCreditLimit(CcCardCategoryWiseCreditLimits CCClimit) {
        CcCardCategoryWiseCreditLimits limitToUpdate = getCCWiseCreditLimit(CCClimit.getCclId());
        limitToUpdate.setCclId(CCClimit.getCclId());
        limitToUpdate.setLowerLimit(CCClimit.getLowerLimit());
        limitToUpdate.setMainCategory(CCClimit.getMainCategory());
        limitToUpdate.setSubCategory(CCClimit.getSubCategory());
        limitToUpdate.setUpperLimit(CCClimit.getUpperLimit());
        getCurrentSession().update(limitToUpdate);
    }

    @Override
    public CcCardCategoryWiseCreditLimits getCCWiseCreditLimit(int pid) {
        CcCardCategoryWiseCreditLimits cclimit = (CcCardCategoryWiseCreditLimits) getCurrentSession().get(CcCardCategoryWiseCreditLimits.class, pid);
        return cclimit;

    }

    @Override
    public void deleteCCWiseCreditLimit(int id) {
        CcCardCategoryWiseCreditLimits cclimit = getCCWiseCreditLimit(id);
        if (cclimit != null) {
            getCurrentSession().delete(cclimit);
        }

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<CcCardCategoryWiseCreditLimits> getCCWiseCreditLimit() {
        return getCurrentSession().createQuery("from CcCardCategoryWiseCreditLimits").list();
    }

}

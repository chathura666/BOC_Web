/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.CcCardCategoryWiseEligibilites;
import com.sprhib.model.CcCardCategoryWiseEligibilitesPK;
import java.util.Iterator;
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
public class CcCardCategoryWiseEligibilitesDAOImpl implements CcCardCategoryWiseEligibilitesDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addCCWiseEligibility(CcCardCategoryWiseEligibilites eligible) {
        getCurrentSession().save(eligible);
    }

    @Override
    public void updateCCWiseEligibility(CcCardCategoryWiseEligibilites eligible) {

        CcCardCategoryWiseEligibilitesPK cardCategoryWiseEligibilitesPK = null;

        List<CcCardCategoryWiseEligibilites> listall = getCCWiseEligibilities();
        Iterator<CcCardCategoryWiseEligibilites> eligibleLIst = listall.iterator();

        CcCardCategoryWiseEligibilites tempcc = null;
        CcCardCategoryWiseEligibilitesPK temppk = null;
        CcCardCategoryWiseEligibilites newPK = null;

        while (eligibleLIst.hasNext()) {
            tempcc = eligibleLIst.next();
            if (tempcc.getCcCardCategoryWiseEligibilitesPK().getCceId()== eligible.getCcCardCategoryWiseEligibilitesPK().getCceId()) {

                newPK = getCCWiseEligibility(tempcc.getCcCardCategoryWiseEligibilitesPK());

                System.out.println(newPK);
                newPK.getCcCardCategoryWiseEligibilitesPK().setCceId(eligible.getCcCardCategoryWiseEligibilitesPK().getCceId());
                newPK.getCcCardCategoryWiseEligibilitesPK().setMainCategory(eligible.getCcCardCategoryWiseEligibilitesPK().getMainCategory());
                newPK.getCcCardCategoryWiseEligibilitesPK().setSubCategory(eligible.getCcCardCategoryWiseEligibilitesPK().getSubCategory());
                newPK.getCcCardCategoryWiseEligibilitesPK().setSubSelection(eligible.getCcCardCategoryWiseEligibilitesPK().getSubSelection());
                System.out.println(newPK);

                break;
            }
            getCurrentSession().save(newPK);
        }
    }

    @Override
    public CcCardCategoryWiseEligibilites getCCWiseEligibility(CcCardCategoryWiseEligibilitesPK eligible) {

        System.out.println(eligible);
        CcCardCategoryWiseEligibilites eligibility = (CcCardCategoryWiseEligibilites) getCurrentSession().get(CcCardCategoryWiseEligibilites.class, eligible);
        System.out.println(eligibility);
        return eligibility;
    }

    @Override
    public void deleteCCWiseEligibility(CcCardCategoryWiseEligibilites eligible) {
        CcCardCategoryWiseEligibilites eligibility = getCCWiseEligibility(eligible.getCcCardCategoryWiseEligibilitesPK());
        if (eligible != null) {
            getCurrentSession().delete(eligibility);
        }

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<CcCardCategoryWiseEligibilites> getCCWiseEligibilities() {
        return getCurrentSession().createQuery("from CcCardCategoryWiseEligibilites").list();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.LegalEntityBase;
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
public class LegalEntityBaseDAOImpl implements LegalEntityBaseDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addLegalEntityBase(LegalEntityBase lbase) {
        getCurrentSession().persist(lbase);
    }

    @Override
    public void updateLegalEntityBase(LegalEntityBase lbase) {
        LegalEntityBase LegalEntityToUpdate = getLegalEntityBase(lbase.getLeid());
        LegalEntityToUpdate.setLegalEntityType(lbase.getLegalEntityType());
        LegalEntityToUpdate.setProductCategoryId(lbase.getProductCategoryId());
        getCurrentSession().update(LegalEntityToUpdate);
    }

    @Override
    public LegalEntityBase getLegalEntityBase(int pid) {
        LegalEntityBase lbase = (LegalEntityBase) getCurrentSession().get(LegalEntityBase.class, pid);
        return lbase;

    }

    @Override
    public void deleteLegalEntityBase(int id) {
        LegalEntityBase lbase = getLegalEntityBase(id);
        if (lbase != null) {
            getCurrentSession().delete(lbase);
        }

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<LegalEntityBase> getLegalEntityBases() {
        return getCurrentSession().createQuery("from LegalEntityBase").list();
    }


}

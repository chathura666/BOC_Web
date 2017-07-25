/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.PicklistvaluesMaster;
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
public class PicklistvaluesMasterDAOImpl implements PicklistvaluesMasterDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addPickListValue(PicklistvaluesMaster pklist) {
        getCurrentSession().save(pklist);
    }

    @Override
    public void updatePickListValue(PicklistvaluesMaster pklist) {
        PicklistvaluesMaster pklistToUpdate = getPickListValue(pklist.getPicklistId());
        pklistToUpdate.setPicklistCode(pklist.getPicklistCode());
        pklistToUpdate.setPickValue(pklist.getPickValue());
        pklistToUpdate.setPicklistName(pklist.getPicklistName());
        pklistToUpdate.setPicklistFilter(pklist.getPicklistFilter());
        getCurrentSession().update(pklistToUpdate);
    }

    @Override
    public PicklistvaluesMaster getPickListValue(int pid) {
        PicklistvaluesMaster pklist = (PicklistvaluesMaster) getCurrentSession().get(PicklistvaluesMaster.class, pid);
        return pklist;

    }

    @Override
    public void deletePickListValue(int id) {
        PicklistvaluesMaster pklist = getPickListValue(id);
        if (pklist != null) {
            getCurrentSession().delete(pklist);
        }

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<PicklistvaluesMaster> getPickListValues() {
        return getCurrentSession().createQuery("from PicklistvaluesMaster").list();
    }

    @Override
    public List<PicklistvaluesMaster> getCreditCardBrands() {
        return getCurrentSession().createQuery("from PicklistvaluesMaster where PICKLIST_NAME = 'CREDIT CARD BRAND'").list();
    }

    @Override
    public List<PicklistvaluesMaster> getCreditCardTypes() {
        return getCurrentSession().createQuery("from PicklistvaluesMaster where PICKLIST_NAME = 'CREDIT CARD TYPE'").list();
    }

    @Override
    public List<PicklistvaluesMaster> getCreditCardSubcategories() {
        return getCurrentSession().createQuery("from PicklistvaluesMaster where PICKLIST_NAME = 'CREDIT CARD SUB CATEGORY'").list();
    }

}

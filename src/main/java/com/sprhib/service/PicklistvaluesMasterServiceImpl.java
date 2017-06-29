/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.dao.PicklistvaluesMasterDAO;
import com.sprhib.dao.Product_BaseDAO;
import com.sprhib.model.PicklistvaluesMaster;
import com.sprhib.model.ProductBase;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author it207432
 */
@Service
@Transactional
public class PicklistvaluesMasterServiceImpl implements PicklistvaluesMasterService {

    @Autowired
    private PicklistvaluesMasterDAO picklistdao;

    @Override
    public void addPickListValue(PicklistvaluesMaster pklist) {
        picklistdao.addPickListValue(pklist);
    }

    @Override
    public void updatePickListValue(PicklistvaluesMaster pklist) {
        picklistdao.updatePickListValue(pklist);
    }

    @Override
    public PicklistvaluesMaster getPickListValue(int id) {
        return picklistdao.getPickListValue(id);
    }

    @Override
    public void deletePickListValue(int id) {
        picklistdao.deletePickListValue(id);
    }

    @Override
    public List<PicklistvaluesMaster> getPickListValues() {
        return picklistdao.getPickListValues();
    }

    @Override
    public List<PicklistvaluesMaster> getCreditCardTypes() {
        return picklistdao.getCreditCardTypes();
    }

    @Override
    public List<PicklistvaluesMaster> getCreditCardSubCategory() {
        return picklistdao.getCreditCardSubCategory();
    }


}

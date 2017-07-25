/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.PicklistvaluesMaster;
import java.util.List;

/**
 *
 * @author it207432
 */
public interface PicklistvaluesMasterDAO {

    public void addPickListValue(PicklistvaluesMaster pbase);

    public void updatePickListValue(PicklistvaluesMaster pbase);

    public PicklistvaluesMaster getPickListValue(int id);

    public void deletePickListValue(int id);

    public List<PicklistvaluesMaster> getPickListValues();
    
    public List<PicklistvaluesMaster> getCreditCardBrands();
    
    public List<PicklistvaluesMaster> getCreditCardTypes();
    
    public List<PicklistvaluesMaster> getCreditCardSubcategories();

}

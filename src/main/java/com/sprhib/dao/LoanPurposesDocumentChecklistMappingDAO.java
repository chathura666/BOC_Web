/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.AreaBase;
import com.sprhib.model.LoanPurposesDocumentChecklistMapping;
import java.util.List;

/**
 *
 * @author it207432
 */
public interface LoanPurposesDocumentChecklistMappingDAO {

    public void addMapping(LoanPurposesDocumentChecklistMapping map);

    public void updateMapping(LoanPurposesDocumentChecklistMapping map);

    public LoanPurposesDocumentChecklistMapping getMapping(int id);

    public void deleteMapping(int id);

    public List<LoanPurposesDocumentChecklistMapping> getMappings();
}

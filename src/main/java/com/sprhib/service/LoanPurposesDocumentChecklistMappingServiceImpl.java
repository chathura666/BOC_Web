/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.dao.LoanPurposesDocumentChecklistMappingDAO;
import com.sprhib.model.LoanPurposesDocumentChecklistMapping;
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
public class LoanPurposesDocumentChecklistMappingServiceImpl implements LoanPurposesDocumentChecklistMappingService {

    @Autowired
    private LoanPurposesDocumentChecklistMappingDAO mapDAO;

    @Override
    public void addMapping(LoanPurposesDocumentChecklistMapping map) {
        mapDAO.addMapping(map);
    }

    @Override
    public void updateMapping(LoanPurposesDocumentChecklistMapping map) {
        mapDAO.updateMapping(map);
    }

    @Override
    public LoanPurposesDocumentChecklistMapping getMapping(int id) {
        return mapDAO.getMapping(id);
    }

    @Override
    public void deleteMapping(int id) {
        mapDAO.deleteMapping(id);
    }

    @Override
    public List<LoanPurposesDocumentChecklistMapping> getMappings() {
        return mapDAO.getMappings();
    }


}

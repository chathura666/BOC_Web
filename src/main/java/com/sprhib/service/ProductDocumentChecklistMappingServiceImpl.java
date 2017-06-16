/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.dao.ProductDocumentChecklistMappingDAO;
import com.sprhib.dao.Product_BaseDAO;
import com.sprhib.model.ProductBase;
import com.sprhib.model.ProductDocumentChecklistMapping;
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
public class ProductDocumentChecklistMappingServiceImpl implements ProductDocumentChecklistMappingService {

    @Autowired
    private ProductDocumentChecklistMappingDAO chkmapDAO;

    @Override
    public void addProductDocumentChecklistMapping(ProductDocumentChecklistMapping docmap) {
         chkmapDAO.addProductDocumentChecklistMapping(docmap);
    }

    @Override
    public void updateProductDocumentChecklistMapping(ProductDocumentChecklistMapping docmap) {
         chkmapDAO.addProductDocumentChecklistMapping(docmap);
    }

    @Override
    public ProductDocumentChecklistMapping getProductDocumentChecklistMapping(int id) {
         return chkmapDAO.getProductDocumentChecklistMapping(id);
    }

    @Override
    public void deleteProductDocumentChecklistMapping(int id) {
         chkmapDAO.deleteProductDocumentChecklistMapping(id);
    }

    @Override
    public List<ProductDocumentChecklistMapping> getProductDocumentChecklistMappings() {
         return chkmapDAO.getProductDocumentChecklistMappings();
    }

    
}

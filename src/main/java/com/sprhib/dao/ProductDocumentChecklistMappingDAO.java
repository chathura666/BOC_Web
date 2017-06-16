/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.ProductDocumentChecklistMapping;
import java.util.List;

/**
 *
 * @author it207432
 */
public interface ProductDocumentChecklistMappingDAO {

    public void addProductDocumentChecklistMapping(ProductDocumentChecklistMapping docmap);

    public void updateProductDocumentChecklistMapping(ProductDocumentChecklistMapping docmap);

    public ProductDocumentChecklistMapping getProductDocumentChecklistMapping(int id);

    public void deleteProductDocumentChecklistMapping(int id);

    public List<ProductDocumentChecklistMapping> getProductDocumentChecklistMappings();

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.ProductDocumentChecklistMapping;
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
public class ProductDocumentChecklistMappingDAOImpl implements ProductDocumentChecklistMappingDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addProductDocumentChecklistMapping(ProductDocumentChecklistMapping docmap) {
        getCurrentSession().save(docmap);
    }

    @Override
    public void updateProductDocumentChecklistMapping(ProductDocumentChecklistMapping docmap) {
        ProductDocumentChecklistMapping dtToUpdate = getProductDocumentChecklistMapping(docmap.getPdcid());
        dtToUpdate.setPdcid(docmap.getPdcid());
        getCurrentSession().update(dtToUpdate);
    }

    @Override
    public ProductDocumentChecklistMapping getProductDocumentChecklistMapping(int id) {
        ProductDocumentChecklistMapping chkmap = (ProductDocumentChecklistMapping) getCurrentSession().get(ProductDocumentChecklistMapping.class, id);
        return chkmap;
    }

    @Override
    public void deleteProductDocumentChecklistMapping(int id) {
         ProductDocumentChecklistMapping chkmap = getProductDocumentChecklistMapping(id);
        if (chkmap != null) {
            getCurrentSession().delete(chkmap);
        }
    }

    @Override
    public List<ProductDocumentChecklistMapping> getProductDocumentChecklistMappings() {
        return getCurrentSession().createQuery("from ProductDocumentChecklistMapping").list();
    }

    
}

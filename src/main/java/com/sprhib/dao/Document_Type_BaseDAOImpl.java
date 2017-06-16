/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.DocumentTypeBase;
import com.sprhib.model.ProductBase;
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
public class Document_Type_BaseDAOImpl implements Document_Type_BaseDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addDocumentTypeBase(DocumentTypeBase dtbase) {
        getCurrentSession().save(dtbase);
    }

    @Override
    public void updateDocumentTypeBase(DocumentTypeBase dtbase) {
        DocumentTypeBase dtToUpdate = getDocumentTypeBase(dtbase.getDid());
        dtToUpdate.setDid(dtbase.getDid());
        getCurrentSession().update(dtToUpdate);
    }

    @Override
    public DocumentTypeBase getDocumentTypeBase(int id) {
        DocumentTypeBase pcbase = (DocumentTypeBase) getCurrentSession().get(DocumentTypeBase.class, id);
        return pcbase;
    }

    @Override
    public void deleteDocumentTypeBase(int id) {
        DocumentTypeBase dtbase = getDocumentTypeBase(id);
        if (dtbase != null) {
            getCurrentSession().delete(dtbase);
        }
    }

    @Override
    public List<DocumentTypeBase> getDocumentTypeBases() {
        return getCurrentSession().createQuery("from DocumentTypeBase").list();
    }

}

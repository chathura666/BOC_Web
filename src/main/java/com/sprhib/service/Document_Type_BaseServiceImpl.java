/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.dao.Document_Type_BaseDAO;
import com.sprhib.model.DocumentTypeBase;
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
public class Document_Type_BaseServiceImpl implements Document_Type_BaseService {

    @Autowired
    private Document_Type_BaseDAO DTBaseDao;

    @Override
    public void addDocumentTypeBase(DocumentTypeBase dtbase) {
        DTBaseDao.addDocumentTypeBase(dtbase);
    }

    @Override
    public void updateDocumentTypeBase(DocumentTypeBase dtbase) {
        DTBaseDao.updateDocumentTypeBase(dtbase);
    }

    @Override
    public DocumentTypeBase getDocumentTypeBase(int id) {
       return DTBaseDao.getDocumentTypeBase(id);
    }

    @Override
    public void deleteDocumentTypeBase(int id) {
       DTBaseDao.deleteDocumentTypeBase(id);
    }

    @Override
    public List<DocumentTypeBase> getDocumentTypeBases() {
       return DTBaseDao.getDocumentTypeBases();
    }

   
     
    
}

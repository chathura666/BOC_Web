/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.model.DocumentTypeBase;
import java.util.List;

/**
 *
 * @author it207432
 */
public interface Document_Type_BaseService {

    public void addDocumentTypeBase(DocumentTypeBase dtbase);

    public void updateDocumentTypeBase(DocumentTypeBase dtbase);

    public DocumentTypeBase getDocumentTypeBase(int id);

    public void deleteDocumentTypeBase(int id);

    public List<DocumentTypeBase> getDocumentTypeBases();

}

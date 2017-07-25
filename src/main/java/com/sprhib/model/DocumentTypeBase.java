/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author it207432
 */
@Entity
@Table(name = "DOCUMENT_TYPE_BASE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentTypeBase.findAll", query = "SELECT d FROM DocumentTypeBase d"),
    @NamedQuery(name = "DocumentTypeBase.findByDid", query = "SELECT d FROM DocumentTypeBase d WHERE d.did = :did"),
    @NamedQuery(name = "DocumentTypeBase.findByDocumentType", query = "SELECT d FROM DocumentTypeBase d WHERE d.documentType = :documentType")})
public class DocumentTypeBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DID")
    private Integer did;
    @Basic(optional = false)
    @Column(name = "DOCUMENT_TYPE")
    private String documentType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "documentId")
    private Collection<ProductDocumentChecklistMapping> productDocumentChecklistMappingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "documentId")
    private Collection<LoanPurposesDocumentChecklistMapping> loanPurposesDocumentChecklistMappingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "documentId")
    private Collection<SecurityTypeDocumentChecklistMapping> securityTypeDocumentChecklistMappingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "documentId")
    private Collection<LegalEntityDocumentChecklistMapping> legalEntityDocumentChecklistMappingCollection;

    public DocumentTypeBase() {
    }

    public DocumentTypeBase(Integer did) {
        this.did = did;
    }

    public DocumentTypeBase(Integer did, String documentType) {
        this.did = did;
        this.documentType = documentType;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    @XmlTransient
    public Collection<ProductDocumentChecklistMapping> getProductDocumentChecklistMappingCollection() {
        return productDocumentChecklistMappingCollection;
    }

    public void setProductDocumentChecklistMappingCollection(Collection<ProductDocumentChecklistMapping> productDocumentChecklistMappingCollection) {
        this.productDocumentChecklistMappingCollection = productDocumentChecklistMappingCollection;
    }

    @XmlTransient
    public Collection<LoanPurposesDocumentChecklistMapping> getLoanPurposesDocumentChecklistMappingCollection() {
        return loanPurposesDocumentChecklistMappingCollection;
    }

    public void setLoanPurposesDocumentChecklistMappingCollection(Collection<LoanPurposesDocumentChecklistMapping> loanPurposesDocumentChecklistMappingCollection) {
        this.loanPurposesDocumentChecklistMappingCollection = loanPurposesDocumentChecklistMappingCollection;
    }

    @XmlTransient
    public Collection<SecurityTypeDocumentChecklistMapping> getSecurityTypeDocumentChecklistMappingCollection() {
        return securityTypeDocumentChecklistMappingCollection;
    }

    public void setSecurityTypeDocumentChecklistMappingCollection(Collection<SecurityTypeDocumentChecklistMapping> securityTypeDocumentChecklistMappingCollection) {
        this.securityTypeDocumentChecklistMappingCollection = securityTypeDocumentChecklistMappingCollection;
    }

    @XmlTransient
    public Collection<LegalEntityDocumentChecklistMapping> getLegalEntityDocumentChecklistMappingCollection() {
        return legalEntityDocumentChecklistMappingCollection;
    }

    public void setLegalEntityDocumentChecklistMappingCollection(Collection<LegalEntityDocumentChecklistMapping> legalEntityDocumentChecklistMappingCollection) {
        this.legalEntityDocumentChecklistMappingCollection = legalEntityDocumentChecklistMappingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (did != null ? did.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentTypeBase)) {
            return false;
        }
        DocumentTypeBase other = (DocumentTypeBase) object;
        if ((this.did == null && other.did != null) || (this.did != null && !this.did.equals(other.did))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.DocumentTypeBase[ did=" + did + " ]";
    }
    
}

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
@Table(name = "CAS_PRODUCT_DOCUMENT_TYPE_BASE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CasProductDocumentTypeBase.findAll", query = "SELECT c FROM CasProductDocumentTypeBase c"),
    @NamedQuery(name = "CasProductDocumentTypeBase.findByDid", query = "SELECT c FROM CasProductDocumentTypeBase c WHERE c.did = :did"),
    @NamedQuery(name = "CasProductDocumentTypeBase.findByDocumentType", query = "SELECT c FROM CasProductDocumentTypeBase c WHERE c.documentType = :documentType")})
public class CasProductDocumentTypeBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DID")
    private Integer did;
    @Basic(optional = false)
    @Column(name = "DOCUMENT_TYPE")
    private String documentType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "documentId")
    private Collection<CasProductDocumentChecklistMapping> casProductDocumentChecklistMappingCollection;

    public CasProductDocumentTypeBase() {
    }

    public CasProductDocumentTypeBase(Integer did) {
        this.did = did;
    }

    public CasProductDocumentTypeBase(Integer did, String documentType) {
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
    public Collection<CasProductDocumentChecklistMapping> getCasProductDocumentChecklistMappingCollection() {
        return casProductDocumentChecklistMappingCollection;
    }

    public void setCasProductDocumentChecklistMappingCollection(Collection<CasProductDocumentChecklistMapping> casProductDocumentChecklistMappingCollection) {
        this.casProductDocumentChecklistMappingCollection = casProductDocumentChecklistMappingCollection;
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
        if (!(object instanceof CasProductDocumentTypeBase)) {
            return false;
        }
        CasProductDocumentTypeBase other = (CasProductDocumentTypeBase) object;
        if ((this.did == null && other.did != null) || (this.did != null && !this.did.equals(other.did))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.CasProductDocumentTypeBase[ did=" + did + " ]";
    }
    
}

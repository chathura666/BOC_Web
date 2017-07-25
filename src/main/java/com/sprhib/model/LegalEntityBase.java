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
@Table(name = "LEGAL_ENTITY_BASE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LegalEntityBase.findAll", query = "SELECT l FROM LegalEntityBase l"),
    @NamedQuery(name = "LegalEntityBase.findByLeid", query = "SELECT l FROM LegalEntityBase l WHERE l.leid = :leid"),
    @NamedQuery(name = "LegalEntityBase.findByLegalEntityType", query = "SELECT l FROM LegalEntityBase l WHERE l.legalEntityType = :legalEntityType"),
    @NamedQuery(name = "LegalEntityBase.findByProductCategoryId", query = "SELECT l FROM LegalEntityBase l WHERE l.productCategoryId = :productCategoryId")})
public class LegalEntityBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LEID")
    private Integer leid;
    @Basic(optional = false)
    @Column(name = "LEGAL_ENTITY_TYPE")
    private String legalEntityType;
    @Column(name = "PRODUCT_CATEGORY_ID")
    private Short productCategoryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leid")
    private Collection<LegalEntityDocumentChecklistMapping> legalEntityDocumentChecklistMappingCollection;

    public LegalEntityBase() {
    }

    public LegalEntityBase(Integer leid) {
        this.leid = leid;
    }

    public LegalEntityBase(Integer leid, String legalEntityType) {
        this.leid = leid;
        this.legalEntityType = legalEntityType;
    }

    public Integer getLeid() {
        return leid;
    }

    public void setLeid(Integer leid) {
        this.leid = leid;
    }

    public String getLegalEntityType() {
        return legalEntityType;
    }

    public void setLegalEntityType(String legalEntityType) {
        this.legalEntityType = legalEntityType;
    }

    public Short getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Short productCategoryId) {
        this.productCategoryId = productCategoryId;
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
        hash += (leid != null ? leid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LegalEntityBase)) {
            return false;
        }
        LegalEntityBase other = (LegalEntityBase) object;
        if ((this.leid == null && other.leid != null) || (this.leid != null && !this.leid.equals(other.leid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.LegalEntityBase[ leid=" + leid + " ]";
    }
    
}

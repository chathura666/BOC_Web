/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author it207432
 */
@Entity
@Table(name = "CAS_PRODUCT_DOCUMENT_CHECKLIST_MAPPING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CasProductDocumentChecklistMapping.findAll", query = "SELECT c FROM CasProductDocumentChecklistMapping c"),
    @NamedQuery(name = "CasProductDocumentChecklistMapping.findByDdcid", query = "SELECT c FROM CasProductDocumentChecklistMapping c WHERE c.ddcid = :ddcid"),
    @NamedQuery(name = "CasProductDocumentChecklistMapping.findByMandatory", query = "SELECT c FROM CasProductDocumentChecklistMapping c WHERE c.mandatory = :mandatory")})
public class CasProductDocumentChecklistMapping implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DDCID")
    private Integer ddcid;
    @Basic(optional = false)
    @Column(name = "MANDATORY")
    private String mandatory;
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "CPT_ID")
    @ManyToOne(optional = false)
    private CasProductTypeBase productId;
    @JoinColumn(name = "DOCUMENT_ID", referencedColumnName = "DID")
    @ManyToOne(optional = false)
    private CasProductDocumentTypeBase documentId;

    public CasProductDocumentChecklistMapping() {
    }

    public CasProductDocumentChecklistMapping(Integer ddcid) {
        this.ddcid = ddcid;
    }

    public CasProductDocumentChecklistMapping(Integer ddcid, String mandatory) {
        this.ddcid = ddcid;
        this.mandatory = mandatory;
    }

    public Integer getDdcid() {
        return ddcid;
    }

    public void setDdcid(Integer ddcid) {
        this.ddcid = ddcid;
    }

    public String getMandatory() {
        return mandatory;
    }

    public void setMandatory(String mandatory) {
        this.mandatory = mandatory;
    }

    public CasProductTypeBase getProductId() {
        return productId;
    }

    public void setProductId(CasProductTypeBase productId) {
        this.productId = productId;
    }

    public CasProductDocumentTypeBase getDocumentId() {
        return documentId;
    }

    public void setDocumentId(CasProductDocumentTypeBase documentId) {
        this.documentId = documentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ddcid != null ? ddcid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CasProductDocumentChecklistMapping)) {
            return false;
        }
        CasProductDocumentChecklistMapping other = (CasProductDocumentChecklistMapping) object;
        if ((this.ddcid == null && other.ddcid != null) || (this.ddcid != null && !this.ddcid.equals(other.ddcid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.CasProductDocumentChecklistMapping[ ddcid=" + ddcid + " ]";
    }
    
}

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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "SECURITY_TYPE_DOCUMENT_CHECKLIST_MAPPING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SecurityTypeDocumentChecklistMapping.findAll", query = "SELECT s FROM SecurityTypeDocumentChecklistMapping s"),
    @NamedQuery(name = "SecurityTypeDocumentChecklistMapping.findBySdcid", query = "SELECT s FROM SecurityTypeDocumentChecklistMapping s WHERE s.sdcid = :sdcid"),
    @NamedQuery(name = "SecurityTypeDocumentChecklistMapping.findByScanRequired", query = "SELECT s FROM SecurityTypeDocumentChecklistMapping s WHERE s.scanRequired = :scanRequired"),
    @NamedQuery(name = "SecurityTypeDocumentChecklistMapping.findByMandatory", query = "SELECT s FROM SecurityTypeDocumentChecklistMapping s WHERE s.mandatory = :mandatory")})
public class SecurityTypeDocumentChecklistMapping implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SDCID")
    private Integer sdcid;
    @Basic(optional = false)
    @Column(name = "SCAN_REQUIRED")
    private Character scanRequired;
    @Column(name = "MANDATORY")
    private Character mandatory;
    @JoinColumn(name = "SECURITY_TYPE_ID", referencedColumnName = "SECURITY_TYPE_ID")
    @ManyToOne(optional = false)
    private SecurityTypeBase securityTypeId;
    @JoinColumn(name = "DOCUMENT_ID", referencedColumnName = "DID")
    @ManyToOne(optional = false)
    private DocumentTypeBase documentId;

    public SecurityTypeDocumentChecklistMapping() {
    }

    public SecurityTypeDocumentChecklistMapping(Integer sdcid) {
        this.sdcid = sdcid;
    }

    public SecurityTypeDocumentChecklistMapping(Integer sdcid, Character scanRequired) {
        this.sdcid = sdcid;
        this.scanRequired = scanRequired;
    }

    public Integer getSdcid() {
        return sdcid;
    }

    public void setSdcid(Integer sdcid) {
        this.sdcid = sdcid;
    }

    public Character getScanRequired() {
        return scanRequired;
    }

    public void setScanRequired(Character scanRequired) {
        this.scanRequired = scanRequired;
    }

    public Character getMandatory() {
        return mandatory;
    }

    public void setMandatory(Character mandatory) {
        this.mandatory = mandatory;
    }

    public SecurityTypeBase getSecurityTypeId() {
        return securityTypeId;
    }

    public void setSecurityTypeId(SecurityTypeBase securityTypeId) {
        this.securityTypeId = securityTypeId;
    }

    public DocumentTypeBase getDocumentId() {
        return documentId;
    }

    public void setDocumentId(DocumentTypeBase documentId) {
        this.documentId = documentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sdcid != null ? sdcid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SecurityTypeDocumentChecklistMapping)) {
            return false;
        }
        SecurityTypeDocumentChecklistMapping other = (SecurityTypeDocumentChecklistMapping) object;
        if ((this.sdcid == null && other.sdcid != null) || (this.sdcid != null && !this.sdcid.equals(other.sdcid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.SecurityTypeDocumentChecklistMapping[ sdcid=" + sdcid + " ]";
    }
    
}

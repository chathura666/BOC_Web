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
@Table(name = "LEGAL_ENTITY_DOCUMENT_CHECKLIST_MAPPING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LegalEntityDocumentChecklistMapping.findAll", query = "SELECT l FROM LegalEntityDocumentChecklistMapping l"),
    @NamedQuery(name = "LegalEntityDocumentChecklistMapping.findByLedcmid", query = "SELECT l FROM LegalEntityDocumentChecklistMapping l WHERE l.ledcmid = :ledcmid"),
    @NamedQuery(name = "LegalEntityDocumentChecklistMapping.findByScanRequired", query = "SELECT l FROM LegalEntityDocumentChecklistMapping l WHERE l.scanRequired = :scanRequired"),
    @NamedQuery(name = "LegalEntityDocumentChecklistMapping.findByMandatory", query = "SELECT l FROM LegalEntityDocumentChecklistMapping l WHERE l.mandatory = :mandatory")})
public class LegalEntityDocumentChecklistMapping implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LEDCMID")
    private Integer ledcmid;
    @Basic(optional = false)
    @Column(name = "SCAN_REQUIRED")
    private Character scanRequired;
    @Column(name = "MANDATORY")
    private Character mandatory;
    @JoinColumn(name = "LEID", referencedColumnName = "LEID")
    @ManyToOne(optional = false)
    private LegalEntityBase leid;
    @JoinColumn(name = "DOCUMENT_ID", referencedColumnName = "DID")
    @ManyToOne(optional = false)
    private DocumentTypeBase documentId;

    public LegalEntityDocumentChecklistMapping() {
    }

    public LegalEntityDocumentChecklistMapping(Integer ledcmid) {
        this.ledcmid = ledcmid;
    }

    public LegalEntityDocumentChecklistMapping(Integer ledcmid, Character scanRequired) {
        this.ledcmid = ledcmid;
        this.scanRequired = scanRequired;
    }

    public Integer getLedcmid() {
        return ledcmid;
    }

    public void setLedcmid(Integer ledcmid) {
        this.ledcmid = ledcmid;
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

    public LegalEntityBase getLeid() {
        return leid;
    }

    public void setLeid(LegalEntityBase leid) {
        this.leid = leid;
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
        hash += (ledcmid != null ? ledcmid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LegalEntityDocumentChecklistMapping)) {
            return false;
        }
        LegalEntityDocumentChecklistMapping other = (LegalEntityDocumentChecklistMapping) object;
        if ((this.ledcmid == null && other.ledcmid != null) || (this.ledcmid != null && !this.ledcmid.equals(other.ledcmid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.LegalEntityDocumentChecklistMapping[ ledcmid=" + ledcmid + " ]";
    }
    
}

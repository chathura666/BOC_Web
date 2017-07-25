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
@Table(name = "LOAN_PURPOSES_DOCUMENT_CHECKLIST_MAPPING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoanPurposesDocumentChecklistMapping.findAll", query = "SELECT l FROM LoanPurposesDocumentChecklistMapping l"),
    @NamedQuery(name = "LoanPurposesDocumentChecklistMapping.findByPrpid", query = "SELECT l FROM LoanPurposesDocumentChecklistMapping l WHERE l.prpid = :prpid"),
    @NamedQuery(name = "LoanPurposesDocumentChecklistMapping.findByScanRequired", query = "SELECT l FROM LoanPurposesDocumentChecklistMapping l WHERE l.scanRequired = :scanRequired"),
    @NamedQuery(name = "LoanPurposesDocumentChecklistMapping.findByMandatory", query = "SELECT l FROM LoanPurposesDocumentChecklistMapping l WHERE l.mandatory = :mandatory")})
public class LoanPurposesDocumentChecklistMapping implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PRPID")
    private Integer prpid;
    @Basic(optional = false)
    @Column(name = "SCAN_REQUIRED")
    private Character scanRequired;
    @Column(name = "MANDATORY")
    private Character mandatory;
    @JoinColumn(name = "PURPOSE_ID", referencedColumnName = "PID")
    @ManyToOne(optional = false)
    private LoanPurposes purposeId;
    @JoinColumn(name = "DOCUMENT_ID", referencedColumnName = "DID")
    @ManyToOne(optional = false)
    private DocumentTypeBase documentId;

    public LoanPurposesDocumentChecklistMapping() {
    }

    public LoanPurposesDocumentChecklistMapping(Integer prpid) {
        this.prpid = prpid;
    }

    public LoanPurposesDocumentChecklistMapping(Integer prpid, Character scanRequired) {
        this.prpid = prpid;
        this.scanRequired = scanRequired;
    }

    public Integer getPrpid() {
        return prpid;
    }

    public void setPrpid(Integer prpid) {
        this.prpid = prpid;
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

    public LoanPurposes getPurposeId() {
        return purposeId;
    }

    public void setPurposeId(LoanPurposes purposeId) {
        this.purposeId = purposeId;
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
        hash += (prpid != null ? prpid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoanPurposesDocumentChecklistMapping)) {
            return false;
        }
        LoanPurposesDocumentChecklistMapping other = (LoanPurposesDocumentChecklistMapping) object;
        if ((this.prpid == null && other.prpid != null) || (this.prpid != null && !this.prpid.equals(other.prpid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.LoanPurposesDocumentChecklistMapping[ prpid=" + prpid + " ]";
    }
    
}

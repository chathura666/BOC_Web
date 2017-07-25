/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author it207432
 */
@Entity
@Table(name = "CAS_SEQUENCE_NUMBER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CasSequenceNumber.findAll", query = "SELECT c FROM CasSequenceNumber c"),
    @NamedQuery(name = "CasSequenceNumber.findBySequenceNo", query = "SELECT c FROM CasSequenceNumber c WHERE c.casSequenceNumberPK.sequenceNo = :sequenceNo"),
    @NamedQuery(name = "CasSequenceNumber.findByCurrentYear", query = "SELECT c FROM CasSequenceNumber c WHERE c.currentYear = :currentYear"),
    @NamedQuery(name = "CasSequenceNumber.findByBranchCode", query = "SELECT c FROM CasSequenceNumber c WHERE c.casSequenceNumberPK.branchCode = :branchCode")})
public class CasSequenceNumber implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CasSequenceNumberPK casSequenceNumberPK;
    @Basic(optional = false)
    @Column(name = "CURRENT_YEAR")
    private int currentYear;

    public CasSequenceNumber() {
    }

    public CasSequenceNumber(CasSequenceNumberPK casSequenceNumberPK) {
        this.casSequenceNumberPK = casSequenceNumberPK;
    }

    public CasSequenceNumber(CasSequenceNumberPK casSequenceNumberPK, int currentYear) {
        this.casSequenceNumberPK = casSequenceNumberPK;
        this.currentYear = currentYear;
    }

    public CasSequenceNumber(int sequenceNo, String branchCode) {
        this.casSequenceNumberPK = new CasSequenceNumberPK(sequenceNo, branchCode);
    }

    public CasSequenceNumberPK getCasSequenceNumberPK() {
        return casSequenceNumberPK;
    }

    public void setCasSequenceNumberPK(CasSequenceNumberPK casSequenceNumberPK) {
        this.casSequenceNumberPK = casSequenceNumberPK;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (casSequenceNumberPK != null ? casSequenceNumberPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CasSequenceNumber)) {
            return false;
        }
        CasSequenceNumber other = (CasSequenceNumber) object;
        if ((this.casSequenceNumberPK == null && other.casSequenceNumberPK != null) || (this.casSequenceNumberPK != null && !this.casSequenceNumberPK.equals(other.casSequenceNumberPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.CasSequenceNumber[ casSequenceNumberPK=" + casSequenceNumberPK + " ]";
    }
    
}

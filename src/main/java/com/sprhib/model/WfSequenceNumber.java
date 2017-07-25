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
@Table(name = "WF_SEQUENCE_NUMBER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WfSequenceNumber.findAll", query = "SELECT w FROM WfSequenceNumber w"),
    @NamedQuery(name = "WfSequenceNumber.findBySequenceNo", query = "SELECT w FROM WfSequenceNumber w WHERE w.wfSequenceNumberPK.sequenceNo = :sequenceNo"),
    @NamedQuery(name = "WfSequenceNumber.findByCurrentYear", query = "SELECT w FROM WfSequenceNumber w WHERE w.currentYear = :currentYear"),
    @NamedQuery(name = "WfSequenceNumber.findByProductCode", query = "SELECT w FROM WfSequenceNumber w WHERE w.wfSequenceNumberPK.productCode = :productCode")})
public class WfSequenceNumber implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WfSequenceNumberPK wfSequenceNumberPK;
    @Basic(optional = false)
    @Column(name = "CURRENT_YEAR")
    private int currentYear;

    public WfSequenceNumber() {
    }

    public WfSequenceNumber(WfSequenceNumberPK wfSequenceNumberPK) {
        this.wfSequenceNumberPK = wfSequenceNumberPK;
    }

    public WfSequenceNumber(WfSequenceNumberPK wfSequenceNumberPK, int currentYear) {
        this.wfSequenceNumberPK = wfSequenceNumberPK;
        this.currentYear = currentYear;
    }

    public WfSequenceNumber(int sequenceNo, String productCode) {
        this.wfSequenceNumberPK = new WfSequenceNumberPK(sequenceNo, productCode);
    }

    public WfSequenceNumberPK getWfSequenceNumberPK() {
        return wfSequenceNumberPK;
    }

    public void setWfSequenceNumberPK(WfSequenceNumberPK wfSequenceNumberPK) {
        this.wfSequenceNumberPK = wfSequenceNumberPK;
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
        hash += (wfSequenceNumberPK != null ? wfSequenceNumberPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WfSequenceNumber)) {
            return false;
        }
        WfSequenceNumber other = (WfSequenceNumber) object;
        if ((this.wfSequenceNumberPK == null && other.wfSequenceNumberPK != null) || (this.wfSequenceNumberPK != null && !this.wfSequenceNumberPK.equals(other.wfSequenceNumberPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.WfSequenceNumber[ wfSequenceNumberPK=" + wfSequenceNumberPK + " ]";
    }
    
}

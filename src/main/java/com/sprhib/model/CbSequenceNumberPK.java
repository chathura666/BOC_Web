/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author it207432
 */
@Embeddable
public class CbSequenceNumberPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "SEQUENCE_NO")
    private int sequenceNo;
    @Basic(optional = false)
    @Column(name = "CURRENT_YEAR")
    private int currentYear;

    public CbSequenceNumberPK() {
    }

    public CbSequenceNumberPK(int sequenceNo, int currentYear) {
        this.sequenceNo = sequenceNo;
        this.currentYear = currentYear;
    }

    public int getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(int sequenceNo) {
        this.sequenceNo = sequenceNo;
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
        hash += (int) sequenceNo;
        hash += (int) currentYear;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CbSequenceNumberPK)) {
            return false;
        }
        CbSequenceNumberPK other = (CbSequenceNumberPK) object;
        if (this.sequenceNo != other.sequenceNo) {
            return false;
        }
        if (this.currentYear != other.currentYear) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.CbSequenceNumberPK[ sequenceNo=" + sequenceNo + ", currentYear=" + currentYear + " ]";
    }
    
}

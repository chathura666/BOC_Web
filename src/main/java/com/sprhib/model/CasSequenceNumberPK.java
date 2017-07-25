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
public class CasSequenceNumberPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "SEQUENCE_NO")
    private int sequenceNo;
    @Basic(optional = false)
    @Column(name = "BRANCH_CODE")
    private String branchCode;

    public CasSequenceNumberPK() {
    }

    public CasSequenceNumberPK(int sequenceNo, String branchCode) {
        this.sequenceNo = sequenceNo;
        this.branchCode = branchCode;
    }

    public int getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(int sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) sequenceNo;
        hash += (branchCode != null ? branchCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CasSequenceNumberPK)) {
            return false;
        }
        CasSequenceNumberPK other = (CasSequenceNumberPK) object;
        if (this.sequenceNo != other.sequenceNo) {
            return false;
        }
        if ((this.branchCode == null && other.branchCode != null) || (this.branchCode != null && !this.branchCode.equals(other.branchCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.CasSequenceNumberPK[ sequenceNo=" + sequenceNo + ", branchCode=" + branchCode + " ]";
    }
    
}

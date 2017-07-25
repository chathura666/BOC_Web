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
public class WfSequenceNumberPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "SEQUENCE_NO")
    private int sequenceNo;
    @Basic(optional = false)
    @Column(name = "PRODUCT_CODE")
    private String productCode;

    public WfSequenceNumberPK() {
    }

    public WfSequenceNumberPK(int sequenceNo, String productCode) {
        this.sequenceNo = sequenceNo;
        this.productCode = productCode;
    }

    public int getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(int sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) sequenceNo;
        hash += (productCode != null ? productCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WfSequenceNumberPK)) {
            return false;
        }
        WfSequenceNumberPK other = (WfSequenceNumberPK) object;
        if (this.sequenceNo != other.sequenceNo) {
            return false;
        }
        if ((this.productCode == null && other.productCode != null) || (this.productCode != null && !this.productCode.equals(other.productCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.WfSequenceNumberPK[ sequenceNo=" + sequenceNo + ", productCode=" + productCode + " ]";
    }
    
}

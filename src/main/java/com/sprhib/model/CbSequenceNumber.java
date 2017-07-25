/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.model;

import java.io.Serializable;
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
@Table(name = "CB_SEQUENCE_NUMBER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CbSequenceNumber.findAll", query = "SELECT c FROM CbSequenceNumber c"),
    @NamedQuery(name = "CbSequenceNumber.findBySequenceNo", query = "SELECT c FROM CbSequenceNumber c WHERE c.cbSequenceNumberPK.sequenceNo = :sequenceNo"),
    @NamedQuery(name = "CbSequenceNumber.findByCurrentYear", query = "SELECT c FROM CbSequenceNumber c WHERE c.cbSequenceNumberPK.currentYear = :currentYear")})
public class CbSequenceNumber implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CbSequenceNumberPK cbSequenceNumberPK;

    public CbSequenceNumber() {
    }

    public CbSequenceNumber(CbSequenceNumberPK cbSequenceNumberPK) {
        this.cbSequenceNumberPK = cbSequenceNumberPK;
    }

    public CbSequenceNumber(int sequenceNo, int currentYear) {
        this.cbSequenceNumberPK = new CbSequenceNumberPK(sequenceNo, currentYear);
    }

    public CbSequenceNumberPK getCbSequenceNumberPK() {
        return cbSequenceNumberPK;
    }

    public void setCbSequenceNumberPK(CbSequenceNumberPK cbSequenceNumberPK) {
        this.cbSequenceNumberPK = cbSequenceNumberPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cbSequenceNumberPK != null ? cbSequenceNumberPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CbSequenceNumber)) {
            return false;
        }
        CbSequenceNumber other = (CbSequenceNumber) object;
        if ((this.cbSequenceNumberPK == null && other.cbSequenceNumberPK != null) || (this.cbSequenceNumberPK != null && !this.cbSequenceNumberPK.equals(other.cbSequenceNumberPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.CbSequenceNumber[ cbSequenceNumberPK=" + cbSequenceNumberPK + " ]";
    }
    
}

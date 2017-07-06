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
@Table(name = "LOAN_PRODUCT_INDEX_ID_MAPPING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoanProductIndexIdMapping.findAll", query = "SELECT l FROM LoanProductIndexIdMapping l"),
    @NamedQuery(name = "LoanProductIndexIdMapping.findByProdIndexId", query = "SELECT l FROM LoanProductIndexIdMapping l WHERE l.prodIndexId = :prodIndexId")})
public class LoanProductIndexIdMapping implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PROD_INDEX_ID")
    private Integer prodIndexId;
    @JoinColumn(name = "PID", referencedColumnName = "PID")
    @ManyToOne(optional = false)
    private ProductBase pid;
    @JoinColumn(name = "IDX_ID", referencedColumnName = "IDX_ID")
    @ManyToOne(optional = false)
    private IndexIdBase idxId;

    public LoanProductIndexIdMapping() {
    }

    public LoanProductIndexIdMapping(Integer prodIndexId) {
        this.prodIndexId = prodIndexId;
    }

    public Integer getProdIndexId() {
        return prodIndexId;
    }

    public void setProdIndexId(Integer prodIndexId) {
        this.prodIndexId = prodIndexId;
    }

    public ProductBase getPid() {
        return pid;
    }

    public void setPid(ProductBase pid) {
        this.pid = pid;
    }

    public IndexIdBase getIdxId() {
        return idxId;
    }

    public void setIdxId(IndexIdBase idxId) {
        this.idxId = idxId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prodIndexId != null ? prodIndexId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoanProductIndexIdMapping)) {
            return false;
        }
        LoanProductIndexIdMapping other = (LoanProductIndexIdMapping) object;
        if ((this.prodIndexId == null && other.prodIndexId != null) || (this.prodIndexId != null && !this.prodIndexId.equals(other.prodIndexId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.LoanProductIndexIdMapping[ prodIndexId=" + prodIndexId + " ]";
    }
    
}

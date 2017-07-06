/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author it207432
 */
@Entity
@Table(name = "INDEX_ID_BASE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IndexIdBase.findAll", query = "SELECT i FROM IndexIdBase i"),
    @NamedQuery(name = "IndexIdBase.findByIdxId", query = "SELECT i FROM IndexIdBase i WHERE i.idxId = :idxId"),
    @NamedQuery(name = "IndexIdBase.findByIndexRate", query = "SELECT i FROM IndexIdBase i WHERE i.indexRate = :indexRate"),
    @NamedQuery(name = "IndexIdBase.findByDescription", query = "SELECT i FROM IndexIdBase i WHERE i.description = :description")})
public class IndexIdBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDX_ID")
    private Integer idxId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "INDEX_RATE")
    private BigDecimal indexRate;
    @Basic(optional = false)
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idxId")
    private Collection<LoanProductIndexIdMapping> loanProductIndexIdMappingCollection;

    public IndexIdBase() {
    }

    public IndexIdBase(Integer idxId) {
        this.idxId = idxId;
    }

    public IndexIdBase(Integer idxId, BigDecimal indexRate, String description) {
        this.idxId = idxId;
        this.indexRate = indexRate;
        this.description = description;
    }

    public Integer getIdxId() {
        return idxId;
    }

    public void setIdxId(Integer idxId) {
        this.idxId = idxId;
    }

    public BigDecimal getIndexRate() {
        return indexRate;
    }

    public void setIndexRate(BigDecimal indexRate) {
        this.indexRate = indexRate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<LoanProductIndexIdMapping> getLoanProductIndexIdMappingCollection() {
        return loanProductIndexIdMappingCollection;
    }

    public void setLoanProductIndexIdMappingCollection(Collection<LoanProductIndexIdMapping> loanProductIndexIdMappingCollection) {
        this.loanProductIndexIdMappingCollection = loanProductIndexIdMappingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idxId != null ? idxId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IndexIdBase)) {
            return false;
        }
        IndexIdBase other = (IndexIdBase) object;
        if ((this.idxId == null && other.idxId != null) || (this.idxId != null && !this.idxId.equals(other.idxId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.IndexIdBase[ idxId=" + idxId + " ]";
    }
    
}

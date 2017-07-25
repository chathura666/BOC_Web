/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "RLC_BASE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RlcBase.findAll", query = "SELECT r FROM RlcBase r"),
    @NamedQuery(name = "RlcBase.findByRlcId", query = "SELECT r FROM RlcBase r WHERE r.rlcId = :rlcId"),
    @NamedQuery(name = "RlcBase.findByRlcCode", query = "SELECT r FROM RlcBase r WHERE r.rlcCode = :rlcCode"),
    @NamedQuery(name = "RlcBase.findByRlcName", query = "SELECT r FROM RlcBase r WHERE r.rlcName = :rlcName")})
public class RlcBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RLC_ID")
    private Integer rlcId;
    @Basic(optional = false)
    @Column(name = "RLC_CODE")
    private String rlcCode;
    @Basic(optional = false)
    @Column(name = "RLC_NAME")
    private String rlcName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rlcId")
    private Collection<RlcBranchMapping> rlcBranchMappingCollection;

    public RlcBase() {
    }

    public RlcBase(Integer rlcId) {
        this.rlcId = rlcId;
    }

    public RlcBase(Integer rlcId, String rlcCode, String rlcName) {
        this.rlcId = rlcId;
        this.rlcCode = rlcCode;
        this.rlcName = rlcName;
    }

    public Integer getRlcId() {
        return rlcId;
    }

    public void setRlcId(Integer rlcId) {
        this.rlcId = rlcId;
    }

    public String getRlcCode() {
        return rlcCode;
    }

    public void setRlcCode(String rlcCode) {
        this.rlcCode = rlcCode;
    }

    public String getRlcName() {
        return rlcName;
    }

    public void setRlcName(String rlcName) {
        this.rlcName = rlcName;
    }

    @XmlTransient
    public Collection<RlcBranchMapping> getRlcBranchMappingCollection() {
        return rlcBranchMappingCollection;
    }

    public void setRlcBranchMappingCollection(Collection<RlcBranchMapping> rlcBranchMappingCollection) {
        this.rlcBranchMappingCollection = rlcBranchMappingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rlcId != null ? rlcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RlcBase)) {
            return false;
        }
        RlcBase other = (RlcBase) object;
        if ((this.rlcId == null && other.rlcId != null) || (this.rlcId != null && !this.rlcId.equals(other.rlcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.RlcBase[ rlcId=" + rlcId + " ]";
    }
    
}

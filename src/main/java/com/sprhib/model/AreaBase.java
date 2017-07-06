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
@Table(name = "AREA_BASE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AreaBase.findAll", query = "SELECT a FROM AreaBase a"),
    @NamedQuery(name = "AreaBase.findByAid", query = "SELECT a FROM AreaBase a WHERE a.aid = :aid"),
    @NamedQuery(name = "AreaBase.findByAreaCode", query = "SELECT a FROM AreaBase a WHERE a.areaCode = :areaCode"),
    @NamedQuery(name = "AreaBase.findByAreaName", query = "SELECT a FROM AreaBase a WHERE a.areaName = :areaName")})
public class AreaBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "AID")
    private Integer aid;
    @Basic(optional = false)
    @Column(name = "AREA_CODE")
    private String areaCode;
    @Basic(optional = false)
    @Column(name = "AREA_NAME")
    private String areaName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aid")
    private Collection<AreaBranchMapping> areaBranchMappingCollection;

    public AreaBase() {
    }

    public AreaBase(Integer aid) {
        this.aid = aid;
    }

    public AreaBase(Integer aid, String areaCode, String areaName) {
        this.aid = aid;
        this.areaCode = areaCode;
        this.areaName = areaName;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @XmlTransient
    public Collection<AreaBranchMapping> getAreaBranchMappingCollection() {
        return areaBranchMappingCollection;
    }

    public void setAreaBranchMappingCollection(Collection<AreaBranchMapping> areaBranchMappingCollection) {
        this.areaBranchMappingCollection = areaBranchMappingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aid != null ? aid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreaBase)) {
            return false;
        }
        AreaBase other = (AreaBase) object;
        if ((this.aid == null && other.aid != null) || (this.aid != null && !this.aid.equals(other.aid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.AreaBase[ aid=" + aid + " ]";
    }
    
}

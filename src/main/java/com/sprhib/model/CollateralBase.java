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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author it207432
 */
@Entity
@Table(name = "COLLATERAL_BASE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CollateralBase.findAll", query = "SELECT c FROM CollateralBase c"),
    @NamedQuery(name = "CollateralBase.findByCid", query = "SELECT c FROM CollateralBase c WHERE c.cid = :cid"),
    @NamedQuery(name = "CollateralBase.findByCollateralCode", query = "SELECT c FROM CollateralBase c WHERE c.collateralCode = :collateralCode"),
    @NamedQuery(name = "CollateralBase.findByCollateralDescription", query = "SELECT c FROM CollateralBase c WHERE c.collateralDescription = :collateralDescription")})
public class CollateralBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CID")
    private Integer cid;
    @Basic(optional = false)
    @Column(name = "COLLATERAL_CODE")
    private String collateralCode;
    @Basic(optional = false)
    @Column(name = "COLLATERAL_DESCRIPTION")
    private String collateralDescription;

    public CollateralBase() {
    }

    public CollateralBase(Integer cid) {
        this.cid = cid;
    }

    public CollateralBase(Integer cid, String collateralCode, String collateralDescription) {
        this.cid = cid;
        this.collateralCode = collateralCode;
        this.collateralDescription = collateralDescription;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCollateralCode() {
        return collateralCode;
    }

    public void setCollateralCode(String collateralCode) {
        this.collateralCode = collateralCode;
    }

    public String getCollateralDescription() {
        return collateralDescription;
    }

    public void setCollateralDescription(String collateralDescription) {
        this.collateralDescription = collateralDescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cid != null ? cid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CollateralBase)) {
            return false;
        }
        CollateralBase other = (CollateralBase) object;
        if ((this.cid == null && other.cid != null) || (this.cid != null && !this.cid.equals(other.cid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.CollateralBase[ cid=" + cid + " ]";
    }
    
}

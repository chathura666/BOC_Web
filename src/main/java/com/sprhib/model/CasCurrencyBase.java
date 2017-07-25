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
@Table(name = "CAS_CURRENCY_BASE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CasCurrencyBase.findAll", query = "SELECT c FROM CasCurrencyBase c"),
    @NamedQuery(name = "CasCurrencyBase.findByCurrencyId", query = "SELECT c FROM CasCurrencyBase c WHERE c.currencyId = :currencyId"),
    @NamedQuery(name = "CasCurrencyBase.findByCurrencyCode", query = "SELECT c FROM CasCurrencyBase c WHERE c.currencyCode = :currencyCode"),
    @NamedQuery(name = "CasCurrencyBase.findByCurrencyName", query = "SELECT c FROM CasCurrencyBase c WHERE c.currencyName = :currencyName"),
    @NamedQuery(name = "CasCurrencyBase.findByIsactive", query = "SELECT c FROM CasCurrencyBase c WHERE c.isactive = :isactive")})
public class CasCurrencyBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CURRENCY_ID")
    private Integer currencyId;
    @Basic(optional = false)
    @Column(name = "CURRENCY_CODE")
    private int currencyCode;
    @Basic(optional = false)
    @Column(name = "CURRENCY_NAME")
    private String currencyName;
    @Basic(optional = false)
    @Column(name = "ISACTIVE")
    private Character isactive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "currencyId")
    private Collection<CasProductTypeBase> casProductTypeBaseCollection;

    public CasCurrencyBase() {
    }

    public CasCurrencyBase(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public CasCurrencyBase(Integer currencyId, int currencyCode, String currencyName, Character isactive) {
        this.currencyId = currencyId;
        this.currencyCode = currencyCode;
        this.currencyName = currencyName;
        this.isactive = isactive;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public int getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(int currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public Character getIsactive() {
        return isactive;
    }

    public void setIsactive(Character isactive) {
        this.isactive = isactive;
    }

    @XmlTransient
    public Collection<CasProductTypeBase> getCasProductTypeBaseCollection() {
        return casProductTypeBaseCollection;
    }

    public void setCasProductTypeBaseCollection(Collection<CasProductTypeBase> casProductTypeBaseCollection) {
        this.casProductTypeBaseCollection = casProductTypeBaseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (currencyId != null ? currencyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CasCurrencyBase)) {
            return false;
        }
        CasCurrencyBase other = (CasCurrencyBase) object;
        if ((this.currencyId == null && other.currencyId != null) || (this.currencyId != null && !this.currencyId.equals(other.currencyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.CasCurrencyBase[ currencyId=" + currencyId + " ]";
    }
    
}

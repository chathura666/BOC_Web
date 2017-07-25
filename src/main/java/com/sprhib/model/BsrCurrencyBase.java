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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author it207432
 */
@Entity
@Table(name = "BSR_CURRENCY_BASE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BsrCurrencyBase.findAll", query = "SELECT b FROM BsrCurrencyBase b"),
    @NamedQuery(name = "BsrCurrencyBase.findByCurrencyId", query = "SELECT b FROM BsrCurrencyBase b WHERE b.currencyId = :currencyId"),
    @NamedQuery(name = "BsrCurrencyBase.findByCurrencyCode", query = "SELECT b FROM BsrCurrencyBase b WHERE b.currencyCode = :currencyCode"),
    @NamedQuery(name = "BsrCurrencyBase.findByCurrencyName", query = "SELECT b FROM BsrCurrencyBase b WHERE b.currencyName = :currencyName"),
    @NamedQuery(name = "BsrCurrencyBase.findByCurrencyShortName", query = "SELECT b FROM BsrCurrencyBase b WHERE b.currencyShortName = :currencyShortName")})
public class BsrCurrencyBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CURRENCY_ID")
    private Integer currencyId;
    @Basic(optional = false)
    @Column(name = "CURRENCY_CODE")
    private String currencyCode;
    @Basic(optional = false)
    @Column(name = "CURRENCY_NAME")
    private String currencyName;
    @Column(name = "CURRENCY_SHORT_NAME")
    private String currencyShortName;

    public BsrCurrencyBase() {
    }

    public BsrCurrencyBase(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public BsrCurrencyBase(Integer currencyId, String currencyCode, String currencyName) {
        this.currencyId = currencyId;
        this.currencyCode = currencyCode;
        this.currencyName = currencyName;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencyShortName() {
        return currencyShortName;
    }

    public void setCurrencyShortName(String currencyShortName) {
        this.currencyShortName = currencyShortName;
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
        if (!(object instanceof BsrCurrencyBase)) {
            return false;
        }
        BsrCurrencyBase other = (BsrCurrencyBase) object;
        if ((this.currencyId == null && other.currencyId != null) || (this.currencyId != null && !this.currencyId.equals(other.currencyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.BsrCurrencyBase[ currencyId=" + currencyId + " ]";
    }
    
}

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
@Table(name = "BSR_PRODUCT_BASE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BsrProductBase.findAll", query = "SELECT b FROM BsrProductBase b"),
    @NamedQuery(name = "BsrProductBase.findByProductId", query = "SELECT b FROM BsrProductBase b WHERE b.productId = :productId"),
    @NamedQuery(name = "BsrProductBase.findByProductCode", query = "SELECT b FROM BsrProductBase b WHERE b.productCode = :productCode"),
    @NamedQuery(name = "BsrProductBase.findByProductName", query = "SELECT b FROM BsrProductBase b WHERE b.productName = :productName"),
    @NamedQuery(name = "BsrProductBase.findByCurrency", query = "SELECT b FROM BsrProductBase b WHERE b.currency = :currency"),
    @NamedQuery(name = "BsrProductBase.findBySoDebitsAllowed", query = "SELECT b FROM BsrProductBase b WHERE b.soDebitsAllowed = :soDebitsAllowed"),
    @NamedQuery(name = "BsrProductBase.findBySoCreditsAllowed", query = "SELECT b FROM BsrProductBase b WHERE b.soCreditsAllowed = :soCreditsAllowed"),
    @NamedQuery(name = "BsrProductBase.findByTfrToLkrAcAllowed", query = "SELECT b FROM BsrProductBase b WHERE b.tfrToLkrAcAllowed = :tfrToLkrAcAllowed"),
    @NamedQuery(name = "BsrProductBase.findByTfrToFcyAcAllowed", query = "SELECT b FROM BsrProductBase b WHERE b.tfrToFcyAcAllowed = :tfrToFcyAcAllowed"),
    @NamedQuery(name = "BsrProductBase.findByIfFcyAllowedEligibleProductTypes", query = "SELECT b FROM BsrProductBase b WHERE b.ifFcyAllowedEligibleProductTypes = :ifFcyAllowedEligibleProductTypes")})
public class BsrProductBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PRODUCT_ID")
    private Integer productId;
    @Basic(optional = false)
    @Column(name = "PRODUCT_CODE")
    private int productCode;
    @Basic(optional = false)
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Basic(optional = false)
    @Column(name = "CURRENCY")
    private String currency;
    @Basic(optional = false)
    @Column(name = "SO_DEBITS_ALLOWED")
    private String soDebitsAllowed;
    @Basic(optional = false)
    @Column(name = "SO_CREDITS_ALLOWED")
    private String soCreditsAllowed;
    @Basic(optional = false)
    @Column(name = "TFR_TO_LKR_AC_ALLOWED")
    private String tfrToLkrAcAllowed;
    @Basic(optional = false)
    @Column(name = "TFR_TO_FCY_AC_ALLOWED")
    private String tfrToFcyAcAllowed;
    @Basic(optional = false)
    @Column(name = "IF_FCY_ALLOWED_ELIGIBLE_PRODUCT_TYPES")
    private String ifFcyAllowedEligibleProductTypes;

    public BsrProductBase() {
    }

    public BsrProductBase(Integer productId) {
        this.productId = productId;
    }

    public BsrProductBase(Integer productId, int productCode, String productName, String currency, String soDebitsAllowed, String soCreditsAllowed, String tfrToLkrAcAllowed, String tfrToFcyAcAllowed, String ifFcyAllowedEligibleProductTypes) {
        this.productId = productId;
        this.productCode = productCode;
        this.productName = productName;
        this.currency = currency;
        this.soDebitsAllowed = soDebitsAllowed;
        this.soCreditsAllowed = soCreditsAllowed;
        this.tfrToLkrAcAllowed = tfrToLkrAcAllowed;
        this.tfrToFcyAcAllowed = tfrToFcyAcAllowed;
        this.ifFcyAllowedEligibleProductTypes = ifFcyAllowedEligibleProductTypes;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSoDebitsAllowed() {
        return soDebitsAllowed;
    }

    public void setSoDebitsAllowed(String soDebitsAllowed) {
        this.soDebitsAllowed = soDebitsAllowed;
    }

    public String getSoCreditsAllowed() {
        return soCreditsAllowed;
    }

    public void setSoCreditsAllowed(String soCreditsAllowed) {
        this.soCreditsAllowed = soCreditsAllowed;
    }

    public String getTfrToLkrAcAllowed() {
        return tfrToLkrAcAllowed;
    }

    public void setTfrToLkrAcAllowed(String tfrToLkrAcAllowed) {
        this.tfrToLkrAcAllowed = tfrToLkrAcAllowed;
    }

    public String getTfrToFcyAcAllowed() {
        return tfrToFcyAcAllowed;
    }

    public void setTfrToFcyAcAllowed(String tfrToFcyAcAllowed) {
        this.tfrToFcyAcAllowed = tfrToFcyAcAllowed;
    }

    public String getIfFcyAllowedEligibleProductTypes() {
        return ifFcyAllowedEligibleProductTypes;
    }

    public void setIfFcyAllowedEligibleProductTypes(String ifFcyAllowedEligibleProductTypes) {
        this.ifFcyAllowedEligibleProductTypes = ifFcyAllowedEligibleProductTypes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BsrProductBase)) {
            return false;
        }
        BsrProductBase other = (BsrProductBase) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.BsrProductBase[ productId=" + productId + " ]";
    }
    
}

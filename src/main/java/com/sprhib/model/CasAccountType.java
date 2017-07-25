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
@Table(name = "CAS_ACCOUNT_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CasAccountType.findAll", query = "SELECT c FROM CasAccountType c"),
    @NamedQuery(name = "CasAccountType.findByAccountId", query = "SELECT c FROM CasAccountType c WHERE c.accountId = :accountId"),
    @NamedQuery(name = "CasAccountType.findByAccountCode", query = "SELECT c FROM CasAccountType c WHERE c.accountCode = :accountCode"),
    @NamedQuery(name = "CasAccountType.findByAccountName", query = "SELECT c FROM CasAccountType c WHERE c.accountName = :accountName")})
public class CasAccountType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ACCOUNT_ID")
    private Integer accountId;
    @Basic(optional = false)
    @Column(name = "ACCOUNT_CODE")
    private int accountCode;
    @Basic(optional = false)
    @Column(name = "ACCOUNT_NAME")
    private String accountName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountType")
    private Collection<CasProductTypeBase> casProductTypeBaseCollection;

    public CasAccountType() {
    }

    public CasAccountType(Integer accountId) {
        this.accountId = accountId;
    }

    public CasAccountType(Integer accountId, int accountCode, String accountName) {
        this.accountId = accountId;
        this.accountCode = accountCode;
        this.accountName = accountName;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public int getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(int accountCode) {
        this.accountCode = accountCode;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
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
        hash += (accountId != null ? accountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CasAccountType)) {
            return false;
        }
        CasAccountType other = (CasAccountType) object;
        if ((this.accountId == null && other.accountId != null) || (this.accountId != null && !this.accountId.equals(other.accountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.CasAccountType[ accountId=" + accountId + " ]";
    }
    
}

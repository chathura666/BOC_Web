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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CAS_PRODUCT_TYPE_BASE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CasProductTypeBase.findAll", query = "SELECT c FROM CasProductTypeBase c"),
    @NamedQuery(name = "CasProductTypeBase.findByCptId", query = "SELECT c FROM CasProductTypeBase c WHERE c.cptId = :cptId"),
    @NamedQuery(name = "CasProductTypeBase.findByProductCode", query = "SELECT c FROM CasProductTypeBase c WHERE c.productCode = :productCode"),
    @NamedQuery(name = "CasProductTypeBase.findByProductName", query = "SELECT c FROM CasProductTypeBase c WHERE c.productName = :productName"),
    @NamedQuery(name = "CasProductTypeBase.findByCustomerMainType", query = "SELECT c FROM CasProductTypeBase c WHERE c.customerMainType = :customerMainType"),
    @NamedQuery(name = "CasProductTypeBase.findByIsactive", query = "SELECT c FROM CasProductTypeBase c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CasProductTypeBase.findByIsrestricted", query = "SELECT c FROM CasProductTypeBase c WHERE c.isrestricted = :isrestricted"),
    @NamedQuery(name = "CasProductTypeBase.findByIsjoint", query = "SELECT c FROM CasProductTypeBase c WHERE c.isjoint = :isjoint"),
    @NamedQuery(name = "CasProductTypeBase.findByMinAge", query = "SELECT c FROM CasProductTypeBase c WHERE c.minAge = :minAge"),
    @NamedQuery(name = "CasProductTypeBase.findByMaxAge", query = "SELECT c FROM CasProductTypeBase c WHERE c.maxAge = :maxAge"),
    @NamedQuery(name = "CasProductTypeBase.findByStatementCategory", query = "SELECT c FROM CasProductTypeBase c WHERE c.statementCategory = :statementCategory")})
public class CasProductTypeBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CPT_ID")
    private Integer cptId;
    @Basic(optional = false)
    @Column(name = "PRODUCT_CODE")
    private int productCode;
    @Basic(optional = false)
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Basic(optional = false)
    @Column(name = "CUSTOMER_MAIN_TYPE")
    private String customerMainType;
    @Basic(optional = false)
    @Column(name = "ISACTIVE")
    private Character isactive;
    @Column(name = "ISRESTRICTED")
    private Character isrestricted;
    @Column(name = "ISJOINT")
    private Character isjoint;
    @Column(name = "MIN_AGE")
    private Integer minAge;
    @Column(name = "MAX_AGE")
    private Integer maxAge;
    @Column(name = "STATEMENT_CATEGORY")
    private String statementCategory;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productId")
    private Collection<CasProductDocumentChecklistMapping> casProductDocumentChecklistMappingCollection;
    @JoinColumn(name = "CURRENCY_ID", referencedColumnName = "CURRENCY_ID")
    @ManyToOne(optional = false)
    private CasCurrencyBase currencyId;
    @JoinColumn(name = "ACCOUNT_TYPE", referencedColumnName = "ACCOUNT_ID")
    @ManyToOne(optional = false)
    private CasAccountType accountType;

    public CasProductTypeBase() {
    }

    public CasProductTypeBase(Integer cptId) {
        this.cptId = cptId;
    }

    public CasProductTypeBase(Integer cptId, int productCode, String productName, String customerMainType, Character isactive) {
        this.cptId = cptId;
        this.productCode = productCode;
        this.productName = productName;
        this.customerMainType = customerMainType;
        this.isactive = isactive;
    }

    public Integer getCptId() {
        return cptId;
    }

    public void setCptId(Integer cptId) {
        this.cptId = cptId;
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

    public String getCustomerMainType() {
        return customerMainType;
    }

    public void setCustomerMainType(String customerMainType) {
        this.customerMainType = customerMainType;
    }

    public Character getIsactive() {
        return isactive;
    }

    public void setIsactive(Character isactive) {
        this.isactive = isactive;
    }

    public Character getIsrestricted() {
        return isrestricted;
    }

    public void setIsrestricted(Character isrestricted) {
        this.isrestricted = isrestricted;
    }

    public Character getIsjoint() {
        return isjoint;
    }

    public void setIsjoint(Character isjoint) {
        this.isjoint = isjoint;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    public String getStatementCategory() {
        return statementCategory;
    }

    public void setStatementCategory(String statementCategory) {
        this.statementCategory = statementCategory;
    }

    @XmlTransient
    public Collection<CasProductDocumentChecklistMapping> getCasProductDocumentChecklistMappingCollection() {
        return casProductDocumentChecklistMappingCollection;
    }

    public void setCasProductDocumentChecklistMappingCollection(Collection<CasProductDocumentChecklistMapping> casProductDocumentChecklistMappingCollection) {
        this.casProductDocumentChecklistMappingCollection = casProductDocumentChecklistMappingCollection;
    }

    public CasCurrencyBase getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(CasCurrencyBase currencyId) {
        this.currencyId = currencyId;
    }

    public CasAccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(CasAccountType accountType) {
        this.accountType = accountType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cptId != null ? cptId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CasProductTypeBase)) {
            return false;
        }
        CasProductTypeBase other = (CasProductTypeBase) object;
        if ((this.cptId == null && other.cptId != null) || (this.cptId != null && !this.cptId.equals(other.cptId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.CasProductTypeBase[ cptId=" + cptId + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "PRODUCT_CATEGORY_BASE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductCategoryBase.findAll", query = "SELECT p FROM ProductCategoryBase p"),
    @NamedQuery(name = "ProductCategoryBase.findByProductCategoryId", query = "SELECT p FROM ProductCategoryBase p WHERE p.productCategoryId = :productCategoryId"),
    @NamedQuery(name = "ProductCategoryBase.findByProductCategory", query = "SELECT p FROM ProductCategoryBase p WHERE p.productCategory = :productCategory"),
    @NamedQuery(name = "ProductCategoryBase.findByEditflag", query = "SELECT p FROM ProductCategoryBase p WHERE p.editflag = :editflag"),
    @NamedQuery(name = "ProductCategoryBase.findByDeleteflag", query = "SELECT p FROM ProductCategoryBase p WHERE p.deleteflag = :deleteflag")})
public class ProductCategoryBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PRODUCT_CATEGORY_ID")
    private Integer productCategoryId;
    @Basic(optional = false)
    @Column(name = "PRODUCT_CATEGORY")
    private String productCategory;
    @Column(name = "EDITFLAG")
    private Short editflag;
    @Column(name = "DELETEFLAG")
    private Short deleteflag;
    @OneToMany(mappedBy = "productCategoryId")
    private Collection<SecurityTypeBase> securityTypeBaseCollection;
    @OneToMany(mappedBy = "productCategoryId")
    private Collection<ProductBase> productBaseCollection;
    @OneToMany(mappedBy = "productCategoryId")
    private Collection<LoanPurposes> loanPurposesCollection;

    public ProductCategoryBase() {
    }

    public ProductCategoryBase(Integer productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public ProductCategoryBase(Integer productCategoryId, String productCategory) {
        this.productCategoryId = productCategoryId;
        this.productCategory = productCategory;
    }

    public Integer getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Integer productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public Short getEditflag() {
        return editflag;
    }

    public void setEditflag(Short editflag) {
        this.editflag = editflag;
    }

    public Short getDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(Short deleteflag) {
        this.deleteflag = deleteflag;
    }

    @XmlTransient
    public Collection<SecurityTypeBase> getSecurityTypeBaseCollection() {
        return securityTypeBaseCollection;
    }

    public void setSecurityTypeBaseCollection(Collection<SecurityTypeBase> securityTypeBaseCollection) {
        this.securityTypeBaseCollection = securityTypeBaseCollection;
    }

    @XmlTransient
    public Collection<ProductBase> getProductBaseCollection() {
        return productBaseCollection;
    }

    public void setProductBaseCollection(Collection<ProductBase> productBaseCollection) {
        this.productBaseCollection = productBaseCollection;
    }

    @XmlTransient
    public Collection<LoanPurposes> getLoanPurposesCollection() {
        return loanPurposesCollection;
    }

    public void setLoanPurposesCollection(Collection<LoanPurposes> loanPurposesCollection) {
        this.loanPurposesCollection = loanPurposesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productCategoryId != null ? productCategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductCategoryBase)) {
            return false;
        }
        ProductCategoryBase other = (ProductCategoryBase) object;
        if ((this.productCategoryId == null && other.productCategoryId != null) || (this.productCategoryId != null && !this.productCategoryId.equals(other.productCategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.ProductCategoryBase[ productCategoryId=" + productCategoryId + " ]";
    }
    
}

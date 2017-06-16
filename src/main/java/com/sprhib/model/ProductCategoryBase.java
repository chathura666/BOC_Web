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
    @NamedQuery(name = "ProductCategoryBase.findByProductCategory", query = "SELECT p FROM ProductCategoryBase p WHERE p.productCategory = :productCategory")})
public class ProductCategoryBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PRODUCT_CATEGORY_ID")
    private Integer productCategoryId;
    @Basic(optional = false)
    @Column(name = "PRODUCT_CATEGORY")
    private String productCategory;
    @OneToMany(mappedBy = "productCategoryId")
    private Collection<ProductBase> productBaseCollection;

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

    @XmlTransient
    public Collection<ProductBase> getProductBaseCollection() {
        return productBaseCollection;
    }

    public void setProductBaseCollection(Collection<ProductBase> productBaseCollection) {
        this.productBaseCollection = productBaseCollection;
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
        return "db2.ProductCategoryBase[ productCategoryId=" + productCategoryId + " ]";
    }
    
}

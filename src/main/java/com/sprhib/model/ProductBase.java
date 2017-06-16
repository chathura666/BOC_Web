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
@Table(name = "PRODUCT_BASE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductBase.findAll", query = "SELECT p FROM ProductBase p"),
    @NamedQuery(name = "ProductBase.findByPid", query = "SELECT p FROM ProductBase p WHERE p.pid = :pid"),
    @NamedQuery(name = "ProductBase.findByProductCode", query = "SELECT p FROM ProductBase p WHERE p.productCode = :productCode"),
    @NamedQuery(name = "ProductBase.findByWfProductCode", query = "SELECT p FROM ProductBase p WHERE p.wfProductCode = :wfProductCode"),
    @NamedQuery(name = "ProductBase.findByProductName", query = "SELECT p FROM ProductBase p WHERE p.productName = :productName"),
    @NamedQuery(name = "ProductBase.findByProductDescription", query = "SELECT p FROM ProductBase p WHERE p.productDescription = :productDescription")})
public class ProductBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PID")
    private Integer pid;
    @Basic(optional = false)
    @Column(name = "PRODUCT_CODE")
    private String productCode;
    @Basic(optional = false)
    @Column(name = "WF_PRODUCT_CODE")
    private String wfProductCode;
    @Basic(optional = false)
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Column(name = "PRODUCT_DESCRIPTION")
    private String productDescription;
    @JoinColumn(name = "PRODUCT_CATEGORY_ID", referencedColumnName = "PRODUCT_CATEGORY_ID")
    @ManyToOne
    private ProductCategoryBase productCategoryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productId")
    private Collection<ProductDocumentChecklistMapping> productDocumentChecklistMappingCollection;

    public ProductBase() {
    }

    public ProductBase(Integer pid) {
        this.pid = pid;
    }

    public ProductBase(Integer pid, String productCode, String wfProductCode, String productName) {
        this.pid = pid;
        this.productCode = productCode;
        this.wfProductCode = wfProductCode;
        this.productName = productName;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getWfProductCode() {
        return wfProductCode;
    }

    public void setWfProductCode(String wfProductCode) {
        this.wfProductCode = wfProductCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public ProductCategoryBase getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(ProductCategoryBase productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    @XmlTransient
    public Collection<ProductDocumentChecklistMapping> getProductDocumentChecklistMappingCollection() {
        return productDocumentChecklistMappingCollection;
    }

    public void setProductDocumentChecklistMappingCollection(Collection<ProductDocumentChecklistMapping> productDocumentChecklistMappingCollection) {
        this.productDocumentChecklistMappingCollection = productDocumentChecklistMappingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pid != null ? pid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductBase)) {
            return false;
        }
        ProductBase other = (ProductBase) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db2.ProductBase[ pid=" + pid + " ]";
    }
    
}

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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "SECURITY_TYPE_BASE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SecurityTypeBase.findAll", query = "SELECT s FROM SecurityTypeBase s"),
    @NamedQuery(name = "SecurityTypeBase.findBySecurityTypeId", query = "SELECT s FROM SecurityTypeBase s WHERE s.securityTypeId = :securityTypeId"),
    @NamedQuery(name = "SecurityTypeBase.findByNatureOfSecurity", query = "SELECT s FROM SecurityTypeBase s WHERE s.natureOfSecurity = :natureOfSecurity")})
public class SecurityTypeBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SECURITY_TYPE_ID")
    private Integer securityTypeId;
    @Basic(optional = false)
    @Column(name = "NATURE_OF_SECURITY")
    private String natureOfSecurity;
    @JoinColumn(name = "PRODUCT_CATEGORY_ID", referencedColumnName = "PRODUCT_CATEGORY_ID")
    @ManyToOne
    private ProductCategoryBase productCategoryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "securityTypeId")
    private Collection<SecurityTypeDocumentChecklistMapping> securityTypeDocumentChecklistMappingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "securityTypeId")
    private Collection<ProductSecurityTypeMapping> productSecurityTypeMappingCollection;

    public SecurityTypeBase() {
    }

    public SecurityTypeBase(Integer securityTypeId) {
        this.securityTypeId = securityTypeId;
    }

    public SecurityTypeBase(Integer securityTypeId, String natureOfSecurity) {
        this.securityTypeId = securityTypeId;
        this.natureOfSecurity = natureOfSecurity;
    }

    public Integer getSecurityTypeId() {
        return securityTypeId;
    }

    public void setSecurityTypeId(Integer securityTypeId) {
        this.securityTypeId = securityTypeId;
    }

    public String getNatureOfSecurity() {
        return natureOfSecurity;
    }

    public void setNatureOfSecurity(String natureOfSecurity) {
        this.natureOfSecurity = natureOfSecurity;
    }

    public ProductCategoryBase getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(ProductCategoryBase productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    @XmlTransient
    public Collection<SecurityTypeDocumentChecklistMapping> getSecurityTypeDocumentChecklistMappingCollection() {
        return securityTypeDocumentChecklistMappingCollection;
    }

    public void setSecurityTypeDocumentChecklistMappingCollection(Collection<SecurityTypeDocumentChecklistMapping> securityTypeDocumentChecklistMappingCollection) {
        this.securityTypeDocumentChecklistMappingCollection = securityTypeDocumentChecklistMappingCollection;
    }

    @XmlTransient
    public Collection<ProductSecurityTypeMapping> getProductSecurityTypeMappingCollection() {
        return productSecurityTypeMappingCollection;
    }

    public void setProductSecurityTypeMappingCollection(Collection<ProductSecurityTypeMapping> productSecurityTypeMappingCollection) {
        this.productSecurityTypeMappingCollection = productSecurityTypeMappingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (securityTypeId != null ? securityTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SecurityTypeBase)) {
            return false;
        }
        SecurityTypeBase other = (SecurityTypeBase) object;
        if ((this.securityTypeId == null && other.securityTypeId != null) || (this.securityTypeId != null && !this.securityTypeId.equals(other.securityTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.SecurityTypeBase[ securityTypeId=" + securityTypeId + " ]";
    }
    
}

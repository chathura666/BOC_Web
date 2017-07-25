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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author it207432
 */
@Entity
@Table(name = "PRODUCT_SECURITY_TYPE_MAPPING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductSecurityTypeMapping.findAll", query = "SELECT p FROM ProductSecurityTypeMapping p"),
    @NamedQuery(name = "ProductSecurityTypeMapping.findByPstid", query = "SELECT p FROM ProductSecurityTypeMapping p WHERE p.pstid = :pstid")})
public class ProductSecurityTypeMapping implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PSTID")
    private Integer pstid;
    @JoinColumn(name = "SECURITY_TYPE_ID", referencedColumnName = "SECURITY_TYPE_ID")
    @ManyToOne(optional = false)
    private SecurityTypeBase securityTypeId;
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PID")
    @ManyToOne(optional = false)
    private ProductBase productId;

    public ProductSecurityTypeMapping() {
    }

    public ProductSecurityTypeMapping(Integer pstid) {
        this.pstid = pstid;
    }

    public Integer getPstid() {
        return pstid;
    }

    public void setPstid(Integer pstid) {
        this.pstid = pstid;
    }

    public SecurityTypeBase getSecurityTypeId() {
        return securityTypeId;
    }

    public void setSecurityTypeId(SecurityTypeBase securityTypeId) {
        this.securityTypeId = securityTypeId;
    }

    public ProductBase getProductId() {
        return productId;
    }

    public void setProductId(ProductBase productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pstid != null ? pstid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductSecurityTypeMapping)) {
            return false;
        }
        ProductSecurityTypeMapping other = (ProductSecurityTypeMapping) object;
        if ((this.pstid == null && other.pstid != null) || (this.pstid != null && !this.pstid.equals(other.pstid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.ProductSecurityTypeMapping[ pstid=" + pstid + " ]";
    }
    
}

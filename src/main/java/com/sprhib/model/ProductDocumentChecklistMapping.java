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
@Table(name = "PRODUCT_DOCUMENT_CHECKLIST_MAPPING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductDocumentChecklistMapping.findAll", query = "SELECT p FROM ProductDocumentChecklistMapping p"),
    @NamedQuery(name = "ProductDocumentChecklistMapping.findByPdcid", query = "SELECT p FROM ProductDocumentChecklistMapping p WHERE p.pdcid = :pdcid"),
    @NamedQuery(name = "ProductDocumentChecklistMapping.findByScanRequired", query = "SELECT p FROM ProductDocumentChecklistMapping p WHERE p.scanRequired = :scanRequired"),
    @NamedQuery(name = "ProductDocumentChecklistMapping.findByMandatory", query = "SELECT p FROM ProductDocumentChecklistMapping p WHERE p.mandatory = :mandatory")})
public class ProductDocumentChecklistMapping implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PDCID")
    private Integer pdcid;
    @Basic(optional = false)
    @Column(name = "SCAN_REQUIRED")
    private Character scanRequired;
    @Column(name = "MANDATORY")
    private Character mandatory;
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PID")
    @ManyToOne(optional = false)
    private ProductBase productId;
    @JoinColumn(name = "DOCUMENT_ID", referencedColumnName = "DID")
    @ManyToOne(optional = false)
    private DocumentTypeBase documentId;

    
    

    public ProductDocumentChecklistMapping() {
    }

    public ProductDocumentChecklistMapping(Integer pdcid) {
        this.pdcid = pdcid;
    }

    public ProductDocumentChecklistMapping(Integer pdcid, Character scanRequired) {
        this.pdcid = pdcid;
        this.scanRequired = scanRequired;
    }

    public Integer getPdcid() {
        return pdcid;
    }

    public void setPdcid(Integer pdcid) {
        this.pdcid = pdcid;
    }

    public Character getScanRequired() {
        return scanRequired;
    }

    public void setScanRequired(Character scanRequired) {
        this.scanRequired = scanRequired;
    }

    public Character getMandatory() {
        return mandatory;
    }

    public void setMandatory(Character mandatory) {
        this.mandatory = mandatory;
    }

    public ProductBase getProductId() {
        return productId;
    }

    public void setProductId(ProductBase productId) {
        this.productId = productId;
    }

    public DocumentTypeBase getDocumentId() {
        return documentId;
    }

    public void setDocumentId(DocumentTypeBase documentId) {
        this.documentId = documentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pdcid != null ? pdcid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductDocumentChecklistMapping)) {
            return false;
        }
        ProductDocumentChecklistMapping other = (ProductDocumentChecklistMapping) object;
        if ((this.pdcid == null && other.pdcid != null) || (this.pdcid != null && !this.pdcid.equals(other.pdcid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db2.ProductDocumentChecklistMapping[ pdcid=" + pdcid + " ]";
    }

}

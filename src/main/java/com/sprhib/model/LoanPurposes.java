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
@Table(name = "LOAN_PURPOSES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoanPurposes.findAll", query = "SELECT l FROM LoanPurposes l"),
    @NamedQuery(name = "LoanPurposes.findByPid", query = "SELECT l FROM LoanPurposes l WHERE l.pid = :pid"),
    @NamedQuery(name = "LoanPurposes.findByLoanPurposes", query = "SELECT l FROM LoanPurposes l WHERE l.loanPurposes = :loanPurposes")})
public class LoanPurposes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PID")
    private Integer pid;
    @Basic(optional = false)
    @Column(name = "LOAN_PURPOSES")
    private String loanPurposes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purposeId")
    private Collection<LoanPurposesDocumentChecklistMapping> loanPurposesDocumentChecklistMappingCollection;
    @JoinColumn(name = "PRODUCT_CATEGORY_ID", referencedColumnName = "PRODUCT_CATEGORY_ID")
    @ManyToOne
    private ProductCategoryBase productCategoryId;

    public LoanPurposes() {
    }

    public LoanPurposes(Integer pid) {
        this.pid = pid;
    }

    public LoanPurposes(Integer pid, String loanPurposes) {
        this.pid = pid;
        this.loanPurposes = loanPurposes;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getLoanPurposes() {
        return loanPurposes;
    }

    public void setLoanPurposes(String loanPurposes) {
        this.loanPurposes = loanPurposes;
    }

    @XmlTransient
    public Collection<LoanPurposesDocumentChecklistMapping> getLoanPurposesDocumentChecklistMappingCollection() {
        return loanPurposesDocumentChecklistMappingCollection;
    }

    public void setLoanPurposesDocumentChecklistMappingCollection(Collection<LoanPurposesDocumentChecklistMapping> loanPurposesDocumentChecklistMappingCollection) {
        this.loanPurposesDocumentChecklistMappingCollection = loanPurposesDocumentChecklistMappingCollection;
    }

    public ProductCategoryBase getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(ProductCategoryBase productCategoryId) {
        this.productCategoryId = productCategoryId;
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
        if (!(object instanceof LoanPurposes)) {
            return false;
        }
        LoanPurposes other = (LoanPurposes) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.LoanPurposes[ pid=" + pid + " ]";
    }
    
}

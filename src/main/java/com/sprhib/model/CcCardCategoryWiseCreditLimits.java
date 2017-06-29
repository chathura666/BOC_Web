/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "CC_CARD_CATEGORY_WISE_CREDIT_LIMITS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CcCardCategoryWiseCreditLimits.findAll", query = "SELECT c FROM CcCardCategoryWiseCreditLimits c"),
    @NamedQuery(name = "CcCardCategoryWiseCreditLimits.findByCclId", query = "SELECT c FROM CcCardCategoryWiseCreditLimits c WHERE c.cclId = :cclId"),
    @NamedQuery(name = "CcCardCategoryWiseCreditLimits.findByMainCategory", query = "SELECT c FROM CcCardCategoryWiseCreditLimits c WHERE c.mainCategory = :mainCategory"),
    @NamedQuery(name = "CcCardCategoryWiseCreditLimits.findBySubCategory", query = "SELECT c FROM CcCardCategoryWiseCreditLimits c WHERE c.subCategory = :subCategory"),
    @NamedQuery(name = "CcCardCategoryWiseCreditLimits.findByLowerLimit", query = "SELECT c FROM CcCardCategoryWiseCreditLimits c WHERE c.lowerLimit = :lowerLimit"),
    @NamedQuery(name = "CcCardCategoryWiseCreditLimits.findByUpperLimit", query = "SELECT c FROM CcCardCategoryWiseCreditLimits c WHERE c.upperLimit = :upperLimit")})
public class CcCardCategoryWiseCreditLimits implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CCL_ID")
    private Integer cclId;
    @Basic(optional = false)
    @Column(name = "MAIN_CATEGORY")
    private String mainCategory;
    @Basic(optional = false)
    @Column(name = "SUB_CATEGORY")
    private String subCategory;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "LOWER_LIMIT")
    private BigDecimal lowerLimit;
    @Basic(optional = false)
    @Column(name = "UPPER_LIMIT")
    private BigDecimal upperLimit;

    public CcCardCategoryWiseCreditLimits() {
    }

    public CcCardCategoryWiseCreditLimits(Integer cclId) {
        this.cclId = cclId;
    }

    public CcCardCategoryWiseCreditLimits(Integer cclId, String mainCategory, String subCategory, BigDecimal lowerLimit, BigDecimal upperLimit) {
        this.cclId = cclId;
        this.mainCategory = mainCategory;
        this.subCategory = subCategory;
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }

    public Integer getCclId() {
        return cclId;
    }

    public void setCclId(Integer cclId) {
        this.cclId = cclId;
    }

    public String getMainCategory() {
        return mainCategory;
    }

    public void setMainCategory(String mainCategory) {
        this.mainCategory = mainCategory;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public BigDecimal getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(BigDecimal lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public BigDecimal getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(BigDecimal upperLimit) {
        this.upperLimit = upperLimit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cclId != null ? cclId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CcCardCategoryWiseCreditLimits)) {
            return false;
        }
        CcCardCategoryWiseCreditLimits other = (CcCardCategoryWiseCreditLimits) object;
        if ((this.cclId == null && other.cclId != null) || (this.cclId != null && !this.cclId.equals(other.cclId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.CcCardCategoryWiseCreditLimits[ cclId=" + cclId + " ]";
    }
    
}

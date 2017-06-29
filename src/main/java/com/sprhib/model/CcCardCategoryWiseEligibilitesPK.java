/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author it207432
 */
@Embeddable
public class CcCardCategoryWiseEligibilitesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CCE_ID")
    private int cceId;
    @Basic(optional = false)
    @Column(name = "MAIN_CATEGORY")
    private String mainCategory;
    @Basic(optional = false)
    @Column(name = "SUB_CATEGORY")
    private String subCategory;
    @Basic(optional = false)
    @Column(name = "SUB_SELECTION")
    private String subSelection;

    public CcCardCategoryWiseEligibilitesPK() {
    }

    public CcCardCategoryWiseEligibilitesPK(int cceId, String mainCategory, String subCategory, String subSelection) {
        this.cceId = cceId;
        this.mainCategory = mainCategory;
        this.subCategory = subCategory;
        this.subSelection = subSelection;
    }

    public int getCceId() {
        return cceId;
    }

    public void setCceId(int cceId) {
        this.cceId = cceId;
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

    public String getSubSelection() {
        return subSelection;
    }

    public void setSubSelection(String subSelection) {
        this.subSelection = subSelection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cceId;
        hash += (mainCategory != null ? mainCategory.hashCode() : 0);
        hash += (subCategory != null ? subCategory.hashCode() : 0);
        hash += (subSelection != null ? subSelection.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CcCardCategoryWiseEligibilitesPK)) {
            return false;
        }
        CcCardCategoryWiseEligibilitesPK other = (CcCardCategoryWiseEligibilitesPK) object;
        if (this.cceId != other.cceId) {
            return false;
        }
        if ((this.mainCategory == null && other.mainCategory != null) || (this.mainCategory != null && !this.mainCategory.equals(other.mainCategory))) {
            return false;
        }
        if ((this.subCategory == null && other.subCategory != null) || (this.subCategory != null && !this.subCategory.equals(other.subCategory))) {
            return false;
        }
        if ((this.subSelection == null && other.subSelection != null) || (this.subSelection != null && !this.subSelection.equals(other.subSelection))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.CcCardCategoryWiseEligibilitesPK[ cceId=" + cceId + ", mainCategory=" + mainCategory + ", subCategory=" + subCategory + ", subSelection=" + subSelection + " ]";
    }
    
}

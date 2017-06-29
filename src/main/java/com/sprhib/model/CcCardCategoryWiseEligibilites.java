/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author it207432
 */
@Entity
@Table(name = "CC_CARD_CATEGORY_WISE_ELIGIBILITES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CcCardCategoryWiseEligibilites.findAll", query = "SELECT c FROM CcCardCategoryWiseEligibilites c"),
    @NamedQuery(name = "CcCardCategoryWiseEligibilites.findByCceId", query = "SELECT c FROM CcCardCategoryWiseEligibilites c WHERE c.ccCardCategoryWiseEligibilitesPK.cceId = :cceId"),
    @NamedQuery(name = "CcCardCategoryWiseEligibilites.findByMainCategory", query = "SELECT c FROM CcCardCategoryWiseEligibilites c WHERE c.ccCardCategoryWiseEligibilitesPK.mainCategory = :mainCategory"),
    @NamedQuery(name = "CcCardCategoryWiseEligibilites.findBySubCategory", query = "SELECT c FROM CcCardCategoryWiseEligibilites c WHERE c.ccCardCategoryWiseEligibilitesPK.subCategory = :subCategory"),
    @NamedQuery(name = "CcCardCategoryWiseEligibilites.findBySubSelection", query = "SELECT c FROM CcCardCategoryWiseEligibilites c WHERE c.ccCardCategoryWiseEligibilitesPK.subSelection = :subSelection")})
public class CcCardCategoryWiseEligibilites implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CcCardCategoryWiseEligibilitesPK ccCardCategoryWiseEligibilitesPK;

    public CcCardCategoryWiseEligibilites() {
    }

    public CcCardCategoryWiseEligibilites(CcCardCategoryWiseEligibilitesPK ccCardCategoryWiseEligibilitesPK) {
        this.ccCardCategoryWiseEligibilitesPK = ccCardCategoryWiseEligibilitesPK;
    }

    public CcCardCategoryWiseEligibilites(int cceId, String mainCategory, String subCategory, String subSelection) {
        this.ccCardCategoryWiseEligibilitesPK = new CcCardCategoryWiseEligibilitesPK(cceId, mainCategory, subCategory, subSelection);
    }

    public CcCardCategoryWiseEligibilitesPK getCcCardCategoryWiseEligibilitesPK() {
        return ccCardCategoryWiseEligibilitesPK;
    }

    public void setCcCardCategoryWiseEligibilitesPK(CcCardCategoryWiseEligibilitesPK ccCardCategoryWiseEligibilitesPK) {
        this.ccCardCategoryWiseEligibilitesPK = ccCardCategoryWiseEligibilitesPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ccCardCategoryWiseEligibilitesPK != null ? ccCardCategoryWiseEligibilitesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CcCardCategoryWiseEligibilites)) {
            return false;
        }
        CcCardCategoryWiseEligibilites other = (CcCardCategoryWiseEligibilites) object;
        if ((this.ccCardCategoryWiseEligibilitesPK == null && other.ccCardCategoryWiseEligibilitesPK != null) || (this.ccCardCategoryWiseEligibilitesPK != null && !this.ccCardCategoryWiseEligibilitesPK.equals(other.ccCardCategoryWiseEligibilitesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.CcCardCategoryWiseEligibilites[ ccCardCategoryWiseEligibilitesPK=" + ccCardCategoryWiseEligibilitesPK + " ]";
    }
    
}

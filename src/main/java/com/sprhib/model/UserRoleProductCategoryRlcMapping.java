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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author it207432
 */
@Entity
@Table(name = "USER_ROLE_PRODUCT_CATEGORY_RLC_MAPPING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserRoleProductCategoryRlcMapping.findAll", query = "SELECT u FROM UserRoleProductCategoryRlcMapping u"),
    @NamedQuery(name = "UserRoleProductCategoryRlcMapping.findByUrpcrlcid", query = "SELECT u FROM UserRoleProductCategoryRlcMapping u WHERE u.urpcrlcid = :urpcrlcid"),
    @NamedQuery(name = "UserRoleProductCategoryRlcMapping.findByUrpcid", query = "SELECT u FROM UserRoleProductCategoryRlcMapping u WHERE u.urpcid = :urpcid"),
    @NamedQuery(name = "UserRoleProductCategoryRlcMapping.findByRlcId", query = "SELECT u FROM UserRoleProductCategoryRlcMapping u WHERE u.rlcId = :rlcId")})
public class UserRoleProductCategoryRlcMapping implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "URPCRLCID")
    private Integer urpcrlcid;
    @Basic(optional = false)
    @Column(name = "URPCID")
    private int urpcid;
    @Basic(optional = false)
    @Column(name = "RLC_ID")
    private int rlcId;

    public UserRoleProductCategoryRlcMapping() {
    }

    public UserRoleProductCategoryRlcMapping(Integer urpcrlcid) {
        this.urpcrlcid = urpcrlcid;
    }

    public UserRoleProductCategoryRlcMapping(Integer urpcrlcid, int urpcid, int rlcId) {
        this.urpcrlcid = urpcrlcid;
        this.urpcid = urpcid;
        this.rlcId = rlcId;
    }

    public Integer getUrpcrlcid() {
        return urpcrlcid;
    }

    public void setUrpcrlcid(Integer urpcrlcid) {
        this.urpcrlcid = urpcrlcid;
    }

    public int getUrpcid() {
        return urpcid;
    }

    public void setUrpcid(int urpcid) {
        this.urpcid = urpcid;
    }

    public int getRlcId() {
        return rlcId;
    }

    public void setRlcId(int rlcId) {
        this.rlcId = rlcId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (urpcrlcid != null ? urpcrlcid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRoleProductCategoryRlcMapping)) {
            return false;
        }
        UserRoleProductCategoryRlcMapping other = (UserRoleProductCategoryRlcMapping) object;
        if ((this.urpcrlcid == null && other.urpcrlcid != null) || (this.urpcrlcid != null && !this.urpcrlcid.equals(other.urpcrlcid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.UserRoleProductCategoryRlcMapping[ urpcrlcid=" + urpcrlcid + " ]";
    }
    
}

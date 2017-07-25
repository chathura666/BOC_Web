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
@Table(name = "USER_ROLE_PRODUCT_CATEGORY_MAPPING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserRoleProductCategoryMapping.findAll", query = "SELECT u FROM UserRoleProductCategoryMapping u"),
    @NamedQuery(name = "UserRoleProductCategoryMapping.findByUrpcid", query = "SELECT u FROM UserRoleProductCategoryMapping u WHERE u.urpcid = :urpcid"),
    @NamedQuery(name = "UserRoleProductCategoryMapping.findByUid", query = "SELECT u FROM UserRoleProductCategoryMapping u WHERE u.uid = :uid"),
    @NamedQuery(name = "UserRoleProductCategoryMapping.findByRid", query = "SELECT u FROM UserRoleProductCategoryMapping u WHERE u.rid = :rid"),
    @NamedQuery(name = "UserRoleProductCategoryMapping.findByProductCategoryId", query = "SELECT u FROM UserRoleProductCategoryMapping u WHERE u.productCategoryId = :productCategoryId"),
    @NamedQuery(name = "UserRoleProductCategoryMapping.findByEditflag", query = "SELECT u FROM UserRoleProductCategoryMapping u WHERE u.editflag = :editflag"),
    @NamedQuery(name = "UserRoleProductCategoryMapping.findByDeleteflag", query = "SELECT u FROM UserRoleProductCategoryMapping u WHERE u.deleteflag = :deleteflag")})
public class UserRoleProductCategoryMapping implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "URPCID")
    private Integer urpcid;
    @Basic(optional = false)
    @Column(name = "UID")
    private int uid;
    @Basic(optional = false)
    @Column(name = "RID")
    private int rid;
    @Basic(optional = false)
    @Column(name = "PRODUCT_CATEGORY_ID")
    private int productCategoryId;
    @Column(name = "EDITFLAG")
    private Short editflag;
    @Column(name = "DELETEFLAG")
    private Short deleteflag;

    public UserRoleProductCategoryMapping() {
    }

    public UserRoleProductCategoryMapping(Integer urpcid) {
        this.urpcid = urpcid;
    }

    public UserRoleProductCategoryMapping(Integer urpcid, int uid, int rid, int productCategoryId) {
        this.urpcid = urpcid;
        this.uid = uid;
        this.rid = rid;
        this.productCategoryId = productCategoryId;
    }

    public Integer getUrpcid() {
        return urpcid;
    }

    public void setUrpcid(Integer urpcid) {
        this.urpcid = urpcid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(int productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Short getEditflag() {
        return editflag;
    }

    public void setEditflag(Short editflag) {
        this.editflag = editflag;
    }

    public Short getDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(Short deleteflag) {
        this.deleteflag = deleteflag;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (urpcid != null ? urpcid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRoleProductCategoryMapping)) {
            return false;
        }
        UserRoleProductCategoryMapping other = (UserRoleProductCategoryMapping) object;
        if ((this.urpcid == null && other.urpcid != null) || (this.urpcid != null && !this.urpcid.equals(other.urpcid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.UserRoleProductCategoryMapping[ urpcid=" + urpcid + " ]";
    }
    
}

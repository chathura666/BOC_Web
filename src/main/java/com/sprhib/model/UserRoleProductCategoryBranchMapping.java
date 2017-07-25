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
@Table(name = "USER_ROLE_PRODUCT_CATEGORY_BRANCH_MAPPING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserRoleProductCategoryBranchMapping.findAll", query = "SELECT u FROM UserRoleProductCategoryBranchMapping u"),
    @NamedQuery(name = "UserRoleProductCategoryBranchMapping.findByUrpcbid", query = "SELECT u FROM UserRoleProductCategoryBranchMapping u WHERE u.urpcbid = :urpcbid"),
    @NamedQuery(name = "UserRoleProductCategoryBranchMapping.findByUrpcid", query = "SELECT u FROM UserRoleProductCategoryBranchMapping u WHERE u.urpcid = :urpcid"),
    @NamedQuery(name = "UserRoleProductCategoryBranchMapping.findByBid", query = "SELECT u FROM UserRoleProductCategoryBranchMapping u WHERE u.bid = :bid"),
    @NamedQuery(name = "UserRoleProductCategoryBranchMapping.findByEditflag", query = "SELECT u FROM UserRoleProductCategoryBranchMapping u WHERE u.editflag = :editflag"),
    @NamedQuery(name = "UserRoleProductCategoryBranchMapping.findByDeleteflag", query = "SELECT u FROM UserRoleProductCategoryBranchMapping u WHERE u.deleteflag = :deleteflag")})
public class UserRoleProductCategoryBranchMapping implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "URPCBID")
    private Integer urpcbid;
    @Basic(optional = false)
    @Column(name = "URPCID")
    private int urpcid;
    @Basic(optional = false)
    @Column(name = "BID")
    private int bid;
    @Column(name = "EDITFLAG")
    private Short editflag;
    @Column(name = "DELETEFLAG")
    private Short deleteflag;

    public UserRoleProductCategoryBranchMapping() {
    }

    public UserRoleProductCategoryBranchMapping(Integer urpcbid) {
        this.urpcbid = urpcbid;
    }

    public UserRoleProductCategoryBranchMapping(Integer urpcbid, int urpcid, int bid) {
        this.urpcbid = urpcbid;
        this.urpcid = urpcid;
        this.bid = bid;
    }

    public Integer getUrpcbid() {
        return urpcbid;
    }

    public void setUrpcbid(Integer urpcbid) {
        this.urpcbid = urpcbid;
    }

    public int getUrpcid() {
        return urpcid;
    }

    public void setUrpcid(int urpcid) {
        this.urpcid = urpcid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
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
        hash += (urpcbid != null ? urpcbid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRoleProductCategoryBranchMapping)) {
            return false;
        }
        UserRoleProductCategoryBranchMapping other = (UserRoleProductCategoryBranchMapping) object;
        if ((this.urpcbid == null && other.urpcbid != null) || (this.urpcbid != null && !this.urpcbid.equals(other.urpcbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.UserRoleProductCategoryBranchMapping[ urpcbid=" + urpcbid + " ]";
    }
    
}

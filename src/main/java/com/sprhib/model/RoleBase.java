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
@Table(name = "ROLE_BASE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RoleBase.findAll", query = "SELECT r FROM RoleBase r"),
    @NamedQuery(name = "RoleBase.findByRid", query = "SELECT r FROM RoleBase r WHERE r.rid = :rid"),
    @NamedQuery(name = "RoleBase.findByRoleName", query = "SELECT r FROM RoleBase r WHERE r.roleName = :roleName"),
    @NamedQuery(name = "RoleBase.findByRoleLabel", query = "SELECT r FROM RoleBase r WHERE r.roleLabel = :roleLabel"),
    @NamedQuery(name = "RoleBase.findByRoleDescription", query = "SELECT r FROM RoleBase r WHERE r.roleDescription = :roleDescription"),
    @NamedQuery(name = "RoleBase.findByLevel", query = "SELECT r FROM RoleBase r WHERE r.level = :level"),
    @NamedQuery(name = "RoleBase.findByEditflag", query = "SELECT r FROM RoleBase r WHERE r.editflag = :editflag"),
    @NamedQuery(name = "RoleBase.findByDeleteflag", query = "SELECT r FROM RoleBase r WHERE r.deleteflag = :deleteflag")})
public class RoleBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RID")
    private Integer rid;
    @Basic(optional = false)
    @Column(name = "ROLE_NAME")
    private String roleName;
    @Basic(optional = false)
    @Column(name = "ROLE_LABEL")
    private String roleLabel;
    @Column(name = "ROLE_DESCRIPTION")
    private String roleDescription;
    @Column(name = "LEVEL")
    private Integer level;
    @Column(name = "EDITFLAG")
    private Short editflag;
    @Column(name = "DELETEFLAG")
    private Short deleteflag;

    public RoleBase() {
    }

    public RoleBase(Integer rid) {
        this.rid = rid;
    }

    public RoleBase(Integer rid, String roleName, String roleLabel) {
        this.rid = rid;
        this.roleName = roleName;
        this.roleLabel = roleLabel;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleLabel() {
        return roleLabel;
    }

    public void setRoleLabel(String roleLabel) {
        this.roleLabel = roleLabel;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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
        hash += (rid != null ? rid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleBase)) {
            return false;
        }
        RoleBase other = (RoleBase) object;
        if ((this.rid == null && other.rid != null) || (this.rid != null && !this.rid.equals(other.rid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.RoleBase[ rid=" + rid + " ]";
    }
    
}

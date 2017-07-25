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
@Table(name = "USR_BASE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsrBase.findAll", query = "SELECT u FROM UsrBase u"),
    @NamedQuery(name = "UsrBase.findByUid", query = "SELECT u FROM UsrBase u WHERE u.uid = :uid"),
    @NamedQuery(name = "UsrBase.findByNtId", query = "SELECT u FROM UsrBase u WHERE u.ntId = :ntId"),
    @NamedQuery(name = "UsrBase.findByNtDomain", query = "SELECT u FROM UsrBase u WHERE u.ntDomain = :ntDomain"),
    @NamedQuery(name = "UsrBase.findByFirstName", query = "SELECT u FROM UsrBase u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "UsrBase.findByMiddleName", query = "SELECT u FROM UsrBase u WHERE u.middleName = :middleName"),
    @NamedQuery(name = "UsrBase.findByLastName", query = "SELECT u FROM UsrBase u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "UsrBase.findByIsActive", query = "SELECT u FROM UsrBase u WHERE u.isActive = :isActive"),
    @NamedQuery(name = "UsrBase.findByEditflag", query = "SELECT u FROM UsrBase u WHERE u.editflag = :editflag"),
    @NamedQuery(name = "UsrBase.findByDeleteflag", query = "SELECT u FROM UsrBase u WHERE u.deleteflag = :deleteflag")})
public class UsrBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UID")
    private Integer uid;
    @Basic(optional = false)
    @Column(name = "NT_ID")
    private String ntId;
    @Column(name = "NT_DOMAIN")
    private String ntDomain;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "MIDDLE_NAME")
    private String middleName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "IS_ACTIVE")
    private Character isActive;
    @Column(name = "EDITFLAG")
    private Short editflag;
    @Column(name = "DELETEFLAG")
    private Short deleteflag;
    @JoinColumn(name = "BID", referencedColumnName = "BID")
    @ManyToOne(optional = false)
    private BranchBase bid;

    public UsrBase() {
    }

    public UsrBase(Integer uid) {
        this.uid = uid;
    }

    public UsrBase(Integer uid, String ntId, Character isActive) {
        this.uid = uid;
        this.ntId = ntId;
        this.isActive = isActive;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getNtId() {
        return ntId;
    }

    public void setNtId(String ntId) {
        this.ntId = ntId;
    }

    public String getNtDomain() {
        return ntDomain;
    }

    public void setNtDomain(String ntDomain) {
        this.ntDomain = ntDomain;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
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

    public BranchBase getBid() {
        return bid;
    }

    public void setBid(BranchBase bid) {
        this.bid = bid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uid != null ? uid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsrBase)) {
            return false;
        }
        UsrBase other = (UsrBase) object;
        if ((this.uid == null && other.uid != null) || (this.uid != null && !this.uid.equals(other.uid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.UsrBase[ uid=" + uid + " ]";
    }
    
}

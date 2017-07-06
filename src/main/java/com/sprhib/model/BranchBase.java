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
import javax.persistence.Id;
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
@Table(name = "BRANCH_BASE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BranchBase.findAll", query = "SELECT b FROM BranchBase b"),
    @NamedQuery(name = "BranchBase.findByBid", query = "SELECT b FROM BranchBase b WHERE b.bid = :bid"),
    @NamedQuery(name = "BranchBase.findByBranchCode", query = "SELECT b FROM BranchBase b WHERE b.branchCode = :branchCode"),
    @NamedQuery(name = "BranchBase.findByBranchName", query = "SELECT b FROM BranchBase b WHERE b.branchName = :branchName"),
    @NamedQuery(name = "BranchBase.findByBranchGrade", query = "SELECT b FROM BranchBase b WHERE b.branchGrade = :branchGrade"),
    @NamedQuery(name = "BranchBase.findByBranchContactNumber", query = "SELECT b FROM BranchBase b WHERE b.branchContactNumber = :branchContactNumber"),
    @NamedQuery(name = "BranchBase.findByEditflag", query = "SELECT b FROM BranchBase b WHERE b.editflag = :editflag"),
    @NamedQuery(name = "BranchBase.findByDeptFlag", query = "SELECT b FROM BranchBase b WHERE b.deptFlag = :deptFlag")})
public class BranchBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BID")
    private Integer bid;
    @Basic(optional = false)
    @Column(name = "BRANCH_CODE")
    private String branchCode;
    @Basic(optional = false)
    @Column(name = "BRANCH_NAME")
    private String branchName;
    @Basic(optional = false)
    @Column(name = "BRANCH_GRADE")
    private String branchGrade;
    @Column(name = "BRANCH_CONTACT_NUMBER")
    private String branchContactNumber;
    @Column(name = "EDITFLAG")
    private Short editflag;
    @Column(name = "DEPT_FLAG")
    private Short deptFlag;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bid")
    private Collection<AreaBranchMapping> areaBranchMappingCollection;

    public BranchBase() {
    }

    public BranchBase(Integer bid) {
        this.bid = bid;
    }

    public BranchBase(Integer bid, String branchCode, String branchName, String branchGrade) {
        this.bid = bid;
        this.branchCode = branchCode;
        this.branchName = branchName;
        this.branchGrade = branchGrade;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchGrade() {
        return branchGrade;
    }

    public void setBranchGrade(String branchGrade) {
        this.branchGrade = branchGrade;
    }

    public String getBranchContactNumber() {
        return branchContactNumber;
    }

    public void setBranchContactNumber(String branchContactNumber) {
        this.branchContactNumber = branchContactNumber;
    }

    public Short getEditflag() {
        return editflag;
    }

    public void setEditflag(Short editflag) {
        this.editflag = editflag;
    }

    public Short getDeptFlag() {
        return deptFlag;
    }

    public void setDeptFlag(Short deptFlag) {
        this.deptFlag = deptFlag;
    }

    @XmlTransient
    public Collection<AreaBranchMapping> getAreaBranchMappingCollection() {
        return areaBranchMappingCollection;
    }

    public void setAreaBranchMappingCollection(Collection<AreaBranchMapping> areaBranchMappingCollection) {
        this.areaBranchMappingCollection = areaBranchMappingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bid != null ? bid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BranchBase)) {
            return false;
        }
        BranchBase other = (BranchBase) object;
        if ((this.bid == null && other.bid != null) || (this.bid != null && !this.bid.equals(other.bid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.BranchBase[ bid=" + bid + " ]";
    }
    
}

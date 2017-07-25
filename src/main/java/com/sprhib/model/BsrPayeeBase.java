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
@Table(name = "BSR_PAYEE_BASE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BsrPayeeBase.findAll", query = "SELECT b FROM BsrPayeeBase b"),
    @NamedQuery(name = "BsrPayeeBase.findByPayeeId", query = "SELECT b FROM BsrPayeeBase b WHERE b.payeeId = :payeeId"),
    @NamedQuery(name = "BsrPayeeBase.findByPayee", query = "SELECT b FROM BsrPayeeBase b WHERE b.payee = :payee"),
    @NamedQuery(name = "BsrPayeeBase.findByPayeeType", query = "SELECT b FROM BsrPayeeBase b WHERE b.payeeType = :payeeType"),
    @NamedQuery(name = "BsrPayeeBase.findByTargetType", query = "SELECT b FROM BsrPayeeBase b WHERE b.targetType = :targetType"),
    @NamedQuery(name = "BsrPayeeBase.findByAccountNo", query = "SELECT b FROM BsrPayeeBase b WHERE b.accountNo = :accountNo"),
    @NamedQuery(name = "BsrPayeeBase.findByTargetDescription", query = "SELECT b FROM BsrPayeeBase b WHERE b.targetDescription = :targetDescription"),
    @NamedQuery(name = "BsrPayeeBase.findByFeePlan", query = "SELECT b FROM BsrPayeeBase b WHERE b.feePlan = :feePlan"),
    @NamedQuery(name = "BsrPayeeBase.findByCurrency", query = "SELECT b FROM BsrPayeeBase b WHERE b.currency = :currency"),
    @NamedQuery(name = "BsrPayeeBase.findByComprofDrAcSv", query = "SELECT b FROM BsrPayeeBase b WHERE b.comprofDrAcSv = :comprofDrAcSv"),
    @NamedQuery(name = "BsrPayeeBase.findByComprofDrAcDd", query = "SELECT b FROM BsrPayeeBase b WHERE b.comprofDrAcDd = :comprofDrAcDd")})
public class BsrPayeeBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PAYEE_ID")
    private Integer payeeId;
    @Basic(optional = false)
    @Column(name = "PAYEE")
    private String payee;
    @Basic(optional = false)
    @Column(name = "PAYEE_TYPE")
    private String payeeType;
    @Basic(optional = false)
    @Column(name = "TARGET_TYPE")
    private String targetType;
    @Basic(optional = false)
    @Column(name = "ACCOUNT_NO")
    private String accountNo;
    @Basic(optional = false)
    @Column(name = "TARGET_DESCRIPTION")
    private String targetDescription;
    @Basic(optional = false)
    @Column(name = "FEE_PLAN")
    private String feePlan;
    @Basic(optional = false)
    @Column(name = "CURRENCY")
    private String currency;
    @Column(name = "COMPROF_DR_AC_SV")
    private String comprofDrAcSv;
    @Column(name = "COMPROF_DR_AC_DD")
    private String comprofDrAcDd;

    public BsrPayeeBase() {
    }

    public BsrPayeeBase(Integer payeeId) {
        this.payeeId = payeeId;
    }

    public BsrPayeeBase(Integer payeeId, String payee, String payeeType, String targetType, String accountNo, String targetDescription, String feePlan, String currency) {
        this.payeeId = payeeId;
        this.payee = payee;
        this.payeeType = payeeType;
        this.targetType = targetType;
        this.accountNo = accountNo;
        this.targetDescription = targetDescription;
        this.feePlan = feePlan;
        this.currency = currency;
    }

    public Integer getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(Integer payeeId) {
        this.payeeId = payeeId;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getPayeeType() {
        return payeeType;
    }

    public void setPayeeType(String payeeType) {
        this.payeeType = payeeType;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getTargetDescription() {
        return targetDescription;
    }

    public void setTargetDescription(String targetDescription) {
        this.targetDescription = targetDescription;
    }

    public String getFeePlan() {
        return feePlan;
    }

    public void setFeePlan(String feePlan) {
        this.feePlan = feePlan;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getComprofDrAcSv() {
        return comprofDrAcSv;
    }

    public void setComprofDrAcSv(String comprofDrAcSv) {
        this.comprofDrAcSv = comprofDrAcSv;
    }

    public String getComprofDrAcDd() {
        return comprofDrAcDd;
    }

    public void setComprofDrAcDd(String comprofDrAcDd) {
        this.comprofDrAcDd = comprofDrAcDd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (payeeId != null ? payeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BsrPayeeBase)) {
            return false;
        }
        BsrPayeeBase other = (BsrPayeeBase) object;
        if ((this.payeeId == null && other.payeeId != null) || (this.payeeId != null && !this.payeeId.equals(other.payeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.BsrPayeeBase[ payeeId=" + payeeId + " ]";
    }
    
}

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
@Table(name = "BSR_BANK_BRANCH_BASE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BsrBankBranchBase.findAll", query = "SELECT b FROM BsrBankBranchBase b"),
    @NamedQuery(name = "BsrBankBranchBase.findByBbId", query = "SELECT b FROM BsrBankBranchBase b WHERE b.bbId = :bbId"),
    @NamedQuery(name = "BsrBankBranchBase.findByBankCode", query = "SELECT b FROM BsrBankBranchBase b WHERE b.bankCode = :bankCode"),
    @NamedQuery(name = "BsrBankBranchBase.findByBankName", query = "SELECT b FROM BsrBankBranchBase b WHERE b.bankName = :bankName"),
    @NamedQuery(name = "BsrBankBranchBase.findByBankNameDisplay", query = "SELECT b FROM BsrBankBranchBase b WHERE b.bankNameDisplay = :bankNameDisplay"),
    @NamedQuery(name = "BsrBankBranchBase.findByBranchCode", query = "SELECT b FROM BsrBankBranchBase b WHERE b.branchCode = :branchCode"),
    @NamedQuery(name = "BsrBankBranchBase.findByBranchName", query = "SELECT b FROM BsrBankBranchBase b WHERE b.branchName = :branchName"),
    @NamedQuery(name = "BsrBankBranchBase.findByBranchNameDisplay", query = "SELECT b FROM BsrBankBranchBase b WHERE b.branchNameDisplay = :branchNameDisplay")})
public class BsrBankBranchBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BB_ID")
    private Integer bbId;
    @Basic(optional = false)
    @Column(name = "BANK_CODE")
    private String bankCode;
    @Basic(optional = false)
    @Column(name = "BANK_NAME")
    private String bankName;
    @Basic(optional = false)
    @Column(name = "BANK_NAME_DISPLAY")
    private String bankNameDisplay;
    @Basic(optional = false)
    @Column(name = "BRANCH_CODE")
    private String branchCode;
    @Basic(optional = false)
    @Column(name = "BRANCH_NAME")
    private String branchName;
    @Basic(optional = false)
    @Column(name = "BRANCH_NAME_DISPLAY")
    private String branchNameDisplay;

    public BsrBankBranchBase() {
    }

    public BsrBankBranchBase(Integer bbId) {
        this.bbId = bbId;
    }

    public BsrBankBranchBase(Integer bbId, String bankCode, String bankName, String bankNameDisplay, String branchCode, String branchName, String branchNameDisplay) {
        this.bbId = bbId;
        this.bankCode = bankCode;
        this.bankName = bankName;
        this.bankNameDisplay = bankNameDisplay;
        this.branchCode = branchCode;
        this.branchName = branchName;
        this.branchNameDisplay = branchNameDisplay;
    }

    public Integer getBbId() {
        return bbId;
    }

    public void setBbId(Integer bbId) {
        this.bbId = bbId;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankNameDisplay() {
        return bankNameDisplay;
    }

    public void setBankNameDisplay(String bankNameDisplay) {
        this.bankNameDisplay = bankNameDisplay;
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

    public String getBranchNameDisplay() {
        return branchNameDisplay;
    }

    public void setBranchNameDisplay(String branchNameDisplay) {
        this.branchNameDisplay = branchNameDisplay;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bbId != null ? bbId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BsrBankBranchBase)) {
            return false;
        }
        BsrBankBranchBase other = (BsrBankBranchBase) object;
        if ((this.bbId == null && other.bbId != null) || (this.bbId != null && !this.bbId.equals(other.bbId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.BsrBankBranchBase[ bbId=" + bbId + " ]";
    }
    
}

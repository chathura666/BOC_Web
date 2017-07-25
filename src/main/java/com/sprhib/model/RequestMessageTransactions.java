/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author it207432
 */
@Entity
@Table(name = "REQUEST_MESSAGE_TRANSACTIONS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequestMessageTransactions.findAll", query = "SELECT r FROM RequestMessageTransactions r"),
    @NamedQuery(name = "RequestMessageTransactions.findByTransactionId", query = "SELECT r FROM RequestMessageTransactions r WHERE r.transactionId = :transactionId"),
    @NamedQuery(name = "RequestMessageTransactions.findByWfRefNo", query = "SELECT r FROM RequestMessageTransactions r WHERE r.wfRefNo = :wfRefNo"),
    @NamedQuery(name = "RequestMessageTransactions.findByWobNo", query = "SELECT r FROM RequestMessageTransactions r WHERE r.wobNo = :wobNo"),
    @NamedQuery(name = "RequestMessageTransactions.findByBranchCode", query = "SELECT r FROM RequestMessageTransactions r WHERE r.branchCode = :branchCode"),
    @NamedQuery(name = "RequestMessageTransactions.findByProductCode", query = "SELECT r FROM RequestMessageTransactions r WHERE r.productCode = :productCode"),
    @NamedQuery(name = "RequestMessageTransactions.findByResponseActivityName", query = "SELECT r FROM RequestMessageTransactions r WHERE r.responseActivityName = :responseActivityName"),
    @NamedQuery(name = "RequestMessageTransactions.findByMapName", query = "SELECT r FROM RequestMessageTransactions r WHERE r.mapName = :mapName"),
    @NamedQuery(name = "RequestMessageTransactions.findByServiceStatusCode", query = "SELECT r FROM RequestMessageTransactions r WHERE r.serviceStatusCode = :serviceStatusCode"),
    @NamedQuery(name = "RequestMessageTransactions.findByServiceStatusDesc", query = "SELECT r FROM RequestMessageTransactions r WHERE r.serviceStatusDesc = :serviceStatusDesc"),
    @NamedQuery(name = "RequestMessageTransactions.findByMessageStatusCode", query = "SELECT r FROM RequestMessageTransactions r WHERE r.messageStatusCode = :messageStatusCode"),
    @NamedQuery(name = "RequestMessageTransactions.findByMessageStatusDesc", query = "SELECT r FROM RequestMessageTransactions r WHERE r.messageStatusDesc = :messageStatusDesc"),
    @NamedQuery(name = "RequestMessageTransactions.findByRetry", query = "SELECT r FROM RequestMessageTransactions r WHERE r.retry = :retry"),
    @NamedQuery(name = "RequestMessageTransactions.findByClassName", query = "SELECT r FROM RequestMessageTransactions r WHERE r.className = :className"),
    @NamedQuery(name = "RequestMessageTransactions.findByCasetype", query = "SELECT r FROM RequestMessageTransactions r WHERE r.casetype = :casetype"),
    @NamedQuery(name = "RequestMessageTransactions.findByLoanAccountNumber", query = "SELECT r FROM RequestMessageTransactions r WHERE r.loanAccountNumber = :loanAccountNumber"),
    @NamedQuery(name = "RequestMessageTransactions.findByTransactionDate", query = "SELECT r FROM RequestMessageTransactions r WHERE r.transactionDate = :transactionDate")})
public class RequestMessageTransactions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TRANSACTION_ID")
    private Integer transactionId;
    @Basic(optional = false)
    @Column(name = "WF_REF_NO")
    private String wfRefNo;
    @Column(name = "WOB_NO")
    private String wobNo;
    @Column(name = "BRANCH_CODE")
    private String branchCode;
    @Column(name = "PRODUCT_CODE")
    private String productCode;
    @Lob
    @Column(name = "REQUEST_XML")
    private Serializable requestXml;
    @Column(name = "RESPONSE_ACTIVITY_NAME")
    private String responseActivityName;
    @Column(name = "MAP_NAME")
    private String mapName;
    @Column(name = "SERVICE_STATUS_CODE")
    private String serviceStatusCode;
    @Column(name = "SERVICE_STATUS_DESC")
    private String serviceStatusDesc;
    @Column(name = "MESSAGE_STATUS_CODE")
    private String messageStatusCode;
    @Column(name = "MESSAGE_STATUS_DESC")
    private String messageStatusDesc;
    @Column(name = "RETRY")
    private String retry;
    @Column(name = "CLASS_NAME")
    private String className;
    @Column(name = "CASETYPE")
    private String casetype;
    @Column(name = "LOAN_ACCOUNT_NUMBER")
    private String loanAccountNumber;
    @Basic(optional = false)
    @Column(name = "TRANSACTION_DATE")
    @Temporal(TemporalType.DATE)
    private Date transactionDate;

    public RequestMessageTransactions() {
    }

    public RequestMessageTransactions(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public RequestMessageTransactions(Integer transactionId, String wfRefNo, Date transactionDate) {
        this.transactionId = transactionId;
        this.wfRefNo = wfRefNo;
        this.transactionDate = transactionDate;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getWfRefNo() {
        return wfRefNo;
    }

    public void setWfRefNo(String wfRefNo) {
        this.wfRefNo = wfRefNo;
    }

    public String getWobNo() {
        return wobNo;
    }

    public void setWobNo(String wobNo) {
        this.wobNo = wobNo;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Serializable getRequestXml() {
        return requestXml;
    }

    public void setRequestXml(Serializable requestXml) {
        this.requestXml = requestXml;
    }

    public String getResponseActivityName() {
        return responseActivityName;
    }

    public void setResponseActivityName(String responseActivityName) {
        this.responseActivityName = responseActivityName;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public String getServiceStatusCode() {
        return serviceStatusCode;
    }

    public void setServiceStatusCode(String serviceStatusCode) {
        this.serviceStatusCode = serviceStatusCode;
    }

    public String getServiceStatusDesc() {
        return serviceStatusDesc;
    }

    public void setServiceStatusDesc(String serviceStatusDesc) {
        this.serviceStatusDesc = serviceStatusDesc;
    }

    public String getMessageStatusCode() {
        return messageStatusCode;
    }

    public void setMessageStatusCode(String messageStatusCode) {
        this.messageStatusCode = messageStatusCode;
    }

    public String getMessageStatusDesc() {
        return messageStatusDesc;
    }

    public void setMessageStatusDesc(String messageStatusDesc) {
        this.messageStatusDesc = messageStatusDesc;
    }

    public String getRetry() {
        return retry;
    }

    public void setRetry(String retry) {
        this.retry = retry;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getCasetype() {
        return casetype;
    }

    public void setCasetype(String casetype) {
        this.casetype = casetype;
    }

    public String getLoanAccountNumber() {
        return loanAccountNumber;
    }

    public void setLoanAccountNumber(String loanAccountNumber) {
        this.loanAccountNumber = loanAccountNumber;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionId != null ? transactionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequestMessageTransactions)) {
            return false;
        }
        RequestMessageTransactions other = (RequestMessageTransactions) object;
        if ((this.transactionId == null && other.transactionId != null) || (this.transactionId != null && !this.transactionId.equals(other.transactionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.RequestMessageTransactions[ transactionId=" + transactionId + " ]";
    }
    
}

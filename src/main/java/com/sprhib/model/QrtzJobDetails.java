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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
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
@Table(name = "QRTZ_JOB_DETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QrtzJobDetails.findAll", query = "SELECT q FROM QrtzJobDetails q"),
    @NamedQuery(name = "QrtzJobDetails.findByJobName", query = "SELECT q FROM QrtzJobDetails q WHERE q.qrtzJobDetailsPK.jobName = :jobName"),
    @NamedQuery(name = "QrtzJobDetails.findByJobGroup", query = "SELECT q FROM QrtzJobDetails q WHERE q.qrtzJobDetailsPK.jobGroup = :jobGroup"),
    @NamedQuery(name = "QrtzJobDetails.findByDescription", query = "SELECT q FROM QrtzJobDetails q WHERE q.description = :description"),
    @NamedQuery(name = "QrtzJobDetails.findByJobClassName", query = "SELECT q FROM QrtzJobDetails q WHERE q.jobClassName = :jobClassName"),
    @NamedQuery(name = "QrtzJobDetails.findByIsDurable", query = "SELECT q FROM QrtzJobDetails q WHERE q.isDurable = :isDurable"),
    @NamedQuery(name = "QrtzJobDetails.findByIsVolatile", query = "SELECT q FROM QrtzJobDetails q WHERE q.isVolatile = :isVolatile"),
    @NamedQuery(name = "QrtzJobDetails.findByIsStateful", query = "SELECT q FROM QrtzJobDetails q WHERE q.isStateful = :isStateful"),
    @NamedQuery(name = "QrtzJobDetails.findByRequestsRecovery", query = "SELECT q FROM QrtzJobDetails q WHERE q.requestsRecovery = :requestsRecovery")})
public class QrtzJobDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected QrtzJobDetailsPK qrtzJobDetailsPK;
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @Column(name = "JOB_CLASS_NAME")
    private String jobClassName;
    @Basic(optional = false)
    @Column(name = "IS_DURABLE")
    private String isDurable;
    @Basic(optional = false)
    @Column(name = "IS_VOLATILE")
    private String isVolatile;
    @Basic(optional = false)
    @Column(name = "IS_STATEFUL")
    private String isStateful;
    @Basic(optional = false)
    @Column(name = "REQUESTS_RECOVERY")
    private String requestsRecovery;
    @Lob
    @Column(name = "JOB_DATA")
    private Serializable jobData;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "qrtzJobDetails")
    private Collection<QrtzTriggers> qrtzTriggersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "qrtzJobDetails")
    private Collection<QrtzJobListeners> qrtzJobListenersCollection;

    public QrtzJobDetails() {
    }

    public QrtzJobDetails(QrtzJobDetailsPK qrtzJobDetailsPK) {
        this.qrtzJobDetailsPK = qrtzJobDetailsPK;
    }

    public QrtzJobDetails(QrtzJobDetailsPK qrtzJobDetailsPK, String jobClassName, String isDurable, String isVolatile, String isStateful, String requestsRecovery) {
        this.qrtzJobDetailsPK = qrtzJobDetailsPK;
        this.jobClassName = jobClassName;
        this.isDurable = isDurable;
        this.isVolatile = isVolatile;
        this.isStateful = isStateful;
        this.requestsRecovery = requestsRecovery;
    }

    public QrtzJobDetails(String jobName, String jobGroup) {
        this.qrtzJobDetailsPK = new QrtzJobDetailsPK(jobName, jobGroup);
    }

    public QrtzJobDetailsPK getQrtzJobDetailsPK() {
        return qrtzJobDetailsPK;
    }

    public void setQrtzJobDetailsPK(QrtzJobDetailsPK qrtzJobDetailsPK) {
        this.qrtzJobDetailsPK = qrtzJobDetailsPK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJobClassName() {
        return jobClassName;
    }

    public void setJobClassName(String jobClassName) {
        this.jobClassName = jobClassName;
    }

    public String getIsDurable() {
        return isDurable;
    }

    public void setIsDurable(String isDurable) {
        this.isDurable = isDurable;
    }

    public String getIsVolatile() {
        return isVolatile;
    }

    public void setIsVolatile(String isVolatile) {
        this.isVolatile = isVolatile;
    }

    public String getIsStateful() {
        return isStateful;
    }

    public void setIsStateful(String isStateful) {
        this.isStateful = isStateful;
    }

    public String getRequestsRecovery() {
        return requestsRecovery;
    }

    public void setRequestsRecovery(String requestsRecovery) {
        this.requestsRecovery = requestsRecovery;
    }

    public Serializable getJobData() {
        return jobData;
    }

    public void setJobData(Serializable jobData) {
        this.jobData = jobData;
    }

    @XmlTransient
    public Collection<QrtzTriggers> getQrtzTriggersCollection() {
        return qrtzTriggersCollection;
    }

    public void setQrtzTriggersCollection(Collection<QrtzTriggers> qrtzTriggersCollection) {
        this.qrtzTriggersCollection = qrtzTriggersCollection;
    }

    @XmlTransient
    public Collection<QrtzJobListeners> getQrtzJobListenersCollection() {
        return qrtzJobListenersCollection;
    }

    public void setQrtzJobListenersCollection(Collection<QrtzJobListeners> qrtzJobListenersCollection) {
        this.qrtzJobListenersCollection = qrtzJobListenersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (qrtzJobDetailsPK != null ? qrtzJobDetailsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QrtzJobDetails)) {
            return false;
        }
        QrtzJobDetails other = (QrtzJobDetails) object;
        if ((this.qrtzJobDetailsPK == null && other.qrtzJobDetailsPK != null) || (this.qrtzJobDetailsPK != null && !this.qrtzJobDetailsPK.equals(other.qrtzJobDetailsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.QrtzJobDetails[ qrtzJobDetailsPK=" + qrtzJobDetailsPK + " ]";
    }
    
}

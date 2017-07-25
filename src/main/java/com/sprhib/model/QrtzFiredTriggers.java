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
@Table(name = "QRTZ_FIRED_TRIGGERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QrtzFiredTriggers.findAll", query = "SELECT q FROM QrtzFiredTriggers q"),
    @NamedQuery(name = "QrtzFiredTriggers.findByEntryId", query = "SELECT q FROM QrtzFiredTriggers q WHERE q.entryId = :entryId"),
    @NamedQuery(name = "QrtzFiredTriggers.findByTriggerName", query = "SELECT q FROM QrtzFiredTriggers q WHERE q.triggerName = :triggerName"),
    @NamedQuery(name = "QrtzFiredTriggers.findByTriggerGroup", query = "SELECT q FROM QrtzFiredTriggers q WHERE q.triggerGroup = :triggerGroup"),
    @NamedQuery(name = "QrtzFiredTriggers.findByIsVolatile", query = "SELECT q FROM QrtzFiredTriggers q WHERE q.isVolatile = :isVolatile"),
    @NamedQuery(name = "QrtzFiredTriggers.findByInstanceName", query = "SELECT q FROM QrtzFiredTriggers q WHERE q.instanceName = :instanceName"),
    @NamedQuery(name = "QrtzFiredTriggers.findByFiredTime", query = "SELECT q FROM QrtzFiredTriggers q WHERE q.firedTime = :firedTime"),
    @NamedQuery(name = "QrtzFiredTriggers.findByPriority", query = "SELECT q FROM QrtzFiredTriggers q WHERE q.priority = :priority"),
    @NamedQuery(name = "QrtzFiredTriggers.findByState", query = "SELECT q FROM QrtzFiredTriggers q WHERE q.state = :state"),
    @NamedQuery(name = "QrtzFiredTriggers.findByJobName", query = "SELECT q FROM QrtzFiredTriggers q WHERE q.jobName = :jobName"),
    @NamedQuery(name = "QrtzFiredTriggers.findByJobGroup", query = "SELECT q FROM QrtzFiredTriggers q WHERE q.jobGroup = :jobGroup"),
    @NamedQuery(name = "QrtzFiredTriggers.findByIsStateful", query = "SELECT q FROM QrtzFiredTriggers q WHERE q.isStateful = :isStateful"),
    @NamedQuery(name = "QrtzFiredTriggers.findByRequestsRecovery", query = "SELECT q FROM QrtzFiredTriggers q WHERE q.requestsRecovery = :requestsRecovery")})
public class QrtzFiredTriggers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ENTRY_ID")
    private String entryId;
    @Basic(optional = false)
    @Column(name = "TRIGGER_NAME")
    private String triggerName;
    @Basic(optional = false)
    @Column(name = "TRIGGER_GROUP")
    private String triggerGroup;
    @Basic(optional = false)
    @Column(name = "IS_VOLATILE")
    private String isVolatile;
    @Basic(optional = false)
    @Column(name = "INSTANCE_NAME")
    private String instanceName;
    @Basic(optional = false)
    @Column(name = "FIRED_TIME")
    private long firedTime;
    @Basic(optional = false)
    @Column(name = "PRIORITY")
    private int priority;
    @Basic(optional = false)
    @Column(name = "STATE")
    private String state;
    @Column(name = "JOB_NAME")
    private String jobName;
    @Column(name = "JOB_GROUP")
    private String jobGroup;
    @Column(name = "IS_STATEFUL")
    private String isStateful;
    @Column(name = "REQUESTS_RECOVERY")
    private String requestsRecovery;

    public QrtzFiredTriggers() {
    }

    public QrtzFiredTriggers(String entryId) {
        this.entryId = entryId;
    }

    public QrtzFiredTriggers(String entryId, String triggerName, String triggerGroup, String isVolatile, String instanceName, long firedTime, int priority, String state) {
        this.entryId = entryId;
        this.triggerName = triggerName;
        this.triggerGroup = triggerGroup;
        this.isVolatile = isVolatile;
        this.instanceName = instanceName;
        this.firedTime = firedTime;
        this.priority = priority;
        this.state = state;
    }

    public String getEntryId() {
        return entryId;
    }

    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTriggerGroup() {
        return triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    public String getIsVolatile() {
        return isVolatile;
    }

    public void setIsVolatile(String isVolatile) {
        this.isVolatile = isVolatile;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public long getFiredTime() {
        return firedTime;
    }

    public void setFiredTime(long firedTime) {
        this.firedTime = firedTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entryId != null ? entryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QrtzFiredTriggers)) {
            return false;
        }
        QrtzFiredTriggers other = (QrtzFiredTriggers) object;
        if ((this.entryId == null && other.entryId != null) || (this.entryId != null && !this.entryId.equals(other.entryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.QrtzFiredTriggers[ entryId=" + entryId + " ]";
    }
    
}

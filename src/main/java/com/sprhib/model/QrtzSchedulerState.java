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
@Table(name = "QRTZ_SCHEDULER_STATE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QrtzSchedulerState.findAll", query = "SELECT q FROM QrtzSchedulerState q"),
    @NamedQuery(name = "QrtzSchedulerState.findByInstanceName", query = "SELECT q FROM QrtzSchedulerState q WHERE q.instanceName = :instanceName"),
    @NamedQuery(name = "QrtzSchedulerState.findByLastCheckinTime", query = "SELECT q FROM QrtzSchedulerState q WHERE q.lastCheckinTime = :lastCheckinTime"),
    @NamedQuery(name = "QrtzSchedulerState.findByCheckinInterval", query = "SELECT q FROM QrtzSchedulerState q WHERE q.checkinInterval = :checkinInterval")})
public class QrtzSchedulerState implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "INSTANCE_NAME")
    private String instanceName;
    @Basic(optional = false)
    @Column(name = "LAST_CHECKIN_TIME")
    private long lastCheckinTime;
    @Basic(optional = false)
    @Column(name = "CHECKIN_INTERVAL")
    private long checkinInterval;

    public QrtzSchedulerState() {
    }

    public QrtzSchedulerState(String instanceName) {
        this.instanceName = instanceName;
    }

    public QrtzSchedulerState(String instanceName, long lastCheckinTime, long checkinInterval) {
        this.instanceName = instanceName;
        this.lastCheckinTime = lastCheckinTime;
        this.checkinInterval = checkinInterval;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public long getLastCheckinTime() {
        return lastCheckinTime;
    }

    public void setLastCheckinTime(long lastCheckinTime) {
        this.lastCheckinTime = lastCheckinTime;
    }

    public long getCheckinInterval() {
        return checkinInterval;
    }

    public void setCheckinInterval(long checkinInterval) {
        this.checkinInterval = checkinInterval;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (instanceName != null ? instanceName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QrtzSchedulerState)) {
            return false;
        }
        QrtzSchedulerState other = (QrtzSchedulerState) object;
        if ((this.instanceName == null && other.instanceName != null) || (this.instanceName != null && !this.instanceName.equals(other.instanceName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.QrtzSchedulerState[ instanceName=" + instanceName + " ]";
    }
    
}

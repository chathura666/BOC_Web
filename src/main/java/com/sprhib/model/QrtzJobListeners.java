/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "QRTZ_JOB_LISTENERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QrtzJobListeners.findAll", query = "SELECT q FROM QrtzJobListeners q"),
    @NamedQuery(name = "QrtzJobListeners.findByJobName", query = "SELECT q FROM QrtzJobListeners q WHERE q.qrtzJobListenersPK.jobName = :jobName"),
    @NamedQuery(name = "QrtzJobListeners.findByJobGroup", query = "SELECT q FROM QrtzJobListeners q WHERE q.qrtzJobListenersPK.jobGroup = :jobGroup"),
    @NamedQuery(name = "QrtzJobListeners.findByJobListener", query = "SELECT q FROM QrtzJobListeners q WHERE q.qrtzJobListenersPK.jobListener = :jobListener")})
public class QrtzJobListeners implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected QrtzJobListenersPK qrtzJobListenersPK;
    @JoinColumns({
        @JoinColumn(name = "JOB_NAME", referencedColumnName = "JOB_NAME", insertable = false, updatable = false),
        @JoinColumn(name = "JOB_GROUP", referencedColumnName = "JOB_GROUP", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private QrtzJobDetails qrtzJobDetails;

    public QrtzJobListeners() {
    }

    public QrtzJobListeners(QrtzJobListenersPK qrtzJobListenersPK) {
        this.qrtzJobListenersPK = qrtzJobListenersPK;
    }

    public QrtzJobListeners(String jobName, String jobGroup, String jobListener) {
        this.qrtzJobListenersPK = new QrtzJobListenersPK(jobName, jobGroup, jobListener);
    }

    public QrtzJobListenersPK getQrtzJobListenersPK() {
        return qrtzJobListenersPK;
    }

    public void setQrtzJobListenersPK(QrtzJobListenersPK qrtzJobListenersPK) {
        this.qrtzJobListenersPK = qrtzJobListenersPK;
    }

    public QrtzJobDetails getQrtzJobDetails() {
        return qrtzJobDetails;
    }

    public void setQrtzJobDetails(QrtzJobDetails qrtzJobDetails) {
        this.qrtzJobDetails = qrtzJobDetails;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (qrtzJobListenersPK != null ? qrtzJobListenersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QrtzJobListeners)) {
            return false;
        }
        QrtzJobListeners other = (QrtzJobListeners) object;
        if ((this.qrtzJobListenersPK == null && other.qrtzJobListenersPK != null) || (this.qrtzJobListenersPK != null && !this.qrtzJobListenersPK.equals(other.qrtzJobListenersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.QrtzJobListeners[ qrtzJobListenersPK=" + qrtzJobListenersPK + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author it207432
 */
@Entity
@Table(name = "QRTZ_CRON_TRIGGERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QrtzCronTriggers.findAll", query = "SELECT q FROM QrtzCronTriggers q"),
    @NamedQuery(name = "QrtzCronTriggers.findByTriggerName", query = "SELECT q FROM QrtzCronTriggers q WHERE q.qrtzCronTriggersPK.triggerName = :triggerName"),
    @NamedQuery(name = "QrtzCronTriggers.findByTriggerGroup", query = "SELECT q FROM QrtzCronTriggers q WHERE q.qrtzCronTriggersPK.triggerGroup = :triggerGroup"),
    @NamedQuery(name = "QrtzCronTriggers.findByCronExpression", query = "SELECT q FROM QrtzCronTriggers q WHERE q.cronExpression = :cronExpression"),
    @NamedQuery(name = "QrtzCronTriggers.findByTimeZoneId", query = "SELECT q FROM QrtzCronTriggers q WHERE q.timeZoneId = :timeZoneId")})
public class QrtzCronTriggers implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected QrtzCronTriggersPK qrtzCronTriggersPK;
    @Basic(optional = false)
    @Column(name = "CRON_EXPRESSION")
    private String cronExpression;
    @Column(name = "TIME_ZONE_ID")
    private String timeZoneId;
    @JoinColumns({
        @JoinColumn(name = "TRIGGER_NAME", referencedColumnName = "TRIGGER_NAME", insertable = false, updatable = false),
        @JoinColumn(name = "TRIGGER_GROUP", referencedColumnName = "TRIGGER_GROUP", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private QrtzTriggers qrtzTriggers;

    public QrtzCronTriggers() {
    }

    public QrtzCronTriggers(QrtzCronTriggersPK qrtzCronTriggersPK) {
        this.qrtzCronTriggersPK = qrtzCronTriggersPK;
    }

    public QrtzCronTriggers(QrtzCronTriggersPK qrtzCronTriggersPK, String cronExpression) {
        this.qrtzCronTriggersPK = qrtzCronTriggersPK;
        this.cronExpression = cronExpression;
    }

    public QrtzCronTriggers(String triggerName, String triggerGroup) {
        this.qrtzCronTriggersPK = new QrtzCronTriggersPK(triggerName, triggerGroup);
    }

    public QrtzCronTriggersPK getQrtzCronTriggersPK() {
        return qrtzCronTriggersPK;
    }

    public void setQrtzCronTriggersPK(QrtzCronTriggersPK qrtzCronTriggersPK) {
        this.qrtzCronTriggersPK = qrtzCronTriggersPK;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getTimeZoneId() {
        return timeZoneId;
    }

    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
    }

    public QrtzTriggers getQrtzTriggers() {
        return qrtzTriggers;
    }

    public void setQrtzTriggers(QrtzTriggers qrtzTriggers) {
        this.qrtzTriggers = qrtzTriggers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (qrtzCronTriggersPK != null ? qrtzCronTriggersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QrtzCronTriggers)) {
            return false;
        }
        QrtzCronTriggers other = (QrtzCronTriggers) object;
        if ((this.qrtzCronTriggersPK == null && other.qrtzCronTriggersPK != null) || (this.qrtzCronTriggersPK != null && !this.qrtzCronTriggersPK.equals(other.qrtzCronTriggersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.QrtzCronTriggers[ qrtzCronTriggersPK=" + qrtzCronTriggersPK + " ]";
    }
    
}

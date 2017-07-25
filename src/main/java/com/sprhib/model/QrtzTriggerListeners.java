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
@Table(name = "QRTZ_TRIGGER_LISTENERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QrtzTriggerListeners.findAll", query = "SELECT q FROM QrtzTriggerListeners q"),
    @NamedQuery(name = "QrtzTriggerListeners.findByTriggerName", query = "SELECT q FROM QrtzTriggerListeners q WHERE q.qrtzTriggerListenersPK.triggerName = :triggerName"),
    @NamedQuery(name = "QrtzTriggerListeners.findByTriggerGroup", query = "SELECT q FROM QrtzTriggerListeners q WHERE q.qrtzTriggerListenersPK.triggerGroup = :triggerGroup"),
    @NamedQuery(name = "QrtzTriggerListeners.findByTriggerListener", query = "SELECT q FROM QrtzTriggerListeners q WHERE q.qrtzTriggerListenersPK.triggerListener = :triggerListener")})
public class QrtzTriggerListeners implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected QrtzTriggerListenersPK qrtzTriggerListenersPK;
    @JoinColumns({
        @JoinColumn(name = "TRIGGER_NAME", referencedColumnName = "TRIGGER_NAME", insertable = false, updatable = false),
        @JoinColumn(name = "TRIGGER_GROUP", referencedColumnName = "TRIGGER_GROUP", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private QrtzTriggers qrtzTriggers;

    public QrtzTriggerListeners() {
    }

    public QrtzTriggerListeners(QrtzTriggerListenersPK qrtzTriggerListenersPK) {
        this.qrtzTriggerListenersPK = qrtzTriggerListenersPK;
    }

    public QrtzTriggerListeners(String triggerName, String triggerGroup, String triggerListener) {
        this.qrtzTriggerListenersPK = new QrtzTriggerListenersPK(triggerName, triggerGroup, triggerListener);
    }

    public QrtzTriggerListenersPK getQrtzTriggerListenersPK() {
        return qrtzTriggerListenersPK;
    }

    public void setQrtzTriggerListenersPK(QrtzTriggerListenersPK qrtzTriggerListenersPK) {
        this.qrtzTriggerListenersPK = qrtzTriggerListenersPK;
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
        hash += (qrtzTriggerListenersPK != null ? qrtzTriggerListenersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QrtzTriggerListeners)) {
            return false;
        }
        QrtzTriggerListeners other = (QrtzTriggerListeners) object;
        if ((this.qrtzTriggerListenersPK == null && other.qrtzTriggerListenersPK != null) || (this.qrtzTriggerListenersPK != null && !this.qrtzTriggerListenersPK.equals(other.qrtzTriggerListenersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.QrtzTriggerListeners[ qrtzTriggerListenersPK=" + qrtzTriggerListenersPK + " ]";
    }
    
}

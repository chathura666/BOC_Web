/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author it207432
 */
@Embeddable
public class QrtzTriggerListenersPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "TRIGGER_NAME")
    private String triggerName;
    @Basic(optional = false)
    @Column(name = "TRIGGER_GROUP")
    private String triggerGroup;
    @Basic(optional = false)
    @Column(name = "TRIGGER_LISTENER")
    private String triggerListener;

    public QrtzTriggerListenersPK() {
    }

    public QrtzTriggerListenersPK(String triggerName, String triggerGroup, String triggerListener) {
        this.triggerName = triggerName;
        this.triggerGroup = triggerGroup;
        this.triggerListener = triggerListener;
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

    public String getTriggerListener() {
        return triggerListener;
    }

    public void setTriggerListener(String triggerListener) {
        this.triggerListener = triggerListener;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (triggerName != null ? triggerName.hashCode() : 0);
        hash += (triggerGroup != null ? triggerGroup.hashCode() : 0);
        hash += (triggerListener != null ? triggerListener.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QrtzTriggerListenersPK)) {
            return false;
        }
        QrtzTriggerListenersPK other = (QrtzTriggerListenersPK) object;
        if ((this.triggerName == null && other.triggerName != null) || (this.triggerName != null && !this.triggerName.equals(other.triggerName))) {
            return false;
        }
        if ((this.triggerGroup == null && other.triggerGroup != null) || (this.triggerGroup != null && !this.triggerGroup.equals(other.triggerGroup))) {
            return false;
        }
        if ((this.triggerListener == null && other.triggerListener != null) || (this.triggerListener != null && !this.triggerListener.equals(other.triggerListener))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.QrtzTriggerListenersPK[ triggerName=" + triggerName + ", triggerGroup=" + triggerGroup + ", triggerListener=" + triggerListener + " ]";
    }
    
}

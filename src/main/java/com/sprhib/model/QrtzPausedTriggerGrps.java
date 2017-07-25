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
@Table(name = "QRTZ_PAUSED_TRIGGER_GRPS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QrtzPausedTriggerGrps.findAll", query = "SELECT q FROM QrtzPausedTriggerGrps q"),
    @NamedQuery(name = "QrtzPausedTriggerGrps.findByTriggerGroup", query = "SELECT q FROM QrtzPausedTriggerGrps q WHERE q.triggerGroup = :triggerGroup")})
public class QrtzPausedTriggerGrps implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TRIGGER_GROUP")
    private String triggerGroup;

    public QrtzPausedTriggerGrps() {
    }

    public QrtzPausedTriggerGrps(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    public String getTriggerGroup() {
        return triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (triggerGroup != null ? triggerGroup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QrtzPausedTriggerGrps)) {
            return false;
        }
        QrtzPausedTriggerGrps other = (QrtzPausedTriggerGrps) object;
        if ((this.triggerGroup == null && other.triggerGroup != null) || (this.triggerGroup != null && !this.triggerGroup.equals(other.triggerGroup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.QrtzPausedTriggerGrps[ triggerGroup=" + triggerGroup + " ]";
    }
    
}

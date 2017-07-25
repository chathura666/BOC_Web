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
@Table(name = "QRTZ_LOCKS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QrtzLocks.findAll", query = "SELECT q FROM QrtzLocks q"),
    @NamedQuery(name = "QrtzLocks.findByLockName", query = "SELECT q FROM QrtzLocks q WHERE q.lockName = :lockName")})
public class QrtzLocks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LOCK_NAME")
    private String lockName;

    public QrtzLocks() {
    }

    public QrtzLocks(String lockName) {
        this.lockName = lockName;
    }

    public String getLockName() {
        return lockName;
    }

    public void setLockName(String lockName) {
        this.lockName = lockName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lockName != null ? lockName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QrtzLocks)) {
            return false;
        }
        QrtzLocks other = (QrtzLocks) object;
        if ((this.lockName == null && other.lockName != null) || (this.lockName != null && !this.lockName.equals(other.lockName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.QrtzLocks[ lockName=" + lockName + " ]";
    }
    
}

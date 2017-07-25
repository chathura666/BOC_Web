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
public class QrtzJobListenersPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "JOB_NAME")
    private String jobName;
    @Basic(optional = false)
    @Column(name = "JOB_GROUP")
    private String jobGroup;
    @Basic(optional = false)
    @Column(name = "JOB_LISTENER")
    private String jobListener;

    public QrtzJobListenersPK() {
    }

    public QrtzJobListenersPK(String jobName, String jobGroup, String jobListener) {
        this.jobName = jobName;
        this.jobGroup = jobGroup;
        this.jobListener = jobListener;
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

    public String getJobListener() {
        return jobListener;
    }

    public void setJobListener(String jobListener) {
        this.jobListener = jobListener;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jobName != null ? jobName.hashCode() : 0);
        hash += (jobGroup != null ? jobGroup.hashCode() : 0);
        hash += (jobListener != null ? jobListener.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QrtzJobListenersPK)) {
            return false;
        }
        QrtzJobListenersPK other = (QrtzJobListenersPK) object;
        if ((this.jobName == null && other.jobName != null) || (this.jobName != null && !this.jobName.equals(other.jobName))) {
            return false;
        }
        if ((this.jobGroup == null && other.jobGroup != null) || (this.jobGroup != null && !this.jobGroup.equals(other.jobGroup))) {
            return false;
        }
        if ((this.jobListener == null && other.jobListener != null) || (this.jobListener != null && !this.jobListener.equals(other.jobListener))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.QrtzJobListenersPK[ jobName=" + jobName + ", jobGroup=" + jobGroup + ", jobListener=" + jobListener + " ]";
    }
    
}

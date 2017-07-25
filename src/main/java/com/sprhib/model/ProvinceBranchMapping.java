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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "PROVINCE_BRANCH_MAPPING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProvinceBranchMapping.findAll", query = "SELECT p FROM ProvinceBranchMapping p"),
    @NamedQuery(name = "ProvinceBranchMapping.findByProvinceBrId", query = "SELECT p FROM ProvinceBranchMapping p WHERE p.provinceBrId = :provinceBrId")})
public class ProvinceBranchMapping implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PROVINCE_BR_ID")
    private Integer provinceBrId;
    @JoinColumn(name = "PID", referencedColumnName = "PID")
    @ManyToOne(optional = false)
    private ProvinceBase pid;
    @JoinColumn(name = "BID", referencedColumnName = "BID")
    @ManyToOne(optional = false)
    private BranchBase bid;

    public ProvinceBranchMapping() {
    }

    public ProvinceBranchMapping(Integer provinceBrId) {
        this.provinceBrId = provinceBrId;
    }

    public Integer getProvinceBrId() {
        return provinceBrId;
    }

    public void setProvinceBrId(Integer provinceBrId) {
        this.provinceBrId = provinceBrId;
    }

    public ProvinceBase getPid() {
        return pid;
    }

    public void setPid(ProvinceBase pid) {
        this.pid = pid;
    }

    public BranchBase getBid() {
        return bid;
    }

    public void setBid(BranchBase bid) {
        this.bid = bid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (provinceBrId != null ? provinceBrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProvinceBranchMapping)) {
            return false;
        }
        ProvinceBranchMapping other = (ProvinceBranchMapping) object;
        if ((this.provinceBrId == null && other.provinceBrId != null) || (this.provinceBrId != null && !this.provinceBrId.equals(other.provinceBrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.ProvinceBranchMapping[ provinceBrId=" + provinceBrId + " ]";
    }
    
}

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
@Table(name = "RLC_BRANCH_MAPPING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RlcBranchMapping.findAll", query = "SELECT r FROM RlcBranchMapping r"),
    @NamedQuery(name = "RlcBranchMapping.findByRlcBrId", query = "SELECT r FROM RlcBranchMapping r WHERE r.rlcBrId = :rlcBrId")})
public class RlcBranchMapping implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RLC_BR_ID")
    private Integer rlcBrId;
    @JoinColumn(name = "RLC_ID", referencedColumnName = "RLC_ID")
    @ManyToOne(optional = false)
    private RlcBase rlcId;
    @JoinColumn(name = "BID", referencedColumnName = "BID")
    @ManyToOne(optional = false)
    private BranchBase bid;

    public RlcBranchMapping() {
    }

    public RlcBranchMapping(Integer rlcBrId) {
        this.rlcBrId = rlcBrId;
    }

    public Integer getRlcBrId() {
        return rlcBrId;
    }

    public void setRlcBrId(Integer rlcBrId) {
        this.rlcBrId = rlcBrId;
    }

    public RlcBase getRlcId() {
        return rlcId;
    }

    public void setRlcId(RlcBase rlcId) {
        this.rlcId = rlcId;
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
        hash += (rlcBrId != null ? rlcBrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RlcBranchMapping)) {
            return false;
        }
        RlcBranchMapping other = (RlcBranchMapping) object;
        if ((this.rlcBrId == null && other.rlcBrId != null) || (this.rlcBrId != null && !this.rlcBrId.equals(other.rlcBrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.RlcBranchMapping[ rlcBrId=" + rlcBrId + " ]";
    }
    
}

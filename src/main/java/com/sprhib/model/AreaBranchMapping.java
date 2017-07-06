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
@Table(name = "AREA_BRANCH_MAPPING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AreaBranchMapping.findAll", query = "SELECT a FROM AreaBranchMapping a"),
    @NamedQuery(name = "AreaBranchMapping.findByAreaBrId", query = "SELECT a FROM AreaBranchMapping a WHERE a.areaBrId = :areaBrId")})
public class AreaBranchMapping implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "AREA_BR_ID")
    private Integer areaBrId;
    @JoinColumn(name = "BID", referencedColumnName = "BID")
    @ManyToOne(optional = false)
    private BranchBase bid;
    @JoinColumn(name = "AID", referencedColumnName = "AID")
    @ManyToOne(optional = false)
    private AreaBase aid;

    public AreaBranchMapping() {
    }

    public AreaBranchMapping(Integer areaBrId) {
        this.areaBrId = areaBrId;
    }

    public Integer getAreaBrId() {
        return areaBrId;
    }

    public void setAreaBrId(Integer areaBrId) {
        this.areaBrId = areaBrId;
    }

    public BranchBase getBid() {
        return bid;
    }

    public void setBid(BranchBase bid) {
        this.bid = bid;
    }

    public AreaBase getAid() {
        return aid;
    }

    public void setAid(AreaBase aid) {
        this.aid = aid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (areaBrId != null ? areaBrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreaBranchMapping)) {
            return false;
        }
        
        AreaBranchMapping other = (AreaBranchMapping) object;
        if ((this.areaBrId == null && other.areaBrId != null) || (this.areaBrId != null && !this.areaBrId.equals(other.areaBrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.AreaBranchMapping[ areaBrId=" + areaBrId + " ]";
    }
    
}

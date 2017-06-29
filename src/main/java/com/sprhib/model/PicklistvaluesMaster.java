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
@Table(name = "PICKLISTVALUES_MASTER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PicklistvaluesMaster.findAll", query = "SELECT p FROM PicklistvaluesMaster p"),
    @NamedQuery(name = "PicklistvaluesMaster.findByPicklistId", query = "SELECT p FROM PicklistvaluesMaster p WHERE p.picklistId = :picklistId"),
    @NamedQuery(name = "PicklistvaluesMaster.findByPicklistCode", query = "SELECT p FROM PicklistvaluesMaster p WHERE p.picklistCode = :picklistCode"),
    @NamedQuery(name = "PicklistvaluesMaster.findByPickValue", query = "SELECT p FROM PicklistvaluesMaster p WHERE p.pickValue = :pickValue"),
    @NamedQuery(name = "PicklistvaluesMaster.findByPicklistName", query = "SELECT p FROM PicklistvaluesMaster p WHERE p.picklistName = :picklistName"),
    @NamedQuery(name = "PicklistvaluesMaster.findByPicklistFilter", query = "SELECT p FROM PicklistvaluesMaster p WHERE p.picklistFilter = :picklistFilter")})
public class PicklistvaluesMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PICKLIST_ID")
    private Integer picklistId;
    @Basic(optional = false)
    @Column(name = "PICKLIST_CODE")
    private String picklistCode;
    @Basic(optional = false)
    @Column(name = "PICK_VALUE")
    private String pickValue;
    @Basic(optional = false)
    @Column(name = "PICKLIST_NAME")
    private String picklistName;
    @Basic(optional = false)
    @Column(name = "PICKLIST_FILTER")
    private String picklistFilter;

    public PicklistvaluesMaster() {
    }

    public PicklistvaluesMaster(Integer picklistId) {
        this.picklistId = picklistId;
    }

    public PicklistvaluesMaster(Integer picklistId, String picklistCode, String pickValue, String picklistName, String picklistFilter) {
        this.picklistId = picklistId;
        this.picklistCode = picklistCode;
        this.pickValue = pickValue;
        this.picklistName = picklistName;
        this.picklistFilter = picklistFilter;
    }

    public Integer getPicklistId() {
        return picklistId;
    }

    public void setPicklistId(Integer picklistId) {
        this.picklistId = picklistId;
    }

    public String getPicklistCode() {
        return picklistCode;
    }

    public void setPicklistCode(String picklistCode) {
        this.picklistCode = picklistCode;
    }

    public String getPickValue() {
        return pickValue;
    }

    public void setPickValue(String pickValue) {
        this.pickValue = pickValue;
    }

    public String getPicklistName() {
        return picklistName;
    }

    public void setPicklistName(String picklistName) {
        this.picklistName = picklistName;
    }

    public String getPicklistFilter() {
        return picklistFilter;
    }

    public void setPicklistFilter(String picklistFilter) {
        this.picklistFilter = picklistFilter;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (picklistId != null ? picklistId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PicklistvaluesMaster)) {
            return false;
        }
        PicklistvaluesMaster other = (PicklistvaluesMaster) object;
        if ((this.picklistId == null && other.picklistId != null) || (this.picklistId != null && !this.picklistId.equals(other.picklistId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.PicklistvaluesMaster[ picklistId=" + picklistId + " ]";
    }
    
}

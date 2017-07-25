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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author it207432
 */
@Entity
@Table(name = "PRIVATE_EMPLOYER_BASE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrivateEmployerBase.findAll", query = "SELECT p FROM PrivateEmployerBase p"),
    @NamedQuery(name = "PrivateEmployerBase.findByEid", query = "SELECT p FROM PrivateEmployerBase p WHERE p.eid = :eid"),
    @NamedQuery(name = "PrivateEmployerBase.findByEmpolyerName", query = "SELECT p FROM PrivateEmployerBase p WHERE p.empolyerName = :empolyerName")})
public class PrivateEmployerBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EID")
    private Integer eid;
    @Basic(optional = false)
    @Column(name = "EMPOLYER_NAME")
    private String empolyerName;

    public PrivateEmployerBase() {
    }

    public PrivateEmployerBase(Integer eid) {
        this.eid = eid;
    }

    public PrivateEmployerBase(Integer eid, String empolyerName) {
        this.eid = eid;
        this.empolyerName = empolyerName;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEmpolyerName() {
        return empolyerName;
    }

    public void setEmpolyerName(String empolyerName) {
        this.empolyerName = empolyerName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eid != null ? eid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrivateEmployerBase)) {
            return false;
        }
        PrivateEmployerBase other = (PrivateEmployerBase) object;
        if ((this.eid == null && other.eid != null) || (this.eid != null && !this.eid.equals(other.eid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.PrivateEmployerBase[ eid=" + eid + " ]";
    }
    
}

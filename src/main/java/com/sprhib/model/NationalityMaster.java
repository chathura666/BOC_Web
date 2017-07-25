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
@Table(name = "NATIONALITY_MASTER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NationalityMaster.findAll", query = "SELECT n FROM NationalityMaster n"),
    @NamedQuery(name = "NationalityMaster.findById", query = "SELECT n FROM NationalityMaster n WHERE n.id = :id"),
    @NamedQuery(name = "NationalityMaster.findByCitizencode", query = "SELECT n FROM NationalityMaster n WHERE n.citizencode = :citizencode"),
    @NamedQuery(name = "NationalityMaster.findByDescription", query = "SELECT n FROM NationalityMaster n WHERE n.description = :description")})
public class NationalityMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CITIZENCODE")
    private String citizencode;
    @Column(name = "DESCRIPTION")
    private String description;

    public NationalityMaster() {
    }

    public NationalityMaster(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCitizencode() {
        return citizencode;
    }

    public void setCitizencode(String citizencode) {
        this.citizencode = citizencode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NationalityMaster)) {
            return false;
        }
        NationalityMaster other = (NationalityMaster) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.NationalityMaster[ id=" + id + " ]";
    }
    
}

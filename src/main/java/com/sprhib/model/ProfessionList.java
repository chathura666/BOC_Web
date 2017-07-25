/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author it207432
 */
@Entity
@Table(name = "PROFESSION_LIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProfessionList.findAll", query = "SELECT p FROM ProfessionList p"),
    @NamedQuery(name = "ProfessionList.findByProfessionId", query = "SELECT p FROM ProfessionList p WHERE p.professionId = :professionId"),
    @NamedQuery(name = "ProfessionList.findByProfessionType", query = "SELECT p FROM ProfessionList p WHERE p.professionType = :professionType")})
public class ProfessionList implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PROFESSION_ID")
    private Integer professionId;
    @Basic(optional = false)
    @Column(name = "PROFESSION_TYPE")
    private String professionType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "professionId")
    private Collection<ProfessionProductMapping> professionProductMappingCollection;

    public ProfessionList() {
    }

    public ProfessionList(Integer professionId) {
        this.professionId = professionId;
    }

    public ProfessionList(Integer professionId, String professionType) {
        this.professionId = professionId;
        this.professionType = professionType;
    }

    public Integer getProfessionId() {
        return professionId;
    }

    public void setProfessionId(Integer professionId) {
        this.professionId = professionId;
    }

    public String getProfessionType() {
        return professionType;
    }

    public void setProfessionType(String professionType) {
        this.professionType = professionType;
    }

    @XmlTransient
    public Collection<ProfessionProductMapping> getProfessionProductMappingCollection() {
        return professionProductMappingCollection;
    }

    public void setProfessionProductMappingCollection(Collection<ProfessionProductMapping> professionProductMappingCollection) {
        this.professionProductMappingCollection = professionProductMappingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (professionId != null ? professionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfessionList)) {
            return false;
        }
        ProfessionList other = (ProfessionList) object;
        if ((this.professionId == null && other.professionId != null) || (this.professionId != null && !this.professionId.equals(other.professionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.ProfessionList[ professionId=" + professionId + " ]";
    }
    
}

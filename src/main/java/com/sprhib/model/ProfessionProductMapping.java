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
@Table(name = "PROFESSION_PRODUCT_MAPPING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProfessionProductMapping.findAll", query = "SELECT p FROM ProfessionProductMapping p"),
    @NamedQuery(name = "ProfessionProductMapping.findByPpid", query = "SELECT p FROM ProfessionProductMapping p WHERE p.ppid = :ppid")})
public class ProfessionProductMapping implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PPID")
    private Integer ppid;
    @JoinColumn(name = "PROFESSION_ID", referencedColumnName = "PROFESSION_ID")
    @ManyToOne(optional = false)
    private ProfessionList professionId;
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PID")
    @ManyToOne(optional = false)
    private ProductBase productId;

    public ProfessionProductMapping() {
    }

    public ProfessionProductMapping(Integer ppid) {
        this.ppid = ppid;
    }

    public Integer getPpid() {
        return ppid;
    }

    public void setPpid(Integer ppid) {
        this.ppid = ppid;
    }

    public ProfessionList getProfessionId() {
        return professionId;
    }

    public void setProfessionId(ProfessionList professionId) {
        this.professionId = professionId;
    }

    public ProductBase getProductId() {
        return productId;
    }

    public void setProductId(ProductBase productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ppid != null ? ppid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfessionProductMapping)) {
            return false;
        }
        ProfessionProductMapping other = (ProfessionProductMapping) object;
        if ((this.ppid == null && other.ppid != null) || (this.ppid != null && !this.ppid.equals(other.ppid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.ProfessionProductMapping[ ppid=" + ppid + " ]";
    }
    
}

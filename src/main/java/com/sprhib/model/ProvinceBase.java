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
@Table(name = "PROVINCE_BASE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProvinceBase.findAll", query = "SELECT p FROM ProvinceBase p"),
    @NamedQuery(name = "ProvinceBase.findByPid", query = "SELECT p FROM ProvinceBase p WHERE p.pid = :pid"),
    @NamedQuery(name = "ProvinceBase.findByProvinceCode", query = "SELECT p FROM ProvinceBase p WHERE p.provinceCode = :provinceCode"),
    @NamedQuery(name = "ProvinceBase.findByProvinceName", query = "SELECT p FROM ProvinceBase p WHERE p.provinceName = :provinceName")})
public class ProvinceBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PID")
    private Integer pid;
    @Basic(optional = false)
    @Column(name = "PROVINCE_CODE")
    private String provinceCode;
    @Basic(optional = false)
    @Column(name = "PROVINCE_NAME")
    private String provinceName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pid")
    private Collection<ProvinceBranchMapping> provinceBranchMappingCollection;

    public ProvinceBase() {
    }

    public ProvinceBase(Integer pid) {
        this.pid = pid;
    }

    public ProvinceBase(Integer pid, String provinceCode, String provinceName) {
        this.pid = pid;
        this.provinceCode = provinceCode;
        this.provinceName = provinceName;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    @XmlTransient
    public Collection<ProvinceBranchMapping> getProvinceBranchMappingCollection() {
        return provinceBranchMappingCollection;
    }

    public void setProvinceBranchMappingCollection(Collection<ProvinceBranchMapping> provinceBranchMappingCollection) {
        this.provinceBranchMappingCollection = provinceBranchMappingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pid != null ? pid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProvinceBase)) {
            return false;
        }
        ProvinceBase other = (ProvinceBase) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.ProvinceBase[ pid=" + pid + " ]";
    }
    
}

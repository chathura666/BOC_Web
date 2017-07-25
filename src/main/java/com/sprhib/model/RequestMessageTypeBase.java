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
@Table(name = "REQUEST_MESSAGE_TYPE_BASE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequestMessageTypeBase.findAll", query = "SELECT r FROM RequestMessageTypeBase r"),
    @NamedQuery(name = "RequestMessageTypeBase.findByRequestMessageTypeId", query = "SELECT r FROM RequestMessageTypeBase r WHERE r.requestMessageTypeId = :requestMessageTypeId"),
    @NamedQuery(name = "RequestMessageTypeBase.findByRequestMessageName", query = "SELECT r FROM RequestMessageTypeBase r WHERE r.requestMessageName = :requestMessageName"),
    @NamedQuery(name = "RequestMessageTypeBase.findByClassName", query = "SELECT r FROM RequestMessageTypeBase r WHERE r.className = :className"),
    @NamedQuery(name = "RequestMessageTypeBase.findByRequestServiceName", query = "SELECT r FROM RequestMessageTypeBase r WHERE r.requestServiceName = :requestServiceName"),
    @NamedQuery(name = "RequestMessageTypeBase.findByResponseActivityName", query = "SELECT r FROM RequestMessageTypeBase r WHERE r.responseActivityName = :responseActivityName")})
public class RequestMessageTypeBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "REQUEST_MESSAGE_TYPE_ID")
    private Integer requestMessageTypeId;
    @Basic(optional = false)
    @Column(name = "REQUEST_MESSAGE_NAME")
    private String requestMessageName;
    @Column(name = "CLASS_NAME")
    private String className;
    @Column(name = "REQUEST_SERVICE_NAME")
    private String requestServiceName;
    @Basic(optional = false)
    @Column(name = "RESPONSE_ACTIVITY_NAME")
    private String responseActivityName;

    public RequestMessageTypeBase() {
    }

    public RequestMessageTypeBase(Integer requestMessageTypeId) {
        this.requestMessageTypeId = requestMessageTypeId;
    }

    public RequestMessageTypeBase(Integer requestMessageTypeId, String requestMessageName, String responseActivityName) {
        this.requestMessageTypeId = requestMessageTypeId;
        this.requestMessageName = requestMessageName;
        this.responseActivityName = responseActivityName;
    }

    public Integer getRequestMessageTypeId() {
        return requestMessageTypeId;
    }

    public void setRequestMessageTypeId(Integer requestMessageTypeId) {
        this.requestMessageTypeId = requestMessageTypeId;
    }

    public String getRequestMessageName() {
        return requestMessageName;
    }

    public void setRequestMessageName(String requestMessageName) {
        this.requestMessageName = requestMessageName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getRequestServiceName() {
        return requestServiceName;
    }

    public void setRequestServiceName(String requestServiceName) {
        this.requestServiceName = requestServiceName;
    }

    public String getResponseActivityName() {
        return responseActivityName;
    }

    public void setResponseActivityName(String responseActivityName) {
        this.responseActivityName = responseActivityName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requestMessageTypeId != null ? requestMessageTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequestMessageTypeBase)) {
            return false;
        }
        RequestMessageTypeBase other = (RequestMessageTypeBase) object;
        if ((this.requestMessageTypeId == null && other.requestMessageTypeId != null) || (this.requestMessageTypeId != null && !this.requestMessageTypeId.equals(other.requestMessageTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.RequestMessageTypeBase[ requestMessageTypeId=" + requestMessageTypeId + " ]";
    }
    
}

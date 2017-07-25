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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author it207432
 */
@Entity
@Table(name = "QRTZ_CALENDARS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QrtzCalendars.findAll", query = "SELECT q FROM QrtzCalendars q"),
    @NamedQuery(name = "QrtzCalendars.findByCalendarName", query = "SELECT q FROM QrtzCalendars q WHERE q.calendarName = :calendarName")})
public class QrtzCalendars implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CALENDAR_NAME")
    private String calendarName;
    @Basic(optional = false)
    @Lob
    @Column(name = "CALENDAR")
    private Serializable calendar;

    public QrtzCalendars() {
    }

    public QrtzCalendars(String calendarName) {
        this.calendarName = calendarName;
    }

    public QrtzCalendars(String calendarName, Serializable calendar) {
        this.calendarName = calendarName;
        this.calendar = calendar;
    }

    public String getCalendarName() {
        return calendarName;
    }

    public void setCalendarName(String calendarName) {
        this.calendarName = calendarName;
    }

    public Serializable getCalendar() {
        return calendar;
    }

    public void setCalendar(Serializable calendar) {
        this.calendar = calendar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (calendarName != null ? calendarName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QrtzCalendars)) {
            return false;
        }
        QrtzCalendars other = (QrtzCalendars) object;
        if ((this.calendarName == null && other.calendarName != null) || (this.calendarName != null && !this.calendarName.equals(other.calendarName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.QrtzCalendars[ calendarName=" + calendarName + " ]";
    }
    
}

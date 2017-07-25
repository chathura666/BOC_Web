/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "LOAN_INTEREST_RATE_VARIANCE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoanInterestRateVariance.findAll", query = "SELECT l FROM LoanInterestRateVariance l"),
    @NamedQuery(name = "LoanInterestRateVariance.findByLirvId", query = "SELECT l FROM LoanInterestRateVariance l WHERE l.lirvId = :lirvId"),
    @NamedQuery(name = "LoanInterestRateVariance.findByVarianceFixed", query = "SELECT l FROM LoanInterestRateVariance l WHERE l.varianceFixed = :varianceFixed"),
    @NamedQuery(name = "LoanInterestRateVariance.findByVarianceRateVariable1", query = "SELECT l FROM LoanInterestRateVariance l WHERE l.varianceRateVariable1 = :varianceRateVariable1"),
    @NamedQuery(name = "LoanInterestRateVariance.findByVarianceRateVariable2", query = "SELECT l FROM LoanInterestRateVariance l WHERE l.varianceRateVariable2 = :varianceRateVariable2"),
    @NamedQuery(name = "LoanInterestRateVariance.findByMinRepaymentPeriod", query = "SELECT l FROM LoanInterestRateVariance l WHERE l.minRepaymentPeriod = :minRepaymentPeriod"),
    @NamedQuery(name = "LoanInterestRateVariance.findByMaxRepaymentPeriod", query = "SELECT l FROM LoanInterestRateVariance l WHERE l.maxRepaymentPeriod = :maxRepaymentPeriod")})
public class LoanInterestRateVariance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LIRV_ID")
    private Integer lirvId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "VARIANCE_FIXED")
    private BigDecimal varianceFixed;
    @Basic(optional = false)
    @Column(name = "VARIANCE_RATE_VARIABLE1")
    private BigDecimal varianceRateVariable1;
    @Basic(optional = false)
    @Column(name = "VARIANCE_RATE_VARIABLE2")
    private BigDecimal varianceRateVariable2;
    @Basic(optional = false)
    @Column(name = "MIN_REPAYMENT_PERIOD")
    private int minRepaymentPeriod;
    @Basic(optional = false)
    @Column(name = "MAX_REPAYMENT_PERIOD")
    private int maxRepaymentPeriod;
    @JoinColumn(name = "PID", referencedColumnName = "PID")
    @ManyToOne(optional = false)
    private ProductBase pid;

    public LoanInterestRateVariance() {
    }

    public LoanInterestRateVariance(Integer lirvId) {
        this.lirvId = lirvId;
    }

    public LoanInterestRateVariance(Integer lirvId, BigDecimal varianceFixed, BigDecimal varianceRateVariable1, BigDecimal varianceRateVariable2, int minRepaymentPeriod, int maxRepaymentPeriod) {
        this.lirvId = lirvId;
        this.varianceFixed = varianceFixed;
        this.varianceRateVariable1 = varianceRateVariable1;
        this.varianceRateVariable2 = varianceRateVariable2;
        this.minRepaymentPeriod = minRepaymentPeriod;
        this.maxRepaymentPeriod = maxRepaymentPeriod;
    }

    public Integer getLirvId() {
        return lirvId;
    }

    public void setLirvId(Integer lirvId) {
        this.lirvId = lirvId;
    }

    public BigDecimal getVarianceFixed() {
        return varianceFixed;
    }

    public void setVarianceFixed(BigDecimal varianceFixed) {
        this.varianceFixed = varianceFixed;
    }

    public BigDecimal getVarianceRateVariable1() {
        return varianceRateVariable1;
    }

    public void setVarianceRateVariable1(BigDecimal varianceRateVariable1) {
        this.varianceRateVariable1 = varianceRateVariable1;
    }

    public BigDecimal getVarianceRateVariable2() {
        return varianceRateVariable2;
    }

    public void setVarianceRateVariable2(BigDecimal varianceRateVariable2) {
        this.varianceRateVariable2 = varianceRateVariable2;
    }

    public int getMinRepaymentPeriod() {
        return minRepaymentPeriod;
    }

    public void setMinRepaymentPeriod(int minRepaymentPeriod) {
        this.minRepaymentPeriod = minRepaymentPeriod;
    }

    public int getMaxRepaymentPeriod() {
        return maxRepaymentPeriod;
    }

    public void setMaxRepaymentPeriod(int maxRepaymentPeriod) {
        this.maxRepaymentPeriod = maxRepaymentPeriod;
    }

    public ProductBase getPid() {
        return pid;
    }

    public void setPid(ProductBase pid) {
        this.pid = pid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lirvId != null ? lirvId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoanInterestRateVariance)) {
            return false;
        }
        LoanInterestRateVariance other = (LoanInterestRateVariance) object;
        if ((this.lirvId == null && other.lirvId != null) || (this.lirvId != null && !this.lirvId.equals(other.lirvId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.LoanInterestRateVariance[ lirvId=" + lirvId + " ]";
    }
    
}

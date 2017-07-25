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
@Table(name = "PRODUCT_LOAN_DETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductLoanDetails.findAll", query = "SELECT p FROM ProductLoanDetails p"),
    @NamedQuery(name = "ProductLoanDetails.findByPlid", query = "SELECT p FROM ProductLoanDetails p WHERE p.plid = :plid"),
    @NamedQuery(name = "ProductLoanDetails.findByMaxRepaymentPeriod", query = "SELECT p FROM ProductLoanDetails p WHERE p.maxRepaymentPeriod = :maxRepaymentPeriod"),
    @NamedQuery(name = "ProductLoanDetails.findByMinAge", query = "SELECT p FROM ProductLoanDetails p WHERE p.minAge = :minAge"),
    @NamedQuery(name = "ProductLoanDetails.findByMaxAge", query = "SELECT p FROM ProductLoanDetails p WHERE p.maxAge = :maxAge"),
    @NamedQuery(name = "ProductLoanDetails.findByInterestRateFixed", query = "SELECT p FROM ProductLoanDetails p WHERE p.interestRateFixed = :interestRateFixed"),
    @NamedQuery(name = "ProductLoanDetails.findByInterestRateVariable1", query = "SELECT p FROM ProductLoanDetails p WHERE p.interestRateVariable1 = :interestRateVariable1"),
    @NamedQuery(name = "ProductLoanDetails.findByInterestRateVariable2", query = "SELECT p FROM ProductLoanDetails p WHERE p.interestRateVariable2 = :interestRateVariable2"),
    @NamedQuery(name = "ProductLoanDetails.findByPercentageOfGrossSalary", query = "SELECT p FROM ProductLoanDetails p WHERE p.percentageOfGrossSalary = :percentageOfGrossSalary"),
    @NamedQuery(name = "ProductLoanDetails.findByPercentageOfOtherIncome", query = "SELECT p FROM ProductLoanDetails p WHERE p.percentageOfOtherIncome = :percentageOfOtherIncome"),
    @NamedQuery(name = "ProductLoanDetails.findByMaxLoanAmount", query = "SELECT p FROM ProductLoanDetails p WHERE p.maxLoanAmount = :maxLoanAmount")})
public class ProductLoanDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PLID")
    private Integer plid;
    @Column(name = "MAX_REPAYMENT_PERIOD")
    private Integer maxRepaymentPeriod;
    @Column(name = "MIN_AGE")
    private Integer minAge;
    @Column(name = "MAX_AGE")
    private Integer maxAge;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "INTEREST_RATE_FIXED")
    private BigDecimal interestRateFixed;
    @Column(name = "INTEREST_RATE_VARIABLE1")
    private BigDecimal interestRateVariable1;
    @Column(name = "INTEREST_RATE_VARIABLE2")
    private BigDecimal interestRateVariable2;
    @Column(name = "PERCENTAGE_OF_GROSS_SALARY")
    private BigDecimal percentageOfGrossSalary;
    @Column(name = "PERCENTAGE_OF_OTHER_INCOME")
    private BigDecimal percentageOfOtherIncome;
    @Column(name = "MAX_LOAN_AMOUNT")
    private Double maxLoanAmount;
    @JoinColumn(name = "PID", referencedColumnName = "PID")
    @ManyToOne(optional = false)
    private ProductBase pid;

    public ProductLoanDetails() {
    }

    public ProductLoanDetails(Integer plid) {
        this.plid = plid;
    }

    public Integer getPlid() {
        return plid;
    }

    public void setPlid(Integer plid) {
        this.plid = plid;
    }

    public Integer getMaxRepaymentPeriod() {
        return maxRepaymentPeriod;
    }

    public void setMaxRepaymentPeriod(Integer maxRepaymentPeriod) {
        this.maxRepaymentPeriod = maxRepaymentPeriod;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    public BigDecimal getInterestRateFixed() {
        return interestRateFixed;
    }

    public void setInterestRateFixed(BigDecimal interestRateFixed) {
        this.interestRateFixed = interestRateFixed;
    }

    public BigDecimal getInterestRateVariable1() {
        return interestRateVariable1;
    }

    public void setInterestRateVariable1(BigDecimal interestRateVariable1) {
        this.interestRateVariable1 = interestRateVariable1;
    }

    public BigDecimal getInterestRateVariable2() {
        return interestRateVariable2;
    }

    public void setInterestRateVariable2(BigDecimal interestRateVariable2) {
        this.interestRateVariable2 = interestRateVariable2;
    }

    public BigDecimal getPercentageOfGrossSalary() {
        return percentageOfGrossSalary;
    }

    public void setPercentageOfGrossSalary(BigDecimal percentageOfGrossSalary) {
        this.percentageOfGrossSalary = percentageOfGrossSalary;
    }

    public BigDecimal getPercentageOfOtherIncome() {
        return percentageOfOtherIncome;
    }

    public void setPercentageOfOtherIncome(BigDecimal percentageOfOtherIncome) {
        this.percentageOfOtherIncome = percentageOfOtherIncome;
    }

    public Double getMaxLoanAmount() {
        return maxLoanAmount;
    }

    public void setMaxLoanAmount(Double maxLoanAmount) {
        this.maxLoanAmount = maxLoanAmount;
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
        hash += (plid != null ? plid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductLoanDetails)) {
            return false;
        }
        ProductLoanDetails other = (ProductLoanDetails) object;
        if ((this.plid == null && other.plid != null) || (this.plid != null && !this.plid.equals(other.plid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.ProductLoanDetails[ plid=" + plid + " ]";
    }
    
}

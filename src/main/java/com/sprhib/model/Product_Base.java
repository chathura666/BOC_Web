/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author it207432
 */
@Entity
@Table(name = "PRODUCT_BASE")
public class Product_Base implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PID", nullable = false)
    private int PID;

    @Column(name = "PRODUCT_CODE", nullable = false)
    private String PRODUCT_CODE;

    @Column(name = "PRODUCT_DESCRIPTION")
    private String PRODUCT_DESCRIPTION;

    @Column(name = "PRODUCT_CATEGORY_ID")
    private int PRODUCT_CATEGORY_ID;

    @Column(name = "WF_PRODUCT_CODE",nullable = false)
    private String WF_PRODUCT_CODE;

    
    @Column(name = "PRODUCT_NAME",nullable = false)
    private String PRODUCT_NAME;

    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public String getPRODUCT_CODE() {
        return PRODUCT_CODE;
    }

    public void setPRODUCT_CODE(String PRODUCT_CODE) {
        this.PRODUCT_CODE = PRODUCT_CODE;
    }

    public String getWF_PRODUCT_CODE() {
        return WF_PRODUCT_CODE;
    }

    public void setWF_PRODUCT_CODE(String WF_PRODUCT_CODE) {
        this.WF_PRODUCT_CODE = WF_PRODUCT_CODE;
    }

    public String getPRODUCT_DESCRIPTION() {
        return PRODUCT_DESCRIPTION;
    }

    public void setPRODUCT_DESCRIPTION(String PRODUCT_DESCRIPTION) {
        this.PRODUCT_DESCRIPTION = PRODUCT_DESCRIPTION;
    }

    public int getPRODUCT_CATEGORY_ID() {
        return PRODUCT_CATEGORY_ID;
    }

    public void setPRODUCT_CATEGORY_ID(int PRODUCT_CATEGORY_ID) {
        this.PRODUCT_CATEGORY_ID = PRODUCT_CATEGORY_ID;
    }

    public String getPRODUCT_NAME() {
        return PRODUCT_NAME;
    }

    public void setPRODUCT_NAME(String PRODUCT_NAME) {
        this.PRODUCT_NAME = PRODUCT_NAME;
    }

}

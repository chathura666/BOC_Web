/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.model.BsrPayeeBase;
import com.sprhib.model.BsrProductBase;
import java.util.List;

/**
 *
 * @author it207432
 */
public interface BsrProductBaseService {

    public void addBsrProduct(BsrProductBase pbase);

    public void updateBsrProduct(BsrProductBase pbase);

    public BsrProductBase getBsrProduct(int id);

    public void deleteBsrProduct(int id);

    public List<BsrProductBase> getBsrProducts();

}

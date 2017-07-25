/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.model.BsrPayeeBase;
import java.util.List;

/**
 *
 * @author it207432
 */
public interface BsrPayeeBaseService {

    public void addBsrPayee(BsrPayeeBase payee);

    public void updateBsrPayee(BsrPayeeBase payee);

    public BsrPayeeBase getBsrPayee(int id);

    public void deleteBsrPayee(int id);

    public List<BsrPayeeBase> getBsrPayees();

}

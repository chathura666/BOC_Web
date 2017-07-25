/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.model.BsrBankBranchBase;
import java.util.List;

/**
 *
 * @author it207432
 */
public interface BsrBankBranchBaseService {

  public void addBsrBankBranch(BsrBankBranchBase abase);

    public void updateBsrBankBranch(BsrBankBranchBase abase);

    public BsrBankBranchBase getBsrBankBranch(int id);

    public void deleteBsrBankBranch(int id);

    public List<BsrBankBranchBase> getBsrBankBranches();

}

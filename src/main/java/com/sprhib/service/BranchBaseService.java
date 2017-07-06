/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.model.BranchBase;
import java.util.List;

/**
 *
 * @author it207432
 */
public interface BranchBaseService {

   public void addBranchBase(BranchBase bbase);

    public void updateBranchBase(BranchBase bbase);

    public BranchBase getBranchBase(int id);

    public void deleteBranchBase(int id);

    public List<BranchBase> getBranchBases();

}

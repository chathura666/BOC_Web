/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.BranchBase;
import java.util.List;

/**
 *
 * @author it207432
 */
public interface BranchBaseDAO {

    public void addBranchBase(BranchBase abase);

    public void updateBranchBase(BranchBase abase);

    public BranchBase getBranchBase(int id);

    public void deleteBranchBase(int id);

    public List<BranchBase> getBranchBases();
}

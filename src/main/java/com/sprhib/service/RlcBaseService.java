/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.model.BranchBase;
import com.sprhib.model.RlcBase;
import java.util.List;

/**
 *
 * @author it207432
 */
public interface RlcBaseService {

    public void addRlcBase(RlcBase rbase);

    public void updateRlcBase(RlcBase rbase);

    public RlcBase getRlcBase(int id);

    public void deleteRlcBase(int id);

    public List<RlcBase> getRlcBases();

}

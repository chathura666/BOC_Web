/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.model.RlcBranchMapping;
import java.util.List;

/**
 *
 * @author it207432
 */
public interface RlcBranchMappingService {

    public void addRlcBranchMapping(RlcBranchMapping rbase);

    public void updateRlcBranchMapping(RlcBranchMapping rbase);

    public RlcBranchMapping getRlcBranchMapping(int id);

    public void deleteRlcBranchMapping(int id);

    public List<RlcBranchMapping> getRlcBranchMappings();
}

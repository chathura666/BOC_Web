/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.model.AreaBranchMapping;
import java.util.List;

/**
 *
 * @author it207432
 */
public interface AreaBranchMappingService {

   public void addAreaBranchMap(AreaBranchMapping abmap);

    public void updateAreaBranchMap(AreaBranchMapping abmap);

    public AreaBranchMapping getAreaBranchMap(int id);

    public void deleteAreaBranchMap(int id);

    public List<AreaBranchMapping> getAreaBranchMaps();

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.dao.AreaBranchMappingDAO;
import com.sprhib.model.AreaBranchMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author it207432
 */
@Service
@Transactional
public class AreaBranchMappingServiceImpl implements AreaBranchMappingService {

    @Autowired
    private AreaBranchMappingDAO abmapDAO;

    @Override
    public void addAreaBranchMap(AreaBranchMapping abmap) {
        abmapDAO.addAreaBranchMap(abmap);
    }

    @Override
    public void updateAreaBranchMap(AreaBranchMapping abmap) {
        abmapDAO.updateAreaBranchMap(abmap);
    }

    @Override
    public AreaBranchMapping getAreaBranchMap(int id) {
        return abmapDAO.getAreaBranchMap(id);
    }

    @Override
    public void deleteAreaBranchMap(int id) {
        abmapDAO.deleteAreaBranchMap(id);
    }

    @Override
    public List<AreaBranchMapping> getAreaBranchMaps() {
        return abmapDAO.getAreaBranchMaps();
    }


}

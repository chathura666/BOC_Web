/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.dao.RlcBranchMappingDAO;
import com.sprhib.model.RlcBranchMapping;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author it207432
 */
@Service
@Transactional
public class RlcBranchMappingServiceImpl implements RlcBranchMappingService {

    @Autowired
    private RlcBranchMappingDAO rmapDAO;

    @Override
    public void addRlcBranchMapping(RlcBranchMapping rmap) {
        rmapDAO.addRlcBranchMapping(rmap);
    }

    @Override
    public void updateRlcBranchMapping(RlcBranchMapping rmap) {
        rmapDAO.updateRlcBranchMapping(rmap);
    }

    @Override
    public RlcBranchMapping getRlcBranchMapping(int pid) {
        return rmapDAO.getRlcBranchMapping(pid);
    }

    @Override
    public void deleteRlcBranchMapping(int id) {
       rmapDAO.deleteRlcBranchMapping(id);
    }

    @Override
    public List<RlcBranchMapping> getRlcBranchMappings() {
        return rmapDAO.getRlcBranchMappings();
    }

}

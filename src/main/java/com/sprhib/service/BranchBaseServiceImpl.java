/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.dao.AreaBaseDAO;
import com.sprhib.dao.BranchBaseDAO;
import com.sprhib.model.AreaBase;
import com.sprhib.model.BranchBase;
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
public class BranchBaseServiceImpl implements BranchBaseService {

    @Autowired
    private BranchBaseDAO bbaseDAO;

    @Override
    public void addBranchBase(BranchBase bbase) {
        bbaseDAO.addBranchBase(bbase);
    }

    @Override
    public void updateBranchBase(BranchBase bbase) {
        bbaseDAO.updateBranchBase(bbase);
    }

    @Override
    public BranchBase getBranchBase(int id) {
        return bbaseDAO.getBranchBase(id);
    }

    @Override
    public void deleteBranchBase(int id) {
        bbaseDAO.deleteBranchBase(id);
    }

    @Override
    public List<BranchBase> getBranchBases() {
        return bbaseDAO.getBranchBases();
    }
}

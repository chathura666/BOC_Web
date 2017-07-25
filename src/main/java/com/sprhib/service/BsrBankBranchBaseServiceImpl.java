/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.dao.BsrBankBranchBaseDAO;
import com.sprhib.model.BsrBankBranchBase;
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
public class BsrBankBranchBaseServiceImpl implements BsrBankBranchBaseService {

    @Autowired
    private BsrBankBranchBaseDAO bbaseDAO;

    @Override
    public void addBsrBankBranch(BsrBankBranchBase abase) {
        bbaseDAO.addBsrBankBranch(abase);
    }

    @Override
    public void updateBsrBankBranch(BsrBankBranchBase abase) {
        bbaseDAO.updateBsrBankBranch(abase);
    }

    @Override
    public BsrBankBranchBase getBsrBankBranch(int id) {
        return bbaseDAO.getBsrBankBranch(id);
    }

    @Override
    public void deleteBsrBankBranch(int id) {
        bbaseDAO.deleteBsrBankBranch(id);
    }

    @Override
    public List<BsrBankBranchBase> getBsrBankBranches() {
        return bbaseDAO.getBsrBankBranches();
    }


}

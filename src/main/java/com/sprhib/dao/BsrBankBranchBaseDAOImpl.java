/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.BsrBankBranchBase;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author it207432
 */
@Repository
public class BsrBankBranchBaseDAOImpl implements BsrBankBranchBaseDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addBsrBankBranch(BsrBankBranchBase bbase) {
        getCurrentSession().save(bbase);
    }

    @Override
    public void updateBsrBankBranch(BsrBankBranchBase bbase) {
        BsrBankBranchBase BranchToUpdate = getBsrBankBranch(bbase.getBbId());
        BranchToUpdate.setBbId(bbase.getBbId());
        BranchToUpdate.setBankCode(bbase.getBankCode());
        BranchToUpdate.setBankName(bbase.getBankName());
        BranchToUpdate.setBankNameDisplay(bbase.getBankNameDisplay());
        BranchToUpdate.setBranchCode(bbase.getBranchCode());
        BranchToUpdate.setBranchName(bbase.getBranchName());
        BranchToUpdate.setBranchNameDisplay(bbase.getBranchNameDisplay());

        getCurrentSession().update(BranchToUpdate);
    }

    @Override
    public BsrBankBranchBase getBsrBankBranch(int bid) {
        BsrBankBranchBase bbase = (BsrBankBranchBase) getCurrentSession().get(BsrBankBranchBase.class, bid);
        return bbase;

    }

    @Override
    public void deleteBsrBankBranch(int id) {
        BsrBankBranchBase bbase = getBsrBankBranch(id);
        if (bbase != null) {
            getCurrentSession().delete(bbase);
        }

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<BsrBankBranchBase> getBsrBankBranches() {
        return getCurrentSession().createQuery("from BsrBankBranchBase").list();
    }


}

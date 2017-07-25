/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.AreaBase;
import com.sprhib.model.BranchBase;
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
public class BranchBaseDAOImpl implements BranchBaseDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addBranchBase(BranchBase bbase) {
        getCurrentSession().save(bbase);
    }

    @Override
    public void updateBranchBase(BranchBase bbase) {
        BranchBase BranchToUpdate = getBranchBase(bbase.getBid());
        BranchToUpdate.setBid(bbase.getBid());
        BranchToUpdate.setBranchCode(bbase.getBranchCode());
        BranchToUpdate.setBranchContactNumber(bbase.getBranchContactNumber());
        BranchToUpdate.setBranchGrade(bbase.getBranchCode());
        BranchToUpdate.setBranchName(bbase.getBranchName());
        BranchToUpdate.setDeleteflag(bbase.getDeleteflag());
        BranchToUpdate.setEditflag(bbase.getEditflag());

        getCurrentSession().update(BranchToUpdate);
    }

    @Override
    public BranchBase getBranchBase(int pid) {
        BranchBase bbase = (BranchBase) getCurrentSession().get(BranchBase.class, pid);
        return bbase;

    }

    @Override
    public void deleteBranchBase(int id) {
        BranchBase bbase = getBranchBase(id);
        if (bbase != null) {
            getCurrentSession().delete(bbase);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<BranchBase> getBranchBases() {
        return getCurrentSession().createQuery("from BranchBase").list();
    }

}

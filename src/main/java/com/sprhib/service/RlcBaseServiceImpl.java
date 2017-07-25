/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.dao.RlcBaseDAO;
import com.sprhib.model.RlcBase;
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
public class RlcBaseServiceImpl implements RlcBaseService {

    @Autowired
    private RlcBaseDAO rbaseDAO;

    @Override
    public void addRlcBase(RlcBase rbase) {
        rbaseDAO.addRlcBase(rbase);
    }

    @Override
    public void updateRlcBase(RlcBase rbase) {
        rbaseDAO.updateRlcBase(rbase);
    }

    @Override
    public RlcBase getRlcBase(int id) {
        return rbaseDAO.getRlcBase(id);
    }

    @Override
    public void deleteRlcBase(int id) {
        rbaseDAO.deleteRlcBase(id);
    }

    @Override
    public List<RlcBase> getRlcBases() {
        return rbaseDAO.getRlcBases();
    }
}

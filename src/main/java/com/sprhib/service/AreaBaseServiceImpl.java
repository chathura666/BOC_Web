/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.dao.AreaBaseDAO;
import com.sprhib.model.AreaBase;
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
public class AreaBaseServiceImpl implements AreaBaseService {

    @Autowired
    private AreaBaseDAO abaseDAO;

    @Override
    public void addAreaBase(AreaBase abase) {
        abaseDAO.addAreaBase(abase);
    }

    @Override
    public void updateAreaBase(AreaBase abase) {
        abaseDAO.updateAreaBase(abase);
    }

    @Override
    public AreaBase getAreaBase(int id) {
        return abaseDAO.getAreaBase(id);
    }

    @Override
    public void deleteAreaBase(int id) {
        abaseDAO.deleteAreaBase(id);
    }

    @Override
    public List<AreaBase> getAreaBases() {
        return abaseDAO.getAreaBases();
    }


}

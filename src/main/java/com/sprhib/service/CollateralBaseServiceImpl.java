/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.dao.AreaBaseDAO;
import com.sprhib.dao.CollateralBaseDAO;
import com.sprhib.model.AreaBase;
import com.sprhib.model.CollateralBase;
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
public class CollateralBaseServiceImpl implements CollateralBaseService {

    @Autowired
    private CollateralBaseDAO cbaseDao;

    @Override
    public void addCollateralBase(CollateralBase cbase) {
        cbaseDao.addCollateralBase(cbase);
    }

    @Override
    public void updateCollateralBase(CollateralBase cbase) {
        cbaseDao.updateCollateralBase(cbase);
    }

    @Override
    public CollateralBase getCollateralBase(int id) {
        return cbaseDao.getCollateralBase(id);
    }

    @Override
    public void deleteCollateralBase(int id) {
        cbaseDao.deleteCollateralBase(id);
    }

    @Override
    public List<CollateralBase> getCollateralBases() {
        return cbaseDao.getCollateralBases();
    }


}

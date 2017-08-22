/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.dao.LegalEntityBaseDAO;
import com.sprhib.model.LegalEntityBase;
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
public class LegalEntityBaseServiceImpl implements LegalEntityBaseService {

    @Autowired
    private LegalEntityBaseDAO lbaseDAO;

    @Override
    public void addLegalEntityBase(LegalEntityBase lbase) {
        lbaseDAO.addLegalEntityBase(lbase);
    }

    @Override
    public void updateLegalEntityBase(LegalEntityBase lbase) {
        lbaseDAO.updateLegalEntityBase(lbase);
    }

    @Override
    public LegalEntityBase getLegalEntityBase(int id) {
        return lbaseDAO.getLegalEntityBase(id);
    }

    @Override
    public void deleteLegalEntityBase(int id) {
        lbaseDAO.deleteLegalEntityBase(id);
    }

    @Override
    public List<LegalEntityBase> getLegalEntityBases() {
        return lbaseDAO.getLegalEntityBases();
    }
}

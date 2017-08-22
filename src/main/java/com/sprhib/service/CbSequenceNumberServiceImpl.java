/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.dao.CbSequenceNumberDAO;
import com.sprhib.model.CbSequenceNumber;
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
public class CbSequenceNumberServiceImpl implements CbSequenceNumberService {

    @Autowired
    private CbSequenceNumberDAO sqnumDAO;

    @Override
    public void addCbSequenceNumber(CbSequenceNumber abase) {
        sqnumDAO.addCbSequenceNumber(abase);
    }

    @Override
    public void updateCbSequenceNumber(CbSequenceNumber abase) {
        sqnumDAO.updateCbSequenceNumber(abase);
    }

    @Override
    public CbSequenceNumber getCbSequenceNumber(int id) {
        return sqnumDAO.getCbSequenceNumber(id);
    }

    @Override
    public void deleteCbSequenceNumber(int id) {
        sqnumDAO.deleteCbSequenceNumber(id);
    }

    @Override
    public List<CbSequenceNumber> getCbSequenceNumbers() {
        return sqnumDAO.getCbSequenceNumbers();
    }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.dao.BsrBankBranchBaseDAO;
import com.sprhib.dao.CasSequenceNumberDAO;
import com.sprhib.model.BsrBankBranchBase;
import com.sprhib.model.CasSequenceNumber;
import com.sprhib.model.CasSequenceNumberPK;
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
public class CasSequenceNumberServiceImpl implements CasSequenceNumberService {

    @Autowired
    private CasSequenceNumberDAO seqnumDAO;

    @Override
    public void addSequenceNumber(CasSequenceNumber seqnum) {
        seqnumDAO.addSequenceNumber(seqnum);
    }

    @Override
    public void updateSequenceNumber(CasSequenceNumber seqnum) {
        seqnumDAO.updateSequenceNumber(seqnum);
    }

    @Override
    public CasSequenceNumber getSequenceNumber(CasSequenceNumberPK seqnumpk) {
        return seqnumDAO.getSequenceNumber(seqnumpk);
    }

    @Override
    public void deleteSequenceNumber(CasSequenceNumber seqnum) {
        seqnumDAO.deleteSequenceNumber(seqnum);
    }

    @Override
    public List<CasSequenceNumber> getSequenceNumbers() {
        return seqnumDAO.getSequenceNumbers();
    }

}

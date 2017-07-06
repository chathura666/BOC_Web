/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.dao.LoanProductIndexIdMappingDAO;
import com.sprhib.model.LoanProductIndexIdMapping;
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
public class LoanProductIndexIdMappingServiceImpl implements LoanProductIndexIdMappingService {

    @Autowired
    private LoanProductIndexIdMappingDAO loanIdMapDao;

    @Override
    public void addLoanProductIndexIdMap(LoanProductIndexIdMapping idmap) {
        loanIdMapDao.addLoanProductIndexIdMap(idmap);
    }

    @Override
    public void updateLoanProductIndexIdMap(LoanProductIndexIdMapping idmap) {
        loanIdMapDao.updateLoanProductIndexIdMap(idmap);
    }

    @Override
    public LoanProductIndexIdMapping getLoanProductIndexIdMap(int id) {
        return loanIdMapDao.getLoanProductIndexIdMap(id);
    }

    @Override
    public void deleteLoanProductIndexIdMap(int id) {
        loanIdMapDao.deleteLoanProductIndexIdMap(id);
    }

    @Override
    public List<LoanProductIndexIdMapping> getLoanProductIndexIdMaps() {
        return loanIdMapDao.getLoanProductIndexIdMaps();
    }


}

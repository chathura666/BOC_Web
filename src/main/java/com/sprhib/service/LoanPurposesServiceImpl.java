/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.dao.LoanPurposesDAO;
import com.sprhib.model.LoanPurposes;
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
public class LoanPurposesServiceImpl implements LoanPurposesService {

    @Autowired
    private LoanPurposesDAO loanDAO;

    @Override
    public void addLoanPurposes(LoanPurposes loan) {
        loanDAO.addLoanPurposes(loan);
    }

    @Override
    public void updateLoanPurposes(LoanPurposes loan) {
        loanDAO.updateLoanPurposes(loan);
    }

    @Override
    public LoanPurposes getLoanPurposes(int id) {
        return loanDAO.getLoanPurposes(id);
    }

    @Override
    public void deleteLoanPurposes(int id) {
        loanDAO.deleteLoanPurposes(id);
    }

    @Override
    public List<LoanPurposes> getLoanPurposes() {
        return loanDAO.getLoanPurposes();
    }


}

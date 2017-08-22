/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.dao.LoanInterestRateVarianceDAO;
import com.sprhib.model.LoanInterestRateVariance;
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
public class LoanInterestRateVarianceServiceImpl implements LoanInterestRateVarianceService {

    @Autowired
    private LoanInterestRateVarianceDAO varienceDAO;

    @Override
    public void addVariance(LoanInterestRateVariance var) {
        varienceDAO.addVariance(var);
    }

    @Override
    public void updateVariance(LoanInterestRateVariance var) {
        varienceDAO.updateVariance(var);
    }

    @Override
    public LoanInterestRateVariance getVariance(int id) {
        return varienceDAO.getVariance(id);
    }

    @Override
    public void deleteVariance(int id) {
        varienceDAO.deleteVariance(id);
    }

    @Override
    public List<LoanInterestRateVariance> getVariances() {
        return varienceDAO.getVariances();
    }


}

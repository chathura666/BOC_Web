/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.model.AreaBase;
import com.sprhib.model.LoanInterestRateVariance;
import java.util.List;

/**
 *
 * @author it207432
 */
public interface LoanInterestRateVarianceService {

   public void addVariance(LoanInterestRateVariance var);

    public void updateVariance(LoanInterestRateVariance var);

    public LoanInterestRateVariance getVariance(int id);

    public void deleteVariance(int id);

    public List<LoanInterestRateVariance> getVariances();

}

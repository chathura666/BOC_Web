/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.model.AreaBase;
import com.sprhib.model.LoanPurposes;
import java.util.List;

/**
 *
 * @author it207432
 */
public interface LoanPurposesService {

    public void addLoanPurposes(LoanPurposes abase);

    public void updateLoanPurposes(LoanPurposes abase);

    public LoanPurposes getLoanPurposes(int id);

    public void deleteLoanPurposes(int id);

    public List<LoanPurposes> getLoanPurposes();

}

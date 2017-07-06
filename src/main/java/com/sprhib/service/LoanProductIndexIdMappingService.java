/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.model.AreaBase;
import com.sprhib.model.LoanProductIndexIdMapping;
import java.util.List;

/**
 *
 * @author it207432
 */
public interface LoanProductIndexIdMappingService {

    public void addLoanProductIndexIdMap(LoanProductIndexIdMapping abase);

    public void updateLoanProductIndexIdMap(LoanProductIndexIdMapping abase);

    public LoanProductIndexIdMapping getLoanProductIndexIdMap(int id);

    public void deleteLoanProductIndexIdMap(int id);

    public List<LoanProductIndexIdMapping> getLoanProductIndexIdMaps();

}

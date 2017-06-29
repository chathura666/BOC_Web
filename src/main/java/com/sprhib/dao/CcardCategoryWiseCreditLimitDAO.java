/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.CcCardCategoryWiseCreditLimits;
import java.util.List;

/**
 *
 * @author it207432
 */
public interface CcardCategoryWiseCreditLimitDAO {

    public void addCCWiseCreditLimit(CcCardCategoryWiseCreditLimits CCClimit);

    public void updateCCWiseCreditLimit(CcCardCategoryWiseCreditLimits CCClimit);

    public CcCardCategoryWiseCreditLimits getCCWiseCreditLimit(int id);

    public void deleteCCWiseCreditLimit(int id);

    public List<CcCardCategoryWiseCreditLimits> getCCWiseCreditLimit();

}

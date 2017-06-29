/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.dao.*;
import com.sprhib.model.CcCardCategoryWiseCreditLimits;
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
public class CcardCategoryWiseCreditLimitServiceImpl implements CcardCategoryWiseCreditLimitService {

    @Autowired
    private CcardCategoryWiseCreditLimitDAO ccclimitDao;

    @Override
    public void addCCWiseCreditLimit(CcCardCategoryWiseCreditLimits CCClimit) {
        ccclimitDao.addCCWiseCreditLimit(CCClimit);
    }

    @Override
    public void updateCCWiseCreditLimit(CcCardCategoryWiseCreditLimits CCClimit) {    
        ccclimitDao.updateCCWiseCreditLimit(CCClimit);
    }

    @Override
    public CcCardCategoryWiseCreditLimits getCCWiseCreditLimit(int id) {
        return ccclimitDao.getCCWiseCreditLimit(id);

    }

    @Override
    public void deleteCCWiseCreditLimit(int id) {
         ccclimitDao.deleteCCWiseCreditLimit(id);

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<CcCardCategoryWiseCreditLimits> getCCWiseCreditLimit() {
        return ccclimitDao.getCCWiseCreditLimit();
    }

}

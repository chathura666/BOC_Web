/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.dao.CcCardCategoryWiseEligibilitesDAO;
import com.sprhib.model.AreaBase;
import com.sprhib.model.CcCardCategoryWiseEligibilites;
import com.sprhib.model.CcCardCategoryWiseEligibilitesPK;
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
public class CcCardCategoryWiseEligibilitesServiceImpl implements CcCardCategoryWiseEligibilitesService {

    @Autowired
    private CcCardCategoryWiseEligibilitesDAO eligibleDAO;

    @Override
    public void addCCWiseEligibility(CcCardCategoryWiseEligibilites eligible) {
        eligibleDAO.addCCWiseEligibility(eligible);
    }

    @Override
    public void updateCCWiseEligibility(CcCardCategoryWiseEligibilites eligible) {
        eligibleDAO.updateCCWiseEligibility(eligible);
    }

    @Override
    public CcCardCategoryWiseEligibilites getCCWiseEligibility(CcCardCategoryWiseEligibilitesPK eligible) {
        return eligibleDAO.getCCWiseEligibility(eligible);
    }

    @Override
    public void deleteCCWiseEligibility(CcCardCategoryWiseEligibilites eligible) {
        eligibleDAO.deleteCCWiseEligibility(eligible);
    }

    @Override
    public List<CcCardCategoryWiseEligibilites> getCCWiseEligibilities() {
        return eligibleDAO.getCCWiseEligibilities();
    }


}

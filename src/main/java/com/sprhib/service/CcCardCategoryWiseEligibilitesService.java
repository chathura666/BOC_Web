/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.model.AreaBase;
import com.sprhib.model.CcCardCategoryWiseEligibilites;
import com.sprhib.model.CcCardCategoryWiseEligibilitesPK;
import java.util.List;

/**
 *
 * @author it207432
 */
public interface CcCardCategoryWiseEligibilitesService {

    public void addCCWiseEligibility(CcCardCategoryWiseEligibilites eligibilites);

    public void updateCCWiseEligibility(CcCardCategoryWiseEligibilites eligibilites);

    public CcCardCategoryWiseEligibilites getCCWiseEligibility(CcCardCategoryWiseEligibilitesPK eligibilites);

    public void deleteCCWiseEligibility(CcCardCategoryWiseEligibilites eligibilites);

    public List<CcCardCategoryWiseEligibilites> getCCWiseEligibilities();

}

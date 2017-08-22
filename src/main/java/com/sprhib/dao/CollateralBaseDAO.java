/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.AreaBase;
import com.sprhib.model.CollateralBase;
import java.util.List;

/**
 *
 * @author it207432
 */
public interface CollateralBaseDAO {

    public void addCollateralBase(CollateralBase cbase);

    public void updateCollateralBase(CollateralBase cbase);

    public CollateralBase getCollateralBase(int id);

    public void deleteCollateralBase(int id);

    public List<CollateralBase> getCollateralBases();
}

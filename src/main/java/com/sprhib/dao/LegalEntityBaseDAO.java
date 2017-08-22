/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.LegalEntityBase;
import java.util.List;

/**
 *
 * @author it207432
 */
public interface LegalEntityBaseDAO {

    public void addLegalEntityBase(LegalEntityBase abase);

    public void updateLegalEntityBase(LegalEntityBase abase);

    public LegalEntityBase getLegalEntityBase(int id);

    public void deleteLegalEntityBase(int id);

    public List<LegalEntityBase> getLegalEntityBases(); 

}

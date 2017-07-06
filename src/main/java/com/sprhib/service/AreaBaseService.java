/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.model.AreaBase;
import java.util.List;

/**
 *
 * @author it207432
 */
public interface AreaBaseService {

   public void addAreaBase(AreaBase abase);

    public void updateAreaBase(AreaBase abase);

    public AreaBase getAreaBase(int id);

    public void deleteAreaBase(int id);

    public List<AreaBase> getAreaBases();

}

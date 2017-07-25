/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.AreaBase;
import com.sprhib.model.BsrCurrencyBase;
import com.sprhib.model.CasCurrencyBase;
import java.util.List;

/**
 *
 * @author it207432
 */
public interface CasCurrencyBaseDAO {

    public void addCasCurrency(CasCurrencyBase cbase);

    public void updateCasCurrency(CasCurrencyBase cbase);

    public CasCurrencyBase getCasCurrency(int id);

    public void deleteCasCurrency(int id);

    public List<CasCurrencyBase> getCasCurrencies();
}

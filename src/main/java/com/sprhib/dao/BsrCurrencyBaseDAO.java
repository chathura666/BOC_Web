/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.AreaBase;
import com.sprhib.model.BsrCurrencyBase;
import java.util.List;

/**
 *
 * @author it207432
 */
public interface BsrCurrencyBaseDAO {

    public void addBsrCurrency(BsrCurrencyBase cbase);

    public void updateBsrCurrency(BsrCurrencyBase cbase);

    public BsrCurrencyBase getBsrCurrency(int id);

    public void deleteBsrCurrency(int id);

    public List<BsrCurrencyBase> getBsrCurrencies();
}

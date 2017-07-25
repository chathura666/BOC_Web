/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.dao.AreaBaseDAO;
import com.sprhib.dao.BsrCurrencyBaseDAO;
import com.sprhib.dao.CasCurrencyBaseDAO;
import com.sprhib.model.AreaBase;
import com.sprhib.model.BsrCurrencyBase;
import com.sprhib.model.CasCurrencyBase;
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
public class CasCurrencyBaseServiceImpl implements CasCurrencyBaseService {

    @Autowired
    private CasCurrencyBaseDAO currencyDAO;

    @Override
    public void addCasCurrency(CasCurrencyBase cbase) {
        currencyDAO.addCasCurrency(cbase);
    }

    @Override
    public void updateCasCurrency(CasCurrencyBase cbase) {
        currencyDAO.updateCasCurrency(cbase);
    }

    @Override
    public CasCurrencyBase getCasCurrency(int id) {
        return currencyDAO.getCasCurrency(id);
    }

    @Override
    public void deleteCasCurrency(int id) {
        currencyDAO.deleteCasCurrency(id);
    }

    @Override
    public List<CasCurrencyBase> getCasCurrencies() {
        return currencyDAO.getCasCurrencies();
    }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.dao.AreaBaseDAO;
import com.sprhib.dao.BsrCurrencyBaseDAO;
import com.sprhib.model.AreaBase;
import com.sprhib.model.BsrCurrencyBase;
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
public class BsrCurrencyBaseServiceImpl implements BsrCurrencyBaseService {

    @Autowired
    private BsrCurrencyBaseDAO currencyDAO;

    @Override
    public void addBsrCurrency(BsrCurrencyBase cbase) {
        currencyDAO.addBsrCurrency(cbase);
    }

    @Override
    public void updateBsrCurrency(BsrCurrencyBase cbase) {
        currencyDAO.updateBsrCurrency(cbase);
    }

    @Override
    public BsrCurrencyBase getBsrCurrency(int id) {
        return currencyDAO.getBsrCurrency(id);
    }

    @Override
    public void deleteBsrCurrency(int id) {
        currencyDAO.deleteBsrCurrency(id);
    }

    @Override
    public List<BsrCurrencyBase> getBsrCurrencies() {
        return currencyDAO.getBsrCurrencies();
    }


}

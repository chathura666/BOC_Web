/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.dao.BsrProductBaseDAO;
import com.sprhib.model.BsrProductBase;
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
public class BsrProductBaseServiceImpl implements BsrProductBaseService {

    @Autowired
    private BsrProductBaseDAO pbaseDAO;

    @Override
    public void addBsrProduct(BsrProductBase pbase) {
        pbaseDAO.addBsrProduct(pbase);
    }

    @Override
    public void updateBsrProduct(BsrProductBase pbase) {
        pbaseDAO.updateBsrProduct(pbase);
    }

    @Override
    public BsrProductBase getBsrProduct(int id) {
        return pbaseDAO.getBsrProduct(id);
    }

    @Override
    public void deleteBsrProduct(int id) {
        pbaseDAO.deleteBsrProduct(id);
    }

    @Override
    public List<BsrProductBase> getBsrProducts() {
        return pbaseDAO.getBsrProducts();
    }


}

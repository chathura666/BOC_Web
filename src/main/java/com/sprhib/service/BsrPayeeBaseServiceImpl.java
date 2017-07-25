/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.dao.BsrPayeeBaseDAO;
import com.sprhib.model.BsrPayeeBase;
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
public class BsrPayeeBaseServiceImpl implements BsrPayeeBaseService {

    @Autowired
    private BsrPayeeBaseDAO payeeDAO;

    @Override
    public void addBsrPayee(BsrPayeeBase payee) {
        payeeDAO.addBsrPayee(payee);
    }

    @Override
    public void updateBsrPayee(BsrPayeeBase payee) {
        payeeDAO.updateBsrPayee(payee);
    }

    @Override
    public BsrPayeeBase getBsrPayee(int id) {
        return payeeDAO.getBsrPayee(id);
    }

    @Override
    public void deleteBsrPayee(int id) {
        payeeDAO.deleteBsrPayee(id);
    }

    @Override
    public List<BsrPayeeBase> getBsrPayees() {
        return payeeDAO.getBsrPayees();
    }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.dao.Product_BaseDAO;
import com.sprhib.model.Product_Base;
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
public class Product_BaseServiceImpl implements Product_BaseService {

    @Autowired
    private Product_BaseDAO pbaseDAO;

    @Override
    public void addProduct(Product_Base pbase) {
        pbaseDAO.addProduct(pbase);
    }

    @Override
    public void updateProduct(Product_Base pbase) {
        pbaseDAO.updateProduct(pbase);
    }

    @Override
    public Product_Base getProduct(int id) {
        return pbaseDAO.getProduct(id);
    }

    @Override
    public void deleteProduct(int id) {
        pbaseDAO.deleteProduct(id);
    }

    @Override
    public List<Product_Base> getProducts() {
        return pbaseDAO.getProducts();
    }

    @Override
    public List<Object> getAllTables() {
        return pbaseDAO.getAllTables();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.dao.Product_BaseDAO;
import com.sprhib.model.ProductBase;
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
    public void addProduct(ProductBase pbase) {
        pbaseDAO.addProduct(pbase);
    }

    @Override
    public void updateProduct(ProductBase pbase) {
        pbaseDAO.updateProduct(pbase);
    }

    @Override
    public ProductBase getProduct(int id) {
        return pbaseDAO.getProduct(id);
    }

    @Override
    public void deleteProduct(int id) {
        pbaseDAO.deleteProduct(id);
    }

    @Override
    public List<ProductBase> getProducts() {
        return pbaseDAO.getProducts();
    }


}

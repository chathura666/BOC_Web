/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.dao.Product_Category_BaseDAO;
import com.sprhib.model.ProductCategoryBase;
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
public class Product_Category_BaseServiceImpl implements Product_Category_BaseService {

    @Autowired
    private Product_Category_BaseDAO pcbaseDAO;

    @Override
    public void addProductCategoryBase(ProductCategoryBase pcbase) {
        pcbaseDAO.addProductCategoryBase(pcbase);
    }

    @Override
    public void updateProductCategoryBase(ProductCategoryBase pcbase) {
        pcbaseDAO.updateProductCategoryBase(pcbase);
    }

    @Override
    public ProductCategoryBase getProductCategoryBase(int id) {
        return pcbaseDAO.getProductCategoryBase(id);
    }

    @Override
    public void deleteProductCategoryBase(int id) {
        pcbaseDAO.deleteProductCategoryBase(id);
    }

    @Override
    public List<ProductCategoryBase> getProductCategoryBases() {
        return pcbaseDAO.getProductCategoryBases();
    }
}

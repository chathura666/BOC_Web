/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.model.ProductBase;
import java.util.List;

/**
 *
 * @author it207432
 */
public interface Product_BaseService {

    public void addProduct(ProductBase pbase);

    public void updateProduct(ProductBase pbase);

    public ProductBase getProduct(int id);

    public void deleteProduct(int id);

    public List<ProductBase> getProducts();
    
    public List<Object>  getAllTables();

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.model.Product_Base;
import java.util.List;

/**
 *
 * @author it207432
 */
public interface Product_BaseService {

    public void addProduct(Product_Base pbase);

    public void updateProduct(Product_Base pbase);

    public Product_Base getProduct(int id);

    public void deleteProduct(int id);

    public List<Product_Base> getProducts();

}

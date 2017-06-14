/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;
import com.sprhib.model.ProductCategoryBase;
import java.util.List;

/**
 *
 * @author it207432
 */
public interface Product_Category_BaseDAO {

    public void addProductCategoryBase(ProductCategoryBase pcbase);

    public void updateProductCategoryBase(ProductCategoryBase pcbase);

    public ProductCategoryBase getProductCategoryBase(int id);

    public void deleteProductCategoryBase(int id);

    public List<ProductCategoryBase> getProductCategoryBases();
}

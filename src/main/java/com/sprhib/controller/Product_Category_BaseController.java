/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.controller;

import com.sprhib.model.ProductCategoryBase;
import com.sprhib.service.Product_Category_BaseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author it207432
 */
@Controller
@RequestMapping(value = "/pcbase")
public class Product_Category_BaseController {

    @Autowired
    Product_Category_BaseService pcbaseService;

    @RequestMapping(value = "/addProductCategory", method = RequestMethod.GET)
    public ModelAndView addProductCategoryPage() {
        ModelAndView modelAndView = new ModelAndView("add-product-category-form");
        modelAndView.addObject("pcbase", new ProductCategoryBase());
        return modelAndView;
    }

    @RequestMapping(value = "/addProductCategory", method = RequestMethod.POST)
    public ModelAndView addingProductCategoryPage(@ModelAttribute ProductCategoryBase pcbase) {

        ModelAndView modelAndView = new ModelAndView("list-of-product-categories");

        try {
            pcbaseService.addProductCategoryBase(pcbase);

            String message = "Product Category was successfully added!!.";
            modelAndView.addObject("message", message);

        } catch (Exception ex) {

            String message1 = "Product Insert failed!!";
            modelAndView.addObject("message1", message1);

        }

        List<ProductCategoryBase> pcbases = pcbaseService.getProductCategoryBases();
        modelAndView.addObject("pcbases", pcbases);
        return modelAndView;
    }

    @RequestMapping(value = "/listProductCategories")
    public ModelAndView listOfProductCategories() {
        ModelAndView modelAndView = new ModelAndView("list-of-product-categories");

        List<ProductCategoryBase> pcbases = pcbaseService.getProductCategoryBases();
        modelAndView.addObject("pcbases", pcbases);

        return modelAndView;
    }

 

    @RequestMapping(value = "/editProductCategory/{id}", method = RequestMethod.GET)
    public ModelAndView editProductCategoryPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("edit-product-category-form");
        ProductCategoryBase pcbase = pcbaseService.getProductCategoryBase(id);
        modelAndView.addObject("pcbase", pcbase);
        return modelAndView;
    }

    @RequestMapping(value = "/editProductCategory/{id}", method = RequestMethod.POST)
    public ModelAndView editingProductCategory(@ModelAttribute ProductCategoryBase pcbase, @PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("list-of-product-categories");

        try {
            pcbaseService.updateProductCategoryBase(pcbase);

            String message = "Product was successfully edited!!.";
            modelAndView.addObject("message", message);

        } catch (Exception ex) {

            String message1 = "Product Update failed!!";
            modelAndView.addObject("message1", message1);

        }

        List<ProductCategoryBase> pcbases = pcbaseService.getProductCategoryBases();
        modelAndView.addObject("pcbases", pcbases);

        return modelAndView;
    }

    @RequestMapping(value = "/deleteProductCategory/{id}", method = RequestMethod.GET)
    public ModelAndView deleteProductCategory(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("list-of-product-categories");

        try {
            pcbaseService.deleteProductCategoryBase(id);
            String message = "Product was successfully deleted!!.";
            modelAndView.addObject("message", message);
        } catch (Exception ex) {

            String message1 = "Product Delete failed!!";
            modelAndView.addObject("message1", message1);

        }

        List<ProductCategoryBase> pcbases = pcbaseService.getProductCategoryBases();
        modelAndView.addObject("pcbases", pcbases);

        return modelAndView;
    }

}

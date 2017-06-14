/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.controller;

import com.sprhib.model.ProductBase;
import com.sprhib.service.Product_BaseService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
@RequestMapping(value = "/pbase")
public class Product_BaseController {

    @Autowired
    Product_BaseService pbaseService;

    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    public ModelAndView addProductPage() {
        ModelAndView modelAndView = new ModelAndView("add-product-form");
        modelAndView.addObject("pbase", new ProductBase());
        return modelAndView;
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public ModelAndView addingProduct(@ModelAttribute ProductBase pbase) {

        ModelAndView modelAndView = new ModelAndView("list-of-products");

        try {
            pbaseService.addProduct(pbase);

            String message = "Product was successfully added!!.";
            modelAndView.addObject("message", message);

        } catch (Exception ex) {

            String message1 = "Product Insert failed!!";
            modelAndView.addObject("message1", message1);

        }

        List<ProductBase> pbases = pbaseService.getProducts();
        modelAndView.addObject("pbases", pbases);
        return modelAndView;
    }

    @RequestMapping(value = "/listProducts")
    public ModelAndView listOfProducts() {
        ModelAndView modelAndView = new ModelAndView("list-of-products");

        List<ProductBase> pbases = pbaseService.getProducts();
        modelAndView.addObject("pbases", pbases);

        return modelAndView;
    }

    @RequestMapping(value = "/listTables")
    public ModelAndView listTables() {
        ModelAndView modelAndView = new ModelAndView("home");

        //List<Object> tables = pbaseService.getAllTables();

        List<String> al = new ArrayList<String>();  
        al.add("ProductBase");
        al.add("ProductCategoryBase");

        modelAndView.addObject("tables", al);

        return modelAndView;
    }

    @RequestMapping(value = "/editProduct/{id}", method = RequestMethod.GET)
    public ModelAndView editProductPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("edit-product-form");
        ProductBase pbase = pbaseService.getProduct(id);
        modelAndView.addObject("pbase", pbase);
        return modelAndView;
    }

    @RequestMapping(value = "/editProduct/{id}", method = RequestMethod.POST)
    public ModelAndView edditingProduct(@ModelAttribute ProductBase pbase, @PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("list-of-products");

        try {
            pbaseService.updateProduct(pbase);

            String message = "Product was successfully edited!!.";
            modelAndView.addObject("message", message);

        } catch (Exception ex) {

            String message1 = "Product Update failed!!";
            modelAndView.addObject("message1", message1);

        }

        List<ProductBase> pbases = pbaseService.getProducts();
        modelAndView.addObject("pbases", pbases);

        return modelAndView;
    }

    @RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.GET)
    public ModelAndView deleteProduct(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("list-of-products");

        try {
            pbaseService.deleteProduct(id);
            String message = "Product was successfully deleted!!.";
            modelAndView.addObject("message", message);
        } catch (Exception ex) {

            String message1 = "Product Delete failed!!";
            modelAndView.addObject("message1", message1);

        }

        List<ProductBase> pbases = pbaseService.getProducts();
        modelAndView.addObject("pbases", pbases);

        return modelAndView;
    }

}

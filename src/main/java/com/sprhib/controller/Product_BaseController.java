/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.controller;

import com.sprhib.model.Product_Base;
import com.sprhib.service.Product_BaseService;
import java.util.List;
import javafx.scene.control.Alert;
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
@RequestMapping(value = "/pbase")
public class Product_BaseController {

    @Autowired
    Product_BaseService pbaseService;

    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    public ModelAndView addProductPage() {
        ModelAndView modelAndView = new ModelAndView("add-product-form");
        modelAndView.addObject("pbase", new Product_Base());
        return modelAndView;
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public ModelAndView addingProduct(@ModelAttribute Product_Base pbase) {

        ModelAndView modelAndView = new ModelAndView("list-of-products");
        pbaseService.addProduct(pbase);

        String message = "Product was successfully added.";
        modelAndView.addObject("message", message);

        List<Product_Base> pbases = pbaseService.getProducts();
        modelAndView.addObject("pbases", pbases);

        return modelAndView;

    }

    @RequestMapping(value = "/listProducts")
    public ModelAndView listOfProducts() {
        ModelAndView modelAndView = new ModelAndView("list-of-products");

        List<Product_Base> pbases = pbaseService.getProducts();
        modelAndView.addObject("pbases", pbases);

        return modelAndView;
    }

    @RequestMapping(value = "/listTables")
    public ModelAndView listTables() {
        ModelAndView modelAndView = new ModelAndView("list-of-products");

        List<Object> tables = pbaseService.getAllTables();
        modelAndView.addObject("tables", tables);

        return modelAndView;
    }

    @RequestMapping(value = "/editProduct/{id}", method = RequestMethod.GET)
    public ModelAndView editProductPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("edit-product-form");
        Product_Base pbase = pbaseService.getProduct(id);
        modelAndView.addObject("pbase", pbase);
        return modelAndView;
    }

    @RequestMapping(value = "/editProduct/{id}", method = RequestMethod.POST)
    public ModelAndView edditingProduct(@ModelAttribute Product_Base pbase, @PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("list-of-products");

        pbaseService.updateProduct(pbase);

        String message = "Product was successfully edited.";
        modelAndView.addObject("message", message);

        List<Product_Base> pbases = pbaseService.getProducts();
        modelAndView.addObject("pbases", pbases);

        return modelAndView;
    }

    @RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.GET)
    public ModelAndView deleteProduct(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("list-of-products");
        pbaseService.deleteProduct(id);
        String message = "Product was successfully deleted.";
        modelAndView.addObject("message", message);

        List<Product_Base> pbases = pbaseService.getProducts();
        modelAndView.addObject("pbases", pbases);

        return modelAndView;
    }

}

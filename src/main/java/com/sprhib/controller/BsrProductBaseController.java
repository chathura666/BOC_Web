/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.controller;

import com.sprhib.model.BsrProductBase;
import com.sprhib.service.BsrProductBaseService;
import java.util.List;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
@RequestMapping(value = "/bsrproduct")
public class BsrProductBaseController {

    @Autowired
    BsrProductBaseService productService;

    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    public ModelAndView addBsrProduct() {
        ModelAndView modelAndView = new ModelAndView("bsrproduct_base/add-bsr-payee");
        modelAndView.addObject("product", new BsrProductBase());
        return modelAndView;
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public ModelAndView addingBsrProduct(@ModelAttribute BsrProductBase product) {

        ModelAndView modelAndView = new ModelAndView("bsrproduct_base/list-of-bsr-product");
        try {
            productService.addBsrProduct(product);

            String message = "Record was successfully added!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Record Adding Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            BsrProductBase currentproduct = productService.getBsrProduct(product.getProductId());
            if (currentproduct != null) {
                String message1 = "Record Already Exist!!!";
                modelAndView.addObject("message1", message1);
            } else {
                String message1 = "Record Adding Failed!!";
                modelAndView.addObject("message1", message1);
            }
        } catch (Exception ex) {
            String message1 = "Record Adding Failed!!";
            modelAndView.addObject("message1", message1);
        }
        List<BsrProductBase> products = productService.getBsrProducts();

        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @RequestMapping(value = "/listProducts")
    public ModelAndView listOfBsrProducts() {
        ModelAndView modelAndView = new ModelAndView("bsrproduct_base/list-of-bsr-product");

        List<BsrProductBase> products = productService.getBsrProducts();

        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @RequestMapping(value = "/editProduct/{id}", method = RequestMethod.GET)
    public ModelAndView editBsrProduct(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("bsrproduct_base/edit-bsr-payee");
        BsrProductBase product = productService.getBsrProduct(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @RequestMapping(value = "/editProduct/{id}", method = RequestMethod.POST)
    public ModelAndView editingBsrProduct(@ModelAttribute BsrProductBase pbase, @PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("bsrproduct_base/list-of-bsr-product");

        try {
            productService.updateBsrProduct(pbase);

            String message = "Record was successfully edited!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Record editing Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            BsrProductBase currentproduct = productService.getBsrProduct(pbase.getProductId());
            if (currentproduct != null) {
                String message1 = "Record With Same ID Already Exist!!!";
                modelAndView.addObject("message1", message1);
            } else {
                String message1 = "Record Editing Failed!!";
                modelAndView.addObject("message1", message1);
            }
        } catch (Exception ex) {
            String message1 = "Record Editing Failed!!";
            modelAndView.addObject("message1", message1);
        }

        List<BsrProductBase> products = productService.getBsrProducts();

        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.GET)
    public ModelAndView deleteBsrProduct(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("bsrproduct_base/list-of-bsr-product");

        try {
            productService.deleteBsrProduct(id);
            String message = "Record was successfully deleted!!.";
            modelAndView.addObject("message", message);
        } catch (Exception ex) {

            String message1 = ex.getMessage();
            modelAndView.addObject("message1", message1);

        }

        List<BsrProductBase> products = productService.getBsrProducts();

        modelAndView.addObject("products", products);
        return modelAndView;
    }

}

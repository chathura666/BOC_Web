/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.controller;

import com.sprhib.model.ProductBase;
import com.sprhib.model.ProductCategoryBase;
import com.sprhib.service.Product_BaseService;
import com.sprhib.service.Product_Category_BaseService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Autowired
    Product_Category_BaseService pcbaseService;
    
    final static Logger logger = Logger.getLogger(Product_BaseController.class);

    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    public ModelAndView addProductPage() {
        ModelAndView modelAndView = new ModelAndView("products/add-product-form");

        List<ProductCategoryBase> productcats = pcbaseService.getProductCategoryBases();
        List<String> Prodcat = new ArrayList<String>();

        Iterator<ProductCategoryBase> pc = productcats.iterator();
        while (pc.hasNext()) {
            Prodcat.add(pc.next().getProductCategory());
        }

        modelAndView.addObject("ProdCat", Prodcat);
        modelAndView.addObject("pbase", new ProductBase());
        return modelAndView;
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public ModelAndView addingProduct(@ModelAttribute ProductBase pbase, @RequestParam("pcat") String pcat) {

        List<ProductBase> currentpbases = pbaseService.getProducts();
        List<ProductCategoryBase> productcats = pcbaseService.getProductCategoryBases();
        System.out.println(currentpbases);
        ModelAndView modelAndView = new ModelAndView("products/list-of-products");

        ProductCategoryBase pcid = null;

        for (ProductCategoryBase pc : productcats) {
            if (pc.getProductCategory().equalsIgnoreCase(pcat)) {
                pcid = pc;
                break;
            }
        }

        pbase.setProductCategoryId(pcid);

        try {

            pbaseService.addProduct(pbase);
            logger.info("Product "+pbase.getProductCode()+" was successfully added!!");

            String message = "Product was successfully added!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Product Adding Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            ProductBase currentpbase = pbaseService.getProduct(pbase.getPid());
            if (currentpbase != null) {
                String message1 = "Product ID Already Exist!!!";
                modelAndView.addObject("message1", message1);
            } else {
                ProductCategoryBase currentpcbase = pcbaseService.getProductCategoryBase(pbase.getProductCategoryId().getProductCategoryId());
                if (currentpcbase == null) {
                    String message1 = "Product Category ID Not Found!!!";
                    modelAndView.addObject("message1", message1);
                } else {
                    String message1 = "Product Adding Failed!!";
                    modelAndView.addObject("message1", message1);
                }
            }

        } catch (Exception ex) {
            String message1 = "Product Adding Failed!!";
            modelAndView.addObject("message1", message1);
        }

        List<ProductBase> pbases = pbaseService.getProducts();

        modelAndView.addObject("pbases", pbases);

        return modelAndView;
    }

    @RequestMapping(value = "/listProducts")
    public ModelAndView listOfProducts() {
        ModelAndView modelAndView = new ModelAndView("products/list-of-products");

        List<ProductBase> pbases = pbaseService.getProducts();
        modelAndView.addObject("pbases", pbases);

        return modelAndView;
    }

 
    @RequestMapping(value = "/editProduct/{id}", method = RequestMethod.GET)
    public ModelAndView editProductPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("products/edit-product-form");
        ProductBase pbase = pbaseService.getProduct(id);

        List<ProductCategoryBase> productcats = pcbaseService.getProductCategoryBases();
        List<String> Prodcats = new ArrayList<String>();

        Iterator<ProductCategoryBase> pc = productcats.iterator();
        while (pc.hasNext()) {
            Prodcats.add(pc.next().getProductCategory());
        }

        ProductCategoryBase pcid = null;

        for (ProductCategoryBase ptype : productcats) {
            
            if (ptype.getProductCategoryId()==(pbase.getProductCategoryId().getProductCategoryId())) {
                pcid = ptype;
                break;
            }
        }

        Prodcats.remove(pcid.getProductCategory());

        modelAndView.addObject("ProdCats", Prodcats);
        modelAndView.addObject("ProdCat", pcid.getProductCategory());
        modelAndView.addObject("pbase", pbase);
        return modelAndView;
    }

    @RequestMapping(value = "/editProduct/{id}", method = RequestMethod.POST)
    public ModelAndView edditingProduct(@ModelAttribute ProductBase pbase, @PathVariable Integer id, @RequestParam("pcat") String pcat) {

        ModelAndView modelAndView = new ModelAndView("products/list-of-products");

        List<ProductCategoryBase> productcats = pcbaseService.getProductCategoryBases();
        ProductCategoryBase pcid = null;

        for (ProductCategoryBase pc : productcats) {
            if (pc.getProductCategory().equalsIgnoreCase(pcat)) {
                pcid = pc;
                break;
            }
        }

        pbase.setProductCategoryId(pcid);

        try {
            pbaseService.updateProduct(pbase);

            logger.info("Product "+pbase.getProductCode()+" was successfully edited!!");
            String message = "Product was successfully edited!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Product Editing Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            ProductCategoryBase currentpcbase = pcbaseService.getProductCategoryBase(pbase.getProductCategoryId().getProductCategoryId());
            if (currentpcbase == null) {
                String message1 = "Product Category ID Not Found!!!";
                modelAndView.addObject("message1", message1);
            } else {
                String message1 = "Product Editing Failed!!";
                modelAndView.addObject("message1", message1);
            }

        } catch (Exception ex) {
            String message1 = "Product Editing Failed!!";
            modelAndView.addObject("message1", message1);
        }

        List<ProductBase> pbases = pbaseService.getProducts();
        modelAndView.addObject("pbases", pbases);

        return modelAndView;
    }

    @RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.GET)
    public ModelAndView deleteProduct(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("products/list-of-products");

        try {
            pbaseService.deleteProduct(id);
            logger.info("Product "+id+" was successfully deleted!!");
            String message = "Product was successfully deleted!!.";
            modelAndView.addObject("message", message);
        } catch (Exception ex) {

            String message1 = ex.getMessage();
            modelAndView.addObject("message1", message1);

        }

        List<ProductBase> pbases = pbaseService.getProducts();
        modelAndView.addObject("pbases", pbases);

        return modelAndView;
    }

}

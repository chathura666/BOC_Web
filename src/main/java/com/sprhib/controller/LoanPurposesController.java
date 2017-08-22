/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.controller;

import com.sprhib.model.LoanPurposes;
import com.sprhib.model.ProductCategoryBase;
import com.sprhib.service.AreaBaseService;
import com.sprhib.service.LoanPurposesService;
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
@RequestMapping(value = "/LoanPurposes")
public class LoanPurposesController {

    @Autowired
    LoanPurposesService loanService;

    @Autowired
    Product_Category_BaseService pcatService;

    final static Logger logger = Logger.getLogger(LoanPurposesController.class);

    @RequestMapping(value = "/addPurposes", method = RequestMethod.GET)
    public ModelAndView addLoanPurposes() {
        ModelAndView modelAndView = new ModelAndView("loan_purposes/add-loan-purposes");

        List<ProductCategoryBase> productCats = pcatService.getProductCategoryBases();
        List<String> ProdCat = new ArrayList<String>();

        Iterator<ProductCategoryBase> pcat = productCats.iterator();
        while (pcat.hasNext()) {
            ProdCat.add(pcat.next().getProductCategory());
        }

        modelAndView.addObject("pcat", ProdCat);
        modelAndView.addObject("loan", new LoanPurposes());
        return modelAndView;
    }

    @RequestMapping(value = "/addPurposes", method = RequestMethod.POST)
    public ModelAndView addingLoanPurposes(@ModelAttribute LoanPurposes loan, @RequestParam("pcat") String pcat) {

        ModelAndView modelAndView = new ModelAndView("loan_purposes/list-of-loan-purposes");

        List<ProductCategoryBase> prodcats = pcatService.getProductCategoryBases();

        ProductCategoryBase prodcat = null;

        for (ProductCategoryBase pb : prodcats) {
            if (pb.getProductCategory().equalsIgnoreCase(pcat)) {
                prodcat = pb;
                break;
            }
        }

        loan.setProductCategoryId(prodcat);

        try {
            loanService.addLoanPurposes(loan);

            logger.info("Loan Purpose Record Inserted... : " + loan.getPid() + "_" + loan.getLoanPurposes() + "_" + loan.getProductCategoryId());

            String message = "Record was successfully added!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Record Adding Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            LoanPurposes currentloan = loanService.getLoanPurposes(loan.getPid());
            if (currentloan != null) {
                String message1 = "Record Already Exist!!!";

                modelAndView.addObject("message1", message1);
            } else {
                String message1 = ex.getMessage();
                //String message1 = "Area Adding Failed!!";
                modelAndView.addObject("message1", message1);
            }
        } catch (Exception ex) {
            String message1 = ex.getMessage();
            //String message1 = "Area Adding Failed!!";
            modelAndView.addObject("message1", message1);
        }
        List<LoanPurposes> loans = loanService.getLoanPurposes();

        modelAndView.addObject(
                "loans", loans);
        return modelAndView;
    }

    @RequestMapping(value = "/listPurposes")
    public ModelAndView listOfLoanPurposes() {
        ModelAndView modelAndView = new ModelAndView("loan_purposes/list-of-loan-purposes");

        List<LoanPurposes> loans = loanService.getLoanPurposes();
        modelAndView.addObject("loans", loans);

        return modelAndView;
    }

    @RequestMapping(value = "/editPurposes/{id}", method = RequestMethod.GET)
    public ModelAndView editLoanPurposes(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("loan_purposes/edit-loan-purposes");
        LoanPurposes loan = loanService.getLoanPurposes(id);

        List<ProductCategoryBase> AllCategories = pcatService.getProductCategoryBases();
        List<String> Prodcats = new ArrayList<String>();

        Iterator<ProductCategoryBase> pcat = AllCategories.iterator();
        while (pcat.hasNext()) {
            Prodcats.add(pcat.next().getProductCategory());
        }
        
         List<ProductCategoryBase> prodcats = pcatService.getProductCategoryBases();

        ProductCategoryBase prodcat = null;

        for (ProductCategoryBase pb : prodcats) {
            if (pb.getProductCategoryId().equals(loan.getProductCategoryId().getProductCategoryId())) {
                prodcat = pb;
                break;
            }
        }
        
        Prodcats.remove(prodcat.getProductCategory());
        
        modelAndView.addObject("ProdCats", Prodcats);
        modelAndView.addObject("ProdCat", prodcat.getProductCategory());

        modelAndView.addObject("loan", loan);
        return modelAndView;
    }

    @RequestMapping(value = "/editPurposes/{id}", method = RequestMethod.POST)
    public ModelAndView editingLoanPurposes(@ModelAttribute LoanPurposes loan, @PathVariable Integer id, @RequestParam("pcat") String pcat) {

        ModelAndView modelAndView = new ModelAndView("loan_purposes/list-of-loan-purposes");
        
        List<ProductCategoryBase> productCats = pcatService.getProductCategoryBases();
        
        ProductCategoryBase prodcat = null;
        
         for (ProductCategoryBase pc : productCats) {
            if (pc.getProductCategory().equalsIgnoreCase(pcat)) {
                prodcat = pc;
                break;
            }
        }
         
         loan.setProductCategoryId(prodcat);
         
        try {
            loanService.updateLoanPurposes(loan);

            logger.info("Loan Purpose Record Edited... : " + loan.getLoanPurposes());

            String message = "Record was successfully edited!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Record editing Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            LoanPurposes currentloan = loanService.getLoanPurposes(loan.getPid());
            if (currentloan != null) {
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

        List<LoanPurposes> loans = loanService.getLoanPurposes();
        modelAndView.addObject("loans", loans);

        return modelAndView;
    }

    @RequestMapping(value = "/deletePurposes/{id}", method = RequestMethod.GET)
    public ModelAndView deleteLoanPurposes(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("loan_purposes/list-of-loan-purposes");

        try {
            loanService.deleteLoanPurposes(id);

            logger.info("Loan Purpose Record Deleted... : " + id);

            String message = "Record was successfully deleted!!.";
            modelAndView.addObject("message", message);
        } catch (Exception ex) {

            String message1 = ex.getMessage();
            modelAndView.addObject("message1", message1);

        }

        List<LoanPurposes> loans = loanService.getLoanPurposes();
        modelAndView.addObject("loans", loans);

        return modelAndView;
    }

}

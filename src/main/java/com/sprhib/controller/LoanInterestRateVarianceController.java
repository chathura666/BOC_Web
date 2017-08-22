/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.controller;

import com.sprhib.model.LoanInterestRateVariance;
import com.sprhib.service.LoanInterestRateVarianceService;
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
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author it207432
 */
@Controller
@RequestMapping(value = "/LoanInterestRateVariance")
public class LoanInterestRateVarianceController {

    @Autowired
    LoanInterestRateVarianceService varienceService;

    final static Logger logger = Logger.getLogger(LoanInterestRateVariance.class);

    @RequestMapping(value = "/addVariance", method = RequestMethod.GET)
    public ModelAndView addRateVariance() {
        ModelAndView modelAndView = new ModelAndView("loan_interest_rate_variance/add-rate-variance");

        modelAndView.addObject("var", new LoanInterestRateVariance());
        return modelAndView;
    }

    @RequestMapping(value = "/addVariance", method = RequestMethod.POST)
    public ModelAndView addingRateVariance(@ModelAttribute LoanInterestRateVariance var) {

        ModelAndView modelAndView = new ModelAndView("loan_interest_rate_variance/list-of-rate-variances");
        try {
            varienceService.addVariance(var);

            logger.info("Varience Record Inserted... : " + var.getLirvId() + "_" + var.getPid() + "_" + var.getVarianceFixed());

            String message = "Record was successfully added!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Record Adding Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            LoanInterestRateVariance currentvar = varienceService.getVariance(var.getLirvId());
            if (currentvar != null) {
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
        List<LoanInterestRateVariance> vars = varienceService.getVariances();

        modelAndView.addObject(
                "vars", vars);
        return modelAndView;
    }

    @RequestMapping(value = "/listVariances")
    public ModelAndView listOfRateVariances() {
        ModelAndView modelAndView = new ModelAndView("loan_interest_rate_variance/list-of-rate-variances");

        List<LoanInterestRateVariance> vars = varienceService.getVariances();

        modelAndView.addObject("vars", vars);
        return modelAndView;
    }

    @RequestMapping(value = "/editVariance/{id}", method = RequestMethod.GET)
    public ModelAndView editRateVariance(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("loan_interest_rate_variance/edit-rate-variance");
        LoanInterestRateVariance var = varienceService.getVariance(id);
        modelAndView.addObject("var", var);
        return modelAndView;
    }

    @RequestMapping(value = "/editVariance/{id}", method = RequestMethod.POST)
    public ModelAndView editingRateVariance(@ModelAttribute LoanInterestRateVariance var, @PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("loan_interest_rate_variance/list-of-rate-variances");

        try {
            varienceService.updateVariance(var);

            logger.info("Varience Record Edited... : " + var.getLirvId());

            String message = "Record was successfully edited!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Record editing Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            LoanInterestRateVariance currentvar = varienceService.getVariance(var.getLirvId());
            if (currentvar != null) {
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

        List<LoanInterestRateVariance> vars = varienceService.getVariances();

        modelAndView.addObject("vars", vars);
        return modelAndView;
    }

    @RequestMapping(value = "/deleteVariance/{id}", method = RequestMethod.GET)
    public ModelAndView deleteRateVariance(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("loan_interest_rate_variance/list-of-rate-variances");

        try {
            varienceService.deleteVariance(id);

            logger.info("Area Record Deleted... : " + id);

            String message = "Record was successfully deleted!!.";
            modelAndView.addObject("message", message);
        } catch (Exception ex) {

            String message1 = ex.getMessage();
            modelAndView.addObject("message1", message1);

        }

        List<LoanInterestRateVariance> vars = varienceService.getVariances();

        modelAndView.addObject("vars", vars);
        return modelAndView;
    }

}

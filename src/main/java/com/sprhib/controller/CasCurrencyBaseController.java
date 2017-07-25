/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.controller;

import com.sprhib.model.CasCurrencyBase;
import com.sprhib.service.CasCurrencyBaseService;
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
@RequestMapping(value = "/cascbase")
public class CasCurrencyBaseController {

    @Autowired
    CasCurrencyBaseService currencyService;

    @RequestMapping(value = "/addCurrency", method = RequestMethod.GET)
    public ModelAndView addCasCurrency() {
        ModelAndView modelAndView = new ModelAndView("cascurrency_base/add-cas-currency");
        modelAndView.addObject("cbase", new CasCurrencyBase());
        return modelAndView;
    }

    @RequestMapping(value = "/addCurrency", method = RequestMethod.POST)
    public ModelAndView addingCasCurrency(@ModelAttribute CasCurrencyBase cbase) {

        ModelAndView modelAndView = new ModelAndView("cascurrency_base/list-of-cas-currency");
        try {
            currencyService.addCasCurrency(cbase);

            String message = "Record was successfully added!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Record Adding Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            CasCurrencyBase currentcbase = currencyService.getCasCurrency(cbase.getCurrencyId());
            if (currentcbase != null) {
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
        List<CasCurrencyBase> cbases = currencyService.getCasCurrencies();

        modelAndView.addObject(
                "cbases", cbases);
        return modelAndView;
    }

    @RequestMapping(value = "/listCurrencies")
    public ModelAndView listOfCasCurrencies() {
        ModelAndView modelAndView = new ModelAndView("cascurrency_base/list-of-cas-currency");

        List<CasCurrencyBase> cbases = currencyService.getCasCurrencies();

        modelAndView.addObject(
                "cbases", cbases);
        return modelAndView;
    }

    @RequestMapping(value = "/editCurrency/{id}", method = RequestMethod.GET)
    public ModelAndView editCasCurrency(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("cascurrency_base/edit-cas-currency");
        CasCurrencyBase cbase = currencyService.getCasCurrency(id);
        modelAndView.addObject("cbase", cbase);
        return modelAndView;
    }

    @RequestMapping(value = "/editCurrency/{id}", method = RequestMethod.POST)
    public ModelAndView editingCasCurrency(@ModelAttribute CasCurrencyBase cbase, @PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("cascurrency_base/list-of-cas-currency");

        try {
            currencyService.updateCasCurrency(cbase);

            String message = "Record was successfully edited!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Record editing Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            CasCurrencyBase currentabase = currencyService.getCasCurrency(cbase.getCurrencyId());
            if (currentabase != null) {
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

        List<CasCurrencyBase> cbases = currencyService.getCasCurrencies();

        modelAndView.addObject(
                "cbases", cbases);
        return modelAndView;
    }

    @RequestMapping(value = "/deleteCurrency/{id}", method = RequestMethod.GET)
    public ModelAndView deleteCasCurrency(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("cascurrency_base/list-of-cas-currency");

        try {
            currencyService.deleteCasCurrency(id);
            String message = "Record was successfully deleted!!.";
            modelAndView.addObject("message", message);
        } catch (Exception ex) {

            String message1 = ex.getMessage();
            modelAndView.addObject("message1", message1);

        }

        List<CasCurrencyBase> cbases = currencyService.getCasCurrencies();

        modelAndView.addObject(
                "cbases", cbases);
        return modelAndView;
    }

}

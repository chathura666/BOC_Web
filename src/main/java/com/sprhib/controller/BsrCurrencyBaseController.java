/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.controller;

import com.sprhib.model.AreaBase;
import com.sprhib.model.BsrCurrencyBase;
import com.sprhib.service.BsrCurrencyBaseService;
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
@RequestMapping(value = "/bsrcbase")
public class BsrCurrencyBaseController {

    @Autowired
    BsrCurrencyBaseService currencyService;

    @RequestMapping(value = "/addCurrency", method = RequestMethod.GET)
    public ModelAndView addBsrCurrency() {
        ModelAndView modelAndView = new ModelAndView("bsrcurrency_base/add-bsr-currency");
        modelAndView.addObject("cbase", new BsrCurrencyBase());
        return modelAndView;
    }

    @RequestMapping(value = "/addCurrency", method = RequestMethod.POST)
    public ModelAndView addingBsrCurrency(@ModelAttribute BsrCurrencyBase cbase) {

        ModelAndView modelAndView = new ModelAndView("bsrcurrency_base/list-of-bsr-currency");
        try {
            currencyService.addBsrCurrency(cbase);

            String message = "Record was successfully added!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Record Adding Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            BsrCurrencyBase currentcbase = currencyService.getBsrCurrency(cbase.getCurrencyId());
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
        List<BsrCurrencyBase> cbases = currencyService.getBsrCurrencies();

        modelAndView.addObject(
                "cbases", cbases);
        return modelAndView;
    }

    @RequestMapping(value = "/listCurrencies")
    public ModelAndView listOfBsrCurrencies() {
        ModelAndView modelAndView = new ModelAndView("bsrcurrency_base/list-of-bsr-currency");

        List<BsrCurrencyBase> cbases = currencyService.getBsrCurrencies();

        modelAndView.addObject(
                "cbases", cbases);
        return modelAndView;
    }

    @RequestMapping(value = "/editCurrency/{id}", method = RequestMethod.GET)
    public ModelAndView editBsrCurrency(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("bsrcurrency_base/edit-bsr-currency");
        BsrCurrencyBase cbase = currencyService.getBsrCurrency(id);
        modelAndView.addObject("cbase", cbase);
        return modelAndView;
    }

    @RequestMapping(value = "/editCurrency/{id}", method = RequestMethod.POST)
    public ModelAndView editingBsrCurrency(@ModelAttribute BsrCurrencyBase cbase, @PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("bsrcurrency_base/list-of-bsr-currency");

        try {
            currencyService.updateBsrCurrency(cbase);

            String message = "Record was successfully edited!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Record editing Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            BsrCurrencyBase currentabase = currencyService.getBsrCurrency(cbase.getCurrencyId());
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

        List<BsrCurrencyBase> cbases = currencyService.getBsrCurrencies();

        modelAndView.addObject(
                "cbases", cbases);
        return modelAndView;
    }

    @RequestMapping(value = "/deleteCurrency/{id}", method = RequestMethod.GET)
    public ModelAndView deleteBsrCurrency(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("bsrcurrency_base/list-of-bsr-currency");

        try {
            currencyService.deleteBsrCurrency(id);
            String message = "Record was successfully deleted!!.";
            modelAndView.addObject("message", message);
        } catch (Exception ex) {

            String message1 = ex.getMessage();
            modelAndView.addObject("message1", message1);

        }

        List<BsrCurrencyBase> cbases = currencyService.getBsrCurrencies();

        modelAndView.addObject(
                "cbases", cbases);
        return modelAndView;
    }

}

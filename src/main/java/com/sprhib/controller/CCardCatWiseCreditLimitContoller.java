/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.controller;

import com.sprhib.model.CcCardCategoryWiseCreditLimits;
import com.sprhib.model.PicklistvaluesMaster;
import com.sprhib.service.CcardCategoryWiseCreditLimitService;
import com.sprhib.service.PicklistvaluesMasterService;
import java.util.ArrayList;
import java.util.Iterator;
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
@RequestMapping(value = "/creditlimit")
public class CCardCatWiseCreditLimitContoller {

    @Autowired
    CcardCategoryWiseCreditLimitService cclimitService;

    @Autowired
    PicklistvaluesMasterService pklistServices;

    @RequestMapping(value = "/addCreditLimit", method = RequestMethod.GET)
    public ModelAndView addCreditLimit() {
        ModelAndView modelAndView = new ModelAndView("credit_limit/add-credit-limit");

        List<PicklistvaluesMaster> creditCardType = pklistServices.getCreditCardBrands();
        List<String> MainDropValues = new ArrayList<String>();

        Iterator<PicklistvaluesMaster> typ = creditCardType.iterator();
        while (typ.hasNext()) {
            MainDropValues.add(typ.next().getPicklistCode());
        }

        modelAndView.addObject("creditCardType", MainDropValues);

        List<PicklistvaluesMaster> subType = pklistServices.getCreditCardTypes();
        List<String> SubDropValues = new ArrayList<String>();

        Iterator<PicklistvaluesMaster> sub = subType.iterator();
        while (sub.hasNext()) {
            SubDropValues.add(sub.next().getPickValue());
        }

        modelAndView.addObject("subType", SubDropValues);

        modelAndView.addObject("cclimit", new CcCardCategoryWiseCreditLimits());
        return modelAndView;
    }

    @RequestMapping(value = "/addCreditLimit", method = RequestMethod.POST)
    public ModelAndView addingCreditLimit(@ModelAttribute CcCardCategoryWiseCreditLimits cclimit) {

        List<CcCardCategoryWiseCreditLimits> allcclimit = cclimitService.getCCWiseCreditLimit();
        System.out.println(allcclimit);

        ModelAndView modelAndView = new ModelAndView("credit_limit/list-of-credit-limits");

        try {

            //if(currentpbases.)
            cclimitService.addCCWiseCreditLimit(cclimit);

            String message = "Credit Limit was successfully added!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Credit Limit Adding Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            CcCardCategoryWiseCreditLimits currentcclimit = cclimitService.getCCWiseCreditLimit(cclimit.getCclId());
            if (currentcclimit != null) {
                String message1 = "Credit Limit ID Already Exist!!!";
                modelAndView.addObject("message1", message1);
            } else {

                String message1 = "Credit Limit Adding Failed !!";
                modelAndView.addObject("message1", message1);
            }
        } catch (Exception ex) {
            String message1 = "Credit Limit Adding Failed!!";
            modelAndView.addObject("message1", message1);
        }

        List<CcCardCategoryWiseCreditLimits> creditlimits = cclimitService.getCCWiseCreditLimit();

        modelAndView.addObject("creditlimits", creditlimits);
        return modelAndView;
    }

    @RequestMapping(value = "/listCreditLimits")
    public ModelAndView listCreditLimit() {
        ModelAndView modelAndView = new ModelAndView("credit_limit/list-of-credit-limits");

        List<CcCardCategoryWiseCreditLimits> creditlimits = cclimitService.getCCWiseCreditLimit();

        modelAndView.addObject("creditlimits", creditlimits);
        return modelAndView;
    }

    @RequestMapping(value = "/editCreditLimit/{id}", method = RequestMethod.GET)
    public ModelAndView editCreditLimit(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("credit_limit/edit-credit-limit");
        CcCardCategoryWiseCreditLimits creditlimit = cclimitService.getCCWiseCreditLimit(id);

        List<PicklistvaluesMaster> creditCardType = pklistServices.getCreditCardBrands();
        List<String> MainDropValues = new ArrayList<String>();

        Iterator<PicklistvaluesMaster> typ = creditCardType.iterator();
        while (typ.hasNext()) {
            MainDropValues.add(typ.next().getPicklistCode());
        }

        modelAndView.addObject("creditCardType", MainDropValues);

        List<PicklistvaluesMaster> subType = pklistServices.getCreditCardTypes();
        List<String> SubDropValues = new ArrayList<String>();

        Iterator<PicklistvaluesMaster> sub = subType.iterator();
        while (sub.hasNext()) {
            SubDropValues.add(sub.next().getPickValue());
        }

        modelAndView.addObject("subType", SubDropValues);

        modelAndView.addObject("creditlimit", creditlimit);
        return modelAndView;
    }

    @RequestMapping(value = "/editCreditLimit/{id}", method = RequestMethod.POST)
    public ModelAndView edditingCreditLimit(@ModelAttribute CcCardCategoryWiseCreditLimits creditlimit, @PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("credit_limit/list-of-credit-limits");

        try {
            cclimitService.updateCCWiseCreditLimit(creditlimit);

            String message = "Credit Limit was successfully edited!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Credit Limit Editing Failed!!";
            modelAndView.addObject("message1", message1);
        } catch (Exception ex) {
            String message1 = "Credit Limit Editing Failed!!";
            modelAndView.addObject("message1", message1);
        }

        List<CcCardCategoryWiseCreditLimits> creditlimits = cclimitService.getCCWiseCreditLimit();

        modelAndView.addObject("creditlimits", creditlimits);

        return modelAndView;
    }

    @RequestMapping(value = "/deleteCreditLimit/{id}", method = RequestMethod.GET)
    public ModelAndView deleteCreditLimit(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("credit_limit/list-of-credit-limits");

        try {
            cclimitService.deleteCCWiseCreditLimit(id);
            String message = "Credit Limit was successfully deleted!!.";
            modelAndView.addObject("message", message);
        } catch (Exception ex) {

            String message1 = ex.getMessage();
            modelAndView.addObject("message1", message1);

        }

        List<CcCardCategoryWiseCreditLimits> creditlimits = cclimitService.getCCWiseCreditLimit();
        modelAndView.addObject("creditlimits", creditlimits);

        return modelAndView;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.controller;

import com.sprhib.model.CcCardCategoryWiseEligibilites;
import com.sprhib.model.CcCardCategoryWiseEligibilitesPK;
import com.sprhib.model.PicklistvaluesMaster;
import com.sprhib.service.CcCardCategoryWiseEligibilitesService;
import com.sprhib.service.PicklistvaluesMasterService;
import java.util.AbstractList;
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
@RequestMapping(value = "/cceligibility")
public class CcCardCategoryWiseEligibilitesController {

    @Autowired
    CcCardCategoryWiseEligibilitesService eligibilityService;

    @Autowired
    PicklistvaluesMasterService pklistServices;

    @RequestMapping(value = "/addEligibility", method = RequestMethod.GET)
    public ModelAndView addCCEligibility() {
        ModelAndView modelAndView = new ModelAndView("cc_eligibility/add-cc-eligibility");

        List<PicklistvaluesMaster> creditCardType = pklistServices.getCreditCardBrands();
        List<String> MainDropValues = new ArrayList<String>();

        Iterator<PicklistvaluesMaster> typ = creditCardType.iterator();
        while (typ.hasNext()) {
            MainDropValues.add(typ.next().getPicklistCode());
        }

        modelAndView.addObject("creditBrand", MainDropValues);

        List<PicklistvaluesMaster> subType = pklistServices.getCreditCardTypes();
        List<String> SubDropValues = new ArrayList<String>();

        Iterator<PicklistvaluesMaster> sub = subType.iterator();
        while (sub.hasNext()) {
            SubDropValues.add(sub.next().getPickValue());
        }

        modelAndView.addObject("creditType", SubDropValues);

        List<PicklistvaluesMaster> subCat = pklistServices.getCreditCardSubcategories();
        List<String> SubCatValues = new ArrayList<String>();

        Iterator<PicklistvaluesMaster> category = subCat.iterator();
        while (category.hasNext()) {
            SubCatValues.add(category.next().getPickValue());
        }

        modelAndView.addObject("subCategory", SubCatValues);

        modelAndView.addObject("eligibility", new CcCardCategoryWiseEligibilitesPK());
        return modelAndView;
    }

    @RequestMapping(value = "/addEligibility", method = RequestMethod.POST)
    public ModelAndView addingCCEligibility(@ModelAttribute CcCardCategoryWiseEligibilitesPK eligibility) {

        ModelAndView modelAndView = new ModelAndView("cc_eligibility/list-of-cc-eligibilities");

        CcCardCategoryWiseEligibilites cardCategoryWiseEligibilites = new CcCardCategoryWiseEligibilites(eligibility);

        try {

            eligibilityService.addCCWiseEligibility(cardCategoryWiseEligibilites);

            String message = "Credit Card Category Wise Eligibility was successfully added!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Credit Card Category Wise Eligibility Adding Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            CcCardCategoryWiseEligibilites currenteligibility = eligibilityService.getCCWiseEligibility(cardCategoryWiseEligibilites.getCcCardCategoryWiseEligibilitesPK());
            if (currenteligibility != null) {
                String message1 = "Credit Card Category Wise Eligibility ID Already Exist!!!";
                modelAndView.addObject("message1", message1);
            } else {

                String message1 = "Credit Card Category Wise Eligibility Adding Failed !!";
                modelAndView.addObject("message1", message1);
            }
        } catch (Exception ex) {
            String message1 = "Credit Card Category Wise Eligibility Adding Failed!!";
            modelAndView.addObject("message1", message1);
        }

        List<CcCardCategoryWiseEligibilites> eligibilites = eligibilityService.getCCWiseEligibilities();

        List<CcCardCategoryWiseEligibilitesPK> PKlist = new ArrayList<CcCardCategoryWiseEligibilitesPK>();

        Iterator<CcCardCategoryWiseEligibilites> list = eligibilites.iterator();
        CcCardCategoryWiseEligibilites temp;

        while (list.hasNext()) {
            temp = list.next();
            PKlist.add(temp.getCcCardCategoryWiseEligibilitesPK());
        }
        modelAndView.addObject("eligibilities", PKlist);
        return modelAndView;
    }

    @RequestMapping(value = "/listEligibilities")
    public ModelAndView listCCEligibilities() {
        ModelAndView modelAndView = new ModelAndView("cc_eligibility/list-of-cc-eligibilities");

        List<CcCardCategoryWiseEligibilites> eligibilites = eligibilityService.getCCWiseEligibilities();

        List<CcCardCategoryWiseEligibilitesPK> PKlist = new ArrayList<CcCardCategoryWiseEligibilitesPK>();

        Iterator<CcCardCategoryWiseEligibilites> list = eligibilites.iterator();
        CcCardCategoryWiseEligibilites temp;

        while (list.hasNext()) {
            temp = list.next();
            PKlist.add(temp.getCcCardCategoryWiseEligibilitesPK());
        }
        modelAndView.addObject("eligibilities", PKlist);
        return modelAndView;
    }

    @RequestMapping(value = "/editEligibility/{id}", method = RequestMethod.GET)
    public ModelAndView editCCEligibility(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("cc_eligibility/edit-cc-eligibility");

        List<CcCardCategoryWiseEligibilites> listall = eligibilityService.getCCWiseEligibilities();
        Iterator<CcCardCategoryWiseEligibilites> eligible = listall.iterator();

        CcCardCategoryWiseEligibilites tempcc = null;
        CcCardCategoryWiseEligibilitesPK temppk = null;

        while (eligible.hasNext()) {
            tempcc = eligible.next();
            if (tempcc.getCcCardCategoryWiseEligibilitesPK().getCceId() == id) {
                temppk = tempcc.getCcCardCategoryWiseEligibilitesPK();
            }
        }
        
        CcCardCategoryWiseEligibilites eligibility = eligibilityService.getCCWiseEligibility(temppk);

        List<PicklistvaluesMaster> creditCardBrand = pklistServices.getCreditCardBrands();
        List<String> MainDropValues = new ArrayList<String>();

        Iterator<PicklistvaluesMaster> brand = creditCardBrand.iterator();
        while (brand.hasNext()) {
            MainDropValues.add(brand.next().getPicklistCode());
        }

        modelAndView.addObject("creditCardBrand", MainDropValues);

        List<PicklistvaluesMaster> creditcardType = pklistServices.getCreditCardTypes();
        List<String> SubDropValues = new ArrayList<String>();

        Iterator<PicklistvaluesMaster> type = creditcardType.iterator();
        while (type.hasNext()) {
            SubDropValues.add(type.next().getPickValue());
        }

        modelAndView.addObject("creditCardType", SubDropValues);

        List<PicklistvaluesMaster> creditcardCategory = pklistServices.getCreditCardSubcategories();
        List<String> CatDropValues = new ArrayList<String>();

        Iterator<PicklistvaluesMaster> category = creditcardCategory.iterator();
        while (category.hasNext()) {
            CatDropValues.add(category.next().getPickValue());
        }

        modelAndView.addObject("creditCardCategory", CatDropValues);

        modelAndView.addObject("eligibility", eligibility.getCcCardCategoryWiseEligibilitesPK());
        return modelAndView;
    }

    @RequestMapping(value = "/editEligibility/{id}", method = RequestMethod.POST)
    public ModelAndView edditingCCEligibility(@ModelAttribute CcCardCategoryWiseEligibilitesPK eligibility, @PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("cc_eligibility/list-of-cc-eligibilities");
        CcCardCategoryWiseEligibilites cardCategoryWiseEligibilites = new CcCardCategoryWiseEligibilites(eligibility);
        try {
            eligibilityService.updateCCWiseEligibility(cardCategoryWiseEligibilites);

            String message = "Credit Card Category Wise Eligibility was successfully edited!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Credit Card Category Wise Eligibility Editing Failed!!";
            modelAndView.addObject("message1", message1);
        } catch (Exception ex) {
            String message1 = "Credit Card Category Wise Eligibility Editing Failed!!";
            modelAndView.addObject("message1", message1);
        }

         List<CcCardCategoryWiseEligibilites> eligibilites = eligibilityService.getCCWiseEligibilities();

        List<CcCardCategoryWiseEligibilitesPK> PKlist = new ArrayList<CcCardCategoryWiseEligibilitesPK>();

        Iterator<CcCardCategoryWiseEligibilites> list = eligibilites.iterator();
        CcCardCategoryWiseEligibilites temp;

        while (list.hasNext()) {
            temp = list.next();
            PKlist.add(temp.getCcCardCategoryWiseEligibilitesPK());
        }
        modelAndView.addObject("eligibilities", PKlist);
        return modelAndView;
    }

    @RequestMapping(value = "/deleteEligibility/{id}", method = RequestMethod.GET)
    public ModelAndView deleteCCEligibility(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("cc_eligibility/list-of-cc-eligibilities");

        List<CcCardCategoryWiseEligibilites> listall = eligibilityService.getCCWiseEligibilities();
        Iterator<CcCardCategoryWiseEligibilites> eligible = listall.iterator();

        CcCardCategoryWiseEligibilites tempcc = null;
        CcCardCategoryWiseEligibilitesPK temppk = null;

        while (eligible.hasNext()) {
            tempcc = eligible.next();
            if (tempcc.getCcCardCategoryWiseEligibilitesPK().getCceId() == id) {
                temppk = tempcc.getCcCardCategoryWiseEligibilitesPK();
            }
        }

        CcCardCategoryWiseEligibilites cardCategoryWiseEligibilites = new CcCardCategoryWiseEligibilites(temppk);

        try {
            eligibilityService.deleteCCWiseEligibility(cardCategoryWiseEligibilites);
            String message = "Credit Card Category Wise Eligibility was successfully deleted!!.";
            modelAndView.addObject("message", message);
        } catch (Exception ex) {

            String message1 = ex.getMessage();
            modelAndView.addObject("message1", message1);

        }

        List< CcCardCategoryWiseEligibilites> eligibilites = eligibilityService.getCCWiseEligibilities();

        List<CcCardCategoryWiseEligibilitesPK> PKlist = new ArrayList<CcCardCategoryWiseEligibilitesPK>();

        Iterator<CcCardCategoryWiseEligibilites> list = eligibilites.iterator();
        CcCardCategoryWiseEligibilites temp;

        while (list.hasNext()) {
            temp = list.next();
            PKlist.add(temp.getCcCardCategoryWiseEligibilitesPK());
        }
        modelAndView.addObject("eligibilities", PKlist);
        return modelAndView;
    }

}

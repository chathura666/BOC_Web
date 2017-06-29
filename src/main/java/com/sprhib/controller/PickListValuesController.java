/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.controller;

import com.sprhib.model.PicklistvaluesMaster;
import com.sprhib.service.PicklistvaluesMasterService;
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
@RequestMapping(value = "/picklist")
public class PickListValuesController {

    @Autowired
    PicklistvaluesMasterService pickService;

    @RequestMapping(value = "/addPickList", method = RequestMethod.GET)
    public ModelAndView addPickListValues() {
        ModelAndView modelAndView = new ModelAndView("add-picklist-value");
        modelAndView.addObject("pklist", new PicklistvaluesMaster());
        return modelAndView;
    }

    @RequestMapping(value = "/addPickList", method = RequestMethod.POST)
    public ModelAndView addingPickListValues(@ModelAttribute PicklistvaluesMaster plist) {

        List<PicklistvaluesMaster> allpklist = pickService.getPickListValues();
        System.out.println(allpklist);

        ModelAndView modelAndView = new ModelAndView("list-of-picklist");

        try {
            //if(currentpbases.)
            pickService.addPickListValue(plist);

            String message = "Picklist Value was successfully added!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Picklist Value Adding Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            PicklistvaluesMaster currentpklist = pickService.getPickListValue(plist.getPicklistId());
            if (currentpklist != null) {
                String message1 = "Picklist ID Already Exist!!!";
                modelAndView.addObject("message1", message1);
            } else {
                String message1 = "Product Adding Failed!!";
                modelAndView.addObject("message1", message1);
            }
        } catch (Exception ex) {
            String message1 = "Product Adding Failed!!";
            modelAndView.addObject("message1", message1);
        }
        List<PicklistvaluesMaster> allpklistafter = pickService.getPickListValues();

        modelAndView.addObject("pklist", allpklistafter);
        return modelAndView;
    }

    @RequestMapping(value = "/listPickList")
    public ModelAndView listOfPickListValues() {
        ModelAndView modelAndView = new ModelAndView("list-of-picklist");

        List<PicklistvaluesMaster> pklist = pickService.getPickListValues();
        modelAndView.addObject("pklist", pklist);

        return modelAndView;
    }

    @RequestMapping(value = "/editPickList/{id}", method = RequestMethod.GET)
    public ModelAndView editPickListValues(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("edit-picklist-value");
        PicklistvaluesMaster pklist = pickService.getPickListValue(id);
        modelAndView.addObject("pklist", pklist);
        return modelAndView;
    }

    @RequestMapping(value = "/editPickList/{id}", method = RequestMethod.POST)
    public ModelAndView edditingProduct(@ModelAttribute PicklistvaluesMaster picklist, @PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("list-of-picklist");

        try {
            pickService.updatePickListValue(picklist);

            String message = "PickList was successfully edited!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Product Editing Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            String message1 = "PickList Editing Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (Exception ex) {
            String message1 = "PickList Editing Failed!!";
            modelAndView.addObject("message1", message1);
        }

        List<PicklistvaluesMaster> pklist = pickService.getPickListValues();
        modelAndView.addObject("pklist", pklist);

        return modelAndView;
    }

    @RequestMapping(value = "/deletePickList/{id}", method = RequestMethod.GET)
    public ModelAndView deletePickListValue(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("list-of-picklist");

        try {
            pickService.deletePickListValue(id);
            String message = "PickList was successfully deleted!!.";
            modelAndView.addObject("message", message);
        } catch (Exception ex) {

            String message1 = ex.getMessage();
            modelAndView.addObject("message1", message1);

        }

        List<PicklistvaluesMaster> pklist = pickService.getPickListValues();
        modelAndView.addObject("pklist", pklist);

        return modelAndView;
    }

}

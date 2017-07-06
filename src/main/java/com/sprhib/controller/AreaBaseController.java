/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.controller;

import com.sprhib.model.AreaBase;
import com.sprhib.service.AreaBaseService;
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
@RequestMapping(value = "/abase")
public class AreaBaseController {

    @Autowired
    AreaBaseService abaseService;

    @RequestMapping(value = "/addAreaBase", method = RequestMethod.GET)
    public ModelAndView addAreaBase() {
        ModelAndView modelAndView = new ModelAndView("add-area-base");
        modelAndView.addObject("abase", new AreaBase());
        return modelAndView;
    }

    @RequestMapping(value = "/addAreaBase", method = RequestMethod.POST)
    public ModelAndView addingAreaBase(@ModelAttribute AreaBase abase) {

        ModelAndView modelAndView = new ModelAndView("list-of-area-bases");
        try {
            abaseService.addAreaBase(abase);

            String message = "Area was successfully added!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Area Adding Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            AreaBase currentabase = abaseService.getAreaBase(abase.getAid());
            if (currentabase != null) {
                String message1 = "Area Already Exist!!!";
                modelAndView.addObject("message1", message1);
            } else {
                String message1 = "Area Adding Failed!!";
                modelAndView.addObject("message1", message1);
            }
        } catch (Exception ex) {
            String message1 = "Area Adding Failed!!";
            modelAndView.addObject("message1", message1);
        }
        List<AreaBase> abases = abaseService.getAreaBases();

        modelAndView.addObject(
                "abases", abases);
        return modelAndView;
    }

    @RequestMapping(value = "/listAreaBases")
    public ModelAndView listOfAreaBases() {
        ModelAndView modelAndView = new ModelAndView("list-of-area-bases");

        List<AreaBase> abases = abaseService.getAreaBases();
        modelAndView.addObject("abases", abases);

        return modelAndView;
    }

    @RequestMapping(value = "/editAreaBase/{id}", method = RequestMethod.GET)
    public ModelAndView editAreaBase(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("edit-area-base");
        AreaBase abase = abaseService.getAreaBase(id);
        modelAndView.addObject("abase", abase);
        return modelAndView;
    }

    @RequestMapping(value = "/editAreaBase/{id}", method = RequestMethod.POST)
    public ModelAndView editingAreaBase(@ModelAttribute AreaBase abase, @PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("list-of-area-bases");

        try {
           abaseService.updateAreaBase(abase);

            String message = "Area was successfully edited!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Area editing Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            AreaBase currentabase = abaseService.getAreaBase(abase.getAid());
            if (currentabase != null) {
                String message1 = "Area Code With Same ID Already Exist!!!";
                modelAndView.addObject("message1", message1);
            } else {
                String message1 = "Area Editing Failed!!";
                modelAndView.addObject("message1", message1);
            }
        } catch (Exception ex) {
            String message1 = "Area Editing Failed!!";
            modelAndView.addObject("message1", message1);
        }

        List<AreaBase> abases = abaseService.getAreaBases();
        modelAndView.addObject("abases", abases);

        return modelAndView;
    }

    @RequestMapping(value = "/deleteAreaBase/{id}", method = RequestMethod.GET)
    public ModelAndView deleteAreaBase(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("list-of-area-bases");

        try {
            abaseService.deleteAreaBase(id);
            String message = "Area was successfully deleted!!.";
            modelAndView.addObject("message", message);
        } catch (Exception ex) {

            String message1 = ex.getMessage();
            modelAndView.addObject("message1", message1);

        }

        List<AreaBase> abases = abaseService.getAreaBases();
        modelAndView.addObject("abases", abases);

        return modelAndView;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.controller;

import com.sprhib.model.AreaBase;
import com.sprhib.service.AreaBaseService;
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
@RequestMapping(value = "/AreaBase")
public class AreaBaseController {

    @Autowired
    AreaBaseService abaseService;
    
    final static Logger logger = Logger.getLogger(AreaBaseController.class);

    @RequestMapping(value = "/addBase", method = RequestMethod.GET)
    public ModelAndView addAreaBase() {
        ModelAndView modelAndView = new ModelAndView("area_base/add-area-base");

        modelAndView.addObject("abase", new AreaBase());
        return modelAndView;
    }

    @RequestMapping(value = "/addBase", method = RequestMethod.POST)
    public ModelAndView addingAreaBase(@ModelAttribute AreaBase abase) {

        ModelAndView modelAndView = new ModelAndView("area_base/list-of-area-bases");
        try {
            abaseService.addAreaBase(abase);
            
            logger.info("Area Record Inserted... : "+abase.getAid()+"_"+abase.getAreaCode()+"_"+abase.getAreaName());

            String message = "Record was successfully added!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Record Adding Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            AreaBase currentabase = abaseService.getAreaBase(abase.getAid());
            if (currentabase != null) {
                String message1 = "Record Already Exist!!!";
                
                modelAndView.addObject("message1", message1);
            } else {
                String message1 = ex.getMessage();
                //String message1 = "Area Adding Failed!!";
                modelAndView.addObject("message1", message1);
            }
        } catch (Exception ex) {
            String message1 =ex.getMessage();
            //String message1 = "Area Adding Failed!!";
            modelAndView.addObject("message1", message1);
        }
        List<AreaBase> abases = abaseService.getAreaBases();

        modelAndView.addObject(
                "abases", abases);
        return modelAndView;
    }

    @RequestMapping(value = "/listBases")
    public ModelAndView listOfAreaBases() {
        ModelAndView modelAndView = new ModelAndView("area_base/list-of-area-bases");

        List<AreaBase> abases = abaseService.getAreaBases();
        modelAndView.addObject("abases", abases);

        return modelAndView;
    }

    @RequestMapping(value = "/editBase/{id}", method = RequestMethod.GET)
    public ModelAndView editAreaBase(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("area_base/edit-area-base");
        AreaBase abase = abaseService.getAreaBase(id);
        modelAndView.addObject("abase", abase);
        return modelAndView;
    }

    @RequestMapping(value = "/editBase/{id}", method = RequestMethod.POST)
    public ModelAndView editingAreaBase(@ModelAttribute AreaBase abase, @PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("area_base/list-of-area-bases");

        try {
            abaseService.updateAreaBase(abase);
            
            logger.info("Area Record Edited... : "+abase.getAid());
            
            String message = "Record was successfully edited!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Record editing Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            AreaBase currentabase = abaseService.getAreaBase(abase.getAid());
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

        List<AreaBase> abases = abaseService.getAreaBases();
        modelAndView.addObject("abases", abases);

        return modelAndView;
    }

    @RequestMapping(value = "/deleteBase/{id}", method = RequestMethod.GET)
    public ModelAndView deleteAreaBase(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("area_base/list-of-area-bases");

        try {
            abaseService.deleteAreaBase(id);
            
            logger.info("Area Record Deleted... : "+id);
            
            String message = "Record was successfully deleted!!.";
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

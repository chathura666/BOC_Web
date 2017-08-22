/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.controller;

import com.sprhib.model.CollateralBase;
import com.sprhib.service.CollateralBaseService;
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
@RequestMapping(value = "/CollateralBase")
public class CollateralBaseController {

    @Autowired
    CollateralBaseService cbaseService;
    
    final static Logger logger = Logger.getLogger(CollateralBaseController.class);

    @RequestMapping(value = "/addBase", method = RequestMethod.GET)
    public ModelAndView addCollateralBase() {
        ModelAndView modelAndView = new ModelAndView("collateral_base/add-collateral-base");

        modelAndView.addObject("cbase", new CollateralBase());
        return modelAndView;
    }

    @RequestMapping(value = "/addBase", method = RequestMethod.POST)
    public ModelAndView addingCollateralBase(@ModelAttribute CollateralBase cbase) {

        ModelAndView modelAndView = new ModelAndView("collateral_base/list-of-collateral-bases");
        try {
            cbaseService.addCollateralBase(cbase);
            
            logger.info("Collateral Record Inserted... : "+cbase.getCid()+"_"+cbase.getCollateralCode()+"_"+cbase.getCollateralDescription());

            String message = "Record was successfully added!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Record Adding Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            CollateralBase currentcbase = cbaseService.getCollateralBase(cbase.getCid());
            if (currentcbase != null) {
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
        List<CollateralBase> cbases = cbaseService.getCollateralBases();

        modelAndView.addObject(
                "cbases", cbases);
        return modelAndView;
    }

    @RequestMapping(value = "/listBases")
    public ModelAndView listOfCollateralBases() {
        ModelAndView modelAndView = new ModelAndView("collateral_base/list-of-collateral-bases");

        List<CollateralBase> cbases = cbaseService.getCollateralBases();
        modelAndView.addObject("cbases", cbases);

        return modelAndView;
    }

    @RequestMapping(value = "/editBase/{id}", method = RequestMethod.GET)
    public ModelAndView editCollateralBase(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("collateral_base/edit-collateral-base");
        CollateralBase cbase = cbaseService.getCollateralBase(id);
        modelAndView.addObject("cbase", cbase);
        return modelAndView;
    }

    @RequestMapping(value = "/editBase/{id}", method = RequestMethod.POST)
    public ModelAndView editingCollateralBase(@ModelAttribute CollateralBase cbase, @PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("collateral_base/list-of-collateral-bases");

        try {
            cbaseService.updateCollateralBase(cbase);
            
            logger.info("Area Record Edited... : "+cbase.getCollateralCode());
            
            String message = "Record was successfully edited!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Record editing Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            CollateralBase currentabase = cbaseService.getCollateralBase(cbase.getCid());
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

        List<CollateralBase> cbases = cbaseService.getCollateralBases();
        modelAndView.addObject("cbases", cbases);

        return modelAndView;
    }

    @RequestMapping(value = "/deleteBase/{id}", method = RequestMethod.GET)
    public ModelAndView deleteCollateralBase(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("collateral_base/list-of-area-bases");

        try {
            cbaseService.deleteCollateralBase(id);
            
            logger.info("Area Record Deleted... : "+id);
            
            String message = "Record was successfully deleted!!.";
            modelAndView.addObject("message", message);
        } catch (Exception ex) {

            String message1 = ex.getMessage();
            modelAndView.addObject("message1", message1);

        }

        List<CollateralBase> cbases = cbaseService.getCollateralBases();
        modelAndView.addObject("cbases", cbases);

        return modelAndView;
    }

}

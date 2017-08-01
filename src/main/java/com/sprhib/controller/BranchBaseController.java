/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.controller;

import com.sprhib.model.BranchBase;
import com.sprhib.service.BranchBaseService;
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
@RequestMapping(value = "/BranchBase")
public class BranchBaseController {

    @Autowired
    BranchBaseService bbaseService;
    
    final static Logger logger = Logger.getLogger(BranchBaseController.class);

    @RequestMapping(value = "/addBase", method = RequestMethod.GET)
    public ModelAndView addBranchBase() {
        ModelAndView modelAndView = new ModelAndView("branch_base/add-branch-base");
        modelAndView.addObject("bbase", new BranchBase());
        return modelAndView;
    }

    @RequestMapping(value = "/addBase", method = RequestMethod.POST)
    public ModelAndView addingBranchBase(@ModelAttribute BranchBase bbase) {

        ModelAndView modelAndView = new ModelAndView("branch_base/list-of-branch-bases");
        try {
            bbaseService.addBranchBase(bbase);

            String message = "Record was successfully added!!.";
            logger.info("Branch record Inserted "+bbase.getBid()+"_"+bbase.getBranchCode()+"_"+bbase.getBranchName());
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Record Adding Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            BranchBase currentbbase = bbaseService.getBranchBase(bbase.getBid());
            if (currentbbase != null) {
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
        List<BranchBase> bbases = bbaseService.getBranchBases();

        modelAndView.addObject(
                "bbases", bbases);
        return modelAndView;
    }

    @RequestMapping(value = "/listBases")
    public ModelAndView listOfBranchBases() {
        ModelAndView modelAndView = new ModelAndView("branch_base/list-of-branch-bases");

        List<BranchBase> abases = bbaseService.getBranchBases();
        modelAndView.addObject("bbases", abases);

        return modelAndView;
    }

    @RequestMapping(value = "/editBase/{id}", method = RequestMethod.GET)
    public ModelAndView editBranchBase(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("branch_base/edit-branch-base");
        BranchBase bbase = bbaseService.getBranchBase(id);
        modelAndView.addObject("bbase", bbase);
        return modelAndView;
    }

    @RequestMapping(value = "/editBase/{id}", method = RequestMethod.POST)
    public ModelAndView editingBranchBase(@ModelAttribute BranchBase bbase, @PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("branch_base/list-of-branch-bases");

        try {
           bbaseService.updateBranchBase(bbase);

            String message = "Record was successfully edited!!.";
            
            logger.info("Branch record Edited.. BID: "+bbase.getBid());
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Record editing Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            BranchBase currentbbase = bbaseService.getBranchBase(bbase.getBid());
            if (currentbbase != null) {
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

        List<BranchBase> bbases = bbaseService.getBranchBases();
        modelAndView.addObject("bbases", bbases);

        return modelAndView;
    }

    @RequestMapping(value = "/deleteBase/{id}", method = RequestMethod.GET)
    public ModelAndView deleteBranchBase(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("branch_base/list-of-branch-bases");

        try {
            bbaseService.deleteBranchBase(id);
            String message = "Record was successfully deleted!!.";
            
            logger.info("Branch record Edited.. BID: "+id);
            modelAndView.addObject("message", message);
        } catch (Exception ex) {

            String message1 = ex.getMessage();
            modelAndView.addObject("message1", message1);

        }

        List<BranchBase> bbases = bbaseService.getBranchBases();
        modelAndView.addObject("bbases", bbases);

        return modelAndView;
    }

}

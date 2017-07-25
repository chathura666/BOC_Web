/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.controller;

import com.sprhib.model.AreaBase;
import com.sprhib.model.BsrBankBranchBase;
import com.sprhib.service.AreaBaseService;
import com.sprhib.service.BsrBankBranchBaseService;
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
@RequestMapping(value = "/bsrbase")
public class BsrBankBranchBaseController {

    @Autowired
    BsrBankBranchBaseService bbaseService;

    @RequestMapping(value = "/addBsrBankBranch", method = RequestMethod.GET)
    public ModelAndView addAreaBase() {
        ModelAndView modelAndView = new ModelAndView("bsrbank_base/add-bsrbank-base");
        modelAndView.addObject("bbase", new BsrBankBranchBase());
        return modelAndView;
    }

    @RequestMapping(value = "/addBsrBankBranch", method = RequestMethod.POST)
    public ModelAndView addingAreaBase(@ModelAttribute BsrBankBranchBase bbase) {

        ModelAndView modelAndView = new ModelAndView("bsrbank_base/list-of-bsrbank-bases");
        try {
            bbaseService.addBsrBankBranch(bbase);

            String message = "Record was successfully added!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Record Adding Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            BsrBankBranchBase currentbbase = bbaseService.getBsrBankBranch(bbase.getBbId());
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
        List<BsrBankBranchBase> bbases = bbaseService.getBsrBankBranches();

        modelAndView.addObject(
                "bbases", bbases);
        return modelAndView;
    }

    @RequestMapping(value = "/listBsrBankBranch")
    public ModelAndView listOfAreaBases() {
        ModelAndView modelAndView = new ModelAndView("bsrbank_base/list-of-bsrbank-bases");

        List<BsrBankBranchBase> bbases = bbaseService.getBsrBankBranches();
        modelAndView.addObject("bbases", bbases);

        return modelAndView;
    }

    @RequestMapping(value = "/editBsrBankBranch/{id}", method = RequestMethod.GET)
    public ModelAndView editAreaBase(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("bsrbank_base/edit-bsrbank-base");
        BsrBankBranchBase bbase = bbaseService.getBsrBankBranch(id);
        modelAndView.addObject("bbase", bbase);
        return modelAndView;
    }

    @RequestMapping(value = "/editBsrBankBranch/{id}", method = RequestMethod.POST)
    public ModelAndView editingAreaBase(@ModelAttribute BsrBankBranchBase bbase, @PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("bsrbank_base/list-of-bsrbank-bases");

        try {
           bbaseService.updateBsrBankBranch(bbase);

            String message = "Record was successfully edited!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Record editing Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            BsrBankBranchBase currentbbase = bbaseService.getBsrBankBranch(bbase.getBbId());
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

        List<BsrBankBranchBase> bbases = bbaseService.getBsrBankBranches();
        modelAndView.addObject("bbases", bbases);

        return modelAndView;
    }

    @RequestMapping(value = "/deleteBsrBankBranch/{id}", method = RequestMethod.GET)
    public ModelAndView deleteAreaBase(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("bsrbank_base/list-of-bsrbank-bases");

        try {
            bbaseService.deleteBsrBankBranch(id);
            String message = "Record was successfully deleted!!.";
            modelAndView.addObject("message", message);
        } catch (Exception ex) {

            String message1 = ex.getMessage();
            modelAndView.addObject("message1", message1);

        }

        List<BsrBankBranchBase> bbases = bbaseService.getBsrBankBranches();
        modelAndView.addObject("bbases", bbases);

        return modelAndView;
    }

}

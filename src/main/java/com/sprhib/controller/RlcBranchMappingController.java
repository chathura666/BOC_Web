/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.controller;

import com.sprhib.model.RlcBase;
import com.sprhib.service.RlcBaseService;
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
@RequestMapping(value = "/RlcBranchMapping")
public class RlcBranchMappingController {

    @Autowired
    RlcBaseService rlcService;

    @RequestMapping(value = "/addMapping", method = RequestMethod.GET)
    public ModelAndView addRlcBranchMapping() {
        ModelAndView modelAndView = new ModelAndView("rlc_base/add-rlc-base");
        modelAndView.addObject("rbase", new RlcBase());
        return modelAndView;
    }

    @RequestMapping(value = "/addMapping", method = RequestMethod.POST)
    public ModelAndView addingRlcBranchMapping(@ModelAttribute RlcBase rbase) {

        ModelAndView modelAndView = new ModelAndView("rlc_base/list-of-rlc-bases");
        try {
            rlcService.addRlcBase(rbase);

            String message = "Record was successfully added!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Record Adding Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            RlcBase currentrbase = rlcService.getRlcBase(rbase.getRlcId());
            if (currentrbase != null) {
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
        List<RlcBase> rbases = rlcService.getRlcBases();

        modelAndView.addObject(
                "rbases", rbases);
        return modelAndView;
    }

    @RequestMapping(value = "/listMappings")
    public ModelAndView listOfRlcBranchMappings() {
        ModelAndView modelAndView = new ModelAndView("rlc_base/list-of-rlc-bases");

        List<RlcBase> rbases = rlcService.getRlcBases();
        modelAndView.addObject("rbases", rbases);

        return modelAndView;
    }

    @RequestMapping(value = "/editMapping/{id}", method = RequestMethod.GET)
    public ModelAndView editRlcBranchMapping(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("rlc_base/edit-rlc-base");
        RlcBase rbase = rlcService.getRlcBase(id);
        modelAndView.addObject("rbase", rbase);
        return modelAndView;
    }

    @RequestMapping(value = "/editMapping/{id}", method = RequestMethod.POST)
    public ModelAndView editingRlcBranchMapping(@ModelAttribute RlcBase rbase, @PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("rlc_base/list-of-rlc-bases");

        try {
           rlcService.updateRlcBase(rbase);

            String message = "Record was successfully edited!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Record editing Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            RlcBase currentrbase = rlcService.getRlcBase(rbase.getRlcId());
            if (currentrbase != null) {
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

        List<RlcBase> rbases = rlcService.getRlcBases();
        modelAndView.addObject("rbases", rbases);

        return modelAndView;
    }

    @RequestMapping(value = "/deleteMapping/{id}", method = RequestMethod.GET)
    public ModelAndView deleteRlcBranchMapping(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("rlc_base/list-of-rlc-bases");

        try {
            rlcService.deleteRlcBase(id);
            String message = "Record was successfully deleted!!.";
            modelAndView.addObject("message", message);
        } catch (Exception ex) {

            String message1 = ex.getMessage();
            modelAndView.addObject("message1", message1);

        }

        List<RlcBase> rbases = rlcService.getRlcBases();
        modelAndView.addObject("rbases", rbases);

        return modelAndView;
    }

}

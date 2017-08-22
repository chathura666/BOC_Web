/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.controller;

import com.sprhib.model.AreaBase;
import com.sprhib.model.LoanPurposesDocumentChecklistMapping;
import com.sprhib.service.AreaBaseService;
import com.sprhib.service.LoanPurposesDocumentChecklistMappingService;
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
@RequestMapping(value = "/LoanPurposesDocumentChecklistMapping")
public class LoanPurposesDocumentChecklistMappingController {

    @Autowired
    LoanPurposesDocumentChecklistMappingService mapService;

    final static Logger logger = Logger.getLogger(LoanPurposesDocumentChecklistMappingController.class);

    @RequestMapping(value = "/addMapping", method = RequestMethod.GET)
    public ModelAndView addLoanPurposesDocumentChecklistMapping() {
        ModelAndView modelAndView = new ModelAndView("area_base/add-area-base");
        modelAndView.addObject("abase", new AreaBase());
        return modelAndView;
    }

    @RequestMapping(value = "/addMapping", method = RequestMethod.POST)
    public ModelAndView addingLoanPurposesDocumentChecklistMapping(@ModelAttribute LoanPurposesDocumentChecklistMapping map) {

        ModelAndView modelAndView = new ModelAndView("area_base/list-of-area-bases");
        try {
            mapService.addMapping(map);

            logger.info("Loan Purposes Document Checklist Mapping Record Inserted... : " + map.getPrpid() + "_" + map.getPurposeId() + "_" + map.getDocumentId());

            String message = "Record was successfully added!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Record Adding Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            LoanPurposesDocumentChecklistMapping currentmap = mapService.getMapping(map.getPrpid());
            if (currentmap != null) {
                String message1 = "Record Already Exist!!!";

                modelAndView.addObject("message1", message1);
            } else {
                String message1 = ex.getMessage();
                //String message1 = "Area Adding Failed!!";
                modelAndView.addObject("message1", message1);
            }
        } catch (Exception ex) {
            String message1 = ex.getMessage();
            //String message1 = "Area Adding Failed!!";
            modelAndView.addObject("message1", message1);
        }
        List<LoanPurposesDocumentChecklistMapping> maps = mapService.getMappings();

        modelAndView.addObject("maps", maps);
        return modelAndView;
    }

    @RequestMapping(value = "/listMappings")
    public ModelAndView listOfLoanPurposesDocumentChecklistMappings() {
        ModelAndView modelAndView = new ModelAndView("area_base/list-of-area-bases");

        List<LoanPurposesDocumentChecklistMapping> maps = mapService.getMappings();

        modelAndView.addObject("maps", maps);
        return modelAndView;
    }

    @RequestMapping(value = "/editMapping/{id}", method = RequestMethod.GET)
    public ModelAndView editLoanPurposesDocumentChecklistMapping(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("area_base/edit-area-base");
        LoanPurposesDocumentChecklistMapping map = mapService.getMapping(id);
        modelAndView.addObject("map", map);
        return modelAndView;
    }

    @RequestMapping(value = "/editMapping/{id}", method = RequestMethod.POST)
    public ModelAndView editingLoanPurposesDocumentChecklistMapping(@ModelAttribute LoanPurposesDocumentChecklistMapping map, @PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("area_base/list-of-area-bases");

        try {
            mapService.updateMapping(map);

            logger.info("Loan Purposes Document Checklist Mapping Record Edited... : " + map.getPrpid());

            String message = "Record was successfully edited!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Record editing Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            LoanPurposesDocumentChecklistMapping currentmap = mapService.getMapping(map.getPrpid());
            if (currentmap != null) {
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

        List<LoanPurposesDocumentChecklistMapping> maps = mapService.getMappings();

        modelAndView.addObject("maps", maps);
        return modelAndView;
    }

    @RequestMapping(value = "/deleteMapping/{id}", method = RequestMethod.GET)
    public ModelAndView deleteLoanPurposesDocumentChecklistMapping(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("area_base/list-of-area-bases");

        try {
            mapService.deleteMapping(id);

            logger.info("Area Record Deleted... : " + id);

            String message = "Record was successfully deleted!!.";
            modelAndView.addObject("message", message);
        } catch (Exception ex) {

            String message1 = ex.getMessage();
            modelAndView.addObject("message1", message1);

        }

        List<LoanPurposesDocumentChecklistMapping> maps = mapService.getMappings();

        modelAndView.addObject("maps", maps);
        return modelAndView;
    }

}

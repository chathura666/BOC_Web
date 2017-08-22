/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.controller;

import com.sprhib.model.CbSequenceNumber;
import com.sprhib.model.CbSequenceNumberPK;
import com.sprhib.model.CcCardCategoryWiseEligibilites;
import com.sprhib.service.CbSequenceNumberService;
import java.util.ArrayList;
import java.util.Iterator;
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
@RequestMapping(value = "/CbSequenceNumber")
public class CbSequenceNumberController {

    @Autowired
    CbSequenceNumberService SequenceNumService;

    final static Logger logger = Logger.getLogger(CbSequenceNumberController.class);

    @RequestMapping(value = "/addSequenceNumber", method = RequestMethod.GET)
    public ModelAndView addAreaBase() {
        ModelAndView modelAndView = new ModelAndView("area_base/add-area-base");

        modelAndView.addObject("abase", new CbSequenceNumber());
        return modelAndView;
    }

    @RequestMapping(value = "/addSequenceNumber", method = RequestMethod.POST)
    public ModelAndView addingAreaBase(@ModelAttribute CbSequenceNumber abase) {

        ModelAndView modelAndView = new ModelAndView("area_base/list-of-area-bases");
        try {
            SequenceNumService.addCbSequenceNumber(abase);

            //logger.info("Area Record Inserted... : "+abase.getAid()+"_"+abase.getAreaCode()+"_"+abase.getAreaName());
            String message = "Record was successfully added!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Record Adding Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            CbSequenceNumber currentabase = SequenceNumService.getCbSequenceNumber(abase.getCbSequenceNumberPK().getSequenceNo());
            if (currentabase != null) {
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
        List<CbSequenceNumber> abases = SequenceNumService.getCbSequenceNumbers();

        modelAndView.addObject(
                "abases", abases);
        return modelAndView;
    }

    @RequestMapping(value = "/listSequenceNumbers")
    public ModelAndView listOfSequenceNumbers() {
        ModelAndView modelAndView = new ModelAndView("cbsequence_number/list-of-seq-numbers");

        List<CbSequenceNumber> abases = SequenceNumService.getCbSequenceNumbers();

        List<CbSequenceNumberPK> PKlist = new ArrayList<CbSequenceNumberPK>();

        Iterator<CbSequenceNumber> list = abases.iterator();
        CbSequenceNumber temp;

        while (list.hasNext()) {
            temp = list.next();
            PKlist.add(temp.getCbSequenceNumberPK());
        }

        modelAndView.addObject("abases", PKlist);

        return modelAndView;
    }

    @RequestMapping(value = "/editSequenceNumber/{id}", method = RequestMethod.GET)
    public ModelAndView editAreaBase(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("area_base/edit-area-base");
        CbSequenceNumber abase = SequenceNumService.getCbSequenceNumber(id);
        modelAndView.addObject("abase", abase);
        return modelAndView;
    }

    @RequestMapping(value = "/editSequenceNumber/{id}", method = RequestMethod.POST)
    public ModelAndView editingAreaBase(@ModelAttribute CbSequenceNumber abase, @PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("area_base/list-of-area-bases");

        try {
            SequenceNumService.updateCbSequenceNumber(abase);

            logger.info("Area Record Edited... : " + abase.getCbSequenceNumberPK());

            String message = "Record was successfully edited!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Record editing Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            CbSequenceNumber currentabase = SequenceNumService.getCbSequenceNumber(abase.getCbSequenceNumberPK().getSequenceNo());
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

        List<CbSequenceNumber> abases = SequenceNumService.getCbSequenceNumbers();
        modelAndView.addObject("abases", abases);

        return modelAndView;
    }

    @RequestMapping(value = "/deleteSequenceNumber/{id}", method = RequestMethod.GET)
    public ModelAndView deleteAreaBase(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("area_base/list-of-area-bases");

        try {
            SequenceNumService.deleteCbSequenceNumber(id);

            logger.info("Area Record Deleted... : " + id);

            String message = "Record was successfully deleted!!.";
            modelAndView.addObject("message", message);
        } catch (Exception ex) {

            String message1 = ex.getMessage();
            modelAndView.addObject("message1", message1);

        }

        List<CbSequenceNumber> abases = SequenceNumService.getCbSequenceNumbers();
        modelAndView.addObject("abases", abases);

        return modelAndView;
    }

}

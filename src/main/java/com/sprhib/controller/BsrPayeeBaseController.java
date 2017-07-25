/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.controller;

import com.sprhib.model.AreaBase;
import com.sprhib.model.BsrPayeeBase;
import com.sprhib.service.AreaBaseService;
import com.sprhib.service.BsrPayeeBaseService;
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
@RequestMapping(value = "/bsrpayee")
public class BsrPayeeBaseController {

    @Autowired
    BsrPayeeBaseService payeeService;

    @RequestMapping(value = "/addPayee", method = RequestMethod.GET)
    public ModelAndView addBsrPayee() {
        ModelAndView modelAndView = new ModelAndView("bsrpayee_base/add-bsr-payee");
        modelAndView.addObject("payee", new BsrPayeeBase());
        return modelAndView;
    }

    @RequestMapping(value = "/addPayee", method = RequestMethod.POST)
    public ModelAndView addingBsrPayee(@ModelAttribute BsrPayeeBase payee) {

        ModelAndView modelAndView = new ModelAndView("bsrpayee_base/list-of-bsr-payee");
        try {
            payeeService.addBsrPayee(payee);

            String message = "Record was successfully added!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Record Adding Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            BsrPayeeBase currentpayee = payeeService.getBsrPayee(payee.getPayeeId());
            if (currentpayee != null) {
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
        List<BsrPayeeBase> payees = payeeService.getBsrPayees();

        modelAndView.addObject("payees", payees);
        return modelAndView;
    }

    @RequestMapping(value = "/listPayees")
    public ModelAndView listOfBsrPayees() {
        ModelAndView modelAndView = new ModelAndView("bsrpayee_base/list-of-bsr-payee");

        List<BsrPayeeBase> payees = payeeService.getBsrPayees();
        modelAndView.addObject("payees", payees);

        return modelAndView;
    }

    @RequestMapping(value = "/editPayee/{id}", method = RequestMethod.GET)
    public ModelAndView editBsrPayee(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("bsrpayee_base/edit-bsr-payee");
        BsrPayeeBase payee = payeeService.getBsrPayee(id);
        modelAndView.addObject("payee", payee);
        return modelAndView;
    }

    @RequestMapping(value = "/editPayee/{id}", method = RequestMethod.POST)
    public ModelAndView editingBsrPayee(@ModelAttribute BsrPayeeBase payee, @PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("bsrpayee_base/list-of-bsr-payee");

        try {
           payeeService.updateBsrPayee(payee);

            String message = "Record was successfully edited!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Record editing Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            BsrPayeeBase currentpayee = payeeService.getBsrPayee(payee.getPayeeId());
            if (currentpayee != null) {
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


        List<BsrPayeeBase> payees = payeeService.getBsrPayees();
        modelAndView.addObject("payees", payees);

        return modelAndView;
    }

    @RequestMapping(value = "/deletePayee/{id}", method = RequestMethod.GET)
    public ModelAndView deleteBsrPayee(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("bsrpayee_base/list-of-bsr-payee");

        try {
            payeeService.deleteBsrPayee(id);
            String message = "Record was successfully deleted!!.";
            modelAndView.addObject("message", message);
        } catch (Exception ex) {

            String message1 = ex.getMessage();
            modelAndView.addObject("message1", message1);

        }

        List<BsrPayeeBase> payees = payeeService.getBsrPayees();
        modelAndView.addObject("payees", payees);

        return modelAndView;
    }

}

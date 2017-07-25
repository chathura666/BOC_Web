/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.controller;

import com.sprhib.model.DocumentTypeBase;
import com.sprhib.service.Document_Type_BaseService;
import java.util.List;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/dtbase")
public class Document_Type_BaseController {

    @Autowired
    Document_Type_BaseService dtbaseService;

    @RequestMapping(value = "/addDocumentType", method = RequestMethod.GET)
    public ModelAndView addProductCategoryPage() {
        ModelAndView modelAndView = new ModelAndView("doctype_base/add-document-type-form");
        modelAndView.addObject("dtbase", new DocumentTypeBase());
        return modelAndView;
    }

    @RequestMapping(value = "/addDocumentType", method = RequestMethod.POST)
    public ModelAndView addingProductCategoryPage(@ModelAttribute DocumentTypeBase dtbase) {

        ModelAndView modelAndView = new ModelAndView("doctype_base/list-of-document-types");

        try {
            dtbaseService.addDocumentTypeBase(dtbase);

            String message = "Document Type was successfully added!!.";
            modelAndView.addObject("message", message);

        } catch (Exception ex) {

            String message1 = "Document Insert failed!!";
            modelAndView.addObject("message1", message1);

        }

        List<DocumentTypeBase> dtbases = dtbaseService.getDocumentTypeBases();
        modelAndView.addObject("dtbases", dtbases);
        return modelAndView;
    }

    @RequestMapping(value = "/listDocumentTypes")
    public ModelAndView listOfProductCategories() {
        ModelAndView modelAndView = new ModelAndView("doctype_base/list-of-document-types");

        List<DocumentTypeBase> dtbases = dtbaseService.getDocumentTypeBases();
        modelAndView.addObject("dtbases", dtbases);
        return modelAndView;
    }

    @RequestMapping(value = "/editDocumentType/{id}", method = RequestMethod.GET)
    public ModelAndView editProductCategoryPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("doctype_base/edit-document-type-form");
        DocumentTypeBase dtbase = dtbaseService.getDocumentTypeBase(id);
        modelAndView.addObject("dtbase", dtbase);
        return modelAndView;
    }

    @RequestMapping(value = "/editDocumentType/{id}", method = RequestMethod.POST)
    public ModelAndView editingProductCategory(@ModelAttribute DocumentTypeBase dtbase, @PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("doctype_base/list-of-document-types");

        try {
            dtbaseService.updateDocumentTypeBase(dtbase);

            String message = "Document Type was successfully edited!!.";
            modelAndView.addObject("message", message);

        } catch (Exception ex) {

            String message1 = "Document Update failed!!";
            modelAndView.addObject("message1", message1);

        }

        List<DocumentTypeBase> dtbases = dtbaseService.getDocumentTypeBases();
        modelAndView.addObject("dtbases", dtbases);
        return modelAndView;
    }

    @RequestMapping(value = "/deleteDocumentType/{id}", method = RequestMethod.GET)
    public ModelAndView deleteProductCategory(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("doctype_base/list-of-document-types");

        try {
            dtbaseService.deleteDocumentTypeBase(id);
            String message = "Document Type was successfully deleted!!.";
            modelAndView.addObject("message", message);
        } catch (ConstraintViolationException ex) {
            String message1 = "Constraint Violation.. Document Deleting Failed!!";
            modelAndView.addObject("message1", message1);
        } catch (Exception ex) {

            String message1 = "Document Delete failed!!";
            modelAndView.addObject("message1", message1);

        }

        List<DocumentTypeBase> dtbases = dtbaseService.getDocumentTypeBases();
        modelAndView.addObject("dtbases", dtbases);

        return modelAndView;
    }

}

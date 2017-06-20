/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.controller;

import com.sprhib.model.DocumentTypeBase;
import com.sprhib.model.ProductDocumentChecklistMapping;
import com.sprhib.service.Document_Type_BaseService;
import com.sprhib.service.ProductDocumentChecklistMappingService;
import java.util.List;
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
@RequestMapping(value = "/dcmap")
public class Product_Doc_CheckMappingController {

    @Autowired
    ProductDocumentChecklistMappingService dcmapService;

    @RequestMapping(value = "/addChecklistMap", method = RequestMethod.GET)
    public ModelAndView addProductChecklistMap() {
        ModelAndView modelAndView = new ModelAndView("add-checklist-mapping-form");
        modelAndView.addObject("dcmap", new ProductDocumentChecklistMapping());
        return modelAndView;
    }

    @RequestMapping(value = "/addChecklistMap", method = RequestMethod.POST)
    public ModelAndView addingProductChecklistMap(@ModelAttribute ProductDocumentChecklistMapping dcmap) {

        ModelAndView modelAndView = new ModelAndView("list-of-checklist-mapping");

        try {
            dcmapService.addProductDocumentChecklistMapping(dcmap);

            String message = "Document Type was successfully added!!.";
            modelAndView.addObject("message", message);

        } catch (Exception ex) {

            String message1 = "Document Insert failed!!";
            modelAndView.addObject("message1", message1);

        }

        List<ProductDocumentChecklistMapping> dcmaps = dcmapService.getProductDocumentChecklistMappings();
        modelAndView.addObject("dcmaps", dcmaps);
        return modelAndView;
    }

    @RequestMapping(value = "/listChecklistMaps")
    public ModelAndView listOfProductChecklistMaps() {
        ModelAndView modelAndView = new ModelAndView("list-of-checklist-mapping");

        List<ProductDocumentChecklistMapping> dcmaps = dcmapService.getProductDocumentChecklistMappings();
        modelAndView.addObject("dcmaps", dcmaps);
        return modelAndView;
    }

    @RequestMapping(value = "/editChecklistMapping/{id}", method = RequestMethod.GET)
    public ModelAndView editProductChecklistMap(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("edit-checklist-mapping-form");
        ProductDocumentChecklistMapping dcmaps = dcmapService.getProductDocumentChecklistMapping(id);
        modelAndView.addObject("dcmaps", dcmaps);
        return modelAndView;
    }

    @RequestMapping(value = "/editChecklistMapping/{id}", method = RequestMethod.POST)
    public ModelAndView editingProductChecklistMap(@ModelAttribute ProductDocumentChecklistMapping dcmap, @PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("list-of-checklist-mapping");

        try {
            dcmapService.updateProductDocumentChecklistMapping(dcmap);

            String message = "Document Type was successfully edited!!.";
            modelAndView.addObject("message", message);

        } catch (Exception ex) {

            String message1 = "Document Update failed!!";
            modelAndView.addObject("message1", message1);

        }

        List<ProductDocumentChecklistMapping> dcmaps = dcmapService.getProductDocumentChecklistMappings();
        modelAndView.addObject("dcmaps", dcmaps);
        return modelAndView;
    }

    @RequestMapping(value = "/deleteChecklistMapping/{id}", method = RequestMethod.GET)
    public ModelAndView deleteProductCategory(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("list-of-checklist-mapping");

        try {
            dcmapService.deleteProductDocumentChecklistMapping(id);
            String message = "Document Type was successfully deleted!!.";
            modelAndView.addObject("message", message);
        } catch (Exception ex) {

            String message1 = "Document Delete failed!!";
            modelAndView.addObject("message1", message1);

        }

        List<ProductDocumentChecklistMapping> dcmaps = dcmapService.getProductDocumentChecklistMappings();
        modelAndView.addObject("dcmaps", dcmaps);

        return modelAndView;
    }

}

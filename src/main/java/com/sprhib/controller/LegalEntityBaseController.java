/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.controller;

import com.sprhib.model.AreaBase;
import com.sprhib.model.LegalEntityBase;
import com.sprhib.model.ProductCategoryBase;
import com.sprhib.service.AreaBaseService;
import com.sprhib.service.LegalEntityBaseService;
import com.sprhib.service.Product_Category_BaseService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author it207432
 */
@Controller
@RequestMapping(value = "/LegalEntityBase")
public class LegalEntityBaseController {

    @Autowired
    LegalEntityBaseService lbaseService;

    @Autowired
    Product_Category_BaseService pcbaseService;

    final static Logger logger = Logger.getLogger(LegalEntityBaseController.class);

    @RequestMapping(value = "/addBase", method = RequestMethod.GET)
    public ModelAndView addLegalEntityBase() {
        ModelAndView modelAndView = new ModelAndView("legal_entity_base/add-legal-entity-base");

        List<ProductCategoryBase> productNames = pcbaseService.getProductCategoryBases();
        List<String> ProdCat = new ArrayList<String>();

        Iterator<ProductCategoryBase> pcat = productNames.iterator();
        while (pcat.hasNext()) {
            ProdCat.add(pcat.next().getProductCategory());

        }

        modelAndView.addObject("lbase", new LegalEntityBase());
        modelAndView.addObject("pcat", ProdCat);
        return modelAndView;
    }

    @RequestMapping(value = "/addBase", method = RequestMethod.POST)
    public ModelAndView addingLegalEntityBase(@ModelAttribute LegalEntityBase lbase, @RequestParam("pcat") String pcat) {

        ModelAndView modelAndView = new ModelAndView("legal_entity_base/list-of-legal-entity-bases");

        List<ProductCategoryBase> prod = pcbaseService.getProductCategoryBases();

        ProductCategoryBase pcbase = null;

        for (ProductCategoryBase pc : prod) {
            if (pc.getProductCategory().equalsIgnoreCase(pcat)) {
                pcbase = pc;
                break;
            }
        }

        try {
            lbase.setProductCategoryId(Short.parseShort(pcbase.getProductCategoryId().toString()));
            lbaseService.addLegalEntityBase(lbase);

            logger.info("Legal Entity Record Inserted... : " + lbase.getLeid() + "_" + lbase.getLegalEntityType() + "_" + lbase.getProductCategoryId());

            String message = "Record was successfully added!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Record Adding Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            LegalEntityBase currentlbase = lbaseService.getLegalEntityBase(lbase.getLeid());
            if (currentlbase != null) {
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
        List<LegalEntityBase> lbases = lbaseService.getLegalEntityBases();

        modelAndView.addObject(
                "lbases", lbases);
        return modelAndView;
    }

    @RequestMapping(value = "/listBases")
    public ModelAndView listOfLegalEntityBases() {
        ModelAndView modelAndView = new ModelAndView("legal_entity_base/list-of-legal-entity-bases");

        List<LegalEntityBase> lbases = lbaseService.getLegalEntityBases();
        modelAndView.addObject("lbases", lbases);

        return modelAndView;
    }

    @RequestMapping(value = "/editBase/{id}", method = RequestMethod.GET)
    public ModelAndView editLegalEntityBase(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("legal_entity_base/edit-legal-entity-base");
        LegalEntityBase lbase = lbaseService.getLegalEntityBase(id);

        List<ProductCategoryBase> productCats = pcbaseService.getProductCategoryBases();
        List<String> Pcat = new ArrayList<String>();

        Iterator<ProductCategoryBase> pname = productCats.iterator();
        while (pname.hasNext()) {
            Pcat.add(pname.next().getProductCategory());
        }
        
        
        ProductCategoryBase pcbase = null;

        for (ProductCategoryBase pb : productCats) {
            
            System.out.println(Short.valueOf(pb.getProductCategoryId().toString()));
            System.out.println(lbase.getProductCategoryId());
            
            if (pb.getProductCategoryId().equals(Integer.parseInt(lbase.getProductCategoryId().toString()))) {
                pcbase = pb;
                break;
            }
        }

        modelAndView.addObject("pcats", Pcat);
        modelAndView.addObject("pcat", pcbase.getProductCategory());
        modelAndView.addObject("lbase", lbase);
        return modelAndView;
    }

    @RequestMapping(value = "/editBase/{id}", method = RequestMethod.POST)
    public ModelAndView editingLegalEntityBase(@ModelAttribute LegalEntityBase lbase, @PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("legal_entity_base/list-of-legal-entity-bases");

        try {
            lbaseService.updateLegalEntityBase(lbase);

            logger.info("Legal Entity Record Edited... : " + lbase.getLeid());

            String message = "Record was successfully edited!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Record editing Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            LegalEntityBase currentabase = lbaseService.getLegalEntityBase(lbase.getLeid());
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

        List<LegalEntityBase> lbases = lbaseService.getLegalEntityBases();
        modelAndView.addObject("lbases", lbases);

        return modelAndView;
    }

    @RequestMapping(value = "/deleteBase/{id}", method = RequestMethod.GET)
    public ModelAndView deleteLegalEntityBase(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("legal_entity_base/list-of-legal-entity-bases");

        try {
            lbaseService.deleteLegalEntityBase(id);

            logger.info("Area Record Deleted... : " + id);

            String message = "Record was successfully deleted!!.";
            modelAndView.addObject("message", message);
        } catch (Exception ex) {

            String message1 = ex.getMessage();
            modelAndView.addObject("message1", message1);

        }

        List<LegalEntityBase> lbases = lbaseService.getLegalEntityBases();
        modelAndView.addObject("lbases", lbases);

        return modelAndView;
    }

}

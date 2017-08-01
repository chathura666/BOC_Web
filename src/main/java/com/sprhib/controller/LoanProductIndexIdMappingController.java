/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.controller;

import com.sprhib.model.DocumentTypeBase;
import com.sprhib.model.IndexIdBase;
import com.sprhib.model.LoanProductIndexIdMapping;
import com.sprhib.model.ProductBase;
import com.sprhib.service.IndexIdBaseService;
import com.sprhib.service.LoanProductIndexIdMappingService;
import com.sprhib.service.Product_BaseService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
@RequestMapping(value = "/LoanProductIndexIdMapping")
public class LoanProductIndexIdMappingController {

    @Autowired
    LoanProductIndexIdMappingService idmapService;

    @Autowired
    Product_BaseService pbaseService;

    @Autowired
    IndexIdBaseService indexidService;

    @RequestMapping(value = "/addMapping", method = RequestMethod.GET)
    public ModelAndView addLoanProductIndexIdMap() {
        ModelAndView modelAndView = new ModelAndView("loan_product_mapping/add-loan-product-mapping");

        List<ProductBase> productNames = pbaseService.getProducts();
        List<String> ProdName = new ArrayList<String>();

        Iterator<ProductBase> pname = productNames.iterator();
        while (pname.hasNext()) {
            ProdName.add(pname.next().getProductName());

        }
        List<IndexIdBase> indexIds = indexidService.getIndexIds();
        List<String> index = new ArrayList<String>();

        Iterator<IndexIdBase> desc = indexIds.iterator();
        while (desc.hasNext()) {
            index.add(desc.next().getDescription());

        }
        modelAndView.addObject("ProdName", ProdName);
        modelAndView.addObject("Desc", index);

        modelAndView.addObject("idmap", new LoanProductIndexIdMapping());
        return modelAndView;
    }

    @RequestMapping(value = "/addMapping", method = RequestMethod.POST)
    public ModelAndView addingLoanProductIndexIdMap(@ModelAttribute LoanProductIndexIdMapping idmap, @RequestParam("pname") String pname, @RequestParam("desc") String desc) {

        ModelAndView modelAndView = new ModelAndView("loan_product_mapping/list-of-loan-product-mapping");

        List<ProductBase> products = pbaseService.getProducts();
        List<IndexIdBase> indexes = indexidService.getIndexIds();

        ProductBase pid = null;
        IndexIdBase iid = null;

        for (ProductBase pb : products) {
            if (pb.getProductName().equalsIgnoreCase(pname)) {
                pid = pb;
                break;
            }
        }

        for (IndexIdBase id : indexes) {
            if (id.getDescription().equalsIgnoreCase(desc)) {
                iid = id;
                break;
            }
        }

        idmap.setPid(pid);
        idmap.setIdxId(iid);

        try {
            idmapService.addLoanProductIndexIdMap(idmap);

            String message = "Loan ProductIndexId Mapping was successfully added!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Loan ProductIndexId Mapping Adding Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            LoanProductIndexIdMapping currentIdMap = idmapService.getLoanProductIndexIdMap(idmap.getProdIndexId());
            if (currentIdMap != null) {
                String message1 = "Loan ProductIndexId Mapping Already Exist!!!";
                modelAndView.addObject("message1", message1);
            } else {
                String message1 = "Loan ProductIndexId Mapping Adding Failed!!";
                modelAndView.addObject("message1", message1);
            }
        } catch (Exception ex) {
            String message1 = "Loan ProductIndexId Mapping Adding Failed!!";
            modelAndView.addObject("message1", message1);
        }
        List<LoanProductIndexIdMapping> allidmaps = idmapService.getLoanProductIndexIdMaps();

        modelAndView.addObject("idmaps", allidmaps);
        return modelAndView;
    }

    @RequestMapping(value = "/listMapping")
    public ModelAndView listOfLoanProductIndexIdMaps() {
        ModelAndView modelAndView = new ModelAndView("loan_product_mapping/list-of-loan-product-mapping");

        List<LoanProductIndexIdMapping> allidmaps = idmapService.getLoanProductIndexIdMaps();

        modelAndView.addObject("idmaps", allidmaps);
        return modelAndView;
    }

    @RequestMapping(value = "/editMapping/{id}", method = RequestMethod.GET)
    public ModelAndView editLoanProductIndexIdMap(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("loan_product_mapping/edit-loan-product-mapping");
        LoanProductIndexIdMapping idmap = idmapService.getLoanProductIndexIdMap(id);
        modelAndView.addObject("idmap", idmap);

        List<ProductBase> productNames = pbaseService.getProducts();
        List<String> ProdNames = new ArrayList<String>();

        Iterator<ProductBase> pname = productNames.iterator();
        while (pname.hasNext()) {
            ProdNames.add(pname.next().getProductName());
        }

        List<IndexIdBase> Indexes = indexidService.getIndexIds();
        List<String> IndexIds = new ArrayList<String>();

        Iterator<IndexIdBase> index = Indexes.iterator();
        while (index.hasNext()) {
            IndexIds.add(index.next().getDescription());
        }

        ProductBase pid = null;
        IndexIdBase iid = null;

        for (ProductBase pb : productNames) {
            if (pb.getPid().equals(idmap.getPid().getPid())) {
                pid = pb;
                break;
            }
        }

        for (IndexIdBase ind : Indexes) {
            if (ind.getIdxId().equals(idmap.getIdxId().getIdxId())) {
                iid = ind;
                break;
            }
        }

        ProdNames.remove(pid.getProductName());
        IndexIds.remove(iid.getDescription());

        modelAndView.addObject("ProdNames", ProdNames);
        modelAndView.addObject("Indexes", IndexIds);

        modelAndView.addObject("ProdName", pid.getProductName());
        modelAndView.addObject("index", iid.getDescription());

        return modelAndView;
    }

    @RequestMapping(value = "/editMapping/{id}", method = RequestMethod.POST)
    public ModelAndView editingLoanProductIndexIdMap(@ModelAttribute LoanProductIndexIdMapping idmap, @PathVariable Integer id, @RequestParam("pname") String pname, @RequestParam("desc") String desc) {

        ModelAndView modelAndView = new ModelAndView("loan_product_mapping/list-of-loan-product-mapping");

        List<ProductBase> products = pbaseService.getProducts();
        List<IndexIdBase> indexes = indexidService.getIndexIds();

        ProductBase pid = null;
        IndexIdBase iid = null;

        for (ProductBase pb : products) {
            if (pb.getProductName().equalsIgnoreCase(pname)) {
                pid = pb;
                break;
            }
        }

        for (IndexIdBase index : indexes) {
            if (index.getDescription().equalsIgnoreCase(desc)) {
                iid = index;
                break;
            }
        }

        idmap.setPid(pid);
        idmap.setIdxId(iid);

        try {
            idmapService.updateLoanProductIndexIdMap(idmap);

            String message = "Loan ProductIndexId Mapping was successfully edited!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Loan ProductIndexId Mapping editing Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            String message1 = "Loan ProductIndexId Mapping Editing Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (Exception ex) {
            String message1 = "Loan ProductIndexId Mapping Editing Failed!!";
            modelAndView.addObject("message1", message1);
        }

        List<LoanProductIndexIdMapping> allidmaps = idmapService.getLoanProductIndexIdMaps();

        modelAndView.addObject("idmaps", allidmaps);
        return modelAndView;
    }

    @RequestMapping(value = "/deleteMapping/{id}", method = RequestMethod.GET)
    public ModelAndView deleteLoanProductIndexIdMap(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("loan_product_mapping/list-of-loan-product-mapping");

        try {
            idmapService.deleteLoanProductIndexIdMap(id);
            String message = "Loan ProductIndexId Mapping was successfully deleted!!.";
            modelAndView.addObject("message", message);
        } catch (Exception ex) {

            String message1 = ex.getMessage();
            modelAndView.addObject("message1", message1);

        }

        List<LoanProductIndexIdMapping> allidmaps = idmapService.getLoanProductIndexIdMaps();

        modelAndView.addObject("idmaps", allidmaps);
        return modelAndView;

    }

}

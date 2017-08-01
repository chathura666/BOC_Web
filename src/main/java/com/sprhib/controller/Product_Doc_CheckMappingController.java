/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.controller;

import com.sprhib.model.DocumentTypeBase;
import com.sprhib.model.ProductBase;
import com.sprhib.model.ProductDocumentChecklistMapping;
import com.sprhib.service.Document_Type_BaseService;
import com.sprhib.service.ProductDocumentChecklistMappingService;
import com.sprhib.service.Product_BaseService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.TransientPropertyValueException;
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
@RequestMapping(value = "/ProductDocumentChecklistMapping")
public class Product_Doc_CheckMappingController {

    @Autowired
    ProductDocumentChecklistMappingService dcmapService;

    @Autowired
    Product_BaseService pbaseService;

    @Autowired
    Document_Type_BaseService dtbaseService;

    @RequestMapping(value = "/addMapping", method = RequestMethod.GET)
    public ModelAndView addProductChecklistMap() {
        ModelAndView modelAndView = new ModelAndView("doc_checklist_mapping/add-checklist-mapping-form");

        List<ProductBase> productNames = pbaseService.getProducts();
        List<String> ProdName = new ArrayList<String>();

        Iterator<ProductBase> pname = productNames.iterator();
        while (pname.hasNext()) {
            ProdName.add(pname.next().getProductName());

        }

        List<DocumentTypeBase> docNames = dtbaseService.getDocumentTypeBases();
        List<String> DocName = new ArrayList<String>();

        Iterator<DocumentTypeBase> dname = docNames.iterator();
        while (dname.hasNext()) {
            DocName.add(dname.next().getDocumentType());

        }

        modelAndView.addObject("ProdName", ProdName);
        modelAndView.addObject("DocName", DocName);
        modelAndView.addObject("dcmap", new ProductDocumentChecklistMapping());
        return modelAndView;
    }

    @RequestMapping(value = "/addMapping", method = RequestMethod.POST)
    public ModelAndView addingProductChecklistMap(@ModelAttribute ProductDocumentChecklistMapping dcmap, @RequestParam("pname") String pname, @RequestParam("dtype") String dtype) {

        ModelAndView modelAndView = new ModelAndView("doc_checklist_mapping/list-of-checklist-mapping");

        List<ProductBase> products = pbaseService.getProducts();
        List<DocumentTypeBase> docs = dtbaseService.getDocumentTypeBases();

        ProductBase pid = null;
        DocumentTypeBase did = null;

        for (ProductBase pb : products) {
            if (pb.getProductName().equalsIgnoreCase(pname)) {
                pid = pb;
                break;
            }
        }

        for (DocumentTypeBase db : docs) {
            if (db.getDocumentType().equalsIgnoreCase(dtype)) {
                did = db;
                break;
            }
        }

        dcmap.setProductId(pid);
        dcmap.setDocumentId(did);

        ProductBase currentpbases = pbaseService.getProduct(dcmap.getProductId().getPid());
        DocumentTypeBase currentdtbase = dtbaseService.getDocumentTypeBase(dcmap.getDocumentId().getDid());

        try {
            dcmapService.addProductDocumentChecklistMapping(dcmap);

            String message = "Document Type was successfully added!!.";
            modelAndView.addObject("message", message);
        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Product Adding Failed!!";
            //String message1 = ex.getMessage();
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            ProductDocumentChecklistMapping currentdcmapbase = dcmapService.getProductDocumentChecklistMapping(dcmap.getPdcid());
            if (currentdcmapbase != null) {
                String message1 = "Document Checklist Map Already Exist!!!";
                //String message1 = ex.getMessage();
                modelAndView.addObject("message1", message1);
            }

            if (currentpbases == null) {
                String message1 = "Product ID Not Exist!!!";
                modelAndView.addObject("message1", message1);
            } else if (currentdtbase == null) {
                String message1 = "Document ID Not Exist!!";
                modelAndView.addObject("message1", message1);
            } else {
                String message1 = "Product Checklist Map Adding Failed!!";
                //String message1 = ex.getMessage();
                modelAndView.addObject("message1", message1);
            }
        } catch (TransientPropertyValueException ex) {
            {

                ProductDocumentChecklistMapping currentdcmapbase = dcmapService.getProductDocumentChecklistMapping(dcmap.getPdcid());
                if (currentdcmapbase != null) {
                    String message1 = "Document Checklist Map Already Exist!!!";
                    //String message1 = ex.getMessage();
                    modelAndView.addObject("message1", message1);
                }

                if (currentpbases == null) {
                    String message1 = "Product ID Not Exist!!!";
                    modelAndView.addObject("message1", message1);
                } else if (currentdtbase == null) {
                    String message1 = "Document ID Not Exist!!";
                    modelAndView.addObject("message1", message1);
                } else {
                    String message1 = "Product Checklist Map Adding Failed!!";
                    //String message1 = ex.getMessage();
                    modelAndView.addObject("message1", message1);
                }
            }
        } catch (Exception ex) {
            //String message1 = ex.getMessage();
            String message1 = "Product Checklist Map Adding Failed!!";
            modelAndView.addObject("message1", message1);
        }

        List<ProductDocumentChecklistMapping> dcmaps = dcmapService.getProductDocumentChecklistMappings();
        modelAndView.addObject("dcmaps", dcmaps);
        return modelAndView;
    }

    @RequestMapping(value = "/listMappings")
    public ModelAndView listOfProductChecklistMaps() {
        ModelAndView modelAndView = new ModelAndView("doc_checklist_mapping/list-of-checklist-mapping");

        List<ProductDocumentChecklistMapping> dcmaps = dcmapService.getProductDocumentChecklistMappings();
        modelAndView.addObject("dcmaps", dcmaps);
        return modelAndView;
    }

    @RequestMapping(value = "/editMapping/{id}", method = RequestMethod.GET)
    public ModelAndView editProductChecklistMap(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("doc_checklist_mapping/edit-checklist-mapping-form");
        ProductDocumentChecklistMapping dcmaps = dcmapService.getProductDocumentChecklistMapping(id);
        modelAndView.addObject("dcmap", dcmaps);

        List<ProductBase> productNames = pbaseService.getProducts();
        List<String> ProdNames = new ArrayList<String>();

        Iterator<ProductBase> pname = productNames.iterator();
        while (pname.hasNext()) {
            ProdNames.add(pname.next().getProductName());
        }

        List<DocumentTypeBase> documentNames = dtbaseService.getDocumentTypeBases();
        List<String> DocNames = new ArrayList<String>();

        Iterator<DocumentTypeBase> dname = documentNames.iterator();
        while (dname.hasNext()) {
            DocNames.add(dname.next().getDocumentType());
        }

        ProductBase pid = null;
        DocumentTypeBase did = null;

        for (ProductBase pb : productNames) {
            if (pb.getPid().equals(dcmaps.getProductId().getPid())) {
                pid = pb;
                break;
            }
        }

        for (DocumentTypeBase db : documentNames) {
            if (db.getDid().equals(dcmaps.getDocumentId().getDid())) {
                did = db;
                break;
            }
        }

        ProdNames.remove(pid.getProductName());
        DocNames.remove(did.getDocumentType());

        modelAndView.addObject("ProdNames", ProdNames);
        modelAndView.addObject("DocNames", DocNames);

        modelAndView.addObject("ProdName", pid.getProductName());
        modelAndView.addObject("DocName", did.getDocumentType());

        List<String> DropValues = new ArrayList<String>();
        DropValues.add("Y");
        DropValues.add("N");

        modelAndView.addObject("DropValues", DropValues);

        return modelAndView;
    }

    @RequestMapping(value = "/editMapping/{id}", method = RequestMethod.POST)
    public ModelAndView editingProductChecklistMap(@ModelAttribute ProductDocumentChecklistMapping dcmap,
            @PathVariable Integer id, @RequestParam("pname") String pname, @RequestParam("dtype") String dtype
    ) {

        ModelAndView modelAndView = new ModelAndView("doc_checklist_mapping/list-of-checklist-mapping");

        List<ProductBase> productNames = pbaseService.getProducts();
        List<DocumentTypeBase> docNames = dtbaseService.getDocumentTypeBases();

        ProductBase pid = null;
        DocumentTypeBase did = null;

        for (ProductBase pb : productNames) {
            if (pb.getProductName().equalsIgnoreCase(pname)) {
                pid = pb;
                break;
            }
        }

        for (DocumentTypeBase db : docNames) {
            if (db.getDocumentType().equalsIgnoreCase(dtype)) {
                did = db;
                break;
            }
        }

        dcmap.setProductId(pid);
        dcmap.setDocumentId(did);

        ProductBase currentpbases = pbaseService.getProduct(dcmap.getProductId().getPid());
        DocumentTypeBase currentdtbase = dtbaseService.getDocumentTypeBase(dcmap.getDocumentId().getDid());

        try {
            dcmapService.updateProductDocumentChecklistMapping(dcmap);

            String message = "Document Type was successfully edited!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Product Checklist Map Editing Failed!!";
            //String message1 = ex.getMessage();
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            ProductDocumentChecklistMapping currentdcmapbase = dcmapService.getProductDocumentChecklistMapping(dcmap.getPdcid());
            if (currentpbases == null) {
                String message1 = "Product ID Not Exist!!!";
                modelAndView.addObject("message1", message1);
            } else if (currentdtbase == null) {
                String message1 = "Document ID Not Exist!!";
                modelAndView.addObject("message1", message1);
            } else {
                String message1 = "Product Checklist Map Editing Failed!!";
                //String message1 = ex.getMessage();
                modelAndView.addObject("message1", message1);
            }
        } catch (TransientPropertyValueException ex) {
            {

                ProductDocumentChecklistMapping currentdcmapbase = dcmapService.getProductDocumentChecklistMapping(dcmap.getPdcid());
                if (currentpbases == null) {
                    String message1 = "Product ID Not Exist!!!";
                    modelAndView.addObject("message1", message1);
                } else if (currentdtbase == null) {
                    String message1 = "Document ID Not Exist!!";
                    modelAndView.addObject("message1", message1);
                } else {
                    String message1 = "Product Checklist Map Editing Failed!!";
                    //String message1 = ex.getMessage();
                    modelAndView.addObject("message1", message1);
                }
            }
        } catch (Exception ex) {
            //String message1 = ex.getMessage();
            String message1 = "Product Checklist Map Editing Failed!!";
            modelAndView.addObject("message1", message1);
        }

        List<ProductDocumentChecklistMapping> dcmaps = dcmapService.getProductDocumentChecklistMappings();
        modelAndView.addObject("dcmaps", dcmaps);
        return modelAndView;
    }

    @RequestMapping(value = "/deleteMapping/{id}", method = RequestMethod.GET)
    public ModelAndView deleteProductCategory(@PathVariable Integer id
    ) {
        ModelAndView modelAndView = new ModelAndView("doc_checklist_mapping/list-of-checklist-mapping");

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

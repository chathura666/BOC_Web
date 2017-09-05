/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.controller;

import com.sprhib.model.DocumentTypeBase;
import com.sprhib.model.LoanPurposes;
import com.sprhib.model.LoanPurposesDocumentChecklistMapping;
import com.sprhib.service.Document_Type_BaseService;
import com.sprhib.service.LoanPurposesDocumentChecklistMappingService;
import com.sprhib.service.LoanPurposesDocumentChecklistMappingServiceImpl;
import com.sprhib.service.LoanPurposesService;
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
@RequestMapping(value = "/LoanPurposesDocumentChecklistMapping")
public class LoanPurposesDocumentChecklistMappingController {

    @Autowired
    LoanPurposesDocumentChecklistMappingService dcmapService;

    @Autowired
    LoanPurposesService loanService;

    @Autowired
    Document_Type_BaseService dtbaseService;

    @RequestMapping(value = "/addMapping", method = RequestMethod.GET)
    public ModelAndView addPurposeChecklistMap() {
        ModelAndView modelAndView = new ModelAndView("loanpurpose_doc_checklist_mapping/add-checklist-mapping-form");

        List<LoanPurposes> AllPurposes = loanService.getLoanPurposes();

        List<String> Purposes = new ArrayList<String>();

        Iterator<LoanPurposes> loan_purpose = AllPurposes.iterator();
        while (loan_purpose.hasNext()) {
            Purposes.add(loan_purpose.next().getLoanPurposes());
        }

        List<DocumentTypeBase> docNames = dtbaseService.getDocumentTypeBases();
        List<String> DocName = new ArrayList<String>();

        Iterator<DocumentTypeBase> dname = docNames.iterator();
        while (dname.hasNext()) {
            DocName.add(dname.next().getDocumentType());
        }

        modelAndView.addObject("Purposes", Purposes);
        modelAndView.addObject("DocName", DocName);
        modelAndView.addObject("dcmap", new LoanPurposesDocumentChecklistMapping());
        return modelAndView;
    }

    @RequestMapping(value = "/addMapping", method = RequestMethod.POST)
    public ModelAndView addingPurposeChecklistMap(@ModelAttribute LoanPurposesDocumentChecklistMapping dcmap, @RequestParam("purpose") String purpose, @RequestParam("dtype") String dtype) {

        ModelAndView modelAndView = new ModelAndView("loanpurpose_doc_checklist_mapping/list-of-checklist-mapping");

        List<LoanPurposes> purposes = loanService.getLoanPurposes();
        List<DocumentTypeBase> docs = dtbaseService.getDocumentTypeBases();

        LoanPurposes pid = null;
        DocumentTypeBase did = null;

        for (LoanPurposes pb : purposes) {
            if (pb.getLoanPurposes().equalsIgnoreCase(purpose)) {
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

        dcmap.setPurposeId(pid);
        dcmap.setDocumentId(did);

        LoanPurposes currentpurpose = loanService.getLoanPurposes(dcmap.getPrpid());
        DocumentTypeBase currentdtbase = dtbaseService.getDocumentTypeBase(dcmap.getDocumentId().getDid());

        try {
            dcmapService.addMapping(dcmap);

            String message = "Mapping was successfully added!!.";
            modelAndView.addObject("message", message);
        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Mapping Adding Failed!!";
            //String message1 = ex.getMessage();
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            LoanPurposesDocumentChecklistMapping currentdcmapbase = dcmapService.getMapping(dcmap.getPrpid());
            if (currentdcmapbase != null) {
                String message1 = "Mapping Already Exist!!!";
                //String message1 = ex.getMessage();
                modelAndView.addObject("message1", message1);
            }

            if (currentpurpose == null) {
                String message1 = "Purpose ID Not Exist!!!";
                modelAndView.addObject("message1", message1);
            } else if (currentdtbase == null) {
                String message1 = "Document ID Not Exist!!";
                modelAndView.addObject("message1", message1);
            } else {
                String message1 = "Mapping Adding Failed!!";
                //String message1 = ex.getMessage();
                modelAndView.addObject("message1", message1);
            }
        } catch (TransientPropertyValueException ex) {

            {
                LoanPurposesDocumentChecklistMapping currentdcmapbase = dcmapService.getMapping(dcmap.getPrpid());
                if (currentdcmapbase != null) {
                    String message1 = "Mapping Already Exist!!!";
                    //String message1 = ex.getMessage();
                    modelAndView.addObject("message1", message1);
                }

                if (currentpurpose == null) {
                    String message1 = "Purpose ID Not Exist!!!";
                    modelAndView.addObject("message1", message1);
                } else if (currentdtbase == null) {
                    String message1 = "Document ID Not Exist!!";
                    modelAndView.addObject("message1", message1);
                } else {
                    String message1 = "Mapping Adding Failed!!";
                    //String message1 = ex.getMessage();
                    modelAndView.addObject("message1", message1);
                }
            }
        } catch (Exception ex) {
            //String message1 = ex.getMessage();
            String message1 = "Product Checklist Map Adding Failed!!";
            modelAndView.addObject("message1", message1);
        }

        List<LoanPurposesDocumentChecklistMapping> dcmaps = dcmapService.getMappings();
        modelAndView.addObject("dcmaps", dcmaps);
        return modelAndView;
    }

    @RequestMapping(value = "/listMappings")
    public ModelAndView listOfPurposeChecklistMaps() {
        ModelAndView modelAndView = new ModelAndView("loanpurpose_doc_checklist_mapping/list-of-checklist-mapping");

        List<LoanPurposesDocumentChecklistMapping> dcmaps = dcmapService.getMappings();
        modelAndView.addObject("dcmaps", dcmaps);
        return modelAndView;
    }

    @RequestMapping(value = "/editMapping/{id}", method = RequestMethod.GET)
    public ModelAndView editPurposeChecklistMap(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("loanpurpose_doc_checklist_mapping/edit-checklist-mapping-form");
        LoanPurposesDocumentChecklistMapping dcmaps = dcmapService.getMapping(id);
        modelAndView.addObject("dcmap", dcmaps);

        List<LoanPurposes> AllPurposes = loanService.getLoanPurposes();
        List<String> Purposes = new ArrayList<String>();

        Iterator<LoanPurposes> loan_purpose = AllPurposes.iterator();
        while (loan_purpose.hasNext()) {
            Purposes.add(loan_purpose.next().getLoanPurposes());
        }

        List<DocumentTypeBase> documentNames = dtbaseService.getDocumentTypeBases();
        List<String> DocNames = new ArrayList<String>();

        Iterator<DocumentTypeBase> dname = documentNames.iterator();
        while (dname.hasNext()) {
            DocNames.add(dname.next().getDocumentType());
        }

        LoanPurposes pid = null;
        DocumentTypeBase did = null;

        for (LoanPurposes pb : AllPurposes) {
            if (pb.getPid().equals(dcmaps.getPrpid())) {
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

        Purposes.remove(pid.getLoanPurposes());
        DocNames.remove(did.getDocumentType());

        modelAndView.addObject("Purposes", Purposes);
        modelAndView.addObject("DocNames", DocNames);

        modelAndView.addObject("Purpose", pid.getLoanPurposes());
        modelAndView.addObject("DocName", did.getDocumentType());

        List<String> DropValues = new ArrayList<String>();
        DropValues.add("Y");
        DropValues.add("N");

        modelAndView.addObject("DropValues", DropValues);

        return modelAndView;
    }

    @RequestMapping(value = "/editMapping/{id}", method = RequestMethod.POST)
    public ModelAndView editingPurposeChecklistMap(@ModelAttribute LoanPurposesDocumentChecklistMapping dcmap,
            @PathVariable Integer id, @RequestParam("purpose") String purpose, @RequestParam("dtype") String dtype
    ) {

        ModelAndView modelAndView = new ModelAndView("loanpurpose_doc_checklist_mapping/list-of-checklist-mapping");

        List<LoanPurposes> AllPurposes = loanService.getLoanPurposes();
        List<DocumentTypeBase> docNames = dtbaseService.getDocumentTypeBases();

        LoanPurposes pid = null;
        DocumentTypeBase did = null;

        for (LoanPurposes pb : AllPurposes) {
            if (pb.getLoanPurposes().equalsIgnoreCase(purpose)) {
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

        dcmap.setPurposeId(pid);
        dcmap.setDocumentId(did);

        LoanPurposes currentpbases = loanService.getLoanPurposes(dcmap.getPrpid());
        DocumentTypeBase currentdtbase = dtbaseService.getDocumentTypeBase(dcmap.getDocumentId().getDid());

        try {
            dcmapService.updateMapping(dcmap);

            String message = "Mapping was successfully edited!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Map Editing Failed!!";
            //String message1 = ex.getMessage();
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            LoanPurposesDocumentChecklistMapping currentdcmapbase = dcmapService.getMapping(dcmap.getPrpid());

            if (currentdcmapbase != null) {
                String message1 = "Document Checklist Map Already Exist!!!";
                //String message1 = ex.getMessage();
                modelAndView.addObject("message1", message1);
            }

            if (currentpbases == null) {
                String message1 = "Purpose ID Not Exist!!!";
                modelAndView.addObject("message1", message1);
            } else if (currentdtbase == null) {
                String message1 = "Document ID Not Exist!!";
                modelAndView.addObject("message1", message1);
            } else {
                String message1 = "Map Editing Failed!!";
                //String message1 = ex.getMessage();
                modelAndView.addObject("message1", message1);
            }
        } catch (TransientPropertyValueException ex) {
            {

                LoanPurposesDocumentChecklistMapping currentdcmapbase = dcmapService.getMapping(dcmap.getPrpid());

                if (currentdcmapbase != null) {
                    String message1 = "Document Checklist Map Already Exist!!!";
                    //String message1 = ex.getMessage();
                    modelAndView.addObject("message1", message1);
                }

                if (currentpbases == null) {
                    String message1 = "Purpose ID Not Exist!!!";
                    modelAndView.addObject("message1", message1);
                } else if (currentdtbase == null) {
                    String message1 = "Document ID Not Exist!!";
                    modelAndView.addObject("message1", message1);
                } else {
                    String message1 = "Map Editing Failed!!";
                    //String message1 = ex.getMessage();
                    modelAndView.addObject("message1", message1);
                }
            }
        } catch (Exception ex) {
            //String message1 = ex.getMessage();
            String message1 = "Map Editing Failed!!";
            modelAndView.addObject("message1", message1);
        }

        List<LoanPurposesDocumentChecklistMapping> dcmaps = dcmapService.getMappings();
        modelAndView.addObject("dcmaps", dcmaps);
        return modelAndView;
    }

    @RequestMapping(value = "/deleteMapping/{id}", method = RequestMethod.GET)
    public ModelAndView deletePurposeChecklistMap(@PathVariable Integer id
    ) {
        ModelAndView modelAndView = new ModelAndView("loanpurpose_doc_checklist_mapping/list-of-checklist-mapping");

        try {
            dcmapService.deleteMapping(id);
            String message = "Mapping was successfully deleted!!.";
            modelAndView.addObject("message", message);
        } catch (Exception ex) {

            String message1 = "Document Delete failed!!";
            modelAndView.addObject("message1", message1);

        }

        List<LoanPurposesDocumentChecklistMapping> dcmaps = dcmapService.getMappings();
        modelAndView.addObject("dcmaps", dcmaps);

        return modelAndView;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.controller;

import com.sprhib.model.AreaBase;
import com.sprhib.model.AreaBranchMapping;
import com.sprhib.model.BranchBase;
import com.sprhib.service.AreaBaseService;
import com.sprhib.service.AreaBranchMappingService;
import com.sprhib.service.BranchBaseService;
import java.util.ArrayList;
import java.util.Collections;
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
@RequestMapping(value = "/AreaBranchMapping")
public class AreaBranchMappingController {

    @Autowired
    AreaBranchMappingService abmapService;

    @Autowired
    AreaBaseService abservice;

    @Autowired
    BranchBaseService bbservice;

    final static Logger logger = Logger.getLogger(AreaBranchMappingController.class);

    @RequestMapping(value = "/addMapping", method = RequestMethod.GET)
    public ModelAndView addAreaBranchMap() {
        ModelAndView modelAndView = new ModelAndView("area_branch_mapping/add-area-branch-mapping");

        List<AreaBase> allAreas = abservice.getAreaBases();
        List<String> areaName = new ArrayList<String>();

        Iterator<AreaBase> aname = allAreas.iterator();
        while (aname.hasNext()) {
            areaName.add(aname.next().getAreaName());

        }

        List<BranchBase> allBranches = bbservice.getBranchBases();
        List<String> branchName = new ArrayList<String>();

        Iterator<BranchBase> bname = allBranches.iterator();
        while (bname.hasNext()) {
            BranchBase current = bname.next();
            System.out.println(current.getBranchName() + "/" + current.getBranchCode());
            branchName.add(current.getBranchName() + "/" + current.getBranchCode());
        }

        Collections.sort(branchName);
        modelAndView.addObject("areaName", areaName);
        modelAndView.addObject("branchName", branchName);

        modelAndView.addObject("abmap", new AreaBranchMapping());
        return modelAndView;
    }

    @RequestMapping(value = "/addMapping", method = RequestMethod.POST)
    public ModelAndView addingAreaBranchMap(@ModelAttribute AreaBranchMapping abmap, @RequestParam("aname") String aname, @RequestParam("bname") String bname) {

        ModelAndView modelAndView = new ModelAndView("area_branch_mapping/list-of-area-branch-mapping");

        List<AreaBase> AllAreas = abservice.getAreaBases();
        List<BranchBase> AllBranches = bbservice.getBranchBases();

        AreaBase area = null;
        BranchBase branch = null;

        for (AreaBase ab : AllAreas) {
            if (ab.getAreaName().equalsIgnoreCase(aname)) {
                area = ab;
                break;
            }
        }

        String[] bn = bname.split("_");

        for (BranchBase bb : AllBranches) {
            if (bb.getBranchName().equalsIgnoreCase(bn[0])) {
                branch = bb;
                break;
            }
        }

        abmap.setAid(area);
        abmap.setBid(branch);

        try {
            abmapService.addAreaBranchMap(abmap);

            String message = "Record was successfully added!!.";
            logger.info("Area Branch Mapping Record Inserted... : " + abmap.getAreaBrId()+ "_" + abmap.getAid()+ "_" + abmap.getBid());

            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Record Adding Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            AreaBranchMapping currentabmap = abmapService.getAreaBranchMap(abmap.getAreaBrId());
            if (currentabmap != null) {
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
        List<AreaBranchMapping> abmaps = abmapService.getAreaBranchMaps();

        modelAndView.addObject("abmaps", abmaps);
        return modelAndView;
    }

    @RequestMapping(value = "/listMappings")
    public ModelAndView listOfAreaBranchMaps() {
        ModelAndView modelAndView = new ModelAndView("area_branch_mapping/list-of-area-branch-mapping");

        List<AreaBranchMapping> abmaps = abmapService.getAreaBranchMaps();

        modelAndView.addObject("abmaps", abmaps);
        return modelAndView;
    }

    @RequestMapping(value = "/editMapping/{id}", method = RequestMethod.GET)
    public ModelAndView editAreaBranchMap(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("area_branch_mapping/edit-area-branch-mapping");
        AreaBranchMapping abmaps = abmapService.getAreaBranchMap(id);

        List<AreaBase> AllAreas = abservice.getAreaBases();
        List<String> ANames = new ArrayList<String>();

        Iterator<AreaBase> aname = AllAreas.iterator();
        while (aname.hasNext()) {
            ANames.add(aname.next().getAreaName());
        }

        List<BranchBase> allBranches = bbservice.getBranchBases();
        List<String> BNames = new ArrayList<String>();

        Iterator<BranchBase> bname = allBranches.iterator();
        while (bname.hasNext()) {
            BranchBase current = bname.next();
            BNames.add(current.getBranchName() + "_" + current.getBranchCode());
        }

        AreaBase area = null;
        BranchBase branch = null;

        for (AreaBase ab : AllAreas) {
            if (ab.getAreaName().equalsIgnoreCase(abmaps.getAid().getAreaName())) {
                area = ab;
                break;
            }
        }

        for (BranchBase db : allBranches) {
            if (db.getBranchName().equalsIgnoreCase(abmaps.getBid().getBranchName())) {
                branch = db;
                break;
            }
        }

        ANames.remove(area.getAreaName());
        BNames.remove(branch.getBranchName() + "_" + branch.getBranchCode());

        modelAndView.addObject("ANames", ANames);
        modelAndView.addObject("BNames", BNames);

        modelAndView.addObject("AName", area.getAreaName());
        modelAndView.addObject("BName", branch.getBranchName() + "_" + branch.getBranchCode());

        modelAndView.addObject("abmap", abmaps);
        return modelAndView;
    }

    @RequestMapping(value = "/editMapping/{id}", method = RequestMethod.POST)
    public ModelAndView editingAreaBranchMap(@ModelAttribute AreaBranchMapping abmap, @PathVariable Integer id, @RequestParam("aname") String aname, @RequestParam("bname") String bname) {

        ModelAndView modelAndView = new ModelAndView("area_branch_mapping/list-of-area-branch-mapping");

        List<AreaBase> AllAreas = abservice.getAreaBases();
        List<BranchBase> AllBranches = bbservice.getBranchBases();

        AreaBase area = null;
        BranchBase branch = null;

        String[] bn = bname.split("_");

        for (AreaBase ab : AllAreas) {
            if (ab.getAreaName().equalsIgnoreCase(aname)) {
                area = ab;
                break;
            }
        }

        for (BranchBase bb : AllBranches) {
            if (bb.getBranchName().equalsIgnoreCase(bn[0])) {
                branch = bb;
                break;
            }
        }

        abmap.setAid(area);
        abmap.setBid(branch);

        try {
            abmapService.updateAreaBranchMap(abmap);

            String message = "Record was successfully edited!!.";
            logger.info("Area Branch Mapping Record updated... : " + abmap.getAreaBrId());
            
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Record editing Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            AreaBranchMapping currentabase = abmapService.getAreaBranchMap(abmap.getAreaBrId());
            if (currentabase != null) {
                String message1 = "Record With Same ID Already Exist!!!";
                modelAndView.addObject("message1", message1);
            } else {
                String message1 = "Mapping Editing Failed!!";
                modelAndView.addObject("message1", message1);
            }
        } catch (Exception ex) {
            String message1 = "Record Editing Failed!!";
            modelAndView.addObject("message1", message1);
        }

        List<AreaBranchMapping> abmaps = abmapService.getAreaBranchMaps();

        modelAndView.addObject("abmaps", abmaps);
        return modelAndView;
    }

    @RequestMapping(value = "/deleteMapping/{id}", method = RequestMethod.GET)
    public ModelAndView deleteAreaBranchMap(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("area_branch_mapping/list-of-area-branch-mapping");

        try {
            abmapService.deleteAreaBranchMap(id);
            String message = "Record was successfully deleted!!.";
            logger.info("Area Branch Mapping Record deleted... : " + id);
            modelAndView.addObject("message", message);
        } catch (Exception ex) {

            String message1 = ex.getMessage();
            modelAndView.addObject("message1", message1);

        }

        List<AreaBranchMapping> abmaps = abmapService.getAreaBranchMaps();

        modelAndView.addObject("abmaps", abmaps);
        return modelAndView;
    }

}

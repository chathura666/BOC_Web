/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.controller;

import com.sprhib.model.AreaBase;
import com.sprhib.model.AreaBranchMapping;
import com.sprhib.model.BranchBase;
import com.sprhib.model.DocumentTypeBase;
import com.sprhib.model.ProductBase;
import com.sprhib.service.AreaBaseService;
import com.sprhib.service.AreaBranchMappingService;
import com.sprhib.service.BranchBaseService;
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
@RequestMapping(value = "/AreaBranchMap")
public class AreaBranchMappingController {

    @Autowired
    AreaBranchMappingService abmapService;

    @Autowired
    AreaBaseService abservice;

    @Autowired
    BranchBaseService bbservice;

    @RequestMapping(value = "/addMap", method = RequestMethod.GET)
    public ModelAndView addAreaBranchMap() {
        ModelAndView modelAndView = new ModelAndView("add-area-branch-mapping");

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
            branchName.add(bname.next().getBranchName() + "_" + bname.next().getBranchCode());
        }

        modelAndView.addObject("areaName", areaName);
        modelAndView.addObject("branchName", branchName);

        modelAndView.addObject("abmap", new AreaBranchMapping());
        return modelAndView;
    }

    @RequestMapping(value = "/addMap", method = RequestMethod.POST)
    public ModelAndView addingAreaBranchMap(@ModelAttribute AreaBranchMapping abmap, @RequestParam("aname") String aname, @RequestParam("bname") String bname) {

        ModelAndView modelAndView = new ModelAndView("list-of-area-branch-mapping");

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

            String message = "Area Branch Mapping was successfully added!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Mapping Adding Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            AreaBranchMapping currentabmap = abmapService.getAreaBranchMap(abmap.getAreaBrId());
            if (currentabmap != null) {
                String message1 = "Mapping Already Exist!!!";
                modelAndView.addObject("message1", message1);
            } else {
                String message1 = "Mapping Adding Failed!!";
                modelAndView.addObject("message1", message1);
            }
        } catch (Exception ex) {
            String message1 = "Mapping Adding Failed!!";
            modelAndView.addObject("message1", message1);
        }
        List<AreaBranchMapping> abmaps = abmapService.getAreaBranchMaps();

        modelAndView.addObject("abmaps", abmaps);
        return modelAndView;
    }

    @RequestMapping(value = "/listMap")
    public ModelAndView listOfAreaBranchMaps() {
        ModelAndView modelAndView = new ModelAndView("list-of-area-branch-mapping");

        List<AreaBranchMapping> abmaps = abmapService.getAreaBranchMaps();

        modelAndView.addObject("abmaps", abmaps);
        return modelAndView;
    }

    @RequestMapping(value = "/editMap/{id}", method = RequestMethod.GET)
    public ModelAndView editAreaBranchMap(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("edit-area-branch-mapping");
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
            BNames.add(bname.next().getBranchName() + "_" + bname.next().getBranchCode());
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
        BNames.remove(branch.getBranchName());

        modelAndView.addObject("ANames", ANames);
        modelAndView.addObject("BNames", BNames);

        modelAndView.addObject("AName", area.getAreaName());
        modelAndView.addObject("BName", branch.getBranchName()+"_"+branch.getBranchCode());

        modelAndView.addObject("abmap", abmaps);
        return modelAndView;
    }

    @RequestMapping(value = "/editMap/{id}", method = RequestMethod.POST)
    public ModelAndView editingAreaBranchMap(@ModelAttribute AreaBranchMapping abmap, @PathVariable Integer id, @RequestParam("aname") String aname, @RequestParam("bname") String bname) {

        ModelAndView modelAndView = new ModelAndView("list-of-area-branch-mapping");

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

            String message = "Mapping was successfully edited!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Mapping editing Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            AreaBranchMapping currentabase = abmapService.getAreaBranchMap(abmap.getAreaBrId());
            if (currentabase != null) {
                String message1 = "Mapping With Same ID Already Exist!!!";
                modelAndView.addObject("message1", message1);
            } else {
                String message1 = "Mapping Editing Failed!!";
                modelAndView.addObject("message1", message1);
            }
        } catch (Exception ex) {
            String message1 = "Mapping Editing Failed!!";
            modelAndView.addObject("message1", message1);
        }

        List<AreaBranchMapping> abmaps = abmapService.getAreaBranchMaps();

        modelAndView.addObject("abmaps", abmaps);
        return modelAndView;
    }

    @RequestMapping(value = "/deleteMap/{id}", method = RequestMethod.GET)
    public ModelAndView deleteAreaBranchMap(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("list-of-area-branch-mapping");

        try {
            abmapService.deleteAreaBranchMap(id);
            String message = "Mapping was successfully deleted!!.";
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

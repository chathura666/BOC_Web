/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.controller;

import com.sprhib.model.BranchBase;
import com.sprhib.model.RlcBase;
import com.sprhib.model.RlcBranchMapping;
import com.sprhib.service.BranchBaseService;
import com.sprhib.service.RlcBaseService;
import com.sprhib.service.RlcBranchMappingService;
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
@RequestMapping(value = "/RlcBranchMapping")
public class RlcBranchMappingController {

    @Autowired
    RlcBranchMappingService rlcmapService;

    @Autowired
    BranchBaseService branchService;

    @Autowired
    RlcBaseService rlcService;

    final static Logger logger = Logger.getLogger(RlcBranchMappingController.class);

    @RequestMapping(value = "/addMapping", method = RequestMethod.GET)
    public ModelAndView addRlcBranchMapping() {
        ModelAndView modelAndView = new ModelAndView("rlc_branch_mapping/add-rlc-mapping");

        List<BranchBase> allBranches = branchService.getBranchBases();
        List<String> branchName = new ArrayList<String>();

        Iterator<BranchBase> bname = allBranches.iterator();
        while (bname.hasNext()) {
            BranchBase current = bname.next();
            branchName.add(current.getBranchName() + "/" + current.getBranchCode());
        }

        List<RlcBase> allRlcs = rlcService.getRlcBases();
        List<String> RlcName = new ArrayList<String>();

        Iterator<RlcBase> rname = allRlcs.iterator();
        while (rname.hasNext()) {
            RlcBase current = rname.next();
            System.out.println(current.getRlcName() + "/" + current.getRlcCode());
            RlcName.add(current.getRlcName() + "/" + current.getRlcCode());
        }

        Collections.sort(branchName);
        modelAndView.addObject("branchName", branchName);
        modelAndView.addObject("rlcName", RlcName);

        modelAndView.addObject("rlcmap", new RlcBranchMapping());
        return modelAndView;
    }

    @RequestMapping(value = "/addMapping", method = RequestMethod.POST)
    public ModelAndView addingRlcBranchMapping(@ModelAttribute RlcBranchMapping rlcmap, @RequestParam("rname") String rname, @RequestParam("bname") String bname) {

        ModelAndView modelAndView = new ModelAndView("rlc_branch_mapping/list-of-rlc-mapping");

        List<RlcBase> AllRlcs = rlcService.getRlcBases();
        List<BranchBase> AllBranches = branchService.getBranchBases();

        RlcBase rlc = null;
        BranchBase branch = null;

        String[] rn = rname.split("/");

        for (RlcBase r : AllRlcs) {
            if (r.getRlcName().equalsIgnoreCase(rn[0].trim())) {
                rlc = r;
                break;
            }
        }

        String[] bn = bname.split("/");

        for (BranchBase bb : AllBranches) {
            if (bb.getBranchName().equalsIgnoreCase(bn[0].trim())) {
                branch = bb;
                break;
            }
        }

        rlcmap.setRlcId(rlc);
        rlcmap.setBid(branch);

        try {
            rlcmapService.addRlcBranchMapping(rlcmap);

            String message = "Record was successfully added!!.";
            logger.info("Rlc Branch Mapping Record Inserted... : " + rlcmap.getRlcBrId()+"_"+rlcmap.getRlcId()+"_"+rlcmap.getBid());
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Record Adding Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            RlcBranchMapping currentrmap = rlcmapService.getRlcBranchMapping(rlcmap.getRlcBrId());
            if (currentrmap != null) {
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
        List<RlcBranchMapping> rmaps = rlcmapService.getRlcBranchMappings();

        modelAndView.addObject(
                "rmaps", rmaps);
        return modelAndView;
    }

    @RequestMapping(value = "/listMappings")
    public ModelAndView listOfRlcBranchMappings() {
        ModelAndView modelAndView = new ModelAndView("rlc_branch_mapping/list-of-rlc-mapping");

        List<RlcBranchMapping> rmaps = rlcmapService.getRlcBranchMappings();
        modelAndView.addObject("rmaps", rmaps);

        return modelAndView;
    }

    @RequestMapping(value = "/editMapping/{id}", method = RequestMethod.GET)
    public ModelAndView editRlcBranchMapping(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("rlc_branch_mapping/edit-rlc-mapping");
        RlcBranchMapping rmap = rlcmapService.getRlcBranchMapping(id);

        List<RlcBase> AllRlcs = rlcService.getRlcBases();
        List<String> RNames = new ArrayList<String>();

        Iterator<RlcBase> rname = AllRlcs.iterator();
        while (rname.hasNext()) {
            RlcBase current = rname.next();
            RNames.add(current.getRlcName()+ "/" + current.getRlcCode());
        }

        List<BranchBase> allBranches = branchService.getBranchBases();
        List<String> BNames = new ArrayList<String>();

        Iterator<BranchBase> bname = allBranches.iterator();
        while (bname.hasNext()) {
            BranchBase current = bname.next();
            BNames.add(current.getBranchName() + "/" + current.getBranchCode());
        }

        RlcBase rlc = null;
        BranchBase branch = null;

        for (RlcBase ab : AllRlcs) {
            if (ab.getRlcId()==(rmap.getRlcId().getRlcId())) {
                rlc = ab;
                break;
            }
        }

        for (BranchBase db : allBranches) {
            if (db.getBranchName().equalsIgnoreCase(rmap.getBid().getBranchName())) {
                branch = db;
                break;
            }
        }

        RNames.remove(rlc.getRlcName() +"/" +rlc.getRlcCode());
        BNames.remove(branch.getBranchName() + "/" + branch.getBranchCode());

        modelAndView.addObject("RNames", RNames);
        modelAndView.addObject("BNames", BNames);

        modelAndView.addObject("RName", rlc.getRlcName() + "/" + rlc.getRlcCode());
        modelAndView.addObject("BName", branch.getBranchName() + "/" + branch.getBranchCode());

        modelAndView.addObject("rmap", rmap);

        return modelAndView;
    }

    @RequestMapping(value = "/editMapping/{id}", method = RequestMethod.POST)
    public ModelAndView editingRlcBranchMapping(@ModelAttribute RlcBranchMapping rmap, @PathVariable Integer id,@RequestParam("rname") String rname, @RequestParam("bname") String bname) {

        ModelAndView modelAndView = new ModelAndView("rlc_branch_mapping/list-of-rlc-mapping");
        
        List<RlcBase> AllRlcs = rlcService.getRlcBases();
        List<BranchBase> AllBranches = branchService.getBranchBases();

        RlcBase rlc = null;
        BranchBase branch = null;

        String[] rn = rname.split("/");

        for (RlcBase r : AllRlcs) {
            if (r.getRlcName().equalsIgnoreCase(rn[0].trim())) {
                rlc = r;
                break;
            }
        }

        String[] bn = bname.split("/");

        for (BranchBase bb : AllBranches) {
            if (bb.getBranchName().equalsIgnoreCase(bn[0].trim())) {
                branch = bb;
                break;
            }
        }

        rmap = rlcmapService.getRlcBranchMapping(id);
        rmap.setRlcId(rlc);
        rmap.setBid(branch);
        

        try {
            rlcmapService.updateRlcBranchMapping(rmap);

            String message = "Record was successfully edited!!.";
            logger.info("Rlc Branch Mapping Record updated... : " + rmap.getRlcBrId());
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. Record editing Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            RlcBranchMapping currentrbase = rlcmapService.getRlcBranchMapping(rmap.getRlcBrId());
            if (currentrbase != null) {
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

        List<RlcBranchMapping> rmaps = rlcmapService.getRlcBranchMappings();
        modelAndView.addObject("rmaps", rmaps);

        return modelAndView;
    }

    @RequestMapping(value = "/deleteMapping/{id}", method = RequestMethod.GET)
    public ModelAndView deleteRlcBranchMapping(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("rlc_branch_mapping/list-of-rlc-mapping");

        try {
            rlcmapService.deleteRlcBranchMapping(id);
            String message = "Record was successfully deleted!!.";
            logger.info("Rlc Branch Mapping Record deleted... : " + id);
            modelAndView.addObject("message", message);
        } catch (Exception ex) {

            String message1 = ex.getMessage();
            modelAndView.addObject("message1", message1);

        }

        List<RlcBranchMapping> rmaps = rlcmapService.getRlcBranchMappings();
        modelAndView.addObject("rmaps", rmaps);

        return modelAndView;
    }

}

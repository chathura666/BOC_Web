/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.controller;

import com.sprhib.model.IndexIdBase;
import com.sprhib.service.IndexIdBaseService;
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
@RequestMapping(value = "/IndexIdBase")
public class IndexIdBaseController {

    @Autowired
    IndexIdBaseService indexService;

    @RequestMapping(value = "/addBase", method = RequestMethod.GET)
    public ModelAndView addIndexId() {
        ModelAndView modelAndView = new ModelAndView("indexid_base/add-indexid-base");
        modelAndView.addObject("index", new IndexIdBase());
        return modelAndView;
    }

    @RequestMapping(value = "/addBase", method = RequestMethod.POST)
    public ModelAndView addingIndexId(@ModelAttribute IndexIdBase index) {

        ModelAndView modelAndView = new ModelAndView("indexid_base/list-of-indexid-bases");
        try {
            indexService.addIndexId(index);

            String message = "IndexId was successfully added!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. IndexId Adding Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            IndexIdBase currentindex = indexService.getIndexId(index.getIdxId());
            if (currentindex != null) {
                String message1 = "IndexId Already Exist!!!";
                modelAndView.addObject("message1", message1);
            } else {
                String message1 = "IndexId Adding Failed!!";
                modelAndView.addObject("message1", message1);
            }
        } catch (Exception ex) {
            String message1 = "IndexId Adding Failed!!";
            modelAndView.addObject("message1", message1);
        }
        List<IndexIdBase> indexes = indexService.getIndexIds();

        modelAndView.addObject(
                "indexes", indexes);
        return modelAndView;
    }

    @RequestMapping(value = "/listBases")
    public ModelAndView listOfIndexIds() {
        ModelAndView modelAndView = new ModelAndView("indexid_base/list-of-indexid-bases");

        List<IndexIdBase> indexes = indexService.getIndexIds();

        modelAndView.addObject(
                "indexes", indexes);
        return modelAndView;
    }

    @RequestMapping(value = "/editBase/{id}", method = RequestMethod.GET)
    public ModelAndView editIndexId(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("indexid_base/edit-indexid-base");
        IndexIdBase index = indexService.getIndexId(id);
        modelAndView.addObject("index", index);
        return modelAndView;
    }

    @RequestMapping(value = "/editBase/{id}", method = RequestMethod.POST)
    public ModelAndView editingIndexId(@ModelAttribute IndexIdBase index, @PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("indexid_base/list-of-indexid-bases");

        try {
            indexService.updateIndexId(index);

            String message = "IndexId was successfully edited!!.";
            modelAndView.addObject("message", message);

        } catch (ConstraintViolationException ex) {

            String message1 = "Constraint Violation.. IndexId editing Failed!!";
            modelAndView.addObject("message1", message1);

        } catch (DataIntegrityViolationException ex) {

            IndexIdBase currentindex = indexService.getIndexId(index.getIdxId());
            if (currentindex != null) {
                String message1 = "Index With Same ID Already Exist!!!";
                modelAndView.addObject("message1", message1);
            } else {
                String message1 = "Index Editing Failed!!";
                modelAndView.addObject("message1", message1);
            }
        } catch (Exception ex) {
            String message1 = "Index Editing Failed!!";
            modelAndView.addObject("message1", message1);
        }

        List<IndexIdBase> indexes = indexService.getIndexIds();

        modelAndView.addObject(
                "indexes", indexes);
        return modelAndView;
    }

    @RequestMapping(value = "/deleteBase/{id}", method = RequestMethod.GET)
    public ModelAndView deleteIndexId(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("indexid_base/list-of-indexid-bases");

        try {
            indexService.deleteIndexId(id);
            String message = "Index was successfully deleted!!.";
            modelAndView.addObject("message", message);
        } catch (Exception ex) {

            String message1 = ex.getMessage();
            modelAndView.addObject("message1", message1);

        }

        List<IndexIdBase> indexes = indexService.getIndexIds();

        modelAndView.addObject(
                "indexes", indexes);
        return modelAndView;
    }

}

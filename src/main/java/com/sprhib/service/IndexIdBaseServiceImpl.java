/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.dao.IndexIdBaseDAO;
import com.sprhib.model.IndexIdBase;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author it207432
 */
@Service
@Transactional
public class IndexIdBaseServiceImpl implements IndexIdBaseService {

    @Autowired
    private IndexIdBaseDAO indexidDAO;

    @Override
    public void addIndexId(IndexIdBase abase) {
        indexidDAO.addIndexId(abase);
    }

    @Override
    public void updateIndexId(IndexIdBase abase) {
        indexidDAO.updateIndexId(abase);
    }

    @Override
    public IndexIdBase getIndexId(int id) {
        return indexidDAO.getIndexId(id);
    }

    @Override
    public void deleteIndexId(int id) {
        indexidDAO.deleteIndexId(id);
    }

    @Override
    public List<IndexIdBase> getIndexIds() {
        return indexidDAO.getIndexIds();
    }


}

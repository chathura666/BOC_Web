/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.model.IndexIdBase;
import java.util.List;

/**
 *
 * @author it207432
 */
public interface IndexIdBaseService {

    public void addIndexId(IndexIdBase abase);

    public void updateIndexId(IndexIdBase abase);

    public IndexIdBase getIndexId(int id);

    public void deleteIndexId(int id);

    public List<IndexIdBase> getIndexIds();

}

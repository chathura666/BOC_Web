/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.service;

import com.sprhib.model.AreaBase;
import com.sprhib.model.CbSequenceNumber;
import java.util.List;

/**
 *
 * @author it207432
 */
public interface CbSequenceNumberService {

    public void addCbSequenceNumber(CbSequenceNumber abase);

    public void updateCbSequenceNumber(CbSequenceNumber abase);

    public CbSequenceNumber getCbSequenceNumber(int id);

    public void deleteCbSequenceNumber(int id);

    public List<CbSequenceNumber> getCbSequenceNumbers();

}

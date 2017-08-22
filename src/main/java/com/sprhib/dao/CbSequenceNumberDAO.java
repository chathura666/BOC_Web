/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.BranchBase;
import com.sprhib.model.CbSequenceNumber;
import java.util.List;

/**
 *
 * @author it207432
 */
public interface CbSequenceNumberDAO {

    public void addCbSequenceNumber(CbSequenceNumber sqnum);

    public void updateCbSequenceNumber(CbSequenceNumber sqnum);

    public CbSequenceNumber getCbSequenceNumber(int id);

    public void deleteCbSequenceNumber(int id);

    public List<CbSequenceNumber> getCbSequenceNumbers();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.BsrProductBase;
import com.sprhib.model.CasSequenceNumber;
import com.sprhib.model.CasSequenceNumberPK;
import java.util.List;

/**
 *
 * @author it207432
 */
public interface CasSequenceNumberDAO {

    public void addSequenceNumber(CasSequenceNumber seqnum);

    public void updateSequenceNumber(CasSequenceNumber seqnum);

    public CasSequenceNumber getSequenceNumber(CasSequenceNumberPK seqnumpk);

    public void deleteSequenceNumber(CasSequenceNumber seqnumpk);

    public List<CasSequenceNumber> getSequenceNumbers();
}

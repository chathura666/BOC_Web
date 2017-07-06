/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprhib.dao;

import com.sprhib.model.AreaBase;
import com.sprhib.model.IndexIdBase;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author it207432
 */
@Repository
public class IndexIdBaseDAOImpl implements IndexIdBaseDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addIndexId(IndexIdBase indexid) {
        getCurrentSession().save(indexid);
    }

    @Override
    public void updateIndexId(IndexIdBase indexid) {
        IndexIdBase indexToUpdate = getIndexId(indexid.getIdxId());
        indexToUpdate.setIdxId(indexid.getIdxId());
        indexToUpdate.setDescription(indexid.getDescription());
        indexToUpdate.setIndexRate(indexid.getIndexRate());
        getCurrentSession().update(indexToUpdate);
    }

    @Override
    public IndexIdBase getIndexId(int pid) {
        IndexIdBase indexid = (IndexIdBase) getCurrentSession().get(IndexIdBase.class, pid);
        return indexid;

    }

    @Override
    public void deleteIndexId(int id) {
        IndexIdBase indexid = getIndexId(id);
        if (indexid != null) {
            getCurrentSession().delete(indexid);
        }

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<IndexIdBase> getIndexIds() {
        return getCurrentSession().createQuery("from IndexIdBase").list();
    }


}

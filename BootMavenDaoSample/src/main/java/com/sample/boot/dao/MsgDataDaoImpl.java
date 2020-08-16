package com.sample.boot.dao;

import org.springframework.stereotype.Repository;
import com.sample.boot.MsgData;
import javax.persistence.EntityManager;
import java.util.List;

@SuppressWarnings("rawtypes")
@Repository
public class MsgDataDaoImpl implements MsgDataDao<MsgData> {
    private static final long serialVersionUID = 1L;
    private EntityManager entityManager;

    public MsgDataDaoImpl(){
        super();
    }
    public MsgDataDaoImpl(EntityManager manager){
        this();
        entityManager = manager;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<MsgData> getAll() {
        return entityManager.createQuery("from MsgData").getResultList();
    }

    @Override
    public MsgData findById(long id) {
        return (MsgData)entityManager.createQuery("from MsgData where id = " + id).getSingleResult();
    }
}
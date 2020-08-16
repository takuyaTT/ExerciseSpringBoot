package com.sample.boot.dao;

import com.sample.boot.CustomerData;
import com.sample.boot.MsgData;

import java.io.Serializable;
import java.util.List;

public interface MsgDataDao<T> extends Serializable{
    public List<MsgData> getAll();
    public MsgData findById(long id);
}
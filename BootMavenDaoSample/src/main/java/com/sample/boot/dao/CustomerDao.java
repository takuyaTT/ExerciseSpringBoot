package com.sample.boot.dao;

import java.io.Serializable;
import java.util.List;

public interface CustomerDao<T> extends Serializable {
    public List<T> getAll();
    public List<T> find(String findstr);
    public T findById(long id);
    public List<T> findByName(String name);
}

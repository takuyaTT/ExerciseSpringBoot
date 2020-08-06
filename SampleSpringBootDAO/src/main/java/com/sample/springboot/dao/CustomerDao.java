package com.sample.springboot.dao;

import java.io.Serializable;
import java.util.List;

public interface CustomerDao <T> extends Serializable {
    public List<T> getAllCustomer();
}

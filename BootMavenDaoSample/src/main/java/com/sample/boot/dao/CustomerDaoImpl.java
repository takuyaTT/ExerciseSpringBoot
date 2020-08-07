package com.sample.boot.dao;
import com.sample.boot.CustomerData;
import com.sample.boot.dao.CustomerDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao<CustomerData> {
    private static final long serialVersionUID = 1L;

    private EntityManager entityManager;

    public CustomerDaoImpl(){
        super();
    }

    //エンティティマネージャー受け取り
    public CustomerDaoImpl(EntityManager manager){
        this();
        entityManager = manager;
    }

    //CustomerDaoのgetAllCustomerメソッドを実装
    @Override
    public List<CustomerData> getAll() {
        //クエリーを生成
        Query query = entityManager.createQuery("from CustomerData");
        @SuppressWarnings("unchecked")
        //結果をリストで受け取る
        List<CustomerData> list = query.getResultList();
        entityManager.close();
        return list;
    }
}
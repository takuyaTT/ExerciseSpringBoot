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

    /*
    @Override
    @SuppressWarnings("unchecked")
    public List<CustomerData> find(String findstr) {
        List<CustomerData> list = null;
        String qstr = "from CustomerData where id = :fid or name like :fname or mail like :fmail";
        Long fid = 0L;
        try{
            fid = Long.parseLong(findstr);
        }catch(NumberFormatException e){
            e.printStackTrace();
        }
        Query query = entityManager.createQuery(qstr).setParameter("fid",fid).setParameter("fname","%" + findstr +"%").setParameter("fmail",findstr + "@%");
        list = query.getResultList();
        return list;
    }
    */

    @SuppressWarnings("unchecked")
    @Override
    public List<CustomerData> find(String findstr) {
        List<CustomerData> list = null;
        Long fid = 0L;
        try{
            fid = Long.parseLong(findstr);
        }catch(NumberFormatException e){}
        Query query = entityManager.createNamedQuery("findWithName").setParameter("fname", "%" + findstr + "%");
        list = query.getResultList();
        return list;
    }

    @Override
    public CustomerData findById(long id) {
        return (CustomerData) entityManager.createQuery("from CustomerData where id = " + id).getSingleResult();
    }

    @Override
    @SuppressWarnings("uncheckd")
    public List<CustomerData> findByName(String name) {
        return (List<CustomerData>)entityManager.createQuery("from CustomerData where name = " + name).getResultList();
    }
}

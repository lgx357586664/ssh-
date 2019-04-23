package com.framework.impl;

import com.framework.Dao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author: LiGX
 * @Date: 2019-04-22 上午 11:57
 */
public class DaoImpl<T> implements Dao<T> {
    private Class<T> entityClass;

    @Autowired
    private HibernateTemplate hibernateTemplate;


    public DaoImpl() {
        ParameterizedType pt = (ParameterizedType)getClass().getGenericSuperclass();
        entityClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    @Override
    public List<T> findAll() {
        // 一个接口中只有一方法就可以采用lamda 表达式（参数名）->{ 方法体 }
//        (session)->{
//            return session.createQuery("from " + entityClass.getSimpleName()).list();
//        }
//        匿名内部类：没有名字的类
     /*   new HibernateCallback<List<T>>() {
            @Override
            public List<T> doInHibernate(Session session) throws HibernateException {

                Query<T> query = session.createQuery("from " + entityClass.getSimpleName(), entityClass);
                return query.list();
            }
        }*/
        // 执行查询
        List<T> list = hibernateTemplate.execute(new HibernateCallback<List<T>>() {
            @Override
            public List<T> doInHibernate(Session session) throws HibernateException {
                return session.createQuery("from " + entityClass.getSimpleName()).list();
            }
        });
        return list;
    }

    @Override
    public List<T> queryPage(int index, int pageCount) {
        List<T> list = hibernateTemplate.execute(new HibernateCallback<List<T>>() {
            @Override
            public List<T> doInHibernate(Session session) throws HibernateException {
                return session.createQuery("from " + entityClass.getSimpleName())
                        .setFirstResult(index)
                        .setMaxResults(pageCount)
                        .list();
            }
        });
        return list;
    }

    @Override
    public void add(T t) {
        hibernateTemplate.save(t);
    }

    @Override
    public T findById(Integer id) {

        return hibernateTemplate
                .get(entityClass, id);
    }

    @Override
    public void update(T t) {

        hibernateTemplate.update(t);
    }

    @Override
    public void delete(T t) {

        hibernateTemplate.delete(t);
    }

}

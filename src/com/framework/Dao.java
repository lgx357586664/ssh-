package com.framework;

import java.util.List;

/**
 * @author: LiGX
 * @Date: 2019-04-22 上午 11:56
 */
public interface Dao<T> {
    /**
     * 查询全部信息
     */
    public List<T> findAll();
    /**
     * 分页查询全部信息
     */
    public List<T> queryPage(int index, int pageCount);
    /**
     * 添加数据
     */
    public void add(T t);
    /**
     * 通过id 查询
     */
    public T findById(Integer id);
    /**
     * 修改
     */
    public void update(T t);
    /**
     * 单条删除
     */
    public void delete(T t );

}

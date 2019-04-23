package com.service;

import com.dao.UserDao;
import com.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author: LiGX
 * @Date: 2019-04-22 下午 12:57
 */
public interface UserService {

    public List<User> findAll();
    public void add(User user);
    public void update(User user);
    public void delete(User user);
    public User findOne(Integer id);
    public List<User> queryPage(int index, int pageCount);
}

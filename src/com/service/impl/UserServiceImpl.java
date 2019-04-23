package com.service.impl;

import com.dao.UserDao;
import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: LiGX
 * @Date: 2019-04-22 下午 12:57
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }
    @Transactional
    @Override
    public void update(User user) {
        userDao.update(user);
    }
    @Transactional
    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public User findOne(Integer id) {
        User user = (User)userDao.findById(id);
        return user;
    }

    @Override
    public List<User> queryPage(int index, int pageCount) {
        List list = userDao.queryPage(index, pageCount);
        return list;
    }
}

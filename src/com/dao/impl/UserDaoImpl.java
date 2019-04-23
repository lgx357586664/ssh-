package com.dao.impl;

import com.dao.UserDao;
import com.entity.User;
import com.framework.impl.DaoImpl;
import org.springframework.stereotype.Repository;

/**
 * @author: LiGX
 * @Date: 2019-04-22 下午 12:55
 */
@Repository
public class UserDaoImpl extends DaoImpl<User> implements UserDao<User> {

}

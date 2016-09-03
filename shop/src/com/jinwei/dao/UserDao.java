package com.jinwei.dao;

import com.jinwei.model.Account;
import com.jinwei.model.User;

public interface UserDao extends BaseDao<User> {
		public User login(User user);
}

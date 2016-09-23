package com.jinwei.service;

import com.jinwei.model.Account;
import com.jinwei.model.User;

public interface UserService extends BaseService<User> {
		public User login(User user);
		
		public boolean queryByLoginName(User user);
}

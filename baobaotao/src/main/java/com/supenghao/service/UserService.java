package com.supenghao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supenghao.dao.LoginLogDao;
import com.supenghao.dao.UserDao;
import com.supenghao.model.LoginLog;
import com.supenghao.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private LoginLogDao loginLogDao;
	
	public boolean hasMatchUser(String userName, String password) {
		int matchCount = userDao.getMatchCount(userName, password);
		return matchCount > 0;
		
	}
	
	public User findUserByUserName(String userName) {
		return userDao.findUserByUserName(userName);
		
	}
	
	
	public void loginSuccess(User user) {
		user.setCredits(5+user.getCredits());
		LoginLog loginLog = new LoginLog();
		loginLog.setIp(user.getLastIp());
		loginLog.setLoginDate(user.getLastVist());
		loginLog.setUserID(user.getUserId());
		userDao.updateLoginInfo(user);
		loginLogDao.insertLoginLog(loginLog);
	}
	

}

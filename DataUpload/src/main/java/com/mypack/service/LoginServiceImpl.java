package com.mypack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mypack.doa.LoginDao;
import com.mypack.model.Login;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private  LoginDao loginDao;
	public void setLoginDao(LoginDao loginDao) {
		
		this.loginDao=loginDao;
	}
	public void createRegister(Login login) {
		
		loginDao.createRegister(login);
	}
	public boolean checkLogin(String username, String password) {
		// TODO Auto-generated method stub
		System.out.println("In service class.. Check Login");
		
		return loginDao.checkLogin(username, password);
	}
	
	/*public Login getUserName(Login login) {
		// TODO Auto-generated method stub
		return loginDao.getUserName(login);
	}
	public Login getUsePassword(Login login) {
		// TODO Auto-generated method stub
		return loginDao.getUsePassword(login);
	}*/
	
	

}

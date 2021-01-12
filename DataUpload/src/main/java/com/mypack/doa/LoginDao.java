package com.mypack.doa;

import com.mypack.model.Login;

public interface LoginDao {
	public void createRegister(Login login);
	//public 	Login getUserName(Login login) ;
	//public 	Login getUsePassword(Login login) ;
	
	public boolean checkLogin(String username, String password);
}

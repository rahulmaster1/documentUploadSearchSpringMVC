package com.mypack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mypack.doa.FileUploadDao;
import com.mypack.model.Login;
import com.mypack.model.UploadFile;
@Service
@Transactional
public class FileUploadServiceImpl implements FileUploadService {
	@Autowired
	private FileUploadDao fileUploadDao;
	public void save(UploadFile uploadFile) {
		// TODO Auto-generated method stub
	 fileUploadDao.save(uploadFile);
	}
	

}
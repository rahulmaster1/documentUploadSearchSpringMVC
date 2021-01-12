package com.mypack.doa;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.CreateKeySecondPass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.mypack.model.UploadFile;
@Repository("FileUploadDao")
public class FileUploadDaoImpl   implements FileUploadDao {
	@Autowired		
	private SessionFactory sessionFactory;
	
		
	public FileUploadDaoImpl() {
		
		// TODO Auto-generated constructor stub
	}


	public FileUploadDaoImpl(SessionFactory sessionFactory) {
	
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void save(UploadFile uploadFile) {
	
		sessionFactory.getCurrentSession().persist(uploadFile);

	}

	@Transactional
	public UploadFile getDocument(int file_id) {
		Session session=sessionFactory.getCurrentSession();
		
		return (UploadFile)session.get(UploadFile.class, file_id);
	}

	
	

	}
	 

	




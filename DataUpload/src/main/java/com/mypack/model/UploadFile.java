package com.mypack.model;

import java.util.Arrays;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Hibernate;

import com.mysql.jdbc.Blob;


@Entity(name="UploadFile")
@Table(name="Data_Upload")
public class UploadFile {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id", unique=true, nullable=false)
		
		private int id;
		
		private  String name;
		private String email;
		private String mobile;
		private int age;
		
		@Column(name="File_Name")
		
	    private String fileName;
	
		
		@Lob @Basic(fetch=FetchType.LAZY)
		@Column(name="File_Data" )
		
	    private byte[] data;
		
		@ManyToOne(fetch=FetchType.LAZY, targetEntity=Login.class)
		@JoinColumn(name="registerid",insertable=false, updatable=false)
		
		private Login login;

		public long getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

	


		public byte[] getData() {
			return data;
		}

		public void setData(byte[] data) {
			this.data = data;
		}

		public Login getLogin() {
			return login;
		}

		public void setLogin(Login login) {
			this.login = login;
		}
		


		
	
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

	

		
	
		

		
		
	
	
	    
	    
}

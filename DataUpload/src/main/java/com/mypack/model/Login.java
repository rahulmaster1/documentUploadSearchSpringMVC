package com.mypack.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity(name="Login")
@Table(name="Login")
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="regsisterid" , unique=true, nullable=false)
	private long registerid;
	
	@Column(name="username")
	
	private String username;
	
	@Column(name="password")
	
	private String password;

	@Column(name="name")
	
	private String name;
	
	@Column(name="email" )
	
	private String email;
	
	@Column(name ="age")
	
	private int age;
	
	@OneToMany(mappedBy="login" , cascade=CascadeType.ALL)
	
	private Set<UploadFile> uploadFiles= new HashSet<UploadFile>();
		

	
	public long getRegisterid() {
		return registerid;
	}
	public void setRegisterid(long registerid) {
		this.registerid = registerid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
		
	}
	
	public Set<UploadFile> getUploadFiles() {
		return uploadFiles;
	}
	public void setUploadFiles(Set<UploadFile> uploadFiles) {
		this.uploadFiles = uploadFiles;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + (int) (registerid ^ (registerid >>> 32));
		result = prime * result + ((uploadFiles == null) ? 0 : uploadFiles.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		if (age != other.age)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (registerid != other.registerid)
			return false;
		if (uploadFiles == null) {
			if (other.uploadFiles != null)
				return false;
		} else if (!uploadFiles.equals(other.uploadFiles))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Login [registerid=" + registerid + ", username=" + username + ", password=" + password + ", name="
				+ name + ", email=" + email + ", age=" + age + ", uploadFiles=" + uploadFiles + "]";
	}



	
	
	
	
}

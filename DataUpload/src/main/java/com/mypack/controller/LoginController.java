package com.mypack.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.hibernate.Hibernate;
import org.hibernate.type.descriptor.sql.BasicExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mypack.doa.FileUploadDao;
import com.mypack.model.Login;
import com.mypack.model.UploadFile;
import com.mypack.service.FileUploadService;
import com.mypack.service.LoginService;
import com.mysql.jdbc.Blob;
@Controller
@ComponentScan("com.mypack.service")
public class LoginController {
	String path;
	private static final String UPLOAD_DIRECTORY ="/images";
		 @Autowired
		 private LoginService loginService;
		
		@Autowired
		private FileUploadDao fileUploadDao;
		
				
		@RequestMapping(value="register" ,method=RequestMethod.GET)
		public ModelAndView ViewRegister(@ModelAttribute Login login) {
			return new ModelAndView("Register");
			
			
		}
		@RequestMapping(value="register" , method=RequestMethod.POST)
		public ModelAndView saveRegister(@ModelAttribute Login login) {
			loginService.createRegister(login);
			return new ModelAndView("loginPage");
		}
		@RequestMapping(value="loginPage" ,method=RequestMethod.GET)
		public  ModelAndView viewLogin(@ModelAttribute Login login) {
			
			
			return new ModelAndView("loginPage");
		}
		@RequestMapping(value = "loginPage", method = RequestMethod.POST)
		public String processLogin(@Valid Login login , BindingResult result, Map model) {
			
			if(result.hasErrors()) {
				return "login";
			}
			boolean userExists=loginService.checkLogin(login.getUsername(), login.getPassword());
			if(userExists) {
				model.put("login", login);
				return "home";
			}else {
				ModelAndView mav= new ModelAndView("loginPage");
				mav.addObject("result", "invalid user name and password");
				return "loginPage";
			}
			
			
		}
		/*public ModelAndView processLogin(@ModelAttribute Login login1) {
			Login log=	loginService.getUserName(login1);
			Login log1=	loginService.getUsePassword(login1);
			ModelAndView model=null;
		
			if(log==null && log1==null) {
				model= new ModelAndView("loginPage");
				model.addObject("result","invalid user name and password");
				
			}else {
				model= new ModelAndView("home");
				model.addObject("log",log.getUsername());
			}
			return 	model;	
			
			
			
		}*/
			@RequestMapping(value="/doUpload", method = RequestMethod.POST)
			public ModelAndView handleFileUploaad(HttpSession session ,HttpServletRequest request, @RequestParam CommonsMultipartFile fileUpload )throws Exception  {
				    ServletContext context	=session.getServletContext();
				    
				     path=context.getRealPath(UPLOAD_DIRECTORY);
				    String  filename=fileUpload.getOriginalFilename();
				    byte[] 	bytes=fileUpload.getBytes();
				    System.out.println(path+""+filename);
				    String name=request.getParameter("name");
				    String email=request.getParameter("email");
				    String mobile=request.getParameter("mobile");
				    
				    int age=Integer.parseInt(request.getParameter("age"));
				    System.out.println(age);
				    UploadFile  uploadFile=new UploadFile();
				    uploadFile.setName(name);
				    uploadFile.setEmail(email);
				    uploadFile.setMobile(mobile);
				    uploadFile.setAge(age);
				    uploadFile.setFileName(filename);
				    uploadFile.setData(bytes);
				    		fileUploadDao.save(uploadFile);
				    		
				    
				    
				    
				    		
			   
				
				return  new ModelAndView("home","fileSucess","File Successfully  Saved");
			}
			@RequestMapping(value="/search")
			public void SearchData(@RequestParam("searchText") String searchText , HttpServletResponse response, Model model) throws SQLException, IOException {
				
				int searchid=Integer.parseInt(searchText);
				
			
				UploadFile uploadFile=fileUploadDao.getDocument(searchid);
				if(searchid==uploadFile.getId()) {
				
				System.out.println(uploadFile.getFileName().toString());
			
				OutputStream out= response.getOutputStream();
				/*
				//response.setHeader("Content-Disposition", "inline;filename=\"" +uploadFile.getFileName()+ "\"");
				response.addHeader("Content-Disposition", "attachment; filename="+uploadFile.getFileName());
				response.setContentType("pdf/application");
				OutputStream out = response.getOutputStream();
				
				//IOUtils.copy(uploadFile.getData().getBinaryStream(), out);
				
				
				Path p = Paths.get(path, Arrays.toString(uploadFile.getData()));
				
				if (Files.exists(p)) 
		        {
		            response.setContentType("application/pdf");
		            response.addHeader("Content-Disposition", "attachment; filename="+uploadFile.getFileName());
		            try
		            {
		                Files.copy(p, response.getOutputStream());
		                response.getOutputStream().flush();
		            } 
		            catch (IOException ex) {
		                ex.printStackTrace();
		            }
		        }
				
				}catch(Exception e) {
					e.printStackTrace();
				}
				*/
				/*byte[] file=uploadFile.getData();
				response.setContentType("application/pdf");
	            response.addHeader("Content-Disposition", "attachment; filename="+uploadFile.getFileName());
				InputStream is= new ByteArrayInputStream(file);
				org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());*/
				
				//response.setContentType("application/pdf");
				
		        response.setContentLength(uploadFile.getData().length);
		        response.setHeader("Content-Disposition","attachment; filename=\"" + uploadFile.getFileName() +"\"");
		        FileCopyUtils.copy(uploadFile.getData(), out);
		        System.out.println(uploadFile.getData().toString());
		        model.addAttribute("data",uploadFile.getData());
		        out.flush();
		        out.close();
				
				}else {
					model.addAttribute("result", "Not found");
				}
		       // response.flushBuffer();
			//	return new ModelAndView("home","msg",uploadFile);
			
				
			
			
			
		
 }}

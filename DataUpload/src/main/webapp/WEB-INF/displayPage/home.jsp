<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
     "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<title>Home</title>
</head>
<body>
<div class="container-fluid">
<div class="row">
    <div class="col-sm-8">
        <h1>Upload Document</h1>
        <form method="post" action="doUpload" enctype="multipart/form-data">
            <table border="0">
          <tr>
          <td>
          Name : <input type="text" name="name"/> <br><br>  

          </td>
          </tr>
           <tr>
          <td>
          Email : <input type="text" name="email"/> <br><br>  

          </td>
          </tr>
           <tr>
          <td>
          Mobile : <input type="text" name="mobile"/> <br><br>  

          </td>
          </tr>
           <tr>
          <td>
          Age : <input type="text" name="age"/> <br><br>  

          </td>
          </tr>
							
							
                <tr>
                    <td>Pick file #1:</td>
                    <td><input type="file" name="fileUpload" size="50" /></td>
                </tr>
          
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="submit" /></td>
                </tr>
                <tr>
                <td colspan="2" >${fileSucess}</td>
                
                
                </tr>
              
            </table>
    </form>
  </div> 
<div class="col-sm-4">

<table  bgcolor="aqua" >



<form:form action="search">
<tr>
<td><input type="text" name="searchText"></td>
<td><input type="submit" value="Search"></td>

</tr>



${result }

</form:form>
</table>


 </div> 
 </div>  
 </div> 
</body>
</html>
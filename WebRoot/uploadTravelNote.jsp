<%@ page language="java" import="java.util.*,java.sql.Timestamp" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'uploadTravelNote.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">

function checkPhoto(){


}


</script>
  </head>
  
  <body>
  <!--   <form action="UploadTravelNote" method="post">-->
   
    <form action="UploadTravelPhotos" method="post"  enctype="multipart/form-data">

   <input type="text" name="scenerySpotId" value="11">
   <input type="text" name="userId" value="1">
   <br>
  标题：<input type="text" name="travelNoteTitle">
  <br>
   内容：
   <br>
   <textarea name="travelNoteContent" style="width:200px;height:80px;">这里写内容</textarea>
 
    <table align="center">
     <tr>  <td>请选择要上传的照片：</td> 
      <td><input type="file"id="p"name="file1"size="20"/></td>
       </tr>  
       <tr align="center">  
       <td align="center"colspan="2"> 
        <input type="text"name="photo"value="123"/> 
         <input type="submit"value="上传"/> 
         </td> 
         </tr> 
         </table> 
    
  </form>  
  </body>
</html>

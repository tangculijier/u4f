<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
   <a href="GetAroundServlet?latitude=34.2494&longtitude=108.9934"><h3>��ȡ��������</h3></a>
   <br>
   
   <a href="GetTravelNote?scenerySpotId=11">��ȡ�þ�����Ϣ</a>
   <br>
   
   <a href="uploadTravelNote.jsp">�ϴ��μ�</a>
   
   <a href="FindFacility?scenerySpotId=11&facilityType=1">����facility</a>
   
  </body>
</html>

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
   <a href="GetAroundServlet?latitude=34.2494&longtitude=108.9934&date=2016-02-29">Ĭ�ϲ���latitude=34.2494&longtitude=108.9934&date=2016-02-29����ȡ��������</a>
   <br>
   
   <a href="GetTravelNote?scenerySpotId=13">��ȡ�þ�����Ϣ</a>
   <br>
   
   <a href="uploadTravelNote.jsp">�ϴ��μ�</a>
   <br>
   
   <a href="FindFacility?scenerySpotId=11&facilityType=1">Ĭ�ϲ���ΪscenerySpotId=11&facilityType=1������facility</a>
   
   <br>
   <a href="GetAllSceneryByScenerySpotId?scenerySpotId=13">Ĭ�ϲ���ΪscenerySpotId=13������ĳ���������о���</a>
   <br>
   <a href="SignIn.jsp">����ǩ��</a>
   
   
    <br>
   <a href="GetMySignedScenerySpot?userId=2">Ĭ�ϲ���ΪuserId=2���õ��û�ǩ���������о���</a>
   <br>
   
    <a href="GetMySignedScenery?userId=2&scenerySpotId=13">Ĭ�ϲ���ΪuserId=2&scenerySpotId=13���õ��û�ǩ����ĳ�����ڵ�����С����</a>
   <br>
   
   
     <a href="GetPathCluster?parkId=13">Ĭ�ϲ���ΪparkId=13 �õ�ĳ�����ڵľ���·��</a>
   <br>
  </body>
</html>

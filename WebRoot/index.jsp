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
   <a href="GetAroundServlet?latitude=34.2494&longtitude=108.9934&date=2016-02-29">默认参数latitude=34.2494&longtitude=108.9934&date=2016-02-29，获取附近景点</a>
   <br>
   
   <a href="GetTravelNote?scenerySpotId=13">获取该景点信息</a>
   <br>
   
   <a href="uploadTravelNote.jsp">上传游记</a>
   <br>
   
   <a href="FindFacility?scenerySpotId=11&facilityType=1">默认参数为scenerySpotId=11&facilityType=1，查找facility</a>
   
   <br>
   <a href="GetAllSceneryByScenerySpotId?scenerySpotId=13">默认参数为scenerySpotId=13，查找某景区内所有景点</a>
   <br>
   <a href="SignIn.jsp">测试签到</a>
   
   
    <br>
   <a href="GetMySignedScenerySpot?userId=2">默认参数为userId=2，得到用户签到过的所有景区</a>
   <br>
   
    <a href="GetMySignedScenery?userId=2&scenerySpotId=13">默认参数为userId=2&scenerySpotId=13，得到用户签到过某景区内的所有小景点</a>
   <br>
   
   
     <a href="GetPathCluster?parkId=13">默认参数为parkId=13 得到某景区内的聚类路径</a>
   <br>
  </body>
</html>

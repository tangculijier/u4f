<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'iframe.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	
<link rel="stylesheet" href="css/bootstrap.css" type="text/css"></link>
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
  <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
  <script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/respond.min.js"></script>
  </head>

  
  <body>
  <div class="span12">
	<h4>主题公园管理</h4></br>
	<img alt="" src="img/home.png" style="margin:0 0 20 -10">

	<p >基于案例的推理（CBR）是一种基于经验知识进行推理的人工智能技术，它是用案例来表达知识，并通过访问</br></br>
	案例库中同类案例的解决方案，从而获得当前问题的解决方法。</br></br>
我们的案例内容包括连铸生产过程中生产某一特定型号钢板时的产品信息、工艺参数与生产结果等。</br></br>
典型的CBR问题求解过程基本步骤为：案例检索、案例重用、案例修改、案例存储</br></br>
</p>
	</div>
	
	
  </body>
</html>

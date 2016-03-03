<%@page import="com.u4f.dao.DBTools"%>
<%@ page language="java" import="java.util.*,com.u4f.model.*,com.u4f.dao.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>主题公园后台管理系统</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/menu.js"></script>
</head>

<body>
<div class="top"></div>
<div id="header">
	<div class="logo">主题公园后台管理系统</div>
	<div class="navigation">
		<ul>
		 	<li>欢迎您！</li>
			<li><a href="">侯瑞</a></li>
			<li><a href="">修改密码</a></li>
			<li><a href="">设置</a></li>
			<li><a href="">退出</a></li>
		</ul>
	</div>
</div>
<div id="content">
	<div class="left_menu">
				<ul id="nav_dot">
      <li>
          <h4 class="M1"><span></span>公园管理</h4>
          <div class="list-item none">
            <a href=''>公园信息</a>
            <a href=''>便利设施</a>
            <a href=''>游乐项目</a>
          </div>
        </li>
        <li>
          <h4 class="M10"><span></span>用户管理</h4>
          <div class="list-item none">
            <a href=''>查看所有用户</a>
            <a href=''>查看用户足迹图</a>
            <a href=''>黑名单</a>
           </div>
        </li>
        <li>
          <h4 class="M9"><span></span>游记管理</h4>
          <div class="list-item none">
            <a href=''>查看所有游记</a>
          </div>
        </li>
				<li>
          <h4 class="M5"><span></span>路线管理</h4>
          <div class="list-item none">
            <a href=''>查看热门路线</a>
            <a href=''>查看已规划路线</a>
          </div>
        </li>
				
  </ul>
		</div>
		<div class="m-right">
			<div class="right-nav">
					<ul>
							<li><img src="images/home.png"></li>
								<li style="margin-left:25px;">您当前的位置：</li>
								<li><a href="#">主题公园管理</a></li>
								<li>></li>
								<li><a href="#">公园信息</a></li>
						</ul>
			</div>
			<div class="main">
				<table align="center" border="1" cellpadding="15px" style="margin-top: 50">
				<th></th>
				<th><a href=''>编号</a></th>
				<th>区域 
				<select><option >全国</option></select></th>
				<th>主题公园名称</th>
				<%
					ParkDao dao = new ParkDao();
					double lat = 34.2494d;
					double lng = 108.9934d;
					List<Park>  listPark = dao.getNearScenerySpotDao(lat,lng,"2016-03-03");
					for(int i =0;i<listPark.size();i++)
					{
						Park p = listPark.get(i);
						%>
						<tr>
						<td><img width="130px" src="<%="../"+p.getParkPicture()%>"/></td>
						<td><%=(i+1)%></td>
						<td><%=p.getParkName().substring(0,2)%></td>
						<td><%=p.getParkName()%></td>
						<td><input type="button" value="查看"/></td></tr>
						<% 
						System.out.print(p.getParkName().substring(0,2));
						System.out.print(p.getParkName()+" ");
						System.out.println(p.getParkPicture()+" ");
					}
					
				 %>
				
				</table>
			</div>
		</div>
</div>
<div class="bottom"></div>
<div id="footer"><p>Copyright©  2016 西安交通大学软件学院 版权所有</p></div>
<script>navList(12);</script>
</body>
</html>

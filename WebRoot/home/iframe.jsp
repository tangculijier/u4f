<%@ page language="java" import="java.util.*,com.u4f.model.*,com.u4f.dao.*" pageEncoding="utf-8"%>
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
	
  </head>

  
  <body>
  <div  class="main">
	<table   align="center" border="1 solid"  cellpadding="15px" style="margin-top: 50;">
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
						<td><img width="130px" src="<%="./"+p.getParkPicture()%>"/></td>
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
	
	
  </body>
</html>

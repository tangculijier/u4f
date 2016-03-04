<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查看已规划路径</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<style type="text/css">
		body, html{width: 100%;height: 100%;margin:0;font-family:"微软雅黑";}
		#allmap{height:500px;width:100%;}
		#r-result{width:100%;}
	</style>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=a4ojsRTaOU6mfwtZyqcvk4ho"></script>
	<title>添加/删除覆盖物</title>
  </head>
  
  <body>
   <div id="allmap"></div>
   	<div id="r-result" style="margin-left: 50px;margin-top: 50px">
   	用户请求偏好：</br>
   	<div  style="margin-left: 100px;">
   	用户Id:15</br>
   	主题公园Id:13</br>
	开始时间:13:20:31</br>
	游玩时间:8*60 mins</br>
	游玩类型...</br>
	请求时间:2015-12-12 10:11:31</br>
	</br>
	</div>
	规划结果:</br>
		<div  style="margin-left: 100px;">
	用户评分:☆☆☆</br>
	规划时间:2015-12-12 10:12:31</br>
	推荐路径:入口-欢乐转马-旋转飞椅-天地双雄-大摆锤-加勒比风暴-天地旋转-加勒比公园-雪域飞龙-
	神树天梯 -渔猎漂流-蝴蝶花园-</br>观鸟园-转转杯-小观光轮-墨西哥大草帽-泡球大战-kaka汽车
	-星际飞翔-海底探险-x战车-熊猫侠-云霄飞车-金沙探险-入口
	</br>
	用户评分:☆☆☆</br>
	规划时间:2015-12-12 10:11:35</br>
	</div>
	</div>
  </body>
</html>
<script type="text/javascript">
	// 百度地图API功能
	var map = new BMap.Map("allmap");
	var point = new BMap.Point(104.041179, 30.72728);
	map.centerAndZoom(point, 18);//缩放为18级
	map.enableScrollWheelZoom(true);//可以滚轮放大缩小
	
	var marker1 = new BMap.Marker(new BMap.Point(104.041097, 30.726739)); // 创建点
	
	var polyline = new BMap.Polyline([
		new BMap.Point(104.041097, 30.726739),//入口
		new BMap.Point(104.042498, 30.727733),//欢乐转马
		new BMap.Point(104.042794, 30.728062),//旋转飞椅
		new BMap.Point(104.041937, 30.728253),//天地双雄
		new BMap.Point(104.042802, 30.728659),//大摆锤
		new BMap.Point(104.041892, 30.729417),//加勒风暴
		new BMap.Point(104.041249, 30.729351),//天地旋转	
		new BMap.Point(104.042026, 30.730538),//加勒比公园
		new BMap.Point(104.040652, 30.731659),//飞龙
		new BMap.Point(104.040239, 30.731997),//神树
		new BMap.Point(104.039592, 30.731299),//渔猎
		new BMap.Point(104.039677, 30.729828),//蝴蝶花园
		new BMap.Point(104.040037, 30.729471),//观鸟园
		new BMap.Point(104.039358, 30.728687),//转转杯
		new BMap.Point(104.039484, 30.728462),//小观光轮
		new BMap.Point(104.039278, 30.728245),//大草帽
		new BMap.Point(104.038348, 30.728994),//泡球
		new BMap.Point(104.037225, 30.728986),//kaka汽车
		new BMap.Point(104.037194, 30.728726),//星际飞翔
		new BMap.Point(104.037297, 30.728423),//海底探险
		new BMap.Point(104.037328, 30.72802),//x战车
		new BMap.Point(104.037189, 30.727151),//熊猫侠
		new BMap.Point(104.038954, 30.727372),//云霄飞车
		new BMap.Point(104.039628, 30.72736),//金沙探险
		new BMap.Point(104.041097, 30.726739)//入口
	], {strokeColor:"red", strokeWeight:3, strokeOpacity:1});   //创建折线
	
	//var circle = new BMap.Circle(point,500,{strokeColor:"blue", strokeWeight:2, strokeOpacity:0.5}); //创建圆
	
	map.addOverlay(polyline);    
	
</script>
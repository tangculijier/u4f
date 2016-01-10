   package com.u4f.tools;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
	
	
	public class MapDistance{ 
	        
	    private static double EARTH_RADIUS = 6378.137; 
	    
	    private static double rad(double d) { 
	        return d * Math.PI / 180.0; 
	    }
	      
	   //根据两个位置的经纬度，来计算两地之间的距离（km）
	    
	    public static String getDistance(String lat1Str, String lng1Str, String lat2Str, String lng2Str) {
	        Double lat1 = Double.parseDouble(lat1Str);
	        Double lng1 = Double.parseDouble(lng1Str);
	        Double lat2 = Double.parseDouble(lat2Str);
	        Double lng2 = Double.parseDouble(lng2Str);
	          
	        double radLat1 = rad(lat1);
	        double radLat2 = rad(lat2);
	        double difference = radLat1 - radLat2;
	        double mdifference = rad(lng1) - rad(lng2);
	        double distance = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(difference / 2), 2)
	                + Math.cos(radLat1) * Math.cos(radLat2)
	                * Math.pow(Math.sin(mdifference / 2), 2)));
	        distance = distance * EARTH_RADIUS;
	        //distance = Math.round(distance * 10000) / 1000;
	        String distanceStr = distance+"";
	        //distanceStr = distanceStr.substring(0, distanceStr.indexOf("."));
	          
	        return distanceStr;
	    }
	    /**
	     * 获取当前用户一定距离以内的经纬度值
	     * 单位米 return minLat
	     * 最小经度 minLng
	     * 最小纬度 maxLat
	     * 最大经度 maxLng
	     * 最大纬度 minLat
	     */
	    public static Map getAround(String latStr, String lngStr, String raidus) {
	        Map map = new HashMap();
	          
	        Double latitude = Double.parseDouble(latStr);// 传值给经度
	        Double longitude = Double.parseDouble(lngStr);// 传值给纬度
	  
	        Double degree = (24901 * 1609) / 360.0; // 获取每度
	        double raidusMile = Double.parseDouble(raidus);
	          
	        Double mpdLng = Double.parseDouble((degree * Math.cos(latitude * (Math.PI / 180))+"").replace("-", ""));
	        Double dpmLng = 1 / mpdLng;
	        Double radiusLng = dpmLng * raidusMile;
	       
//	        Double minLat = longitude - radiusLng;
//	        
//	        Double maxLat = longitude + radiusLng;
//	          
//	        Double dpmLat = 1 / degree;
//	        Double radiusLat = dpmLat * raidusMile;
//	       
//	        Double minLng = latitude - radiusLat;
//	       
//	        Double maxLng = latitude + radiusLat;
	        
	        
	        Double minLat = latitude - radiusLng;
	        
	        Double maxLat = latitude + radiusLng;
	          
	        Double dpmLat = 1 / degree;
	        Double radiusLat = dpmLat * raidusMile;
	       
	        Double minLng = longitude - radiusLat;
	       
	        Double maxLng = longitude + radiusLat;
	        
	          
	        map.put("minLat", minLat+"");
	        map.put("maxLat", maxLat+"");
	        map.put("minLng", minLng+"");
	        map.put("maxLng", maxLng+"");
	          
	        return map;
	    }
	  
	    public static double take_effect_number(double  number){
	    	BigDecimal temp=new BigDecimal(number);
	    	return number=temp.setScale(6,BigDecimal.ROUND_HALF_UP).doubleValue();
	    }
	   
	      
	    public static Map<String, double[]> returnLLSquarePoint(double longitude,
	            double latitude, double distance) {
	        Map<String, double[]> squareMap = new HashMap<String, double[]>();
	        // 计算经度弧度,从弧度转换为角度
	        double dLongitude = 2 * (Math.asin(Math.sin(distance
	                / (2 * EARTH_RADIUS))
	                / Math.cos(Math.toRadians(latitude))));
	        dLongitude = Math.toDegrees(dLongitude);
	        // 计算纬度角度
	        double dLatitude = distance / EARTH_RADIUS;
	        dLatitude = Math.toDegrees(dLatitude);
	        // 正方形
	        double[] leftTopPoint = { latitude + dLatitude, longitude - dLongitude };
	        double[] rightTopPoint = { latitude + dLatitude, longitude + dLongitude };
	        double[] leftBottomPoint = { latitude - dLatitude,
	                longitude - dLongitude };
	        double[] rightBottomPoint = { latitude - dLatitude,
	                longitude + dLongitude };
	        squareMap.put("leftTopPoint", leftTopPoint);
	        squareMap.put("rightTopPoint", rightTopPoint);
	        squareMap.put("leftBottomPoint", leftBottomPoint);
	        squareMap.put("rightBottomPoint", rightBottomPoint);
	        return squareMap;
	    }
	  
}

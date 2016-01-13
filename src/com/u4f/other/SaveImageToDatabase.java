package com.u4f.other;
//package com.u4f.tools;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.InputStream;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//import com.u4f.tools.DBTools;
//
//
//public class SaveImageToDatabase {
//	static Connection conn=null;
//	static PreparedStatement ps=null;
//	static ResultSet rs=null;
//    
//    public static void main(String[] args)  {
//    	
//    	saveScenerySpotImg();
//    	
//    }
//    
//    public void example(){
//    	// declare FileInputStream object to store binary stream of given image.      
//        FileInputStream fis;
//     	conn = DBTools.getConn(conn);
//         String sql="insert into testimg(name, image) "
//                 + "values(?,?)";
//                   
//         try {
//            //file://localhost/Users/hourui/Downloads/%20image/IMG_4775.JPG
//         	
//             File image = new File("/Users/hourui/Downloads/IMG_4775.JPG");           
//             ps = conn.prepareStatement(sql);
//             ps.setString(1, "michael");
//        
//             fis = new FileInputStream(image);
//             ps.setBinaryStream(2, (InputStream) fis, (int) (image.length()));
//            
//             int s = ps.executeUpdate();
//             if (s > 0) {
//                 System.out.println("Uploaded successfully !");
//             } else {
//                 System.out.println("unsucessfull to upload image.");
//             }
//         }      
//         catch (Exception ex) {
//             System.out.println("Found some error : "+ ex);
//         } finally {
//        	 DBTools.close(conn, ps, rs);
//         }
//    }
//    public static void saveScenerySpotImg(){
//
//		 FileInputStream fis;
//	    	conn = DBTools.getConn(conn);
//	        String sql="insert into travelPhoto(image) values(?)";
//	    //	String sql="update ScenerySpot set ScenerySpotPicture=? where ScenerySpotId=2";
//	                  
//	        try {
//	          
//	        	
//	            File image = new File("/Users/hourui/Downloads/兴庆公园1.png");           
//	            ps = conn.prepareStatement(sql);
//	           // ps.setString(1, "michael");
//	       
//	            fis = new FileInputStream(image);
//	            ps.setBinaryStream(1, (InputStream) fis, (int) (image.length()));
//	           
//	            int s = ps.executeUpdate();
//	            if (s > 0) {
//	                System.out.println("Uploaded successfully !");
//	            } else {
//	                System.out.println("unsucessfull to upload image.");
//	            }
//	        }      
//	        catch (Exception ex) {
//	            System.out.println("Found some error : "+ ex);
//	        } finally {
//	        	DBTools.close(conn, ps, rs);
//	        }
//	    
//	}
//}

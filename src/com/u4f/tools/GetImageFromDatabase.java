package com.u4f.tools;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.u4f.tools.DBTools;


public class GetImageFromDatabase {
	static Connection conn=null;
	static PreparedStatement ps=null;
	static ResultSet rs=null;
    public static void main(String[] args) {
    	
    	
    }
    	public static void test(){
        FileOutputStream fos;
        conn = DBTools.getConn(conn);
        try {
        	
            File imageout = new File("/Users/hourui/Downloads/aaaaaaaa.JPG");
            fos=new FileOutputStream(imageout);
             
           
            ps = conn
                    .prepareStatement("select image from testimg where name=?");
            ps.setString(1, "michael");
            rs=ps.executeQuery();
            rs.next();
            Blob image_blob=rs.getBlob("image");
            InputStream is=image_blob.getBinaryStream();
             
             int ch = 0;  
                try {  
                    while((ch=is.read()) != -1){  
                        fos.write(ch);  
                    }  
                } catch (IOException e1) {  
                    e1.printStackTrace();  
                } finally{  
                               
                    fos.close();  
                    is.close();  
                }
        }
        // catch if found any exception during rum time.
        catch (Exception ex) {
            System.out.println("Found some error : " + ex);
        } finally {
           
        	 DBTools.closeConn(conn);
			 DBTools.close(rs);
			 DBTools.close(ps);
        }
    }
}
    	
//    	public static byte[] getScenerySpotImage(int id){
//    		
//    	        conn = DBTools.getConn(conn);
//    	        
//    	        try {
//    	        	
//    	            ps = conn .prepareStatement("select ScenerySpotPicture from ScenerySpot where ScenerySpotId="+id);
//    	          
//    	            rs=ps.executeQuery();
//    	         
//    	          //  Blob image_blob=rs.getBlob("ScenerySpotPicture");
//    	            InputStream in=null;
//                    
//    	              if(rs.next())
//    	              {     
//    	                  in=rs.getBinaryStream("ScenerySpotPicture"); 
//    	                  ServletOutputStream sout=response.getOutputStream();
//    	                  byte image[]=new byte[1024];
//    	                  while(in.read(image)!=-1)
//    	                  {
//    	                      sout.write(image);
//    	                  } 
//    	                  sout.flush();
//    	                   
//    	                  //sout.close();
//    	                  rs.close();
//    	                  stmt.close();
//    	                  conn.close();
//    	                  //response.sendRedirect("pleaselogin.jsp?errorMessage=1"); return;
//    	                //request.getRequestDispatcher("/site2/index.jsp").forward(request,response);
//    	              } 
//    	               
//    	         } catch (Exception e){
//    	            sout.println("图片不能显示.<br>");
//    	            sout.println("Error : " + e.toString());
//    	 
//    	        }
//    	            }
//    	        catch (Exception ex) {
//    	            System.out.println("Found some error : " + ex);
//    	        } finally {
//    	           
//    	        	 DBTools.closeConn(conn);
//    				 DBTools.close(rs);
//    				 DBTools.close(ps);
//    	        }
//    	        return buf;
//    	}
//}

package com.u4f.tools;

public class SystemUtil
{
	static final String systemVersion="Mac OS X";
	
   public static String getUploadPah(){
	   String path="";	  
	   if( isMac()){
		   path="/Users/hourui/Workspaces/MyEclipse 10/u4f/WebRoot/uploadImg/";
	   }else
		   path="E:/MyEclipse/u4f/WebRoot/uploadImg/";
	   return path;
   }
   
   public static String getMySqlPwd(){
	   String pwd="";
	   if(!isMac()){
		   pwd="hourui";
	   }
	   return pwd;
   }
   
   public static boolean isMac(){	   
	   String s=System.getProperties().getProperty("os.name");
	   if(systemVersion.equals(s)){
		   return true;
	   }
	   else return false;	   
   }
    
}

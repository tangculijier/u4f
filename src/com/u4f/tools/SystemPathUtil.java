package com.u4f.tools;

public class SystemPathUtil
{
	private static String projectName="WebRoot\\uploadImg";        //  你项目的名称
	public static void main(String[] a)
	{
		System.out.println(SystemPathUtil.getPorjectPath());
	}
	//获取当前项目的绝对路径
	  public static String getPorjectPath()
	  {
	   String nowpath;             //当前tomcat的bin目录的路径 如 D:\java\software\apache-tomcat-6.0.14\bin
	   String tempdir;
	   nowpath=System.getProperty("user.dir");
	   System.out.println("nowpath= "+nowpath);
	   tempdir=nowpath.replace("bin", "webapps");  //把bin 文件夹变到 webapps文件里面 
	   System.out.println("tempdir= "+tempdir);
	   tempdir+="\\"+projectName;  //拼成D:\java\software\apache-tomcat-6.0.14\webapps\sz_pro 
	   return tempdir;  
	  }
}

package com.u4f.tools;

public class SystemUtil
{
	private static final String systemVersion = "Mac OS X";
	private static final String MAC_MYSQL_PASSWORD = "";
	private static final String WINDOWS_MYSQL_PASSWORD = "hourui";

	public static void main(String a[])
	{
		System.out.println(getUploadPah());
	}
	public static String getUploadPah()
	{
		String path = "";
		if (isMac())
		{
			path = "/Users/hourui/Workspaces/MyEclipse 10/u4f/WebRoot/uploadImg/";
		} else
			path = "E:/MyEclipse/u4f/WebRoot/uploadImg/";
		return path;
	}

	public static boolean isMac()
	{
		String systemName = System.getProperties().getProperty("os.name");
		return systemVersion.equals(systemName);
	}
	
	public static String getMySqlPwd()
	{
		String pwd =isMac() == true ? MAC_MYSQL_PASSWORD :WINDOWS_MYSQL_PASSWORD;
		return pwd;
	}

}

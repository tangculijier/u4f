package com.u4f.other;
/*
import java.io.File;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.u4f.servlet.DiskFileUpload;
import com.u4f.servlet.EquipmentDao;
import com.u4f.servlet.FileItem;

public class UploadPic
{
	String p1=request.getParameter("file1");
	String p2=request.getParameter("travelPhoto");

	System.out.println("p1:"+p1+",p2:"+p2);
	
	String uploadPath =request.getRealPath("/")+"/images/"; 
   System.out.println("uploadPath:"+uploadPath);
   //图下临时上传路径       
   String tempPath = request.getRealPath("/")+"images/temp/"; 
   //数据库中图片网络相对路径     
   String  imagePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/"; 
   //数据库中图片网络URL    
   String imageUrl=null;     
   //文件夹不存在就自动创建：   
   if(!new File(uploadPath).isDirectory())   
	   new File(uploadPath).mkdirs(); 
   if(!new File(tempPath).isDirectory())   
	   new File(tempPath).mkdirs();   
	  
   try 
   {   
	   DiskFileUpload fu = new DiskFileUpload();            
       // 设置最大文件尺寸，这里是4MB  
       fu.setSizeMax(4194304);             
       // 设置缓冲区大小，这里是4kb   
      fu.setSizeThreshold(4096);            
       // 设置临时目录：   
      fu.setRepositoryPath(tempPath);               
      // 得到所有的文件：               
      List fileItems = fu.parseRequest(request);           
      Iterator i = fileItems.iterator();            
      // 依次处理每一个文件：  
   while(i.hasNext()) {    
	   FileItem file = (FileItem)i.next(); 
   // 获得文件名，这个文件名是用户上传时用户的绝对路径：                 
   String fileName = file.getName();                    
   //看文件以什么结束                
   //System.out.println(fileName.endsWith(".gif"));      
   if(fileName!=null&&(fileName.endsWith(".jpg")||fileName.endsWith(".gif")||fileName.endsWith(".doc"))) {                    
	   // 在这里可以记录用户和文件信息                    
	   // 生成上传后的文件名                 
	   String filename=null;                
	   Random rd = new Random();                    
	   Calendar time = Calendar.getInstance();    
	   if(fileName.endsWith(".jpg")){   
		   filename=String.valueOf(time.get(Calendar.YEAR))                     
				   + String.valueOf(time.get(Calendar.MONTH))                    
				   + String.valueOf(time.get(Calendar.DAY_OF_MONTH))                    
				   + String.valueOf(time.get(Calendar.HOUR_OF_DAY))                    
				   + String.valueOf(time.get(Calendar.MINUTE))                    
				   + String.valueOf(time.get(Calendar.SECOND))                    
				   + String.valueOf(rd.nextInt(100)) + ".jpg";   
		   }else if(fileName.endsWith(".gif")){   
			   filename=String.valueOf(time.get(Calendar.YEAR))                    
					   + String.valueOf(time.get(Calendar.MONTH))                     
					   + String.valueOf(time.get(Calendar.DAY_OF_MONTH))                    
					   + String.valueOf(time.get(Calendar.HOUR_OF_DAY))
					   +String.valueOf(time.get(Calendar.MINUTE))
					   +String.valueOf(time.get(Calendar.SECOND))
                      +String.valueOf(rd.nextInt(100))+".gif";
			    
			}else{    
				filename=String.valueOf(time.get(Calendar.YEAR))                      
						+ String.valueOf(time.get(Calendar.MONTH))                     
					   + String.valueOf(time.get(Calendar.DAY_OF_MONTH))                    
				        + String.valueOf(time.get(Calendar.HOUR_OF_DAY))                    
					  + String.valueOf(time.get(Calendar.MINUTE))                     
					  + String.valueOf(time.get(Calendar.SECOND))                    
					 + String.valueOf(rd.nextInt(100)) + ".doc";                
					   }                 
			File f1=new File(uploadPath+filename);                
					   //打印相对路径   
					   EquipmentDao equipmentdao=new EquipmentDao();                 
					   String url=f1.getAbsolutePath();  
					   equipmentdao.updateEquipmentByID(1002, url);   
					   System.out.print(f1.getAbsolutePath());                 
					   //数据库中存储图片路径为:  http://127.0.0.1:8080/MailSend/upload/images/1.jpg   
					   imageUrl=imagePath+"uploadPath"+"随机生成文件名";              
					   //  System.out.println(imageUrl);                 
					   //将路径写入到数据库   
					   file.write(f1);    
					   out.print("图片上传成功!");                     
					   System.out.println(fileName+"成功上传！");   
					   }else
					   {    
						   out.println("上传文件出错，只能上传 *.jpg , *.gif , *.doc");               
						   }           
   }             // 跳转到上传成功提示页面        
   }    catch(Exception e) {             
	   // 可以跳转出错页面       
   
			   }
}
*/

package com.u4f.spider;
import java.io.File;
import java.io.IOException;  
import java.sql.SQLException;

import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;  
import org.jsoup.nodes.Element;  
import org.jsoup.select.Elements;

import com.u4f.dao.DBTools;

public class HTMLParser{  
   
    public static void main(String args[]) throws IOException, SQLException {  
   
    	 File input = new File("D:/a.html"); 

    	 Document doc = Jsoup.parse(input, "UTF-8", "http://www.mafengwo.cn/poi/5820.html"); 





    	 Elements links = doc.select("p"); // 具有 href 属性的链接

    	 Elements text = doc.select("p.rev-txt");// 所有引用 png 图片的元素

    	 Elements masthead = doc.select("a.name"); //标签.类
    	 Elements logo = doc.select("img.lazyavatar"); 
    	 DBTools db = new DBTools();
    	 for(int i = 0 ;i<masthead.size();i++)
    	 {
    		 String userName = masthead.get(i).html();
    		 String travle = text.get(i).html();
    		 System.out.println(masthead.get(i).html()+" "+text.get(i).html());
        	// db.insertTravle(userName, travle);
    	 }
    	// System.out.println(times);

}  
   
}
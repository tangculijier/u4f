package com.huang;

import java.util.Scanner;

public class GetSim
{
	public static void main(String[] args) {
       float len= getLCString("12fa34","1234");
        System.out.println(len);
        
        
    }
    
	public static float getLCString(String str1, String str2) {
	String str="";
	//String longStr=str1.length()>str2.length()?str1:str2;
	String longStr="";
	String shortStr="";
	if(str1.length()>str2.length()){
		longStr=str1;
		shortStr=str2;
	}else{
		
		longStr=str2;
		shortStr=str1;
	}
	
	for(int i=0;i<shortStr.length();i++){
	String s=shortStr.charAt(i)+"";
	
	if(longStr.contains(s)){
		str+=s;
	}	
	}
	
	System.out.println(str.length());
	
	float res=(float)str.length()/(float)longStr.length();
	return res;
	
	}
	
	
	
}

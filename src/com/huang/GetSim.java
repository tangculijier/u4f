package com.huang;

import java.util.Scanner;

public class GetSim
{
	public static void main(String[] args)
	{
		float len = samePathPercent("7", "23456");
		System.out.println(len);

	}

	private static int compute(char[] str1, char[] str2)
	{
		int substringLength1 = str1.length;
		int substringLength2 = str2.length;

		// 构造二维数组记录子问题A[i]和B[j]的LCS的长度
		int[][] opt = new int[substringLength1 + 1][substringLength2 + 1];

		// 从后向前，动态规划计算所有子问题。也可从前到后。
		for (int i = substringLength1 - 1; i >= 0; i--)
		{
			for (int j = substringLength2 - 1; j >= 0; j--)
			{
				if (str1[i] == str2[j])
					opt[i][j] = opt[i + 1][j + 1] + 1;// 状态转移方程
				else
					opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]);// 状态转移方程
			}
		}
		 System.out.println("substring1:" + new String(str1));
		 System.out.println("substring2:" + new String(str2));
		// System.out.print("LCS:");

		int i = 0, j = 0;
		while (i < substringLength1 && j < substringLength2)
		{
			if (str1[i] == str2[j])
			{
				// System.out.print(str1[i]);
				i++;
				j++;
			} else if (opt[i + 1][j] >= opt[i][j + 1])
				i++;
			else
				j++;
		}
		return opt[0][0];
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
		
		//System.out.println(str.length());
		
		float res=(float)str.length()/(float)longStr.length();
		return res;
		
		}
		
	public static float samePathPercent(String str1, String str2)
	{
//		int maxLength = str1.length() > str2.length() ? str1.length() : str2.length();
//		int same = compute(str1.toCharArray(), str2.toCharArray());
//		 System.out.println("same="+same +" maxLength="+maxLength);
//		return  (float) MyMath.divide(same, maxLength);
		return getLCString(str1,str2);
	}

}

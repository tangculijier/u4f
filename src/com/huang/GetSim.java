package com.huang;

import java.util.Scanner;

public class GetSim
{
	public static void main(String[] args)
	{
//		float len = samePathPercent("abcdfhjkeilmy", "opquvrtcdwxilzn");
//		System.out.println("青春-合家欢"+len);
//		float len1 = samePathPercent("abcdfhjkeilmy", "prsbcdfhklzym");
//		System.out.println("青春-情侣"+len1);
//		float len3 = samePathPercent("abcdfhjkeilmy", "oquvrstcwxln");
//		System.out.println("青春-合家欢"+len3);
		

		//String[] path1 = {"bcdefg","hijkqg","xlmopg","hijdefg","bcdjkqg","lxmondefg","hijdefgpomxl","lxmondjih","bcdjnopg","bcdefgpomxl"};
		//String[] path2 = {"bcdjkqg","hijkqg","lxmondefg","hijdefg","bcdefg","xlmopg","hijdefgpomxl","lxmondjih","bcdjnopg","bcdefgpomxl"};
		String[] test = {"lxmondefg","xlmopg","hijdefgpomxl","lxmondjih","bcdefgpomxl"};
		printSimMaxtri(test);
	
		
	}

	public static void printSimMaxtri(String[] paths)
	{
		System.out.println("相似度矩阵");
		System.out.print("    ");
		for(int i = 0 ; i < paths.length;i++)
		{
			System.out.print("\t"+paths[i]);
		}
		System.out.println("");
		for(int i = 0 ; i < paths.length;i++)
		{
			System.out.print(paths[i]);
			float sum = 0f;
			for(int j = 0;j < paths.length;j++)
			{
				float sim = samePathPercent(paths[i], paths[j]);
				sum = (float) MyMath.add(sum, sim);
				System.out.print("\t"+sim);
			}
			System.out.print("  sum="+sum);
			System.out.println();

		}
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

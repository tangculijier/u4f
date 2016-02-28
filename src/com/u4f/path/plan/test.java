package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class test
{

	public static Set<String> set ;
	public static void main(String[] args)
	{
		String[] v = {"A","B","C","D","E"};
		//Project[] project =  {new Project("A", 30),"B","C","D","E"};
		int[][] matrix = new int[5][5];
		matrix[0][1]=1;
		matrix[0][2]=1;
		matrix[0][3]=1;
		matrix[0][4]=1;
		
		matrix[1][0]=1;
		matrix[1][2]=1;
		matrix[1][3]=1;	
		
		matrix[2][0]=1;
		matrix[2][1]=1;
		matrix[2][3]=1;
		matrix[2][4]=1;
		
		matrix[3][0]=1;
		matrix[3][1]=1;
		matrix[3][2]=1;
		
		matrix[4][0]=1;
		matrix[4][2]=1;
		
		System.out.print("   ");
		for(String s:v)
		{
			System.out.print(s+" ");
		}
		System.out.println(" ");
		for(int i = 0;i<matrix.length;i++)
		{	
			System.out.print(v[i]+" ");
			
			for(int j =0 ;j<matrix[i].length;j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println(" ");
		}
		
		test test = new test();
		set = new HashSet<String>();
		List<Path> pathList = new ArrayList<Path>();
		test.addNext("A",matrix);
		for (String str : set) 
		{
			int sum = 0;
			for(int i =0 ;i <str.length();i++)
			{
				char ch = str.charAt(i);
				switch(ch)
				{
					case 'A':
						sum+=50;
						break;
					case 'B':
						sum+=100;
						break;
					case 'C':
						sum+=20;
						break;
					case 'D':
						sum+=30;
						break;
					case 'E':
						sum+=30;
						break;
				}
				
			}
			pathList.add(new Path(str, sum));
		     // System.out.println(str+" score="+sum);
		}
		Collections.sort(pathList,new Comparator<Path>()
		{

			@Override
			public int compare(Path p1, Path p2) 
			{
				int p1Score = p1.sumScore;
				int p2score = p2.sumScore;
				
				return p1Score > p2score ? -1 : 1;
			}
		});

		for (Path p :pathList)
		{  
			 System.out.println("path = " + p.path + ", score = " + p.sumScore);  

		}

		

	}
	
	public  void addNext(String path,int[][] matrix)
	{
		String[] v = {"A","B","C","D","E"};
		String startPath = new String(path);
		int begin = getIndex(path.charAt(path.length()-1)+"");	
			for(int j = 0 ;j<matrix[begin].length;j++)
			{
				if(matrix[begin][j] == 1 )
				{
					if( v[j].equals("A"))//zuihou
					{
						path += v[j];
						
						System.out.println(" path:"+path);
						set.add(path);
						path = startPath;
					//	lastPath =startPath.charAt(startPath.length()-1)+"";
						continue;
					}
					else if(path.indexOf(v[j]) == -1)
					{
						//path += v[j];
					//	lastPath =v[j]; 
						addNext(path+v[j],matrix);
					}
				}
					
			}
		
	}
	public static int getIndex(String x)
	{
		int index = 0;
		String[] v = {"A","B","C","D","E"};
		for(int i = 0; i< v.length;i++)
		{
			if(x.equals(v[i]))
			{
				index = i;
			}
		}
		return index;
	}
}

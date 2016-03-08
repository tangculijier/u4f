package com.huang;
import java.util.ArrayList;  
import java.util.Random;  


/** 
 * k—medoids聚类算法 
 */  
 public class kmedoids{  
    private int k;// 分成多少簇  
    private int m;// 迭代次数  
    private int dataSetLength;// 数据集元素个数，即数据集的长度  
    private ArrayList<String> dataSet;// 数据集链表  
    private ArrayList<String> center;// 中心链表  
    private ArrayList<ArrayList<String>> lastCluster;// 上一次中心链表  
    private ArrayList<ArrayList<String>> cluster; // 簇  
    private ArrayList<Float> jc;// 误差平方和，k越接近dataSetLength，误差越小  
    private Random random;  
  
    /** 
     * 设置需分组的原始数据集 
     *  
     * @param dataSet2 
     */  
  
    public void setDataSet(ArrayList<String> dataSet2) {  
        this.dataSet = dataSet2;  
    }  
  
    /** 
     * 获取结果分组 
     *  
     * @return 结果集 
     */  
  
    public ArrayList<ArrayList<String>> getCluster() {  
        return cluster;  
    }  
  
    /** 
     * 构造函数，传入需要分成的簇数量 
     *  
     * @param k 
     * 簇数量,若k<=0时，设置为1，若k大于数据源的长度时，置为数据源的长度 
     */  
    public kmedoids(int k) {  
        if (k <= 0) {  
            k = 1;  
        }  
        this.k = k;  
    }  
  
    /** 
     * 初始化 
     */  
    private void init() {  
        m = 0;  
        random = new Random();  
       
        dataSetLength = dataSet.size();  
        if (k > dataSetLength) {  
            k = dataSetLength;  
        }  
        center = initCenters();  
        cluster = initCluster();  
    }  
  
  
  
    /** 
     * 初始化中心数据链表，分成多少簇就有多少个中心点 
     *  
     * @return 中心点集 
     */  
    private ArrayList<String> initCenters() {  
        ArrayList<String> center = new ArrayList<String>();
      
        
        int[] randoms = new int[k];  
        boolean flag;  
        int temp = random.nextInt(dataSetLength);  
        randoms[0] = temp;  
        for (int i = 1; i < k; i++) 
        {  
            flag = true;  
            while (flag) 
            {  
                temp = random.nextInt(dataSetLength);  
                int j = 0;  
               //  不清楚for循环导致j无法加1  
                 for(j=0;j<i;++j)  
                 {  
                 if(temp==randoms[j]);  
                 {  
                 break;  
                 }  
                 }  
                while (j < i) {  
                    if (temp == randoms[j]) 
                    {  
                        break;  
                    }  
                    j++;  
                }  
                if (j == i) 
                {  
                    flag = false;  
                }  
            }  
            randoms[i] = temp;  
        }  
  
        // 测试随机数生成情况  
         for(int i=0;i<k;i++)  
         {  
         System.out.println("test1:randoms["+i+"]="+randoms[i]);  
         }  
  
        printDataArray(center,"newCenter");  
        center.add(dataSet.get(randoms[0]));
        center.add(dataSet.get(randoms[1]));
        center.add(dataSet.get(randoms[2]));
        return center;  
    }  
  
    /** 
     * 初始化簇集合 
     *  
     * @return 一个分为k簇的空数据的簇集合 
     */  
    private ArrayList<ArrayList<String>> initCluster() {  
        ArrayList<ArrayList<String>> cluster = new ArrayList<ArrayList<String>>();
        if(m == 0 )
        lastCluster = new ArrayList<ArrayList<String>>();  
        for (int i = 0; i < k; i++) {  
            cluster.add(new ArrayList<String>());  
            if(m == 0 )
            lastCluster.add(new ArrayList<String>());  
        }  
       
        return cluster;  
    }  
  
    /** 
     * 计算两个路径间的相似度 
     *  
     * @param path1 点1 
     * @param path2 点2 
     * @return 相似度  
     */  
    private float distance(String path1, String path2) {  
        float distance = 0.0f;  
        distance=GetSimUtil.GetJaccardSimilarity(path1, path2);
        return distance;
        
    }  
    
    
    
    /** 
     * 获取距离集合中最小距离的位置 
     *  
     * @param distance 
     *         距离数组 
     * @return 最小距离在距离数组中的位置 
     */  
    private int maxSimlar(float[] distance) {  
        float maxDistance = distance[0];  
        int maxLocation = 0;  
        for (int i = 1; i < distance.length; i++) {  
            if (distance[i] > maxDistance) {  
                maxDistance = distance[i];  
                maxLocation = i;  
            } else if (distance[i] == maxDistance) // 如果相等，随机返回一个位置  
            {  
                if (random.nextInt(10) < 5) {  
                    maxLocation = i;  
                }  
            }  
        }  
  
        return maxLocation;  
    }  
  
    /** 
     * 核心，将当前元素放到最大相似度中心相关的簇中 
     */  
    private void clusterSet() {  
        float[] distance = new float[k];  
        for (int i = 0; i < dataSetLength; i++) {  
            for (int j = 0; j < k; j++) 
            {  
               // distance[j] = distance(dataSet.get(i), center.get(j));  
            	distance[j] = GetSimUtil.GetJaccardSimilarity(dataSet.get(i), center.get(j));
                // System.out.println("test2:"+"dataSet["+i+"],center["+j+"],相似度="+distance[j]);  
  
            }  
            int minLocation = maxSimlar(distance);  
            // System.out.println("test3:"+"dataSet["+i+"],应该属于第="+minLocation+"簇");  
            // System.out.println();  
  
            cluster.get(minLocation).add(dataSet.get(i));// 核心，将当前元素放到最小距离中心相关的簇中  
  
        }  
    }  
  
   
    private boolean countRule() {  
    	if(lastCluster.size() == 0 )
    	{
    		return false;
    	}
    	if(lastCluster.get(0).size() == 0 )
    	{
    		return false;
    	}
    		boolean isSame = true;
        	for(int i = 0 ;i < cluster.size() ;i++)
        	{
        		ArrayList<String> clusterItem  = cluster.get(i);
        		ArrayList<String> lastClusterItem  = lastCluster.get(i);
        		if(clusterItem.size() != lastClusterItem.size())
        		{
        			isSame = false;
    				break;
        		}
        		for(int j = 0 ; j < clusterItem.size();j++)
        		{
        			if(!lastClusterItem.get(j).equals(clusterItem.get(j)))
        			{
        				isSame = false;
        				break;
        			}
        		}
        		
        	
    	}
    	
    	return isSame;
    }  
  
    /** 
     * 设置新的簇中心方法 
     */
    private void setNewCenter() 
    {  
        for (int i = 0; i < k; i++)
        {  
            int n = cluster.get(i).size();  
            if (n != 0)
            {  
                String newCenter ="";  
                float maxSum = 0f;
                int maxIndex = 0;//和簇中其他路径相似度之和的那个路径在簇中的index
                for (int j = 0; j < n; j++) 
                {  
                	float simSum = 0f;
                	for(int m = 0; m < n; m++)//求得这个路径和簇中其他所有路径的相似度之和
                	{
                		simSum += GetSimUtil.GetJaccardSimilarity(cluster.get(i).get(j),
                		cluster.get(i).get(m));  
                	}
                	
                	if(simSum > maxSum)//和最大相似度之和比较
                	{
                		maxSum = simSum;
                		maxIndex = j;
                	}
                	
                  
                }   
                center.set(i, cluster.get(i).get(maxIndex));  
            }  
        }  
        
        printDataArray(center,"newCenter");  
        //printDataArray(lastCluster,"lastCenter");  
    }  
  
    /** 
     * 打印数据，测试用 
     *  
     * @param arrayList 
     *            数据集 
     * @param dataArrayName 
     *            数据集名称 
     */  
    public void printDataArray(ArrayList<String> arrayList,  
            String dataArrayName) {  
        for (int i = 0; i < arrayList.size(); i++) {  
            System.out.println("print:" + dataArrayName + "[" + i + "]={"  
                    + arrayList.get(i) +"}");  
        }  
        System.out.println("===================================");  
    }  
  
    /** 
     * kmedoids算法核心过程方法 
     */  
    public void kmedoids()
    {  
        init();  
        // 循环分组，直到误差不变为止  
        while (true) 
        {
        	clusterSet();
            //System.out.println();  
           // 分组簇类不再变化时  
            if (m != 0) //m = 0为第一次迭代
            {  
            	boolean isBreak = countRule();  
            	for(int i=0;i<cluster.size();i++) 
       	        {  
       	        	printDataArray(cluster.get(i),"cluster["+i+"]");  
       	        }  
            	if(isBreak == true)
            	{
            		System.out.println("列表不变了");
            		break;  
            	}
                   
            }  
            setNewCenter(); //设置新的质心
            m++;  //迭代次数+1
            for(int i  = 0 ; i < cluster.size();i++)
        	{
            	ArrayList<String> itme =cluster.get(i);
        		lastCluster.set(i, itme);
        	}
            cluster.clear();  
            cluster = initCluster();  
        }  
  
         System.out.println("note:the times of repeat:m="+m);//输出迭代次数  
    }
  
}  




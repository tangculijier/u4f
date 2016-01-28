package com.huang;

import java.util.ArrayList;


public class KmeansTest {  
    public  static void main(String[] args)  
    {  
        //初始化一个Kmean对象，将k置为10  
        Kmeans k=new Kmeans(3);  
        ArrayList<String> dataSet=new ArrayList<String>();  
          
        dataSet.add("123456");  
        dataSet.add("564312");  
        dataSet.add("56789");  
        dataSet.add("98765");  
        dataSet.add("90");  
        dataSet.add("9");  
       
        //设置原始数据集  
        k.setDataSet(dataSet);  
        //执行算法  
        k.execute();  
        //得到聚类结果  
        ArrayList<ArrayList<String>> cluster=k.getCluster();  
        //查看结果  
        for(int i=0;i<cluster.size();i++)  
        {  
        //    k.printDataArray(cluster.get(i), "cluster["+i+"]");  
        }  
          
    }  
}  

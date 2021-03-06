package com.huang;

import java.util.ArrayList;


public class KmeansTest {  
    public  static void main(String[] args)  
    {  
    	String[] paths = {"bcdefg","hijkqg","lxmopg","hijdefg","bcdjkqg","lxmondefg","hijdefgpomxl","lxmondjih","bcdjnopg","bcdefgpomxl"};    	//1 String[] paths = {"abcdefg","bodekl","opqekxyz","abcfxz","abjolx","abcefjkl","abcoph","hzlwc","behijklmn"};
		//2 String[] paths = {"bcdjkqg","hijkqg","lxmondefg","hijdefg","bcdefg","xlmopg","hijdefgpomxl","lxmondjih","bcdjnopg","bcdefgpomxl"};

        //初始化一个Kmean对象，将k置为10  
        Kmeans k=new Kmeans(3);  
        ArrayList<String> dataSet=new ArrayList<String>();  
        for(String s :paths)
        {
    	   dataSet.add(s);
        }
        //设置原始数据集  
        k.setDataSet(dataSet);  
        //执行算法  
        k.kmeans();  
        //得到聚类结果  
        ArrayList<ArrayList<String>> cluster=k.getCluster();  
        //查看结果  
        for(int i=0;i<cluster.size();i++)  
        {  
            //k.printDataArray(cluster.get(i), "cluster["+i+"]");  
        }  
          
    }  
}  

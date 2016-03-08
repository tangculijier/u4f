package com.huang;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.u4f.model.PlayPath;


public class kmedoidsController {  
    public  static void main(String[] args)  
    {  
    	String[] paths = {"bcdefg","hijkqg","lxmopg","hijdefg","bcdjkqg","lxmondefg","hijdefgpomxl","lxmondjih","bcdjnopg","bcdefgpomxl"};    	//1 String[] paths = {"abcdefg","bodekl","opqekxyz","abcfxz","abjolx","abcefjkl","abcoph","hzlwc","behijklmn"};
		//2 String[] paths = {"bcdjkqg","hijkqg","lxmondefg","hijdefg","bcdefg","xlmopg","hijdefgpomxl","lxmondjih","bcdjnopg","bcdefgpomxl"};

        //初始化一个Kmean对象，将k置为10  
        kmedoids k=new kmedoids(3);  
        ArrayList<String> dataSet=new ArrayList<String>();  
        for(String s :paths)
        {
    	   dataSet.add(s);
        }
        //设置原始数据集  
        k.setDataSet(dataSet);  
        //执行算法  
        k.kmedoids();  
        //得到聚类结果  
        ArrayList<ArrayList<String>> cluster=k.getCluster();  
        //查看结果  
        for(int i=0;i<cluster.size();i++)  
        {  
            //k.printDataArray(cluster.get(i), "cluster["+i+"]");  
        }  
          
    }  
    /*
    public boolean  clustering(int parkId)
    {
    	boolean res = false;
    	PlayDao dao = new PlayDao();
    	List<PlayPath> newAddList= PlayDao.getNewPlayPath(parkId,new Date());//得到今日新增的所有路径
    	if(newAddList > 20)//如果新增的数据超过20条则重新聚类
    	{
    		List<PlayPath> allList= PlayDao.getAllPlayPath(parkId);//得到主题公园所有路径
    		kmedoids k=new kmedoids(3);  
            ArrayList<String> dataSet=new ArrayList<String>();  
            for(PlayPath p :allList)
            {
        	   dataSet.add(p.getPathStr());//将路径加入到算法数据集中
            }
            //设置原始数据集  
            k.setDataSet(dataSet);  
            //执行算法  
            k.kmedoids();  
            //得到聚类结果  
            ArrayList<Cluster> clusterResult=k.getClusterResult();  
            //保存到数据库
            res = dao.insertCluster(clusterResult) ;
    	}
    	return res;
    	*/
    }
    
}  

package com.u4f.ant;

import java.util.Random;

/**
 * 蚂蚁类
 * @Time 2014-5-17
 * @author buyuanyuan
 */
public class Ant {
	private int[] tour; //蚂蚁的路径
	/**
	 * 存储该蚂蚁已经访问过的城市
	 */
	 private int[] city; //存储是否访问过某一城市
	 /**
		 * 蚂蚁当前走过的距离
		 */
	 private int length; //蚂蚁当前走过的距离
	 /**
		 * 城市个数
		 */
	 private int count; //城市个数
	 
	 public int[] getTour() {
		return tour;
	}

	public int getLength() {
		return length;
	}
	
	public void init(int count) {
		 this.count = count;
		 city = new int[count];
		 tour = new int[count+1];
		 for(int i=0; i<count; i++) {
			 city[i] = 0;
		 }
		// int random = 0;
		 int random = new Random(System.currentTimeMillis()).nextInt(count);
		 city[random] = 1;
		 tour[0] = random;//每一个蚂蚁初始化的时候都随机走了一个地方
	 }
	 
	 public void SelectNextCity(int index, double [][]pheromone, int[][] distance)
	 {
		 int current = tour[index-1];
		 double []p = new double[count];
		 double sum = 0.0;
	     //计算公式中的分母部分  
		 for(int i=0; i<count; i++) 
		 {
			 if(city[i] == 0)//表示还没有访问过
			 {
				 sum += pheromone[current][i]/(Math.pow(distance[current][i], 2));
			 }
		 }
		  //计算每个城市被选中的概率  
		 for(int i=0; i<count; i++) 
		 {
			 if(city[i] == 1) {//如果已经访问过 概率为0
				 p[i] = 0.0;
			 } else
			 {
				 p[i] = pheromone[current][i]/(Math.pow(distance[current][i], 2))/sum;
			 }
		 }
		 int select = getSelect(p);
		 tour[index] = select;
		 city[select] = 1;
	 }

	  //轮盘赌选择一个城市；
	private int getSelect(double[] p) {
		double selectP = new Random(System.currentTimeMillis()).nextDouble();
		double sumSel = 0.0;
		for(int i=0; i<count; i++) 
		{
			sumSel += p[i];
			if(sumSel>selectP) 
				return i; 
		}
		return -1;
	}
	 /** 
     * 计算蚂蚁获得的路径的长度 
     * @param distance  全局的距离矩阵信息 
     */  
	public void calLength(int [][]distance) {
		length = 0;
		tour[count] = tour[0];
		for(int i=0; i<count; i++) {
			length += distance[tour[i]][tour[i+1]];
		}
	}
}


package com.u4f.ant;

import java.util.Random;

/**
 * ������
 * @Time 2014-5-17
 * @author buyuanyuan
 */
public class Ant {
	private int[] tour; //���ϵ�·��
	/**
	 * �洢�������Ѿ����ʹ��ĳ���
	 */
	 private int[] city; //�洢�Ƿ���ʹ�ĳһ����
	 /**
		 * ���ϵ�ǰ�߹��ľ���
		 */
	 private int length; //���ϵ�ǰ�߹��ľ���
	 /**
		 * ���и���
		 */
	 private int count; //���и���
	 
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
		 tour[0] = random;//ÿһ�����ϳ�ʼ����ʱ���������һ���ط�
	 }
	 
	 public void SelectNextCity(int index, double [][]pheromone, int[][] distance)
	 {
		 int current = tour[index-1];
		 double []p = new double[count];
		 double sum = 0.0;
	     //���㹫ʽ�еķ�ĸ����  
		 for(int i=0; i<count; i++) 
		 {
			 if(city[i] == 0)//��ʾ��û�з��ʹ�
			 {
				 sum += pheromone[current][i]/(Math.pow(distance[current][i], 2));
			 }
		 }
		  //����ÿ�����б�ѡ�еĸ���  
		 for(int i=0; i<count; i++) 
		 {
			 if(city[i] == 1) {//����Ѿ����ʹ� ����Ϊ0
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

	  //���̶�ѡ��һ�����У�
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
     * �������ϻ�õ�·���ĳ��� 
     * @param distance  ȫ�ֵľ��������Ϣ 
     */  
	public void calLength(int [][]distance) {
		length = 0;
		tour[count] = tour[0];
		for(int i=0; i<count; i++) {
			length += distance[tour[i]][tour[i+1]];
		}
	}
}


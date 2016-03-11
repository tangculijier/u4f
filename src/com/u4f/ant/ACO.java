package com.u4f.ant;

import java.util.List;

import com.u4f.model.Project;


/**
 * ��Ⱥ�Ż��㷨���������TSP����
 * @Time 2016-1-17

 */
public class ACO {
	Ant []ants;
	int antCount;
	int [][]distance;
	/**
	 * ���г���֮�����Ϣ�ؾ���
	 */
	double [][]pheromone;
	
	int cityCount;
	/**
	 * ���·��
	 */
	int []bestTour;
	/**
	 * ����
	 */
	List<Project> city;
	/**
	 * ���·��
	 */
	int bestLength;
	
	public void init(int antCount,Citys citys) {
		this.antCount = antCount;
		ants = new Ant[antCount];
		//Citys citys = new Citys();
		citys.initDis();
		distance = citys.getDistance();
		city = citys.getProjects();
		cityCount = city.size();
		pheromone = new double[cityCount][cityCount];
		for(int i=0; i<cityCount; i++) {
			for(int j=0; j<cityCount; j++) {
				pheromone[i][j] = 0.1;
			}
		}
		bestLength = Integer.MAX_VALUE;
		bestTour = new int[cityCount+1];
		for(int i=0;i<antCount;i++){  
            ants[i] = new Ant();  
            ants[i].init(cityCount);  
        }
	}
	
	 public void run(int maxgen){
		 for(int gen=0; gen<maxgen; gen++) 
		 {
			 //ÿһֻ�����ƶ��Ĺ���  
			 for(int i=0; i<antCount; i++)//ѭ����������
			 {
				 for(int j=1;j<cityCount;j++)//ÿ������ѭ�����г���
				 {
					 ants[i].SelectNextCity(j, pheromone, distance);
				 }
				 //�������ϻ�õ�·������  
				 ants[i].calLength(distance);
				 //��������·��  
				 if(ants[i].getLength() < bestLength) 
				 {
					 bestLength = ants[i].getLength();
					 System.out.println("��" + gen + "���������µĽ�Ϊ��"+bestLength);
					 for(int j=0; j<cityCount+1; j++)
					 {
						 bestTour[j] = ants[i].getTour()[j];
						 System.out.print(city.get(bestTour[j]).getProjectName() + " ");
					 }
					 System.out.println();
				 }
			 }
			//������Ϣ�ؾ���  
			 update();
			//���������������  
			 for(int i=0;i<antCount;i++) 
			 {
				 ants[i].init(cityCount);
			 }
		 }
	 }

	private void update()
	{
		double r = 0.5;
		 //��Ϣ�ػӷ�  
		for(int i=0; i<cityCount; i++) 
		{ 
            for(int j=0;j<cityCount;j++)
            {
            	pheromone[i][j] *= (1-r);
            }
		}
		
		 //��Ϣ�ظ���  
		for(int i=0; i<antCount; i++)
		{  
            for(int j=0; j<cityCount; j++) 
            {  
            	pheromone[ants[i].getTour()[j]][ants[i].getTour()[j+1]] += 1.0/ants[i].getLength();  
            }  
        }  
	}
	
	public void ReportResult(){  
        System.out.println("����·��������"+bestLength);
        for(int j=0; j<cityCount+1; j++) {
        	System.out.print(city.get(bestTour[j]).getProjectName() + " ");

        }
    }
	
	
	public void run(int antNumber,int maxgen,Citys citys)
	{
		this.init(antNumber,citys);  
        this.run(maxgen);  
        this.ReportResult();  
	}
}

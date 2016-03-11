package com.u4f.ant;

import java.util.List;

import com.u4f.model.Project;


/**
 * 蚁群优化算法，用来求解TSP问题
 * @Time 2016-1-17

 */
public class ACO {
	Ant []ants;
	int antCount;
	int [][]distance;
	/**
	 * 所有城市之间的信息素矩阵
	 */
	double [][]pheromone;
	
	int cityCount;
	/**
	 * 最佳路径
	 */
	int []bestTour;
	/**
	 * 城市
	 */
	List<Project> city;
	/**
	 * 最短路径
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
			 //每一只蚂蚁移动的过程  
			 for(int i=0; i<antCount; i++)//循环所有蚂蚁
			 {
				 for(int j=1;j<cityCount;j++)//每个蚂蚁循环所有城市
				 {
					 ants[i].SelectNextCity(j, pheromone, distance);
				 }
				 //计算蚂蚁获得的路径长度  
				 ants[i].calLength(distance);
				 //保留最优路径  
				 if(ants[i].getLength() < bestLength) 
				 {
					 bestLength = ants[i].getLength();
					 System.out.println("第" + gen + "代，发现新的解为："+bestLength);
					 for(int j=0; j<cityCount+1; j++)
					 {
						 bestTour[j] = ants[i].getTour()[j];
						 System.out.print(city.get(bestTour[j]).getProjectName() + " ");
					 }
					 System.out.println();
				 }
			 }
			//更新信息素矩阵  
			 update();
			//重新随机设置蚂蚁  
			 for(int i=0;i<antCount;i++) 
			 {
				 ants[i].init(cityCount);
			 }
		 }
	 }

	private void update()
	{
		double r = 0.5;
		 //信息素挥发  
		for(int i=0; i<cityCount; i++) 
		{ 
            for(int j=0;j<cityCount;j++)
            {
            	pheromone[i][j] *= (1-r);
            }
		}
		
		 //信息素更新  
		for(int i=0; i<antCount; i++)
		{  
            for(int j=0; j<cityCount; j++) 
            {  
            	pheromone[ants[i].getTour()[j]][ants[i].getTour()[j+1]] += 1.0/ants[i].getLength();  
            }  
        }  
	}
	
	public void ReportResult(){  
        System.out.println("最优路径长度是"+bestLength);
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

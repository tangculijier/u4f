package com.u4f.servlet;
import java.util.ArrayList;
import java.util.List;

import com.u4f.dao.ScenerySpotDao;
import com.u4f.model.ScenerySpot;


public class Test {
	
    public static void main(String args[]){
	    Test t=new Test();
	    t.showSpots();
        }

	public void showSpots(){
		List<ScenerySpot> list=new ArrayList<ScenerySpot>();
		ScenerySpotDao dao=new ScenerySpotDao();
		double a=34.2567;
		double b=108.9897;
		list=dao.getNearScenerySpot(b,a);
		 //list=dao.getAllScenerySpot();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	
		
	}
}

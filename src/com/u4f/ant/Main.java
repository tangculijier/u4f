package com.u4f.ant;

public class Main
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		ACO aco = new ACO();  
        aco.init(1000);  
        aco.run(20000);  
        aco.ReportResult();  
	}

}

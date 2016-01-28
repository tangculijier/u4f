package com.huang;



import java.math.BigDecimal;

/**
 * ����������
 *
 */
public class MyMath {
	
	// Ĭ�ϱ���С���λ��
	public static final int DEFAULT_SCALE = 20;


	
	public static double add(double num1, double num2) {
		BigDecimal first = getBigDecimal(num1);
		BigDecimal second = getBigDecimal(num2);
		return first.add(second).doubleValue();
	}
	
	/**
	 * Ϊһ�����ִ���BigDecimal����
	 * @param number
	 * @return
	 */
	private static BigDecimal getBigDecimal(double number) {
		return new BigDecimal(number);
	}


	public static double subtract(double num1, double num2) {
		BigDecimal first = getBigDecimal(num1);
		BigDecimal second = getBigDecimal(num2);
		return first.subtract(second).doubleValue();
	}


	public static double multiply(double num1, double num2) {
		BigDecimal first = getBigDecimal(num1);
		BigDecimal second = getBigDecimal(num2);
		return first.multiply(second).doubleValue();
	}


	public static double divide(double num1, double num2) {
		BigDecimal first = getBigDecimal(num1);
		BigDecimal second = getBigDecimal(num2);
		return first.divide(second, DEFAULT_SCALE, BigDecimal.ROUND_HALF_UP)
				.doubleValue();
	}
	
	//ȡ�������Чλ��
	public  static double take_effect_number(double number)
	{
			 BigDecimal temp =new BigDecimal(number);
			 number=temp.setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
			 return number;
			 
	}

}
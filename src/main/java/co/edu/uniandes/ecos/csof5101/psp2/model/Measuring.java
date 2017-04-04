/**
 * Measuring.java
 * PSP Program 5
 * Copyright (c) Universidad de los Andes.
 */
package co.edu.uniandes.ecos.csof5101.psp2.model;

/**
 * Measuring.
 * 
 * @author Javier Mesa
 * @version 1.0
 * @since 02/04/2017 04:58:29 PM 2017
 */

public final class Measuring {
	
	/**
	 * Calculate the W value
	 * @param data the object containing the values to make the calculations
	 */
	public static void calculateSegment(Data data){
		data.setW(data.getxTo()/Data.SEGMENT_NUMBER);
	}
	
	/**
	 * Calculate the gamma function for any value
	 * @param x the number to find the value of gamma function
	 * @return the value of gamma function
	 */
	public static double calculateGammaFunction(double x){
		double tmp = (x - 0.5) * Math.log(x + 4.5)-(x + 4.5);
	    double ser = 1.0+76.18009173/(x + 0)-86.50532033/(x + 1)
	                  +24.01409822/(x + 2)-1.231739516/(x + 3)
	                  +0.00120858003/(x + 4)-0.00000536382/(x + 5);
	    
	    return Math.exp(tmp + Math.log(ser*Math.sqrt(2*Math.PI)));
	}
	
	/**
	 * Calculate the t distribution with  Simpson´s rule
	 * @param data the object containing the values to make the calculations
	 */
	public static void calculateIntegrationTDistWithSimpsRuleValue(Data data){
		double xi = data.getxFrom();
		double dof = data.getDof();
		double w = data.getW();
		double integralVal = 0;
		for (int i = 0; i <= Data.SEGMENT_NUMBER; i++) {
			double xiTemp = xi;
			double fXiTemp = (Measuring.calculateGammaFunction((dof+1)/2)) / (Math.pow(dof*Math.PI,0.5) 
				* Measuring.calculateGammaFunction(dof/2)) * (Math.pow(1+(Math.pow(xiTemp,2)/dof),-((dof+1)/2)));
			double integralValTemp = (w/3) * calculateMultiplier(i) * fXiTemp ;
			integralVal += integralValTemp;
			xi += w;
		}
		data.setIntegralValue(integralVal);
	}
	
	/**
	 * Calculate of multiplier for each value of interval
	 * @param number the number of the iteration
	 * @return the value of multiplier
	 */
	public static double calculateMultiplier(double number){
		if(number==0 || number == Data.SEGMENT_NUMBER){
			return 1;
		} else if (number%2 == 0){
			return 2;
		} else {
			return 4;
		}
	}
}
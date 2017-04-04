/**
 * Data.java
 * PSP Program 5
 * Copyright (c) Universidad de los Andes.
 */
package co.edu.uniandes.ecos.csof5101.psp2.model;

/**
 * Data.
 * 
 * @author Javier Mesa
 * @version 1.0
 * @since 02/04/2017 04:58:29 PM 2017
 */
public class Data {
	
	// Constants
	public static final double ERROR = 0.00001;
	public static final double SEGMENT_NUMBER = 10;

	//Instance variables
	private double dof;
	private double xFrom;
	private double xTo;
	private double w;
	private double integralValue;
	/**
	 * @return the dof
	 */
	public double getDof() {
		return dof;
	}
	/**
	 * @param dof the dof to set
	 */
	public void setDof(double dof) {
		this.dof = dof;
	}
	/**
	 * @return the xFrom
	 */
	public double getxFrom() {
		return xFrom;
	}
	/**
	 * @param xFrom the xFrom to set
	 */
	public void setxFrom(double xFrom) {
		this.xFrom = xFrom;
	}
	/**
	 * @return the xTo
	 */
	public double getxTo() {
		return xTo;
	}
	/**
	 * @param xTo the xTo to set
	 */
	public void setxTo(double xTo) {
		this.xTo = xTo;
	}
	/**
	 * @return the w
	 */
	public double getW() {
		return w;
	}
	/**
	 * @param w the w to set
	 */
	public void setW(double w) {
		this.w = w;
	}
	/**
	 * @return the integralValue
	 */
	public double getIntegralValue() {
		return integralValue;
	}
	/**
	 * @param integralValue the integralValue to set
	 */
	public void setIntegralValue(double integralValue) {
		this.integralValue = integralValue;
	}
}

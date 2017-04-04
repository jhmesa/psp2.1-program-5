/**
 * MeasuringTest.java
 * PSP Program 5
 * Copyright (c) Universidad de los Andes.
 */
package co.edu.uniandes.ecos.csof5101.psp2.test;

import static org.junit.Assert.*;

import org.junit.Test;

import co.edu.uniandes.ecos.csof5101.psp2.model.Data;
import co.edu.uniandes.ecos.csof5101.psp2.model.Measuring;

/**
 * MeasuringTest.
 * 
 * @author Javier Mesa
 * @version 1.0
 * @since 02/04/2017 04:58:29 PM 2017
 */

public class MeasuringTest{
	
	/**
	 * Method to test the method calculateSegment.
	 */
	@Test
	public void calculateSegmentTest(){
		Data data = new Data();
		data.setxTo(1.1);
		Measuring.calculateSegment(data);
		
		assertEquals(0.11000000000000001, data.getW(), 0.0);
	}
	
	/**
	 * Method to test the method calculateGammaFunction.
	 */
	@Test
	public void calculateGammaFunctionTest(){
		double value = Measuring.calculateGammaFunction(1);
		
		assertEquals(0.999999999958284, value, 0.0);
	}
	
	/**
	 * Method to test the method calculateIntegrationTDistWithSimpsRuleValue.
	 */
	@Test
	public void calculateIntegrationTDistWithSimpsRuleValueTest(){
		Data data = new Data();
		data.setxTo(1.1);
		data.setxFrom(0.0);
		data.setDof(9.0);
		Measuring.calculateSegment(data);
		Measuring.calculateIntegrationTDistWithSimpsRuleValue(data);
		
		assertEquals(0.3500589042834335, data.getIntegralValue(), 0.0);
	}
	
	/**
	 * Method to test the method calculateMultiplier.
	 */
	@Test
	public void calculateMultiplierTest(){
		double value = Measuring.calculateMultiplier(1);
		assertEquals(4.0, value, 0.0);
	}
}

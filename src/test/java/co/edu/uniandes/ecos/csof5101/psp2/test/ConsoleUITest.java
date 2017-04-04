/**
 * ConsoleUITest.java
 * PSP Program 5
 * Copyright (c) Universidad de los Andes.
 */
package co.edu.uniandes.ecos.csof5101.psp2.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import co.edu.uniandes.ecos.csof5101.psp2.view.ConsoleUI;

/**
 * ConsoleUITest.
 * 
 * @author Javier Mesa
 * @version 1.0
 * @since 02/04/2017 04:58:29 PM 2017
 */

public class ConsoleUITest {
	
	/**
	 * Method to test the method calculateMeasurings.
	 */
	@Test
	public void calculateMeasuringsTest(){
		ConsoleUI face = new ConsoleUI();
		face.getData().setxTo(1.1);
		face.getData().setxFrom(0.0);
		face.getData().setDof(9.0);
		face.calculateMeasurings();
		
		assertEquals(0.3500589042834335, face.getData().getIntegralValue(),0.0);
	}
	
	
	/**
	 * Method to test the method printMeasurings.
	 */
	@Test
	public void printMeasuringsTest(){
		ConsoleUI face = new ConsoleUI();
		face.getData().setxTo(1.1);
		face.getData().setxFrom(0.0);
		face.getData().setDof(9.0);
		face.calculateMeasurings();
		ArrayList<String> output = new ArrayList<String>();
		output.add("x = 0.0 to 1.1");
		output.add("dof = 9.0");
		output.add("-------------------------");
		output.add("The expected value is = 0.3500589042834335");
		face.printMeasurings();
		
		assertEquals(output.get(2), face.printMeasurings().get(2));
	}
}

/**
 * ConsoleUI.java
 * PSP Program 5
 * Copyright (c) Universidad de los Andes.
 */

package co.edu.uniandes.ecos.csof5101.psp2.view;

import java.util.ArrayList;

import spark.Request;
import co.edu.uniandes.ecos.csof5101.psp2.model.Data;
import co.edu.uniandes.ecos.csof5101.psp2.model.Measuring;

/**
 * ConsoleUI.
 * 
 * @author Javier Mesa
 * @version 1.0
 * @since 02/04/2017 04:58:29 PM 2017
 */

public class ConsoleUI {
	
	//Instance Variables
	private Data data = new Data();

	/**
	 * Method to read the parameters from URL.
	 * @param params object that contains the request params
	 */
	public void readValuesFromURL(Request req) {
		String xFrom = req.queryParams("xFrom");
		String xTo = req.queryParams("xTo");
		String dof = req.queryParams("dof");
		double xFromNumber = xFrom != null?Double.valueOf(xFrom):0;
		double xToNumber = xTo != null?Double.valueOf(xTo):0;
		double dofNumber = dof != null?Double.valueOf(dof):0;
		data.setxFrom(xFromNumber);
		data.setxTo(xToNumber);
		data.setDof(dofNumber);
		
	}

	/**
	 * Method to print the metrics calculated on the page.
	 */
	public ArrayList<String> printMeasurings() {
		ArrayList<String> output = new ArrayList<String>();
		if(data != null){
			output.add("x = " + getData().getxFrom() + " to " + getData().getxTo());
			output.add("dof = " + getData().getDof());
			output.add("-------------------------");
			output.add("The expected value is = " + data.getIntegralValue());
		}
		return output;
	}
	
	/**
	 * Method to calculate the measurings.
	 */
	public void calculateMeasurings(){
		Measuring.calculateSegment(getData());
		Measuring.calculateIntegrationTDistWithSimpsRuleValue(getData());
	}
	
	/**
	 * @return the data
	 */
	public Data getData() {
		return data;
	}
}

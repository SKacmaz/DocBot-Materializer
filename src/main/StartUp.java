package main;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.log4j.Logger;

import adam.Adam;
import adam.IAdam;
import model.GridPlane;
import model.docBot.DocBotEnvironment;
import model.docBot.Pilot;
import stairway.Stairway;

/**
 * This class initializes all components of the materializer.
 * 
 * @author Kim
 */
public class StartUp {
	
	static final Logger LOGGER = Logger.getLogger(StartUp.class.getName());

	public static void main(String[] args) throws IOException {
		LOGGER.info("initializing Materializer components");

		//component to talk with Haven
		Stairway stairs = new Stairway();
		
		//component to talk to Ev3
		IAdam adam = new Adam();
		
		//represents the dimensions of the robot and its environment
		DocBotEnvironment environment = new DocBotEnvironment(1,1,1,1);
		
		//Represents the grid in which the resources will be materialized
		GridPlane plane = new GridPlane();
		
		//component for handling physical world logic
		Pilot pilot = new Pilot(plane, adam, environment);
		
		LOGGER.info("all components set up, beginning pulling loop");
		
		while(true)
		{
			//pull info and tell to pilot
		}
		
		
		
		
		
		
		
//		try {
//			String result = stairs.getJsonFrom(stairs.builder.build());
//			LOGGER.info("RESULT: " + result);
//		} catch (URISyntaxException e) {
//			LOGGER.error("could not build uri", e);
//		}
	}
}

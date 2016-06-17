package main;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

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
public class Materializer {
	static final Logger LOGGER = Logger.getLogger(Materializer.class.getName());
	
	//component to talk with Haven
	final Stairway stairs;
	
	//component to talk to Ev3
	final IAdam adam;
	
	//represents the dimensions of the robot and its environment
	final DocBotEnvironment environment;
	
	//Represents the grid in which the resources will be materialized
	final GridPlane plane;
	
	//component for handling physical world logic
	final Pilot pilot;
	
	final Map<String, User> users;
	
	public Materializer()
	{
		stairs = new Stairway();
		adam = new Adam();
		environment = new DocBotEnvironment();
		plane = new GridPlane();
		pilot = new Pilot(plane, adam, environment);
		users = new HashMap<>();
	}
	

	public static void main(String[] args) throws IOException {
		LOGGER.info("initializing Materializer components");
		
		Materializer matt = new Materializer();
		LOGGER.info("all components set up, beginning pulling loop");
		
		// Start Scanner For User input
		LOGGER.info("##########");
		Scanner scanner = new Scanner(System.in);

		// Create Polling Task
		TimerTask pollFromHaven = new TimerTask()
		{
			@Override
			public void run()
			{
				LOGGER.debug("###################");
				LOGGER.info("polling from Haven...");
				matt.handleUpdate();
			}
		};
		
		Timer timer = new Timer();
		timer.schedule(pollFromHaven, 10000, 10000);
		
		LOGGER.debug("Please, enter 0 to exit.");
		int i = scanner.nextInt();
		if (i == 0) {
			scanner.close();
			timer.cancel();
		}
	}


	protected void handleUpdate() {
		//pull
		String update = stairs.pullFromHaven();
		
		if(update != null && update != "")
		{
			LOGGER.info("UPDATE is: " + update);
			
		}
	}
}

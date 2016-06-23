package main;

import java.io.IOException;
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
 * @author Kim Reichert, Jochen Joswig
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
		users = new HashMap<String, User>();
//		//this method needs some checking
//		//it should go through all the users and add them to the userSet
//		//then it should go through all the resources and them to the typeSet
//		//the last step may not be usefull since there might be types of which no users has any instances yet -> they wouldn't make the list
//		Set<String> userSet = new HashSet<String>();
//		Set<String> typeSet = new HashSet<String>();
//		for(String user : users.keySet()){
//			User u = users.get(user);
//			userSet.add(u.getName());
//			for(String type : u.getResources().keySet()){
//				typeSet.add(u.getResources().get(type));
//			}
//		}
//		plane = new GridPlane(userSet, typeSet);
		plane = new GridPlane();
		pilot = new Pilot(plane, adam, environment);
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
		timer.schedule(pollFromHaven, 100, 10000);
		
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
			
			//parse update String
			
			//control pilot accordingly
			
		}
	}
}

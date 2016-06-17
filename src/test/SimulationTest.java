package test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import adam.Adam;
import adam.IAdam;
import main.StartUp;
import model.GridPlane;
import model.docBot.DocBotEnvironment;
import model.docBot.Pilot;
import stairway.Stairway;

/**
 * This test simulates information about resources from Haven to trigger
 * different actions in the robot.
 *
 * Assumed Context:
 * 
 * two users and two types of resources
 * 
 * | green | blue | ------+-------+-------+ depot | 2 | 2 |
 * ------+-------+-------+ userA | | | ------+-------+-------+ userB | | |
 * -----------------------
 *
 *
 * @author Kim
 */
public class SimulationTest {

	static final Logger LOGGER = Logger.getLogger(StartUp.class.getName());
	
	private static final String USER_B = "UserB";

	private static final String USER_A = "UserA";

	private static final String TYPE_GREEN = "Green";

	private static final String TYPE_BLUE = "Blue";

	// component to talk to Ev3
	IAdam adam;

	// represents the dimensions of the robot and its environment
	DocBotEnvironment environment;

	// Represents the grid in which the resources will be materialized
	GridPlane plane;

	// component for handling physical world logic
	Pilot pilot;
	
	Set<String> users = new HashSet<>();
	
	Set<String> types = new HashSet<>();
	
	@Before
	public void setup()
	{
		adam = new Adam();
		environment = new DocBotEnvironment();
		
		users.add(USER_A);
		users.add(USER_B);
		types.add(TYPE_BLUE);
		types.add(TYPE_GREEN);
		
		plane = new GridPlane(users, types);
		pilot = new Pilot(plane, adam, environment);
	}

	/**
	 * This test simulates the creation of one resource for user A of type
	 * green.
	 */
	@Test
	public void VerifySimpleSimulation() {
		
		//simulate USER A launching one resource
		pilot.increment(TYPE_BLUE, USER_A);
		
		//simulate User A removing same resource
		pilot.decrement(TYPE_BLUE, USER_A);

	}
}

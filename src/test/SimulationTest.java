package test;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import adam.Adam;
import adam.IAdam;
import main.Materializer;
import model.GridPlane;
import model.docBot.DocBotEnvironment;
import model.docBot.SimpleBinaryPilot;
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

	static final Logger LOGGER = Logger.getLogger(Materializer.class.getName());
	
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
	SimpleBinaryPilot pilot;
	
	Set<String> users = new HashSet<>();
	
	Set<String> types = new HashSet<>();
	
	@Before
	public void setup()
	{
		adam = new Adam();
		environment = new DocBotEnvironment(25, 18, 25, 25, 1, 1);
		
		users.add(USER_A);
		users.add(USER_B);
		types.add(TYPE_BLUE);
		types.add(TYPE_GREEN);
		
		plane = new GridPlane(users, types);
		pilot = new SimpleBinaryPilot(plane, adam, environment);
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
	
	/**
	 * This test simulates the creation of one resource for user A of type
	 * green.
	 */
	@Test
	public void VerifySimpleSimulation2() {
		
		//simulate USER A launching one resource
		pilot.increment(TYPE_GREEN, USER_B);
		
		//simulate User A removing same resource
//		pilot.decrement(TYPE_BLUE, USER_A);

	}
}

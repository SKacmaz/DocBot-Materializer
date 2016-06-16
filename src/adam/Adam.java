package adam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.log4j.Logger;

import stairway.Stairway;

public class Adam implements IAdam{

	static final Logger LOGGER = Logger.getLogger(Stairway.class.getName());
	
	private final String EVE_HOST = "http://192.168.173.227/";
	
	@Override
	public boolean moveForward(double cm) {
		URI uri = URI.create(EVE_HOST + "forward");
		return sendCommandToEve(uri);
	}

	@Override
	public boolean moveBackward(double cm) {
		URI uri = URI.create(EVE_HOST + "backward");
		return sendCommandToEve(uri);
	}

	@Override
	public boolean turnRight(double angle) {
		// TODO add angle!
		URI uri = URI.create(EVE_HOST + "turnright");
		return sendCommandToEve(uri);
	}

	@Override
	public boolean turnLeft(double angle) {
		// TODO add angle!
		URI uri = URI.create(EVE_HOST + "turnleft");
		return sendCommandToEve(uri);
	}

	@Override
	public boolean grab() {
		URI uri = URI.create(EVE_HOST + "grab");
		return sendCommandToEve(uri);
	}

	@Override
	public boolean drop() {
		URI uri = URI.create(EVE_HOST + "drop");
		return sendCommandToEve(uri);
	}

	/**
	 * Creates and sends a GET call to the given URI
	 * @param commandUri a {@link URI} that points to the URL with a command for Ev3.
	 * @return true if the call was successful
	 */
	private boolean sendCommandToEve(URI commandUri)
	{
		StringBuilder result = new StringBuilder();
		HttpURLConnection conn;
		
		try {
			conn = (HttpURLConnection) commandUri.toURL().openConnection();
			LOGGER.info("Sending request to Ev3 successful! Request URL: " + commandUri);
			conn.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			rd.close();
			
			return true;
		} catch (IOException e) {
			LOGGER.error("Sending request to Ev3 FAILED! Request URL: " + commandUri, e);
			return false;
		}
	}

	
	// JUST FOR TESTING
	public static void main(String[] args) throws IOException {
		Adam robot = new Adam();
		
		Boolean result = robot.moveForward(20);
		LOGGER.info("RESULT: " + result);
		
		 result = robot.moveBackward(20);
		LOGGER.info("RESULT: " + result);
		
		result = robot.turnLeft(20);
		LOGGER.info("RESULT: " + result);
		
		result = robot.turnRight(20);
		LOGGER.info("RESULT: " + result);
		
		result = robot.grab();
		LOGGER.info("RESULT: " + result);
		
		result = robot.drop();
		LOGGER.info("RESULT: " + result);
	}
}

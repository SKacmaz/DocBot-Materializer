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
	
	@Override
	public boolean moveForward(int cm) {
			StringBuilder result = new StringBuilder();
			HttpURLConnection conn;
			
			URI uri = URI.create("http://192.168.137.189/forward");
			
			try {
				conn = (HttpURLConnection) uri.toURL().openConnection();
				LOGGER.info("connection to Haven estalished");
				conn.setRequestMethod("GET");
				BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line;
				while ((line = rd.readLine()) != null) {
					result.append(line);
				}
				rd.close();
			} catch (IOException e) {
				LOGGER.error("Connection to Haven could not be established", e);
			}
		
		return false;
	}

	@Override
	public boolean moveBackward(int cm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean turnRight(int angle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean turnLeft(int angle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean grab() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean drop() {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String[] args) throws IOException {
		Adam stairs = new Adam();
		
		Boolean result = stairs.moveForward(20);
		LOGGER.info("RESULT: " + result);
	}
}

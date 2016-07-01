package stairway;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.utils.URIBuilder;
import org.apache.log4j.Logger;

/**
 * This is a first test class that talks to haven.
 * 
 * @author Kim Reichert
 */
public class Stairway {
	static final Logger LOGGER = Logger.getLogger(Stairway.class.getName());
	
//	private static final String LOCAL_HOST = "172.21.38.200";
	
	private static final String HAVEN_HOST = "localhost";
	
	private static final int PORT = 8081;
	
	private URIBuilder builder;
	
	public Stairway()
	{
		builder = new URIBuilder();
		builder.setScheme("http");
		builder.setHost(HAVEN_HOST);
		builder.setPort(PORT);
		builder.setPath(ApiHelper.RESOURCES_ALL);
//		builder.setPath(ApiHelper.TEST_DEFAULT);
	}

	/**
	 * Pulls resource information from Haven
	 * @return String with information, empty String if no new info
	 * null if connection failed.
	 */
	public String pullFromHaven()
	{
		try {
			return getJsonFrom(builder.build());
		} catch (ProtocolException e) {
			LOGGER.error("Could not reach Haven", e);
			return null;
		} catch (URISyntaxException e) {
			LOGGER.error("Could not reach Haven", e);
			return null;
		}
	}
	
	
	/**
	 * 
	 * @param urlToRead
	 * @return
	 * @throws ProtocolException 
	 */
	private String getJsonFrom(URI uri) throws ProtocolException {
//		LOGGER.debug("getting Json from Url: " + uri.toString());
		
		StringBuilder result = new StringBuilder();
		HttpURLConnection conn;
		
		try {
			conn = (HttpURLConnection) uri.toURL().openConnection();
//			LOGGER.info("connection to Haven estalished");
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
		return result.toString();
	}
}

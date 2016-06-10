package stairway;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.http.client.utils.URIBuilder;
import org.apache.log4j.Logger;

/**
 * This is a first test class that talks to haven
 * @author Kim
 *
 */
public class Stairway {
	static final Logger LOGGER = Logger.getLogger(Stairway.class.getName());
	
	private static final String LOCAL_HOST = "172.21.38.200";
	
	private static final String HAVEN_HOST = "52.29.104.85";
	
	private static final int PORT = 8081;
	
	private URIBuilder builder;
	
	public Stairway()
	{
		builder = new URIBuilder();
		builder.setScheme("http");
		builder.setHost(HAVEN_HOST);
		builder.setPort(PORT);
		builder.setPath(ApiHelper.TEST_DEFAULT);
	}

	
	/**
	 * 
	 * @param urlToRead
	 * @return
	 * @throws ProtocolException 
	 */
	public String getJsonFrom(URI uri) throws ProtocolException {
		LOGGER.debug("getting Json from Url: " + uri.toString());
		
		StringBuilder result = new StringBuilder();
		HttpURLConnection conn;
		
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
		return result.toString();
	}
	
	public static void main(String[] args) throws IOException {
		Stairway stairs = new Stairway();
		
		try {
			String result = stairs.getJsonFrom(stairs.builder.build());
			LOGGER.info("RESULT: " + result);
		} catch (URISyntaxException e) {
			LOGGER.error("could not build uri", e);
		}
	}
	
}

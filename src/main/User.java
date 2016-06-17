package main;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 *
 * @author Kim
 */
public class User {
	
	final String name;
	
	final Map<String,String> resources;
	
	public User(String name)
	{
		this.name = name;
		resources = new HashMap<>();
	}
	
	public void addResource(String name, String type)
	{
		resources.put(name, type);
	}
	
	public void removeResource(String name)
	{
		resources.remove(name);
	}
	
	public Map<String, String> getResources()
	{
		return resources;
	}
}

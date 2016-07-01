package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This class provides the grid for the pilot for navigation.
 *
 * @author Jochen Joswig
 */
public class GridPlane {
	private Map<String, Integer> users = new HashMap<String, Integer>();
	private Map<String, Integer> types = new HashMap<String, Integer>();
	
	/**
	 * 1.dimension: user
	 * 2.dimension: type
	 *       | type1 | type2 | ...
	 * ------+-------+-------+-----
	 * depot | 0...n | 0...m | ...
	 * ------+-------+-------+-----
	 * user1 | 0...k | 0...l | ...
	 * ------+-------+-------+-----
	 *  ...  |  ...  |  ...  | ...
	 * 
	 */
	private int[][] grid;
	
	/**
	 * Use this constructor to create a GridPlane with default values.
	 * @see fillWithdefaultValues()
	 */
	public GridPlane(){
		this.addUser("depot");
		//TODO make flexiable e.g. make it so that it the users and types are read from a .config-file.
		
		
		//XXX to be delete / just for testing
		this.fillWithdefaultValues();
	}
	
	/**
	 * Use this constructor to create a GridPlane with the given Sets of users and types.
	 * @param users
	 * @param types
	 */
	public GridPlane(Set<String> users, Set<String> types){
		this.addUser("depot");
		this.initialize(users, types);
	}
	
	protected void addUser(String user){
		this.users.put(user, new Integer(this.users.size()));
	}
	
	protected void addUsers(Set<String> users){
		for(String user : users){
			this.addUser(user);
		}
	}
	
	protected void addUsers(List<String> users){
		for(String user : users){
			this.addUser(user);
		}
	}
	
	/**
	 * Use this method to add a single type to the grid.
	 * @param type
	 */
	protected void addType(String type){
		this.types.put(type, new Integer(this.types.size()));
	}
	
	/**
	 * Use this method to add multiple types to the grid.
	 * @param types
	 */
	protected void addTypes(Set<String> types){
		for(String type : types){
			this.addType(type);
		}
	}
	
	/**
	 * Use this method to add multiple types to the grid.
	 * @param types
	 */
	protected void addTypes(List<String> types){
		for(String type : types){
			this.addType(type);
		}
	}
	
	/**
	 * Initializes the grid (how many rows and how many columns).
	 * Only use this method after you have added users and types!
	 * @see addUser(), addUsers(), addType(), addTypes()
	 */
	public void initialize(){
		this.grid = new int[this.users.size()][this.types.size()];
	}
	
	/**
	 * Initializes the grid (how many rows and how many columns).
	 * Use this method as a shortcut to adding users and types manually.
	 * @param users
	 * @param types
	 */
	public void initialize(Set<String> users, Set<String> types){
		
		ArrayList<String> u = new ArrayList<String>(users);
		ArrayList<String> t = new ArrayList<String>(types);
		
		Collections.sort(u);
		Collections.sort(t);
		
		this.addUsers(u);
		this.addTypes(t);
		
		this.initialize();
	}
	
	/**
	 * increases the resource-counter for a given user and type of resource by 1.
	 * @param user
	 * @param type
	 */
	public void increment(String user, String type){
		int u = this.users.get(user).intValue();
		int t = this.types.get(type).intValue();
		
		this.grid[u][t]++;
	}
	
	/**
	 * decreases the resources-counter for a given user and type of resource by 1.
	 * @param user
	 * @param type
	 */
	public void decrement(String user, String type){
		int u = this.users.get(user).intValue();
		int t = this.types.get(type).intValue();
		
		this.grid[u][t]--;
	}
	
	/**
	 * Use this method to get the corresponding grid index for a given user.
	 * @param user
	 * @return int - corresponding index for the given user
	 */
	public int getUserIndex(String user){
		return this.users.get(user).intValue();
	}
	
	/**
	 * Use this method to get the corresponding grid index for a given type.
	 * @param type
	 * @return int - corresponding index for the given type.
	 */
	public int getTypeIndex(String type){
		return this.types.get(type).intValue();
	}

	public Map<String, Integer> getUsers() {
		return users;
	}

	public void setUsers(Map<String, Integer> users) {
		this.users = users;
	}

	public Map<String, Integer> getTypes() {
		return types;
	}

	public void setTypes(Map<String, Integer> types) {
		this.types = types;
	}

	public int[][] getGrid() {
		return grid;
	}
	
	public int get(String user, String type){
		int u = this.users.get(user).intValue();
		int t = this.types.get(type).intValue();
		
		return this.grid[u][t];
	}

	public void setGrid(int[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Use this method to initialize the GridPlane with default data:
	 * users: Bob Marley, Marilyn Monroe
	 * types: blue, green
	 */
	private void fillWithdefaultValues(){
		Set<String> users = new HashSet<String>();
		Set<String> types = new HashSet<String>();
		
		users.add("Bob Marley");
		users.add("Marilyn Monroe");
		
		types.add("blue");
		types.add("green");
		
		this.initialize(users, types);
	}
	
	/**
	 * This method is for testing and debugging. It prints out the current status of the grid, e.g. all the columns all the rows and the values in them.
	 * FYI: it only prints out the first letter of the type and the first two letters of the user. Also if the number are greater then 9 the visuals will fall apart.
	 */
	public void printGridPlane(){
		String out = "    ";
		
		for(String t : this.getTypes().keySet()){
			out += "| " + t.charAt(0) + " ";
		}
		
		System.out.println(out);
		
		for(String u : this.getUsers().keySet()){
			out = " " + u.charAt(0) + u.charAt(1) + " ";
			for(String t : this.getTypes().keySet()){
				out += "| " + this.get(u, t) + " ";
			}
			System.out.println(out);
		}
	}
}

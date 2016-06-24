package model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 *
 * @author Jochen
 */
public class GridPlane {
	private Map<String, Integer> users = new HashMap<String, Integer>();
	private Map<String, Integer> types = new HashMap<String, Integer>();
	
	/**
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
	 * @deprecated
	 */
	public GridPlane(){
		this.addUser("depot");
		
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
	
	public void addUser(String user){
		this.users.put(user, new Integer(this.users.size()));
	}
	
	public void addUsers(Set<String> users){
		for(String user : users){
			this.addUser(user);
		}
	}
	
	/**
	 * Use this method to add a single type to the grid.
	 * @param type
	 */
	public void addType(String type){
		this.types.put(type, new Integer(this.types.size()));
	}
	
	/**
	 * Use this method to add multiple types to the grid.
	 * @param types
	 */
	public void addTypes(Set<String> types){
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
		this.grid = new int[this.types.size()][this.users.size()];
	}
	
	/**
	 * Initializes the grid (how many rows and how many columns).
	 * Use this method as a shortcut to adding users and types manually.
	 * @param users
	 * @param types
	 */
	public void initialize(Set<String> users, Set<String> types){
		this.addUsers(users);
		this.addTypes(types);
		
		this.grid = new int[this.types.size()][this.users.size()];
	}
	
	/**
	 * increases the resource-counter for a given user and type of resource by 1.
	 * @param user
	 * @param type
	 */
	public void increment(String user, String type){
		int i = this.users.get(user).intValue();
		int j = this.types.get(type).intValue();
		
		this.grid[j][i]++;
	}
	
	/**
	 * decreases the resources-counter for a given user and type of resource by 1.
	 * @param user
	 * @param type
	 */
	public void decrement(String user, String type){
		int i = this.users.get(user).intValue();
		int j = this.types.get(type).intValue();
		
		this.grid[j][i]--;
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

	public void setGrid(int[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Use this method to initialize the GridPlane with default data:
	 * users: Jochen, Kim, Semih
	 * types: A, B, C
	 */
	public void fillWithdefaultValues(){
		Set<String> users = new HashSet<String>();
		Set<String> types = new HashSet<String>();
		
		users.add("Bob Marley");
		users.add("Marilyn Monroe");
		
		types.add("blue");
		types.add("green");
		
		this.initialize(users, types);
	}
}

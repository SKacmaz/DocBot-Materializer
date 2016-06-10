package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GridPlane {
	private Map<String, Integer> users = new HashMap<String, Integer>();
	private Map<String, Integer> types = new HashMap<String, Integer>();
	
	private int[][] grid;
	
	public GridPlane(){super();}
	public GridPlane(Set<String> users, Set<String> types){
		super();
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
		this.grid = new int[this.users.size()][this.types.size()];
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
		
		this.grid = new int[this.users.size()][this.types.size()];
	}
	
	/**
	 * increases the resource-counter for a given user and type of resource
	 * @param user
	 * @param type
	 */
	public void increase(String user, String type){
		int i = this.users.get(user).intValue();
		int j = this.types.get(type).intValue();
		
		this.grid[i][j]++;
		//TODO tell the Bot what to do
	}
	
	/**
	 * decreases the resources-counter for a given user and type of resource
	 * @param user
	 * @param type
	 */
	public void decrease(String user, String type){
		int i = this.users.get(user).intValue();
		int j = this.types.get(type).intValue();
		
		this.grid[i][j]--;
		//TODO tell the Bot what to do
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
	
}

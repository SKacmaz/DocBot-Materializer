package model.docBot;

public interface IPilot{
	/**
	 * Use this method to increase the amount of containers associated with a given user and type by 1.
	 * @param type
	 * @param user
	 * @return
	 */
	public boolean increment(String user, String type);
	
	/**
	 * Use this method to decrease the amount of containers associated with a given user and type by 1. 
	 * @param type
	 * @param user
	 * @return
	 */
	public boolean decrement(String user, String type);
}
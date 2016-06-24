package model.docBot;

import adam.IAdam;
import model.GridPlane;
/**
 * This class controls the robot and the environment the robot is in,
 * by increasing or decreasing the field values corresponding to the specified user and type.
 * @author Jochen Joswig
 *
 */
public class Pilot {
	private final IAdam robot;
	private final GridPlane grid;
	private final DocBotEnvironment environment;
	
	public Pilot(GridPlane grid, IAdam robot, DocBotEnvironment environment){
		this.grid = grid;
		this.robot = robot;
		this.environment = environment;
	}
	
	/**
	 * Use this method to increase the amount of containers associated with a given user and type by 1.
	 * @param type
	 * @param user
	 * @return
	 */
	public boolean increment(String type, String user){
		int userDelta = this.grid.getUserIndex(user) - this.environment.getBotRowPos();
		int typeDelta = this.grid.getTypeIndex(type) - this.environment.getBotColPos();
		//if the robot is already at the right place it does not need to move so we can skip that.
		if(userDelta != 0 && typeDelta != 0){
			this.moveRobotToDepot(type);
		}
		this.robot.grab();
		this.moveRobotToDestination(user, type);
		this.robot.drop();
		this.grid.increment(user, type);
		return true;
	}
	
	/**
	 * Use this method to decrease the amount of containers associated with a given user and type by 1. 
	 * @param type
	 * @param user
	 * @return
	 */
	public boolean decrement(String type, String user){
		int userDelta = this.grid.getUserIndex(user) - this.environment.getBotRowPos();
		int typeDelta = this.grid.getTypeIndex(type) - this.environment.getBotColPos();
		//if the robot is already at the right place it does not need to move so we can skip that.
		if(userDelta != 0 && typeDelta != 0){
			this.moveRobotToDestination(user, type);
		}
		this.robot.grab();
		this.moveRobotToDepot(type);
		this.robot.drop();
		this.grid.decrement(user, type);
		return true;
	}
	
	/**
	 * Use this method to send the robot to the depot of a given type.
	 * It will then calculate the way there.
	 * Once it reached the depot it will grab an item out of that depot and stop.
	 * @param type
	 */
	private void moveRobotToDepot(String type){
		//horizontal movement
		double typeDelta = (this.grid.getTypeIndex(type) - this.environment.getBotColPos());
		
		if(typeDelta < 0){
			this.robot.turnRight(90);
		} else {
			this.robot.turnLeft(90);
		}
		
		typeDelta = typeDelta * this.environment.getSquareWidth() + typeDelta * this.environment.getMaxDocBotMeasurements();
				
		this.robot.moveForward(Math.abs(typeDelta) + (this.environment.getSquareWidth()/2) + (this.environment.getMaxDocBotMeasurements()/2));
		
		//vertical movement
		double userDelta = (this.grid.getUserIndex("depot") - this.environment.getBotRowPos());
		
		if(typeDelta < 0 && userDelta < 0){
			this.robot.turnRight(90);
		}else if(typeDelta < 0 && userDelta >= 0){
			this.robot.turnLeft(90);
		}else if(typeDelta >= 0 && userDelta < 0){
			this.robot.turnLeft(90);
		}else if(typeDelta >= 0 && userDelta >= 0){
			this.robot.turnRight(90);
		}
		
		userDelta = userDelta * this.environment.getSquareHeight() + userDelta * this.environment.getMaxDocBotMeasurements();
		
		this.robot.moveForward(Math.abs(userDelta));
		
		if(typeDelta < 0){
			this.robot.turnRight(90);
		} else {
			this.robot.turnLeft(90);
		}
		
		this.robot.moveForward((this.environment.getMaxDocBotMeasurements() / 2) + (this.environment.getSquareWidth() / 2));
		
		if(typeDelta < 0){
			this.robot.turnRight(90);
		} else {
			this.robot.turnLeft(90);
		}
		
		this.environment.setBotRowPos(this.grid.getUserIndex("depot"));
		this.environment.setBotColPos(this.grid.getTypeIndex(type));
	}
	
	/**
	 * Use this method to move the robot from the depot to the desired location, given by user and type.
	 * @param user
	 * @param type
	 */
	private void moveRobotToDestination(String user, String type){
		//horizontal movement
		double typeDelta = (this.grid.getTypeIndex(type) - this.environment.getBotColPos());
		
		if(typeDelta < 0){
			this.robot.turnRight(90);
		} else {
			this.robot.turnLeft(90);
		}
		
		typeDelta = typeDelta * this.environment.getSquareWidth() + typeDelta * this.environment.getMaxDocBotMeasurements();
		
		this.robot.moveForward(Math.abs(typeDelta) + (this.environment.getSquareWidth()/2) + (this.environment.getMaxDocBotMeasurements()/2));
		
		//vertical movement
		double userDelta = (this.grid.getUserIndex(user) - this.environment.getBotRowPos());
		
		if(typeDelta < 0 && userDelta < 0){
			this.robot.turnRight(90);
		}else if(typeDelta < 0 && userDelta >= 0){
			this.robot.turnLeft(90);
		}else if(typeDelta >= 0 && userDelta < 0){
			this.robot.turnLeft(90);
		}else if(typeDelta >= 0 && userDelta >= 0){
			this.robot.turnRight(90);
		}
		
		userDelta = userDelta * this.environment.getSquareHeight() + userDelta * this.environment.getMaxDocBotMeasurements();
		
		this.robot.moveForward(Math.abs(userDelta));
		
		if(typeDelta > 0){
			this.robot.turnLeft(90);
		} else {
			this.robot.turnRight(90);
		}
		
		this.robot.moveForward((this.environment.getMaxDocBotMeasurements() / 2) + (this.environment.getSquareWidth() / 2));
		
		//TODO add if to check which way to turn is right (eventually not needed)
		if(typeDelta > 0){
			this.robot.turnRight(90);
		} else {
			this.robot.turnLeft(90);
		}
		
		this.environment.setBotRowPos(this.grid.getUserIndex(user));
		this.environment.setBotColPos(this.grid.getTypeIndex(type));
	}
}

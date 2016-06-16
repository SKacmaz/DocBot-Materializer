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
	
	public boolean increase(String type, String user){
		this.moveRobotToDepot(type);
		this.moveRobotToDestination(user, type);
		return true;
	}
	
	public boolean decreasing(String type, String user){
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
		typeDelta = typeDelta * this.environment.getSquareWidth() + typeDelta * Math.max(this.environment.getDocBotHeigth(), this.environment.getDocBotWidth());
		if(typeDelta < 0){
			this.robot.turnRight(90);
		} else {
			this.robot.turnLeft(90);
		}
		
		this.robot.moveForward(typeDelta + (this.environment.getSquareWidth() / 2));
		
		//vertical movement
		double userDelta = (this.grid.getUserIndex("depot") - this.environment.getBotRowPos());
		userDelta = userDelta * this.environment.getSquareHeight() + userDelta * Math.max(this.environment.getDocBotHeigth(), this.environment.getDocBotWidth());
		if(typeDelta < 0 && userDelta < 0){
			this.robot.turnRight(90);
		}else if(typeDelta < 0 && userDelta > 0){
			this.robot.turnLeft(90);
		}else if(typeDelta <= 0 && userDelta < 0){
			this.robot.turnLeft(90);
		}else if(typeDelta <= 0 && userDelta > 0){
			this.robot.turnRight(90);
		}
		
		this.robot.moveForward(userDelta);
		
		this.robot.turnLeft(90);
		
		this.robot.moveForward(this.environment.getDocBotWidth() / 2);
		
		this.robot.turnRight(90);
		
		this.robot.grab();
	}
	
	/**
	 * Use this method to move the robot from the depot to the desired location, given by user and type.
	 * @param user
	 * @param type
	 */
	private void moveRobotToDestination(String user, String type){
		//horizontal movement
		double typeDelta = (this.grid.getTypeIndex(type) - this.environment.getBotColPos());
		
		//vertical movement
	}
}

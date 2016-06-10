package model.docBot;

import adam.IAdam;
import model.GridPlane;

public class Pilot {
	private IAdam robot;
	private GridPlane grid;
	private DocBotEnvironment environment;
	
	public Pilot(){
		super();
		this.grid = new GridPlane();
	}
	public Pilot(IAdam robot, DocBotEnvironment environment){
		this.robot = robot;
		this.environment = environment;
	}
	
	public boolean increase(String type, String user){
		this.moveRobotToDepot(type);
		
		
		return true;
	}
	
	public boolean remove(String type, String user){
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
		int typeDelta = (this.grid.getTypeIndex(type) - this.environment.getBotColPos());
		typeDelta = typeDelta * this.environment.getSquareWidth() + typeDelta * Math.max(this.environment.getDocBotHeigth(), this.environment.getDocBotWidth());
		if(typeDelta < 0){
			this.robot.turnRight(90);
		} else {
			this.robot.turnLeft(90);
		}
		
		this.robot.moveForward(typeDelta + (this.environment.getSquareWidth() / 2));
		
		//vertical movement
		int userDelta = (this.grid.getUserIndex("depot") - this.environment.getBotRowPos());
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
}

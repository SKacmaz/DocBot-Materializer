package model.docBot;

import adam.IAdam;
import exceptions.UnknownTypeException;
import exceptions.UnknownUserException;
import model.GridPlane;

public class SlimBinaryPilot implements IPilot{
	protected final IAdam robot;
	protected final GridPlane grid;
	protected final DocBotEnvironment environment;
	
	public SlimBinaryPilot(GridPlane grid, IAdam robot, DocBotEnvironment environment){
		this.robot = robot;
		this.grid = grid;
		this.environment = environment;
	}

	@Override
	public boolean increment(String user, String type) {
		try{
			int userDelta = this.grid.getUserIndex(user) - this.environment.getBotUserPosition();
			int typeDelta = this.grid.getTypeIndex(type) - this.environment.getBotTypePosition();
			
			//if the robot is already at the right place it does not need to move so we can skip that.
			if(userDelta != 0 && typeDelta != 0){
				this.moveRobotTo("depot", type);
			}
			
			while(!this.robot.grab()){}
			this.moveRobotTo(user, type);
			while(!this.robot.drop()){}
			this.grid.increment(user, type);
			return true;
			
		}catch(UnknownUserException e){
			System.err.println("Unknown user: " + user);
		}catch(UnknownTypeException e){
			System.err.println("Unknown type: "+ type);
		}
		
		return false;
	}

	@Override
	public boolean decrement(String user, String type){
		try{
			int userDelta = this.grid.getUserIndex(user) - this.environment.getBotUserPosition();
			int typeDelta = this.grid.getTypeIndex(type) - this.environment.getBotTypePosition();
			//if the robot is already at the right place it does not need to move so we can skip that.
			if(userDelta != 0 && typeDelta != 0){
				this.moveRobotTo(user, type);
			}
			while(!this.robot.grab()){}
			this.moveRobotTo("depot", type);
			while(!this.robot.drop()){}
			this.grid.decrement(user, type);
			return true;
		}catch(UnknownUserException e){
			System.err.println("Unknown user: " + user);
		}catch(UnknownTypeException e){
			System.err.println("Unknown type: "+ type);
		}
		
		return false;
	}
	
	private void moveToLane(){
		this.robot.turnRight(90);
		this.robot.moveForward(this.environment.getSquareWidth() * (this.environment.getBotTypePosition() + 1));
	}
	
	private void moveFromLane(String type){
		try {
			this.robot.moveForward((this.environment.getMaxDocBotMeasurements()/2) + (this.environment.getSquareWidth()/2) + this.environment.getSquareWidth() * (this.grid.getTypeIndex(type)));
			this.robot.turnRight(90);
		} catch (UnknownTypeException e) {
			e.printStackTrace();
		}
	}
	
	private void moveInLane(String user){
		try {
			int userDelta = this.grid.getUserIndex(user) - this.environment.getBotUserPosition();
			if(userDelta <= 0){
				this.robot.turnRight(90);
			}else if(userDelta > 0){
				this.robot.turnLeft(90);
			}
			
			this.robot.moveForward(userDelta * this.environment.getSquareHeight() + userDelta * this.environment.getMaxDocBotMeasurements());
			
			if(userDelta <= 0){
				this.robot.turnRight(90);
			}else if(userDelta > 0){
				this.robot.turnLeft(90);
			}
		} catch (UnknownUserException e) {
			e.printStackTrace();
		}
	}
	
	private void MoveInRowToType(String type){
		try {
			double typeDelta = this.grid.getTypeIndex(type) - this.environment.getBotTypePosition();
			if(typeDelta < 0){
				this.robot.turnRight(90);
			} else if(typeDelta > 0){
				this.robot.turnLeft(90);
			}
			
			typeDelta = typeDelta * this.environment.getSquareWidth();
			
			this.robot.moveForward(typeDelta);
			
			if(typeDelta < 0){
				this.robot.turnLeft(90);
			} else if(typeDelta > 0){
				this.robot.turnRight(90);
			}
			
		} catch (UnknownTypeException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Use this method to move the robot from the depot to the desired location, given by user and type.
	 * @param user
	 * @param type
	 */
	private void moveRobotTo(String user, String type){
		try{
			double userDelta = (this.grid.getUserIndex(user) - this.environment.getBotUserPosition());
			
			if(userDelta == 0){
				this.MoveInRowToType(type);
			} else {
				this.moveToLane();
				this.moveInLane(user);
				this.moveFromLane(type);
			}
						
			this.environment.setBotUserPosition(this.grid.getUserIndex(user));
			this.environment.setBotTypePosition(this.grid.getTypeIndex(type));

		}catch(UnknownUserException e){
			System.err.println("Unknown user: " + user);
		}catch(UnknownTypeException e){
			System.err.println("Unknown type: "+ type);
		}
	}
	
	public GridPlane getGridPlane(){
		return grid;
	}
}

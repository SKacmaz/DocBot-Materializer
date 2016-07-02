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
				this.moveRobotToDepot(type);
			}
			
			while(!this.robot.grab()){}
			this.moveRobotToDestination(user, type);
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
				this.moveRobotToDestination(user, type);
			}
			while(!this.robot.grab()){}
			this.moveRobotToDepot(type);
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
			this.robot.moveForward(this.environment.getSquareWidth() * (this.grid.getTypeIndex(type) + 1));
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

	/**
	 * Use this method to send the robot to the depot of a given type.
	 * It will then calculate the way there.
	 * Once it reached the depot it will grab an item out of that depot and stop.
	 * @param type
	 */
	private void moveRobotToDepot(String type){
		//horizontal movement
		try{
			double typeDelta = (this.grid.getTypeIndex(type) - this.environment.getBotTypePosition());
			
			if(typeDelta < 0){
				while(!this.robot.turnRight(90)){}
			} else {
				while(!this.robot.turnLeft(90)){}
			}
			
			typeDelta = typeDelta * this.environment.getSquareWidth() + typeDelta * this.environment.getMaxDocBotMeasurements();
					
			while(!this.robot.moveForward(Math.abs(typeDelta) + (this.environment.getSquareWidth()/2) + (this.environment.getMaxDocBotMeasurements()/2))){}
			
			//vertical movement
			double userDelta = (this.grid.getUserIndex("depot") - this.environment.getBotUserPosition());
			
			if(typeDelta < 0 && userDelta < 0){
				while(!this.robot.turnRight(90)){}
			}else if(typeDelta < 0 && userDelta >= 0){
				while(!this.robot.turnLeft(90)){}
			}else if(typeDelta >= 0 && userDelta < 0){
				while(!this.robot.turnLeft(90)){}
			}else if(typeDelta >= 0 && userDelta >= 0){
				while(!this.robot.turnRight(90)){}
			}
			
			userDelta = userDelta * this.environment.getSquareHeight() + userDelta * this.environment.getMaxDocBotMeasurements();
			
			while(!this.robot.moveForward(Math.abs(userDelta))){}
			
			if(typeDelta < 0){
				while(!this.robot.turnRight(90)){}
			} else {
				while(!this.robot.turnLeft(90)){}
			}
			
			while(!this.robot.moveForward((this.environment.getMaxDocBotMeasurements() / 2) + (this.environment.getSquareWidth() / 2))){}
			
			if(typeDelta < 0){
				while(!this.robot.turnRight(90)){}
			} else {
				while(!this.robot.turnLeft(90)){}
			}
			
			this.environment.setBotUserPosition(this.grid.getUserIndex("depot"));
			this.environment.setBotTypePosition(this.grid.getTypeIndex(type));
		}catch(UnknownUserException e){
			System.err.println("The depot is unknown.");
		}catch(UnknownTypeException e){
			System.err.println("Unknown type: "+ type);
		}
	}
	
	/**
	 * Use this method to move the robot from the depot to the desired location, given by user and type.
	 * @param user
	 * @param type
	 */
	private void moveRobotToDestination(String user, String type){
		try{
			double typeDelta = (this.grid.getTypeIndex(type) - this.environment.getBotTypePosition());
			
			//horizontal movement		
			if(typeDelta != 0){
				while(!this.robot.turnRight(90)){}
			}
			
			typeDelta = typeDelta * this.environment.getSquareWidth();
			
			while(!this.robot.moveForward(Math.abs(typeDelta) + (this.environment.getSquareWidth()/2) + (this.environment.getMaxDocBotMeasurements()/2))){}
			
			//vertical movement
			double userDelta = (this.grid.getUserIndex(user) - this.environment.getBotUserPosition());
			
			if(userDelta == 0){
				while(!this.robot.turnLeft(90)){}
			}else if(userDelta < 0){
				while(!this.robot.turnRight(90)){}
			}else if(userDelta > 0){
				while(!this.robot.turnLeft(90)){}
			}
			
			userDelta = userDelta * this.environment.getSquareHeight() + userDelta * this.environment.getMaxDocBotMeasurements();
			
			while(!this.robot.moveForward(Math.abs(userDelta))){}
			
			if(typeDelta > 0){
				while(!this.robot.turnLeft(90)){}
			} else {
				while(!this.robot.turnRight(90)){}
			}
			
			while(!this.robot.moveForward((this.environment.getMaxDocBotMeasurements() / 2) + (this.environment.getSquareWidth() / 2))){}
			
			//TODO add if to check which way to turn is right (eventually not needed)
			if(typeDelta > 0){
				while(!this.robot.turnRight(90)){}
			} else {
				while(!this.robot.turnLeft(90)){}
			}
			
			this.environment.setBotUserPosition(this.grid.getUserIndex(user));
			this.environment.setBotTypePosition(this.grid.getTypeIndex(type));

		}catch(UnknownUserException e){
			System.err.println("Unknown user: " + user);
		}catch(UnknownTypeException e){
			System.err.println("Unknown type: "+ type);
		}
	}
}

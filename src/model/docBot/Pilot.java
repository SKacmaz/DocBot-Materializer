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
	
	
}

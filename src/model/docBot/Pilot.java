package model.docBot;

import model.GridPlane;

public class Pilot {
	private DocBot robot;
	private GridPlane grid;
	private DocBotEnvironment environment;
	
	public Pilot(){
		super();
		this.grid = new GridPlane();
	}
	public Pilot(DocBot robot, DocBotEnvironment environment){
		this.robot = robot;
		this.environment = environment;
	}
	
	
}

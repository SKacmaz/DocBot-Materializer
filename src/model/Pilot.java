package model;

public class Pilot {
	private DocBot robot;
	private GridPlane grid;
	
	public Pilot(){
		super();
		this.grid = new GridPlane();
	}
	public Pilot(DocBot robot){
		this.robot = robot;
	}
	
	
}

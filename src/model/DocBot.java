package model;

public interface DocBot {
	public boolean move(int cm);
	public boolean turnRight(int angle);
	public boolean turnLeft(int angle);
	
	public boolean grab();
	public boolean drop();
}

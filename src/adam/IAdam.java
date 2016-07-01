package adam;

/**
 * This interface defines the commands that the pilot can use to control the Ev3-robot.
 *
 * @author Jochen Joswig, Kim Reichert
 */
public interface IAdam {
	
	/**
	 * Use this method to move a given length in cm forward.
	 * @param cm
	 * @return true - if the robot finished the movement successfully<br>
	 * 		   false - if the robot could not finish the movement successfully.
	 */
	public boolean moveForward(double cm);
	
	/**
	 * Use this method to move a given length in cm backward.
	 * @param cm
	 * @return true - if the robot finished the movement successfully<br>
	 * 		   false - if the robot could not finish the movement successfully.
	 */
	public boolean moveBackward(double cm);
	
	/**
	 * Use this method to turn right a given angle in degree.
	 * @param angle - the angle to turn
	 * @return true - if the robot finished the movement successfully<br>
	 * 		   false - if the robot could not finish the movement successfully.
	 */
	public boolean turnRight(int angle);
	
	/**
	 * Use this method to turn left a given angle in degree.
	 * @param angel - the angle to turn
	 * @return true - if the robot finished the movement successfully<br>
	 * 		   false - if the robot could not finish the movement successfully.
	 */
	public boolean turnLeft(int angle);
	
	/**
	 * Use this method to grab and lift an item in front of the robot. 
	 * @return
	 */
	public boolean grab();
	/**
	 * Use this method to drop an item that the robot is holding.
	 * @return
	 */
	public boolean drop();
}

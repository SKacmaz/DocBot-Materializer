package model.docBot;

/**
 * This is class provides the Pilot with important information about the environment the DocBot/robot is in.
 * Like:
 * 		- The Position of the DocBot/robot
 * 		- The measurements of the grid cells and the DocBot/robot itself.
 *
 * @author Jochen Joswig
 */
public class DocBotEnvironment {
	/**
	 * The height of the robot in cm.
	 */
	private final double docBotHeigth;
	/**
	 * The width of the robot in cm.
	 */
	private final double docBotWidth;
	/**
	 * the height of one square of the grid in cm.
	 */
	private final double squareHeight;
	/**
	 * the width of one square of the grid in cm.
	 */
	private final double squareWidth;
	/**
	 * The current column position of the robot.
	 */
	private int botTypePosition;
	/**
	 * The current row position of the robot.
	 */
	private int botUserPosition;
	
	/**
	 * Use this constructor to create a DocBotEnvironment with default values (iow. the values that we used to test our installation with).
	 */
	public DocBotEnvironment(){
		super();
		this.botTypePosition = 0;
		this.botUserPosition = 0;
		this.squareHeight = 25;
		this.squareWidth = 25;
		this.docBotHeigth = 25;
		this.docBotWidth = 18;
	}
	
	/**
	 * Use this method to create a DocBotEnvironment with the passed parameters.
	 * @param docBotHeigth
	 * @param docBotWidth
	 * @param squareHeight
	 * @param squareWidth
	 */
	public DocBotEnvironment(double docBotHeigth, double docBotWidth, double squareHeight, double squareWidth, int botColPos, int botRowPos) {
		this.docBotHeigth = docBotHeigth;
		this.docBotWidth = docBotWidth;
		this.squareHeight = squareHeight;
		this.squareWidth = squareWidth;
		this.botTypePosition = botColPos;
		this.botUserPosition = botRowPos;
	}
	
	public double getMaxDocBotMeasurements(){
		return Math.max(this.docBotHeigth, this.docBotWidth);
	}
	

	public double getDocBotHeigth() {
		return docBotHeigth;
	}

	public double getDocBotWidth() {
		return docBotWidth;
	}


	public double getSquareHeight() {
		return squareHeight;
	}

	public double getSquareWidth() {
		return squareWidth;
	}

	public int getBotTypePosition() {
		return botTypePosition;
	}

	public void setBotTypePosition(int botColPos) {
		this.botTypePosition = botColPos;
	}

	public int getBotUserPosition() {
		return botUserPosition;
	}

	public void setBotUserPosition(int botRowPos) {
		this.botUserPosition = botRowPos;
	}

}

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
	private int botColPos;
	/**
	 * The current row position of the robot.
	 */
	private int botRowPos;
	
	/**
	 * Use this constructor to create a DocBotEnvironment with default values.
	 * @deprecated
	 */
	public DocBotEnvironment(){
		super();
		this.botColPos = 0;
		this.botRowPos = 0;
		this.squareHeight = 4;
		this.squareWidth = 4;
		this.docBotHeigth = 5;
		this.docBotWidth = 4;
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
		this.botColPos = botColPos;
		this.botRowPos = botRowPos;
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

	public int getBotColPos() {
		return botColPos;
	}

	public void setBotColPos(int botColPos) {
		this.botColPos = botColPos;
	}

	public int getBotRowPos() {
		return botRowPos;
	}

	public void setBotRowPos(int botRowPos) {
		this.botRowPos = botRowPos;
	}

}

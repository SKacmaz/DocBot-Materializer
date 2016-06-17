package model.docBot;

public class DocBotEnvironment {
	private double docBotHeigth = 1;
	private double docBotWidth = 1;
	private double squareHeight = 2;
	private double squareWidth = 2;
	private int botColPos = 0;
	private int botRowPos = 0;
		
	public DocBotEnvironment(double docBotHeigth, double docBotWidth, double squareHeight, double squareWidth) {
		this.docBotHeigth = docBotHeigth;
		this.docBotWidth = docBotWidth;
		this.squareHeight = squareHeight;
		this.squareWidth = squareWidth;
	}

	public double getDocBotHeigth() {
		return docBotHeigth;
	}

	public void setDocBotHeigth(double docBotHeigth) {
		this.docBotHeigth = docBotHeigth;
	}

	public double getDocBotWidth() {
		return docBotWidth;
	}

	public void setDocBotWidth(double docBotWidth) {
		this.docBotWidth = docBotWidth;
	}

	public double getSquareHeight() {
		return squareHeight;
	}

	public void setSquareHeight(double squareHeight) {
		this.squareHeight = squareHeight;
	}

	public double getSquareWidth() {
		return squareWidth;
	}

	public void setSquareWidth(double squareWidth) {
		this.squareWidth = squareWidth;
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

package model.docBot;

public class DocBotEnvironment {
	private int docBotHeigth;
	private int docBotWidth;
	private int squareHeight;
	private int squareWidth;
	private int botColPos = 0;
	private int botRowPos = 1;
		
	public DocBotEnvironment(int docBotHeigth, int docBotWidth, int squareHeight, int squareWidth) {
		this.docBotHeigth = docBotHeigth;
		this.docBotWidth = docBotWidth;
		this.squareHeight = squareHeight;
		this.squareWidth = squareWidth;
	}

	public int getDocBotHeigth() {
		return docBotHeigth;
	}

	public void setDocBotHeigth(int docBotHeigth) {
		this.docBotHeigth = docBotHeigth;
	}

	public int getDocBotWidth() {
		return docBotWidth;
	}

	public void setDocBotWidth(int docBotWidth) {
		this.docBotWidth = docBotWidth;
	}

	public int getSquareHeight() {
		return squareHeight;
	}

	public void setSquareHeight(int squareHeight) {
		this.squareHeight = squareHeight;
	}

	public int getSquareWidth() {
		return squareWidth;
	}

	public void setSquareWidth(int squareWidth) {
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

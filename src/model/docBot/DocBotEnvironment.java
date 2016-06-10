package model.docBot;

public class DocBotEnvironment {
	private int DocBotHeigth;
	private int DocBotWidth;
	private int SquareHeight;
	private int SquareWidth;
	private int BotColPos = 0;
	private int BotRowPos = 1;
		
	public DocBotEnvironment(){
		super();
	}
	
	public DocBotEnvironment(int docBotHeigth, int docBotWidth, int squareHeight, int squareWidth) {
		super();
		DocBotHeigth = docBotHeigth;
		DocBotWidth = docBotWidth;
		SquareHeight = squareHeight;
		SquareWidth = squareWidth;
	}

	public int getDocBotHeigth() {
		return DocBotHeigth;
	}

	public void setDocBotHeigth(int docBotHeigth) {
		DocBotHeigth = docBotHeigth;
	}

	public int getDocBotWidth() {
		return DocBotWidth;
	}

	public void setDocBotWidth(int docBotWidth) {
		DocBotWidth = docBotWidth;
	}

	public int getSquareHeight() {
		return SquareHeight;
	}

	public void setSquareHeight(int squareHeight) {
		SquareHeight = squareHeight;
	}

	public int getSquareWidth() {
		return SquareWidth;
	}

	public void setSquareWidth(int squareWidth) {
		SquareWidth = squareWidth;
	}

	public int getBotColPos() {
		return BotColPos;
	}

	public void setBotColPos(int botColPos) {
		BotColPos = botColPos;
	}

	public int getBotRowPos() {
		return BotRowPos;
	}

	public void setBotRowPos(int botRowPos) {
		BotRowPos = botRowPos;
	}

}

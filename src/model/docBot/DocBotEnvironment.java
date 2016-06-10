package model.docBot;

public class DocBotEnvironment {
	public int DocBotHeigth;
	public int DocBotWidth;
	public int SquareHeight;
	public int SquareWidth;
	
	
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
}

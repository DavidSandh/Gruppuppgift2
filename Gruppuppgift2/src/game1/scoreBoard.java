package game1;

import paintpanel.Text;

public class scoreBoard {
	
	private int score;
	private Text textScore;
	
	public scoreBoard(int score) {
		this.score = score;
	}

	public Text getTextScore() {
		return textScore;
	}

	public void setTextScore(Text textScore) {
		this.textScore = textScore;
	}

	public String getScore() {
		return String.valueOf(score);
	}

	public void setScore(int score) {
		this.score = score;
	}
	

}

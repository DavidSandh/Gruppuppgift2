package game1;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import controller.StartApp;
import controller.StartGamePanel;
import gu2.PaintWindow_GU2;
import game1.Car;
import paintpanel.Text;

public class Game1 {
	private PaintWindow_GU2 mWindow;	
	private StartGamePanel mController;
	private int mX;
	private int mY;
	private Font font = new Font("Monospaced",Font.BOLD, 150);
	private Font font1 = new Font("Monospaced",Font.BOLD, 35);
	private Text timer, playerSpeedTxt, winner;
	private Car c1 = new Car(StartApp.getImageIcon("/game1/images/CarBlue.GIF"));
    private Car c2 = new Car(StartApp.getImageIcon("/game1/images/CarRed.GIF"));
    private int playerSpeed = 0;
    private double computerSpeed = 0;
    private boolean toggle = true;
    private int game = 0;
    private scoreBoard[][] score = new scoreBoard [5][2];

	public Game1(PaintWindow_GU2 window, StartGamePanel controller, int x, int y) {
		mWindow = window;
		mController = controller;
		mX = x;
		mY = y;
		mWindow.fillRect(x, y, StartGamePanel.GAME_WIDTH, StartGamePanel.GAME_HEIGHT, Color.GRAY);
		mWindow.setKeyReleased(PaintWindow_GU2.VK_UP, this, "speedUp");
		initButtons();
		init();
		reset();
	}
	private void initButtons() {
		int x = mX + 10;
		ImageIcon btnStart = StartApp.getImageIcon("/game1/images/buttonstart.png");
		ImageIcon btnReset = StartApp.getImageIcon("/game1/images/buttonreset.png");
		ImageIcon btnMenu = StartApp.getImageIcon("/game1/images/buttonmeny.png");

		mWindow.addIcon(btnStart, x, mY+500, true);
		x += 10+btnStart.getIconWidth();
		mWindow.addIcon(btnReset, x, mY+500, true);
		x += 10+btnStart.getIconWidth();
		mWindow.addIcon(btnMenu, x, mY+500, true);
		mWindow.setIconAction(btnStart, this, "start");
		mWindow.setIconAction(btnReset, this, "reset");
		mWindow.setIconAction(btnMenu,  this, "menu");
	}
	
	private void init() {
		mWindow.fillRect(mX+20, mY+100, 700 , 50, Color.BLACK);
		mWindow.fillRect(mX+20, mY+200, 700 , 50, Color.BLACK);
		mWindow.fillRect(mX, mY+100, 20, 150, Color.WHITE);
		mWindow.addIcon(c1.getImage(), mX+720, mY+105, true);
		mWindow.addIcon(c2.getImage(), mX+720, mY+205, true);
		for(int i = 0; score.length > i; i++) {
			for(int j=0; score[i].length > j;j++){	
				score[i][1] = new scoreBoard(0);
			}
			score[i][0] = new scoreBoard(i+1);
		}
		for(int i = 0; i < score.length; i++) {
			score[i][0].setTextScore((new Text(score[i][0].getScore(),font1,Color.WHITE)));
			mWindow.addText(score[i][0].getTextScore(), mX+500, mY+300+(i*35));
			for(int j = 1; j < score[i].length; j++) {
				score[i][j].setTextScore((new Text(score[i][j].getScore(),font1,Color.WHITE)));
				mWindow.addText(score[i][j].getTextScore(), mX+600, mY+300+(i*35));
			}
		}
	}
	
	private void scoreBoard(int game) {
		mWindow.removeIcon(score[game][1].getTextScore());
		score[game][1].setTextScore(new Text(score[game][1].getScore(),font1,Color.WHITE));
		mWindow.addIcon(score[game][1].getTextScore(), mX+600, mY+300+(game*35), true);
	}
	
	public void start() {
		playerSpeed = 0;
		computerSpeed = 5;
		mWindow.removeIcon(playerSpeedTxt);
		mWindow.removeIcon(winner);
		playerSpeedTxt = new Text("Player Speed: " + String.valueOf(playerSpeed), font1, Color.WHITE);
		mWindow.addText(playerSpeedTxt, mX+150, mY+340);
		c1.moveTo(mX+720, mY+105);
		c2.moveTo(mX+720, mY+205);
		mWindow.setIconXY(c1.getImage(), c1.getX(), c1.getY());
		mWindow.setIconXY(c2.getImage(), c2.getX(), c2.getY());
		toggle = true;
		int i = 3;
		for(i = 3; i >= 0; i -- ) {
			mWindow.removeIcon(timer);
			timer = new Text(String.valueOf(i), font, Color.WHITE);
			mWindow.addText(timer, mX+20, mY+300);
			PaintWindow_GU2.pause(1000);
		}
		score[game][1].setScore(playerSpeed);
		scoreBoard(game);
		toggle = false;
		while((c1.getX() > mX+20) && (c2.getX() > mX+20)) {
			c1.moveTo(c1.getX() - playerSpeed, c1.getY());
			c2.moveTo(c2.getX() - (int)computerSpeed, c2.getY());
			mWindow.setIconXY(c1.getImage(), c1.getX(), c1.getY());
			mWindow.setIconXY(c2.getImage(), c2.getX(), c2.getY());
			PaintWindow_GU2.pause(40);
		}
		if(playerSpeed > 25) {
			winner = new Text("Player Wins",font1, Color.BLUE);
		} else if (playerSpeed < 21) {
			winner = new Text("Computer Wins", font1, Color.RED);
		} else {
			winner = new Text("Draw", font1, Color.WHITE);
		}
		mWindow.addText(winner, mX+300, mY+50);
		game++;
		if(game > 4) {
			game = 0;
		}
	}
	
	public void speedUp() {
		if (toggle) {
		playerSpeed += 1;
		computerSpeed += 0.8;
		mWindow.removeIcon(playerSpeedTxt);
		playerSpeedTxt = new Text("Player Speed: " + String.valueOf(playerSpeed), font1, Color.WHITE);
		mWindow.addText(playerSpeedTxt, mX+150, mY+340);
		}
	}
	
	public void reset() {
		mWindow.removeIcon(timer);
		timer = new Text("3", font, Color.WHITE);
		mWindow.addText(timer, mX+20, mY+300);
		c1.moveTo(mX+720, mY+105);
		c2.moveTo(mX+720, mY+205);
		mWindow.setIconXY(c1.getImage(), c1.getX(), c1.getY());
		mWindow.setIconXY(c2.getImage(), c2.getX(), c2.getY());
		mWindow.removeIcon(playerSpeedTxt);
		for(int i = 0; i < 4; i++) {
			score[i][1].setScore(0);
			scoreBoard(i);
		}
		
	}
	public void menu() {
		mController.menu();
	}

}


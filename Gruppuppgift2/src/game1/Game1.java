package game1;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import controller.StartApp;
import controller.StartGamePanel;
import gu2.PaintWindow_GU2;
import game1.Car;
import paintpanel.Sound;
import paintpanel.SoundClip;
import paintpanel.Text;

public class Game1 {
	private PaintWindow_GU2 mWindow;
	private StartGamePanel mController;
	private int mX;
	private int mY;
	//private Numbers numbers1;
	//private Numbers numbers2;
	private boolean mStarted;
	private boolean mRunning;
	private SoundClip clip;
	private Text text1;
	private Text text2;
	private Font font = new Font("Monospaced",Font.BOLD, 150);
	private Font font1 = new Font("Monospaced",Font.BOLD, 35);
	private Text timer, playerSpeedTxt;
	private Car c1 = new Car(StartApp.getImageIcon("/game1/images/CarBlue.GIF"));
    private Car c2 = new Car(StartApp.getImageIcon("/game1/images/CarRed.GIF"));
    private int playerSpeed = 0;
    private double computerSpeed = 0;
    private boolean toggle = true;
    

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
		ImageIcon btnStart = StartApp.getImageIcon("/game1/images/starta.png");
		ImageIcon btnReset = StartApp.getImageIcon("/game1/images/fortsatt.png");
		ImageIcon btnMenu = StartApp.getImageIcon("/game1/images/meny.png");

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
		
		
	}
	
	public void start() {
		playerSpeed = 0;
		computerSpeed = 5;
		mWindow.removeIcon(playerSpeedTxt);
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
		toggle = false;
		while((c1.getX() > mX+20) && (c2.getX() > mX+20)) {
			c1.moveTo(c1.getX() - playerSpeed, c1.getY());
			c2.moveTo(c2.getX() - (int)computerSpeed, c2.getY());
			mWindow.setIconXY(c1.getImage(), c1.getX(), c1.getY());
			mWindow.setIconXY(c2.getImage(), c2.getX(), c2.getY());
			PaintWindow_GU2.pause(40);
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
		
	}
	public void menu() {
		mController.menu();
	}

}

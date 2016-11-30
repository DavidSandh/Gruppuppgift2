package controller;

import java.awt.Color;

import game1.Game1;
//import game2.Game2;
//import game3.Game3;
import gu2.PaintWindow_GU2;

public class StartGamePanel {
	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 600;
	private final int MENU_X = 0;
	private final int MENU_Y = 0;
	private final int GAME1_X = 800;
	private final int GAME1_Y = 0;
	private final int GAME2_X = 0;
	private final int GAME2_Y = 600;
	private final int GAME3_X = 800;
	private final int GAME3_Y = 600;
	private PaintWindow_GU2 mWindow;
	private Game1 mGame1;
	//private Game2 mGame2;
	//private Game3 mGame3;
	public StartGamePanel() {
		mWindow = new PaintWindow_GU2(800,600,1600,1200,"Application_Example",Color.LIGHT_GRAY);
		MainMenu menu = new MainMenu(mWindow, this, MENU_X, MENU_Y);
		mGame1 = new Game1(mWindow, this, GAME1_X, GAME1_Y);
	}
	
	public void menu() {
		mWindow.setCameraXY(0, 0);
	}
	
	public void moveCameraTo(String game) {
		switch(game) {
		case "GAME1" : moveCameraTo(GAME1_X,GAME1_Y,1); break;
/*		case "GAME2" : 
			mWindow.executeAction(mGame2, "init");
			moveCameraTo(GAME2_X,GAME2_Y,50); 
			break;
		case "GAME3" : 
			mWindow.executeAction(mGame3, "start");
			moveCameraTo(GAME3_X,GAME3_Y,40); 
			break;
*/		}
	}
	
	public void moveCameraTo(int toX, int toY, int steps) {
		double windowX = mWindow.getCameraX();
		double windowY = mWindow.getCameraY();
		double dx = (toX-windowX)/steps;
		double dy = (toY-windowY)/steps;
		for(int i=1; i<=steps; i++) {
			windowX += dx;
			windowY += dy;
			mWindow.setCameraXY((int)Math.round(windowX), (int)Math.round(windowY));
			PaintWindow_GU2.pause(20);
		}
	}
	
	public void exit() {
		System.exit(0);
	}

}

package controller;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;

import paintpanel.Text;
import gu2.PaintWindow_GU2;

public class MainMenu {
	private PaintWindow_GU2 mWindow;
	private StartGamePanel mController;
	
	public MainMenu(PaintWindow_GU2 window, StartGamePanel controller, int x, int y) {
		Font font = new Font("SansSerif",Font.PLAIN,48);
		mWindow = window;
		mController = controller;
		ImageIcon btnMenu1 = StartApp.getImageIcon("/mainmenu/images/black_button.png");
		ImageIcon btnMenu2 = StartApp.getImageIcon("/mainmenu/images/black_button.png");
		ImageIcon btnMenu3 = StartApp.getImageIcon("/mainmenu/images/black_button.png");
		ImageIcon btnMenu4 = StartApp.getImageIcon("/mainmenu/images/black_button.png");
		Text txtGame1 = new Text("Game 1", font, Color.WHITE);
		Text txtGame2 = new Text("Game 2", font, Color.LIGHT_GRAY);
		Text txtGame3 = new Text("Game 3", font, Color.YELLOW);
		Text txtExit = new Text("Avsluta", font, Color.GREEN);
		
		mWindow.addIcon(btnMenu1, x+100, y+40, true);
		mWindow.addText(txtGame1, x+120, y+60);
		mWindow.addIcon(btnMenu2, x+100, y+180, true);
		mWindow.addText(txtGame2, x+120, y+200);
		mWindow.addIcon(btnMenu3, x+100, y+320, true);
		mWindow.addText(txtGame3, x+120, y+340);
		mWindow.addIcon(btnMenu4, x+100, y+460, true);
		mWindow.addText(txtExit, x+120, y+480);
		
		mWindow.setIconAction(btnMenu1, this, "game1");
		mWindow.setIconAction(btnMenu2, this, "game2");
		mWindow.setIconAction(btnMenu3, this, "game3");
		mWindow.setIconAction(btnMenu4, this, "exit");
	}
	
	public void game1() {
		mController.moveCameraTo("GAME1");
	}
	
	public void game2() {
		mController.moveCameraTo("GAME2");
	}
	
	public void game3() {
		mController.moveCameraTo("GAME3");
	}
	
	public void exit() {
		mController.exit();
	}
}









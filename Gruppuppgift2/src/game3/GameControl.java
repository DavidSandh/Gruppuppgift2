package game3;

import java.awt.Color;

import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import controller.StartApp;
import controller.StartGamePanel;
import game2.Controller;
import gu2.PaintWindow_GU2;
import paintpanel.Text;

/**
 * Klassen GameControl skapar spelet med hjälp av PainWindow. 
 * @author Lykke Levin & Amin Harirchian
 *
 */
public class GameControl {
	private StartGamePanel controller;
	private int x, y;
	
	private PaintWindow_GU2 window;
	private Girl girl = new Girl((StartApp.getImageIcon("/game3/images/girl.png")));
	private int counter = 0;
	private Text text1;
	private Numbers numbers1;
	ImageIcon home = (StartApp.getImageIcon("/game3/images/home.png"));
	ImageIcon background1 = (StartApp.getImageIcon("/game3/images/loading1.jpg"));
	ImageIcon background2 = (StartApp.getImageIcon("/game3/images/loading2.jpg"));
	ImageIcon background3 = (StartApp.getImageIcon("/game3/images/loading3.jpg"));
	ImageIcon background4 = (StartApp.getImageIcon("/game3/images/loading4.jpg"));
	ImageIcon background5 = (StartApp.getImageIcon("/game3/images/loading5.jpg"));
	ImageIcon winBackground = (StartApp.getImageIcon("/game3/images/win.jpg"));
	ImageIcon loseBackground = (StartApp.getImageIcon("/game3/images/lose.jpg"));
	ImageIcon girl1 = (StartApp.getImageIcon("/game3/images/girl.png"));
	ImageIcon girl2 = (StartApp.getImageIcon("/game3/images/girl.png"));
	ImageIcon girl3 = (StartApp.getImageIcon("/game3/images/girl.png"));

	ImageIcon wild1 = (StartApp.getImageIcon("/game3/images/wild1.png"));
	ImageIcon wild2 = (StartApp.getImageIcon("/game3/images/wild2.png"));
	ImageIcon wild3 = (StartApp.getImageIcon("/game3/images/wild3.png"));
	ImageIcon wild4 = (StartApp.getImageIcon("/game3/images/wild4.png"));
	ImageIcon tree1 = (StartApp.getImageIcon("/game3/images/tree1.png"));
	ImageIcon tree2 = (StartApp.getImageIcon("/game3/images/tree2.png"));
	ImageIcon[] backgrounds = { background1, background2, background3, background4, background5, winBackground,
			loseBackground };
	ImageIcon[] enemies = { wild1, wild2, wild3, wild4 };
	ImageIcon rock = (StartApp.getImageIcon("/game3/images/rock.png"));

	ImageIcon forest1 = (StartApp.getImageIcon("/game3/images/forest1.png"));
	ImageIcon forest2 = (StartApp.getImageIcon("/game3/images/forest2.png"));
	ImageIcon forest3 = (StartApp.getImageIcon("/game3/images/forest3.png"));
	ImageIcon forest4 = (StartApp.getImageIcon("/game3/images/forest4.png"));
	ImageIcon forest5 = (StartApp.getImageIcon("/game3/images/forest5.png"));
	Font font = new Font("Monospaced", Font.PLAIN, 50);
	ImageIcon btnPlay = (StartApp.getImageIcon("/game3/images/btnplay.png"));
	ImageIcon btnRight = (StartApp.getImageIcon("/game3/images/btnright.png"));
	ImageIcon btnLeft = (StartApp.getImageIcon("/game3/images/btnleft.png"));
	ImageIcon btnUp = (StartApp.getImageIcon("/game3/images/btnup.png"));
	ImageIcon btnDown = (StartApp.getImageIcon("/game3/images/btndown.png"));

	ImageIcon btnClose = (StartApp.getImageIcon("/game3/images/btnclose.png"));
	public GameControl(PaintWindow_GU2 window, StartGamePanel startgamepanel, int x, int y) {
		this.controller = startgamepanel;
		this.window = window;
		this.x = x;
		this.y = y;
		initButtons();
		game();
	}
	public void initButtons() {
		window.setIconAction(btnUp, this, "up");
		window.setIconAction(btnDown, this, "down");
		window.setIconAction(btnLeft, this, "left");
		window.setIconAction(btnRight, this, "right");
		window.setIconAction(btnPlay, this, "playButton");
		window.setIconAction(btnClose, this, "closeButton");
	}
	public void game() {
		//window = new PaintWindow_GU2(800, 600, "Get Home", Color.GRAY);
		counter = 0;
		initButtons();
		window.addIcon(backgrounds[0], x+0, y+0, true);
		window.pause(1000);
		window.addIcon(backgrounds[1], x+0, y+0, true);
		window.pause(1000);
		window.addIcon(backgrounds[2], x+0, y+0, true);
		window.pause(1000);
		window.addIcon(backgrounds[3], x+0, y+0, true);
		window.pause(1000);
		window.addIcon(backgrounds[4], x+0, y+0, true);

		window.pause(500);
		remove();
		window.addIcon(home, x+660, y+20, true);
		window.addIcon(girl1, x+10, y+10, true);
		window.addIcon(girl2, x+100, y+10, true);
		window.addIcon(girl3, x+190, y+10, true);
		window.fillRect(x+0, y+450, 200, 120, Color.green);
		window.fillRect(x+200, y+350, 120, 220, Color.green);
		window.fillRect(x+300, y+350, 170, 120, Color.green);
		window.fillRect(x+350, y+100, 120, 250, Color.green);
		window.fillRect(x+450, y+200, 200, 120, Color.green);
		window.fillRect(x+650, y+100, 120, 220, Color.green);
		window.setIconXY(girl.getImage(), x+20, y+470);
		window.addIcon(girl.getImage(), x+20, y+470, true);
		girl.moveTo(x+20,y+470);
		
		window.addIcon(tree2, x+270, y+450, true);
		window.addIcon(tree1, x+460, y+340, true);
		window.addIcon(rock, x+380, y+100, true);
		window.addIcon(btnPlay, x+50, y+100, true);
		window.addIcon(btnClose, x+200, y+100, true);
		window.addIcon(btnUp, x+650, y+440, true);
		window.addIcon(btnDown, x+650, y+525, true);
		window.addIcon(btnRight, x+700, y+480, true);
		window.addIcon(btnLeft, x+595, y+480, true);

		window.addIcon(forest1, x+-3, y+340, true);
		window.addIcon(forest2, x+190, y+0, true);
		window.addIcon(forest4, x+467, y+63, true);
		window.addIcon(forest3, x+320, y+50, true);
		window.addIcon(forest5, x+737, y+10, true);

		window.addIcon(enemies[0], x+430, y+180, true);
		window.addIcon(enemies[1], x+670, y+250, true);
		window.addIcon(enemies[2], x+200, y+350, true);
		window.addIcon(enemies[3], x+400, y+400, true);

		text1 = new Text("60", font, Color.BLACK, Color.GRAY);
	}

	public void right() {

		for (int i = 1; i <= 5; i++) {
			int x1, y1;
			x1 = girl.getX() + i;
			y1 = girl.getY();
			window.setIconXY(girl.getImage(), x1, y1);
			window.addIcon(girl.getImage(), x1,y1, true);
			girl.moveTo(x1, y1);
			window.pause(20);

		}
		if ((girl.getX() >= x+280) && (girl.getY() <= y+510 && girl.getY() >= y+450)
				|| (girl.getX() >= x+450) && (girl.getY() <= y+470 && girl.getY() >= y+270)
				|| (girl.getX() >= x+740) && (girl.getY() <= y+280 && girl.getY() >= y+30)) {
			
			counter++;
			lose();
		}
		// Buffel
		if ((girl.getY() >= y+350 && girl.getY() <= y+420 && girl.getX() >= x+375 && girl.getX() <= x+476)) {
			
			counter++;
			lose();
		}
		// Bock
		if (((girl.getY() >= y+170 && girl.getY() <= y+200) && (girl.getX() <= x+475 && girl.getX() >= x+400))) {
			
			counter++;
			lose();
		}
		// Varg
		if ((girl.getY() >= y+205 && girl.getY() <= y+285) && (girl.getX() >= x+635 && girl.getX() <= x+752)) {
			
			counter++;
			lose();
		}

	}

	public void left() {
		for (int i = 1; i <= 5; i++) {
			int x1, y1;
			x1 = girl.getX() - i;
			y1 = girl.getY();

			window.setIconXY(girl.getImage(), x1, y1);
			window.addIcon(girl.getImage(), x1, y1, true);
			girl.moveTo(x1, y1);
			window.pause(20);

		}
		if ((girl.getX() <= x+-50) || ((girl.getX() <= x+160) && (girl.getY() <= y+450 && girl.getY() >= y+280))
				|| ((girl.getX() <= x+300) && (girl.getY() <= y+280 && girl.getY() >= y+30))
				|| ((girl.getX() <= x+620 && girl.getX() >= x+600) && (girl.getY() <= y+140 && girl.getY() >= y+30))) {
			
			counter++;
			lose();
		}
		if ((girl.getY() <= y+375 && girl.getY() >= y+350) && (girl.getX() <= x+250 && girl.getX() >= x+200)) {
			
			counter++;
			lose();
		}
		if (((girl.getY() >= y+170 && girl.getY() <= y+200) && (girl.getX() <= x+475 && girl.getX() >= x+400))) {
			
			counter++;
			lose();
		}
	}

	public void down() {
		for (int i = 1; i <= 5; i++) {
			int x1, y1;
			x1 = girl.getX();
			y1 = girl.getY() + i;

			window.setIconXY(girl.getImage(), x1, y1);
			window.addIcon(girl.getImage(), x1, y1, true);
			girl.moveTo(x1, y1);
			window.pause(20);

		}

		if ((girl.getY() >= y+510) && (girl.getX() >= x+0 && girl.getX() <= x+300)
				|| (girl.getY() >= y+410 && (girl.getX() >= x+300 && girl.getX() <= x+550))
				|| (girl.getY() >= y+250) && (girl.getX() >= x+450 && girl.getX() <= x+710)) {

			
			counter++;
			lose();

		}
		if ((girl.getY() >= y+370 && girl.getY() <= y+400) && (girl.getX() >= x+360 && girl.getX() <= x+476)) {
			
			counter++;
			lose();
		}
		if ((girl.getY() >= y+205 && girl.getY() <= y+285) && (girl.getX() >= x+650 && girl.getX() <= x+752)) {
			
			counter++;
			lose();
		}

	}

	public void up() {
		for (int i = 1; i <= 5; i++) {
			int x1, y1;
			x1 = girl.getX();
			y1 = girl.getY() - i;

			window.setIconXY(girl.getImage(), x1, y1);
			window.addIcon(girl.getImage(), x1, y1, true);
			girl.moveTo(x1, y1);
			window.pause(20);

		}

		if ((girl.getY() <= y+380) && (girl.getX() >= x+0 && girl.getX() <= x+145)
				|| (girl.getY() <= y+280) && (girl.getX() >= x+200 && girl.getX() <= x+280)
				|| (girl.getY() <= y+40) && (girl.getX() >= x+290 && girl.getX() <= x+460)
				|| (girl.getY() <= y+130) && (girl.getX() >= x+450 && girl.getX() <= x+620)) {
			
			counter++;
			lose();
		}
		if (girl.getY() <= y+20 && girl.getX() > x+600 && girl.getX() <= x+700) {
			win();
		}
		if ((girl.getY() <= y+375 && girl.getY() >= y+350) && (girl.getX() <= x+272 && girl.getX() >= x+200)) {
			
			counter++;
			lose();
		}

		if ((girl.getY() >= y+190 && girl.getY() <= y+235 && girl.getX() >= x+430 && girl.getX() <= x+498)) {
			
			counter++;
			lose();
		}

	}

	public void playButton() {
		game();
		init();
		//time();
	}

	public void closeButton() {
		remove();
		controller.menu();
	}

	public void lose() {

		if (counter == 1) {
			window.removeIcon(girl3);

		} else if (counter == 2) {
			window.removeIcon(girl2);
		} else if (counter == 3) {
			window.removeIcon(girl1);
		}

		else if (counter > 3) {
			remove();
			window.addIcon(backgrounds[6], x+0, y+0, true);
			window.addIcon(btnPlay, x+50, y+100, true);
			window.addIcon(btnClose, x+200, y+100, true);
		}

	}
	private void init() {	
		
		numbers1 = new Numbers(60,60,-1);
		text1.setText("60");
		
	}

/*	public void time() {
		int nbr;
		window.addText(text1, x+550, y+20);
		//PaintWindow_GU2.pause(1000);
		for(int i=60;i>=0;i-- ) {
			nbr = numbers1.nextValue();
			text1.setText( String.format("%2d",nbr) );
			
			if(nbr==0) {
				remove();
				window.addIcon(backgrounds[6], x+0, y+0, true);
				window.addIcon(btnClose, x+50, y+100, true);
			}
     		PaintWindow_GU2.pause(1000);	
		}
	}*/

	public void win() {
		remove();
		window.addIcon(backgrounds[5], x+0, y+0, true);
		window.addIcon(btnPlay, x+50, y+100, true);
		window.addIcon(btnClose, x+200, y+100, true);
	}

	public void remove() {
		window.removeIcon(home);
		for(ImageIcon elem : backgrounds) {
			window.removeIcon(elem);
			}
		window.removeIcon(background1);
		window.removeIcon(background2);
		window.removeIcon(background3);
		window.removeIcon(background4);
		window.removeIcon(background5);
		window.removeIcon(winBackground);
		window.removeIcon(loseBackground);
		for(ImageIcon elem : enemies) {
			window.removeIcon(elem);
			}
		window.removeIcon(girl);
		window.removeIcon(girl1);
		window.removeIcon(girl2);
		window.removeIcon(girl3);
		window.removeIcon(tree1);
		window.removeIcon(tree2);
		window.removeIcon(btnPlay);
		window.removeIcon(rock);
		window.removeIcon(forest1);
		window.removeIcon(forest2);
		window.removeIcon(forest3);
		window.removeIcon(forest4);
		window.removeIcon(forest5);
		window.removeIcon(btnRight);
		window.removeIcon(btnLeft);
		window.removeIcon(btnUp);
		window.removeIcon(btnClose); 
	}
}

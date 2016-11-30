package game2;

import java.awt.Window;

import javax.swing.ImageIcon;

import controller.StartApp;
import controller.StartGamePanel;
import gu2.PaintWindow_GU2;
import paintpanel.Text;

public class Game2 {
	Controller controller;
	private StartGamePanel startgamepanel;
	
	private PaintWindow_GU2 window;
	
	private int[] tossCount = new int[6];
	private int[] toss = new int[5];
	
	private ImageIcon one;
	private ImageIcon two;
	private ImageIcon three;
	private ImageIcon four;
	private ImageIcon five;
	
	// För att flera objekt ska kunna ha samma image objekt som bild i paintwindow så måste det finnas 5 unika versioner av alla bilder.
	
	private ImageIcon onePNG1 = StartApp.getImageIcon("/game2/images/Etta.png");
	private ImageIcon twoPNG1 = StartApp.getImageIcon("/game2/images/Two.png");
	private ImageIcon threePNG1 = StartApp.getImageIcon("/game2/images/Trea.png");
	private ImageIcon fourPNG1 = StartApp.getImageIcon("/game2/images/Fyra.png");
	private ImageIcon fivePNG1 = StartApp.getImageIcon("/game2/images/Femma.png");
	private ImageIcon sixPNG1 = StartApp.getImageIcon("/game2/images/Sexa.png");
	
	private ImageIcon onePNG2 = StartApp.getImageIcon("/game2/images/Etta.png");
	private ImageIcon twoPNG2 = StartApp.getImageIcon("/game2/images/Two.png");
	private ImageIcon threePNG2 = StartApp.getImageIcon("/game2/images/Trea.png");
	private ImageIcon fourPNG2 = StartApp.getImageIcon("/game2/images/Fyra.png");
	private ImageIcon fivePNG2 = StartApp.getImageIcon("/game2/images/Femma.png");
	private ImageIcon sixPNG2 = StartApp.getImageIcon("/game2/images/Sexa.png");
	
	private ImageIcon onePNG3 = StartApp.getImageIcon("/game2/images/Etta.png");
	private ImageIcon twoPNG3 = StartApp.getImageIcon("/game2/images/Two.png");
	private ImageIcon threePNG3 = StartApp.getImageIcon("/game2/images/Trea.png");
	private ImageIcon fourPNG3 = StartApp.getImageIcon("/game2/images/Fyra.png");
	private ImageIcon fivePNG3 = StartApp.getImageIcon("/game2/images/Femma.png");
	private ImageIcon sixPNG3 = StartApp.getImageIcon("/game2/images/Sexa.png");
	
	private ImageIcon onePNG4 = StartApp.getImageIcon("/game2/images/Etta.png");
	private ImageIcon twoPNG4 = StartApp.getImageIcon("/game2/images/Two.png");
	private ImageIcon threePNG4 = StartApp.getImageIcon("/game2/images/Trea.png");
	private ImageIcon fourPNG4 = StartApp.getImageIcon("/game2/images/Fyra.png");
	private ImageIcon fivePNG4 = StartApp.getImageIcon("/game2/images/Femma.png");
	private ImageIcon sixPNG4 = StartApp.getImageIcon("/game2/images/Sexa.png");
	
	private ImageIcon onePNG5 = StartApp.getImageIcon("/game2/images/Etta.png");
	private ImageIcon twoPNG5 = StartApp.getImageIcon("/game2/images/Two.png");
	private ImageIcon threePNG5 = StartApp.getImageIcon("/game2/images/Trea.png");
	private ImageIcon fourPNG5 = StartApp.getImageIcon("/game2/images/Fyra.png");
	private ImageIcon fivePNG5 = StartApp.getImageIcon("/game2/images/Femma.png");
	private ImageIcon sixPNG5 = StartApp.getImageIcon("/game2/images/Sexa.png");

	
	private ImageIcon btnThrowDice = StartApp.getImageIcon("/game2/images/kastatarning.png");
	private ImageIcon btnNewGame = StartApp.getImageIcon("/game2/images/nyttspel.png");
	private ImageIcon btnExit = StartApp.getImageIcon("/game2/images/avsluta.png");
	
	private int x, y;
	
	
	public Game2(PaintWindow_GU2 window, StartGamePanel startgamepanel, int x, int y) {
		controller = new Controller(startgamepanel);
		this.window = window;
		this.startgamepanel = startgamepanel;
		this.x = x;
		this.y = y;
		runGame();
		
	}
	public void runGame(){
		controller.throwDice(toss, tossCount); //kastar tärningen 5 gånger och räknar in kasten i en array.
		boolean[] picked = controller.getPicked();
		
		int counter = 0;
		
		for(int i=0; i<picked.length; i++){
			if(picked[i] == true){
				counter++;
			}
		}
		//En lång radda if else satser som kollar igenom arrayen med kast och sätter en bild passande kastet.
		if (toss[0] == 1){
			setPictureOne(onePNG1);
		}
		else if(toss[0] == 2){
			setPictureOne(twoPNG1);
		}
		else if(toss[0] == 3){
			setPictureOne(threePNG1);
		}
		else if(toss[0] == 4){
			setPictureOne(fourPNG1);
		}
		else if(toss[0] == 5){
			setPictureOne(fivePNG1);
		}
		else if(toss[0] == 6){
			setPictureOne(sixPNG1);
		}
		
		if (toss[1] == 1){
			setPictureTwo(onePNG2);
		}
		else if(toss[1] == 2){
			setPictureTwo(twoPNG2);
		}
		else if(toss[1] == 3){
			setPictureTwo(threePNG2);
		}
		else if(toss[1] == 4){
			setPictureTwo(fourPNG2);
		}
		else if(toss[1] == 5){
			setPictureTwo(fivePNG2);
		}
		else if(toss[1] == 6){
			setPictureTwo(sixPNG2);
		}
		
		if (toss[2] == 1){
			setPictureThree(onePNG3);
		}
		else if(toss[2] == 2){
			setPictureThree(twoPNG3);
		}
		else if(toss[2] == 3){
			setPictureThree(threePNG3);
		}
		else if(toss[2] == 4){
			setPictureThree(fourPNG3);
		}
		else if(toss[2] == 5){
			setPictureThree(fivePNG3);
		}
		else if(toss[2] == 6){
			setPictureThree(sixPNG3);
		}
		
		if (toss[3] == 1){
			setPictureFour(onePNG4);
		}
		else if(toss[3] == 2){
			setPictureFour(twoPNG4);
		}
		else if(toss[3] == 3){
			setPictureFour(threePNG4);
		}
		else if(toss[3] == 4){
			setPictureFour(fourPNG4);
		}
		else if(toss[3] == 5){
			setPictureFour(fivePNG4);
		}
		else if(toss[3] == 6){
			setPictureFour(sixPNG4);
		}
		
		if (toss[4] == 1){
			setPictureFive(onePNG5);
		}
		else if(toss[4] == 2){
			setPictureFive(twoPNG5);
		}
		else if(toss[4] == 3){
			setPictureFive(threePNG5);
		}
		else if(toss[4] == 4){
			setPictureFive(fourPNG5);
		}
		else if(toss[4] == 5){
			setPictureFive(fivePNG5);
		}
		else if(toss[4] == 6){
			setPictureFive(sixPNG5);
		}	

		// Ritar upp tre bilder på kasta tärningar, nytt spel, avsluta.
		window.addIcon(btnThrowDice, x+0, y+90, true);
		window.addIcon(btnNewGame, x+200, y+90, true);
		window.addIcon(btnExit, x+100, y+140, true);
		//Ger bilden kastatärningar funktionen att köra hela spelet om igen.
		window.setIconAction(btnThrowDice, this, "runGame");
		//Ger bilden nytt spel funktionen att starta om spelet samt skapa ett nytt.
		window.setIconAction(btnNewGame, this, "newGame");
		//Ger bilden avsluta funktionen att stänga av programmet.
		window.setIconAction(btnExit, this.controller, "exit");
		// Tar bort bilderna på de fem olika tärningar(behövs för att de ska kunna "updateras" vid tryck på knappen.
		window.removeIcon(one);
		window.removeIcon(two);
		window.removeIcon(three);
		window.removeIcon(four);
		window.removeIcon(five);
		// Lägger till fem bilder på de fem olika tärningarna som kastats.
		window.addIcon(one, x+65, y+30, true);
		window.addIcon(two, x+115, y+30, true);
		window.addIcon(three, x+165, y+30, true);
		window.addIcon(four, x+215, y+30, true);
		window.addIcon(five, x+265, y+30, true);
		
		window.setIconAction(one, this.controller, "setOneTrue");
		window.setIconAction(two, this.controller, "setTwoTrue");
		window.setIconAction(three, this.controller, "setThreeTrue");
		window.setIconAction(four, this.controller, "setFourTrue");
		window.setIconAction(five, this.controller, "setFiveTrue");
		}
	
	public void newGame(){
		for(int i=0; i<toss.length; i++){
			toss[i] = 0;
		}
		controller.newGame();
		runGame();
	}
	
	public void setPictureOne(ImageIcon one){
		this.one = one;
	}
	public void setPictureTwo(ImageIcon two){
		this.two = two;
	}
	public void setPictureThree(ImageIcon three){
		this.three = three;
	}
	public void setPictureFour(ImageIcon four){
		this.four = four;
	}
	public void setPictureFive(ImageIcon five){
		this.five = five;
	}
	
}

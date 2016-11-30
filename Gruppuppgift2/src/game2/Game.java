package yatzy;

import java.awt.Window;

import javax.swing.ImageIcon;

import gu2.PaintWindow_GU2;
import paintpanel.Text;

public class Game {
	
	Controller controller = new Controller();
	
	private PaintWindow_GU2 window = new PaintWindow_GU2(380,300, "p2", null, 0,0);
	
	private int[] tossCount = new int[6];
	private int[] toss = new int[5];
	
	private ImageIcon one;
	private ImageIcon two;
	private ImageIcon three;
	private ImageIcon four;
	private ImageIcon five;
	
	// För att flera objekt ska kunna ha samma image objekt som bild i paintwindow så måste det finnas 5 unika versioner av alla bilder.
	
	private ImageIcon onePNG1 = new ImageIcon("images/Etta.png");
	private ImageIcon twoPNG1 = new ImageIcon("images/Tvåa.png");
	private ImageIcon threePNG1 = new ImageIcon("images/Trea.png");
	private ImageIcon fourPNG1 = new ImageIcon("images/Fyra.png");
	private ImageIcon fivePNG1 = new ImageIcon("images/Femma.png");
	private ImageIcon sixPNG1 = new ImageIcon("images/Sexa.png");
	
	private ImageIcon onePNG2 = new ImageIcon("images/Etta.png");
	private ImageIcon twoPNG2 = new ImageIcon("images/Tvåa.png");
	private ImageIcon threePNG2 = new ImageIcon("images/Trea.png");
	private ImageIcon fourPNG2 = new ImageIcon("images/Fyra.png");
	private ImageIcon fivePNG2 = new ImageIcon("images/Femma.png");
	private ImageIcon sixPNG2 = new ImageIcon("images/Sexa.png");
	
	private ImageIcon onePNG3 = new ImageIcon("images/Etta.png");
	private ImageIcon twoPNG3 = new ImageIcon("images/Tvåa.png");
	private ImageIcon threePNG3 = new ImageIcon("images/Trea.png");
	private ImageIcon fourPNG3 = new ImageIcon("images/Fyra.png");
	private ImageIcon fivePNG3 = new ImageIcon("images/Femma.png");
	private ImageIcon sixPNG3 = new ImageIcon("images/Sexa.png");
	
	private ImageIcon onePNG4 = new ImageIcon("images/Etta.png");
	private ImageIcon twoPNG4 = new ImageIcon("images/Tvåa.png");
	private ImageIcon threePNG4 = new ImageIcon("images/Trea.png");
	private ImageIcon fourPNG4 = new ImageIcon("images/Fyra.png");
	private ImageIcon fivePNG4 = new ImageIcon("images/Femma.png");
	private ImageIcon sixPNG4 = new ImageIcon("images/Sexa.png");
	
	private ImageIcon onePNG5 = new ImageIcon("images/Etta.png");
	private ImageIcon twoPNG5 = new ImageIcon("images/Tvåa.png");
	private ImageIcon threePNG5 = new ImageIcon("images/Trea.png");
	private ImageIcon fourPNG5 = new ImageIcon("images/Fyra.png");
	private ImageIcon fivePNG5 = new ImageIcon("images/Femma.png");
	private ImageIcon sixPNG5 = new ImageIcon("images/Sexa.png");

	private ImageIcon y1 = new ImageIcon("images/y.png");
	private ImageIcon y2 = new ImageIcon("images/y.png");
	private ImageIcon a = new ImageIcon("images/a.png");
	private ImageIcon t = new ImageIcon("images/t.png");
	private ImageIcon z = new ImageIcon("images/z.png");
	
	private ImageIcon btnThrowDice = new ImageIcon("images/kastatarning.png");
	private ImageIcon btnNewGame = new ImageIcon("images/nyttspel.png");
	private ImageIcon btnExit = new ImageIcon("images/avsluta.png");
	
	public void runGame(){
		
		controller.throwDice(toss, tossCount); //kastar tärningen 5 gånger och räknar in kasten i en array.
		
		boolean[] picked = controller.getPicked();
		
		int counter = 0;
		
		for(int i=0; i<picked.length; i++){
			if(picked[i] == true){
				counter++;
			}
		}
		//OBS inte klar!!
		if(counter == 5){
			window.addIcon(y1, 65, 30, true);
			window.addIcon(a, 115, 30, true);
			window.addIcon(t, 165, 30, true);
			window.addIcon(z, 215, 30, true);
			window.addIcon(y2, 265, 30, true);
		}
		else{
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
		window.addIcon(btnThrowDice, 0, 90, true);
		window.addIcon(btnNewGame, 200, 90, true);
		window.addIcon(btnExit, 100, 140, true);
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
		window.addIcon(one, 65, 30, true);
		window.addIcon(two, 115, 30, true);
		window.addIcon(three, 165, 30, true);
		window.addIcon(four, 215, 30, true);
		window.addIcon(five, 265, 30, true);
		
		window.setIconAction(one, this.controller, "setOneTrue");
		window.setIconAction(two, this.controller, "setTwoTrue");
		window.setIconAction(three, this.controller, "setThreeTrue");
		window.setIconAction(four, this.controller, "setFourTrue");
		window.setIconAction(five, this.controller, "setFiveTrue");
		}
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
	
	public static void main(String[]args){
		Game game = new Game();
		game.runGame();
	}
}

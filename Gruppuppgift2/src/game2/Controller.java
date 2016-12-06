package game2;

import java.awt.Color;
import java.util.Random;

import javax.swing.ImageIcon;

import controller.StartGamePanel;
import gu2.PaintWindow_GU2;


public class Controller {
	
	private Game2 game;
	private StartGamePanel startgamepanel;
	
	private boolean[] picked = new boolean[5];
	
	public Controller(StartGamePanel startgamepanel) {
		this.startgamepanel = startgamepanel;
	}

	public void throwDice(int[] toss, int[] tossCount){
		Random rand = new Random();
		int temp = 0;
		for(int i=0; i<toss.length; i++){
			if(picked[i] == true){ // Kontrollerar om tärningen har blivit vald att behållas.
				
			}
			else{
				toss[i] = rand.nextInt(6)+1;
			}
		}	
	}
	
	//Ett gäng metoder som sätter bestämd tärning till sann (alltså ska behållas)
	public void setOneTrue(){
		if(picked[0]==true){
			picked[0] = false;
		}
		else{
			picked[0] = true;
		}
	}
	public void setTwoTrue(){
		if(picked[1]==true){
			picked[1] = false;
		}
		else{
			picked[1] = true;
		}
	}
	public void setThreeTrue(){
		if(picked[2]==true){
			picked[2] = false;
		}
		else{
			picked[2] = true;
		}
	}
	public void setFourTrue(){
		if(picked[3]==true){
			picked[3] = false;
		}
		else{
			picked[3] = true;
		}
	}
	public void setFiveTrue(){
		if(picked[4]==true){
			picked[4] = false;
		}
		else{
			picked[4] = true;
		}
	}
	
	public void newGame(){
		for(int i=0; i<picked.length; i++){
			picked[i] = false;
		}
	}
	
	public void exit(){
		startgamepanel.menu();
	}
	
	public void checkForYatzy(int array[], int arrayCounter[]){
		int temp;
		for(int i = 0; i<arrayCounter.length; i++){
			arrayCounter[i] = 0;
		}
		for(int i = 0; i<array.length; i++){
			temp = array[i];
			arrayCounter[temp-1]++;
		}
	}
}

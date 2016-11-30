package yatzy;

import java.awt.Color;
import java.util.Random;

import javax.swing.ImageIcon;

import gu2.PaintWindow_GU2;


public class Controller {
	
	private Game game;
	
	private boolean[] picked = new boolean[5];
	
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
	
	public boolean[] getPicked(){
		return picked;
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
		System.exit(0);
	}
	
	public void checkForYatzy(int array[]){
		String temp = "Du har inte fått yatzy";
		for(int i=0; i<array.length; i++){
			if(array[i] == 5){
				temp = "Du har fått yatzy";
			}
		}
		System.out.print(temp);
	}
}

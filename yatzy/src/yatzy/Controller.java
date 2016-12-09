package yatzy;

import java.awt.Image;
import java.lang.reflect.Array;
import java.util.Arrays;
import javax.swing.ImageIcon;

/**
* Controller klass för Yatzy som tar hand om knapptryckningarna som sker på userinput samt bestämmer
* och skickar iväg de nya tärningarna som visas på viewern 
public class Controller {

	private Viewer viewer;
	
	private ImageIcon onePNG = new ImageIcon(getClass().getResource("/resources/Etta.png"));
	private ImageIcon twoPNG = new ImageIcon(getClass().getResource("/resources/Tvåa.png"));
	private ImageIcon threePNG = new ImageIcon(getClass().getResource("/resources/Trea.png"));
	private ImageIcon fourPNG = new ImageIcon(getClass().getResource("/resources/Fyra.png"));
	private ImageIcon fivePNG = new ImageIcon(getClass().getResource("/resources/Femma.png"));
	private ImageIcon sixPNG = new ImageIcon(getClass().getResource("/resources/Sexa.png"));

	private int counter = 0;
	
	public Controller(Viewer viewer) {
		this.viewer = viewer;
	}
	//En metod som simulerar ett tärningskast
	public int tossDice(){
		return (int)(Math.random()*6+1);
	}
	//En metod som stänger ner spelet
	public void exit(){
		System.exit(0);
	}
	//En metod som nollställer counter.
	public void resetCounter(){
		counter = 0;
	}
	// En metod som skapar ett nytt spel tar bort alla nersparade värden samt tärningarna.
	public void newGame(){
		
		int player[] = viewer.getPlayer();
		
		for(int i = 0; i<player.length; i++){
			player[i] = 0;
		}
		viewer.setPoints(0);
		viewer.setDieOne(null);
		viewer.setDieTwo(null);
		viewer.setDieThree(null);
		viewer.setDieFour(null);
		viewer.setDieFive(null);
		setBoxesFalse();
		
		viewer.setBoxesEnabled();
		
		viewer.setPair("");
		viewer.setTwoPair("");
		viewer.setThrees("");
		viewer.setFours("");
		viewer.setTinyStraight("");
		viewer.setBigStraight("");
		viewer.setFullHouse("");
		viewer.setYatzy("");
		
		viewer.setCounter(0);
		
	}
	// En metod som sätter alla boxes till false
	public void setBoxesFalse() {
		viewer.setBoxesFalse();
	}
	
	//En metod med reglerna samt sätter poängen för par
	public void setPairScore(){
		
		boolean[] checkChecker = new boolean[5];
		int[] player = viewer.getPlayer();
		int points = viewer.getPoints();
		String temp = "";
		
		if(viewer.getBox1() == true && counter < 2){
			points += player[0];
			counter++;
			checkChecker[0] = true;
		}
		if(viewer.getBox2() == true && counter < 2){
			points += player[1];
			counter++;
			checkChecker[1] = true;
		}
		if(viewer.getBox3() == true && counter < 2){
			points += player[2];
			counter++;
			checkChecker[2] = true;
		}
		if(viewer.getBox4() == true && counter < 2){
			points += player[3];
			counter++;
			checkChecker[3] = true;
		}
		if(viewer.getBox5() == true && counter < 2){
			points += player[4];
			counter++;
			checkChecker[4] = true;
		}
		
		for(int i=0; i<5; i++){
			if(checkChecker[i] == true){
				temp += player[i];
			}
		}
		if(temp.equals("11")){
			viewer.setPoints(points);
		}
		else if(temp.equals("22")){
			viewer.setPoints(points);
		}
		else if(temp.equals("33")){
			viewer.setPoints(points);
		}
		else if(temp.equals("44")){
			viewer.setPoints(points);
		}
		else if(temp.equals("55")){
			viewer.setPoints(points);
		}
		else if(temp.equals("66")){
			viewer.setPoints(points);
		}
		else{
			viewer.setPoints(viewer.getPoints());
		}
		
		viewer.setPair("Par");
		
	}
	//En metod med regler som också sätter poäng för två par
	public void setTwoPairScore(){
		
		boolean[] checkChecker = new boolean[5];
		int[] player = viewer.getPlayer();
		int[] tossCounter = new int[6];
		int points = viewer.getPoints();
		int temp = 0;
		
		
		if(viewer.getBox1() == true && counter < 4){
			points += player[0];
			counter++;
			checkChecker[0] = true;
		}
		if(viewer.getBox2() == true && counter < 4){
			points += player[1];
			counter++;
			checkChecker[1] = true;
		}
		if(viewer.getBox3() == true && counter < 4){
			points += player[2];
			counter++;
			checkChecker[2] = true;
		}
		if(viewer.getBox4() == true && counter < 4){
			points += player[3];
			counter++;
			checkChecker[3] = true;
		}
		if(viewer.getBox5() == true && counter < 4){
			points += player[4];
			counter++;
			checkChecker[4] = true;
		}
		
		for(int i=0; i<5; i++){
			if(checkChecker[i] == true){
				if(player[i] == 1){
					tossCounter[0] ++;
				}
				if(player[i] == 2){
					tossCounter[1] ++;
				}
				if(player[i] == 3){
					tossCounter[2] ++;
				}
				if(player[i] == 4){
					tossCounter[3] ++;
				}
				if(player[i] == 5){
					tossCounter[4] ++;
				}
				if(player[i] == 6){
					tossCounter[5] ++;
				}
			}
		}
		for(int i=0; i<5; i++){
			if(tossCounter[i] == 2){
				temp++;
			}
		}
		if(tossCounter[5] == 2){
			temp++;
		}
		if(temp == 2){
			viewer.setPoints(points);
		}
		else{
			viewer.setPoints(viewer.getPoints());
		}
		
		viewer.setTwoPair("Två par");
		
	}
	//En metod med regler samt som sätter poäng för tretal
	public void setThreesScore(){
		
		int[] player = viewer.getPlayer();
		boolean[] checkChecker = new boolean[5];
		int points = viewer.getPoints();
		String temp = "";
	
	if(viewer.getBox1() == true && counter < 3){
		points += player[0];
		counter++;
		checkChecker[0] = true;
	}
	if(viewer.getBox2() == true && counter < 3){
		points += player[1];
		counter++;
		checkChecker[1] = true;
	}
	if(viewer.getBox3() == true && counter < 3){
		points += player[2];
		counter++;
		checkChecker[2] = true;
	}
	if(viewer.getBox4() == true && counter < 3){
		points += player[3];
		counter++;
		checkChecker[3] = true;
	}
	if(viewer.getBox5() == true && counter < 3){
		points += player[4];
		counter++;
		checkChecker[4] = true;
	}
	
	for(int i=0; i<5; i++){
		if(checkChecker[i] == true){
			temp += player[i];
		}
	}
	if(temp.equals("111")){
		viewer.setPoints(points);
	}
	else if(temp.equals("222")){
		viewer.setPoints(points);
	}
	else if(temp.equals("333")){
		viewer.setPoints(points);
	}
	else if(temp.equals("444")){
		viewer.setPoints(points);
	}
	else if(temp.equals("555")){
		viewer.setPoints(points);
	}
	else if(temp.equals("666")){
		viewer.setPoints(points);
	}
	else{
		viewer.setPoints(viewer.getPoints());
	}
	
	viewer.setThrees("Tretal");
	
}
	//En metod med regler som sätter poäng för fyrtal
	public void setFoursScore(){
		
		boolean[] checkChecker = new boolean[5];
		int[] player = viewer.getPlayer();
		int points = viewer.getPoints();
		String temp = "";
		
		if(viewer.getBox1() == true && counter < 4){
			points += player[0];
			counter++;
			checkChecker[0] = true;
		}
		if(viewer.getBox2() == true && counter < 4){
			points += player[1];
			counter++;
			checkChecker[1] = true;
		}
		if(viewer.getBox3() == true && counter < 4){
			points += player[2];
			counter++;
			checkChecker[2] = true;
		}
		if(viewer.getBox4() == true && counter < 4){
			points += player[3];
			counter++;
			checkChecker[3] = true;
		}
		if(viewer.getBox5() == true && counter < 4){
			points += player[4];
			counter++;
			checkChecker[4] = true;
		}
		
		for(int i=0; i<5; i++){
			if(checkChecker[i] == true){
				temp += player[i];
			}
		}
		if(temp.equals("1111")){
			viewer.setPoints(points);
		}
		else if(temp.equals("2222")){
			viewer.setPoints(points);
		}
		else if(temp.equals("3333")){
			viewer.setPoints(points);
		}
		else if(temp.equals("4444")){
			viewer.setPoints(points);
		}
		else if(temp.equals("5555")){
			viewer.setPoints(points);
		}
		else if(temp.equals("6666")){
			viewer.setPoints(points);
		}
		else{
			viewer.setPoints(viewer.getPoints());
		}
		
		viewer.setFours("Fyrtal");
		
	}
	//En metod med regler som samt sätter poäng för liten straight
	public void setTinyStraight(){
		
		boolean[] checkChecker = new boolean[5];
		int[] player = viewer.getPlayer();
		int points = viewer.getPoints();
		String temp = "";
		
		if(viewer.getBox1() == true && counter < 5){
			points += player[0];
			counter++;
			checkChecker[0] = true;
		}
		if(viewer.getBox2() == true && counter < 5){
			points += player[1];
			counter++;
			checkChecker[1] = true;
		}
		if(viewer.getBox3() == true && counter < 5){
			points += player[2];
			counter++;
			checkChecker[2] = true;
		}
		if(viewer.getBox4() == true && counter < 5){
			points += player[3];
			counter++;
			checkChecker[3] = true;
		}
		if(viewer.getBox5() == true && counter < 5){
			points += player[4];
			counter++;
			checkChecker[4] = true;
		}
		
		Arrays.sort(player);
		for(int i=0; i<5; i++){
			if(checkChecker[i] == true){
				temp += player[i];
			}
		}
		if(temp.equals("12345")){
			viewer.setPoints(points);
		}
		else{
			viewer.setPoints(viewer.getPoints());
		}
		
		viewer.setTinyStraight("Liten Straight");
		
	}
	//En metod med regler samt som sätter poäng för en stor straight
	public void setBigStraight(){
		
		boolean[] checkChecker = new boolean[5];
		int[] player = viewer.getPlayer();
		int points = viewer.getPoints();
		String temp = "";
		
		if(viewer.getBox1() == true && counter < 5){
			points += player[0];
			counter++;
			checkChecker[0] = true;
		}
		if(viewer.getBox2() == true && counter < 5){
			points += player[1];
			counter++;
			checkChecker[1] = true;
		}
		if(viewer.getBox3() == true && counter < 5){
			points += player[2];
			counter++;
			checkChecker[2] = true;
		}
		if(viewer.getBox4() == true && counter < 5){
			points += player[3];
			counter++;
			checkChecker[3] = true;
		}
		if(viewer.getBox5() == true && counter < 5){
			points += player[4];
			counter++;
			checkChecker[4] = true;
		}
		
		Arrays.sort(player);
		for(int i=0; i<5; i++){
			if(checkChecker[i] == true){
				temp += player[i];
			}
		}
		if(temp.equals("23456")){
			viewer.setPoints(points);
		}
		else{
			viewer.setPoints(viewer.getPoints());
		}
		
		viewer.setBigStraight("Stor Straight");
		
	}
	//En metod med regler samt som sätter poäng för fullt hus
	public void setFullHouse(){
		boolean[] checkChecker = new boolean[5];
		int[] player = viewer.getPlayer();
		int[] tossCounter = new int[6];
		int points = viewer.getPoints();
		int temp = 0;
		
		if(viewer.getBox1() == true && counter < 5){
			points += player[0];
			counter++;
			checkChecker[0] = true;
		}
		if(viewer.getBox2() == true && counter < 5){
			points += player[1];
			counter++;
			checkChecker[1] = true;
		}
		if(viewer.getBox3() == true && counter < 5){
			points += player[2];
			counter++;
			checkChecker[2] = true;
		}
		if(viewer.getBox4() == true && counter < 5){
			points += player[3];
			counter++;
			checkChecker[3] = true;
		}
		if(viewer.getBox5() == true && counter < 5){
			points += player[4];
			counter++;
			checkChecker[4] = true;
		}	
		for(int i=0; i<5; i++){
			if(checkChecker[i] == true){
				if(player[i] == 1){
					tossCounter[0] ++;
				}
				if(player[i] == 2){
					tossCounter[1] ++;
				}
				if(player[i] == 3){
					tossCounter[2] ++;
				}
				if(player[i] == 4){
					tossCounter[3] ++;
				}
				if(player[i] == 5){
					tossCounter[4] ++;
				}
				if(player[i] == 6){
					tossCounter[5] ++;
				}
			}
		}
		
		for(int i=0; i<5; i++){
			if(tossCounter[i] == 3){
				temp+=2;
			}
			else if(tossCounter[i] == 2){
				temp++;
			}
		}
		
		if(tossCounter[5] == 3){
			temp+=2;
		}
		else if(tossCounter[5] == 2){
			temp++;
		}
		if(temp == 3){
			viewer.setPoints(points);
		}
		else{
			viewer.setPoints(viewer.getPoints());
		}
		viewer.setFullHouse("Kåk");
	}
	//En metod med regler samt sätter poäng för yatzy
	public void setYatzyScore(){
		
		boolean[] checkChecker = new boolean[5];
		int[] player = viewer.getPlayer();
		int points = viewer.getPoints();
		String temp = "";
		
		if(viewer.getBox1() == true && counter < 5){
			counter++;
			checkChecker[0] = true;
		}
		if(viewer.getBox2() == true && counter < 5){
			counter++;
			checkChecker[1] = true;
		}
		if(viewer.getBox3() == true && counter < 5){
			counter++;
			checkChecker[2] = true;
		}
		if(viewer.getBox4() == true && counter < 5){
			counter++;
			checkChecker[3] = true;
		}
		if(viewer.getBox5() == true && counter < 5){
			counter++;
			checkChecker[4] = true;
		}
		
		for(int i=0; i<5; i++){
			if(checkChecker[i] == true){
				temp += player[i];
			}
		}
		if(temp.equals("11111")){
			viewer.setPoints(points+=50);
		}
		else if(temp.equals("22222")){
			viewer.setPoints(points+=50);
		}
		else if(temp.equals("33333")){
			viewer.setPoints(points+=50);
		}
		else if(temp.equals("44444")){
			viewer.setPoints(points+=50);
		}
		else if(temp.equals("55555")){
			viewer.setPoints(points+=50);
		}
		else if(temp.equals("66666")){
			viewer.setPoints(points+=50);
		}
		else{
			viewer.setPoints(viewer.getPoints());
		}
		
		viewer.setYatzy("Yatzy");
		
	}
	
	/*
	* En metod som i en for loop kastar om alla tärningar. för att sedan se om någon av tärningarna
	* blivit valda att bli besparade. Om inte så får de värde beroende på vilket kast de fick. 
	*/
	public void gamePlay(){
		
		int player[] = viewer.getPlayer();
		
		if(viewer.getBox1() == true){
			
		}
		else{
			player[0] = tossDice();
		}
		if(viewer.getBox2() == true){
			
		}
		else{
			player[1] = tossDice();
		}
		if(viewer.getBox3() == true){
			
		}
		else{
			player[2] = tossDice();
		}
		if(viewer.getBox4() == true){
			
		}
		else{
			player[3] = tossDice();
		}
		if(viewer.getBox5() == true){
			
		}
		else{
			player[4] = tossDice();
		}
		
		if (player[0] == 1){
			viewer.setDieOne(onePNG);
		}
		else if(player[0] == 2){
			viewer.setDieOne(twoPNG);
		}
		else if(player[0] == 3){
			viewer.setDieOne(threePNG);
		}
		else if(player[0] == 4){
			viewer.setDieOne(fourPNG);
		}
		else if(player[0] == 5){
			viewer.setDieOne(fivePNG);
		}
		else if(player[0] == 6){
			viewer.setDieOne(sixPNG);
		}
		
		if (player[1] == 1){
			viewer.setDieTwo(onePNG);
		}
		else if(player[1] == 2){
			viewer.setDieTwo(twoPNG);
		}
		else if(player[1] == 3){
			viewer.setDieTwo(threePNG);
		}
		else if(player[1] == 4){
			viewer.setDieTwo(fourPNG);
		}
		else if(player[1] == 5){
			viewer.setDieTwo(fivePNG);
		}
		else if(player[1] == 6){
			viewer.setDieTwo(sixPNG);
		}
		
		if (player[2] == 1){
			viewer.setDieThree(onePNG);
		}
		else if(player[2] == 2){
			viewer.setDieThree(twoPNG);
		}
		else if(player[2] == 3){
			viewer.setDieThree(threePNG);
		}
		else if(player[2] == 4){
			viewer.setDieThree(fourPNG);
		}
		else if(player[2] == 5){
			viewer.setDieThree(fivePNG);
		}
		else if(player[2] == 6){
			viewer.setDieThree(sixPNG);
		}
		
		if (player[3] == 1){
			viewer.setDieFour(onePNG);
		}
		else if(player[3] == 2){
			viewer.setDieFour(twoPNG);
		}
		else if(player[3] == 3){
			viewer.setDieFour(threePNG);
		}
		else if(player[3] == 4){
			viewer.setDieFour(fourPNG);
		}
		else if(player[3] == 5){
			viewer.setDieFour(fivePNG);
		}
		else if(player[3] == 6){
			viewer.setDieFour(sixPNG);
		}
		
		if (player[4] == 1){
			viewer.setDieFive(onePNG);
		}
		else if(player[4] == 2){
			viewer.setDieFive(twoPNG);
		}
		else if(player[4] == 3){
			viewer.setDieFive(threePNG);
		}
		else if(player[4] == 4){
			viewer.setDieFive(fourPNG);
		}
		else if(player[4] == 5){
			viewer.setDieFive(fivePNG);
		}
		else if(player[4] == 6){
			viewer.setDieFive(sixPNG);
		}	
	}	
}

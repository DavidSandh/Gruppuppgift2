package yatzy;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class Viewer extends JPanel {
	
	private Controller controller;
	
	private int counter = 0;
	
	private boolean box1boolean = false;
	private boolean box2boolean = false;
	private boolean box3boolean = false;
	private boolean box4boolean = false;
	private boolean box5boolean = false;
	
	private int[] player = new int[5];

	private int points = 0;
	
	private JLabel omKast = new JLabel("Välj de tärningar du vill behålla");
	private JLabel showPoints = new JLabel("Dina poäng: " + points);
	
	private Font font = new Font("Italic", Font.BOLD, 16);
	
	private JLabel die1 = new JLabel();
	private JLabel die2 = new JLabel();
	private JLabel die3 = new JLabel();
	private JLabel die4 = new JLabel();
	private JLabel die5 = new JLabel();

	private JLabel result = new JLabel ("Använda paragrafer");
	private JLabel pair = new JLabel ("");
	private JLabel twoPair = new JLabel ("");
	private JLabel threes = new JLabel ("");
	private JLabel fours = new JLabel ("");
	private JLabel tinyStraight = new JLabel ("");
	private JLabel bigStraight = new JLabel ("");
	private JLabel fullHouse = new JLabel ("");
	private JLabel yatzy = new JLabel ("");
	
	private JCheckBox box1 = new JCheckBox("");
	private JCheckBox box2 = new JCheckBox("");
	private JCheckBox box3 = new JCheckBox("");
	private JCheckBox box4 = new JCheckBox("");
	private JCheckBox box5 = new JCheckBox("");
	
	private JPanel border = new JPanel(new BorderLayout());
	private JPanel west = new JPanel();
	private JPanel westWest = new JPanel(new GridLayout(2,5));
	private JPanel south = new JPanel(new GridLayout(1,1));
	private JPanel center = new JPanel();
	private JPanel northNorth = new JPanel(new BorderLayout());
	private JPanel northEast = new JPanel(new GridLayout(8,1));
	
	public Viewer(){
		setPreferredSize(new Dimension(500, 200));
		setLayout(new BorderLayout());
		
		omKast.setFont(font);
		showPoints.setFont(font);
		result.setFont(font);
		
		westWest.add(die1);
		westWest.add(die2);
		westWest.add(die3);
		westWest.add(die4);
		westWest.add(die5);
		
		westWest.add(box1);
		westWest.add(box2);
		westWest.add(box3);
		westWest.add(box4);
		westWest.add(box5);	
		
		northNorth.add(omKast, BorderLayout.WEST);
		northNorth.add(result, BorderLayout.EAST);
		
		northEast.add(pair);
		northEast.add(twoPair);
		northEast.add(threes);
		northEast.add(fours);
		northEast.add(tinyStraight);
		northEast.add(bigStraight);
		northEast.add(fullHouse);
		northEast.add(yatzy);
		
		west.add(westWest);
		south.add(showPoints);
		
		border.add(northNorth, BorderLayout.NORTH);
		border.add(west, BorderLayout.WEST);
		border.add(south, BorderLayout.SOUTH);
		border.add(northEast, BorderLayout.EAST);
		
		add(border);
		
		SaveListener e = new SaveListener();
		box1.addItemListener(e);
		box2.addItemListener(e);
		box3.addItemListener(e);
		box4.addItemListener(e);
		box5.addItemListener(e);
		
	}
	
	public void setPoints(int points){
		counter++;
		this.points = points;
		showPoints.setText("Dina poäng: " + points);
		if(counter == 8){
			showPoints.setText("Ditt resultat blev: " + points + " poäng");
			box1.setEnabled(false);
			box2.setEnabled(false);
			box3.setEnabled(false);
			box4.setEnabled(false);
			box5.setEnabled(false);
		}
	}
	
	public void setBoxesEnabled(){
		box1.setEnabled(true);
		box2.setEnabled(true);
		box3.setEnabled(true);
		box4.setEnabled(true);
		box5.setEnabled(true);
	}
	
	public void setCounter(int counter){
		this.counter = counter;
	}
	
	public void setPair(String temp){
		pair.setText(temp);
	}
	public void setTwoPair(String temp){
		twoPair.setText(temp);
	}
	public void setThrees(String temp){
		threes.setText(temp);
	}
	public void setFours(String temp){
		fours.setText(temp);
	}
	public void setTinyStraight(String temp){
		tinyStraight.setText(temp);
	}
	public void setBigStraight(String temp){
		bigStraight.setText(temp);
	}
	public void setFullHouse(String temp){
		fullHouse.setText(temp);
	}
	public void setYatzy(String temp){
		yatzy.setText(temp);
	}
	
	public int getPoints(){
		return points;
	}
	
	public int[] getPlayer(){
		return player;
	}
	
	public void setPlayer(int[]player){
		this.player = player;
	}
	
	public void setDieOne(ImageIcon icon) {
		die1.setIcon(icon);
	}
	
	public void setDieTwo(ImageIcon icon) {
		die2.setIcon(icon);
	}
	
	public void setDieThree(ImageIcon icon) {
		die3.setIcon(icon);
	}
	
	public void setDieFour(ImageIcon icon) {
		die4.setIcon(icon);
	}
	
	public void setDieFive(ImageIcon icon) {
		die5.setIcon(icon);
	}

	public boolean getBox1(){
		return box1boolean;
	}
	public void setBoxesFalse(){
		box1.setSelected(false);
		box2.setSelected(false);
		box3.setSelected(false);
		box4.setSelected(false);
		box5.setSelected(false);
	}
	public boolean getBox2(){
		return box2boolean;
	}
	public boolean getBox3(){
		return box3boolean;
	}
	public boolean getBox4(){
		return box4boolean;
	}
	public boolean getBox5(){
		return box5boolean;
	}
	
	public class SaveListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			
			if(box1.isSelected()){
				box1boolean = true;
			}
			else{
				box1boolean = false;
			}
			if(box2.isSelected()){
				box2boolean = true;
			}
			else{
				box2boolean = false;
			}
			if(box3.isSelected()){
				box3boolean = true;
			}
			else{
				box3boolean = false;
			}
			if(box4.isSelected()){
				box4boolean = true;
			}
			else{
				box4boolean = false;
			}
			if(box5.isSelected()){
				box5boolean = true;
			}
			else{
				box5boolean = false;
			}
		}
	}
	
	public static void main(String[]args){
		 Viewer viewer = new Viewer();
		 Controller controller = new Controller(viewer);
		 UserInput userInput = new UserInput(controller);
		 
		 JFrame frame1 = new JFrame( "Viewer" );
		 frame1.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 frame1.add( viewer);
		 frame1.pack();
		 frame1.setVisible( true );
		 
		 JFrame frame2 = new JFrame( "UserInput" );
		 frame2.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 frame2.add( userInput );
		 frame2.pack();
		 frame2.setVisible( true );
	}

	
}

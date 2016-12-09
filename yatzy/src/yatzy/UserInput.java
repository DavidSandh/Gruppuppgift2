package yatzy;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
* En klass som ärver en JPanel och visar upp tärningarna som kastat med hjälp av Controller klassen.
* Klassen innehåller också ett gäng checkboxes som används vid val av tärningar. 
*/
public class UserInput extends JPanel {
	
	private Controller controller;
	
	private JPanel protocol = new JPanel(new GridLayout(8,1));
	private JPanel executeButtons = new JPanel(new BorderLayout());
	private JPanel information = new JPanel(new GridLayout(8,1));
	
	private int pairCounter = 0;
	private int twoPairCounter = 0;
	private int threesCounter = 0;
	private int foursCounter = 0;
	private int tinyStraightCounter= 0;
	private int bigStraightCounter = 0;
	private int fullHouseCounter = 0;
	private int yatzyCounter = 0;
	private int tossCounter = 0;
	
	private JLabel pair = new JLabel("Par");
	private JLabel twoPair = new JLabel("Två Par");
	private JLabel threes = new JLabel("Tretal");
	private JLabel fours = new JLabel("Fyrtal");
	private JLabel tinyStraight = new JLabel("Liten Straight");
	private JLabel bigStraight = new JLabel("Stor Striaght");
	private JLabel fullHouse = new JLabel("Kåk");
	private JLabel yatzy = new JLabel("YATZY!");
	
	private JButton newGame = new JButton("Nytt spel");
	private JButton exit = new JButton("Avsluta");
	private JButton toss = new JButton("Kasta tärningar");
	private JButton savePair = new JButton();
	private JButton saveTwoPair = new JButton();
	private JButton saveThrees = new JButton();
	private JButton saveFours = new JButton();
	private JButton saveTinyStraight = new JButton();
	private JButton saveBigStraight = new JButton();
	private JButton saveFullHouse = new JButton();
	private JButton saveYatzy = new JButton();
	
	public UserInput(Controller controller){
		this.controller = controller;
		
		setPreferredSize(new Dimension(300,300));
		setLayout(new BorderLayout());
		
		executeButtons.add(toss, BorderLayout.NORTH);
		executeButtons.add(newGame, BorderLayout.CENTER);
		executeButtons.add(exit, BorderLayout.SOUTH);
		
		protocol.add(savePair);
		protocol.add(saveTwoPair);
		protocol.add(saveThrees);
		protocol.add(saveFours);
		protocol.add(saveTinyStraight);
		protocol.add(saveBigStraight);
		protocol.add(saveFullHouse);
		protocol.add(saveYatzy);
		
		information.add(pair);
		information.add(twoPair);
		information.add(threes);
		information.add(fours);
		information.add(tinyStraight);
		information.add(bigStraight);
		information.add(fullHouse);
		information.add(yatzy);
		
		add(executeButtons, BorderLayout.NORTH);
		add(protocol, BorderLayout.WEST);
		add(information, BorderLayout.CENTER);
		
		toss.addActionListener(new TossListener());
		newGame.addActionListener(new GameListener());
		exit.addActionListener(new CloseListener());
		
		ProtocolListener e = new ProtocolListener();
		savePair.addActionListener(e);
		saveTwoPair.addActionListener(e);
		saveThrees.addActionListener(e);
		saveFours.addActionListener(e);
		saveTinyStraight.addActionListener(e);
		saveBigStraight.addActionListener(e);
		saveFullHouse.addActionListener(e);
		saveYatzy.addActionListener(e);
		
	}
	
	public class ProtocolListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == savePair){
				if(pairCounter == 1){
					System.out.print("Du har redan valt denna");
				}
				else{
					controller.setPairScore();
					controller.resetCounter();
					controller.setBoxesFalse();
					controller.gamePlay();
					pairCounter++;
					tossCounter -=1;
				}
			}
			
			if(e.getSource() == saveTwoPair){
				if(twoPairCounter == 1){
					System.out.print("Du har redan valt denna");
				}
				else{
					controller.setTwoPairScore();
					controller.resetCounter();
					controller.setBoxesFalse();
					controller.gamePlay();
					twoPairCounter++;
					tossCounter -=1;
				}
			}
			
			if(e.getSource() == saveThrees){
				if(threesCounter == 1){
					System.out.print("Du har redan valt denna");
				}
				else{
					controller.setThreesScore();
					controller.resetCounter();
					controller.setBoxesFalse();
					controller.gamePlay();
					threesCounter++;
					tossCounter -=1;
				}
			}
			
			if(e.getSource() == saveFours){
				if(foursCounter == 1){
					System.out.print("Du har redan valt denna");
				}
				else{
					controller.setFoursScore();
					controller.resetCounter();
					controller.setBoxesFalse();
					controller.gamePlay();
					foursCounter++;
					tossCounter -=1;
				}
			}
			
			if(e.getSource() ==saveTinyStraight){
				if(tinyStraightCounter == 1){
					System.out.print("Du har redan valt denna");
				}
				else{
					controller.setTinyStraight();
					controller.resetCounter();
					controller.setBoxesFalse();
					controller.gamePlay();
					tinyStraightCounter++;
					tossCounter -=1;
				}
			}
			
			if(e.getSource() == saveBigStraight){
				if(bigStraightCounter == 1){
					System.out.print("Du har redan valt denna");
				}
				else{
					controller.setBigStraight();
					controller.resetCounter();
					controller.setBoxesFalse();
					controller.gamePlay();
					bigStraightCounter++;
					tossCounter -=1;
				}
			}
			
			if(e.getSource() == saveFullHouse){
				if(fullHouseCounter == 1){
					System.out.print("Du har redan valt denna");
				}
				else{
					controller.setFullHouse();
					controller.resetCounter();
					controller.setBoxesFalse();
					controller.gamePlay();
					fullHouseCounter++;
					tossCounter -=1;
				}
			}
			
			if(e.getSource() == saveYatzy){
				if(yatzyCounter == 1){
					System.out.print("Du har redan valt denna");
				}
				else{
					controller.setYatzyScore();
					controller.resetCounter();
					controller.setBoxesFalse();
					controller.gamePlay();
					yatzyCounter++;
					tossCounter -=1;
				}
			}
		}
	}
	
	public class TossListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(tossCounter == 2){
				System.out.print("Du har redan kastat om engång");
			}
			else{
			controller.gamePlay();
			tossCounter++;
			}
		}
	}
	
	private class GameListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			controller.newGame();
			pairCounter = 0;
			twoPairCounter = 0;
			threesCounter = 0;
			foursCounter = 0;
			tinyStraightCounter = 0;
			bigStraightCounter = 0;
			fullHouseCounter = 0;
			yatzyCounter = 0;
			tossCounter = 0;
			
		}
	}
	
	private class CloseListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    	controller.exit();
	    }
	}
}

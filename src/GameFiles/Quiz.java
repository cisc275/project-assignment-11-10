package GameFiles;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 * represents the quiz at the end of each game 
 *
 */
public class Quiz extends JDialog implements KeyListener{
	
	/**
	 * Card style layout for our Quizzes
	 */
	CardLayout card;
	
	/**
	 * Container to put our cards in
	 */
	Container c;
	
	/**
	 * an array list of all the possible quiz questions
	 */
	 ArrayList<JLabel> questions;
	 
	 
	 /**
	  * the label for the chosen question
	  */
	 JLabel question;
	 
	 /**
	  * The instruction to select answer
	  */
	 JLabel instruction = new JLabel("Press the key listed next to your answer.");
	 
	 /**
	  * Telling individual how to get to actual quiz
	  */
	 JLabel next = new JLabel("Double tap the spacebar to answer a question and get a powerup.");
	 
	 /**
	  * whether or not a question has been answered
	  */
	 static boolean answered = false;
	
	 /**
	  * all of the Jbuttons involved in the quiz
	  */
	 JButton information, right, wrong, mW, first, second, third;
	 
	 /**
	  * arraylists of each type of answer
	  */
	 ArrayList<JButton> rightAnswers, wrongAnswers, mWAnswers, informations;
	 
	 /**
	  * hashset of integers so that there are no duplicate questions
	  */
	 static HashSet<Integer> previousNumbers;
	 
	 /**
	  * int used to pick random question
	  */
	 int qNumber;
	 
	 /**
	  * panel used to draw the quiz and information screen
	  */
	 JPanel p, info;
	
	 /**
	  * screen size dimensions
	  */
	 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	/**
	 * 
	 * @param game
	 * 
	 * Constructs the quiz according to whatever game you're in
	 * according to parameter game
	 */
	
	public Quiz(String game) {
		c = getContentPane();
		card = new CardLayout();
		c.setLayout(card);
		panelHandling();
		questionNumber();
		initQuestions(game);
		initAnswers(game);
	//	initInfo(game);
	//	info.add(next);
	//	c.add("info", info);
        c.add("qNa", p);
		this.setModal(true);
		this.setResizable(false);
        this.setSize(400, 200);
        this.setVisible(true);
   
		
     
	}
	
	/**
	 * handles the panels for each part of the quiz, 
	 * the info and the actual question
	 * 
	 * @author Tim Mazzarelli
	 */
	
	public void panelHandling() {
		p = new JPanel();
		info = new JPanel();
		ArrayList<JPanel> panels = new ArrayList<JPanel>();
		panels.add(p);
		panels.add(info);
		for (JPanel j : panels) {
			j.setLayout(new GridLayout(0, 1));
			j.setAlignmentX(CENTER_ALIGNMENT);
			j.setAlignmentY(TOP_ALIGNMENT);
		}
	}
	
	
	/**
	 * @param none
	 * @return HashSet<Integer>
	 * initializes the HashSet of integers which will prevent repeats
	 * 
	 * @author tim mazzarelli
	 */
	
	public HashSet<Integer> initHashtable() {
		if (previousNumbers != null) {return previousNumbers;}
		else {
			previousNumbers = new HashSet<Integer>();
		}
		return previousNumbers;
	}
	
	/**
	 * @param none
	 * @return int
	 * 
	 * gives us the random number to choose our questions
	 * and answers for a quiz quiz
	 * 
	 * @author tim mazzarelli
	 */
	
	public int questionNumber() {
		int answer = 0;
		Random r = new Random();
		qNumber = r.nextInt(5);
		qNumber = (Integer) qNumber;
		if (previousNumbers != null) {
			if (previousNumbers.contains(qNumber)) {
				questionNumber();	
			}
			else {
				previousNumbers.add(qNumber);
				answer = qNumber;	
			}
		}
		return answer;
	}	
	
	/**
	 * adds in the information screen for each game
	 * @param game
	 */
	
	public void initInfo(String game) {
		if (game.equals("sides")) {
			if (informations != null) {}
			else {
				informations = new ArrayList<JButton>();
				informations.add(Constants.OSPREY_I_1);
				informations.add(Constants.OSPREY_I_2);
				informations.add(Constants.OSPREY_I_3);
				informations.add(Constants.OSPREY_I_4);
				informations.add(Constants.OSPREY_I_5);
				informations.add(Constants.OSPREY_I_6);
				informations.add(Constants.OSPREY_I_7);
				informations.add(Constants.OSPREY_I_8);
				informations.add(Constants.OSPREY_I_9);
				informations.add(Constants.OSPREY_I_10);
				
			}
		}
		if (game.equals("td")) {
			if (informations != null) {}
			else {

				informations = new ArrayList<JButton>();
				informations.add(Constants.CR_I_1);
				informations.add(Constants.CR_I_2);
				informations.add(Constants.CR_I_3);
				informations.add(Constants.CR_I_4);
				informations.add(Constants.CR_I_5);
				informations.add(Constants.CR_I_6);
				informations.add(Constants.CR_I_7);
				informations.add(Constants.CR_I_8);
				informations.add(Constants.CR_I_9);
				informations.add(Constants.CR_I_10);
			}
		}
		getInfo(informations);
	}
	
	/**
	 * picks the correct info according to the randomly generated 
	 * @param inf
	 */
	
	public void getInfo(ArrayList<JButton> inf) {
		if (Mate.caughtUp) {
			information = Constants.OSPREY_I_LAST;
		}
		else {
			information = inf.get(qNumber);
			inf.remove(qNumber);
		}
		infoPanelHandling();
	}
	
	public void infoPanelHandling() {
		information.addKeyListener(this);
		information.setFocusPainted(false);
		information.setOpaque(true);
		information.setBackground(Color.WHITE);
		information.setMinimumSize(new Dimension(300, 20));
        information.setPreferredSize(new Dimension(300, 20));
        information.setMaximumSize(new Dimension(300, 20));
    	information.setVerticalAlignment(JButton.TOP);
    	information.setHorizontalAlignment(JButton.CENTER);
    	information.setFont(new Font("Serif", Font.BOLD, 15));
    	information.setBorderPainted(false);	
    	info.add(information);
		directionHandling();
	}
	
	public void directionHandling() {
		next.setHorizontalAlignment(JLabel.CENTER);
		next.setVerticalAlignment(JLabel.TOP);
		next.setOpaque(true);
        next.setFont(new Font("Serif", Font.BOLD, 15));
        next.setBackground(Color.WHITE);
        next.setMinimumSize(new Dimension(200, 5));
        next.setPreferredSize(new Dimension(200, 5));
        next.setMaximumSize(new Dimension(200, 5));
		info.add(next);
		
	}
	
	/**
	 * @param String game
	 * 
	 * Depending on whichever game you're in
	 * we will access our array of questions
	 * if it's null it creates it, if it's not it 
	 * just return the array
	 * 
	 * @author tim mazzarelli
	 */
	
	public void initQuestions(String game) {
		if (game.equals("sides")) {
			if (questions != null) {}
			else {
				questions = new ArrayList<JLabel>();
				questions.add(Constants.OSPREY_1);
				questions.add(Constants.OSPREY_2);
				questions.add(Constants.OSPREY_3);
				questions.add(Constants.OSPREY_4);
				questions.add(Constants.OSPREY_5);
			}
		}
		if (game.equals("td")) {
			if (questions != null) {}
			else {
				questions = new ArrayList<JLabel>();
				questions.add(Constants.CR_1);
				questions.add(Constants.CR_2);
				questions.add(Constants.CR_3);
				questions.add(Constants.CR_4);
				questions.add(Constants.CR_5);
			}
		}
		getQuestion(questions);
	}
	
	
	/**
	 * @param ArrayList<JLabel> ourQuestion
	 * 
	 * takes an arrayList of questions and based on the number 
	 * chosen at beginning takes that question and removes it from the list
	 * so it can't be accessed again in the same game
	 * 
	 * @author tim mazzarelli
	 */
	
	public void getQuestion(ArrayList<JLabel> ourQuestions) {
		if (Mate.caughtUp) {
			question = Constants.OSPREY_LAST;
		}
		else {
			question = ourQuestions.get(qNumber);
			ourQuestions.remove(qNumber);
		}
		questionHandling();	
	}
	
	/**
	 * @param none
	 * 
	 * sets up the label in an appealing way
	 * 
	 * @author tim mazzarelli
	 */
	
	public void questionHandling() {
		ArrayList<JLabel> templist = new ArrayList<>();
		templist.add(question);
		templist.add(instruction);
		for (JLabel l : templist) {
			l.setHorizontalAlignment(JLabel.CENTER);
			l.setVerticalAlignment(JLabel.TOP);
			l.setOpaque(true);
	        l.setFont(new Font("Serif", Font.BOLD, 15));
	        l.setBackground(Color.WHITE);
	        l.setMinimumSize(new Dimension(200, 5));
	        l.setPreferredSize(new Dimension(200, 5));
	        l.setMaximumSize(new Dimension(200, 5));
			p.add(l);
	        }
		}
	
	
	
	/**
	 * @param String game
	 * 
	 * initializes the arrayLists of answers depending on
	 * whether or not you are playing the clapperrail or osprey game
	 * 
	 * @author tim mazzarelli
	 */
	
	public void initAnswers(String game) {
		getAnswer(initRightAnswers(game), initWrongAnswers(game), initMWAnswers(game));
	}
	
	/**
	 * @param String game
	 * 
	 * gets the arrayList of correct answers depending on game
	 * being played
	 * 
	 * @return ArrayList<Jbutton>
	 * 
	 * @author tim mazzarelli
	 */
	
	public ArrayList<JButton> initRightAnswers(String game) {
		if (game.equals("sides")){
			if (rightAnswers != null) {}
			else {
				rightAnswers = new ArrayList<JButton>();
				rightAnswers.add(Constants.OSPREY_CORRECT1);
				rightAnswers.add(Constants.OSPREY_CORRECT2);
				rightAnswers.add(Constants.OSPREY_CORRECT3);
				rightAnswers.add(Constants.OSPREY_CORRECT4);
				rightAnswers.add(Constants.OSPREY_CORRECT5);
			}
		}
		if (game.equals("td")) {
			if (rightAnswers != null) {}
			else {
				rightAnswers = new ArrayList<JButton>();
				rightAnswers.add(Constants.CR_CORRECT1);
				rightAnswers.add(Constants.CR_CORRECT2);
				rightAnswers.add(Constants.CR_CORRECT3);
				rightAnswers.add(Constants.CR_CORRECT4);
				rightAnswers.add(Constants.CR_CORRECT5);

			}
		}
		return rightAnswers;
	}
	
	/**
	 * @param String game
	 * 
	 * gets the arrayList of incorrect answers depending on game
	 * being played
	 * 
	 * 
	 * @return ArrayList<Jbutton>
	 * 
	 * @author tim mazzarelli
	 */
	
	public ArrayList<JButton> initWrongAnswers(String game) {
		if (game.equals("sides")) {
			if (wrongAnswers != null) {}
			else {
				wrongAnswers = new ArrayList<JButton>();
				wrongAnswers.add(Constants.OSPREY_INCORRECT1);
				wrongAnswers.add(Constants.OSPREY_INCORRECT2);
				wrongAnswers.add(Constants.OSPREY_INCORRECT3);
				wrongAnswers.add(Constants.OSPREY_INCORRECT4);
				wrongAnswers.add(Constants.OSPREY_INCORRECT5);

			}
		}
		if (game.equals("td")) {
			if (wrongAnswers != null) {}
			else {
				wrongAnswers = new ArrayList<JButton>();
				wrongAnswers.add(Constants.CR_INCORRECT1);
				wrongAnswers.add(Constants.CR_INCORRECT2);
				wrongAnswers.add(Constants.CR_INCORRECT3);
				wrongAnswers.add(Constants.CR_INCORRECT4);
				wrongAnswers.add(Constants.CR_INCORRECT5);
			}
		}
		return wrongAnswers;
	}
	
	/**
	 * @param String game
	 * 
	 * gets the arrayList of more incorrect answers depending on game
	 * being played
	 * 
	 * @return ArrayList<Jbutton>
	 * 
	 * @author tim mazzarelli
	 */
	
	public ArrayList<JButton> initMWAnswers(String game) {
		if (game.equals("sides")) {
			if (mWAnswers != null) {}
			else {
				mWAnswers = new ArrayList<JButton>();
				mWAnswers.add(Constants.OSPREY_WRONG1);
				mWAnswers.add(Constants.OSPREY_WRONG2);
				mWAnswers.add(Constants.OSPREY_WRONG3);
				mWAnswers.add(Constants.OSPREY_WRONG4);
				mWAnswers.add(Constants.OSPREY_WRONG5);
			}
		}
		if (game.equals("td")) {
			if (mWAnswers != null) {return mWAnswers;}
			else {
				mWAnswers = new ArrayList<JButton>();
				mWAnswers.add(Constants.CR_WRONG1);
				mWAnswers.add(Constants.CR_WRONG2);
				mWAnswers.add(Constants.CR_WRONG3);
				mWAnswers.add(Constants.CR_WRONG4);
				mWAnswers.add(Constants.CR_WRONG5);
			}
		}
		return mWAnswers;
		
	}
	
	/**
	 * @param ArrayList<Jbutton> right, ArrayList<Jbutton> wrong, ArrayList<Jbutton> moreWrong
	 * 
	 * gets the proper answers based on the question number
	 * and then passes onto button handling
	 * 
	 * @author tim mazzarelli
	 */

	public void getAnswer(ArrayList<JButton> rightAnswer, ArrayList<JButton> wrongAnswer, ArrayList<JButton> moreWrong) {
		if (Mate.caughtUp) {
			right = Constants.OSPREY_LAST_RIGHT;
			wrong = Constants.OSPREY_LAST_INCORRECT;
			mW = Constants.OSPREY_LAST_WRONG;
		}
		else {
			right = rightAnswer.get(qNumber);
			rightAnswer.remove(qNumber);
			wrong = wrongAnswer.get(qNumber);
			wrongAnswer.remove(qNumber);
			mW = moreWrong.get(qNumber);
			moreWrong.remove(qNumber);
		}
		buttonHandling(right, wrong, mW);
	}
	
	/**
	 * @param Jbutton correct, Jbutton incorrect, Jbutton veryWrong
	 * 
	 * sets up each JButton in a nice way, 
	 * in a random order so the right answer is not always the first choice, 
	 * or second, or third etc.
	 * 
	 * @author tim mazzarelli
	 */
	
	public void buttonHandling(JButton correct, JButton incorrect, JButton veryWrong) {
		correct.setText(right.getText());
		incorrect.setText(wrong.getText());
		veryWrong.setText(mW.getText());
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		first = new JButton();
		second = new JButton();
		third = new JButton();
		Random r = new Random();
		int answerOrder = r.nextInt(6);
		switch(answerOrder) {
			case 0: first.setText(correct.getText());
					second.setText(incorrect.getText());
					third.setText(veryWrong.getText());
					break;
			case 1: first.setText(correct.getText());
					second.setText(veryWrong.getText());
					third.setText(incorrect.getText());
					break;
			case 2: first.setText(incorrect.getText());
					second.setText(correct.getText());
					third.setText(veryWrong.getText());
					break;
			case 3: first.setText(incorrect.getText());
					second.setText(veryWrong.getText());
					third.setText(correct.getText());
					break;
			case 4: first.setText(veryWrong.getText());
					second.setText(incorrect.getText());
					third.setText(correct.getText());
					break;
			case 5: 
					first.setText(veryWrong.getText());
					second.setText(correct.getText());
					third.setText(incorrect.getText());
					break;
			
		}
		first.setText("A. " + first.getText());
		second.setText("B. " + second.getText());
		third.setText("C. " + third.getText());
		buttons.add(first);
		buttons.add(second);
		buttons.add(third);

		
		for (JButton b :buttons) {
			b.addKeyListener(this);
			b.setFocusPainted(false);
			b.setOpaque(true);
			b.setBackground(Color.WHITE);
			b.setMinimumSize(new Dimension(300, 20));
            b.setPreferredSize(new Dimension(300, 20));
            b.setMaximumSize(new Dimension(300, 20));
        	b.setVerticalAlignment(JButton.TOP);
        	b.setHorizontalAlignment(JButton.CENTER);
        	b.setFont(new Font("Serif", Font.BOLD, 15));
        	b.setBorderPainted(false);
        	p.add(b);	
		}
	}
	
	
	
	
	public static void main(String[] args) {
		new Quiz("sides");
	}
	
	
	
	/**
	 *
	 * class that tells us how to handle actions
	 * 
	 * @author tim mazzarelli
	 */
	
	public void addActionListener(Quiz q) {
	}
	
	class keyAction extends AbstractAction{
		
		/**
		 * @param ActionEvent e
		 * 
		 * tells us what to do when an action is performed (JButton pressed) 
		 * 
		 * 
		 * @author tim mazzarelli
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("hi");
				if (e.getSource() == information) {
					card.next(c);
				}
				if (e.getSource() == first) {
					if (first.getText().equals("A. " + right.getText())) {
						if(Mate.caughtUp) {
							View.frame.dispose();
							answered = true;
							new EndScreen();
						}
						System.out.println("right");
					}
					else System.out.println("wrong");
					endQuiz();
				}
				if (e.getSource() == second) {
					if (second.getText().equals("B. " + right.getText())) {
						if(Mate.caughtUp) {
							View.frame.dispose();
							answered = true;
							new EndScreen();
						}
						System.out.println("right");
					}
					else System.out.println("wrong");
					endQuiz();
				}
				if (e.getSource() == third) {
					if (third.getText().equals("C. " + right.getText())) {
						if(Mate.caughtUp) {
							View.frame.dispose();
							answered = true;
							new EndScreen();
						}
						System.out.println("right");
					}
					else System.out.println("wrong");
					endQuiz();
				}

			
			}
		}
	
	

	
	/**
	 * @param KeyEvent e
	 * 
	 * handles when a key is pressed, performs the correct action
	 * according to each button accordingly
	 * 
	 * @author tim mazzarelli
	 */
	 
	@Override
	public void keyPressed(KeyEvent e) {
		this.requestFocus();
	//	firstPanelSetup();
		firstButtonSetup();
		secondButtonSetup();
		thirdButtonSetup();
		}
	

	/**
	 * sets up the correct input and action maps for the first button
	 * @author Tim Mazzarelli
	 */
	
	public void firstButtonSetup() {
		int map = JComponent.WHEN_IN_FOCUSED_WINDOW;
		InputMap imap = first.getInputMap(map);
		imap.put(KeyStroke.getKeyStroke('a'), "first");
		
		ActionMap amap = first.getActionMap();
		amap.put("first", new keyAction());
	}
	
	public void firstPanelSetup() {
		int map = JComponent.WHEN_IN_FOCUSED_WINDOW;
		InputMap imap = information.getInputMap(map);
		imap.put(KeyStroke.getKeyStroke("SPACE"), "information");
		
		ActionMap amap = information.getActionMap();
		amap.put("information", new keyAction());
	}
	
	/**
	 * sets up the correct input and action maps for the second button
	 * @author Tim Mazzarelli
	 */
	public void secondButtonSetup() {
		int map = JComponent.WHEN_IN_FOCUSED_WINDOW;
		InputMap imap = second.getInputMap(map);  
		imap.put(KeyStroke.getKeyStroke('b'), "second");
		
		ActionMap amap = second.getActionMap();
		amap.put("second", new keyAction());
	}
	
	/**
	 * sets up the correct input and action maps for the third button
	 * @author Tim Mazzarelli
	 */
	public void thirdButtonSetup() {
		int map = JComponent.WHEN_IN_FOCUSED_WINDOW;
		InputMap imap = third.getInputMap(map);
		
		keyAction rA = new keyAction();
		rA.setEnabled(true);
		
		imap.put(KeyStroke.getKeyStroke('c'), "third");
		ActionMap amap = third.getActionMap();
		amap.put("third", new keyAction());
	}
	
	
	/**
	 * closes the quiz when done
	 * @author Tim Mazzarelli
	 */
	public void endQuiz() {
		this.dispose();
	}
	
	/**
	 * does nothing for us but here for interface purposes
	 * @author Tim Mazzarelli
	 */
	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	/**
	 * does nothing for us but here for interface purposes
	 * @author Tim Mazzarelli
	 */
	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
		
	}

	


	



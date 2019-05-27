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
	 * a string representing which game the quiz is for
	 */
	protected String game;
	
	/**
	 * a BufferedImage for background images
	 */
	protected BufferedImage image;
	
	/**
	 * Card style layout for our Quizzes
	 */
	protected CardLayout card;
	
	/**
	 * Container to put our cards in
	 */
	protected Container c;
	
	/**
	 * an array list of all the possible quiz questions
	 */
	protected ArrayList<JLabel> questions;
	 
	 
	 /**
	  * the label for the chosen question
	  */
	protected JLabel question;
	 
	 /**
	  * The instruction to select answer
	  */
	protected JLabel instruction = new JLabel("Press the key listed next to your answer.");
	 
	 /**
	  * Telling individual how to get to actual quiz
	  */
	protected JLabel next = new JLabel("Double tap the spacebar to answer a question and get a powerup.");
	 
	 /**
	  * whether or not a question has been answered
	  */
	protected static boolean answered;
	
	 /**
	  * all of the Jbuttons involved in the quiz
	  */
	protected JButton information, right, wrong, mW, first, second, third;
	 
	 /**
	  * arraylists of each type of answer
	  */
	protected ArrayList<JButton> rightAnswers, wrongAnswers, mWAnswers, informations;
	 
	 /**
	  * hashset of integers so that there are no duplicate questions
	  */
	protected static HashSet<Integer> previousNumbers;
	 
	 /**
	  * int used to pick random question
	  */
	protected int qNumber;
	 
	 /**
	  * panel used to draw the quiz and information screen
	  */
	protected JPanel p, info;
	
	 /**
	  * screen size dimensions
	  */
	protected Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	 
	 /**
	  * static boolean representing if player has correctly answered a question
	  */
	 public static boolean correct = false;
	
	 
	/**
	 * 
	 * @param game The game to create
	 * 
	 * Constructs the quiz according to whatever game you're in
	 * according to parameter game
	 */
	
	public Quiz(String game) {
		this.game = game;
		Constants.FRAME_X = (int) screenSize.getWidth();
		Constants.FRAME_Y = (int) screenSize.getHeight();
		c = getContentPane();
		card = new CardLayout();
		c.setLayout(card);
		panelHandling();
		questionNumber();
		initQuestions(game);
		initAnswers(game);
		initHashSet();
		if (Mate.caughtUp) {
			this.setSize(Constants.FRAME_X, Constants.FRAME_Y);
			this.setLocation(Constants.VIEW_ORIGIN, Constants.VIEW_ORIGIN);
		}
		else {
			this.setLocation(Constants.FRAME_X/Constants.QUIZ_CENTER - Constants.FRAME_X/Constants.QUIZ_OFFSET, Constants.FRAME_Y/Constants.QUIZ_CENTER - Constants.FRAME_Y/Constants.QUIZ_OFFSET);
			this.setSize(Constants.FRAME_X/Constants.QUIZ_CENTER, Constants.FRAME_Y/Constants.QUIZ_CENTER);
		}
		c.add(p);
		this.setModal(true);
		this.setResizable(false);
		this.setUndecorated(true);
        this.setVisible(true);

	}
	
	
	/**
	 * handles the panels for each part of the quiz, 
	 * the info and the actual question
	 * 
	 * @author Tim Mazzarelli
	 */
	public void panelHandling() {
		p = new DrawPanel();
		p.setLayout(new GridLayout(Constants.GRID_LAYOUT_X, Constants.GRID_LAYOUT_Y));
		p.setIgnoreRepaint(true);
	}
	
	/**
	 * class that draws our JPanel
	 * @author Tim mazzarelli
	 *
	 */
	private class DrawPanel extends JPanel{
		
		/**
		 * creates the image that we want on our Quiz background
		 * depends on what game you're in or if you
		 * won the Osprey game
		 * @return New BufferedImage of what to draw
		 * @author Tim Mazzarelli
		 */
		private BufferedImage createImage(){
			BufferedImage bufferedImage;
	    	try {
	    		if (Mate.caughtUp) {
	    			bufferedImage = ImageIO.read(new File(Constants.IMG_TIM_PICK_ME_PLEASE));
		    		return bufferedImage;
	    		}
	    		if (game.equals(Constants.SIDE_SCROLL_STRING)){
	    		bufferedImage = ImageIO.read(new File(Constants.IMG_BACKGROUND_OSPREY_QUIZ));
	    		return bufferedImage;
	    		}
	    		if (game.equals(Constants.TOP_DOWN_STRING)) {
	    		bufferedImage = ImageIO.read(new File(Constants.IMG_CR_BACKGROUND_QUIZ));
	    		return bufferedImage;
	    		}
	    	}
	    	catch (IOException e) {
	    		e.printStackTrace();
	    	}	
	    	return null;
		}
			
		
		/**
		 * draws our created image onto the JPanel
		 * @param g	Internal graphics system
		 * @author Mark Wolgin
		 */
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			image = createImage();
			g.drawImage(image, this.getWidth() - this.getWidth(), 
					this.getHeight() - this.getHeight(), this.getWidth(), this.getHeight(), this);
		}
	}
	
	
	
	
	/**
	 * @return HashSet of Integers
	 * initializes the HashSet of integers which will prevent repeats
	 * @author tim mazzarelli
	 */
	
	public HashSet<Integer> initHashSet() {
		if (previousNumbers != null) {return previousNumbers;}
		else {
			previousNumbers = new HashSet<Integer>();
		}
		return previousNumbers;
	}
	
	/**
	 * gives us the random number to choose our questions
	 * and answers for a quiz quiz
	 * 
	 * @author tim mazzarelli
	 */
	
	public void questionNumber() {
		Random r = new Random();
		qNumber = r.nextInt(Constants.QUIZ_QUESTIONS);
		if (previousNumbers != null) {
			if (previousNumbers.contains(qNumber)) {
				questionNumber();	
			}
			else {
				previousNumbers.add(qNumber);	
			}
		}
	}	
	

	
	
	/**
	 * @param game String of the game
	 * 
	 * Depending on whichever game you're in
	 * we will access our array of questions
	 * if it's null it creates it, if it's not it 
	 * just return the array
	 * 
	 * @author tim mazzarelli
	 */
	public void initQuestions(String game) {
		if (game.equals(Constants.SIDE_SCROLL_STRING)) {
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
		if (game.equals(Constants.TOP_DOWN_STRING)) {
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
	 * @param ourQuestions ArrayList of our ourQuestion
	 * 
	 * takes an arrayList of questions and based on the number 
	 * chosen at beginning takes that question and removes it from the list
	 * so it can't be accessed again in the same game
	 * 
	 * @author tim mazzarelli
	 */
	
	public void getQuestion(ArrayList<JLabel> ourQuestions) {
		if (Mate.caughtUp == true) {
			question = Constants.OSPREY_LAST;
		}
		else if (Model.inTutoral == true) {
			question = Constants.OSPREY_TUTORIAL;
		}
		else {
			question = questions.get(qNumber);
			questions.remove(qNumber);
		}
		questionHandling();	
	}
	
	/** 
	 * sets up the label in an appealing way
	 * @author tim mazzarelli
	 */
	
	public void questionHandling() {
		ArrayList<JLabel> list = new ArrayList<JLabel>();
		list.add(question);
		if (Model.inTutoral == true) {
			if (game.equals(Constants.SIDE_SCROLL_STRING)) {
				instruction = new JLabel(Constants.QUIZ_SIDE_SCROLL_INSTRUCTION);
			}
			if (game.equals(Constants.TOP_DOWN_STRING)) {
			instruction = new JLabel(Constants.QUIZ_TOP_DOWN_INSTRUCTION);
			}
		}
			
		else instruction = new JLabel(Constants.QUIZ_GENERIC_INSTRUCTION);
		list.add(instruction);
		for (JLabel l : list) {
			if (Mate.caughtUp == true) {
				l.setForeground(Color.BLACK);
			    l.setFont(new Font(Constants.FONT_FAMILY, Font.ITALIC + Font.BOLD, (int)(Constants.FRAME_X * Constants.ENDSCREEN_TEXT_SIZE)));
				l.setOpaque(false);
				
			}
			else {
				l.setOpaque(false);
				l.setForeground(Color.BLACK);
			    l.setFont(new Font(Constants.FONT_FAMILY, Font.ITALIC + Font.BOLD, (int) (Constants.FRAME_X * Constants.QUIZ_TEXT_SIZE)));
			}
			l.setHorizontalAlignment(JLabel.CENTER);
			l.setVerticalAlignment(JLabel.TOP);
			p.add(l);	
		}
	}
		
	
	
	
	/**
	 * @param game String of the game to play
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
	 * @param game String of the game
	 * 
	 * gets the arrayList of correct answers depending on game
	 * being played
	 * 
	 * @return ArrayList of JButtons
	 * 
	 * @author tim mazzarelli
	 */
	
	public ArrayList<JButton> initRightAnswers(String game) {
		if (game.equals(Constants.SIDE_SCROLL_STRING)){
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
		if (game.equals(Constants.TOP_DOWN_STRING)) {
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
	 * @param game of String
	 * 
	 * gets the arrayList of incorrect answers depending on game
	 * being played
	 * 
	 * 
	 * @return ArrayList of JButtons
	 * 
	 * @author tim mazzarelli
	 */
	public ArrayList<JButton> initWrongAnswers(String game) {
		if (game.equals(Constants.SIDE_SCROLL_STRING)) {
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
		if (game.equals(Constants.TOP_DOWN_STRING)) {
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
	 * @param game The game
	 * 
	 * gets the arrayList of more incorrect answers depending on game
	 * being played
	 * 
	 * @return ArrayList of JButtons
	 * 
	 * @author tim mazzarelli
	 */
	public ArrayList<JButton> initMWAnswers(String game) {
		if (game.equals(Constants.SIDE_SCROLL_STRING)) {
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
		if (game.equals(Constants.TOP_DOWN_STRING)) {
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
	 * gets the proper answers based on the question number
	 * and then passes onto button handling
	 * 
	 * @author tim mazzarelli
	 * @param rightAnswer 	ArrayList of correct JButtons
	 * @param wrongAnswer	ArrayList of incorrect JButtons
	 * @param moreWrong		ArrayList of very wrong JButtons
	 */
	public void getAnswer(ArrayList<JButton> rightAnswer, ArrayList<JButton> wrongAnswer, ArrayList<JButton> moreWrong) {
		if (Mate.caughtUp == true) {
			right = Constants.OSPREY_LAST_RIGHT;
			wrong = Constants.OSPREY_LAST_INCORRECT;
			mW = Constants.OSPREY_LAST_WRONG;
		}
		else if (Model.inTutoral == true) {
			right = Constants.OSPREY_TUTORIAL_RIGHT;
			wrong = Constants.OSPREY_TUTORIAL_INCORRECT;
			mW = Constants.OSPREY_TUTORIAL_WRONG;
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
	 * 
	 * sets up each JButton in a nice way, 
	 * in a random order so the right answer is not always the first choice, 
	 * or second, or third etc.
	 * 
	 * @author tim mazzarelli
	 * @param correct 		Correct Button
	 * @param incorrect		Incorrect Button
	 * @param veryWrong		Very Wrong Button
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
		int answerOrder = r.nextInt(Constants.QUIZ_PERMS);
		switch(answerOrder) { // 6 permutations of button order
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
		if (Model.inTutoral == true) {
			first.setText("Press the A key if " + first.getText());
			second.setText("Press the B key if " + second.getText());
			third.setText("Press the C key if " + third.getText());
		}
		else {
			first.setText("A. " + first.getText());
			second.setText("B. " + second.getText());
			third.setText("C. " + third.getText());
		}
		buttons.add(first);
		buttons.add(second);
		buttons.add(third);
		buttons.add(new JButton());
		buttons.add(new JButton());
		buttons.add(new JButton());
		buttons.add(new JButton());
		if (Mate.caughtUp) {
			buttons.add(new JButton());
			buttons.add(new JButton());
		}
		
		// makes the buttons pretty
		for (JButton b :buttons) {
			if (Mate.caughtUp == true) {
				b.setForeground(Color.BLACK);
				b.setBackground(Color.BLACK);
				b.setOpaque(false);
	           	b.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, (int) (Constants.FRAME_X * Constants.ENDSCREEN_TEXT_SIZE)));
			}
			else{
        		b.setForeground(Color.BLACK);
        		b.setOpaque(false);
        		b.setBackground(Color.WHITE);
               	b.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, (int) (Constants.FRAME_X * Constants.QUIZ_TEXT_SIZE)));
        		
        	}
			b.addKeyListener(this);
			b.setFocusPainted(false);
        	b.setVerticalAlignment(JButton.TOP);
        	b.setHorizontalAlignment(JButton.CENTER);
        	b.setBorderPainted(false);
        	p.add(b);	
		}
	}
	
	
	
	
	/**
	 *
	 * class that tells us how to handle actions
	 * 
	 * @author tim mazzarelli
	 */
	
	
	class keyAction extends AbstractAction{
		
		/**
		 * @param e ActionListener
		 * tells us what to do when an action is performed (JButton pressed) 
		 * @author tim mazzarelli
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
				if (e.getSource() == first) {
					if (first.getText().equals("A. " + right.getText())) {
						if(Mate.caughtUp) {
							View.frame.dispose();
							Mate.caughtUp = false;
							new EndScreen(Constants.SIDE_SCROLL_STRING);
						}
						else{
							correct = true;
						}
						Osprey.posHitOs = true;
					}
					else {
						if(Mate.caughtUp) {
							View.frame.dispose();
							new LoseScreen(Constants.SIDE_SCROLL_STRING);
						}
						Osprey.negHitOs = true;
					}
					endQuiz();
				}
				if (e.getSource() == second) {
					if (second.getText().equals("B. " + right.getText())) {
						if(Mate.caughtUp) {
							View.frame.dispose();
							Mate.caughtUp = false;
							new EndScreen(Constants.SIDE_SCROLL_STRING);
						}
						else{
							correct = true;
						}
						Osprey.posHitOs = true;
					}
					else {
						if(Mate.caughtUp) {
							View.frame.dispose();
							new LoseScreen(Constants.SIDE_SCROLL_STRING);
						}
						Osprey.negHitOs = true;
					}
					endQuiz();
				}
				if (e.getSource() == third) {
					if (third.getText().equals("C. " + right.getText())) {
						if(Mate.caughtUp) {
							Mate.caughtUp = false;
							View.frame.dispose();
							new EndScreen(Constants.SIDE_SCROLL_STRING);
						}
						else{
							correct = true;
						}
						Osprey.posHitOs = true;
					}
					else {
						if(Mate.caughtUp) {
							View.frame.dispose();
							new LoseScreen(Constants.SIDE_SCROLL_STRING);
						}
						Osprey.negHitOs = true;
					}
					
					endQuiz();
				}

			Quiz.answered = true;
			}
		}
	
	

	
	/**
	 * @param e KeyEvent
	 * handles when a key is pressed, performs the correct action
	 * according to each button accordingly
	 * @author tim mazzarelli
	 */
	 
	@Override
	public void keyPressed(KeyEvent e) {
		this.requestFocus();
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

	


	



package GameFiles;
import java.awt.Color;
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
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * represents the quiz at the end of each game 
 *
 */
public class Quiz extends JDialog implements ActionListener{
	/**
	 * button that will allow user to select the osprey game
	 */
	
	 Image image;
	 JLabel question;
	 JButton right, wrong, mW;
	 ArrayList<JLabel> questions;
	 ArrayList<JButton> rightAnswers;
	 ArrayList<JButton> wrongAnswers;
	 ArrayList<JButton> mWAnswers;
	 static HashSet<Integer> previousNumbers;
	 int qNumber;
	 JPanel p;
	 Osprey o;
	
	
	/**
	 * button that will allow user to select the clapperrail game
	 */

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public Quiz(String game) {
		p = new JPanel();
		p.setLayout(new GridLayout(0,1));
		p.setAlignmentX(CENTER_ALIGNMENT);
		p.setAlignmentY(TOP_ALIGNMENT);
		initHashtable();
		questionNumber();
		initQuestions(game);
		initAnswers(game);
		this.setModal(true);
		this.setResizable(false);
        this.add(p);
        this.setSize(350, 200);
        this.setVisible(true);
        addActionListener(this);
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
		qNumber = r.nextInt(10);
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
			if (questions != null) {
				
			}
			else {
				questions = new ArrayList<JLabel>();
				questions.add(Constants.OSPREY_1);
				questions.add(Constants.OSPREY_2);
				questions.add(Constants.OSPREY_3);
				questions.add(Constants.OSPREY_4);
				questions.add(Constants.OSPREY_5);
				questions.add(Constants.OSPREY_6);
				questions.add(Constants.OSPREY_7);
				questions.add(Constants.OSPREY_8);
				questions.add(Constants.OSPREY_9);
				questions.add(Constants.OSPREY_10);
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
				questions.add(Constants.CR_6);
				questions.add(Constants.CR_7);
				questions.add(Constants.CR_8);
				questions.add(Constants.CR_9);
				questions.add(Constants.CR_10);
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
		question = ourQuestions.get(qNumber);
		ourQuestions.remove(qNumber);
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
		question.setHorizontalAlignment(JLabel.CENTER);
		question.setVerticalAlignment(JLabel.TOP);
		question.setOpaque(true);
        question.setFont(new Font("Serif", Font.BOLD, 15));
        question.setBackground(Color.WHITE);
        question.setMinimumSize(new Dimension(200, 5));
        question.setPreferredSize(new Dimension(200, 5));
        question.setMaximumSize(new Dimension(200, 5));
		p.add(question);
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
			if (rightAnswers != null) { return rightAnswers;}
			else {
				rightAnswers = new ArrayList<JButton>();
				rightAnswers.add(Constants.OSPREY_CORRECT1);
				rightAnswers.add(Constants.OSPREY_CORRECT2);
				rightAnswers.add(Constants.OSPREY_CORRECT3);
				rightAnswers.add(Constants.OSPREY_CORRECT4);
				rightAnswers.add(Constants.OSPREY_CORRECT5);
				rightAnswers.add(Constants.OSPREY_CORRECT6);
				rightAnswers.add(Constants.OSPREY_CORRECT7);
				rightAnswers.add(Constants.OSPREY_CORRECT8);
				rightAnswers.add(Constants.OSPREY_CORRECT9);
				rightAnswers.add(Constants.OSPREY_CORRECT10);
				
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
				rightAnswers.add(Constants.CR_CORRECT6);
				rightAnswers.add(Constants.CR_CORRECT7);
				rightAnswers.add(Constants.CR_CORRECT8);
				rightAnswers.add(Constants.CR_CORRECT9);
				rightAnswers.add(Constants.CR_CORRECT10);
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
			if (wrongAnswers != null) {return wrongAnswers;}
			else {
				wrongAnswers = new ArrayList<JButton>();
				wrongAnswers.add(Constants.OSPREY_INCORRECT1);
				wrongAnswers.add(Constants.OSPREY_INCORRECT2);
				wrongAnswers.add(Constants.OSPREY_INCORRECT3);
				wrongAnswers.add(Constants.OSPREY_INCORRECT4);
				wrongAnswers.add(Constants.OSPREY_INCORRECT5);
				wrongAnswers.add(Constants.OSPREY_INCORRECT6);
				wrongAnswers.add(Constants.OSPREY_INCORRECT7);
				wrongAnswers.add(Constants.OSPREY_INCORRECT8);
				wrongAnswers.add(Constants.OSPREY_INCORRECT9);
				wrongAnswers.add(Constants.OSPREY_INCORRECT10);
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
				wrongAnswers.add(Constants.CR_INCORRECT6);
				wrongAnswers.add(Constants.CR_INCORRECT7);
				wrongAnswers.add(Constants.CR_INCORRECT8);
				wrongAnswers.add(Constants.CR_INCORRECT9);
				wrongAnswers.add(Constants.CR_INCORRECT10);
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
			if (mWAnswers != null) {return mWAnswers;}
			else {
				mWAnswers = new ArrayList<JButton>();
				mWAnswers.add(Constants.OSPREY_WRONG1);
				mWAnswers.add(Constants.OSPREY_WRONG2);
				mWAnswers.add(Constants.OSPREY_WRONG3);
				mWAnswers.add(Constants.OSPREY_WRONG4);
				mWAnswers.add(Constants.OSPREY_WRONG5);
				mWAnswers.add(Constants.OSPREY_WRONG6);
				mWAnswers.add(Constants.OSPREY_WRONG7);
				mWAnswers.add(Constants.OSPREY_WRONG8);
				mWAnswers.add(Constants.OSPREY_WRONG9);
				mWAnswers.add(Constants.OSPREY_WRONG10);
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
				mWAnswers.add(Constants.CR_WRONG6);
				mWAnswers.add(Constants.CR_WRONG7);
				mWAnswers.add(Constants.CR_WRONG8);
				mWAnswers.add(Constants.CR_WRONG9);
				mWAnswers.add(Constants.CR_WRONG10);
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
		right = rightAnswer.get(qNumber);
		rightAnswer.remove(qNumber);
		wrong = wrongAnswer.get(qNumber);
		wrongAnswer.remove(qNumber);
		mW = moreWrong.get(qNumber);
		moreWrong.remove(qNumber);
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
		right = correct;
		wrong = incorrect;
		mW = veryWrong;
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		Random l = new Random();
		int answerOrder = l.nextInt(6);
		switch(answerOrder) {
			case 0: buttons.add(right);
					buttons.add(wrong);
					buttons.add(mW);
					break;
			case 1: buttons.add(right);
					buttons.add(mW);
					buttons.add(wrong);
					break;
			case 2: buttons.add(wrong);
					buttons.add(right);
					buttons.add(mW);
					break;
			case 3: buttons.add(wrong);
					buttons.add(mW);
					buttons.add(right);
					break;
			case 4: buttons.add(mW);
					buttons.add(wrong);
					buttons.add(right);
					break;
			case 5: buttons.add(mW);
					buttons.add(right);
					buttons.add(wrong);
					break;
			
		}
			
		for (JButton b :buttons) {
			b.addActionListener(this);
			b.setFocusPainted(false);
			b.setOpaque(true);
			b.setBackground(Color.WHITE);
			b.setMinimumSize(new Dimension(300, 20));
            b.setPreferredSize(new Dimension(300, 20));
            b.setMaximumSize(new Dimension(300, 20));
        	b.setVerticalAlignment(JButton.TOP);
        	b.setHorizontalAlignment(JButton.CENTER);
        	b.setFont(new Font("Serif", Font.BOLD, 15));
        	p.add(b);
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		new Quiz("sides");
	}
	
	
	/**
	 * @param none
	 * 
	 * adds an ActionListener to each JButton 
	 *  
	 * 
	 * @author tim mazzarelli
	 */
	
	
	public void addActionListener(Quiz q) {	
	}
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.setModal(false);
		this.dispose();
		if (e.getSource() == right) {
			System.out.println("right");
			
		}
		if (e.getSource() == wrong) {
			System.out.println("wrong");
			
		}
		if (e.getSource() == mW) {
			System.out.println("wrong");
			
		}
		
	}

	


	

}

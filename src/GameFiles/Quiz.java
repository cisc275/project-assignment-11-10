package GameFiles;
import java.io.File;
import javax.swing.JButton;
/**
 * represents the quiz at the end of each game 
 *
 */
public class Quiz extends Controllable {
	/**
	 * @param y
	 * @param x
	 * @param imgPose
	 * @param width
	 * @param height
	 * @param xMin
	 * @param xMax
	 * @param yMin
	 * @param yMax
	 * @param speed
	 * @param answer
	 * @param bad
	 * @param question
	 * 
	 * a constructor that takes values for all fields as input parameters
	 */
	/*
	 * (int y, int x, File imgPose, int width, int height, int xMin, int xMax, int yMin, 
			int yMax, boolean isDiving, int currY, int xSpeed, int ySpeed) {
	 */
	public Quiz(int y, int x, File imgPose, int width, int height, int xMin, int xMax, int yMin, 
			int yMax, boolean isDiving, int currY, int xSpeed, int ySpeed, 
			JButton answer, JButton bad, String question) {
		super(y, x, imgPose, width, height, xMin, xMax, yMin, yMax, isDiving, currY, xSpeed, ySpeed);
	}
	/**
	 * button that will allow the user to select the correct answer
	 */
	JButton answer; 
	/**
	 * button that will allow the user to select incorrect answer(s)
	 */
	JButton bad; 
	/**
	 * string that will contain the question being asked during the quiz
	 */
	String question;
	public JButton getAnswer() {
		return answer;
	}
	public void setAnswer(JButton answer) {
		this.answer = answer;
	}
	public JButton getBad() {
		return bad;
	}
	public void setBad(JButton bad) {
		this.bad = bad;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	} 
}

package GameFiles;
import javax.swing.JButton;
/**
 * represents the quiz at the end of each game 
 *
 */
public class Quiz extends Controllable {
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
}

package GameFiles;
import javax.swing.JButton;
/**
 * View for the selection screen
 */
public class SelectionView extends View{
	/**
	 * button that will allow user to select the osprey game
	 */
	JButton osprey; 
	/**
	 * button that will allow user to select the clapperrail game
	 */
	JButton clapperRail;
	public JButton getOsprey() {
		return osprey;
	}
	public void setOsprey(JButton osprey) {
		this.osprey = osprey;
	}
	public JButton getClapperRail() {
		return clapperRail;
	}
	public void setClapperRail(JButton clapperRail) {
		this.clapperRail = clapperRail;
	} 
}

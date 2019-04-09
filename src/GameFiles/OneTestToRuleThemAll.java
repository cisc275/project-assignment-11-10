package GameFiles;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OneTestToRuleThemAll {
	
	@Test
	void testSelectionModel() {
		
	}
	
	@Test
	void testSideScrollModel() {
		SideScrollModel scm = new SideScrollModel();
		ArrayList<GameObject> go = new ArrayList<GameObject>();
		go.add(new Osprey());
		gp.add(new Fish());
		int oldx1 = scm.getGame().get(0).getX();
		int oldy1 = scm.getGame().get(0).getY();
		int oldx2 = scm.getGame().get(1).getX();
		int oldy2 = scm.getGame().get(1).getY();
		scm.setGame(go);
		scm.advanceWorld();
		assertNotEquals(oldx1,scm.getGame().get(0).getX());
		assertNotEquals(oldy1,scm.getGame().get(0).getY());	
		assertNotEquals(oldx2,scm.getGame().get(1).getX());
		assertEquals(oldy2,scm.getGame().get(1).getY());	
		
		
	}

	@Test
	void testTopDownModel() {
		TopDownModel tdm = new TopDownModel();
		ArrayList<GameObject> go = new ArrayList<GameObject>();
		go.add(new ClapperRail());
		go.add(new Bush());
		int oldx1 = tdm.getGame().get(0).getX();
		int oldy1 = tdm.getGame().get(0).getY();
		int oldx2 = tdm.getGame().get(1).getX();
		int oldy2 = tdm.getGame().get(1).getY();
		tdm.setGame(go);
		tdm.update();
		assertNotEquals(oldx1,tdm.getGame().get(0).getX());
		assertNotEquals(oldy1,tdm.getGame().get(0).getY());
		assertEquals(oldx2,tdm.getGame().get(1).getX());
		assertEquals(oldy2,tdm.getGame().get(1).getY());
	}
	
	@Test
	void testTopDownView() {
		
	}
}

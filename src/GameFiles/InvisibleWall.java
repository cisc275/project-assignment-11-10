package GameFiles;

public class InvisibleWall extends NonControllable {

	public InvisibleWall(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.imgFileName = Constants.ANIMATION_BACKGROUND;
	}
	
	@Override
	public void handleCollision(Osprey o) {
		int y1 = o.hitbox.ypoints[0];
		int y2 = o.hitbox.ypoints[1];
		int y3 = o.hitbox.ypoints[2];
		int y4 = o.hitbox.ypoints[3];
		o.hitbox.reset();
		o.hitbox.addPoint(x, y1);
		o.hitbox.addPoint(x, y2);
		o.hitbox.addPoint(x + width, y3);
		o.hitbox.addPoint(x + width, y4);
	}

}

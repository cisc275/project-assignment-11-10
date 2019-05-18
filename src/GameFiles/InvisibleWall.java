package GameFiles;

public class InvisibleWall extends NonControllable {

	public InvisibleWall(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.hitbox.addPoint(x, y);

	}
	
	@Override
	public void handleCollision(Osprey o) {
		System.out.println("hey");
		if (!o.isDiving) {
		o.hitbox.reset();
		o.hitbox.addPoint(o.x, this.hitbox.ypoints[0] - o.height);
		o.hitbox.addPoint(o.x, this.hitbox.ypoints[0]);
		o.hitbox.addPoint(o.x + o.width, this.hitbox.ypoints[0]);
		o.hitbox.addPoint(o.x + o.width, this.hitbox.ypoints[0] - o.height);
		}
	}
}

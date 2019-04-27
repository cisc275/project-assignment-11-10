package testing;


public class ZOsprey1 extends ZGameObject1{
	static double xSpeed;
	int ySpeed;
	int currY;
	boolean isDiving;
	final double AC = 0.2;

public ZOsprey1(int x, double xSpeed, boolean isDiving) {
	this.x = x;
	ZOsprey1.xSpeed = xSpeed;
	this.currY = this.ypoints[0];
	this.isDiving = isDiving;
	this.addPoint(this.x, this.x);
	this.addPoint(this.x, this.x + this.x);
	this.addPoint(this.x + this.x, this.x + this.x);
	this.addPoint(this.x + this.x, this.x);

}

public static double getXSpeed() {
	return ZOsprey1.xSpeed;
}

public void setXSpeed(double d) {
	ZOsprey1.xSpeed = d;
}

public void move() {
	this.translate(0, this.ySpeed);
	if (this.ypoints[0] >= 600) {
		this.ySpeed = -30;
	}
	if ((this.ypoints[0] == this.currY) && (this.isDiving == true)) {
		this.ySpeed = 0;
		this.isDiving = !this.isDiving;
	}
}

public void dive() {
	this.isDiving = !this.isDiving;
	this.ySpeed = 30;
	this.currY = this.ypoints[0];
	this.translate(0, this.ySpeed);
	}


public void collision(ZFish1 f, ZTrash1 t, ZAirCurrent a) {
	if (this.collidesWith(f)){
		this.setXSpeed(ZOsprey1.getXSpeed() - AC);
	}
	if (this.collidesWith(t) || this.collidesWith(a)){
		this.setXSpeed(ZOsprey1.getXSpeed() + AC);	
	}
	
}

}

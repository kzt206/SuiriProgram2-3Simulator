package suiri2_3;

public class FloodCell {
	private int x;
	private int y;
	private double zb;
	private char ip;
	private double rn;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public double getZb() {
		return zb;
	}
	public void setZb(double zb) {
		this.zb = zb;
	}
	public char getIp() {
		return ip;
	}
	public void setIp(char ip) {
		this.ip = ip;
	}
	public double getRn() {
		return rn;
	}
	public void setRn(double rn) {
		this.rn = rn;
	}
	
	@Override
	public String toString() {
		return "x="+this.getX()+", y="+this.getY()+", IP="+this.getIp()+", ZB="+this.getZb()+", RN="+this.getRn();
	}
}

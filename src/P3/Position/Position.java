package P3.Position;

public class Position {

	// AF:x对应横坐标上的x点，y对应纵坐标上的y点
	// RI x,y>=0
	// secure way:using defensive copy and all fields are private
	private int x;
	private int y;
	//checkRep
	public void checkRep() {
		assert x>=0;
		assert y>=0;
	}
	public Position(int x_1, int y_1) {
		this.x = x_1;
		this.y = y_1;
		checkRep();
	}

	public int getX() {
		int a = this.x;
		checkRep();
		return a;
	}

	public int getY() {
		int a = this.y;
		checkRep();
		return a;
	}

	public void setPosition(int x_1, int y_1) {
		this.x = x_1;
		this.y = y_1;
		checkRep();
	}

	public boolean equals(Position position_1) {
		if ((position_1.x == this.x) && (position_1.y == this.y)) {
			checkRep();
			return true;
		} else {
			checkRep();
			return false;
		}
			
	}

}

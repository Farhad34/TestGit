package lab3.a;

import javafx.scene.paint.Color;

abstract public class FillableShape extends Shape{
	
	private boolean filled;
	
	protected FillableShape(double x, double y, Color color, boolean fill) {
		super(x,y,color);
		filled = fill;
	}
	
	protected FillableShape() {
		super();
		filled = false;
	}
	
	public boolean isFilled() {
		if(filled)
			return true;
		return false;
	}
	
	public void setFilled(boolean fill) {
		filled = fill;
	}

}

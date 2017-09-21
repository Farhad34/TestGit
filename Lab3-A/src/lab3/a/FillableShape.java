package lab3.a;

abstract public class FillableShape extends Shape{
	
	private boolean filled;
	
	protected FillableShape() {
		super();
		filled = false;
	}
	
	protected FillableShape(boolean fill) {
		super();
		filled = fill;
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

package lab3.a;

import javafx.scene.canvas.GraphicsContext;

public class Circle extends FillableShape{
	
	private double diameter;
	
	public Circle() {
		super();
		diameter = 3;
	}
	
	public Circle(double diameter) {
		super();
		this.diameter = diameter;
	}
	
	public double getDiameter() {
		return diameter;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	@Override
	public void paint(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void constrain(
            double boxX, double boxY, 
            double boxWidth, double boxHeight) {
		        // If outside the box - calculate new dx and dy
        if (getDx() < boxX) {
            setDx(Math.abs(getDx()));
        } else if (getDx() > boxWidth) {
        	setDx(-Math.abs(getDx()));
        }
        if (getDy() < boxY) {
        	setDy(Math.abs(getDy()));
        } else if (getDy() > boxHeight) {
        	setDy(-Math.abs(getDy()));
        }
    }

	@Override
	public String toString() {
		return "Circle [diameter=" + diameter + "]";
	}
	
}

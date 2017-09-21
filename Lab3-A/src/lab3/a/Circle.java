package lab3.a;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

// @author FarHad Salehi and Tahir Sabe

public class Circle extends FillableShape{
	
	private double diameter;
	
	public Circle(double x, double y, Color color, double diameter, boolean fill) {
		super(x, y, color, fill);
		this.diameter = diameter;
	}
	
	public Circle() {
		super();
		diameter = 50;
	}
	
	public double getDiameter() {
		return diameter;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	@Override
	public void paint(GraphicsContext gc) {
		gc.setStroke(getColor());
		gc.strokeOval(getX(),getY(),diameter,diameter);
		if(isFilled()) {
			gc.setFill(getColor());
			gc.fillOval(getX(),getY(),diameter,diameter);
		}
	}
	
	@Override
	   public void constrain(
	            double boxX, double boxY, 
	            double boxWidth, double boxHeight) {
	        // If outside the box - calculate new dx and dy
	        super.constrain(boxX, boxY, boxWidth, boxHeight);
	        double dx = getDx(),dy = getDy();
	        
	        if ((getX() + diameter) < boxX) {
	            dx = Math.abs(getDx());
	         } else if ((getX() + diameter) > boxWidth) {
	         	dx = -Math.abs(getDx());
	         }
	         if ((getY() + diameter) < boxY) {
	         	dy = Math.abs(getDy());
	         } else if ((getY() + diameter) > boxHeight) {
	         	dy = -Math.abs(getDy());
	         }
	         setVelocity(dx, dy);
	   }

	@Override
	public String toString() {
		return "Circle [diameter=" + diameter + "]";
	}
	
}

package lab3.a;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends FillableShape{
	
	private double width, height;
	
	public Rectangle(double x, double y, Color color, double width, double height, boolean fill) {
		super(x,y,color,fill);
		this.width = width;
		this.height = height;
	}
	
	public Rectangle() {
		super();
		width = 60;
		height = 20;
	}
	
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public void paint(GraphicsContext gc) {
		gc.setStroke(getColor());
		gc.strokeRect(getX(),getY(), width, height);
		if(isFilled()) {
			gc.setFill(getColor());
			gc.fillRect(getX(),getY(), width, height);
		}
	}
	
	@Override
	   public void constrain(
	            double boxX, double boxY, 
	            double boxWidth, double boxHeight) {
	        // If outside the box - calculate new dx and dy
	        super.constrain(boxX, boxY, boxWidth, boxHeight);
	        double dx = getDx(),dy = getDy();
	        
	        if ((getX()+width) < boxX) {
	            dx = Math.abs(getDx());
	         } else if ((getX()+width) > boxWidth) {
	         	dx = -Math.abs(getDx());
	         }
	         if ((getY()+height) < boxY) {
	         	dy = Math.abs(getDy());
	         } else if ((getY()+height) > boxHeight) {
	         	dy = -Math.abs(getDy());
	         }
	         setVelocity(dx, dy);
	   }


	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + "]";
	}


}

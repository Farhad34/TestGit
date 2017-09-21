package lab3.a;

import javafx.scene.canvas.GraphicsContext;

public class Rectangle extends FillableShape{
	
	private double width, height;
	
	public Rectangle() {
		super();
		width = 6;
		height = 2;
	}
	
	public Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
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
		return "Rectangle [width=" + width + ", height=" + height + "]";
	}


}

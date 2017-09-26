/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3.a;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author FarHad Salehi and Tahir Sabe
 */
public class Line extends Shape {
    
   private double x2, y2;
   
   
   public Line(double x, double y, double x2, double y2, Color color){
       super(x,y, color);
       this.x2=x2;
       this.y2=y2; 
   }
   

   public Line(){
       super();
       x2 = 60;
       y2 = 60; 
   }
   
   public double getX2()
   {
      return x2;
   }
   
   public double getY2()
   {
       return y2;
   }

   public void setX2(double x2)
   {
      this.x2=x2;
   }
   
   public void setY2(double y2)
   { 
       this.y2=y2;
   }
           
           
    @Override
    public void paint(GraphicsContext gc) {
       
    	gc.setStroke(getColor()); 
        gc.strokeLine(getX(), getY(), x2, y2);   
    }
    
    @Override
    public void move(long elapsedTimeNs)
    {
        super.move(elapsedTimeNs);
        x2 +=this.getDx()* elapsedTimeNs / BILLION;
        y2 +=this.getDy()* elapsedTimeNs / BILLION;
             
    }
   
    
   @Override
   public void constrain(
            double boxX, double boxY, 
            double boxWidth, double boxHeight) {
        // If outside the box - calculate new dx and dy
        super.constrain(boxX, boxY, boxWidth, boxHeight);
        double dx = getDx(),dy = getDy();
        
        if (x2 < boxX) {
            dx = Math.abs(getDx());
         } else if (x2 > boxWidth) {
         	dx = -Math.abs(getDx());
         }
         if (y2 < boxY) {
         	dy = Math.abs(getDy());
         } else if (y2 > boxHeight) {
         	dy = -Math.abs(getDy());
         }
         setVelocity(dx, dy);
   }

	@Override
	public String toString() {
		return "Line [x2=" + x2 + ", y2=" + y2 + "]";
	}
}

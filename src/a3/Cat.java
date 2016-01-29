/*Omar Portillo
 *CSC133
 *A3 for Dog Catcher Game
 * 
 * This class handles functions regarding Cat
 */
package a3;

import java.awt.Graphics;
import java.text.DecimalFormat;

public class Cat extends  Animal implements IDrawable{
	
	private boolean kitFlag;
	
	public void setColor(){
		//Cat can't change color
	}
	
	public String toString() {
		String catDetails = "Cat: ";
		
		//formatting 
		DecimalFormat df = new DecimalFormat();
		df.applyPattern("##.#");
		
		//location
		catDetails += "loc= " + df.format(getxLoc()) + "," + df.format(getyLoc() ) + " ";
		
		// color
		catDetails += " color=[" + getColor().getRed() + "," + getColor().getGreen() + "," + getColor().getBlue() + "]";
		
		// size
		catDetails += " size=" + getSize();
				
		// speed
		catDetails += " speed= " + df.format( getSpeed() ) + " ";
				
		//direction
		catDetails += "dir=" + getDirection() + " ";
		
		
		//return all the details
		return catDetails;
	}
	
	@Override
	public void draw(Graphics g) {
			
			int x = (int) getxLoc();
			int y = (int) getyLoc();
			int w = ((getSize())/2);
			
			int p1 = (w * w);
			int p2 = (getSize()*getSize());
			int p3 = (p2 - p1);
			int rotation =  (int) Math.sqrt(p3);
			
			int x1 = (x-w);
			int y1 = (y - (rotation/2));
			int y2 = (y + (rotation/2));
			int x2 = (x1 + getSize());
			
			g.setColor(getColor());
			g.drawLine(x1, y1, x, y2);
			g.drawLine(x2, y1, x, y2);
			g.drawLine(x1, y1, x2, y1);
	
	}

	
	
	public boolean isKitten() {
		return kitFlag;
	}

	

	public void setKitten(boolean b) {

		if (b)
			kitFlag = true;
		else
			kitFlag = false;
	}

	@Override
	public void move() {
		
	}

	

	public void resetCollisionCount() {
		// TODO Auto-generated method stub
		
	}
	
}

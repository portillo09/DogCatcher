/*Omar Portillo
 *CSC133
 *A2 for Dog Catcher Game
 * 
 * This class handles functions regarding Cat
 */
package a2;

import java.text.DecimalFormat;

public class Cat extends  Animal {
	
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
	
}

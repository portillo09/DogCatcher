/*Omar Portillo
 *CSC133
 *A1 for Dog Catcher Game
 * 
 * 
 */
package a1;
import java.text.DecimalFormat;

//Concrete class of Abstract Animal	
public class Dog extends Animal  {
	
	private int scratches;
	
	public int getScratches() {
		return scratches;
	}

	public void setScratches(int scratches) {
		this.scratches = scratches;
	}

	public String toString() {
		String dogDetails = "Dog: ";
		
		//formatting 
		DecimalFormat df = new DecimalFormat();
		df.applyPattern("##.#");
		
		//location
		dogDetails += "loc= " + df.format(getxLoc()) + "," + df.format(getyLoc() ) + " ";
		// color
		dogDetails += "color=[" + getColor().getRed() + "," + getColor().getGreen() + "," + getColor().getBlue() + "] ";
		// size
		dogDetails += "size= " + getSize();		
		// speed
		dogDetails += " speed= " + df.format( getSpeed() ) + " ";		
		//direction
		dogDetails += " dir=" + getDirection() + " ";
		//scratches 
		dogDetails += "scratches=" + getScratches();
		//return all the details
		return dogDetails;
	}

}

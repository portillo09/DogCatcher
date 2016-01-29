/*Omar Portillo
 *CSC133
 *A2 for Dog Catcher Game
 * 
 * This class handles the functions 
 * only used by the Dog.
 */
package a2;
import java.text.DecimalFormat;

public class Dog extends Animal  {
	
	private int scratches;
	
	public int getScratches() {
		return scratches;
	}

	public void upScratches() {
		scratches++;

		// SET speed to 0 if scratches = 5
		if (scratches >= 5) {
			setSpeed(0);
		}
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

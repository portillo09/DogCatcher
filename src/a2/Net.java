/*Omar Portillo
 *CSC133
 *A2 for Dog Catcher Game
 * 
 * The class handls any function for the net object
 */
package a2;
import java.text.DecimalFormat;

public class Net extends Catcher{
	
	@Override
	public String toString() {
		String netDetails = "Net: ";
		
		//Formatting 
		DecimalFormat df = new DecimalFormat();
		df.applyPattern("##.#");
		
		//Location
		netDetails += "loc= " + df.format(getxLoc()) + "," + df.format(getyLoc() ) + " ";
		//Color
		netDetails += " color=[" + getColor().getRed() + "," + getColor().getGreen() + "," + getColor().getBlue() + "] ";
		//Size
		netDetails += "size=" + getSize();
					
		//return all details
		return netDetails;
	}

}

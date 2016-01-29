/*Omar Portillo
 *CSC133
 *A1 for Dog Catcher Game
 * 
 * 
 */
package a1;
import java.text.DecimalFormat;

//Concrete Class of Abstract Catcher
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

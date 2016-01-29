/*Omar Portillo
 *CSC133
 *A3 for Dog Catcher Game
 * 
 * The class handls any function for the net object
 */
package a3;
import java.awt.Graphics;
import java.text.DecimalFormat;

public class Net extends Catcher implements IDrawable{
	
	
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
	
	
	@Override
	public void draw(Graphics g) {
		g.drawRect((int) getxLoc(), (int) getyLoc(), 
						 getSize(), (getSize()-35));
	}


	

}

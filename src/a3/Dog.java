/*Omar Portillo
 *CSC133
 *A3 for Dog Catcher Game
 * 
 * This class handles the functions 
 * only used by the Dog.
 */
package a3;
import java.awt.Graphics;
import java.awt.Point;
import java.text.DecimalFormat;

public class Dog extends Animal implements IDrawable, ISelectable {
	
	private int scratches=0;
	private boolean selected;
	//private GameWorld gw;
	
	
	public int getScratches() {
		return scratches;
	}

	public void setScratches(int scratches) {
		this.scratches = scratches;
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

	@Override
	public void draw(Graphics g) {
		
		g.setColor(getColor());
		g.drawOval((int)getxLoc(), (int)getyLoc(), (getSize())/2,(getSize())/2);
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	
	public void setSelected(boolean s) {
		selected = s;
	}
	
	public boolean isSelected() {
		return selected;
	}
	

	public void resetScratches() {
		scratches = 0;
	}

	public boolean contains(Point po) {
		float xa, xb,
			  ya, yb;
		xb = getxLoc() - (getSize()/2);
		xa = getxLoc() + (getSize()/2);
		
		yb = getyLoc() - (getSize()/2);
		ya = getyLoc() + (getSize()/2);
		
		if(po.getX() >= xb && po.getX() <= xa){
			if(po.getY() >= yb && po.getY() <= ya) 
				return true;
		}
		return false;
    }

	


}




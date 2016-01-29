/*Omar Portillo
 *CSC133
 *A3 for Dog Catcher Game
 * 
 * This class contains all functions and 
 * data for the Catcher Object
 */
package a3;

public abstract class Catcher extends GameObject implements IGuided{

	public void expandNet() {
		float x, y;
		
		setSize(getSize() + 8);
		
		// check the right boundary
	    if (getxLoc() > 610- (getSize() / 2)) {
	    	x = 610 - (getSize() / 2);
			y = getyLoc();
			setLocation(x, y);
		}
	    // check the left boundary
		if (getxLoc() < getSize() / 2) {
			x = getSize() / 2;
			y = getyLoc();
			setLocation(x, y);
		}
		// check the top boundary
		if (getyLoc() > 830 - (getSize() / 2)) {
			y = 830 - (getSize() / 2);
			x = getxLoc();
			setLocation(x, y);
		}
		// check the bottom boundary
		if (getyLoc() < getSize() / 2) {
			y = getSize() / 2;
			x = getxLoc();
			setLocation(x, y);
				}
		

	}

	public void contractNet() {
		setSize(getSize() - 8);
	}	
    
	public void moveRight(){
    	float x = getxLoc();
		x = x + 7f;

		// check right
		if (x > 610 - (getSize() / 2)) {
			x = 610 - (getSize() / 2);
		}
		setLocation(x, getyLoc());
    }
    
	public void moveLeft(){
    	float x = getxLoc();
		x = x - 7f;

		// checkleft
		if (x < getSize() / 2) {
			x = getSize() / 2;
		}
		setLocation(x, getyLoc());
    }
    
	public void moveDown(){
		float y = getyLoc();
		y = y + 7f;

		// check top
		if (y > 830 - (getSize() / 2)) {
			y = 830 - (getSize() / 2);
		}
		setLocation(getxLoc(), y);

    }
    
	public void moveUp(){
		float y = getyLoc();
		y = y - 7f;

		// check bottm
		if (y < getSize() / 2) {
			y = getSize() / 2;
		}
		setLocation(getxLoc(), y);
		

    	
    }
	
}

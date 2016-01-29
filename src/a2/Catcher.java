/*Omar Portillo
 *CSC133
 *A2 for Dog Catcher Game
 * 
 * This class contains all functions and 
 * data for the Catcher Object
 */
package a2;

public abstract class Catcher extends GameObject implements IGuided{

	public void expandNet() {
		setSize(getSize() + 8);

	}

	public void contractNet() {
		setSize(getSize() - 8);
	}	
    
	public void moveRight(){
    	float x = getxLoc();
		x = x + 7f;

		// CHECK RIGHT SIDE
		if (x > getWidth() - (getSize() / 2)) {
			x = getWidth() - (getSize() / 2);
		}
		setLocation(x, getyLoc());
    }
    
	public void moveLeft(){
    	float x = getxLoc();
		x = x - 7f;

		// CHECK LEFT SIDE
		if (x < getSize() / 2) {
			x = getSize() / 2;
		}
		setLocation(x, getyLoc());
    }
    
	public void moveDown(){
    	float y = getyLoc();
		y = y - 7f;

		// CHECK BOTTOM
		if (y < getSize() / 2) {
			y = getSize() / 2;
		}
		setLocation(getxLoc(), y);

    }
    
	public void moveUp(){

    	float y = getyLoc();
		y = y + 7f;

		// CHECK TOP
		if (y > getHeight() - (getSize() / 2)) {
			y = getHeight() - (getSize() / 2);
		}
		setLocation(getxLoc(), y);
    }
	
}

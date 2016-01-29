/*Omar Portillo
 *CSC133
 *A1 for Dog Catcher Game
 * 
 * 
 */
package a1;

public abstract class Catcher extends GameObject implements IGuided{

	
	
    public void moveRight(){
        setLocation(getxLoc()+4f,getyLoc());
    }

    public void moveLeft(){
        setLocation(getxLoc()-4f,getyLoc());
    }
    public void moveDown(){
        setLocation(getxLoc(),getyLoc()-4f);

    }
    public void moveUp(){

        setLocation(getxLoc(),getyLoc()+4f);
    }
	
	
	
}

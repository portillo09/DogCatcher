/*Omar Portillo
 *CSC133
 *A2 for Dog Catcher Game
 * 
 * This class handles all functions and data
 * for the Animal Object
 */
package a2;

import java.util.Random;
public abstract class Animal extends GameObject implements IMove{
	
	
	private int direction;
	private int speed ;
	private Random rand;
	private float tempX;
	private float tempY;

	public Animal(){
		
	}
	
	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	public void decSpeed() { 
		speed = speed - 1;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void randSpeed() {
		speed = rand.nextInt(5 - 1) + 1;
	}
	
	public void setSize() {
		// Blank Cant change size
	}

	public void move(){

	        rand = new Random();
	        float dx= (float) Math.cos(90-getxLoc())*speed;
	        float dy= (float) Math.sin(90-getyLoc())*speed;
	        tempX = getxLoc()+dx;
	        tempY = getyLoc()+dy;

	        
	        //left check
	        if(tempX < getSize()/2){
	            tempX = getSize()/2 + rand.nextFloat()*getSize()/2;
	        }
	        //right check
	        else if(tempY > 1024 - (getSize()/2)){
	            tempX = 1024 - (getSize()/2 + rand.nextFloat()*getSize()/2);
	        }

	        //bottom check
	        if(tempY < getSize()/2){
	            tempY = getSize()/2 + rand.nextFloat()*getSize()/2;
	        }
	        //top check
	        else if(tempY > 1024 - (getSize()/2)){
	            tempY = 1024 - (getSize()/2 + rand.nextFloat()*getSize()/2);
	        }

	            setLocation((tempX), (tempY));
	            setDirection(rand.nextInt(360));


	    }
}
	

	
		
	



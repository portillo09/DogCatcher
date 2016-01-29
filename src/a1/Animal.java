/*Omar Portillo
 *CSC133
 *A1 for Dog Catcher Game
 * 
 * 
 */
package a1;

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


	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
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
	

	
		
	



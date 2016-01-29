/*Omar Portillo
 *CSC133
 *A3 for Dog Catcher Game
 * 
 * This class handles all functions and data
 * for the Animal Object
 */
package a3;


public abstract class Animal extends GameObject implements IMove, ICollider{
	
	
	private int direction;
	private int speed ;
	private boolean collision;
	private GameWorld gw;
	private Sound theSounds = Sound.getInstance(); 

	
	public GameWorld getGw(){
		return gw;
	}
	
	public void setGw(GameWorld gw){

		this.gw =gw;
	}
	
	public Animal(){
		
	}
	
	public boolean isCollision() {
		return collision;
	}

	public void setCollision(boolean collision) {
		this.collision = collision;
	}
    
	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	public void decSpeed() { 
		if(speed>=0)
		speed = speed - 1;
		else
			speed=0;
		
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void setSize() {
		// Blank Cant change size
	}

	public void move(int DELAY){
					
	        float dx= (float) Math.cos(90-direction)*speed/2;
	        float dy= (float) Math.sin(90-direction)*speed/2;
	        
	        setX(getxLoc() + dx);
	        setY(getyLoc() + dy);
	        
	        if (((getxLoc() <= 0) || (getxLoc() >= 650)) ||
	        	((getyLoc() <= 0) || (getyLoc() >= 490))){

	        	direction = direction - 180;
	        	}								        

	    }
	
	@Override
	 public boolean collidesWith(ICollider otherObject) {
        float point1x = getxLoc();
        float point2x = getxLoc() + getSize();
        float point3x = getxLoc();
        float point4x = getxLoc() + getSize();
        float point1y = getyLoc();
        float point2y = getyLoc();
        float point3y = getyLoc() + getSize();
        float point4y = getyLoc() + getSize();
        

        Animal obj = (Animal) otherObject;
        float aPoint1x = obj.getxLoc();
        float aPoint2x = obj.getxLoc() + obj.getSize();
        float aPoint3x = obj.getxLoc();
        float aPoint1y = obj.getyLoc();
        float aPoint2y = obj.getyLoc() + obj.getSize();

        if ((point1x > aPoint1x && point1x < aPoint2x) && (point1y > aPoint1y && point1y < aPoint2y) ||
            (point2x > aPoint1x && point2x < aPoint2x) && (point2y > aPoint1y && point2y < aPoint2y) ||
            (point3x > aPoint1x && point3x < aPoint2x) && (point3y > aPoint1y && point3y < aPoint2y) ||
            (point4x > aPoint1x && point4x < aPoint2x) && (point4y > aPoint1y && point4x < aPoint3x)) 
        { 
          setCollision(true);
          return true;
        } else {
            setCollision(false);
            return false;
        }
    }

    public void handleCollision(ICollider otherObject) {
        
    	if (otherObject instanceof Dog){
            Dog dog = (Dog) otherObject;
            
            if(dog.getScratches()<5){
	    		gw.fight();
				//System.out.println("here");
	
				if(dog.getSpeed()>0){
					dog.setSpeed(dog.getSpeed()-1);
				 }
				
				if(gw.soundIsOn())
					theSounds.playFightCollisisonClip();
				dog.upScratches();
				dog.setRandomColor();
            }	
            
        }else if (otherObject instanceof Cat) {
        	gw.catAdd();
        	
        }
    	
    }

    
}
	

	
		
	



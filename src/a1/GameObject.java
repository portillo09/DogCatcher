/*Omar Portillo
 *CSC133
 *A1 for Dog Catcher Game
 * 
 * 
 */
package a1;
import java.awt.Color;
import java.util.Vector;
import java.util.Random;

//This class represents an object in the Game World
//This is where both the animal and catcher get info
public class GameObject {

    private Vector<Float> location;
	private int size;
	private Color color;
	
	public GameObject(){
		location = new Vector<>();
		location.setSize(2);
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public float getxLoc() {
		return location.get(0);
	}

	public float getyLoc() {
		return location.get(1);
	}

	public void setLocation(float x, float y) {
        location.set(0,x);
        location.set(1,y);
    }

	//Used this to change color of Dog
	public void setRandomColor(){
		Color c = new Color(randInt(0,255), randInt(0,255), randInt(0,255));
		setColor(c);
	}
	
	public static int randInt(int min, int max){
		
		Random rand = new Random();
		int randNum= rand.nextInt((max-min)+1) +min;
		return randNum;
	}
	



	

	
}


/*Omar Portillo
 *CSC133
 *A2 for Dog Catcher Game
 * 
 * The class contains all functions and data
 * for all Game Objects 
 */
package a2;
import java.awt.Color;
import java.util.Vector;
import java.util.Random;

public class GameObject {

    private Vector<Float> location;
	private int size;
	private Color color;
	private int gHeight = 1024;
	private int gWidth = 1024;
	
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
	
	public int getHeight() {
		return gHeight;
	}

	public int getWidth() {
		return gWidth;
	}

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


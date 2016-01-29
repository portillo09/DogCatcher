/*Omar Portillo
 *CSC133
 *A3 for Dog Catcher Game
 * 
 * This is the Collider interface for gameobjects
 */
package a3;

public interface ICollider {
	
public boolean collidesWith(ICollider otherObject); 
public void handleCollision(ICollider otherObject);
}

/*Omar Portillo
 *CSC133
 *A3 for Dog Catcher Game
 * 
 * This is the Iterator interface for gameobjects
 */
package a3;

public interface IIterator {

	//does collection have more
	public boolean hasNext();
	
	//return next object
	public Object next();
	public void remove();
	public int getIndex();

	public Object objectAt(int i);
	
}

/*Omar Portillo
 *CSC133
 *A3 for Dog Catcher Game
 * 
 * This class handles the collection of game objects
 * and the iterator to move through the list of them
 */
package a3;

import java.util.Vector;

public class GameObjectCollection implements ICollection{

	//dynamic sized vector for objects
	@SuppressWarnings("rawtypes")
	private Vector oCollection;
	
	
	@SuppressWarnings("rawtypes")
	GameObjectCollection(){
		oCollection = new Vector();
	}	
	
	
	@SuppressWarnings("unchecked")
	public boolean add(Object newObj) {
		oCollection.add(newObj);
		return true;
	}

	public IIterator getIterator() {
		return new GameObjectIterator();
	}

	public boolean remove(Object o) {
		return oCollection.remove(o);
	}

	private class GameObjectIterator implements IIterator {
			
			// index 
			private int currObjIndex;
			
			// construct an iterator, and initialize index to -1
			public GameObjectIterator(){
				currObjIndex = -1;
			}
			
			// are there more objects in the collection?
			public boolean hasNext(){
				
				// are there any at all?
				if(oCollection.size() < 1)
					return false;
				
				// are there any after the last one we returned?
				if(currObjIndex == oCollection.size() - 1 )
					return false;
				
				// there's more, so true
				return true;
			}

			@Override
			public Object next() {
				currObjIndex++;
				return (oCollection.elementAt(currObjIndex));
			}

			@Override
			public void remove() {
				oCollection.remove(currObjIndex);
			}

			@Override
			public int getIndex() {
				return currObjIndex;
			}

			@Override
			public Object objectAt(int i) {
				return oCollection.get(i);
			}
	
	
	
	}
	
}

/*Omar Portillo
 *CSC133
 *A2 for Dog Catcher Game
 * 
 * This is the interface that implements
 * that observer/observable design pattern. 
 */
package a2;

public interface IObservable {

	public void addObserver(IObserver ob);
	public void tellObservers();
	
}

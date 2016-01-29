/*Omar Portillo
 *CSC133
 *A3 for Dog Catcher Game
 * 
 * This is the interface that implements
 * that observer/observable design pattern. 
 */
package a3;

public interface IObservable {

	public void addObserver(IObserver ob);
	public void tellObservers();
	
}

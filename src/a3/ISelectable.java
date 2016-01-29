/*Omar Portillo
 *CSC133
 *A3 for Dog Catcher Game
 * 
 * This is the Selectable interface for healing dogs
 */
package a3;

import java.awt.Graphics;
import java.awt.Point;

public interface ISelectable {
	
	public void setSelected(boolean yesNo);
	public boolean isSelected();
	public boolean contains(Point P);
	public void draw(Graphics g);

}

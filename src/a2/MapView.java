/*Omar Portillo
 *CSC133
 *A2 for Dog Catcher Game
 * 
 * This class sets up and updates the Mapview
 */
package a2;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.*;
@SuppressWarnings("serial")
public class MapView extends JPanel implements IObserver {

private JTextArea textArea = new JTextArea("Test text for possible output");
	
	MapView(){
		// create an empty panel for future map output
		setBorder(new EtchedBorder());
		setBackground(Color.gray);
	}
	
	public void update(IObservable o) {
		add(textArea);
		if(o instanceof GameWorld)
			((GameWorld)o).map();
		
	}
}

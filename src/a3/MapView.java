/*Omar Portillo
 *CSC133
 *A3 for Dog Catcher Game
 * 
 * This class sets up and updates the Mapview
 */
package a3;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class MapView extends JPanel implements IObserver, MouseListener {

private GameWorld gw;
private Game g;
private GameObject go;


	MapView(GameWorld gwp){
		// create an empty panel for future map output
		setBorder(new EtchedBorder());
		setBackground(Color.white);
		gw = gwp;
	}
	
	public void update(IObservable o) {
		
		gw = (GameWorld)o;
		repaint();
		
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		IIterator anIterator = null;
		anIterator = gw.getIterator();

		Object curObj = new Object();
		
		//move through each object
		while(anIterator.hasNext()){
			curObj = anIterator.next();
			if(curObj instanceof GameObject){
				((GameObject) curObj).draw(g);
			}
			
		}
		setVisible(true);
	
	  }
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		Point p = e.getPoint();
		
		if(gw == null)
			return;
		if(g.isPaused()== false)
			return;
		
		IIterator iterator = gw.myObjs.getIterator();
		Object curObj;
		
		while(iterator.hasNext()){
			curObj = iterator.next();
			if(curObj instanceof Dog){
				if( e.isControlDown()){
					if (((Dog) go).contains(p)) {
						((Dog) go).setSelected(((Dog)curObj).isSelected() );		
					}
				}else {
					if (((Dog) go).contains(p)){
						((Dog) go).setSelected(true);	
						
					}else {
						((Dog) go).setSelected(false);
					}
				}
					
				/*
				if(((Dog)curObj).contains(p)){
					((Dog)curObj).setSelected(true);
				}
				else if( e.isControlDown()){
					((Dog)curObj).setSelected( ((Dog)curObj).isSelected() );
				}
				else{
					((Dog)curObj).setSelected(false);
				}*/
			}
		}
		this.repaint(0);
			
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	}

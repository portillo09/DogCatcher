/*Omar Portillo
 *CSC133
 *A2 for Dog Catcher Game
 * 
 * This class handles the "Scoop" command
 */
package a2;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class ScoopCommand extends AbstractAction {
	private static GameWorld target;
	private static ScoopCommand theScoop;
	private ScoopCommand(){
		super("Scoop");
	}

	public static ScoopCommand getInstance() {
		if (theScoop == null)
			theScoop = new ScoopCommand();
		return theScoop;
	}
	
public static void setTarget(GameWorld tgw){
	// only accept and set the first ever target sent
	if(target == null)
		target = tgw;
	}
	

public void actionPerformed(ActionEvent e){
		
	// display the source of request in console
	System.out.println("Scoop requested from " + e.getActionCommand()
					+ " " + e.getSource().getClass() );
		
		if(target != null){
			// actually collide the player with a bird
			target.scoop();
		} else{
			System.out.println("Command recieved to Scoop, but a GameWorld target has been set...");
		}	
	}
}

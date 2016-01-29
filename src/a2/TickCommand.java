/*Omar Portillo
 *CSC133
 *A2 for Dog Catcher Game
 * 
 * This class handles the "Tick" command
 */
package a2;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class TickCommand extends AbstractAction {
	private static GameWorld target;
	private static TickCommand theTick;
	
	private TickCommand(){
		super("Tick");
	}

	public static TickCommand getInstance() {
		if (theTick == null)
			theTick = new TickCommand();
		return theTick;
	}

	public static void setTarget(GameWorld tgw) {
		// only accept and set the first ever target sent
		if(target == null)
			target = tgw;		
	
	}
	
	public void actionPerformed(ActionEvent e){
		
		// display the source of request in console
		System.out.println("Tick requested from " + e.getActionCommand()
						+ " " + e.getSource().getClass() );
			
			if(target != null){
				// actually update
				target.tick();
			} else{
				System.out.println("Command recieved to tick clock, but a GameWorld target has been set...");
			}	
	}
}



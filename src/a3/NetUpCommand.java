/*Omar Portillo
 *CSC133
 *A3 for Dog Catcher Game
 * 
 * This class handles the "Up" command
 */
package a3;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class NetUpCommand extends AbstractAction {
	private static NetUpCommand aNetUpCommand;
	private static GameWorld target;
	
	private NetUpCommand() {
		super("Net UP");
	}

	//Request the Instance of command
	public static NetUpCommand getInstance(){
		if(aNetUpCommand == null)
			aNetUpCommand = new NetUpCommand();
		return aNetUpCommand;
	}
	
	public static void setTarget(GameWorld gws){
		if(target == null)
			target = gws;
	}
	
	public void actionPerformed(ActionEvent e){
		
		//display source
		System.out.println("Net Up requested from " + e.getActionCommand()
							+ " " + e.getSource().getClass());
		
		if(target != null)
			//Move Net UP
			target.up();
		else
			System.out.println("Command to move net up, but target sent");
	}
	
	
}

/*Omar Portillo
 *CSC133
 *A2 for Dog Catcher Game
 * 
 * This class handles the "Right" command
 */

package a2;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class NetRightCommand extends AbstractAction {
	private static NetRightCommand aNetRightCommand;
	private static GameWorld target;
	
	private NetRightCommand() {
		super("Net Right");
	}

	//Request the Instance of command
	public static NetRightCommand getInstance(){
		if(aNetRightCommand == null)
			aNetRightCommand = new NetRightCommand();
		return aNetRightCommand;
	}
	
	public static void setTarget(GameWorld gws){
		if(target == null)
			target = gws;
	}
	
	public void actionPerformed(ActionEvent e){
		
		//display source
		System.out.println("Net Right requested from " + e.getActionCommand()
							+ " " + e.getSource().getClass());
		
		if(target != null)
			//Move Net Right
			target.right();
		else
			System.out.println("Command to move net Right, but target sent");
	}
	
	
}

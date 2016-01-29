/*Omar Portillo
 *CSC133
 *A3 for Dog Catcher Game
 * 
 * This class handles the "Expand" command
 */
package a3;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class ExpandNetCommand extends AbstractAction {
	private static ExpandNetCommand aExpandCommand;
	private static GameWorld target;
	
	private ExpandNetCommand() {
		super("Expand Net");
	}

	//Request Instance of command
	public static ExpandNetCommand getInstance(){
		if(aExpandCommand == null)
			aExpandCommand = new ExpandNetCommand();
		return aExpandCommand;
	}
	
	public static void setTarget(GameWorld gws){
		if(target == null)
			target = gws;
	}
	
	public void actionPerformed(ActionEvent e){
		
		//display source
		System.out.println("Expand Net requested from " + e.getActionCommand()
							+ " " + e.getSource().getClass());
		
		if(target != null)
			//Expand Net 
			target.expandNet();
		else
			System.out.println("Command to expand net, but target sent");
	}
	

}

/*Omar Portillo
 *CSC133
 *A2 for Dog Catcher Game
 * 
 * This class handles the "ShrinkNet" command
 */
package a2;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class ShrinkNetCommand extends AbstractAction{
	private static ShrinkNetCommand aShrinkCommand;
	private static GameWorld target;
	
	private ShrinkNetCommand() {
		super("Shrink Net");
	}

	//Request the Instance of command
	public static ShrinkNetCommand getInstance(){
		if(aShrinkCommand == null)
			aShrinkCommand = new ShrinkNetCommand();
		return aShrinkCommand;
	}
	
	public static void setTarget(GameWorld gws){
		if(target == null)
			target = gws;
	}
	
	public void actionPerformed(ActionEvent e){
		
		//display source
		System.out.println("Shrink Net requested from " + e.getActionCommand()
							+ " " + e.getSource().getClass());
		
		if(target != null)
			//Shrink Net
			target.decreaseNet();
		else
			System.out.println("Command to shrink net, but target sent");
	}
	


}

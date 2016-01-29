/*Omar Portillo
 *CSC133
 *A2 for Dog Catcher Game
 * 
 * This class handles the "Down" command
 */
package a2;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class NetDownCommand extends AbstractAction{
	private static NetDownCommand aNetDownCommand;
	private static GameWorld target;
	
	private NetDownCommand() {
		super("Net Down");
	}

	//Request the Instance of command
	public static NetDownCommand getInstance(){
		if(aNetDownCommand == null)
			aNetDownCommand = new NetDownCommand();
		return aNetDownCommand;
	}
	
	public static void setTarget(GameWorld gws){
		if(target == null)
			target = gws;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		//display source
		System.out.println("Net Down requested from " + e.getActionCommand()
							+ " " + e.getSource().getClass());
		
		if(target != null)
			//Move Net Down
			target.down();
		else
			System.out.println("Command to move net down, but target sent");
	}

}

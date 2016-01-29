/*Omar Portillo
 *CSC133
 *A2 for Dog Catcher Game
 * 
 * This class handles the "Left" command
 */
package a2;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class NetLeftCommand extends AbstractAction {
	private static NetLeftCommand aNetLeftCommand;
	private static GameWorld target;
	
	private NetLeftCommand() {
		super("Net Left");
	}

	//Request the Instance of command
	public static NetLeftCommand getInstance(){
		if(aNetLeftCommand == null)
			aNetLeftCommand = new NetLeftCommand();
		return aNetLeftCommand;
	}
	
	public static void setTarget(GameWorld gws){
		if(target == null)
			target = gws;
	}
	
	public void actionPerformed(ActionEvent e){
		
		//display source
		System.out.println("Net Left requested from " + e.getActionCommand()
							+ " " + e.getSource().getClass());
		
		if(target != null)
			//Move Net Left
			target.left();
		else
			System.out.println("Command to move net left, but target sent");
	}
	
	
}

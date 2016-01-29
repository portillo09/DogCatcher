/*Omar Portillo
 *CSC133
 *A2 for Dog Catcher Game
 * 
 * The class handles the Kitten Command
 */
package a2;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class KittenCommand extends AbstractAction {
	private static KittenCommand aKittenCommand;
	private static GameWorld target;
	
	private KittenCommand() {
		super("Kitten Collision");
	}

	//Request the Instance of command
	public static KittenCommand getInstance(){
		if(aKittenCommand == null)
			aKittenCommand = new KittenCommand();
		return aKittenCommand;
	}
	
	public static void setTarget(GameWorld gws){
		if(target == null)
			target = gws;
	}
	
	public void actionPerformed(ActionEvent e){
		
		//display source
		System.out.println("Kitten requested from " + e.getActionCommand()
							+ " " + e.getSource().getClass());
		
		if(target != null)
			//Kitten Collided
			target.catAdd();
		else
			System.out.println("Command to create Kitten, but target sent");
	}
	


}

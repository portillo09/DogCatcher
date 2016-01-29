/*Omar Portillo
 *CSC133
 *A3 for Dog Catcher Game
 * 
 * This class handles the "Heal" command
 */
package a3;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class HealCommand extends AbstractAction {
	private static HealCommand aHealCommand;
	private static GameWorld target;
	
	private HealCommand() {
		super("Heal");
	}

	//Request the Instance of command
	public static HealCommand getInstance(){
		if(aHealCommand == null)
			aHealCommand = new HealCommand();
		return aHealCommand;
	}
	
	public static void setTarget(GameWorld gws){
		if(target == null)
			target = gws;
	}
	
	public void actionPerformed(ActionEvent e){
		
		//display source
		System.out.println("Heal requested from " + e.getActionCommand()
							+ " " + e.getSource().getClass());
		
		if(target != null)
			//Heal Dog
			target.heal();
		else
			System.out.println("Command to heal, but target sent");
	}
	

}
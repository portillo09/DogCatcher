/*Omar Portillo
 *CSC133
 *A3 for Dog Catcher Game
 * 
 * This class handles the "Fight" command
 */
package a3;


import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class FightCommand extends AbstractAction{
	private static FightCommand aFightCommand;
	private static GameWorld target;
	
	private FightCommand() {
		super("Cat/Dog Fight");
	}

	//Request the Instance of command
	public static FightCommand getInstance(){
		if(aFightCommand == null)
			aFightCommand = new FightCommand();
		return aFightCommand;
	}
	
	public static void setTarget(GameWorld gws){
		if(target == null)
			target = gws;
	}
	
	public void actionPerformed(ActionEvent e){
		
		//display source
		System.out.println("Cat/Dog fight requested from " + e.getActionCommand()
							+ " " + e.getSource().getClass());
		
		if(target != null)
			//Cat and Dog Fight
			target.fight();
		else
			System.out.println("Command to Cat/Dog fight, but target sent");
	}
	

}

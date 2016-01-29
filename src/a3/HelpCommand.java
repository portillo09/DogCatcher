/*Omar Portillo
 *CSC133
 *A3 for Dog Catcher Game
 * 
 * This handles the undo command.
 */
package a3;

import java.awt.event.ActionEvent;


import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class HelpCommand extends AbstractAction {
	private static HelpCommand aHelpCommand;
	private static GameWorld target;
	
	private HelpCommand() {
		super("Help");
	}

	//Request the Instance of command
	public static HelpCommand getInstance(){
		if(aHelpCommand == null)
			aHelpCommand = new HelpCommand();
		return aHelpCommand;
	}
	
	public static void setTarget(GameWorld gws){
		if(target == null)
			target = gws;
	}

	@Override
	public void actionPerformed(ActionEvent e){
		
		// display source of request in console
		System.out.println("Help requested from " + e.getActionCommand() 
							+ " " + e.getSource().getClass() );
		JOptionPane.showMessageDialog(null,
				 "VALID COMMANDS\n"
			   + "--------------\n"
			   + "UpKey - Move net up\n" 
			   + "DownKey - Move net down\n" 
			   + "RightKey - Move net right\n"
			   + "DownKey - Move net down\n"
			   + "S - Make the net Scoop\n"
			   + "E - Expand the Net\n" 
		       + "X - Shrink the Net\n" 
			   + "Q - Quit Game",
				 "EasyMoneyProductions",
				JOptionPane.INFORMATION_MESSAGE);

		
		
	
	}
}

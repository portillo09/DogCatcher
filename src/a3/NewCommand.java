/*Omar Portillo
 *CSC133
 *A3 for Dog Catcher Game
 * 
 * This is the class for the new command
 */
package a3;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
//import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class NewCommand extends AbstractAction {
	private static NewCommand aNewCommand;
	private static GameWorld target;
	
	private NewCommand() {
		super("New");
	}

	//Request the Instance of command
	public static NewCommand getInstance(){
		if(aNewCommand == null)
			aNewCommand = new NewCommand();
		return aNewCommand;
	}
	
	public static void setTarget(GameWorld gws){
		if(target == null)
			target = gws;
	}

	@Override
	public void actionPerformed(ActionEvent e){
		
		// display source of request in console
		System.out.println("New requested from " + e.getActionCommand() 
							+ " " + e.getSource().getClass() );
		
	
	}
}

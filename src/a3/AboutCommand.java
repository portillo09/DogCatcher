/*Omar Portillo
 *CSC133
 *A3 for Dog Catcher Game
 * 
 * This class handles the "About" command
 */
package a3;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class AboutCommand extends AbstractAction {
	private static AboutCommand aAboutCommand;
	private static GameWorld target;
	
	private AboutCommand() {
		super("About");
	}

	//Request the Instance of command
	public static AboutCommand getInstance(){
		if(aAboutCommand == null)
			aAboutCommand = new AboutCommand();
		return aAboutCommand;
	}
	
	public static void setTarget(GameWorld gws){
		if(target == null)
			target = gws;
	}

	@Override
	public void actionPerformed(ActionEvent e){
		
		// display source of request in console
		System.out.println("About pane requested from " + e.getActionCommand() 
							+ " " + e.getSource().getClass() );
		
		// display a pane with information about the application
		JOptionPane.showMessageDialog(null, "Programmer: Omar Portillo\n"
								+ "Class: CSC 133 - Fall 2015\n"
								+ "Version: Assignment 2", "Easy Money",
								JOptionPane.PLAIN_MESSAGE);
		
	}

}

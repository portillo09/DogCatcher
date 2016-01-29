/*Omar Portillo
 *CSC133
 *A2 for Dog Catcher Game
 * 
 * This class handles the "Quit" command
 */
package a2;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;


@SuppressWarnings("serial")
public class QuitCommand extends AbstractAction{

	private static QuitCommand theQuit;
	
	private QuitCommand(){
		super("Quit");
	}
	public static QuitCommand getInstance() {
		if(theQuit == null)
			theQuit = new QuitCommand();
		return theQuit;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {

	// display source of request in console
	System.out.println("Quit requested from " + e.getActionCommand() 
						+ " " + e.getSource().getClass() );
		
	// verify that user actually wants to close 
	int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?",
			"Confirm Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
	// check for yes
	if(result == JOptionPane.YES_OPTION) {
		System.out.println("User chose yes, closing application...");
		System.exit(0);
	}
		
	// didn't pick yes, go back to application
	System.out.println("User chose no, returning to application...");
	return;		
}

}

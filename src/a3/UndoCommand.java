/*Omar Portillo
 *CSC133
 *A3 for Dog Catcher Game
 * 
 * This handles the undo command.
 */
package a3;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
//import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class UndoCommand extends AbstractAction {
	private static UndoCommand aUndoCommand;
	private static GameWorld target;
	
	private UndoCommand() {
		super("Undo");
	}

	//Request the Instance of command
	public static UndoCommand getInstance(){
		if(aUndoCommand == null)
			aUndoCommand = new UndoCommand();
		return aUndoCommand;
	}
	
	public static void setTarget(GameWorld gws){
		if(target == null)
			target = gws;
	}

	@Override
	public void actionPerformed(ActionEvent e){
		
		// display source of request in console
		System.out.println("Undo requested from " + e.getActionCommand() 
							+ " " + e.getSource().getClass() );
		
	
	}
}

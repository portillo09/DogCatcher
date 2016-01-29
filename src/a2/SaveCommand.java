package a2;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
//import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class SaveCommand extends AbstractAction {
	private static SaveCommand aSaveCommand;
	private static GameWorld target;
	
	private SaveCommand() {
		super("Save");
	}

	//Request the Instance of command
	public static SaveCommand getInstance(){
		if(aSaveCommand == null)
			aSaveCommand = new SaveCommand();
		return aSaveCommand;
	}
	
	public static void setTarget(GameWorld gws){
		if(target == null)
			target = gws;
	}

	@Override
	public void actionPerformed(ActionEvent e){
		
		// display source of request in console
		System.out.println("Save requested from " + e.getActionCommand() 
							+ " " + e.getSource().getClass() );
		
	
	}
}

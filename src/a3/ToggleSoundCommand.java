/*Omar Portillo
 *CSC133
 *A3 for Dog Catcher Game
 * 
 * This class handles the "ToggleSound" command
 */
package a3;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;


@SuppressWarnings("serial")
public class ToggleSoundCommand extends AbstractAction{

		private static ToggleSoundCommand aToggleSoundCommand;
		
		private static GameWorld target;
		
		private ToggleSoundCommand(){
			super("Sound");
		}
		
		// request the instance of the command
		public static ToggleSoundCommand getInstance(){
			if(aToggleSoundCommand == null)
				aToggleSoundCommand = new ToggleSoundCommand();
			return aToggleSoundCommand;
		}
		
		public static void setTarget(GameWorld gws){
			// only accept and set the first ever target sent
			if(target == null)
				target = gws;
		}
		
		public void actionPerformed(ActionEvent e){
			
			// display source of request in console
			System.out.println("Toggle Sound requested from " + e.getActionCommand()
					+ " " + e.getSource().getClass());

			if(target != null){
			// actually toggle the sound
			target.toggleSound();
			if(target.soundIsOn())
				target.turnSoundOn();
			else
				target.turnSoundOff();
			
			} else{
			System.out.println("Command received to toggle sound, but a GameWorld target has been set...");
			}
		}

}

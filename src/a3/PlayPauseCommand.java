/*Omar Portillo
 *CSC133
 *A3 for Dog Catcher Game
 * 
 * This is the play pause command
 */
package a3;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class PlayPauseCommand extends AbstractAction {
	private static PlayPauseCommand aPlayPauseCommand;
	private static Game target;
	private Sound theSounds = Sound.getInstance(); 

	private PlayPauseCommand() {
		super("Pause");
	}

	//Request the Instance of command
	public static PlayPauseCommand getInstance(){
		if(aPlayPauseCommand == null)
			aPlayPauseCommand = new PlayPauseCommand();
		return aPlayPauseCommand;
	}
	
	public static void setTarget(Game tw){
		if(target == null)
			target = tw;
	}
	
	public void actionPerformed(ActionEvent e){
		
		//display source
		System.out.println("Pause/Play requested from " + e.getActionCommand()
							+ " " + e.getSource().getClass());
		
		if(target.isPaused()){
			theSounds.playPauseClip();
			target.resumeGame();
		}
		else if(!target.isPaused())
			target.pauseGame();
			theSounds.playPauseClip();

	
	}
	

}
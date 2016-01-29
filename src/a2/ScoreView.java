/*Omar Portillo
 *CSC133
 *A2 for Dog Catcher Game
 * 
 * This class sets up and updates the ScoreView
 */
package a2;

import javax.swing.JPanel;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ScoreView extends JPanel implements IObserver{
	
	private JLabel score;
	private JLabel dogsCaptured;
	private JLabel catsCaptured;
	private JLabel dogsLeft;
	private JLabel catsLeft;
	private JLabel sound;
	
	
	ScoreView() {
		    // add space
			add(Box.createRigidArea(new Dimension(25,0)));
			
			// add the labels with dummy data for the panel	
			score = new JLabel("Total Points: ##");				
			add(score);
			
			// add space
			add(Box.createRigidArea(new Dimension(25,0)));
			
			dogsCaptured = new JLabel("Dogs Captured: ##");
			add(dogsCaptured);
				
			// add space
			add(Box.createRigidArea(new Dimension(25,0)));
				
			catsCaptured = new JLabel("Cats Captured: ##");
			add(catsCaptured);
				
			// add space
			add(Box.createRigidArea(new Dimension(25,0)));
				
			dogsLeft = new JLabel("Dogs Left: ##");
			add(dogsLeft);
				
			// add space
			add(Box.createRigidArea(new Dimension(25,0)));
				
			catsLeft = new JLabel("Cats Left: ##");
			add(catsLeft);
				
		    // add space
			add(Box.createRigidArea(new Dimension(25,0)));
				
			sound = new JLabel("Sound: XX");
			add(sound);
				
			// add space
			add(Box.createRigidArea(new Dimension(25,0)));

			this.setVisible(true);		
	
	}
	
	@Override
	public void update(IObservable o) {
		// update all the labels from the game world we received
				score.setText("Total Points: " + ((GameWorld) o).getScore());
				dogsCaptured.setText("Dogs Captured: " + ((GameWorld) o).getDogsScop());
				catsCaptured.setText("Cats Captured: " + ((GameWorld) o).getCatsScop());
				dogsLeft.setText("Dogs Left: " + ((GameWorld) o).getDogsLeft());
				catsLeft.setText("Cats Left: " + ((GameWorld) o).getCatsLeft());
				if(((GameWorld) o).soundIsOn())
					sound.setText("Sound: ON");
				else sound.setText("Sound: OFF");
				
				this.setVisible(true);
				
	}

}

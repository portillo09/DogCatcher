/*Omar Portillo
 *CSC133
 *A3 for Dog Catcher Game
 * 
 * This is class handles the sound library
 */
package a3;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;

public class Sound {
	
	private static Sound theSound;
	
	private AudioClip catCollide;
	private AudioClip fightCollision;
	private AudioClip scoopNet;
	private AudioClip expandNet;
	private AudioClip pause;
	private AudioClip gameover;
	private AudioClip scoopCat;
	private AudioClip BGC;
	
	private Sound() {
		
		String soundFolder = "sounds" + File.separator;
		String fileName, filePath;
		
		File aFile;
		
		
		//Set up the cat collision sound
		fileName = "CatCollide.wav";
		filePath = soundFolder + fileName;
		try{
			aFile = new File(filePath);
			if(aFile.exists()){
				catCollide = Applet.newAudioClip(new File(filePath).toURI().toURL());
				
			}else{
				throw new RuntimeException("Sound: File not Found: " + filePath);
			}
		} catch(MalformedURLException e) {
			throw new RuntimeException("Sound: malformed URL: " + e);
		}
		
		
		//Set up Fight Collision sound
		fileName = "cdFight.wav";
		filePath = soundFolder + fileName;
		try{
			aFile = new File(filePath);
			if(aFile.exists()){
				fightCollision = Applet.newAudioClip(new File(filePath).toURI().toURL());
				
			}else{
				throw new RuntimeException("Sound: File not Found: " + filePath);
			}
		} catch(MalformedURLException e) {
			throw new RuntimeException("Sound: malformed URL: " + e);
		}
		
		
		
		//Set Up Scoop sound 
		fileName = "scoopNet.wav";
		filePath = soundFolder + fileName;
		try{
			aFile = new File(filePath);
			if(aFile.exists()){
				scoopNet = Applet.newAudioClip(new File(filePath).toURI().toURL());
				
			}else{
				throw new RuntimeException("Sound: File not Found: " + filePath);
			}
		} catch(MalformedURLException e) {
			throw new RuntimeException("Sound: malformed URL: " + e);
		}
		
		
		//Set up Background Music
		fileName = "backGround.wav";
		filePath = soundFolder + fileName;
		try{
			aFile = new File(filePath);
			if(aFile.exists()){
				BGC = Applet.newAudioClip(new File(filePath).toURI().toURL());
				
			}else{
				throw new RuntimeException("Sound: File not Found: " + filePath);
			}
		} catch(MalformedURLException e) {
			throw new RuntimeException("Sound: malformed URL: " + e);
		}
		
		

		fileName = "catScooped.wav";
		filePath = soundFolder + fileName;
		try{
			aFile = new File(filePath);
			if(aFile.exists()){
				scoopCat = Applet.newAudioClip(new File(filePath).toURI().toURL());
				
			}else{
				throw new RuntimeException("Sound: File not Found: " + filePath);
			}
		} catch(MalformedURLException e) {
			throw new RuntimeException("Sound: malformed URL: " + e);
		}
		
		fileName = "expandNet.wav";
		filePath = soundFolder + fileName;
		try{
			aFile = new File(filePath);
			if(aFile.exists()){
				expandNet = Applet.newAudioClip(new File(filePath).toURI().toURL());
				
			}else{
				throw new RuntimeException("Sound: File not Found: " + filePath);
			}
		} catch(MalformedURLException e) {
			throw new RuntimeException("Sound: malformed URL: " + e);
		}
		
		
		fileName = "pause.wav";
		filePath = soundFolder + fileName;
		try{
			aFile = new File(filePath);
			if(aFile.exists()){
				pause = Applet.newAudioClip(new File(filePath).toURI().toURL());
				
			}else{
				throw new RuntimeException("Sound: File not Found: " + filePath);
			}
		} catch(MalformedURLException e) {
			throw new RuntimeException("Sound: malformed URL: " + e);
		}
		
		fileName = "gameover.wav";
		filePath = soundFolder + fileName;
		try{
			aFile = new File(filePath);
			if(aFile.exists()){
				gameover = Applet.newAudioClip(new File(filePath).toURI().toURL());
				
			}else{
				throw new RuntimeException("Sound: File not Found: " + filePath);
			}
		} catch(MalformedURLException e) {
			throw new RuntimeException("Sound: malformed URL: " + e);
		}
		
	}
	
	

		
		public static Sound getInstance(){
			if(theSound == null )
				theSound = new Sound();
			return theSound;
			
		}
		
		public void playCatCollideClip(){
			catCollide.play();
		}
		
		public void playFightCollisisonClip(){
			fightCollision.play();
		}
		
		public void playScoopNetClip(){
			scoopNet.play();
		}
		
		public void playScoopCatClip(){
			scoopCat.play();
		}
		public void playExpandNetClip(){
			expandNet.play();
		}
		public void playGameOverClip(){
			gameover.play();
		}
		public void playPauseClip(){
			pause.play();
		}
		
		
		
		public void playBGC(){
			BGC.loop();
		}
		
		public void stopBGC(){
			BGC.stop();
		}
		
		
		
}
		
		
		
		
		
	



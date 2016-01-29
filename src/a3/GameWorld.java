/*Omar Portillo
 *CSC133
 *A3 for Dog Catcher Game
 * 
 * This class represents a GameWorld, with a collection
 * of GameObjects and other classes can instantiate commands
 * on GameWorld
 */
package a3;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
//import java.util.Scanner;
import java.util.Vector;

import javax.swing.JOptionPane;

 public class GameWorld implements IObservable{
	
	GameObjectCollection myObjs = new GameObjectCollection();
	// keep a list of things observing the game world
   @SuppressWarnings("rawtypes")
	private Vector myObservers;
   @SuppressWarnings("unused")
	private int initCat,initDog, score, totalScratches, catScop, 
			    dogScop, totalCats, totalDogs, scratches;
	private Cat cat; 
	private Dog dog;
	private Net net;
	private String dogNum, catNum;
	private float netLeftP, netRightP,netBotP, netTopP ;
	private boolean sound = true;
	Random rand = new Random();
	private Sound theSounds = Sound.getInstance(); 
	private ArrayList<Animal> collided = new ArrayList<>();

	
	
			
	@SuppressWarnings("rawtypes")
	GameWorld() {
		myObservers = new Vector();
		net = new Net();
		dog = new Dog();
		cat = new Cat();
	}
	

	
	//Initialize game state variables/layout
	public void initLayout() {
		
		sound = true;
		
			dogNum = JOptionPane.showInputDialog ( "EasyMoney Productions\n\nHow many Dogs would you like?" ); 
			
			//read in the second number from user as a string 
			catNum = JOptionPane.showInputDialog ( "How many Cats would you like?" ); 
			
			//convert numbers from type String to type int 
			initDog = Integer.parseInt ( dogNum); 
			initCat = Integer.parseInt ( catNum); 
		
		
		//create the initial game objects/layout


		//Create Net
		net = new Net();
		net.setColor(Color.GREEN);
		net.setSize(100);
		net.setLocation(rand.nextFloat()*(300)+20, rand.nextFloat()*(300)+20);
		myObjs.add(net);
		
		//Create Cats
		for (int i = 0; i < initCat; i++) {
			cat = new Cat();
			cat.setColor(Color.RED);
			cat.setSpeed(5);
			cat.setLocation(rand.nextFloat()*(500), rand.nextFloat()*(500));
			cat.setSize(rand.nextInt(40)+7);
			cat.setDirection(rand.nextInt(360));
			//cat.resetCollisionCount();
			//cat.setKitten(false);
			myObjs.add(cat);
			totalCats++;
		}
		
		//Create Dogs
		for(int j =0; j <initDog; j++){
			
			dog = new Dog();
			dog.setColor(Color.BLUE);
			dog.setSpeed(5);
			dog.setSize(rand.nextInt(40)+7);
			dog.setLocation(rand.nextFloat()*(500), rand.nextFloat()*(500));
			dog.setDirection(rand.nextInt(360));
			myObjs.add(dog);
			totalDogs++;
		}
		tellObservers();
	}		
		
	//This produces a kitten when two cats collide
	public void catAdd(){
		if (initCat <2)
			System.out.println("Less than two cats, Cannot make kittens");
		else {
			if(initCat <30){
				if(soundIsOn())
					theSounds.playCatCollideClip();
			
		cat = new Cat();
		System.out.println("Kitten is produced");
		cat.setSpeed(5);
		cat.setSize(rand.nextInt(40)+7);
		cat.setColor(Color.RED);
		cat.setLocation(rand.nextFloat()*(500)+1, rand.nextFloat()*(500)+1);
		cat.setDirection(rand.nextInt(360));
		myObjs.add(cat);
		initCat++;
		totalCats++;
		}
		}
		tellObservers();

		
	}
	
	//This is when a cat scratches a dog
	public void fight(){
		
	scratches++;
	System.out.println(scratches);
			
		if(scratches<=5){
		
					
		// if no cats collide
		if (initCat == 0){
			System.out.println("No cats in game - No scratch recorded");
		}
		//If no dogs collide
		if(initDog == 0){
			System.out.println("No dogs in game - No scratch recorded");
		}
		
		}
		tellObservers();
	}
		
	
	
	//When the Net captures a Dog or Cat
	public void scoop(){
		
		
		 netLeftP  = net.getxLoc() - (net.getSize()/2);
		 netRightP = net.getxLoc() + (net.getSize()/2);
		 netBotP   = net.getyLoc() - (net.getSize()/2);
		 netTopP   = net.getyLoc() + (net.getSize()/2);

	     IIterator iterator = myObjs.getIterator();
		 Object    curObj   = new Object();
		
		 while(iterator.hasNext()){
				curObj = iterator.next();
				if(curObj instanceof Cat){
					// check if cat is in boundaries
					if(((Cat) curObj).getxLoc() > netLeftP
						&& ((Cat) curObj).getxLoc() < netRightP
						&& ((Cat) curObj).getyLoc() > netBotP
						&& ((Cat) curObj).getyLoc() < netTopP){
						
						System.out.println("Cat Scooped");
						if(soundIsOn()){
							theSounds.playScoopCatClip();
						}

						catScop++;
						initCat--;
						totalCats--;
				
						iterator.remove();
					}
		 		}else if(curObj instanceof Dog){
				// check if dog is in boundaries
				if(((Dog) curObj).getxLoc() > netLeftP
						&& ((Dog) curObj).getxLoc() < netRightP
						&& ((Dog) curObj).getyLoc() > netBotP
						&& ((Dog) curObj).getyLoc() < netTopP){
					System.out.println("Dog Scooped");
					if(soundIsOn()){
						theSounds.playScoopNetClip();
					}

					dogScop++;
					initDog--;
					totalDogs--;
			

					// Game Over if there are no dogs
					iterator.remove();
					if (totalDogs == 0) {
						theSounds.stopBGC();
						print();
						System.exit(0);
					}
				}
		 	}
		 }
		 tellObservers();
	}
		 
	//Expand size of net
	public void expandNet() {
		net.expandNet();
		if(soundIsOn()){
			theSounds.playExpandNetClip();
		}
	}
	
	//Decrease size of net
	public void decreaseNet() {
		net.contractNet();
	}
	
	//Updates Animal variables 
	public void tick(int DELAY){
		
		IIterator iterator = myObjs.getIterator();
		Object curObj = new Object();
		
		//move each animal
		while(iterator.hasNext()){
			curObj = iterator.next();
			
			if(curObj instanceof Animal){
				((Animal) curObj).move(DELAY);
			}
		}
		tellObservers();
		detectCollision();
	}
		
	//Net up
	public void up(){

		net.moveUp();
	}
	
	//Net down
	public void down(){
		net.moveDown();
	}
	
	//Net left
	public void left(){
		net.moveLeft();
	}
	
	//Net right
	public void right(){
		net.moveRight();
	}
	
	//Prints out all Gameobject info
	/*public void map() {
		
		// get an iterator for the collection
		IIterator anIterator = myObjs.getIterator();
				
		// setup a placeholder object
		Object currentObj = new Object();
				
		System.out.println("\n THE CURRENT \"MAP\"...\n");
		// iterate through, and print each one
		while( anIterator.hasNext() ){
			currentObj = anIterator.next();
			System.out.println( currentObj.toString() );
		}
		System.out.println();

	}*/
	
	//Prints score 
	public void print() {
				
		IIterator iterator = myObjs.getIterator();
		Object curObj = new Object();
		
		 
		// Minus one if dog gets scratched.
		// Get total scratches
		while(iterator.hasNext()){
			curObj = iterator.next();
			if(curObj instanceof Dog){
				if(((Dog) curObj).getScratches() < 5){
					
					totalScratches += ((Dog) curObj).getScratches();
					score += -1*((Dog) curObj).getScratches();
				}
			}
		}

		score += catScop * -10;
		score += dogScop * 10;
		theSounds.playGameOverClip();
		JOptionPane.showMessageDialog(null,
				"GAME OVER NO MORE DOGS!\n"
				+ "Score:" + score
				+ "\nNumber of Dogs captured:" + dogScop
				+ "\nNumber of Cats captured:" +  catScop
				+ "\nNumber of Dogs left:" + initDog
				+ "\nNumber of Cats left:" + initCat
				+ "\n"
				+ "\nGOOD GAME!",
				"EasyMoneyProductions",
				JOptionPane.INFORMATION_MESSAGE);
	
	}

	
	//@SuppressWarnings("unchecked")
	@SuppressWarnings("unchecked")
	public void addObserver(IObserver ob) {
		//add observer
		myObservers.add(ob);
	}

	@Override
	public void tellObservers() {
		
		int i; //Counter
		Object theObservers[]; //array for observables
		
		theObservers = myObservers.toArray();
		
		//pass a copy 
		if(!myObservers.isEmpty()){
			for(i=0; i < myObservers.size(); i++)
				((IObserver)theObservers[i]).update(this);
			
		}
	}

	public int getScore() {
		IIterator iterator = myObjs.getIterator();
		Object curObj = new Object();
		
		score = 0;
		
		while(iterator.hasNext()){
			curObj = iterator.next();
			if(curObj instanceof Dog){
				if(((Dog) curObj).getScratches() > 0){
					score += -1*((Dog) curObj).getScratches();
				}
			}
		}

		score += catScop * -10;// CAT = -10 POINTS
		score += dogScop * 10; // UNSCRATCHED DOG = 10 POINTS
		return score;
	}

	public int getDogsScop() {
		return dogScop;
	}

	public int getCatsScop() {
		return catScop;
	}

	public int getDogsLeft() {
		return initDog;
	}

	public int getCatsLeft() {
		return initCat;
	}
	
	// turn the sound on
	public void turnSoundOn(){
		sound = true;
		theSounds.playBGC();
		tellObservers();
	}
		
	// turn the sound off
	public void turnSoundOff(){
		sound = false;
		theSounds.stopBGC();
		tellObservers();
	}
		
	// toggle the sound
	public void toggleSound(){
		if(sound)
			sound = false;
		else sound = true;
			tellObservers();
	}

	//turn sound on
	public boolean soundIsOn() {
		return sound;
	}



	public IIterator getIterator() {
		return myObjs.getIterator();
	}

	
	
	public void detectCollision() {
		
		 
		  IIterator iterator = myObjs.getIterator();
		  Object curObj = new Object();
		  IIterator iterator2 = myObjs.getIterator();
		  Object otherObj = new Object();
		
		  
		  
		  
		  while(iterator.hasNext()){
			curObj = iterator.next();
			if(curObj instanceof Animal ){
			   Animal a = (Animal)curObj;

			   while(iterator2.hasNext()){
				   otherObj = iterator2.next();
				   if(otherObj instanceof Animal){
					   Animal b = (Animal) otherObj;
					   a.collidesWith(b);
					   
					   if(a.collidesWith(b)){
						   if(b instanceof Dog &&
							  a	 instanceof Cat &&
							  check(b)==false){
							   b.setGw(this);
							   
							   b.handleCollision(b);
							   
							   
						   }else if (a instanceof Cat &&
								     b instanceof Cat &&
								     check(b)==false ) {
							   add(a);
							   add(b);
							   catAdd();
						   }
					   }else if(!a.collidesWith(b)){
						   remove(a);
						   remove(b);
					   }
				   }
			   }
			}   
			   
		  }   
			  		  
	}
	
	 public void remove(Animal a){
	        for (int i = 0; i < collided.size(); i++) {
	            if (collided.get(i) == a) {
	               collided.remove(i);
	            }
	        }

	    }

	public void add(Animal a){
        collided.add(a);
    }

	 public boolean check(Animal a) {
	        for (int i = 0; i < collided.size(); i++) {
	            if (collided.get(i) == a) {
	               return true;
	            }
	        }
	        return false;
	    }
	public void heal() {
		IIterator iterator = myObjs.getIterator();
		Object curObj = new Object();
		
		
		
			while(iterator.hasNext()){
				curObj = iterator.next();
				if(curObj instanceof Dog ){
					if(((Dog) curObj).getScratches() >= 4){
						((Dog) curObj).setSelected(false);
						((Dog) curObj).resetScratches();
						((Dog) curObj).setSpeed(5);
						((Dog) curObj).setColor(Color.BLUE);
						tellObservers();
					}
				}
			}	
		
		
	}



	public void stopBGC() {
		theSounds.stopBGC();
	}



	public void playBGC() {
		theSounds.playBGC();
	}

	
}

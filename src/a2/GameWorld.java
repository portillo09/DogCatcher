/*Omar Portillo
 *CSC133
 *A2 for Dog Catcher Game
 * 
 * This class represents a GameWorld, with a collection
 * of GameObjects and other classes can instantiate commands
 * on GameWorld
 */
package a2;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

 public class GameWorld implements IObservable{
	
	GameObjectCollection myObjs = new GameObjectCollection();
	// keep a list of things observing the game world
   @SuppressWarnings("rawtypes")
	private Vector myObservers;
   @SuppressWarnings("unused")
	private int initCat,initDog, score, totalScratches, catScop, 
			dogScop, totalCats, totalDogs;
	private Cat cat; 
	private Dog dog;
	private Net net;
	private final int GW_SIZE=1024;
	private float netLeftP, netRightP,netBotP, netTopP ;
	private Scanner scanner;
	private boolean sound = true;
	Random rand = new Random();
	
	
			
	@SuppressWarnings("rawtypes")
	GameWorld() {
		myObservers = new Vector();
		net = new Net();
		dog = new Dog();
		cat = new Cat();
	}
	

	
	//Initialize game state variables/layout
	public void initLayout() {
		
		//col= new ArrayList<>();
		scanner = new Scanner(System.in);
		
		System.out.println("Welcome to the Magical DogCatcher!");
	
		System.out.println("How many cats would you like? ");
		initCat= scanner.nextInt();
		System.out.println("How many dogs would you like? ");
		initDog = scanner.nextInt();
		
		
		//create the initial game objects/layout


		//Create Net
		net = new Net();
		net.setColor(Color.ORANGE);
		net.setSize(100);
		net.setLocation(rand.nextFloat()*(GW_SIZE), rand.nextFloat()*(GW_SIZE));
		myObjs.add(net);
		
		//Create Cats
		for (int i = 0; i < initCat; i++) {
			cat = new Cat();
			cat.setColor(Color.RED);
			cat.setSpeed(5);
			cat.setLocation(rand.nextFloat()*(GW_SIZE), rand.nextFloat()*(GW_SIZE));
			cat.setSize(rand.nextInt(40));
			cat.setDirection(rand.nextInt(360));
			myObjs.add(cat);
			totalCats++;
		}
		
		//Create Dogs
		for(int j =0; j <initDog; j++){
			dog = new Dog();
			dog.setColor(Color.BLUE);
			dog.setSpeed(5);
			dog.setSize(rand.nextInt(40));
			dog.setLocation(rand.nextFloat()*(GW_SIZE), rand.nextFloat()*(GW_SIZE));
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
			System.out.println("Kitten is produced");
		cat = new Cat();
		cat.setSpeed(5);
		cat.setColor(Color.RED);
		cat.setLocation(rand.nextFloat()*(10), rand.nextFloat()*(10));
		cat.setDirection(rand.nextInt(360));
		myObjs.add(cat);
		initCat++;
		totalCats++;
		}
		tellObservers();

		
	}
	
	//This is when a cat scratches a dog
	public void fight(){
		ArrayList<Integer> dogList = new ArrayList<Integer>();
		
		IIterator iterator = myObjs.getIterator();
		Object curObj = new Object();
		
		// if no cats collide
		if (initCat == 0){
			System.out.println("No cats in game - No scratch recorded");
		}
		//If no dogs collide
		if(initDog == 0){
			System.out.println("No dogs in game - No scratch recorded");
		}
		else{
			while(iterator.hasNext()){
				curObj = iterator.next();
				if(curObj instanceof Dog){
					dogList.add(iterator.getIndex());
				}
			}
		}
		
		
		
		int randDog= rand.nextInt(dogList.size());
		int	randPos = dogList.get(randDog);
		
		((Dog)iterator.objectAt(randPos)).upScratches();
		((Dog)iterator.objectAt(randPos)).setRandomColor();
		((Dog)iterator.objectAt(randPos)).decSpeed();
		
		tellObservers();
		
	}
	
	//When the Net captures a Dog or Cat
	public void scoop(){
		
		 netLeftP  = net.getxLoc() - (net.getSize()/2);
		 netRightP = net.getxLoc() + (net.getSize()/2);
		 netBotP = net.getyLoc() - (net.getSize()/2);
		 netTopP  = net.getyLoc() + (net.getSize()/2);

	     IIterator iterator = myObjs.getIterator();
		 Object curObj = new Object();
		
		 while(iterator.hasNext()){
				curObj = iterator.next();
				if(curObj instanceof Cat){
					// check if cat is in boundaries
					if(((Cat) curObj).getxLoc() > netLeftP
						&& ((Cat) curObj).getxLoc() < netRightP
						&& ((Cat) curObj).getxLoc() > netBotP
						&& ((Cat) curObj).getxLoc() < netTopP){
						
						System.out.println("Cat Scooped");

						catScop++;
						initCat--;
						totalCats--;
						
						
						iterator.remove();
					}
		 		}else if(curObj instanceof Dog){
				// check if dog is in boundaries
				if(((Dog) curObj).getxLoc() > netLeftP
						&& ((Dog) curObj).getxLoc() < netRightP
						&& ((Dog) curObj).getxLoc() > netBotP
						&& ((Dog) curObj).getxLoc() < netTopP){
					System.out.println("Dog Scooped");

					dogScop++;
					initDog--;
					totalDogs--;
			

					// Game Over if there are no dogs
					iterator.remove();
					if (totalDogs == 0) {
						System.out.println("Game Over! Try Again");
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
	}
	
	//Decrease size of net
	public void decreaseNet() {
		net.contractNet();
	}
	
	//Updates Animal variables 
	public void tick(){
		
		IIterator iterator = myObjs.getIterator();
		Object curObj = new Object();
		
		//move each animal
		while(iterator.hasNext()){
			curObj = iterator.next();
			if(curObj instanceof Animal){
				((Animal) curObj).move();
			}
		}
		tellObservers();
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
	public void map() {
		
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

	}

	//Prints score 
	public void print() {
				
		IIterator iterator = myObjs.getIterator();
		Object curObj = new Object();
		
		// Minus one if dog gets scratched.
		// Get total scratches
		while(iterator.hasNext()){
			curObj = iterator.next();
			if(curObj instanceof Dog){
				if(((Dog) curObj).getScratches() > 0){
					totalScratches += ((Dog) curObj).getScratches();
					score += -1*((Dog) curObj).getScratches();
				}
			}
		}

		score += catScop * -10;
		score += dogScop * 10;

		System.out.println("Current Score:" + score);
		System.out.println("Number of Dogs captured:" + dogScop);
		System.out.println("Number of Cats captured:" +  catScop);
		System.out.println("Number of Dogs left:" + initDog);
		System.out.println("Number of Cats left:" + initCat);
		System.out.println("Scratches:" + totalScratches);

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
		tellObservers();
	}
		
	// turn the sound off
	public void turnSoundOff(){
		sound = false;
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
	
}

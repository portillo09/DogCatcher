/*Omar Portillo
 *CSC133
 *A1 for Dog Catcher Game
 * 
 * 
 */
package a1;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//This class represents a GameWorld, with a collection of GameObjects
//This class can be instantiated 
 class GameWorld {
	
	private ArrayList<GameObject> col;
	private int initCat,initDog, score, scratches, catScop, dogScop ;
	private Cat cat; 
	private Dog dog;
	private Net net;
	private final int GW_SIZE=1024;
	private float netXTopRight, netYTopLeft,netYBottomRight, netYBottomLeft ;
	private Scanner scanner;
	Random rand = new Random();
	
	
			
	GameWorld() {
		net = new Net();
		dog = new Dog();
		cat = new Cat();
	}
	

	
	//Initialize game state variables/layout
	public void initLayout() {
		
		col= new ArrayList<>();
		scanner = new Scanner(System.in);
		
		System.out.println("Welcome to the Magical DogCatcher!");
	
		System.out.println("How many cats would you like? ");
		initCat= scanner.nextInt();
		System.out.println("How many dogs would you like? ");
		initDog = scanner.nextInt();
		
		
		//create the initial game objects/layout
		createNet();
		createDog(initDog);
		createCat(initCat);

		
		col.forEach(System.out::println);
		

	}
	
	
	public void createNet(){
		net.setColor(Color.BLACK);
		net.setSize(100);
		net.setLocation(rand.nextFloat()*(GW_SIZE), rand.nextFloat()*(GW_SIZE));
		col.add(net);
		
	}

	public void createDog(int initDog){
		
		for(int i =0; i <initDog; i++){
			dog = new Dog();
			dog.setColor(Color.BLUE);
			dog.setSpeed(5);
			dog.setSize(rand.nextInt(40));
			dog.setLocation(rand.nextFloat()*(GW_SIZE), rand.nextFloat()*(GW_SIZE));
			dog.setDirection(rand.nextInt(360));
			col.add(dog);
		}
		
	}
	
	public void createCat( int initCat){

		for(int i =0; i <initCat; i++){
			cat = new Cat();
			cat.setColor(Color.RED);
			cat.setSpeed(5);
			cat.setLocation(rand.nextFloat()*(GW_SIZE), rand.nextFloat()*(GW_SIZE));
			cat.setSize(rand.nextInt(40));
			cat.setDirection(rand.nextInt(360));
			col.add(cat);
		}
	}

	//This produces a kitten when two cats collide
	public void catAdd(){
		if (initCat <2)
			System.out.println("Less than two cats, Cannot make kittens");
		else 
			System.out.println("Kitten is produced");
		initCat++;
		cat = new Cat();
		cat.setSpeed(5);
		cat.setColor(Color.RED);
		cat.setLocation(rand.nextFloat()*(GW_SIZE), rand.nextFloat()*(GW_SIZE));
		cat.setDirection(rand.nextInt(360));
		col.add(cat);
		
	}
	
	//This is when a cat scratches a dog
	public void fight(){
		
		int tmp= rand.nextInt(col.size());
		while(!(col.get(tmp)instanceof Dog)){
			tmp=rand.nextInt(col.size());
		}
	
		int x = ((Dog)col.get(tmp)).getScratches();
		if (x<5){
			int speed = ((Dog)col.get(tmp)).getSpeed();
			((Dog)col.get(tmp)).setSpeed(speed -1);
			((Dog)col.get(tmp)).setRandomColor();
			((Dog)col.get(tmp)).setScratches(x+1);
		}
		scratches++;
		
	}
	
	//When the Net captures a Dog or Cat
	public void scoop(){
		
		 netXTopRight  = net.getxLoc() - (net.getSize()/2);
	     netYTopLeft = net.getxLoc() + (net.getSize()/2);
	     netYBottomRight= net.getyLoc() - (net.getSize()/2);
	     netYBottomLeft   = net.getyLoc() + (net.getSize()/2);

		for (int i = 0; i < col.size() ; i++) {
            if(col.get(i) instanceof Dog){
                if ((((Dog) col.get(i)).getxLoc() > netXTopRight) && 
                		(((Dog) col.get(i)).getxLoc() < netYTopLeft) &&
                        (((Dog) col.get(i)).getyLoc() > netYBottomRight)&&
                        (((Dog) col.get(i)).getyLoc() < netYBottomLeft)) {
                    dogScop++;
                    initDog--;
                    System.out.println("Dog Scooped");
                    col.remove(i);
                    if (initDog == 0) {
                        System.out.print("End of Game");

                    }
                }
            }


        }
        for (int i = 0; i < col.size() ; i++) {
            if(col.get(i) instanceof Cat){
                if((((Cat) col.get(i)).getxLoc() > netXTopRight) && 
                		(((Cat) col.get(i)).getxLoc() < netYTopLeft) &&
                        (((Cat) col.get(i)).getyLoc() > netYBottomRight) &&
                        (((Cat) col.get(i)).getyLoc() < netYBottomLeft)){
                	
                    catScop++;
                    initCat--;
                    System.out.println("Cat Scooped");
                    col.remove(i);
                    if (initCat==0){
                    	System.out.println("No more Cats!");
                    }

                }
            }

        }
	
	}
	 
	//Expand size of net
	public void expandNet() {
		int x = net.getSize();
		if(x<500){
			net.setSize(x+10);
		}
		
	}

	//Decrease size of net
	public void decreaseNet() {
		int x = net.getSize();
		if (x>50){
			net.setSize(x-10);
		}
	}
	
	//Updates Animal variables 
	public void tick(){
		for(int i = 0; i <col.size(); i++){
			
			if(col.get(i)instanceof Animal){
				((Animal)col.get(i)).move();
			}
			
		}
	}
		
	//Net up
	public void up(){

		net.moveRight();
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
		
		for(int i=0; i < col.size(); i++){
	
			System.out.println(col.get(i));
			
		}
		
	}

	//Prints score 
	public void print() {
				
		if (dogScop>catScop){
			score = (dogScop-catScop)*10;
		}
		if (catScop>dogScop){
			score = (dogScop-catScop)*10;
		}

		if (scratches >0){
			for( int i = 0; i < scratches; i++ ){
				score = score -1;
		}
	}

		System.out.println("Current Score:" + score);
		System.out.println("Number of Dogs captured:" + dogScop);
		System.out.println("Number of Cats captured:" +  catScop);
		System.out.println("Number of Dogs left:" + initDog);
		System.out.println("Number of Cats left:" + initCat);
		
	}



}

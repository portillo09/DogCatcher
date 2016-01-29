/*Omar Portillo
 *CSC133
 *A1 for Dog Catcher Game
 * 
 * 
 */
package a1;
import java.util.Scanner;


public class Game {

	private GameWorld gw;
	private Scanner scanner;
		
	public Game() {
		gw = new GameWorld();
		gw.initLayout();
		play();	
		
	}

	private void play() {
		//code here to accept and
		//execute user commands that
		//operate on the GameWorld
	
		boolean run = true;
		while(run) {
			String command = getCommand();
			
			if(command.equals("m")){
				gw.map();
			}else if(command.equals("e")){
				System.out.println("Expand net size");
				gw.expandNet();
				
			}
			else if(command.equals("c")){
				System.out.println("Decrease net size");
				gw.decreaseNet(); 
				
			}else if(command.equals("s")){
				System.out.println("SCOOP");
				gw.scoop();
				
			}else if(command.equals("r")){
				System.out.println("Net right");
				gw.right();
				
			}else if(command.equals("l")){

				System.out.println("Net left");
				gw.left();
				
			}else if(command.equals("u")){
				
				System.out.println("Net up");
				gw.up();

			}else if(command.equals("d")){
				
				System.out.println("Net down");
				gw.down();
				
			}else if(command.equals("k")){
				gw.catAdd();
				
			}else if(command.equals("f")){
			
				System.out.println("Cat scratched a dog!");
				gw.fight();
				
			}else if(command.equals("t")){
				
				System.out.println("All Animals update positions");
				gw.tick();
				
			}else if(command.equals("p")){
				System.out.println("PRINT POINTS:  ");
				gw.print();
		
					
			}else if(command.equals("q")){
				
					System.out.println("Do you want to quit? y/n");
					if(scanner.nextLine().equals("y")) {
					System.exit(0);
					}else {
						continue;
					}
				}
			else{
					System.out.println("Not a valid command");
				}
			}
		}

	
	private String getCommand() {
		scanner= new Scanner(System.in);
		System.out.print("Type in a command: ");
		return scanner.nextLine();
	}


}


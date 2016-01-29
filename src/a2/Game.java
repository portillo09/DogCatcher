/*Omar Portillo
 *CSC133
 *A2 for Dog Catcher Game
 * 
 * This class is used to set up the initial game
 * and then get input from user to control game
 */
package a2;

import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.border.*;


@SuppressWarnings("serial")
public class Game extends JFrame{

	//Create a Game World
	private GameWorld gw;
	
	//Create the necessary views
	private ScoreView myScoreView;
	private MapView myMapView;
		
	public Game(){
		//Initialize the command
		
		JFrame frame = new JFrame();
		//Frame of GUI
		frame.setTitle("$EASY MONEY$");
		//where tp put
		frame.setLocation(0,300);
		//Set size of Window
		frame.setSize(1000,800);
		//Close on X button 
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// arrow keys
		KeyStroke upArrowKey = KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0);
		KeyStroke downArrowKey = KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0);
		KeyStroke leftArrowKey = KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0);
		KeyStroke rightArrowKey = KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0);
		KeyStroke sKey = KeyStroke.getKeyStroke(KeyEvent.VK_S, 0);
		KeyStroke rKey = KeyStroke.getKeyStroke(KeyEvent.VK_R, 0);
		KeyStroke lKey = KeyStroke.getKeyStroke(KeyEvent.VK_L, 0);
		KeyStroke uKey = KeyStroke.getKeyStroke(KeyEvent.VK_U, 0);
		KeyStroke dKey = KeyStroke.getKeyStroke(KeyEvent.VK_D, 0);
		KeyStroke qKey = KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0);
		KeyStroke tKey = KeyStroke.getKeyStroke(KeyEvent.VK_T, 0);
		

		
		//MENU bar
		JMenuBar bar = createMenuBar();
		frame.setJMenuBar(bar);
		frame.setVisible(true);
		
		//TOP PANEL For scores and status
		myScoreView = new ScoreView();
		frame.add(myScoreView, BorderLayout.NORTH);
		
		//LEFT Command PANEL
		JPanel leftPanel = new JPanel();
		leftPanel.setBorder(new TitledBorder(" Commands"));
		leftPanel.setLayout(new GridLayout(10,1));
		frame.add(leftPanel, BorderLayout.WEST);
		
		//add buttons here
		JButton expandButton = new JButton("Expand Net");
		expandButton.setAction(ExpandNetCommand.getInstance());
		leftPanel.add(expandButton);
	
		JButton shrinkButton = new JButton("Shrink Net");
		shrinkButton.setAction(ShrinkNetCommand.getInstance());
		leftPanel.add(shrinkButton);
		
		JButton scoopButton = new JButton("Scoop");
		scoopButton.setAction(ScoopCommand.getInstance());
		leftPanel.add(scoopButton);
		
		JButton netRightButton = new JButton("Move Right");
		netRightButton.setAction(NetRightCommand.getInstance());
		leftPanel.add(netRightButton);
		
		JButton netLeftButton = new JButton("Move Left");
		netLeftButton.setAction(NetLeftCommand.getInstance());
		leftPanel.add(netLeftButton);
		
		JButton netDownButton = new JButton("Move Down");
		netDownButton.setAction(NetDownCommand.getInstance());
		leftPanel.add(netDownButton);
		
		JButton netUpButton = new JButton("Move Up");
		netUpButton.setAction(NetUpCommand.getInstance());
		leftPanel.add(netUpButton);
		
		JButton kittenButton = new JButton("Kitten Collision");
		kittenButton.setAction(KittenCommand.getInstance());
		leftPanel.add(kittenButton);
		
		JButton fightButton = new JButton("Fight");
		fightButton.setAction(FightCommand.getInstance());
		leftPanel.add(fightButton);
		
		JButton tickButton = new JButton("Tick");
		tickButton.setAction(TickCommand.getInstance());
		leftPanel.add(tickButton);
				
		
		//Right/Center Map Panel
		myMapView = new MapView();
		frame.add(myMapView, BorderLayout.CENTER);
		
		//Get focus in this window
		int mapName = JComponent.WHEN_IN_FOCUSED_WINDOW;
		InputMap iMap= myMapView.getInputMap(mapName);
		
		//map keys to actions
		iMap.put(upArrowKey, "Net up");
		iMap.put(downArrowKey, "Net down");
		iMap.put(leftArrowKey, "Net left");
		iMap.put(rightArrowKey, "Net right");
		iMap.put(sKey, "SCOOP!");
		iMap.put(tKey, "TickClock");
		iMap.put(rKey, "Net Right");
		iMap.put(lKey, "Net Left");
		iMap.put(uKey, "Net Up");
		iMap.put(dKey, "Net Down");
		iMap.put(qKey, "Quit");
		
		
		//Action Map
		ActionMap aMap = myMapView.getActionMap();
		
		aMap.put("Net up",   NetUpCommand.getInstance());
		aMap.put("Net down", NetDownCommand.getInstance() );
		aMap.put("Net left", NetLeftCommand.getInstance() );
		aMap.put("Net right",NetRightCommand.getInstance());
		aMap.put("SCOOP!", ScoopCommand.getInstance());
		aMap.put("Cat/Dog Fight",FightCommand.getInstance());
		aMap.put("TickClock",TickCommand.getInstance());
		aMap.put("Quit", QuitCommand.getInstance());
		
		this.requestFocus();
		
		//create new game world
		gw = new GameWorld();
		
		//Register the views so they update at initalization 
		gw.addObserver(myScoreView);
		gw.addObserver(myMapView);
		
		//create the initial world
		gw.initLayout();
		
		
		// Make target that is needed
		ExpandNetCommand.setTarget(gw);
		ShrinkNetCommand.setTarget(gw);
		NetUpCommand.setTarget(gw);
		NetDownCommand.setTarget(gw);
		NetLeftCommand.setTarget(gw);
		NetRightCommand.setTarget(gw);
		KittenCommand.setTarget(gw);
		ScoopCommand.setTarget(gw);
		TickCommand.setTarget(gw);
		FightCommand.setTarget(gw);
		ToggleSoundCommand.setTarget(gw);
		
		frame.setVisible(true);
		frame.toFront();
		
		
	}

	private JMenuBar createMenuBar() {
		
		//init the bar you are going to return
		JMenuBar bar = new JMenuBar();
		
		//Create the File Menu
		JMenu fileMenu = new JMenu("File");
		
			//file to new
			JMenuItem aItem = new JMenuItem("New");
			aItem.setAction(NewCommand.getInstance());
			fileMenu.add(aItem);
			
			//file to save
			aItem = new JMenuItem("Save"); 
			aItem.setAction(SaveCommand.getInstance());
			fileMenu.add(aItem);
			
			//file to undo
			aItem= new JMenuItem("Undo");
			aItem.setAction(UndoCommand.getInstance());
			fileMenu.add(aItem);
			
			//file to sound
			JCheckBoxMenuItem soundMenuItem = new JCheckBoxMenuItem("Sound");
			soundMenuItem.setAction(ToggleSoundCommand.getInstance());
			soundMenuItem.setState(true);
			fileMenu.add(soundMenuItem);
			
			//file to About
			aItem= new JMenuItem("About");
			aItem.setAction(AboutCommand.getInstance());
			fileMenu.add(aItem);
	
		
			//file to Quit
			aItem= new JMenuItem("Quit");
			aItem.setAction(QuitCommand.getInstance());
			fileMenu.add(aItem);
			
			 bar.add(fileMenu);

		
		//Create the Command menu
		JMenu commandMenu = new JMenu("Commands");
		
			//command to expand the netsize
			aItem = new JMenuItem("Expand Net");
			aItem.setAction(ExpandNetCommand.getInstance());
			commandMenu.add(aItem);
		
			//command to decrease the net size
			aItem = new JMenuItem("Shrink Net");
			aItem.setAction(ShrinkNetCommand.getInstance());
			commandMenu.add(aItem);
		
			//command for Cat collision
			aItem = new JMenuItem("Kitten Collision");
			aItem.setAction(KittenCommand.getInstance());
			commandMenu.add(aItem);
			
			//command for Cat/Dog Fight
			aItem = new JMenuItem("Cat/Dog Fight");
			aItem.setAction(FightCommand.getInstance());
			commandMenu.add(aItem);
			
		 	bar.add(commandMenu);

		
		return bar;
	}
	

}


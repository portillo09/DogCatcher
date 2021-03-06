/*Omar Portillo
 *CSC133
 *A3 for Dog Catcher Game
 * 
 * This class is used to set up the initial game
 * and then get input from user to control game
 */
package a3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.border.*;


@SuppressWarnings("serial")
public class Game extends JFrame implements ActionListener{

	//Create a Game World
	private GameWorld gw;
	
	//Create the necessary views
	private ScoreView myScoreView;
	private MapView myMapView;
	private int DELAY= 20;
	private boolean isPaused;
	private JButton playPauseButton;
	private Timer timer = new Timer(DELAY, this);

	private KittenCommand aKittenCommand = KittenCommand.getInstance();
	private ShrinkNetCommand aShrinkNetCommand = ShrinkNetCommand.getInstance();
	private NetDownCommand aNetDownCommand = NetDownCommand.getInstance();
	private ExpandNetCommand aExpandNetCommand = ExpandNetCommand.getInstance();
	private FightCommand aFightCommand = FightCommand.getInstance();
	private NetLeftCommand aNetLeftCommand = NetLeftCommand.getInstance();
	private NetRightCommand aNetRightCommand = NetRightCommand.getInstance();
	private ScoopCommand aScoopCommand = ScoopCommand.getInstance();
	private HealCommand aHealCommand = HealCommand.getInstance();
	private NetUpCommand aNetUpCommand = NetUpCommand.getInstance();
	private HelpCommand aHelpCommand = HelpCommand.getInstance();

		
	public Game(){
		//Initialize the command
		
		JFrame frame = new JFrame();
		//Frame of GUI
		frame.setTitle("$EasyMoneyProductions$");
		//where tp put
		frame.setLocation(0,300);
		//Set size of Window
		frame.setSize(800,590);
		//Close on X button 
		frame.setResizable(false);
	    frame.setLocationRelativeTo(null);
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
		KeyStroke eKey = KeyStroke.getKeyStroke(KeyEvent.VK_E, 0);
		KeyStroke qKey = KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0);
		KeyStroke xKey = KeyStroke.getKeyStroke(KeyEvent.VK_X, 0);
		KeyStroke hKey = KeyStroke.getKeyStroke(KeyEvent.VK_H, 0);
		
		
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
		expandButton.setAction(aExpandNetCommand);
		leftPanel.add(expandButton);
	
		JButton shrinkButton = new JButton("Shrink Net");
		shrinkButton.setAction(aShrinkNetCommand);
		leftPanel.add(shrinkButton);
		
		JButton scoopButton = new JButton("Scoop");
		scoopButton.setAction(aScoopCommand);
		leftPanel.add(scoopButton);
		
		JButton netRightButton = new JButton("Move Right");
		netRightButton.setAction(aNetRightCommand);
		leftPanel.add(netRightButton);
		
		JButton netLeftButton = new JButton("Move Left");
		netLeftButton.setAction(aNetLeftCommand);
		leftPanel.add(netLeftButton);
		
		JButton netDownButton = new JButton("Move Down");
		netDownButton.setAction(aNetDownCommand);
		leftPanel.add(netDownButton);
		
		JButton netUpButton = new JButton("Move Up");
		netUpButton.setAction(aNetUpCommand);
		leftPanel.add(netUpButton);
		
		JButton healButton = new JButton("Heal Dog");
		healButton.setAction(aHealCommand);
		leftPanel.add(healButton);
				
		playPauseButton = new JButton("Pause");
		playPauseButton.setAction(PlayPauseCommand.getInstance());
		leftPanel.add(playPauseButton);
		
		JButton helpButton = new JButton("HELP");
		helpButton.setAction(aHelpCommand);
		leftPanel.add(helpButton);
				
				
		
		//Right/Center Map Panel
		myMapView = new MapView(gw);
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
		iMap.put(rKey, "Net Right");
		iMap.put(lKey, "Net Left");
		iMap.put(uKey, "Net Up");
		iMap.put(dKey, "Net Down");
		iMap.put(qKey, "Quit");
		iMap.put(eKey, "Expand Net" );
		iMap.put(xKey, "Shrink Net");
		iMap.put(hKey, "Help");
		
		
		//Action Map
		ActionMap aMap = myMapView.getActionMap();
		
		aMap.put("Net up", aNetUpCommand);
		aMap.put("Net down", aNetDownCommand);
		aMap.put("Net left", aNetLeftCommand);
		aMap.put("Net right",aNetRightCommand);
		aMap.put("SCOOP!", ScoopCommand.getInstance());
		aMap.put("Cat/Dog Fight",aFightCommand);
		aMap.put("Quit", QuitCommand.getInstance());
		aMap.put("Expand Net", aExpandNetCommand);
		aMap.put("Shrink Net", ShrinkNetCommand.getInstance());
		aMap.put("Heal", aHealCommand);
		aMap.put("Help", aHelpCommand);
		
		this.requestFocus();
		
		//create new game world
		gw = new GameWorld();
		
		
		//Register the views so they update at initalization 
		gw.addObserver(myScoreView);
		gw.addObserver(myMapView);
		
		//create the initial world
		gw.initLayout();
		
		//javax.swing.Timer timer = new javax.swing.Timer(DELAY, this);
		timer.start();
		
		
		// Make target that is needed
		ExpandNetCommand.setTarget(gw);
		ShrinkNetCommand.setTarget(gw);
		NetUpCommand.setTarget(gw);
		NetDownCommand.setTarget(gw);
		NetLeftCommand.setTarget(gw);
		NetRightCommand.setTarget(gw);
		KittenCommand.setTarget(gw);
		ScoopCommand.setTarget(gw);
		//TickCommand.setTarget(gw);
		FightCommand.setTarget(gw);
		ToggleSoundCommand.setTarget(gw);
		PlayPauseCommand.setTarget(this);
		HelpCommand.setTarget(gw);
		HealCommand.setTarget(gw);

		
		
		frame.setVisible(true);
		frame.toFront();
		
		resumeGame();
		
		
	
		
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
			
			//file to pause
			aItem= new JMenuItem("Pause");
			aItem.setAction(PlayPauseCommand.getInstance());
			fileMenu.add(aItem);
			
			//file to save
			aItem = new JMenuItem("Save"); 
			aItem.setAction(SaveCommand.getInstance());
			fileMenu.add(aItem);
			
			//file to undo
			aItem= new JMenuItem("Undo");
			aItem.setAction(HelpCommand.getInstance());
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
			
			//command for Cat/Dog Fight
			aItem = new JMenuItem("Pause");
			aItem.setAction(PlayPauseCommand.getInstance());
			commandMenu.add(aItem);
			
		 	bar.add(commandMenu);

		
		return bar;
	}
	
	public void actionPerformed(ActionEvent e){
		gw.tick(DELAY);
		repaint();
	}

	public boolean isPaused() {
		return isPaused;
	}



	public void resumeGame() {
		playPauseButton.setText("Pause");
	
		if(gw.soundIsOn()){
			gw.playBGC();
		}
		
		
		aHealCommand.setEnabled(false);
		

		aShrinkNetCommand.setEnabled(true);
		aNetDownCommand.setEnabled(true);
		aExpandNetCommand.setEnabled(true);
		aFightCommand.setEnabled(true);
		aKittenCommand.setEnabled(true);
		aNetLeftCommand.setEnabled(true);
		aNetRightCommand.setEnabled(true);
		aScoopCommand.setEnabled(true);
		aNetUpCommand.setEnabled(true);
		aHelpCommand.setEnabled(true);
		
		timer.start();
		isPaused = false;
		
	}



	public boolean isRunning() {
		return !isPaused;
	}



	public void pauseGame() {
		timer.stop();
		isPaused = true;
		playPauseButton.setText("Play");
		gw.stopBGC();
		

		
		//ENABLE COMMANDS
		aHealCommand.setEnabled(true);
		
		
		//DISABLE COMMANDS
		aShrinkNetCommand.setEnabled(false);
		aNetDownCommand.setEnabled(false);
		aExpandNetCommand.setEnabled(false);
		aFightCommand.setEnabled(false);
		aKittenCommand.setEnabled(false);
		aNetLeftCommand.setEnabled(false);
		aNetRightCommand.setEnabled(false);
		aScoopCommand.setEnabled(false);
		aNetUpCommand.setEnabled(false);
		aHelpCommand.setEnabled(false);

	}



}


package view;

import java.awt.BorderLayout;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;

/**
 * @ClassName: MainInterface
 *
 */
public class MainInterface extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public HashMap<Player, Integer> alreadyDealPlayers;
	GameEngine gameEngine;
	public boolean isUpdating=false;
	// statusBar
	StatusBar jlStatusBar;
	// menu bar
	MenuBar menuBar;
	//Current player
	private Player player;
	// player panel card,bet,score
	PlayerPanel playerPanel;
	// player list
	PlayerTable playerTable;
	ToolBar toolBar;

	public MainInterface(GameEngine ge) {
		// players that have dealt
		alreadyDealPlayers = new HashMap<Player, Integer>();
		this.gameEngine = ge;
		playerTable = new PlayerTable();
		// set data
		playerTable.setData(ge.getAllPlayers());
		this.playerPanel = new PlayerPanel(this);
		this.toolBar = new ToolBar(this);
		menuBar = new MenuBar(this);
		this.setJMenuBar(this.menuBar);
		jlStatusBar = new StatusBar();
		// set layout
		this.setLayout(new BorderLayout());
		JSplitPane jSplitPane = new JSplitPane();
		jSplitPane.setOneTouchExpandable(true);
		jSplitPane.setContinuousLayout(true);
		jSplitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		jSplitPane.setLeftComponent(playerPanel);
		jSplitPane.setRightComponent(playerTable);
		jSplitPane.setDividerSize(8);
		// add toolBar
		this.add(toolBar, BorderLayout.NORTH);
		this.add(jlStatusBar, BorderLayout.SOUTH);
		this.add(jSplitPane, BorderLayout.CENTER);
		// this.add(playerPanel, BorderLayout.WEST);



		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// set window icon
		// this.setIconImage(titleIcon);
		this.setTitle("CardGame");
		this.setSize(710, 620);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	/**
	 * addPlayer 
	 *
	 * @param id
	 * @param name
	 * @param points
	 */
	public void addPlayer(String id,String name,int points) {
		// validate id exist
		for (Player player : gameEngine.getAllPlayers()) {
			if (player.getPlayerId().equals(id)) {
				Message.showMessage("Player ID " + id + " already exist.");
				return;
			}
		}
		// new player
		Player player=new SimplePlayer(id, name, points);
		gameEngine.addPlayer(player);
		// update GUI
		updatePlayerComboBox();
		updatePlayerTable();
	}


	/**
	 * checkStatus 
	 * void
	 */
	public void checkStatus() {
		if (alreadyDealPlayers.size() == toolBar.jcb.getItemCount()) {
			toUpdStatusBar(player);

			new Thread() {
				@Override
				public void run() {
					gameEngine.dealHouse(1000);
				}
			}.start();
		}
	}

	/**
	 * dealPlayer  void
	 */
	public void dealPlayer() {
		if (player == null) {
			Message.showMessage("Select a player Please.");
		} else if (player.getBet() == 0) {
			Message.showMessage("place bet please.");
		} else if (alreadyDealPlayers.containsKey(player)) {
			Message.showMessage("Already dealed.");
		} else {
			if (alreadyDealPlayers.size() == 0) {
				for (Player player : gameEngine.getAllPlayers()) {
					player.setResult(0);
				}
			}
			alreadyDealPlayers.put(player, 0);
			playerPanel.houseScore = 0;
			// run the dealPlayer method
			new Thread() {
				@Override
				public void run() {
					gameEngine.dealPlayer(player, 2000);
				}
			}.start();
		}
	}

	/**
	 * houseResult  void
	 */
	public void houseResult() {
		// show information
		this.playerPanel.setBet("Game Over!!");
		this.playerPanel.houseScore = 0;
		this.jlStatusBar.setMessage(gameEngine.getAllPlayers().size() + " players have dealt. House has dealt.");
	}

	/**
	 * placeBet 
	 *
	 * @param id
	 * @param bet
	 */
	public void placeBet(String id,int bet) {
		if(!gameEngine.placeBet(gameEngine.getPlayer(id), bet))
		{
			Message.showMessage("Place bet fail.");
		} else {
			updatePlayerTable();
		}
	}

	/**
	 * playerResult 
	 *
	 * @param player void
	 */
	public void playerResult(Player player) {
		this.jlStatusBar.setMessage(player.getPlayerName() + " has dealt.");
	}

	/**
	 * selectedPlayer 
	 *
	 * @return Player
	 */
	public Player selectedPlayer()
	{
		return this.player;
	}

	/**
	 * setPlayer 
	 *
	 * @param id
	 */
	public void setPlayer(String id) {
		if (this.gameEngine.getPlayer(id) != null) {
			this.player = this.gameEngine.getPlayer(id);
			this.playerPanel.setScore(player);
			if(!this.isUpdating)
			{
				this.playerPanel.clearCard();
			}
		} else {
			Message.showMessage("Player " + id + " is not exist!");
		}

	}

	/**
	 * toUpdStatusBar 
	 *
	 * @param player
	 */
	void toUpdStatusBar(Player player) {
		if (player == null) {
			this.jlStatusBar.setMessage("House is dealing!");
		} else {
			this.jlStatusBar.setMessage(player.getPlayerName() + " is dealing!");
		}

	}

	/**
	 * updatePlayerComboBox  void
	 */
	public void updatePlayerComboBox() {
		// update combobox
		if (toolBar.jcb.getItemCount() != gameEngine.getAllPlayers().size()) {
			this.isUpdating = true;
			toolBar.setDate(gameEngine.getAllPlayers());
			this.isUpdating = false;
		}
	}

	/**
	 * updatePlayerTable  void
	 */
	public void updatePlayerTable() {
		playerTable.setData(gameEngine.getAllPlayers());
	}
}

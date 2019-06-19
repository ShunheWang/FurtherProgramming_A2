package view;

import javax.swing.SwingUtilities;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.PlayingCard;
import view.interfaces.GameEngineCallback;

public class GameEngineCallbackGUI implements GameEngineCallback {
	private MainInterface mi;

	public GameEngineCallbackGUI(GameEngine ge) {
		mi = new MainInterface(ge);
	}

	@Override
	public void bustCard(Player player, PlayingCard card, GameEngine engine) {
		// update card on the gui
		if (player.equals(mi.selectedPlayer())) {
			mi.playerPanel.setCard(card);
		}
	}

	@Override
	public void houseBustCard(PlayingCard card, GameEngine engine) {
		// update card the gui
		mi.playerPanel.setCard(card);
	}

	@Override
	public void houseResult(int result, GameEngine engine) {
		// update player table
		mi.updatePlayerTable();
		mi.updatePlayerComboBox();
		// clear already deal players
		mi.alreadyDealPlayers.clear();
		// show result
		mi.houseResult();
	}

	@Override
	public void nextCard(Player player, PlayingCard card, GameEngine engine) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {

				mi.updatePlayerComboBox();
				mi.updatePlayerTable();
				// save player score
				mi.playerPanel.saveScore(player, card);
				if (player.equals(mi.selectedPlayer()))
				{
					// show information
					mi.toUpdStatusBar(player);
					mi.playerPanel.setCard(card);
					mi.playerPanel.setScore(player);
				}
			}
		});

	}

	@Override
	public void nextHouseCard(PlayingCard card, GameEngine engine) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// set card
				mi.playerPanel.setCard(card);
				// show house status
				mi.toUpdStatusBar(null);
				mi.playerPanel.saveScore(null, card);
				mi.playerPanel.setScore(null);
			}
		});

	}

	@Override
	public void result(Player player, int result, GameEngine engine) {
		mi.toUpdStatusBar(player);
		mi.updatePlayerTable();
		// check status to deal house
		mi.checkStatus();

	}

}

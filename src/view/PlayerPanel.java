package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.interfaces.Player;
import model.interfaces.PlayingCard;

/**
 * @ClassName: PlayerPanel
 *
 */
public class PlayerPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int houseScore = 0;
	private JLabel jlBet;
	private JLabel jlCard;
	private JLabel jlScore;
	private JPanel jpCards;

	private MainInterface mi;

	public PlayerPanel(MainInterface mi) {
		JPanel jpBet, jpScore;

		this.mi = mi;
		jpCards = new JPanel();
		// border color
		jpCards.setBorder(BorderFactory.createLineBorder(Color.black));
		jpCards.setPreferredSize(new Dimension(200, 280));
		jpBet = new JPanel();
		jpBet.setBorder(BorderFactory.createLineBorder(Color.black));
		jpBet.setPreferredSize(new Dimension(200, 90));
		jlBet = new JLabel();
		jpBet.add(jlBet);
		jpScore = new JPanel();
		jpScore.setBorder(BorderFactory.createLineBorder(Color.black));
		jpScore.setPreferredSize(new Dimension(200, 90));
		jlScore = new JLabel();
		jpScore.add(jlScore);
		this.jlCard = new JLabel();
		jpCards.add(jlCard);
		// set layout
		this.setLayout(new BorderLayout());
		this.add(jpCards, BorderLayout.NORTH);
		this.add(jpBet, BorderLayout.CENTER);
		this.add(jpScore, BorderLayout.SOUTH);
		this.setPreferredSize(new Dimension(220, 480));
		this.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

	}

	/**
	 * clearCard 
	 */
	public void clearCard() {
		//
		this.jpCards.repaint();
		this.jpCards.removeAll();
		this.jpCards.validate();
	}

	/**
	 * saveScore 
	 *
	 * @param player
	 * @param card
	 */
	public void saveScore(Player player,PlayingCard card)
	{
		if (player == null) {
			this.houseScore += card.getScore();
		}
		// validate exist in already collection
		if (mi.alreadyDealPlayers.containsKey(player)) {
			int score = mi.alreadyDealPlayers.get(player);
			// player score
			score += card.getScore();
			mi.alreadyDealPlayers.put(player, score);
		}

	}

	/**
	 * setBet 
	 *
	 * @param str void
	 */
	public void setBet(String str) {
		this.jlBet.setText(str);
	}

	/**
	 * setCard 
	 *
	 * @param nextCard void
	 */
	public void setCard(PlayingCard nextCard) {
		// set image
		ImageIcon icon = new ImageIcon("card/" + nextCard.getSuit() + "/" + nextCard.getValue() + ".png");
		// reset image
		this.jpCards.removeAll();
		icon.setImage(icon.getImage().getScaledInstance(180, 270, Image.SCALE_DEFAULT));
		jlCard.setIcon(icon);
		jlCard.repaint();
		jlCard.validate();
		// jlnextCard = new JLabel(icon);
		this.jpCards.add(jlCard);
		this.jpCards.validate();
		this.jpCards.repaint();
	}

	/**
	 * setScore 
	 *
	 * @param player
	 */
	public void setScore(Player player) {
		// validate house or player
		if (player == null) {
			if (houseScore != 0) {
				this.jlBet.setText("House is dealing.");
				this.jlScore.setText("House's Score: " + this.houseScore);
			}
		} else {
			this.jlBet.setText(player.getPlayerName() + " Bet: " + player.getBet());
			if (mi.alreadyDealPlayers.containsKey(player)) {
				this.jlScore.setText(player.getPlayerName() + "'s Score: " + mi.alreadyDealPlayers.get(player));
			} else {
				this.jlScore.setText(player.getPlayerName() + "'s Score: 0");
			}
		}

	}

}

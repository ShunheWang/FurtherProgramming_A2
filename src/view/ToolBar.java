/**
 * @Title: ToolBar.java
 * @Package view
 * @Description: TODO
 * @author Administrator
 * @date 2018年10月14日 上午4:27:19 
 * @version V1.0   
 */
package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import controller.ItemChangeListener;
import controller.ToolBarListener;
import model.interfaces.Player;

/**
 * @ClassName: ToolBar   
 */
public class ToolBar extends JToolBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// fields
	JButton jbAddPlayer, jbBet, jbDeal;
	public JComboBox<String> jcb;
	JLabel jlChoosePlayer;
	public JTextField jtfBet;

	private MainInterface mi;

	public ToolBar(MainInterface mi) {
		this.mi = mi;
		ToolBarListener toolBarListener = new ToolBarListener(this, mi);
		jbAddPlayer = new JButton("Add New Player");
		jbAddPlayer.setActionCommand("add");
		jbAddPlayer.addActionListener(toolBarListener);
		jbAddPlayer.setToolTipText("You can add new player");
		jlChoosePlayer = new JLabel("Choose Player");
		jcb = new JComboBox<String>();
		jcb.addItemListener(new ItemChangeListener(mi));
		jcb.setPreferredSize(new Dimension(80, 25));
		jtfBet = new JTextField();
		jtfBet.setPreferredSize(new Dimension(80, 25));
		jbBet = new JButton("Set New Bet");
		jbBet.setActionCommand("setbet");
		jbBet.addActionListener(toolBarListener);
		jbBet.setToolTipText("Must be input integer only");
		jbDeal = new JButton("Deal");
		jbDeal.setActionCommand("deal");
		jbDeal.addActionListener(toolBarListener);
		jbDeal.setPreferredSize(new Dimension(60, 25));
		// settings
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(jbAddPlayer);
		this.addSeparator(new Dimension(2, 25));
		this.add(jlChoosePlayer);
		this.addSeparator(new Dimension(2, 25));
		this.add(jcb);
		this.addSeparator(new Dimension(2, 25));
		this.add(jtfBet);
		this.addSeparator(new Dimension(2, 25));
		this.add(jbBet);
		this.addSeparator(new Dimension(100, 0));
		this.add(jbDeal);

	}

	/**
	 * @return the mi
	 */
	public MainInterface getMi() {
		return mi;
	}

	/**
	 * setDate 
	 *
	 * @param players
	 */
	public void setDate(Collection<Player> players)
	{
		// clear id list
		jcb.removeAllItems();
		for(Player player:players)
		{
			jcb.addItem(player.getPlayerId());
		}
	}



}

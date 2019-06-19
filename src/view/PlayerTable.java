/**
 * @Title: PlayerTable.java
 * @Package view
 * @Description: TODO
 * @author Administrator
 * @date 2018年10月14日 上午5:13:34 
 * @version V1.0   
 */
package view;

import java.awt.Dimension;
import java.util.Collection;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.interfaces.Player;

/**
 * @ClassName: PlayerTable
 *
 */
public class PlayerTable extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel model;
	private JTable table;

	/**
	 * PlayerTable
	 */
	public PlayerTable() {
		table = new JTable();
		String[] columnNames = { "ID", "NAME", "POINTS", "BET", "RESULT" };
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		table.setModel(model);
		table.setPreferredSize(new Dimension(450, 450));

		JScrollPane jsp = new JScrollPane(table);
		jsp.setPreferredSize(new Dimension(450, 470));
		this.add(jsp);
	}

	/**
	 * setData 
	 *
	 * @param collection
	 */
	public void setData(Collection<Player> collection) {
		model.getDataVector().removeAllElements();
		// add data
		for (Player p : collection) {
			Object[] o = new Object[5];
			o[0] = p.getPlayerId();
			o[1] = p.getPlayerName();
			o[2] = p.getPoints();
			o[3] = p.getBet();
			o[4] = p.getResult();
			model.addRow(o);
		}
		table.repaint();
	}
}

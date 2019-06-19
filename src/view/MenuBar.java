/**
 * @Title: MenuBar.java
 * @Package view
 * @Description: TODO
 * @author Administrator
 * @date 2018年10月14日 上午4:51:22 
 * @version V1.0   
 */
package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.MenuBarListener;

/**
 * @ClassName: MenuBar
 *
 */
public class MenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// file
	private JMenu jMFile; //
	// add player
	private JMenuItem jmiAddPlayer;
	// exit
	private JMenuItem jmiExit;

	public MenuBar(MainInterface mi) {
		jMFile = new JMenu("File");
		jmiExit = new JMenuItem("Exit");
		jmiExit.setActionCommand("exit");
		jmiAddPlayer = new JMenuItem("Add Player");
		jmiAddPlayer.setActionCommand("addplayer");
		jMFile.add(jmiExit);
		jMFile.add(jmiAddPlayer);
		// event listener
		MenuBarListener mbl = new MenuBarListener(mi);
		jmiExit.addActionListener(mbl);
		jmiAddPlayer.addActionListener(mbl);
		this.add(jMFile);
	}
}

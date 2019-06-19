/**
 * @Title: MenuBarListener.java
 * @Package controller
 * @Description: TODO
 * @author Administrator
 * @date 2018年10月14日 下午11:57:50 
 * @version V1.0   
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AddPlayerInterface;
import view.MainInterface;

/**
 * @ClassName: MenuBarListener
 *
 */
public class MenuBarListener implements ActionListener {
	private MainInterface mi;

	public MenuBarListener(MainInterface mi) {
		this.mi = mi;
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		switch (event.getActionCommand()) {
		case "exit":
			System.exit(0);
			break;
		case "addplayer":
			new AddPlayerInterface(mi);
			break;
		default:
			break;
		}

	}

}

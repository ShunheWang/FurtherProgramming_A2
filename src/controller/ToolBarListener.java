/**
 * @Title: ToolBarListener.java
 * @Package controller
 * @Description: TODO
 * @author Administrator
 * @date 2018年10月14日 下午3:18:41 
 * @version V1.0   
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AddPlayerInterface;
import view.InputValidator;
import view.MainInterface;
import view.Message;
import view.ToolBar;

/**
 * @ClassName: ToolBarListener
 *
 */
public class ToolBarListener implements ActionListener {
	private MainInterface mi;
	private ToolBar toolBar;

	public ToolBarListener(ToolBar toolBar, MainInterface mi) {
		this.mi = mi;
		this.toolBar = toolBar;
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		switch (event.getActionCommand()) {
		case "add":
			new AddPlayerInterface(mi);
			break;
		case "setbet":
			// validate bet
			if (!InputValidator.isEmpty(toolBar.jtfBet.getText())) {
				Message.showMessage("Enter bet please.");
			} else if (!InputValidator.isNumeric(toolBar.jtfBet.getText())) {
				Message.showMessage("Enter a number please.");
			} else {
				int bet = Integer.parseInt(toolBar.jtfBet.getText());
				toolBar.jtfBet.setText("");
				// place bet
				mi.placeBet(toolBar.jcb.getSelectedItem().toString(), bet);
			}
			break;
		case "deal":
			mi.dealPlayer();
			break;
		default:
			break;
		}
	}

}

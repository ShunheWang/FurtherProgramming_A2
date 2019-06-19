package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AddPlayerInterface;
import view.InputValidator;
import view.MainInterface;
import view.Message;


/**
 * @ClassName: AddPlayerListener
 *
 */
public class AddPlayerListener implements ActionListener{
	private AddPlayerInterface api;
	private MainInterface mi;

	public AddPlayerListener(AddPlayerInterface api, MainInterface mi) {
		this.api=api;
		this.mi = mi;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == api.getJbAdd()) {
			// validate player information
			if(!InputValidator.isEmpty(api.getJtfId().getText().trim())) {
				Message.showMessage("Please input new player id");
			}else if(!InputValidator.isNumeric(api.getJtfId().getText().trim())) {
				Message.showMessage("New player id only is integer");
				api.getJtfId().setText("");
			}else if(!InputValidator.isEmpty(api.getJtfName().getText().trim())) {
				Message.showMessage("Please input new player name");
			}else if(!InputValidator.isString(api.getJtfName().getText().trim())) {
				Message.showMessage("New player name only has string");
				api.getJtfName().setText("");
			}else if(!InputValidator.isEmpty(api.getJtfPoints().getText().trim())) {
				Message.showMessage("Please input new player points");
			}else if(!InputValidator.isNumeric(api.getJtfPoints().getText().trim())) {
				Message.showMessage("New player points only are integer");
				api.getJtfPoints().setText("");
			}
			int points = Integer.parseInt(api.getJtfPoints().getText().trim());
			// add player
			mi.addPlayer(api.getJtfId().getText().trim(), api.getJtfName().getText().trim(), points);
			api.dispose();
		}else if(arg0.getSource() == api.getJbCancel()) {
			api.dispose();
		}


	}
}

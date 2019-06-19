package view;

import javax.swing.JOptionPane;

/**
 * @ClassName: Message
 * 
 */
public abstract class Message {
	public static void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);							//Print out message
	}
}
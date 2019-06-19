package view;

import java.awt.Dimension;

import javax.swing.JLabel;

/**
 * @ClassName: StatusBar
 *
 */
public class StatusBar extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Creates a new instance of StatusBar */
	public StatusBar() {
		super();
		super.setPreferredSize(new Dimension(100, 16));
		setMessage("Ready");
		// this.setForeground(Color.red);
		setPreferredSize(new Dimension(2, 35));
	}

	/**
	 * setMessage 
	 *
	 * @param message
	 */
	public void setMessage(String message) {
		setText("      " + message);
	}
}

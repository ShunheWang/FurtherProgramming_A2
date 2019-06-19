package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.AddPlayerListener;

/**
 * @ClassName: AddPlayerInterface
 *
 */
public class AddPlayerInterface extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton jbAdd,jbCancel;
	private JLabel jlId,jlName,jlPoints;
	private JTextField jtfId,jtfName,jtfPoints;

	public AddPlayerInterface(MainInterface mi) {
		jlId=new JLabel("Player id: ");
		jlName=new JLabel("Player name: ");
		jlPoints=new JLabel("Player points: ");

		jtfId=new JTextField();
		jtfName=new JTextField();
		jtfPoints=new JTextField();
		jbAdd=new JButton("Add");
		jbAdd.addActionListener(new AddPlayerListener(this, mi));
		jbCancel=new JButton("Cancel");
		jbCancel.addActionListener(new AddPlayerListener(this, mi));
		this.setLayout(new GridLayout(4,2));
		this.add(jlId);
		this.add(jtfId);
		this.add(jlName);
		this.add(jtfName);
		this.add(jlPoints);
		this.add(jtfPoints);
		this.add(jbAdd);
		this.add(jbCancel);

		this.setSize(350, 240);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(mi);
	}

	public JButton getJbAdd() {
		return this.jbAdd;
	}

	public JButton getJbCancel() {
		return this.jbCancel;
	}

	public JTextField getJtfId() {
		return jtfId;
	}

	public JTextField getJtfName() {
		return jtfName;
	}

	public JTextField getJtfPoints() {
		return jtfPoints;
	}

	public void resetJtfId() {
		this.jtfId = new JTextField();
	}

	public void resetJtfName() {
		jtfName = new JTextField();
	}

	public void resetJtfPoints() {
		jtfPoints = new JTextField();
	}
}

/**
 * @Title: ComboBoxSelectionListener.java
 * @Package controller
 * @Description: TODO
 * @author Administrator
 * @date 2018年10月14日 下午2:12:04 
 * @version V1.0   
 */
package controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import view.MainInterface;

/**
 * @ClassName: ComboBoxSelectionListener
 *
 */

public class ItemChangeListener implements ItemListener {
	private MainInterface mi;

	public ItemChangeListener(MainInterface mi) {
		this.mi = mi;
	}
	@Override
	public void itemStateChanged(ItemEvent event) {
		if (event.getStateChange() == ItemEvent.SELECTED) {
			Object item = event.getItem();
			// set player
			mi.setPlayer(item.toString());

		}
	}
}


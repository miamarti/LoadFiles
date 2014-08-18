package view;

import java.awt.EventQueue;
import java.text.ParseException;

/**
 * @author miamarti
 *
 */
public class Main {

	/**
	 * Launch the application.
	 * 
	 * @throws ParseException
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new TryIconView();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

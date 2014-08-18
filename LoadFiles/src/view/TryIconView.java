package view;

import java.awt.AWTException;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author miamarti
 *
 */
public class TryIconView {
	private TrayIcon trayIcon;

	/**
	 * 
	 */
	public TryIconView() {
		if (SystemTray.isSupported()) {
			this.getTray();
		} else {
			System.out.println("SystemTray is not supported");
		}
	}

	/**
	 * 
	 */
	public void getTray() {

		final PopupMenu popup = new PopupMenu();
		final SystemTray tray = SystemTray.getSystemTray();

		MenuItem aboutItem = new MenuItem("About");
		Menu displayMenu = new Menu("Carga de TXT");
		MenuItem propostaPipoLoad = new MenuItem("Proposta de TXT");

		MenuItem errorItem = new MenuItem("Error");
		MenuItem exitItem = new MenuItem("Exit");

		aboutItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				(new AboutView()).setVisible(true);
			}
		});

		propostaPipoLoad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				(new PaperView()).setVisible(true);
			}
		});

		exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		errorItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				trayIcon.setImage(Toolkit.getDefaultToolkit().getImage("\\\\Sjkap356\\htdocs\\img\\Alertas\\ErrorCircle-32.png"));
			}
		});

		popup.add(aboutItem);
		popup.addSeparator();
		popup.add(displayMenu);
		displayMenu.add(propostaPipoLoad);
		popup.add(exitItem);

		try {
			trayIcon = new TrayIcon(Toolkit.getDefaultToolkit().getImage("\\\\Sjkap356\\software\\Installer-Request-16x16.png"), "Load Files", popup);
			trayIcon.setPopupMenu(popup);
			trayIcon.setImageAutoSize(true);
			tray.add(trayIcon);
		} catch (AWTException e) {
			System.out.println("TrayIcon could not be added.");
		}
	}
}

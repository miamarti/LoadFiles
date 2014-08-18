package view;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 * @author miamarti
 *
 */
@SuppressWarnings("serial")
public class AboutView extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AboutView dialog = new AboutView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AboutView() {
		setType(Type.POPUP);
		setModal(true);
		setTitle("CLEVER CODE LTDA");
		setBounds(100, 100, 450, 150);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 442, 0 };
		gridBagLayout.rowHeights = new int[] { 41, 0, 0, 33, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);
		{
			JLabel label = new JLabel("Java TEAM - CLEVER CODE");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.insets = new Insets(0, 0, 5, 0);
			gbc_label.gridx = 0;
			gbc_label.gridy = 0;
			getContentPane().add(label, gbc_label);
		}
		{
			JLabel lblEmbraer = new JLabel("Charging System on Cloud");
			GridBagConstraints gbc_lblEmbraer = new GridBagConstraints();
			gbc_lblEmbraer.insets = new Insets(0, 0, 5, 0);
			gbc_lblEmbraer.gridx = 0;
			gbc_lblEmbraer.gridy = 1;
			getContentPane().add(lblEmbraer, gbc_lblEmbraer);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Suport phone .: +55 12 9 8107-0248");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 2;
			getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			GridBagConstraints gbc_buttonPane = new GridBagConstraints();
			gbc_buttonPane.anchor = GridBagConstraints.NORTH;
			gbc_buttonPane.fill = GridBagConstraints.HORIZONTAL;
			gbc_buttonPane.gridx = 0;
			gbc_buttonPane.gridy = 3;
			getContentPane().add(buttonPane, gbc_buttonPane);
			{
				JButton cancelButton = new JButton("Sign out");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent arg0) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Sign out");
				buttonPane.add(cancelButton);
			}

			try {
				for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
					if ("Nimbus".equals(info.getName())) {
						UIManager.setLookAndFeel(info.getClassName());
						SwingUtilities.updateComponentTreeUI(this);
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

}

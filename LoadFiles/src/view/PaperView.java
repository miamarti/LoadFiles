package view;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import business.PaperBO;

/**
 * @author miamarti
 *
 */
@SuppressWarnings("serial")
public class PaperView extends JFrame {

	private JPanel contentPane;

	/**
	 * 
	 */
	public PaperView() {
		setResizable(false);
		setType(Type.POPUP);
		setTitle("Paper Load");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 89);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		final JLabel lblNewLabel = new JLabel();
		final JButton btnSelecionarTxt = new JButton("Select CSV document");
		contentPane.add(lblNewLabel, BorderLayout.SOUTH);
		btnSelecionarTxt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if (btnSelecionarTxt.isEnabled()) {
					btnSelecionarTxt.setEnabled(false);
					PaperBO posBO = new PaperBO();
					posBO.setJLabel(lblNewLabel);
					Thread newThrd = new Thread(posBO);
					newThrd.start();
				}
			}
		});
		contentPane.add(btnSelecionarTxt, BorderLayout.NORTH);

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

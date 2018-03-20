package GUI;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import Controller.GroupController;
import Controller.PersonController;


public class MainMenu extends JFrame {

	private JPanel parentPanel;
	private JPanel menuPanel;
	private PersonController personCtr;
	private GroupController groupCtr;
	private PersonMenu personMenu;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					SwingUtilities.updateComponentTreeUI(frame);
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainMenu() throws SQLException {
		CardLayout cl = new CardLayout();
		parentPanel = new JPanel();
		menuPanel = new JPanel();
		personCtr = new PersonController();
		groupCtr = new GroupController();
		
		personMenu = new PersonMenu(parentPanel, cl, personCtr, groupCtr);


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		setContentPane(parentPanel);

		parentPanel.setLayout(cl);
		cl.show(parentPanel, "1");

		parentPanel.add(menuPanel, "1");
		parentPanel.add(personMenu, "2");
		menuPanel.setLayout(null);

		JLabel lblVelkommenTilVestbjerg = new JLabel("Micro Project");
		lblVelkommenTilVestbjerg.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVelkommenTilVestbjerg.setBounds(317, 93, 300, 32);
		menuPanel.add(lblVelkommenTilVestbjerg);

		JButton btnKunder = new JButton("Login");
		btnKunder.addActionListener(	new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(parentPanel, "2");
			}
		});
		btnKunder.setBounds(263, 210, 205, 102);
		menuPanel.add(btnKunder);


		JButton btnAfslut = new JButton("Afslut");
		btnAfslut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnAfslut.setBounds(325, 568, 89, 23);
		menuPanel.add(btnAfslut);

	}

}

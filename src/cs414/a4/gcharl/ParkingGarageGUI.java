package cs414.a4.gcharl;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JSplitPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;

import com.sun.corba.se.impl.protocol.giopmsgheaders.MessageHandler;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ParkingGarageGUI extends JFrame {

	private JPanel contentPane;
	private JTextField assignedTicketNumber;
	private JTextField exitTicketNum;
	private JTextField totalText;
	private JTextField textField_3;
	private JTextField textField_4;
	private FormOfPayment FOP;
	
	private Garage garage = new Garage(101);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParkingGarageGUI frame = new ParkingGarageGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ParkingGarageGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {150, 150, 150, 150, 150};
		gbl_contentPane.rowHeights = new int[]{23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblVacancy = new JLabel("Vacancy:");
		GridBagConstraints gbc_lblVacancy = new GridBagConstraints();
		gbc_lblVacancy.anchor = GridBagConstraints.EAST;
		gbc_lblVacancy.insets = new Insets(0, 0, 5, 5);
		gbc_lblVacancy.gridx = 0;
		gbc_lblVacancy.gridy = 0;
		contentPane.add(lblVacancy, gbc_lblVacancy);
		
		final JTextPane vacancyPane = new JTextPane();
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.insets = new Insets(0, 0, 5, 5);
		gbc_textPane.fill = GridBagConstraints.BOTH;
		gbc_textPane.gridx = 1;
		gbc_textPane.gridy = 0;
		contentPane.add(vacancyPane, gbc_textPane);
		
		final JTextPane entryGatePane = new JTextPane();
		GridBagConstraints gbc_textPane_1 = new GridBagConstraints();
		gbc_textPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_textPane_1.fill = GridBagConstraints.BOTH;
		gbc_textPane_1.gridx = 1;
		gbc_textPane_1.gridy = 3;
		contentPane.add(entryGatePane, gbc_textPane_1);
		
		JButton btnEntergarage = new JButton("EnterGarage");
		btnEntergarage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				assignedTicketNumber.setText(garage.getEntryGate().requestEntry().toString());
				entryGatePane.setText("Open");
				if (garage.isGarageAcceptingVehicles()) {
					vacancyPane.setText("Yes");
				} else {
					vacancyPane.setText("No");
				}
				
			}
		});
		GridBagConstraints gbc_btnEntergarage = new GridBagConstraints();
		gbc_btnEntergarage.insets = new Insets(0, 0, 5, 5);
		gbc_btnEntergarage.gridx = 0;
		gbc_btnEntergarage.gridy = 1;
		contentPane.add(btnEntergarage, gbc_btnEntergarage);
		
		JLabel lblYourAssignedTicket = new JLabel("Your Assigned Ticket Number:");
		GridBagConstraints gbc_lblYourAssignedTicket = new GridBagConstraints();
		gbc_lblYourAssignedTicket.insets = new Insets(0, 0, 5, 5);
		gbc_lblYourAssignedTicket.anchor = GridBagConstraints.EAST;
		gbc_lblYourAssignedTicket.gridx = 0;
		gbc_lblYourAssignedTicket.gridy = 2;
		contentPane.add(lblYourAssignedTicket, gbc_lblYourAssignedTicket);
		
		assignedTicketNumber = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		contentPane.add(assignedTicketNumber, gbc_textField);
		assignedTicketNumber.setColumns(10);
		
		JLabel lblEntryGate = new JLabel("Entry Gate:");
		GridBagConstraints gbc_lblEntryGate = new GridBagConstraints();
		gbc_lblEntryGate.insets = new Insets(0, 0, 5, 5);
		gbc_lblEntryGate.gridx = 0;
		gbc_lblEntryGate.gridy = 3;
		contentPane.add(lblEntryGate, gbc_lblEntryGate);
		
		JLabel lblAdministratorLogin = new JLabel("Administrator Login");
		GridBagConstraints gbc_lblAdministratorLogin = new GridBagConstraints();
		gbc_lblAdministratorLogin.insets = new Insets(0, 0, 5, 0);
		gbc_lblAdministratorLogin.gridx = 3;
		gbc_lblAdministratorLogin.gridy = 4;
		contentPane.add(lblAdministratorLogin, gbc_lblAdministratorLogin);
		
		JLabel lblNewLabel_2 = new JLabel("ID:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 5;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 3;
		gbc_textField_3.gridy = 5;
		contentPane.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 2;
		gbc_lblPassword.gridy = 6;
		contentPane.add(lblPassword, gbc_lblPassword);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 3;
		gbc_textField_4.gridy = 6;
		contentPane.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.insets = new Insets(0, 0, 5, 0);
		gbc_btnLogin.gridx = 3;
		gbc_btnLogin.gridy = 7;
		contentPane.add(btnLogin, gbc_btnLogin);
		
		JLabel lblTicketId = new JLabel("Ticket ID:");
		GridBagConstraints gbc_lblTicketId = new GridBagConstraints();
		gbc_lblTicketId.insets = new Insets(0, 0, 5, 5);
		gbc_lblTicketId.anchor = GridBagConstraints.EAST;
		gbc_lblTicketId.gridx = 0;
		gbc_lblTicketId.gridy = 12;
		contentPane.add(lblTicketId, gbc_lblTicketId);
		
		exitTicketNum = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 12;
		contentPane.add(exitTicketNum, gbc_textField_1);
		exitTicketNum.setColumns(10);
		
		JButton btnExitGarage = new JButton("Exit Garage");
		btnExitGarage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				entryGatePane.setText("Closed");
				Ticket t1 = new Ticket();
				if (exitTicketNum.getText() == "") {
					//MessageHandler mh = new MessageHandler();
				} else {
					
					for (Ticket t : garage.getEntryGate().tickets) {
						if (t.toString().equals(exitTicketNum.getText())) {
							t1 = t;
						}
					}					
					garage.getExitGate().requestExit(t1, FOP);
					for (Sale s : garage.getExitGate().getSales()) {
						if (s.getTicket().toString() == exitTicketNum.getText()){
							String temp = "" + s.getTotal();
							totalText.setText(temp);
						}
					}
					if (garage.isGarageAcceptingVehicles()) {
						vacancyPane.setText("Yes");
					} else {
						vacancyPane.setText("No");
					}
				}
				
			}
		});
		GridBagConstraints gbc_btnExitGarage = new GridBagConstraints();
		gbc_btnExitGarage.insets = new Insets(0, 0, 5, 5);
		gbc_btnExitGarage.gridx = 0;
		gbc_btnExitGarage.gridy = 13;
		contentPane.add(btnExitGarage, gbc_btnExitGarage);
		
		JLabel lblNewLabel_1 = new JLabel("Payment Type:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 14;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JRadioButton rdbtnCash = new JRadioButton("Cash");
		rdbtnCash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FOP = FormOfPayment.Cash;
			}
		});
		GridBagConstraints gbc_rdbtnCash = new GridBagConstraints();
		gbc_rdbtnCash.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnCash.gridx = 2;
		gbc_rdbtnCash.gridy = 14;
		contentPane.add(rdbtnCash, gbc_rdbtnCash);
		
		JLabel lblNewLabel = new JLabel("Total");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 15;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		totalText = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 15;
		contentPane.add(totalText, gbc_textField_2);
		totalText.setColumns(10);
		
		JRadioButton rdbtnCreditCard = new JRadioButton("Credit Card");
		rdbtnCreditCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FOP = FormOfPayment.CreditCard;
			}
		});
		GridBagConstraints gbc_rdbtnCreditCard = new GridBagConstraints();
		gbc_rdbtnCreditCard.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnCreditCard.gridx = 2;
		gbc_rdbtnCreditCard.gridy = 15;
		contentPane.add(rdbtnCreditCard, gbc_rdbtnCreditCard);
		
		JButton btnMakePayment = new JButton("Make Payment");
		GridBagConstraints gbc_btnMakePayment = new GridBagConstraints();
		gbc_btnMakePayment.insets = new Insets(0, 0, 0, 5);
		gbc_btnMakePayment.gridx = 2;
		gbc_btnMakePayment.gridy = 16;
		contentPane.add(btnMakePayment, gbc_btnMakePayment);
	}

}

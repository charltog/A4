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
	private JTextPane assignedTicketNumber;
	private JTextField exitTicketNum;
	private JTextPane totalText;
	private JTextField adminID;
	private JTextField adminPassword;
	private FormOfPayment FOP;
	
	private Garage garage = new Garage(101);
	private int totalAmt = 0;
	private int payAmt;
	private JTextField paymentAmount;
	private GridBagConstraints gbc_paymentAmount;

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
		gbl_contentPane.rowHeights = new int[]{28, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblEntryGate = new JLabel("Entry Gate:");
		GridBagConstraints gbc_lblEntryGate = new GridBagConstraints();
		gbc_lblEntryGate.insets = new Insets(0, 0, 5, 5);
		gbc_lblEntryGate.gridx = 0;
		gbc_lblEntryGate.gridy = 0;
		contentPane.add(lblEntryGate, gbc_lblEntryGate);
		
		final JTextPane entryGatePane = new JTextPane();
		entryGatePane.setText("Closed");
		GridBagConstraints gbc_textPane_1 = new GridBagConstraints();
		gbc_textPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_textPane_1.gridx = 1;
		gbc_textPane_1.gridy = 0;
		contentPane.add(entryGatePane, gbc_textPane_1);
		
		JLabel lblVacancy = new JLabel("Vacancy:");
		GridBagConstraints gbc_lblVacancy = new GridBagConstraints();
		gbc_lblVacancy.anchor = GridBagConstraints.EAST;
		gbc_lblVacancy.insets = new Insets(0, 0, 5, 5);
		gbc_lblVacancy.gridx = 2;
		gbc_lblVacancy.gridy = 0;
		contentPane.add(lblVacancy, gbc_lblVacancy);
		
		final JTextPane vacancyPane = new JTextPane();
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.insets = new Insets(0, 0, 5, 0);
		gbc_textPane.gridx = 3;
		gbc_textPane.gridy = 0;
		contentPane.add(vacancyPane, gbc_textPane);
		vacancyPane.setText("Yes");
		
		JButton btnGetTicket = new JButton("Get Ticket");
		btnGetTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ticket t1 = garage.getEntryGate().requestTicket();
				if (t1 != null) {
					assignedTicketNumber.setText(t1.toString());
					entryGatePane.setText("Open");
					vacancyPane.setText("Yes");					
				} else {
					assignedTicketNumber.setText("Sorry, Garage is Full");
					entryGatePane.setText("Closed");
					vacancyPane.setText("No");
				}				
			}
		});
		
		JButton btnEnterGarage = new JButton("Enter Garage");
		btnEnterGarage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				entryGatePane.setText("Closed");		
				assignedTicketNumber.setText("");
				garage.getEntryGate().enterGarage();
			}
		});
		
		GridBagConstraints gbc_btnGetTicket = new GridBagConstraints();
		gbc_btnGetTicket.gridwidth = 2;
		gbc_btnGetTicket.insets = new Insets(0, 0, 5, 5);
		gbc_btnGetTicket.gridx = 0;
		gbc_btnGetTicket.gridy = 1;
		contentPane.add(btnGetTicket, gbc_btnGetTicket);
		
		JLabel lblYourAssignedTicket = new JLabel("Your Assigned Ticket Number:");
		GridBagConstraints gbc_lblYourAssignedTicket = new GridBagConstraints();
		gbc_lblYourAssignedTicket.insets = new Insets(0, 0, 5, 5);
		gbc_lblYourAssignedTicket.anchor = GridBagConstraints.EAST;
		gbc_lblYourAssignedTicket.gridx = 0;
		gbc_lblYourAssignedTicket.gridy = 2;
		contentPane.add(lblYourAssignedTicket, gbc_lblYourAssignedTicket);
		
		assignedTicketNumber = new JTextPane();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		contentPane.add(assignedTicketNumber, gbc_textField);
				
		GridBagConstraints gbc_btnEnterGarage = new GridBagConstraints();
		gbc_btnEnterGarage.fill = GridBagConstraints.BOTH;
		gbc_btnEnterGarage.insets = new Insets(0, 0, 5, 5);
		gbc_btnEnterGarage.gridx = 0;
		gbc_btnEnterGarage.gridy = 3;
		contentPane.add(btnEnterGarage, gbc_btnEnterGarage);
		
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
		
		adminID = new JTextField();
		GridBagConstraints gbc_adminID = new GridBagConstraints();
		gbc_adminID.insets = new Insets(0, 0, 5, 0);
		gbc_adminID.fill = GridBagConstraints.HORIZONTAL;
		gbc_adminID.gridx = 3;
		gbc_adminID.gridy = 5;
		contentPane.add(adminID, gbc_adminID);
		adminID.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 2;
		gbc_lblPassword.gridy = 6;
		contentPane.add(lblPassword, gbc_lblPassword);
		
		adminPassword = new JTextField();
		GridBagConstraints gbc_adminPassword = new GridBagConstraints();
		gbc_adminPassword.insets = new Insets(0, 0, 5, 0);
		gbc_adminPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_adminPassword.gridx = 3;
		gbc_adminPassword.gridy = 6;
		contentPane.add(adminPassword, gbc_adminPassword);
		adminPassword.setColumns(10);
		
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
		gbc_lblTicketId.gridy = 9;
		contentPane.add(lblTicketId, gbc_lblTicketId);
		
		exitTicketNum = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 9;
		contentPane.add(exitTicketNum, gbc_textField_1);
		exitTicketNum.setColumns(10);
		
		JButton btnGetTotal = new JButton("Get Total");
		btnGetTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String testString = exitTicketNum.getText();
				Ticket t1 = garage.getEntryGate().findTicketByID(testString);
				if (t1 == null) {
					totalText.setText("Bad ticket #");
				} else {				
					//Sale s1 = new Sale(t1);
					Sale s1 = garage.getExitGate().requestExit(t1);
					if (s1.getTotal() != 0.0 ) {
						totalText.setText("" + s1.roundedTotal + ".00");
					} else {
						totalText.setText("0.00");
					}
				}
			}
		});
		GridBagConstraints gbc_btnGetTotal = new GridBagConstraints();
		gbc_btnGetTotal.insets = new Insets(0, 0, 5, 5);
		gbc_btnGetTotal.gridx = 1;
		gbc_btnGetTotal.gridy = 10;
		contentPane.add(btnGetTotal, gbc_btnGetTotal);
		
		JLabel lblTotal = new JLabel("Remaining Total you owe:");
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.anchor = GridBagConstraints.EAST;
		gbc_lblTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotal.gridx = 0;
		gbc_lblTotal.gridy = 11;
		contentPane.add(lblTotal, gbc_lblTotal);
		
		totalText = new JTextPane();
		GridBagConstraints gbc_totalText = new GridBagConstraints();
		gbc_totalText.insets = new Insets(0, 0, 5, 5);
		gbc_totalText.fill = GridBagConstraints.HORIZONTAL;
		gbc_totalText.gridx = 1;
		gbc_totalText.gridy = 11;
		contentPane.add(totalText, gbc_totalText);
		
		JButton btnExitGarage = new JButton("Exit Garage");
		btnExitGarage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Ticket t1 = new Ticket();
				String testString = exitTicketNum.getText();
				for (Ticket t : garage.getEntryGate().tickets) {
					if (t.toString().equals(testString)) {
						t1 = t;
					}
				}	
				Sale s1 = new Sale(t1);
				if (s1.getTotal() > 0.0 ) {
					totalText.setText("" + s1.roundedTotal + ".00");	
				} else {
					totalText.setText("Goodbye");
					garage.getExitGate().exitGarage();					
				}
				
//				if (FOP == null) {
//					// need FOP
//					
//				} else {
//					Ticket t1 = new Ticket();
//	//				if (exitTicketNum.getText() == "") {
//	//					//MessageHandler mh = new MessageHandler();
//	//				} else {
//	//					
//					String testString = exitTicketNum.getText();
//						for (Ticket t : garage.getEntryGate().tickets) {
//							if (t.toString().equals(testString)) {
//								t1 = t;
//							}
//						}					
//						Sale s1 = garage.getExitGate().requestExit(t1, FOP);						
////						for (Sale s : garage.getExitGate().getSales()) {
////							if (s.getTicket().toString() == testString){
////								String temp = "" + s.getTotal();
////								totalText.setText(temp);
////							}
////						}
//						totalText.setText("" + s1.getTotal());
						
						if (garage.isGarageAcceptingVehicles()) {
							vacancyPane.setText("Yes");
						} else {
							vacancyPane.setText("No");
						}
					//}
//				}
				
			}
		});
		
		JButton btnMakePayment = new JButton("Make Payment");
		btnMakePayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String testString = exitTicketNum.getText();
				Ticket t1 = garage.getEntryGate().findTicketByID(testString);
				Sale s1 = garage.getExitGate().findSaleByTicketId(t1);
				
				if (garage.getExitGate().makePayment(s1, payAmt, FOP)) {
					totalText.setText("");
					paymentAmount.setText("");
				} else {
					paymentAmount.setText("Payment Failed");
				}
			}
		});
		GridBagConstraints gbc_btnMakePayment = new GridBagConstraints();
		gbc_btnMakePayment.insets = new Insets(0, 0, 0, 5);
		gbc_btnMakePayment.gridx = 1;
		gbc_btnMakePayment.gridy = 16;
		contentPane.add(btnMakePayment, gbc_btnMakePayment);
		
		GridBagConstraints gbc_btnExitGarage = new GridBagConstraints();
		gbc_btnExitGarage.fill = GridBagConstraints.BOTH;
		gbc_btnExitGarage.gridheight = 3;
		gbc_btnExitGarage.insets = new Insets(0, 0, 5, 0);
		gbc_btnExitGarage.gridx = 3;
		gbc_btnExitGarage.gridy = 12;
		contentPane.add(btnExitGarage, gbc_btnExitGarage);
		
		JLabel lblNewLabel_1 = new JLabel("Payment Type:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 13;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		final JRadioButton rdbtnCash = new JRadioButton("Cash");
		final JRadioButton rdbtnCreditCard = new JRadioButton("Credit Card");
		rdbtnCash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FOP = FormOfPayment.Cash;
				rdbtnCreditCard.setSelected(false);
			}
		});
		rdbtnCreditCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FOP = FormOfPayment.CreditCard;
				rdbtnCash.setSelected(false);
			}
		});
		
		JLabel lblPaymentAmount = new JLabel("Payment Amount:");
		GridBagConstraints gbc_lblPaymentAmount = new GridBagConstraints();
		gbc_lblPaymentAmount.insets = new Insets(0, 0, 5, 5);
		gbc_lblPaymentAmount.gridx = 1;
		gbc_lblPaymentAmount.gridy = 13;
		contentPane.add(lblPaymentAmount, gbc_lblPaymentAmount);
		
		GridBagConstraints gbc_rdbtnCash = new GridBagConstraints();
		gbc_rdbtnCash.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnCash.gridx = 0;
		gbc_rdbtnCash.gridy = 14;
		contentPane.add(rdbtnCash, gbc_rdbtnCash);
		
		
		paymentAmount = new JTextField();
		GridBagConstraints gbc_paymentAmount;
		gbc_paymentAmount = new GridBagConstraints();
		gbc_paymentAmount.insets = new Insets(0, 0, 5, 5);
		gbc_paymentAmount.fill = GridBagConstraints.HORIZONTAL;
		gbc_paymentAmount.gridx = 1;
		gbc_paymentAmount.gridy = 14;
		contentPane.add(paymentAmount, gbc_paymentAmount);
		paymentAmount.setColumns(10);
		
		GridBagConstraints gbc_rdbtnCreditCard = new GridBagConstraints();
		gbc_rdbtnCreditCard.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnCreditCard.gridx = 0;
		gbc_rdbtnCreditCard.gridy = 15;
		contentPane.add(rdbtnCreditCard, gbc_rdbtnCreditCard);
		
	}

}

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
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import java.awt.Color;
import java.awt.Font;

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
	private double payAmt = 0.0;
	private JTextField paymentAmount;
	private GridBagConstraints gbc_paymentAmount;
	private JTextField exitInformation;
	private JTextField changeAmount;

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
		gbl_contentPane.rowHeights = new int[]{28, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
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
		GridBagConstraints gbc_vacancyPane = new GridBagConstraints();
		gbc_vacancyPane.insets = new Insets(0, 0, 5, 0);
		gbc_vacancyPane.gridx = 3;
		gbc_vacancyPane.gridy = 0;
		contentPane.add(vacancyPane, gbc_vacancyPane);
		vacancyPane.setText("Yes");
		
		final JTextPane exitGatePane = new JTextPane();
		exitGatePane.setEditable(false);
		exitGatePane.setText("Closed");
		GridBagConstraints gbc_exitGatePane = new GridBagConstraints();
		gbc_exitGatePane.gridheight = 2;
		gbc_exitGatePane.insets = new Insets(0, 0, 0, 5);
		gbc_exitGatePane.gridx = 1;
		gbc_exitGatePane.gridy = 16;
		contentPane.add(exitGatePane, gbc_exitGatePane);
		
		
		final JButton btnGetTicket = new JButton("Get Ticket");
		
		final JButton btnEnterGarage = new JButton("Enter Garage");
		btnEnterGarage.setEnabled(false);
		
		final JButton btnMakePayment = new JButton("Make Payment");
		btnMakePayment.setEnabled(false);
		
		final JButton btnGetTotal = new JButton("Get Total");
		btnGetTotal.setEnabled(false);
		
		final JButton btnExitGarage = new JButton("Exit Garage");
		btnExitGarage.setEnabled(false);
		
		final JRadioButton rdbtnCreditCard = new JRadioButton("Credit Card");
		final JRadioButton rdbtnCash = new JRadioButton("Cash");
		
				
		btnGetTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				exitInformation.setText("");
				Ticket t1 = garage.getEntryGate().requestTicket();
				if (t1 != null) {
					assignedTicketNumber.setText(t1.toString());
					entryGatePane.setText("Open");
					vacancyPane.setText("Yes");			
					btnEnterGarage.setEnabled(true);
					btnGetTicket.setEnabled(false);
				} else {
					assignedTicketNumber.setText("Sorry, Garage is Full");
					entryGatePane.setText("Closed");
					vacancyPane.setText("No");
				}				
			}
		});
		
		btnEnterGarage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitInformation.setText("");
				entryGatePane.setText("Closed");		
				assignedTicketNumber.setText("");
				garage.getEntryGate().enterGarage();
				btnEnterGarage.setEnabled(false);
				btnGetTicket.setEnabled(true);
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
		assignedTicketNumber.setBackground(Color.LIGHT_GRAY);
		assignedTicketNumber.setForeground(Color.BLACK);
		assignedTicketNumber.setEditable(false);
		GridBagConstraints gbc_exitGarageSign = new GridBagConstraints();
		gbc_exitGarageSign.insets = new Insets(0, 0, 5, 5);
		gbc_exitGarageSign.fill = GridBagConstraints.HORIZONTAL;
		gbc_exitGarageSign.gridx = 1;
		gbc_exitGarageSign.gridy = 2;
		contentPane.add(assignedTicketNumber, gbc_exitGarageSign);
				
		GridBagConstraints gbc_btnEnterGarage = new GridBagConstraints();
		gbc_btnEnterGarage.fill = GridBagConstraints.BOTH;
		gbc_btnEnterGarage.insets = new Insets(0, 0, 5, 5);
		gbc_btnEnterGarage.gridx = 0;
		gbc_btnEnterGarage.gridy = 3;
		contentPane.add(btnEnterGarage, gbc_btnEnterGarage);
		
		exitTicketNum = new JTextField();
		exitTicketNum.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				String testString = exitTicketNum.getText();
				Ticket t1 = garage.getEntryGate().findTicketByID(testString);
				//Sale s1 = garage.getExitGate().findSaleByTicketId(t1);
				if (t1 != null && t1.isValid()) {
					btnGetTotal.setEnabled(true);	
					btnExitGarage.setEnabled(true);
				} else {
					btnGetTotal.setEnabled(false);
					btnExitGarage.setEnabled(false);
				}
			}
		});
		
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
		
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 6;
		contentPane.add(exitTicketNum, gbc_textField_1);
		exitTicketNum.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
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
		
		JLabel lblTicketId = new JLabel("Ticket ID:");
		GridBagConstraints gbc_lblTicketId = new GridBagConstraints();
		gbc_lblTicketId.insets = new Insets(0, 0, 5, 5);
		gbc_lblTicketId.anchor = GridBagConstraints.EAST;
		gbc_lblTicketId.gridx = 0;
		gbc_lblTicketId.gridy = 7;
		contentPane.add(lblTicketId, gbc_lblTicketId);
		
		GridBagConstraints gbc_btnGetTotal = new GridBagConstraints();
		gbc_btnGetTotal.insets = new Insets(0, 0, 5, 5);
		gbc_btnGetTotal.gridx = 1;
		gbc_btnGetTotal.gridy = 7;
		contentPane.add(btnGetTotal, gbc_btnGetTotal);
		
		btnGetTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				exitInformation.setText("");
				String testString = exitTicketNum.getText();
				Ticket t1 = garage.getEntryGate().findTicketByID(testString);
				if (t1 == null) {
					totalText.setText("Ticket not found");
				} else if (!t1.isValid()) {
					totalText.setText("Invalid Ticket");
				} else {
					Sale s1 = garage.getExitGate().requestExit(t1);
					//totalText.setText("" + s1.roundedTotal + ".00");
					String s = String.format("$ %.2f", s1.getTotal());
					totalText.setText(s);
					btnMakePayment.setEnabled(true);
				}
			}
		});
		
		JButton btnLogin = new JButton("Login");
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.insets = new Insets(0, 0, 5, 0);
		gbc_btnLogin.gridx = 3;
		gbc_btnLogin.gridy = 7;
		contentPane.add(btnLogin, gbc_btnLogin);
		
		JLabel lblTotal = new JLabel("Remaining Total you owe:");
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.anchor = GridBagConstraints.EAST;
		gbc_lblTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotal.gridx = 0;
		gbc_lblTotal.gridy = 8;
		contentPane.add(lblTotal, gbc_lblTotal);
		
		totalText = new JTextPane();
		totalText.setBackground(Color.LIGHT_GRAY);
		totalText.setEditable(false);
		GridBagConstraints gbc_totalText = new GridBagConstraints();
		gbc_totalText.insets = new Insets(0, 0, 5, 5);
		gbc_totalText.fill = GridBagConstraints.HORIZONTAL;
		gbc_totalText.gridx = 1;
		gbc_totalText.gridy = 8;
		contentPane.add(totalText, gbc_totalText);
		
		JLabel lblNewLabel_1 = new JLabel("Payment Type:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 9;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblPaymentAmount = new JLabel("Payment Amount:");
		GridBagConstraints gbc_lblPaymentAmount = new GridBagConstraints();
		gbc_lblPaymentAmount.insets = new Insets(0, 0, 5, 5);
		gbc_lblPaymentAmount.gridx = 1;
		gbc_lblPaymentAmount.gridy = 9;
		contentPane.add(lblPaymentAmount, gbc_lblPaymentAmount);
		
		rdbtnCash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FOP = FormOfPayment.Cash;
				rdbtnCreditCard.setSelected(false);
			}
		});
		
		GridBagConstraints gbc_rdbtnCash = new GridBagConstraints();
		gbc_rdbtnCash.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnCash.gridx = 0;
		gbc_rdbtnCash.gridy = 10;
		contentPane.add(rdbtnCash, gbc_rdbtnCash);
		
		
		paymentAmount = new JTextField();
		gbc_paymentAmount = new GridBagConstraints();
		gbc_paymentAmount.insets = new Insets(0, 0, 5, 5);
		gbc_paymentAmount.fill = GridBagConstraints.HORIZONTAL;
		gbc_paymentAmount.gridx = 1;
		gbc_paymentAmount.gridy = 10;
		contentPane.add(paymentAmount, gbc_paymentAmount);
		paymentAmount.setColumns(10);
		
		
		btnMakePayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitInformation.setText("");
				String testString = exitTicketNum.getText();
				Ticket t1 = garage.getEntryGate().findTicketByID(testString);
				Sale s1 = garage.getExitGate().findSaleByTicketId(t1);
				try {
					payAmt = Double.parseDouble(paymentAmount.getText());
				} 
				catch(NumberFormatException e1) {
					exitInformation.setText("Invalid payment amount");
					paymentAmount.setText("");
				}
					
				
				if (garage.getExitGate().makePayment(s1, payAmt, FOP)) {
					totalText.setText("");
					paymentAmount.setText("");
					rdbtnCash.setSelected(false);
					rdbtnCreditCard.setSelected(false);
					payAmt = 0.0;
					FOP = null;
					String s = String.format("$ %.2f", s1.getChange());
					changeAmount.setText(s);
				} else {
					paymentAmount.setText("Payment Failed");
				}
				
				exitGatePane.setText(garage.getExitGate().getStatus().toString());
				if (!t1.isValid()) {
					btnExitGarage.setEnabled(true);
				}
				
				
			}
		});
		
		rdbtnCreditCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FOP = FormOfPayment.CreditCard;
				rdbtnCash.setSelected(false);
			}
		});
		
		exitInformation = new JTextField();
		
		
		exitInformation.setFont(new Font("Tahoma", Font.BOLD, 11));
		exitInformation.setBackground(Color.LIGHT_GRAY);
		exitInformation.setEditable(false);
		GridBagConstraints gbc_exitInformation = new GridBagConstraints();
		gbc_exitInformation.insets = new Insets(0, 0, 5, 5);
		gbc_exitInformation.fill = GridBagConstraints.HORIZONTAL;
		gbc_exitInformation.gridx = 2;
		gbc_exitInformation.gridy = 10;
		contentPane.add(exitInformation, gbc_exitInformation);
		exitInformation.setColumns(10);
		
		GridBagConstraints gbc_rdbtnCreditCard = new GridBagConstraints();
		gbc_rdbtnCreditCard.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnCreditCard.gridx = 0;
		gbc_rdbtnCreditCard.gridy = 11;
		contentPane.add(rdbtnCreditCard, gbc_rdbtnCreditCard);
		
		GridBagConstraints gbc_btnMakePayment = new GridBagConstraints();
		gbc_btnMakePayment.insets = new Insets(0, 0, 5, 5);
		gbc_btnMakePayment.gridx = 1;
		gbc_btnMakePayment.gridy = 11;
		contentPane.add(btnMakePayment, gbc_btnMakePayment);
		
		btnExitGarage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String testString = exitTicketNum.getText();
				Ticket t1 = garage.getEntryGate().findTicketByID(testString);
				
				if (t1 == null) {
					exitInformation.setText("Invalid Ticket #");
					btnExitGarage.setEnabled(false);
				} else if (t1.isValid()) {
					exitInformation.setText("Pay before exiting please");
					btnExitGarage.setEnabled(false);
				} else {
					Sale s1 = garage.getExitGate().findSaleByTicketId(t1);
								
					totalText.setText("");
					exitTicketNum.setText("");
					exitInformation.setText("Goodbye");
					btnMakePayment.setEnabled(false);
					garage.getExitGate().exitGarage(s1);	
					btnExitGarage.setEnabled(false);
					
				
				}		
				if (garage.isGarageAcceptingVehicles()) {
					vacancyPane.setText("Yes");
				} else {
					vacancyPane.setText("No");
				}	
				exitGatePane.setText(garage.getExitGate().getStatus().toString());
			}
		});
		
		GridBagConstraints gbc_btnExitGarage = new GridBagConstraints();
		gbc_btnExitGarage.fill = GridBagConstraints.BOTH;
		gbc_btnExitGarage.gridheight = 3;
		gbc_btnExitGarage.insets = new Insets(0, 0, 5, 5);
		gbc_btnExitGarage.gridx = 2;
		gbc_btnExitGarage.gridy = 11;
		contentPane.add(btnExitGarage, gbc_btnExitGarage);
		
		JLabel lblChange = new JLabel("Change:");
		lblChange.setEnabled(false);
		GridBagConstraints gbc_lblChange = new GridBagConstraints();
		gbc_lblChange.insets = new Insets(0, 0, 5, 5);
		gbc_lblChange.gridx = 1;
		gbc_lblChange.gridy = 12;
		contentPane.add(lblChange, gbc_lblChange);
		
		changeAmount = new JTextField();
		changeAmount.setBackground(Color.LIGHT_GRAY);
		changeAmount.setEditable(false);
		GridBagConstraints gbc_changeAmount = new GridBagConstraints();
		gbc_changeAmount.insets = new Insets(0, 0, 5, 5);
		gbc_changeAmount.fill = GridBagConstraints.HORIZONTAL;
		gbc_changeAmount.gridx = 1;
		gbc_changeAmount.gridy = 13;
		contentPane.add(changeAmount, gbc_changeAmount);
		changeAmount.setColumns(10);
		
		JLabel lblExitGate = new JLabel("Exit Gate:");
		GridBagConstraints gbc_lblExitGate = new GridBagConstraints();
		gbc_lblExitGate.gridheight = 2;
		gbc_lblExitGate.insets = new Insets(0, 0, 0, 5);
		gbc_lblExitGate.gridx = 0;
		gbc_lblExitGate.gridy = 16;
		contentPane.add(lblExitGate, gbc_lblExitGate);
		
		
	}

}

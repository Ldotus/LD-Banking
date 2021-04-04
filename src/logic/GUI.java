package logic;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame implements Runnable {

	private static final long serialVersionUID = 2898559780053622204L;
	private int HEIGHT = 750;
	private int WIDTH = 77;
	private static JFrame jf;
	private JPanel jp;
	private JTextField jtb;
	private Thread t;

	GUI() {

		setFrame();

	}

	private void setCreateAccountFrame() {
		// Clear panel of all elements

		jp.removeAll();
		jp.repaint();
		// set new attributes of panel

		jf.setBounds(500, 100, 700, 700);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel fNameLbl = new JLabel("First Name: ");
		JLabel lNameLbl = new JLabel("Last Name: ");
		JLabel ageLbl = new JLabel("Age: ");
		JLabel emailLbl = new JLabel("Email Address: ");
		JButton backBtn = new JButton("Back");

		jp.add(fNameLbl);
		jp.add(lNameLbl);
		jp.add(ageLbl);
		jp.add(emailLbl);
		jp.add(backBtn);
		jf.add(jp);

		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (jf.isShowing()) {
					jp.removeAll();
					jp.repaint();
					setFrame();
				}
			}
		});

	}

	private void setFrame() {
		// create frame and panel containers
		// populated containers with elements
		jf = new JFrame();
		jp = new JPanel();
		FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
		jf.setLayout((fl));
		jf.setBounds(500, 500, HEIGHT, WIDTH);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setTitle("lDot ATM");
		jf.setBackground(Color.orange);
		jp.setBackground(Color.orange);
		JButton withdrawBtn = new JButton("Withdraw");
		JButton depositBtn = new JButton("Deposit");
		JButton printBalBtn = new JButton("Check Balance");
		JButton createAccountBtn = new JButton("Create Account");
		jtb = new JTextField("0", 13);

		jp.add(jtb);
		jf.add(jp);
		jp.add(new JLabel("Enter Amount"));

		// Action listeners for Textbox
		jtb.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				// when a
				String input = jtb.getText();
				int characterCount = input.length();
				if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
					if (characterCount >= 5) {
						jtb.setEditable(true);
						jtb.setText("");
					}

				} else {
					jtb.setEditable(false);
					jtb.setText("Enter only Numberics");
				}
			}
		});
		jtb.setVisible(true);

		withdrawBtn.setBounds(75, 400, 100, 50);
		depositBtn.setBounds(225, 400, 100, 50);
		printBalBtn.setBounds(375, 400, 100, 50);
		createAccountBtn.setBounds(525, 400, 100, 50);
		jp.add(withdrawBtn);
		jp.add(depositBtn);
		jp.add(printBalBtn);
		jp.add(createAccountBtn);

		jf.add(jp);
		jf.setVisible(true);

		Bank ba = new Bank();

		withdrawBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {
					String value = jtb.getText();
					int amount = Integer.parseInt(value);
					ba.withdraw(amount);

				} catch (NumberFormatException e) {
					e.printStackTrace();
				}

			}

		});
		depositBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String value = jtb.getText();
					int amount = Integer.parseInt(value);
					ba.deposit(amount);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}

			}

		});
		printBalBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				ba.printReceipt();

			}

		});
		createAccountBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (jf.isShowing()) {

					setCreateAccountFrame();
				}

			}

		});

	}

	public void paint(Graphics g) {

	}

	@Override
	public void run() {

		System.out.print("");
	}

	public void init() {
		t = new Thread(this);
		t.start();
	}

	public static JFrame getFrame() {
		return jf;
	}
}
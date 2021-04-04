package logic;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// main class for a bank Account 
/**
 * @author Liam Brooks
 *
 */
public class Bank extends InterestAdder implements Serializable {

	private static final long serialVersionUID = 3000547061234035445L;

	// constructor of Class
	Bank() {

	}

	// private fields cannot be directly accessed outside of the class
	private List<Transaction> transactions = new ArrayList<>();
	private static String name;
	private static double balance;
	private static int accNum;

	LocalDateTime ldt = LocalDateTime.now();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

	String formattedDate = ldt.format(dtf);

	// paramatised method error checking for invalid entries e.g depositing less
	// than 0
	public void deposit(int amountAdded) {
		int n = 0;
		if (amountAdded <= 0) {
			System.out.println("Can't deposit nothing, come on man.");
			transactions.add(new Transaction("Deposit", "Unaccepted"));

		} else {
			Bank.balance += amountAdded + applyInterest(amountAdded);
			System.out.println("You've Deposited £" + amountAdded);
			System.out.println("Interest Added: " + applyInterest(amountAdded));

			System.out.println("Your new balance is £" + Bank.balance);
			transactions.add(new Transaction("Deposit", balance, amountAdded, n));

		}
	}

	// paramatised method that invokes the run method which is attached to a thread
	public int withdraw(int amountRemoved) {
		int n = 1;
		if (amountRemoved > balance || amountRemoved < 1) {
			System.out.println("Insufficient Funds");
			transactions.add(new Transaction("Withdraw", "Insufficient Funds"));
		} else {
			Bank.balance = Bank.balance - amountRemoved;
			System.out.println("Withdrawing £" + amountRemoved + " From Account.");
			run();
			System.out.println("Your new balance is £" + balance);
			transactions.add(new Transaction("Withdraw", balance, amountRemoved, n));

		}
		return amountRemoved;

	}

	public void printReceipt() {

		// class //variable //class function

		System.out.println("___________________");
		System.out.println("Receipt");
		System.out.println(formattedDate);
		System.out.println("Current balance: £" + balance);
		System.out.println("___________________");
		for (Transaction trans : transactions) {
			System.out.println(trans);
			System.out.println(
					"_______________________________________________________________________________________________");
		}

	}

	@Override
	public String toString() {
		return "Bank [name=" + name + ", balance=" + balance + ", accNum=" + accNum + "]";
	}

	// t thread state is changed by running this method,
	public void run() {
		System.out.println("Your money will be with you shortly...");
		try {
			Thread.sleep(1000);
			System.out.println("Process Successful");
			System.out.println("Please Take Your Money");
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	// public int method returns an int

	// returns balance
	public double getBalance() {
		return balance;
	}

	public static void setBalance(int balance) {
		Bank.balance = balance;
	}

	public void addTransaction(Transaction t) {
	

	}

}
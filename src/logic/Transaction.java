package logic;

public class Transaction extends Bank {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4558055125609179937L;
	private String transactionType;
	private double balance;
	private int amount;
	private int amountDeposited;
	private int amountWithdrawn;

	private int n;

	String fmtdDate;

	public Transaction(String transactionType, String successOrNot) {

	}

	public Transaction(String transactionType, double balance, int amount, int n) {
		super();
		this.transactionType = transactionType;
		this.balance = balance;
		this.amount = amount;
		this.n = n;
		this.fmtdDate = ldt.format(dtf);

	}

	@Override
	public String toString() {
		if (n == 0) {
			return "Transaction [transaction Type: " + transactionType + ", balance: £" + balance + ", Deposited: £"
					+ amount + ", " + fmtdDate + "]";
		} else {
			return "Transaction [transaction Type: " + transactionType + ", balance: £" + balance + ", Withdrawn: £"
					+ amount + ", " + fmtdDate + "]";
		}

	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {

		this.transactionType = transactionType;
	}

	public int getAmountAdded() {
		return amountDeposited;
	}

	public void setAmountAdded(int amountAdded) {
		this.amountDeposited = amountAdded;
	}

	public int getAmountWithdrawn() {
		return amountWithdrawn;
	}

	public void setAmountWithdrawn(int amountWithdrawn) {
		this.amountWithdrawn = amountWithdrawn;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

}

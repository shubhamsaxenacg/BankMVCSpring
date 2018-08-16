//this account extends the BankAccount .
//It has the specific instances Specific to the Saving account and their setters and getters.

package com.cg.pojo;

public  class SavingsAccount extends BankAccount {
	private boolean salary;
	private String odLimit="NA";
	double uBalance=super.getAccountBalance();
	//Constructor For Non-Zero balance. 

	//Constructor for Zero balance Account.

	public SavingsAccount(Customer accountHolder, boolean salary,String accountType ) {
		super(accountHolder, accountType);
		this.salary = salary;
	}
	public SavingsAccount(Customer accountHolder, double accountBalance, String accountType,boolean salary) {
		super(accountHolder, accountBalance, accountType);
		this.salary = salary;
	}

	@Override
	public String withdraw(double amountToBeWithDrawn) {
		String flag="";
		if(getAccountBalance()>=amountToBeWithDrawn)
		{	System.out.println(getAccountBalance()+"	"+amountToBeWithDrawn);
			setAccountBalance(((getAccountBalance()-amountToBeWithDrawn)));
		flag="yes";
		}else {
			flag="no";
		}
		return flag;
	}
	public boolean isSalary() {
		return salary;
	}
	public void setSalary(boolean salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "SavingsAccount [salary=" + salary + ", toString()=" + super.toString() + "]";
	}
	public String getOdLimit() {
		return odLimit;
	}
	public void setOdLimit(String odLimit) {
		this.odLimit = odLimit;
	}
}

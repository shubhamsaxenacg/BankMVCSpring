//This class extends the BankAccount .
//it has specific instances related to CurrentAccount and their setters and getters.

package com.cg.pojo;

public  class CurrentAccount extends BankAccount {
	private double odLimit;
	private String salary="NA"; 

	public double getOdLimit() {
		return odLimit;
	}

	public CurrentAccount(Customer accountHolder, double accountBalance, String accountType, double odLimit) {
		super(accountHolder, accountBalance, accountType);
			this.odLimit=odLimit;
	}


	public void setOdLimit(double odLimit) {
		this.odLimit = odLimit;
	}
	@Override
	public String withdraw(double amountToBeWithDrawn) {
		String flag="";
		if(odLimit+getAccountBalance()>=amountToBeWithDrawn)
		{System.out.println(getAccountBalance()+"	"+amountToBeWithDrawn);
			setAccountBalance(((getAccountBalance()-amountToBeWithDrawn)));
		flag="yes";
		}
		else {
			flag="no";
		}
		return flag;
	}

	@Override
	public String toString() {
		return "CurrentAccount [odLimit=" + odLimit + ", toString()=" + super.toString() + "]";
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}	
}

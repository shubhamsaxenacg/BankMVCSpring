package com.cg.service;

import java.util.Collection;

import com.cg.dao.BankAccountDAO;
import com.cg.dao.BankAccountDAOI;
import com.cg.pojo.BankAccount;
import com.cg.pojo.SavingsAccount;

public class BankAccountService {
	BankAccountDAOI accountDAO = new BankAccountDAO();
	BankAccount customer = null;
	private BankAccount Bsender;
	private BankAccount Breceiver;
	
	public void AddNewAccount(BankAccount account) {
		accountDAO.AddNewAccount(account);
	}

	public BankAccount searchAccount(int accountNO) {
		for (BankAccount bankAccount : viewAccount()) {
			if (bankAccount.getAccountNumber() == accountNO) {
				customer = bankAccount;
				break;
			}
		}
		return customer;
	}

	public int getAccountNo() {
		System.out.println(BankAccount.getNextAccountNumber());
		return BankAccount.getNextAccountNumber();
	}

	public Collection<BankAccount> viewAccount() {

		return accountDAO.viewAccount().values();
	}

	public Collection<BankAccount> viewCustomer() {

		return accountDAO.viewCustomer().values();
	}

	public BankAccount deposit(double amount, int accNo) {
		customer = searchAccount(accNo);
		if (customer == null) {
			return customer;
		} else {
			customer.deposit(amount);
			return customer;
		}
	}

	public BankAccount withdrawl(double amount, int accNo) {
		customer = searchAccount(accNo);
		System.out.println();
		if (customer != null&&customer.withdraw(amount).equals("yes")) {
			return customer;
		} else {
			return null;
		}
	}
	public boolean Fundtransfer(int sender,int reciever,double amount,String remarks) {
		boolean stat=false;
		Bsender=searchAccount(sender);
		Breceiver=searchAccount(reciever);
		if(Bsender!=null&&Breceiver!=null&&Bsender.withdraw(amount).equals("yes")) {	
			stat=true;
			Breceiver.deposit(amount);
		}
		else { 
			stat=false;
		}
		return stat;	
	}

}

package com.cg.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.pojo.BankAccount;
import com.cg.pojo.SavingsAccount;

/**
 * @author Shubham Saxena
 *
 */
public class BankAccountDAO implements BankAccountDAOI  {
	static Map<Integer, BankAccount> bankAcc = new HashMap<Integer, BankAccount>();

	/* (non-Javadoc)
	 * @see com.cg.dao.BankAccountDAOI#AddNewAccount(com.cg.pojo.BankAccount)
	 */
	@Override
	public void AddNewAccount(BankAccount account) {
		bankAcc.put(account.getAccountNumber(), account);
	}
	
	/**
	 * @param account
	 */
	public void AddNewCurrentAccount(SavingsAccount account) {
		bankAcc.put(account.getAccountNumber(), account);
	}
	
	/**
	 * @param account
	 */
	public void AddNewSavingAccount(SavingsAccount account) {
		bankAcc.put(account.getAccountNumber(), account);
	}


	/* (non-Javadoc)
	 * @see com.cg.dao.BankAccountDAOI#searchAccount()
	 */
	@Override
	public  Map<Integer, BankAccount> searchAccount() {
		return bankAcc;
	}


	/* (non-Javadoc)
	 * @see com.cg.dao.BankAccountDAOI#viewAccount()
	 */
	@Override
	public  Map<Integer, BankAccount> viewAccount() {
		return bankAcc;
	}


	/* (non-Javadoc)
	 * @see com.cg.dao.BankAccountDAOI#viewCustomer()
	 */
	@Override
	public Map<Integer, BankAccount> viewCustomer() {
		return bankAcc;
	}
}

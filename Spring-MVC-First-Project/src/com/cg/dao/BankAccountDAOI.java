package com.cg.dao;

import java.util.Map;

import com.cg.pojo.BankAccount;

public interface BankAccountDAOI {

	/**
	 * Add new Account in Map
	 * @param account
	 */
	void AddNewAccount(BankAccount account);

	/**
	 * @return Account Map
	 */
	Map<Integer, BankAccount> searchAccount();

	/**
	 * @return Account Map
	 */
	Map<Integer, BankAccount> viewAccount();

	/**
	 * @return Account Map
	 */
	Map<Integer, BankAccount> viewCustomer();

}
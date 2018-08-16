package com.cg.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.pojo.CurrentAccount;
import com.cg.pojo.Customer;
import com.cg.pojo.SavingsAccount;
import com.cg.service.BankAccountService;

@Controller

public class BankController {

@RequestMapping("/")
public String hello()
	{
		System.out.println("Home");
		return "home";
	}

@RequestMapping("/add")
public String add()
	{
		System.out.println("Add page");
		return "add";
	}

BankAccountService accountService = new BankAccountService();

@RequestMapping("/addAccount")
public String addAccount(@RequestParam("c_Name") String customerName,  @RequestParam("c_dob") String c_dob,
		@RequestParam("c_Email") String emailId, @RequestParam("c_contact") long contactNumber
		,@RequestParam("c_Address") String permanentAddress, @RequestParam("gender") String gender
		,@RequestParam("nationality") String nationality, @RequestParam("c_AccType") String c_AccType,
		@RequestParam("c_salary") String c_salary, @RequestParam("c_amount") String c_amount,
		@RequestParam("c_ODLimit") String c_ODLimit, Model model)
	{
		System.out.println("Account Added");
		DateTimeFormatter JAVAFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dateOfBirth = LocalDate.parse(c_dob, JAVAFormat);
		Customer customer = new Customer(customerName, emailId, contactNumber, dateOfBirth, permanentAddress,
				gender, nationality);
		
		if (c_AccType.equals("sav")) {
			if (c_salary.equals("salary")) {
				SavingsAccount savingsAccount = new SavingsAccount(customer, true, "Savings");
				accountService.AddNewAccount(savingsAccount);
				System.out.println(accountService.getAccountNo());
				model.addAttribute("accNO", accountService.getAccountNo()-1);
				return "createSuccess";
			} else {
				double accountBalance = Double.parseDouble(c_amount);
				SavingsAccount savingsAccount = new SavingsAccount(customer, accountBalance, "Savings", false);
				accountService.AddNewAccount(savingsAccount);
				model.addAttribute("accNO", accountService.getAccountNo()-1);
				return "createSuccess";
			}
		} else {
			double accountBalance = Double.parseDouble(c_amount);
			double odLimit = Double.parseDouble(c_ODLimit);
			CurrentAccount currentAccount = new CurrentAccount(customer, accountBalance, "Current", odLimit);
			accountService.AddNewAccount(currentAccount);
			model.addAttribute("accNO", accountService.getAccountNo()-1);
			return "createSuccess";
		}
		
		
	}

@RequestMapping("/viewAcc")
public String viewAcc(Model model)
	{
		System.out.println("View Account");
		model.addAttribute("viewaccount",accountService.viewAccount());
		return "viewaccount";
	}
}

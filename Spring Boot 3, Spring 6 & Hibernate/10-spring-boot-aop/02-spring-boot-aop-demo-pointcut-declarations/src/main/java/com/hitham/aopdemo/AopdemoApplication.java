package com.hitham.aopdemo;

import com.hitham.aopdemo.dao.AccountDAO;
import com.hitham.aopdemo.dao.MembershipDAO;
import com.hitham.aopdemo.service.TrafficFortune;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountdao,
											   MembershipDAO membershipDAO,
											   TrafficFortune trafficFortune){
		return runner ->{
//			demoTheBeforeAdvice(accountdao, membershipDAO);
//			demoTheAfterReturning(accountdao);
//			demoTheAfterThrowing(accountdao);
//			demoTheAfterAdvice(accountdao);
//			demoTheAroundAdvice(trafficFortune);
//			demoTheAroundAdviceHandleEx(trafficFortune);
			demoTheAroundAdviceRethrowEx(trafficFortune);
		};
	}

	private void demoTheAroundAdviceRethrowEx(TrafficFortune trafficFortune) {
		System.out.println("\nMain Program: demoAroundAdviceRethrowException");

		System.out.println("Calling getFortune()");

		boolean tripWire = true;
		String data = trafficFortune.getFortune(tripWire);

		System.out.println("fortune is: " + data);
		System.out.println("Finished");
	}

	private void demoTheAroundAdviceHandleEx(TrafficFortune trafficFortune) {
		System.out.println("\nMain Program: demoAroundAdviceHandleException");

		System.out.println("Calling getFortune()");

		boolean tripWire = true;
		String data = trafficFortune.getFortune(tripWire);

		System.out.println("fortune is: " + data);
		System.out.println("Finished");
	}

	private void demoTheAroundAdvice(TrafficFortune trafficFortune) {
		System.out.println("\nMain Program: demoAroundAdvice");

		System.out.println("Calling getFortune()");
		String data = trafficFortune.getFortune();

		System.out.println("fortune is: " + data);
		System.out.println("Finished");
	}

	private void demoTheAfterAdvice(AccountDAO accountdao) {
		List<Account> accs = null;
		try {
			boolean flag = false;
			accs = accountdao.findAccounts(flag);
		}
		catch (Exception ex) {
			System.out.println("\nMain Program: caught exception" + ex);
		}
		System.out.println("\nMain Program: demoTheAfterThrowing");
		System.out.println("---");
		System.out.println(accs);
		System.out.println("\n");
	}

	private void demoTheAfterThrowing(AccountDAO accountdao) {
		List<Account> accs = null;
		try {
			boolean flag = true;
			accs = accountdao.findAccounts(true);
		}
		catch (Exception ex) {
			System.out.println("\nMain Program: caught exception" + ex);
		}
		System.out.println("\nMain Program: demoTheAfterThrowing");
		System.out.println("---");
		System.out.println(accs);
		System.out.println("\n");
	}

	private void demoTheAfterReturning(AccountDAO accountdao) {
		List<Account> accs = accountdao.findAccounts();

		System.out.println("\nMain Program: demoTheAfterReturning");
		System.out.println("---");
		System.out.println(accs);
		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(AccountDAO accountdao, MembershipDAO membershipDAO) {
		Account acc = new Account();
		acc.setName("Hitham");
		acc.setLevel("Expert");
		accountdao.addAccount(acc, true);
		accountdao.doWork();

		System.out.println("\n");

		accountdao.setName("Test");
		accountdao.setCode("CS22");

		String s = accountdao.getName();
		String c = accountdao.getCode();

		System.out.println("\n");

		membershipDAO.addMember();
		membershipDAO.goSleep();
	}

}

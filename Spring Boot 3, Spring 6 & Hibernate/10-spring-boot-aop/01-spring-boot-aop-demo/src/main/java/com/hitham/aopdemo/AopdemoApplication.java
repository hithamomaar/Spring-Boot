package com.hitham.aopdemo;

import com.hitham.aopdemo.dao.AccountDAO;
import com.hitham.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountdao, MembershipDAO membershipDAO){
		return runner ->{
			demoTheBeforeAdvice(accountdao, membershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO accountdao, MembershipDAO membershipDAO){
		Account acc = new Account();
		accountdao.addAccount(acc, true);

		accountdao.doWork();

		System.out.println("\n");

		membershipDAO.addMember();
		membershipDAO.goSleep();
	}

}

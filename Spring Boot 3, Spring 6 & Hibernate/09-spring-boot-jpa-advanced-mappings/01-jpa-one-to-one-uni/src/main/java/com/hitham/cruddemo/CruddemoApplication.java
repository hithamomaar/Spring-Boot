package com.hitham.cruddemo;

import com.hitham.cruddemo.dao.AppDAO;
import com.hitham.cruddemo.entity.Instructor;
import com.hitham.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
//			createInstructor(appDAO);
//			findInstructor(appDAO);
			deleteInstructor(appDAO);
		};
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 2;
		System.out.println("Deleting instructor with id: " + id);
		appDAO.deleteById(id);
		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO) {
		int id = 2;
		System.out.println("Finding instructor with id: " + id);

		Instructor instructor = appDAO.findById(id);

		System.out.println("instructor: " + instructor);
		System.out.println("Instructor's detail: " + instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {

		Instructor instructor =
				new Instructor("Hitham", "Omar", "hitham.a1000@gmail.com");

		InstructorDetail instructorDetail =
				new InstructorDetail("http://www.youtube.com/test", "Coding");

//		Instructor instructor =
//				new Instructor("Mohamed", "Saady", "saady.a1000@gmail.com");
//		InstructorDetail instructorDetail =
//				new InstructorDetail("http://www.youtube.com/test", "Singing");

		instructor.setInstructorDetail(instructorDetail);
		System.out.println("Saving instructor: " + instructor);

		appDAO.save(instructor);
		System.out.println("Done!");
	}
}

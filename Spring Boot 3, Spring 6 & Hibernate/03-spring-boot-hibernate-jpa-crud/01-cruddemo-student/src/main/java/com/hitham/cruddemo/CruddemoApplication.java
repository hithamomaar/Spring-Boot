package com.hitham.cruddemo;

import com.hitham.cruddemo.dao.StudentDAO;
import com.hitham.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
//			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryStudents(studentDAO);
//			queryStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAllStudents(studentDAO);

		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		int rowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted students: " + rowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int theId = 4;
		System.out.println("Deleting student with id: " + theId);
		studentDAO.delete(theId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on id: primary key
		int theId = 4;
		System.out.println("Getting student with id: " + theId);
		Student student = studentDAO.findById(theId);

		//change first name
		System.out.println("Updating student...");
		student.setFirstName("Hitham");

		//update student
		studentDAO.update(student);

		//display updated student
		System.out.println("Updated student: " + student);
	}

	private void queryStudentsByLastName(StudentDAO studentDAO) {
		//get students by last name
		List<Student> students = studentDAO.findByLastName("Omar");

		//display students
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void queryStudents(StudentDAO studentDAO) {
		//get all students
		List<Student> students = studentDAO.findAll();

		//display students
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student
		System.out.println("Creating a new student...");
		Student student = new Student("Hitham", "Omar", "hitham.a1000@gmail.com");

		//save student
		System.out.println("Saving the student...");
		studentDAO.save(student);

		//display id of student
		int theId = student.getId();
		System.out.println("Saved student. Generated id: " + theId);

		//retrieve student based on id: primary key
		System.out.println("Getting student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		//display student
		System.out.println("Found student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		//create students
		System.out.println("Creating 3 students objects...");
		Student student1 = new Student("Ahmed", "Yahia", "yahia.a1000@gmail.com");
		Student student2 = new Student("Mohamed", "Saady", "saady.a1000@gmail.com");
		Student student3 = new Student("Sharaf", "Ahmed", "sharaf.a1000@gmail.com");

		//save the students
		System.out.println("Saving the students...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {
		//create a student
		System.out.println("Creating a new student...");
		Student student = new Student("Hitham", "Omar", "hitham.a1000@gmail.com");

		//save the student
		System.out.println("Saving the student...");
		studentDAO.save(student);

		//display id of the student
		System.out.println("Saved student. Generated id: " + student.getId());
	}


}

package com.hitham.cruddemo;

import com.hitham.cruddemo.dao.AppDAO;
import com.hitham.cruddemo.entity.Course;
import com.hitham.cruddemo.entity.Instructor;
import com.hitham.cruddemo.entity.InstructorDetail;
import com.hitham.cruddemo.entity.Review;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
//			createCourseAndReviews(appDAO);
//			retrieveCourseAndReviews(appDAO);
			deleteCourseAndReviews(appDAO);
		};
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int id = 10;
		System.out.println("Deleting course id: " + id);

		appDAO.deleteCourseById(id);
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		int id = 10;
		Course course = appDAO.findCourseAndReviewByCourseId(id);

		System.out.println(course);

		System.out.println(course.getReviews());

		System.out.println("DONE!");
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		Course course = new Course("JAVASCRIPT");

		course.addReview(new Review("Nice Course, Worst Lang"));
		course.addReview(new Review("Dumb course"));

		System.out.println("SAVING course");
		System.out.println(course);
		System.out.println(course.getReviews());

		appDAO.save(course);

		System.out.println("DONE!");
	}

	private void deleteCourse(AppDAO appDAO) {
		int id = 10;
		System.out.println("Deleting Course id: " + id);

		appDAO.deleteCourseById(id);
		System.out.println("DONE!");
	}

	private void updateCourse(AppDAO appDAO) {
		int id = 10;
		System.out.println("Finding instructor id: " + id);
		Course course =appDAO.findCourseById(id);

		System.out.println("Updating Course id: " + id);
		course.setTitle("C++");

		appDAO.updateCourse(course);

		System.out.println("DONE!");

	}

	private void updateInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor id: " + id);
		Instructor instructor = appDAO.findById(id);

		System.out.println("Updating instructor id: " + id);
		instructor.setEmail("hitham.a1000@gmail.com");
		appDAO.updateInstructor(instructor);

		System.out.println("Done!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor id: " + id);

		Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);

		System.out.println("Instructor: " + instructor);
		System.out.println("Courses: " + instructor.getCourses());
//		System.out.println("Instructor's detail: " + instructor.getInstructorDetail());

		System.out.println("Done!");
	}

	private void findCoursesByInstructorId(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor id: " + id);

		Instructor instructor = appDAO.findById(id);

		System.out.println("Instructor: " + instructor);

		System.out.println("Finding courses for instructor id: " + id);
		List<Course> courses = appDAO.findCoursesByInstructorId(id);

		instructor.setCourses(courses);

		System.out.println("Courses: " + instructor.getCourses());

		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor id: " + id);

		Instructor instructor = appDAO.findById(id);

		System.out.println("Instructor: " + instructor);
		System.out.println("Courses: " + instructor.getCourses());

		System.out.println("Done!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor instructor =
				new Instructor("Ahmed", "Yahia", "yahia.a1000@gmail.com");

		InstructorDetail instructorDetail =
				new InstructorDetail("http://www.youtube.com/test", "Coding");

		instructor.setInstructorDetail(instructorDetail);

		Course course1 = new Course("Java");
		Course course2 = new Course("Python");

		instructor.add(course1);
		instructor.add(course2);

		System.out.println("Saving instructor: " + instructor);
		System.out.println("Courses: " + instructor.getCourses());

		appDAO.save(instructor);
		System.out.println("Done!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int id = 3;
		System.out.println("Deleting instructor detail with id: " + id);
		appDAO.deleteInstructorDetailById(id);
		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor detail with id: " + id);
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);

		System.out.println("Instructor detail: " + instructorDetail);
		System.out.println("associated instructor: " + instructorDetail.getInstructor());

		System.out.println("Done!");
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 1;
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

package com.luv2code.crud_demo;

import com.luv2code.crud_demo.dao.StudentDAO;
import com.luv2code.crud_demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);

			// createMultipleStudents(studentDAO);

			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating new student...");
		Student tempStudent = new Student("Alan", "Alexander", "alan@alexander.com");

		// save the student
		System.out.println("Saving the student....");
		studentDAO.save(tempStudent);

		// display id of saved student
		Integer savedId = tempStudent.getId();
		System.out.println("Student saved. id generated: " + savedId);

		// retrieve student based on id: primary key
		Student retrievedStudent = studentDAO.findById(savedId);

		// display student
		System.out.println(retrievedStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// create multiple students
		System.out.println("Creating 3 new student objects...");
		Student tempStudent1 = new Student("Claudia", "Cruce", "claudia@claudia.com");
		Student tempStudent2 = new Student("Liam", "Cruce", "liam@liam.com");
		Student tempStudent3 = new Student("Lincoln", "Cruce", "lincoln@lincoln.com");

		// save the student objects
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		// print out results
		System.out.println("Saved student. Generated id: " + tempStudent1.getId());
		System.out.println("Saved student. Generated id: " + tempStudent2.getId());
		System.out.println("Saved student. Generated id: " + tempStudent3.getId());



	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Alex", "Cruce", "alex@alex.com");

		// save the student object
		System.out.println("Saving the student object....");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}

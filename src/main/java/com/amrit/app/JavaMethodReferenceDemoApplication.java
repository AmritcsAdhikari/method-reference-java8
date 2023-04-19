package com.amrit.app;

import java.util.function.Consumer;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amrit.app.domain.Person;
import com.amrit.app.service.PersonService;

/*
 * 
 * Method Reference - static methods 
 * SYNTAX: (reference(className)::method)
 * 
 */

@SpringBootApplication
public class JavaMethodReferenceDemoApplication {

	public static void main(String[] args) {
		// SpringApplication.run(JavaMethodReferenceDemoApplication.class, args);

		PersonService service = new PersonService();

		//1. Anonymous implementation
		service.loadPersonsFromDb().forEach(new Consumer<Person>() {
			@Override
			public void accept(Person t) {
				System.out.println(t);

			}
		});
		
		//2. lambda Expression
		service.loadPersonsFromDb().forEach((t) -> System.out.println(t));
		
		
		//3. method reference
		service.loadPersonsFromDb().forEach(JavaMethodReferenceDemoApplication::print);
		
		//4. method reference
		service.loadPersonsFromDb().forEach(System.out::println);
				
		
	}
	
	public static void print(Person person) {
		System.out.println(person);
	}

}

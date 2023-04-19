package com.amrit.app;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.amrit.app.domain.Person;
import com.amrit.app.dto.PersonDto;
import com.amrit.app.service.PersonService;

/*
 * 
 * Method Reference - instance method reference
 * SYNTAX: (reference(obj)::method)
 * 
 * Learning approach = 1. write anonymous methods ->2. convert to lambda expression ->3. remove everything before () and return type inside (), add '->' after () -> 4. change to method reference
 */

public class EmployeeMapper {

	public PersonDto convert(Person person) {

		PersonDto personDto = new PersonDto();
		personDto.setId(person.getId());
		personDto.setName(person.getName());
		personDto.setPhone(person.getPhone());
		return personDto;
	}

	public static void main(String[] args) {
		

		PersonService service = new PersonService();
		EmployeeMapper mapper = new EmployeeMapper();

		// 1. Anonymous Function
		List<PersonDto> list = service.loadPersonsFromDb().stream().map(new Function<Person, PersonDto>() {
			@Override
			public PersonDto apply(Person person) {
				PersonDto personDto = new PersonDto();
				personDto.setId(person.getId());
				personDto.setName(person.getName());
				personDto.setPhone(person.getPhone());
				return personDto;
			}

		}).collect(Collectors.toList());
		System.out.println("_" + list);

		// 2. Using Lambda Expression
		List<PersonDto> list2 = service.loadPersonsFromDb().stream().map((person) -> {
			PersonDto personDto = new PersonDto();
			personDto.setId(person.getId());
			personDto.setName(person.getName());
			personDto.setPhone(person.getPhone());
			return personDto;
		}).collect(Collectors.toList());

		System.out.println("_" + list2);
		

		// 3. Using Lambda Expression + Extraceted convert() mtehod

		List<PersonDto> list3 = service.loadPersonsFromDb().stream().map(p->mapper.convert(p)).collect(Collectors.toList());

		System.out.println("_" + list3);

		// 4. Method Reference
		List<PersonDto> list4 = service.loadPersonsFromDb().stream().map(mapper::convert).collect(Collectors.toList());

		System.out.println("_" + list4);
		
		
		/***********************************
		|            important!            |
		*************************************/
		/* But if the method that you are referencing does not take any input value, in that case Java treats it as a static method 
		 * and can be accessed using-> className::method (i.e static method reference)
		*/
		
		// 1. get all the person names using lambda exp
		List<String> nameList = service.loadPersonsFromDb().stream().map(p->p.getName()).collect(Collectors.toList());
		System.out.println("_" + nameList);
		// 2. Using method reference - getName() does not take any argument so can be referenced as a static method reference using className
		List<String> nameList2 = service.loadPersonsFromDb().stream().map(Person::getName).collect(Collectors.toList());

		System.out.println("_" + nameList2);
	}
	
	

}

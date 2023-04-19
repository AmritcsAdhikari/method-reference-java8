package com.amrit.app.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.amrit.app.domain.Person;

public class PersonService {
	
	public List<Person> loadPersonsFromDb(){
		return IntStream.rangeClosed(1,10)
				.mapToObj(i-> new Person(i, "Person-" + i , new Random().nextLong(100000)))
						.collect(Collectors.toList());
	}

}

package exo16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Exo16 {

	public static void main(String[] args) {
		
		PersonReader personReader = new PersonReader();
		
		List<Person> persons = personReader.reader("files/EDF.txt");
		
		persons.forEach(s -> System.out.println("name : " + s.getFirstName() + " " +
												"Surname : " + s.getLastName() + " " +
												"Age : " + s.getAge()));
		
		
		PersonWriter personWriter = new PersonWriter();
		
		List<Person> NewPersons = List.of(
				new Person("Kylian","Mbappé",22),
				new Person("Paummard","José",40)
				);
		
		personWriter.write(NewPersons, "files/EDF.txt");
		

	}

}

package exo16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PersonReader {

	
	Function <String, Person> StringToPerson = line -> {
		String[] sep = line.split(", ");
		Person person = new Person(sep[0],sep[1], Integer.parseInt(sep[2]));
		return person;
	};
	
	public List<Person> reader(String fileName) {
		
		File file = new File(fileName);
		List<Person> persons = new ArrayList<Person>();

		try (Reader reader = new FileReader(file); BufferedReader bufferedReader = new BufferedReader(reader);) {

			
		List<String> lines = bufferedReader.lines()
				.filter(s -> !s.startsWith("#") || s.isEmpty())
				.collect(Collectors.toList());			
		
		lines.forEach(s -> persons.add(StringToPerson.apply(s)));
	
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		

		
		return persons;

	
	}

	@Override
	public String toString() {
		
		
		return "PersonReader []";
	}
	
	
}

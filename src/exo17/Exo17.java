package exo17;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Exo17 {

	public static void main(String[] args) {

		
		List<Person> NewPerson= List.of(
			new Person ("Kylian","Mbappe",22),
			new Person ("José","Paummard",40));
		
		
		
		String file = "files/newfile.bin";
		try(PersonOutputStream personOutputStream=new PersonOutputStream(new FileOutputStream(file))){
			personOutputStream.writeFields(NewPerson);
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
        try (PersonInputStream personInput = new PersonInputStream(new FileInputStream(file))) {
            List<Person> persons;
            persons = personInput.readFields();
            persons.forEach(System.out::println);
        } catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}

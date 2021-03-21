package exo16;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.function.Function;

public class PersonWriter {
	Function <Person, String> stringToPerson= (Person person) -> {
		StringBuilder stringBuilder= new StringBuilder();
		stringBuilder.append(person.getFirstName()+", "+person.getLastName()+", "+person.getAge()+"\n");
		return stringBuilder.toString();
	};
	
	
	public void write (List <Person> people, String filename) {
		File file=new File(filename);
		try(Writer writer =new FileWriter(file,true);BufferedWriter bufferedwriter=new BufferedWriter(writer);)
				{
			for(Person person:people) {
				bufferedwriter.write(stringToPerson.apply(person));
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
}
}
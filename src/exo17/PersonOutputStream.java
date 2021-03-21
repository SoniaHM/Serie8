package exo17;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;

public class PersonOutputStream extends FileOutputStream{
	private FileOutputStream fileOutputStream;
	
	Function <Person, byte[]> personToBinary= (Person person) -> {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream=new DataOutputStream(byteArrayOutputStream)) {
               dataOutputStream.writeUTF(person.getLastName());
               dataOutputStream.writeUTF(person.getFirstName());
               dataOutputStream.writeInt(person.getAge());
               return byteArrayOutputStream.toByteArray();
           } catch (IOException e) {
               e.printStackTrace();
           }

           return new byte[0];
	};
	
	public PersonOutputStream(FileOutputStream file){
		super(FileDescriptor.in);
		this.fileOutputStream = file;
	}
	public void writeFields(List <Person> people) {
		
		try (FileOutputStream os = this.fileOutputStream;
				DataOutputStream bos = new DataOutputStream(os);) {
			bos.writeInt(people.size());

				for (Person p : people) {
					bos.write(personToBinary.apply(p));
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			} 
	}
	

}

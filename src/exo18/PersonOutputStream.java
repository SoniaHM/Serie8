package exo18;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.List;

public class PersonOutputStream extends FileOutputStream{

	private FileOutputStream file;
	
	public PersonOutputStream(FileOutputStream file){
		super(FileDescriptor.in);
		this.file = file;
	}
	
	public  void writePeople(List<Person> people) {

        try (OutputStream outputStream = this.file;
             ObjectOutputStream objectOutputStream= new ObjectOutputStream(outputStream)) {

            objectOutputStream.writeObject(people);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

package exo18;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Collections;
import java.util.List;

public class PersonInputStream extends FileInputStream{
    private FileInputStream fileInputStream;

    public PersonInputStream(FileInputStream fileInputStream) {
        super(FileDescriptor.in);
        this.fileInputStream = fileInputStream;
    }
    public List<Person> readPeople(){

        try (InputStream inputStream =this.fileInputStream;
             ObjectInputStream objectInputStream= new ObjectInputStream(inputStream)) {
            @SuppressWarnings("unchecked")
            List<Person> people = (List<Person>)objectInputStream.readObject();
            return people;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

}

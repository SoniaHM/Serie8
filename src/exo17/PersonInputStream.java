package exo17;


import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonInputStream extends FileInputStream {
    private FileInputStream fileInputStream;

    public PersonInputStream(FileInputStream fileInputStream) {
        super(FileDescriptor.in);
        this.fileInputStream = fileInputStream;
    }



   public List<Person> readFields() {
        try (FileInputStream fileInputStream= this.fileInputStream;
             InputStream inputStream=new ByteArrayInputStream(fileInputStream.readAllBytes());
             DataInputStream dataInputStream= new DataInputStream(inputStream)){

            List<Person> people = new ArrayList<>();
            final int  size= dataInputStream.readInt();
            for (int i = 0;i<size;i++) {
                people.add(new Person(dataInputStream.readUTF(),dataInputStream.readUTF(),dataInputStream.readInt()));
            }
            return people;
       } catch (IOException e) {
           e.printStackTrace();
       }

        return Collections.emptyList();
   }

}

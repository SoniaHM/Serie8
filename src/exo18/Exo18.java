package exo18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


public class Exo18 {
	public static void main(String[] args) {
		
		System.out.println("\n Question 1: \n");
		System.out.println("On utilise ObjectOutputStream qui nous permet d'écrire des objects directement dans un .bin \n");
		
		System.out.println("\n Question 2: \n");
		System.out.println("Nous devons ajouter une implementation de l'interface Serializable du java.io\n");
		
		List<Person> newPerson= List.of(
				new Person ("Kylian","Mbappe",22),
				new Person ("José","Paummard",40));
		
        String fileName = "files/newfile2.bin";

        System.out.println("\n Question 3: \n");
        System.out.println("Check the file 'newfile2.bin' \n");
        try (PersonOutputStream personOutputStream = new PersonOutputStream(new FileOutputStream(fileName))) {
            personOutputStream.writePeople(newPerson);
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("\n Question 4: \n");
        try (PersonInputStream personInputStream = new PersonInputStream(new FileInputStream(fileName))) {
            List<Person> people = personInputStream.readPeople();
            people.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}

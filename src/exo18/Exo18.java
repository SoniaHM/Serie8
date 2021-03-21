package exo18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Exo18 {
	public static void main(String[] args) {
		
		System.out.println("\n Question 1: \n");
		System.out.println("On utilise ObjectOutputStream qui nous permet d'écrire des objects directement dans un .bin \n");
		
		System.out.println("\n Question 2: \n");
		System.out.println("Nous devons ajouter une implementation de l'interface Serializable du java.io\n");
		
		List<Person> perso= new ArrayList<>();
		Person p1 = new Person ("Zineddine","Ziden",25);
		Person p2 = new Person ("Ronaldo","Jr",30);
		Person p3 = new Person ("Beckham","David",35);
		Person p4 = new Person ("Figo","Luis",40);
		Person p5 = new Person ("Casillas","Iker",45);
		Person tab[]= {p1,p2,p3,p4,p5};
		for(int i=0;i<tab.length;i++) {
			perso.add(tab[i]);
		}
        String fileName = "files/newfile2.bin";

        System.out.println("\n Question 3: \n");
        System.out.println("Check the file 'newfile2.bin' \n");
        try (PersonOutputStream personOutputStream = new PersonOutputStream(new FileOutputStream(fileName))) {
            personOutputStream.writePeople(perso);
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

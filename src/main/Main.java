package main;

import definition.MyProgram;
import definition.Person;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

//menu-driven program for a contact lists application.
public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        MyProgram myProgram = new MyProgram();
        while (true) {
            System.out.print("Welcome to Ashita's Contact List App: \n" +
                    " Press 1 to add a new contact \n" +
                    " Press 2 to view all contacts \n" +
                    " Press 3 to search for a contact \n" +
                    " Press 4 to delete a contact \n" +
                    " Press 5 to exit program");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    Person result = fetchDetails();
                    myProgram.add(result);
                    break;
                }
                case 2: {
                    myProgram.view();
                    break;
                }
                case 3: {
                    System.out.println("You could search for a contact from their first names: ");
                    String name = scanner.nextLine();
                    myProgram.search(name);
                    break;
                }
                case 4: {
                    System.out.println("Here are all your contacts:");
                    myProgram.displayList();
                    System.out.println("Press the number against the contact to delete it: ");
                    int num = scanner.nextInt();
                    myProgram.delete(num);
                    break;
                }
                case 5: {
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Wrong Choice!");
                    break;
                }
            }
        }
    }

    //fetchDetails method to fetch the details at the time of insertion of the contact.
    private static Person fetchDetails() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("You have chosen to add a new contact");
        System.out.println("Please enter the name of the Person");
        Person person = new Person();
        System.out.print("First Name: ");
        person.setFName(scanner.nextLine());
        System.out.print("Last Name: ");
        person.setLName(scanner.nextLine());
        ArrayList<BigInteger> contactNumber = new ArrayList<>();
        System.out.println("Would you like to add your contact number? (y/n):");
        char response = scanner.next().charAt(0);
        while (response == 'y' || response == 'Y') {
            if (response == 'y' || response == 'Y') {
                System.out.print("Contact Number: ");
                contactNumber.add(scanner.nextBigInteger());
                person.setContactList(contactNumber);
                System.out.println("Would you like to add another contact number? (y/n):");
                response = scanner.next().charAt(0);
            } else {
                response = 'n';
            }
        }
        System.out.println("Would you like to add email address? (y/n):");
        char response1 = scanner.next().charAt(0);
        scanner.nextLine();
        if (response1 == 'y' || response1 == 'Y') {
            System.out.print("Email Address: ");
            person.setEmail(scanner.nextLine());
        }
        return person;
    }
}
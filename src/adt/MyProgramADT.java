package adt;

import definition.Person;

public interface MyProgramADT {


    //add() method to add an contact to the contact list
    void add(Person item);

    //view() method to display all the contacts in the contact list
    void view();

    //search() method to search for a contact in the contact list
    void search(String item);

    //delete() method to delete a contact from the contact list
    void delete(int item);

    //displayList() method to display the contact names
    void displayList();
}


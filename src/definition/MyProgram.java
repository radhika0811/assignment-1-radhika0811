package definition;

import adt.MyProgramADT;

import java.util.ArrayList;
import java.util.Collections;

public class MyProgram implements MyProgramADT {

    // This reference variable will store the reference to the first contact of the contact list.
    private Node head = null;

    // This variable will store the current size of the contact list.
    private int size = 0;

    //add() method to add a contact in the contact list.
    @Override
    public void add(Person data) {
        Node node = new Node(data, head);
        head = node;
        size++;
    }

    //view() method to view the complete contact list.
    @Override
    public void view() {
        try {
            if (head != null) {
                Node temp1 = head;
                ArrayList<String> listNames = new ArrayList<>(size);
                String strName = "";
                while (temp1 != null) {
                    strName = (String) (temp1.getData().getFName() + temp1.getData().getLName());
                    listNames.add(strName);
                    temp1 = temp1.getNext();
                }
                Collections.sort(listNames);
                System.out.println("---Here are all your contacts---");
                for (int i = 0; i < listNames.size(); i++) {
                    Node temp = head;
                    String str = "";
                    while (temp != null) {
                        str = (String) (temp.getData().getFName() + temp.getData().getLName());
                        if (listNames.get(i).equals(str)) {
                            System.out.println("-------- * -------- * -------- * --------");
                            System.out.println(temp.getData());
                            System.out.println("-------- * -------- * -------- * --------");
                            break;
                        }
                        temp = temp.getNext();
                    }
                    System.out.println();
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Contact List is Empty!");
        }
    }

    //search() method to search for a contact in the contact list.
    @Override
    public void search(String item) {
        Node temp = head;
        int count = 0;
        ArrayList<Person> list = new ArrayList<>();
        while (temp != null) {
            if (temp.getData().getFName().equals(item)) {
                count += 1;
                list.add((Person) temp.getData());
            }
            temp = temp.getNext();
        }
        if (count != 0) {
            System.out.println(count + " match found!");
            for (int i = 0; i < list.size(); i++) {
                System.out.println("-------- * -------- * -------- * --------");
                System.out.println(list.get(i));
                System.out.println("-------- * -------- * -------- * --------");
            }
        } else {
            System.out.println("NO RESULTS FOUND!");
        }
    }

    //delete() method to delete a contact from the contact list.
    @Override
    public void delete(int item) {
        Node temp = head;
        Node previous = null;
        String result = "";
        if (item == 1) {
            result = (String) (temp.getData().getFName() + " " + temp.getData().getLName());
            System.out.println(result + "'s contact deleted from list!");
            head = temp.getNext();
            temp = head;
        } else {
            try {
                for (int i = 1; i <= size; i++) {
                    if (i == item) {
                        result = (String) (temp.getData().getFName() + " " + temp.getData().getLName());
                        System.out.println(result + "'s contact deleted from list!");
                        previous.setNext(temp.getNext());
                        break;
                    }
                    previous = temp;
                    temp = temp.getNext();
                }
            } catch (NullPointerException e) {
                System.out.println("Contact List is Empty!");
            }
        }
    }

    //displayList() method to display the list of contact names of the contact list.
    @Override
    public void displayList() {
        Node temp = head;
        int num = 1;
        while (temp != null) {
            System.out.println(num + " " + temp.getData().getFName() + " " + temp.getData().getLName());
            num += 1;
            temp = temp.getNext();
        }
    }
}
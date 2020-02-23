package definition;

import java.math.BigInteger;
import java.util.ArrayList;

public class Person {
    // these are the fields for the person class
    private String FName;
    private String LName;
    private ArrayList<BigInteger> contactList = new ArrayList<>();
    private String email;

    //getter methods for the fields of person class
    public String getFName() {
        return FName;
    }

    //setter methods for the fields of person class
    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<BigInteger> getContactList() {
        return contactList;
    }

    public void setContactList(ArrayList<BigInteger> contactList) {
        this.contactList = contactList;
    }

    //toString method
    @Override
    public String toString() {
        if (getContactList().size() == 1) {
            return "First Name: " + getFName() + "\n"
                    + "Last Name: " + getLName() + "\n"
                    + "Contact Number: " + getContactList().get(0) + "\n"
                    + "Email address: " + getEmail();
        } else {
            return "First Name: " + getFName() + "\n"
                    + "Last Name: " + getLName() + "\n"
                    + "Contact Number(s): " + getContactList() + "\n"
                    + "Email address: " + getEmail();
        }
    }
}
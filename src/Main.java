import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by PiratePowWow on 2/5/16.
 */
public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Contact> contacts = new ArrayList<Contact>();

    public static void main(String[] args) {

        listOptions();

    }


    public static void listOptions() {
        System.out.println("1: Create Contact");
        System.out.println("2: Delete Contact");
        System.out.println("3: List All Contacts");
        String response = scanner.nextLine();
        switch (response) {
            case "1":
                create();
                break;
            case "2":
                delete();
                break;
            case "3":
                list();
                break;
            default:
                System.out.println("Please enter a valid selection.");
                listOptions();
                break;
        }
    }

    public static void create() {
        System.out.println("What is the name of your contact?");
        String name = scanner.nextLine();
        Contact newContact = new Contact();
        if (contacts.isEmpty()) {
            getContactInfoAndAdd(newContact, name);
            System.out.println("Contact created, returning to main menu.");

        }
        else {
            for (Contact contact : contacts) {////The purpose of the for loop is to check if the contact exists. It could be replaced with a "finder" method that returns a boolean ie: contactExists?() to make the code more readable but meh
                if (contact.name.equalsIgnoreCase(name)) {
                    System.out.println("This contact already exists, would you like to replace this contact? [y/n]");
                    String response = scanner.nextLine();
                    if (response.equalsIgnoreCase("y")) {
                        getContactInfoAndAdd(newContact, name);
                        System.out.println("Contact replaced, returning to main menu.");
                        break;
                    } else {
                        System.out.println("Returning to main menu.");
                        break;
                    }
                } else {
                    getContactInfoAndAdd(newContact, name);
                    System.out.println("Contact created, returning to main menu.");
                    break;
                }
            }

        }
        listOptions();
    }

    public static void getContactInfoAndAdd(Contact newContact, String name) {
        newContact.name = name;
        System.out.println("What is the house number for " + name + "?");
        String houseNumber = scanner.nextLine();
        newContact.houseNumber = houseNumber;
        System.out.println("What is the street for " + name + "?");
        String street = scanner.nextLine();
        newContact.street = street;
        System.out.println("What is the City for " + name + "?");
        String city = scanner.nextLine();
        newContact.city = city;
        System.out.println("What is the State for " + name + "?");
        String state = scanner.nextLine();
        newContact.state = state;
        System.out.println("What is the zip code for " + name + "?");
        int zip = Integer.valueOf(scanner.nextLine());
        newContact.zip = zip;
        System.out.println("What is the phone number for " + name + "?");
        String phone = scanner.nextLine();
        newContact.phone = phone;
        contacts.add(newContact);
    }

    public static void delete() {
        Contact newContact = new Contact();
        System.out.println("What is the name of the contact you would like to delete?");
        String name = scanner.nextLine();
        for (Contact contact : contacts) {//The purpose of the for loop is to check if the contact exists. It could be replaced with a "finder" method that returns a boolean ie: contactExists?() to make the code more readable but meh
            if (contact.name.equalsIgnoreCase(name)) {
                contacts.remove(contact);
                System.out.println("That contact has been deleted. Returning to main menu");
                listOptions();
                break;
            }
        }
        System.out.println("That contact does not exist in our database. Would you like to try a new contact name? [y/n]");
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("y")) {
            delete();
        } else if (response.equalsIgnoreCase("n")) {
            System.out.println("Returning to main menu");
        } else {
            System.out.println("That selection was not recognized, returning to main menu.");
        }


    listOptions();

    }

    public static void list() {
        Contact newContact = new Contact();
        for (Contact contact : contacts) {
            System.out.println(contact.name);
            System.out.println(contact.houseNumber);
            System.out.println(contact.street);
            System.out.println(contact.city);
            System.out.println(contact.state);
            System.out.println(contact.zip);
            System.out.println(contact.phone);
            System.out.println();

        }
        listOptions();
    }

}

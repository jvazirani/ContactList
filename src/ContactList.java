import java.util.ArrayList;
import java.util.Scanner;
/**
 * A class that stores subclasses of Person as a contact list.
 * The user is presented with a menu of options and may add, sort,
 * search, or list the contacts.
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick & Jaya Vazirani
 * @version: 2022-2023
 */

public class ContactList
{
    // TODO: Create your array contacts
    private ArrayList<Person> contacts;
    // TODO: Write a Constructor
    public ContactList(){
        contacts = new ArrayList<Person>();
    }
    public void printMenuOptions() {
        System.out.println("Menu: ");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search by Phone Number");
        System.out.println("0. Exit");
    }

    /**
     * Asks user for input to create and add a new Person
     * to the contact list
     */
    public void addContact() {
        // TODO: Complete the addContact method
        // Get user input
        Scanner s = new Scanner(System.in);
        System.out.println("Select a type of contact to add: " + "\n" + "1. Student " + "\n" + "2. Worker");
        int type = s.nextInt();
        s.nextLine();
        // Make sure user input is valid
        while(!((type == 1) || (type == 2))){
            System.out.println("Select a type of contact to add: " + "\n" + "1. Student " + "\n" + "2. Worker");
            type = s.nextInt();
            s.nextLine();
        }
        // Get all shared information
        System.out.println("First name: ");
        String name = s.nextLine();
        System.out.println("Last name: ");
        String lName = s.nextLine();
        System.out.println("Phone number: ");
        String phone = s.nextLine();
        // Make sure phone number is a valid length (10 digits)
        while (phone.length() != 10){
            System.out.println("Phone should be 10 digits");
            System.out.println("Phone number: ");
            phone = s.nextLine();
        }
        Person person;
        // If it is a student, ask for a grade
        if(type == 1){
            System.out.println("Grade: ");
            int grade = s.nextInt();
            person = new Student(name, lName, phone, grade);
        }
        // If it is a worker, ask for a salary
        else {
            System.out.println("Salary: ");
            int salary = s.nextInt();
            person = new Worker(name, lName, phone, salary);
        }
        // Add contact to arrayList of contacts
        contacts.add(person);
    }

    /**
     * Loops through and prints all contacts
     */
    public void printContacts() {
        // TODO: Complete the printContacts method
        for(Person p : contacts){
            System.out.println(p.toString());
        }
    }

    /**
     * Bubble sorts the contacts in the list by firstName,
     * lastName, or phoneNumber
     * @param sortBy: 0=firstName, 1=lastName, 2=phoneNumber
     */
    public void sort(int sortBy) {
        // TODO: Complete the sort method
        // sort by first name
        int n = contacts.size();
        String letter1;
        String letter2;
        for(int pass = 1; pass < n; pass++){
            for(int comp = 0; comp < n - pass; comp++)
            {
                // Depending on what the user wants to do, sort by name, last name, or phone number
                if(sortBy == 0){
                    // Get first two letters of the first name's
                    letter1 = contacts.get(comp).getFirstName();
                    letter2 = contacts.get(comp + 1).getFirstName();
                }
                else if (sortBy == 1){
                    // Get first two letters of the last name's
                    letter1 = contacts.get(comp).getLastName();
                    letter2 = contacts.get(comp + 1).getLastName();
                }
                else{
                    // Get first two numbers of the phone numbers
                    letter1 = contacts.get(comp).getPhoneNumber();
                    letter2 = contacts.get(comp + 1).getPhoneNumber();
                }
                if (letter1.compareToIgnoreCase(letter2) > 0) {
                    Person temp = contacts.get(comp);
                    // Set index of contacts.getcomp to what is in comp+1
                    contacts.set(comp, contacts.get(comp+1));
                    // Set what was in comp+1 to temp
                    contacts.set(comp + 1, temp);
                }
            }
        }
        printContacts();
    }

    // TODO: Write searchByFirstName
    public Person searchByFirstName(String firstName) {
        // Search through all contacts
        for (int i = 0; i < contacts.size(); i++) {
            // If one of the contacts is the same name we're searching for, return it
            if (contacts.get(i).getFirstName().equals(firstName)) {
                return contacts.get(i);
            }
        }
        return null;
    }
    // TODO: Write searchByLastName
    public Person searchByLastName(String lastName) {
        for (int i = 0; i < contacts.size(); i++){
            // Compare each contact to the last name we are searching for
            if(contacts.get(i).getLastName().equals(lastName)){
                // Return the contact if there is a match
                return contacts.get(i);
            }
        }
        return null;
    }
    // TODO: Write searchByPhoneNumber
    public Person searchByPhoneNumber(String phoneNumber){
        for (int i = 0; i < contacts.size(); i++){
            // Search through array list of contacts to see if there is one the same as the phone number
            if(contacts.get(i).getPhoneNumber().equals(phoneNumber)){
                return contacts.get(i);
            }
        }
        return null;
    }
    /**
     * Lists just the Student objects in the Contact List
     */
    public void listStudents() {
        // TODO: Complete the listStudents method
        for(int i = 0; i < contacts.size(); i++){
            // If a contact is a student print it
            if (contacts.get(i) instanceof Student){
                System.out.println(contacts.get(i));
            }
        }
    }

    /**
     * Loops providing menu options to the user
     * until the user exits
     */
    // TODO: Complete the run method
    public void run() {
        System.out.println("Welcome to your Contacts List");
        System.out.println("Please pick from the following menu options");
        printMenuOptions();
        Scanner s = new Scanner(System.in);
        System.out.println("What would you like to do?");
        int number = s.nextInt();
        s.nextLine();
        // While the user still wants to choose a number, give them the options
        while(number != 0) {
            if (number == 1) {
                addContact();
            }
            if (number == 2) {
                sort(0);
            }
            if (number == 3) {
                sort(1);
            }
            if (number == 4) {
                sort(2);
            }
            if (number == 5) {
                listStudents();
            }
            if (number == 6) {
                // Get the name the user is searching for
                System.out.println("Enter a name");
                String name = s.nextLine();
                if(searchByFirstName(name) == null){
                    System.out.println(name + " is not in the list");
                }
                else{
                    System.out.println(searchByFirstName(name));
                }
            }
            if (number == 7) {
                System.out.println("Enter a name");
                String name = s.nextLine();
                if(searchByLastName(name) == null){
                    System.out.println(name + " is not in the list");
                }
                else{
                    System.out.println(searchByLastName(name));
                }
            }
            if (number == 8) {
                System.out.println("Enter a number");
                String name = s.nextLine();
                if(searchByPhoneNumber(name) == null){
                    System.out.println(name + " is not in the list");
                }
                else{
                    System.out.println(searchByPhoneNumber(name));
                }
            }
            printMenuOptions();
            System.out.println("What would you like to do?");
            number = s.nextInt();
            s.nextLine();
        }
    }


    public static void main(String[] args)
    {
        ContactList cl = new ContactList();
        cl.run();
    }
}

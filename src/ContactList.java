import java.util.ArrayList;
import java.util.Scanner;
/**
 * A class that stores subclasses of Person as a contact list.
 * The user is presented with a menu of options and may add, sort,
 * search, or list the contacts.
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick
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
        Scanner s = new Scanner(System.in);
        System.out.println("Select a type of contact to add: " + "\n" + "1. Student " + "\n" + "2. Worker");
        int type = s.nextInt();
        System.out.println("First name: ");
        String name = s.nextLine();
        System.out.println("Last name: ");
        String lName = s.nextLine();
        System.out.println("Phone number: ");
        String phone = s.nextLine();
        if(type == 1){
            System.out.println("Grade: ");
            int grade = s.nextInt();
            Person person = new Student(name, lName, phone, grade);
        }
        else if (type == 2){
            System.out.println("Salary: ");
            int salary = s.nextInt();
            Person person = new Worker(name, lName, phone, salary);
        }

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
        searchByFirstName(contacts);
        searchByLastName(contacts);
        searchByPhoneNumber(contacts);
    }

    // TODO: Write searchByFirstName
    public void searchByFirstName(ArrayList contacts){
        //
    }

    // TODO: Write searchByLastName
    public void searchByLastName(ArrayList contacts){
        //
    }
    // TODO: Write searchByPhoneNumber
    public void searchByPhoneNumber(ArrayList contacts){
        //
    }
    /**
     * Lists just the Student objects in the Contact List
     */
    public void listStudents() {
        // TODO: Complete the listStudents method
    }

    /**
     * Loops providing menu options to the user
     * until the user exits
     */
    public void run() {
        System.out.println("Welcome to your Contacts List");
        System.out.println("Please pick from the following menu options");
        printMenuOptions();

        // TODO: Complete the run method
    }


    public static void main(String[] args)
    {
        ContactList cl = new ContactList();
        cl.run();
    }
}

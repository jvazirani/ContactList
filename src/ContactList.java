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
        Person person;
        if(type == 1){
            System.out.println("Grade: ");
            int grade = s.nextInt();
            person = new Student(name, lName, phone, grade);
        }
        else{
            System.out.println("Salary: ");
            int salary = s.nextInt();
            person = new Worker(name, lName, phone, salary);
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
        // sort by first name
        int n = contacts.size();
        String letter1;
        String letter2;
        for(int pass = 1; pass < n; pass++){
            for(int comp = 0; comp < n - pass; comp++)
            {
                if(sortBy == 0){
                    letter1 = contacts.get(comp).getFirstName();
                    letter2 = contacts.get(comp + 1).getFirstName();
                }
                else if (sortBy == 1){
                    // sort by last name
                    letter1 = contacts.get(comp).getLastName();
                    letter2 = contacts.get(comp + 1).getLastName();
                }
                else{
                    // sort by phone number
                    letter1 = contacts.get(comp).getPhoneNumber();
                    letter2 = contacts.get(comp + 1).getPhoneNumber();
                }
                if (letter1.compareToIgnoreCase(letter2) > 0) {
                    Person temp = contacts.get(comp);
                    // set index of contacts.getcomp to what is in comp+1
                    contacts.set(comp, contacts.get(comp+1));
                    // set what was in comp+1 to temp
                    contacts.set(comp + 1, temp);
                }
            }
        }
    }

    // TODO: Write searchByFirstName
    public Person searchByFirstName(String firstName) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getFirstName().equals(firstName)) {
                return contacts.get(i);
            }
        }
        return null;
    }
    // TODO: Write searchByLastName
    public Person searchByLastName(String lastName) {
        for (int i = 0; i < contacts.size(); i++){
            if(contacts.get(i).getFirstName().equals(lastName)){
                return contacts.get(i);
            }
        }
        return null;
    }
    // TODO: Write searchByPhoneNumber
    public Person searchByPhoneNumber(String phoneNumber){
        for (int i = 0; i < contacts.size(); i++){
            if(contacts.get(i).getFirstName().equals(phoneNumber)){
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
            //if contact is a student print it
            //how to check if contact is a student?
            if (contacts.get(i) instanceof Student){
                System.out.println(contacts.get(i));
            }
        }
    }

    /**
     * Loops providing menu options to the user
     * until the user exits
     */
    public void run() {
        System.out.println("Welcome to your Contacts List");
        System.out.println("Please pick from the following menu options");
        printMenuOptions();
        Scanner s = new Scanner(System.in);
        System.out.println("What would you like to do?");
        int number = s.nextInt();
        if(number == 1){
            addContact();
        }
        else if (number == 2){
            sort(0);
        }
        else if (number == 3){
            sort(1);
        }
        else if (number == 4){
            sort(2);
        }
        else if (number == 5){
            listStudents();
        }
        else if (number == 6){
            System.out.println("Enter a name");
            String name = s.nextLine();
            searchByFirstName(name);
        }
        else if (number == 7){
            System.out.println("Enter a name");
            String lName = s.nextLine();
            searchByLastName(lName);
        }
        else if (number == 8){
            System.out.println("Enter a number");
            String num = s.nextLine();
            searchByPhoneNumber(num);
        }
        else if (number == 0){
            // how to exit?
        }


        // TODO: Complete the run method
    }


    public static void main(String[] args)
    {
        ContactList cl = new ContactList();
        cl.run();
    }
}

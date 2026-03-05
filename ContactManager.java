import java.util.ArrayList;
import java.util.Scanner;

class Contact {

    String name;
    String phone;

    Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}

public class ContactManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Contact> contacts = new ArrayList<>();

        while (true) {

            System.out.println("\nContact Management System");
            System.out.println("1 Add Contact");
            System.out.println("2 View Contacts");
            System.out.println("3 Search Contact");
            System.out.println("4 Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter phone: ");
                    String phone = sc.nextLine();

                    contacts.add(new Contact(name, phone));
                    System.out.println("Contact added.");
                    break;

                case 2:
                    if (contacts.isEmpty()) {
                        System.out.println("No contacts found.");
                    } else {
                        for (Contact c : contacts) {
                            System.out.println("Name: " + c.name + " | Phone: " + c.phone);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    String search = sc.nextLine();

                    boolean found = false;

                    for (Contact c : contacts) {
                        if (c.name.equalsIgnoreCase(search)) {
                            System.out.println("Found: " + c.name + " - " + c.phone);
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Contact not found.");
                    }

                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}

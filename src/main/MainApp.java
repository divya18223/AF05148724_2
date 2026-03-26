package main;

import java.util.Scanner;
import dao.ContactDAO;
import model.Contact;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ContactDAO dao = new ContactDAO();

        while (true) {
            System.out.println("\n--- Contact Manager ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Delete Contact");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Phone: ");
                    String phone = sc.nextLine();

                    dao.addContact(new Contact(name, phone));
                    break;

                case 2:
                    dao.viewContacts();
                    break;

                case 3:
                    System.out.print("Enter ID to delete: ");
                    int id = sc.nextInt();
                    dao.deleteContact(id);
                    break;

                case 4:
                    sc.close();
                    System.exit(0);
            }
        }
    }
}
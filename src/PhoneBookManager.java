import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBookManager {
    private Map<String, Contact> phoneBook;
    private Scanner scanner;

    public PhoneBookManager() {
        phoneBook = new HashMap<>();
        scanner = new Scanner(System.in);
    }


    public void run() {
        boolean running = true;
        while (running) {
            printMenu(); // TODO valósítsd meg a printMenu() metódust!
            int choice; // TODO olvasd be a felhasználótól, mit szeretne csinálni!
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            scanner.nextLine(); // vajon miért kell ez a sor?
            // TODO a megadott szám alapján hívd meg a megfelelő metódust
            //  vagy lépj ki!
            switch (choice) {
                case 1 -> addContact();
                case 2 -> removeContact();
                case 3 -> searchContact();
                case 4 -> listContacts();
                case 5 -> System.out.println("Exit...");
                default -> System.out.println("Invalid choice");
            }
        }
        scanner.close();
    }

    private void printMenu() {
        System.out.println("Phone Book Menu");
        System.out.println("1. Add contact");
        System.out.println("2. Remove contact");
        System.out.println("3. Search contact");
        System.out.println("4. Display all contacts");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private void listContacts() {
        // TODO Szépen formázva írd ki a telefonkönyv összes bejegyzését!
        System.out.println("Phone book entries: ");

        for (Contact contact : phoneBook.values()) {
            String name = contact.getName();
            String phoneNumber = contact.getPhoneNumber();

            System.out.println("Name: " + name );
            System.out.println("Phone number: " + phoneNumber);
            System.out.println();
        }


    }

    private void addContact() {
         Map<String,String> phoneBook = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        // TODO olvasd be egy változóba a kontakt nevét
        System.out.println("Contact name: ");
        String name = scanner.nextLine();

        // TODO olvasd be egy változóba a kontakt telefonszámát
        System.out.println("Contact phone number: ");
        String phoneNumber = scanner.nextLine();
        // TODO példányosíts ezekből az adatokból egy Contact-ot
        // TODO tedd bele ezeket az infókat a mapbe:
        //      mi lesz a kulcs és mi az érték?
        Contact contact = new Contact(name, phoneNumber);
        phoneBook.put(name,phoneNumber);
        System.out.println("Contact added successfully!");
        System.out.println("Name: " + name);
        System.out.println("Phone number: " + phoneNumber);

    }

    private void searchContact() {
        // TODO valósítsd meg a név alapján való keresést
        System.out.print("Enter name to search: ");
        String searchName = scanner.nextLine();
        if(phoneBook.containsKey(searchName)){
            Contact contact = phoneBook.get(searchName);
            String name = contact.getName();
            String phoneNumber = contact.getPhoneNumber();

            System.out.println("Contact found: ");
            System.out.println("Name: " + name);
            System.out.println("Phone number: " + phoneNumber);
        }else{
            System.out.println("Contact not found! ");
        }


        //  ha nem találod meg az adott kontaktot, jelezd
        //  azt is a felhasználónak!
    }

    private void removeContact() {
        // TODO valósítsd meg a név alapján való törlést
        //  ha nem találod meg az adott kontaktot, jelezd
        //  azt is a felhasználónak!
        System.out.println("Enter name to remove: ");
        String removeName = scanner.nextLine();
        if(phoneBook.containsKey(removeName)){
            phoneBook.remove(removeName);
            System.out.println("Contact removed successfully!");
        }else{
            System.out.println("Contact not found! ");
        }

    }

}

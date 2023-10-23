package contact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactService {

    private Map<String, Contact> contacts;

    public ContactService() {
        contacts = new HashMap<>();
    }

    public boolean addContact(Contact contact) {
        String contactID = contact.getContactID();
        if (contacts.containsKey(contactID)) {
            System.out.println("Contact with the same ID already exists. Cannot add.");
            return false;
        }
        contacts.put(contactID, contact);
        System.out.println("Contact added successfully.");
        return true;
    }

    public boolean deleteContact(String contactID) {
        if (contacts.containsKey(contactID)) {
            contacts.remove(contactID);
            System.out.println("Contact with ID " + contactID + " deleted successfully.");
            return true;
        } else {
            System.out.println("Contact with ID " + contactID + " not found.");
            return false;
        }
    }

    public boolean updateContact(String contactID, String firstName, String lastName, String numberAddress) {
        if (contacts.containsKey(contactID)) {
            Contact contact = contacts.get(contactID);
            if (!firstName.isEmpty()) {
                contact.setFirstName(firstName);
            }
            if (!lastName.isEmpty()) {
                contact.setLastName(lastName);
            }
            if (!numberAddress.isEmpty()) {
                contact.setNumberAddress(numberAddress);
            }
            System.out.println("Contact updated successfully.");
            return true;
        } else {
            System.out.println("Contact with ID " + contactID + " not found.");
            return false;
        }
    }

    public List<Contact> getAllContacts() {
        return new ArrayList<>(contacts.values());
    }
}

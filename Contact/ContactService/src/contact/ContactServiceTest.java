package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("C001", "Luke", "Fin", "1234567890", "123 Main St");
        assertTrue(contactService.addContact(contact));
    }

    @Test
    public void testAddDuplicateContact() {
        Contact contact1 = new Contact("C001", "Luke", "Fin", "1234567890", "123 Main St");
        Contact contact2 = new Contact("C001", "Lois", "Lane", "9876543210", "456 Elm St");
        assertTrue(contactService.addContact(contact1));
        assertFalse(contactService.addContact(contact2));
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("C001", "Luke", "Fin", "1234567890", "123 Main St");
        assertTrue(contactService.addContact(contact));
        assertTrue(contactService.deleteContact("C001"));
    }

    @Test
    public void testDeleteNonexistentContact() {
        assertFalse(contactService.deleteContact("C002"));
    }

    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("C001", "Luke", "Fin", "1234567890", "123 Main St");
        assertTrue(contactService.addContact(contact));
        assertTrue(contactService.updateContact("C001", "Luke", "", "9876543210"));
    }

    @Test
    public void testUpdateNonexistentContact() {
        assertFalse(contactService.updateContact("C002", "Lois", "Lane", "1234567890"));
    }
}

package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("C001", "Luke", "Fin", "1234567890", "123 Main St");
        assertEquals("C001", contact.getContactID());
        assertEquals("Luke", contact.getFirstName());
        assertEquals("Fin", contact.getLastName());
        assertEquals("1234567890", contact.getPhoneNumber());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testInvalidContactID() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () ->
                new Contact(null, "Luke", "Fin", "1234567890", "123 Main St"));
        assertEquals("Contact ID must not be null, empty, or exceed 10 characters.", thrown.getMessage());
    }

    @Test
    public void testInvalidFirstName() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () ->
                new Contact("C001", null, "Fin", "1234567890", "123 Main St"));
        assertEquals("First Name must not be null and must not exceed 10 characters.", thrown.getMessage());
    }

    @Test
    public void testInvalidLastName() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () ->
                new Contact("C001", "Luke", null, "1234567890", "123 Main St"));
        assertEquals("Last Name must not be null and must not exceed 10 characters.", thrown.getMessage());
    }

    @Test
    public void testInvalidPhoneNumber() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () ->
                new Contact("C001", "Luke", "Fin", "12345", "123 Main St"));
        assertEquals("Phone number must be exactly 10 digits.", thrown.getMessage());
    }

    @Test
    public void testInvalidAddress() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () ->
                new Contact("C001", "Luke", "Fin", "1234567890", null));
        assertEquals("Address must not be null and must not exceed 30 characters.", thrown.getMessage());
    }
}
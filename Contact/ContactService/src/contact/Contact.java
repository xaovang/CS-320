package contact;

public class Contact {

    private final String contactID;
    private final String firstName;
    private final String lastName;
    private final String phoneNumber;
    private final String address;

    public Contact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
        validateContactID(contactID);
        validateStringField("First Name", firstName, 10);
        validateStringField("Last Name", lastName, 10);
        validatePhoneNumber(phoneNumber);
        validateStringField("Address", address, 30);

        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    private void validateContactID(String contactID) {
        if (contactID == null || contactID.isEmpty() || contactID.length() > 10) {
            throw new IllegalArgumentException("Contact ID must not be null, empty, or exceed 10 characters.");
        }
    }

    private void validateStringField(String fieldName, String fieldValue, int maxLength) {
        if (fieldValue == null || fieldValue.length() > maxLength) {
            throw new IllegalArgumentException(fieldName + " must not be null and must not exceed " + maxLength + " characters.");
        }
    }

    private void validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || !phoneNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits.");
        }
    }
}

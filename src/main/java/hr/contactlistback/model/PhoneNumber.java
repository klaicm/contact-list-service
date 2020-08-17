package hr.contactlistback.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "phone_number")
public class PhoneNumber extends BaseEntity {

    private String phoneNumber;

    private String phoneDescription;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="contact_id", nullable = false)
    Contact contact;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneDescription() {
        return phoneDescription;
    }

    public void setPhoneDescription(String phoneDescription) {
        this.phoneDescription = phoneDescription;
    }

    public long getContactId() {
        return contact.getId();
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}

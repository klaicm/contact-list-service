package hr.contactlistback.controllers;

import hr.contactlistback.model.Contact;
import hr.contactlistback.model.PhoneNumber;
import hr.contactlistback.services.ContactService;
import hr.contactlistback.services.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class ContactController {

    @Autowired
    ContactService contactService;

    @Autowired
    PhoneNumberService phoneNumberService;

    @GetMapping("/allContacts")
    public Set<Contact> getAllContacts() {
        return contactService.findAll();
    }

    @GetMapping("/contact/{id}")
    public Contact getContact(@PathVariable("id") Long id, Model model) {
        return contactService.findById(id);
    }

    @PostMapping(path = "/addNewContact", consumes = "application/json", produces = "application/json")
    public void addNewPlayer(@RequestBody Contact contact) {

        contactService.save(contact);
    }

    @PostMapping(path = "/saveContact", consumes = "application/json", produces = "application/json")
    public Contact saveContact(@RequestBody Contact contact) {

        if (contact.getId() != null) {
            Set<PhoneNumber> phoneNumbers = phoneNumberService.findAll();
            phoneNumbers.forEach(phoneNumber -> {
                if (phoneNumber.getContactId() == contact.getId()) {
                    phoneNumberService.deleteById(phoneNumber.getId());
                }
            });
        }

        return contactService.save(contact);
    }

    @PostMapping(path = "/deleteContact", consumes = "application/json", produces = "application/json")
    public void deleteContact(@RequestBody Contact contact) {
        contactService.delete(contact);
    }
}

package hr.contactlistback.controllers;

import hr.contactlistback.model.PhoneNumber;
import hr.contactlistback.services.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class PhoneNumberController {

    @Autowired
    PhoneNumberService phoneNumberService;

    @GetMapping("/allPhoneNumbers")
    public Set<PhoneNumber> getAllContacts() {
        return phoneNumberService.findAll();
    }

    @GetMapping("/phoneNumber/{id}")
    public PhoneNumber getPhoneNumber(@PathVariable("id") Long id, Model model) {
        return phoneNumberService.findById(id);
    }

    @PostMapping(path = "/savePhoneNumber", consumes = "application/json", produces = "application/json")
    public PhoneNumber saveContact(@RequestBody PhoneNumber phoneNumber) {

        return phoneNumberService.save(phoneNumber);
    }

    @PostMapping(path = "/deletePhoneNumber", consumes = "application/json", produces = "application/json")
    public void deleteContact(@RequestBody PhoneNumber phoneNumber) {
        phoneNumberService.delete(phoneNumber);
    }
}

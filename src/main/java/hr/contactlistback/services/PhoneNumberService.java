package hr.contactlistback.services;

import hr.contactlistback.model.PhoneNumber;
import hr.contactlistback.repositories.PhoneNumberRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PhoneNumberService implements CrudService<PhoneNumber, Long> {

    private final PhoneNumberRepository phoneNumberRepository;

    public PhoneNumberService(PhoneNumberRepository phoneNumberRepository) {
        this.phoneNumberRepository = phoneNumberRepository;
    }

    @Override
    public Set<PhoneNumber> findAll() {
        Set<PhoneNumber> phoneNumbers = new HashSet<>();
        phoneNumberRepository.findAll().forEach(phoneNumbers::add);
        return phoneNumbers;
    }

    @Override
    public PhoneNumber findById(Long id) {
        return phoneNumberRepository.findById(id).orElse(null);
    }

    @Override
    public PhoneNumber save(PhoneNumber phoneNumber) {

        return phoneNumberRepository.save(phoneNumber);
    }

    @Override
    public void delete(PhoneNumber phoneNumber) {
        phoneNumberRepository.delete(phoneNumber);
    }

    @Override
    public void deleteById(Long id) {
        phoneNumberRepository.deleteById(id);
    }

}

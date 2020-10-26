package com.assessment.services;

import com.assessment.dto.AddContactsDto;
import com.assessment.dto.CreateUserDto;
import com.assessment.dto.GetCommonContactsDto;
import com.assessment.entities.Contact;
import com.assessment.repositories.UserRepository;
import com.assessment.entities.User;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Singleton
public class UserService {

    @Inject
    UserRepository userRepository;

    public User createUser(CreateUserDto createUserDto) {
        User user = new User(createUserDto.getPhone(), createUserDto.getName(), createUserDto.getLastName());
        this.userRepository.save(user);
        return user;
    }

    public List<User> getUsers() {
        return (List<User>) this.userRepository.findAll();
    }

    public User addContacts(String id, AddContactsDto[] addContactsDto) {
        User user = this.userRepository.findById(id).orElseThrow();
        List<Contact> contacts = Arrays
                .stream(addContactsDto)
                .map(contactDto -> new Contact(contactDto.getPhone(), contactDto.getContactName()))
                .collect(Collectors.toList());
        user.getContacts().addAll(contacts);
        return this.userRepository.update(user);
    }

    public List<Contact> getCommonContacts(GetCommonContactsDto getCommonContactsDto) {
        return this.userRepository
                .getCommonContacts(getCommonContactsDto.getUserId1(), getCommonContactsDto.getUserId2());
    }

    public List<Contact> getContacts(String userId) {
        return this.userRepository.findById(userId)
                .orElseThrow(NoSuchElementException::new)
                .getContacts();
    }
}

package com.assessment.controllers;

import com.assessment.annotations.ValidPhone;
import com.assessment.dto.AddContactsDto;
import com.assessment.dto.CreateUserDto;
import com.assessment.dto.GetCommonContactsDto;
import com.assessment.entities.Contact;
import com.assessment.services.UserService;
import com.assessment.entities.User;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

@Introspected
@Controller("/users")
public class UserController {

    @Inject
    private UserService usersService;

    @Post
    public User createUser(@Valid @Body CreateUserDto createUserDto){
        return this.usersService.createUser(createUserDto);
    }

    @Post("{userId}/contacts")
    public User addContacts(String userId, @Valid @Body AddContactsDto[] addContactsDto){
        return this.usersService.addContacts(userId, addContactsDto);
    }

    @Get("{userPhone}/contacts")
    public List<Contact> getContacts(@ValidPhone String userPhone){
        return this.usersService.getContacts(userPhone);
    }

    @Post("commonContacts")
    public List<Contact> getCommonContacts(@Valid @Body GetCommonContactsDto getCommonContactsDto) {
        return this.usersService.getCommonContacts(getCommonContactsDto);
    }
}


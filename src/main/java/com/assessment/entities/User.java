package com.assessment.entities;

import com.assessment.annotations.ValidPhone;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String phone;
    private String name;
    private String lastname;
    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
    private List<Contact> contacts;

    public User(String phone, String name, String lastname){
        this(phone, name, lastname, new ArrayList<>());
    }
}

package com.assessment.repositories;

import com.assessment.entities.Contact;
import com.assessment.entities.User;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;


@JdbcRepository(dialect = Dialect.MYSQL)
public interface UserRepository extends CrudRepository<User, String> {
    @Query("SELECT DISTINCT c.* " +
            "FROM contact c, " +
            "(SELECT uc1.contacts_phone " +
            "FROM user_contact uc1 " +
            "LEFT JOIN user_contact uc2 ON uc1.contacts_phone=uc2.contacts_phone " +
            "WHERE uc1.user_phone<>uc2.user_phone AND uc1.user_phone=:userId1 AND uc2.user_phone=:userId2" +
            ") commonContacts " +
            "WHERE commonContacts.contacts_phone=c.phone")
    List<Contact> getCommonContacts(String userId1, String userId2);
}
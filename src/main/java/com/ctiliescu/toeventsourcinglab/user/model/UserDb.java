package com.ctiliescu.toeventsourcinglab.user.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document("users")
public class UserDb extends User {
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserDb() {}

    public UserDb(User user) {
        this.setEmail(user.getEmail());
        this.setPassword(user.getPassword());
        this.setFirstName(user.getFirstName());
        this.setSecondName(user.getSecondName());
        this.setCountry(user.getCountry());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDb)) return false;
        if (!super.equals(o)) return false;
        UserDb userDb = (UserDb) o;
        return Objects.equals(id, userDb.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}

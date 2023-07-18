package com.example.bff3.model;

import lombok.Data;

@Data
public class UserDТО {
    private String username;
    private UserRole role;

    public static UserDТО of(User user) {
        UserDТО details = new UserDТО();
        details.username = user.getUsername();
        details.role = user.getRole();
        return details;
    }
}


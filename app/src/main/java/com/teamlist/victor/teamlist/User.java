package com.teamlist.victor.teamlist;

/**
 * Created by Victor on 9/14/2016.
 */
public class User {

    private String name;
    private String email;
    private String userID;


    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String name, String email, String userID) {
        this.name = name;
        this.email = email;
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setEmail(String newEmail) {
        email = newEmail;
    }

}

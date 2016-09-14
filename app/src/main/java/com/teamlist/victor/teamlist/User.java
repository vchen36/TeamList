package com.teamlist.victor.teamlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Victor on 9/14/2016.
 */
public class User {

    private String name;
    private String email;
    private Map<String, Boolean> mProjects;


    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String name, String email, Map<String, Boolean> mProjects) {
        this.name = name;
        this.email = email;
        if (mProjects != null) {
            this.mProjects = mProjects;
        } else {
            mProjects = new HashMap<>();
        }

    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Map<String, Boolean> getmProjects() {
        return mProjects;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setEmail(String newEmail) {
        email = newEmail;
    }

    public void addProject(String projectName) {
        mProjects.put(projectName, true);
    }

}

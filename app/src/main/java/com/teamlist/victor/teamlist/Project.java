package com.teamlist.victor.teamlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Victor on 9/14/2016.
 */
public class Project {

    private List<String> users;
    private String name;
    private List<Task> tasks;

    public Project() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Project(String name) {
        this.name = name;
        users = new ArrayList<>();
        tasks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public List<String> getUsers() {
        return users;
    }

    public void addUser(String user) {
        users.add(user);
    }

    public void removeUser(String user) {
        users.remove(user);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task mTask) {
        tasks.add(mTask);
    }

}

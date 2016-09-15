package com.teamlist.victor.teamlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Victor on 9/14/2016.
 */
public class Project {

    private Map<String, Boolean> users;
    private String name;
    private Map<String, Task> tasks;

    public Project() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
        users = new HashMap<>();
        tasks = new HashMap<>();
    }

    public Project(String name) {
        super();
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public Map<String, Boolean> getUsers() {
        return users;
    }

    public void addUser(String user) {
        users.put(user, true);
    }

    public void removeUser(String user) {
        users.remove(user);
    }

    public Map<String, Task> getTasks() {
        return tasks;
    }

    public void addTask(String ID, Task mTask) {
        tasks.put(ID, mTask);
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> ret = new HashMap<>();
        ret.put("name", name);
        ret.put("members", users);
        ret.put("tasks", tasks);
        return ret;
    }

}

package com.teamlist.victor.teamlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents each item on the to-do list
 * Created by Victor on 9/12/2016.
 */
public class Task {

    private String content;
    private List<Task> subtasks;

    public Task(String content) {
        this.content = content;
        subtasks = new ArrayList<>();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String str) {
        content = str;
    }

    public void addSubTasks(List<Task> mList) {
        subtasks.addAll(mList);
    }

    public int getNumSubtasks() {
        return subtasks.size();
    }
}

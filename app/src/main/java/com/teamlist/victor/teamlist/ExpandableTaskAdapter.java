package com.teamlist.victor.teamlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Victor on 9/16/2016.
 */
public class ExpandableTaskAdapter extends BaseExpandableListAdapter {

    private Context context;

    private List<Task> topTasks;
    private Map<Task, List<Task>> subTasks;


    public ExpandableTaskAdapter(Context c, List<Task> topTasks, Map<Task, List<Task>> subTasks) {
        this.topTasks = topTasks;
        this.subTasks = subTasks;
        this.context = c;
    }


    @Override
    public View getChildView(int group, int child, boolean lastChild, View convertView, ViewGroup parent) {
        // inflate and setup child view
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.child_task, null);
        }
        return convertView;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
       Task choose =  topTasks.get(groupPosition);
       if (choose.getNumSubtasks() == 0) {
           return choose;
       } else {
           return subTasks.get(choose);
       }
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getGroupView(final int group, final boolean expanded, final View convertView,
                             final ViewGroup parent) {
//        if (elements.get(group).shouldBeDisplayedAsAGroup()) {
//            // inflate and setup view that displays expandable view header
//        } else {
//            // inflate and setup view of element that should be displayed as single element
//        }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return topTasks.get(groupPosition).getNumSubtasks();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return topTasks.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return topTasks.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
}

package com.teamlist.victor.teamlist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Victor on 9/16/2016.
 */
public class ExpandableTaskAdapter extends BaseExpandableListAdapter {

    private Context context;
    private final List<String> taskInfo = new ArrayList<>();

    private final List<Task> elements;

    public ExpandableTaskAdapter(Context c, List<Task> elements) {
        this.elements = elements;
        this.context = c;
    }


    @Override
    public View getChildView(final int group, final int child, final boolean lastChild, final View convertView,
                             final ViewGroup parent) {

        // inflate and setup child view
        return convertView;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return 0;
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
        return 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return 0;
    }

    @Override
    public int getGroupCount() {
        return 0;
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

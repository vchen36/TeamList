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

    public MultiSelectExpandableListAdapter(Context c, List<Task> elements) {
        this.elements = elements;
    }

    public View getGroupView(final int group, final boolean expanded, final View convertView,
                             final ViewGroup parent) {
        if (elements.get(group).shouldBeDisplayedAsAGroup()) {
            // inflate and setup view that displays expandable view header
        } else {
            // inflate and setup view of element that should be displayed as single element
        }

    }

    public View getChildView(final int group, final int child, final boolean lastChild, final View convertView,
                             final ViewGroup parent) {

        // inflate and setup child view

    }
}

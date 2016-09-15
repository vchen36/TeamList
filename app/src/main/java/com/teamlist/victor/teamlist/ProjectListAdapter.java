package com.teamlist.victor.teamlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Victor on 9/14/2016.
 */
public class ProjectListAdapter extends ArrayAdapter<Project> {
    public ProjectListAdapter(Context context, int resource, ArrayList<Project> projs) {
        super(context, resource, projs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Project proj = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.project_rows, parent, false);
        }

        TextView projectItem = (TextView) convertView.findViewById(R.id.project_item);
        if (proj != null) {
            projectItem.setText(proj.getName());
            projectItem.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                }
            });
        }
        return convertView;
    }
}

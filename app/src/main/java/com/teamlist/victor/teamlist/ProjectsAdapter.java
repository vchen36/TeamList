package com.teamlist.victor.teamlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Victor on 10/4/2016.
 */


public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    // Define the method that allows the parent activity or fragment to define the listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    private static OnItemClickListener listener;

    //Provide a direct reference to each of the views within a data item
    //Used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView projNameTextView;

        public ViewHolder(final View itemView) {
            super(itemView);
            this.projNameTextView = (TextView) itemView.findViewById(R.id.project_item);
            // Setup the click listener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Triggers click upwards to the adapter on click
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (listener != null && position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(itemView, position);
                        }
                    }
                }
            });
        }
    }

    private List<String> projectNames;

    private Context context;

    public ProjectsAdapter(Context context, List<String> projectNames) {
        this.context = context;
        this.projectNames = projectNames;
    }

    private Context getContext() {
        return context;
    }

    //Involes inflating layout from xml and returning holder
    @Override
    public ProjectsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View projectView = inflater.inflate(R.layout.project_rows, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(projectView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(ProjectsAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        String proj = projectNames.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.projNameTextView;
        textView.setText(proj);
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return projectNames.size();
    }
}

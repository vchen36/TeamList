package com.teamlist.victor.teamlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewProjectActivity extends AppCompatActivity {

    private EditText mProjectNameView;
    private EditText mUsersView;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_project);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (toolbar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mProjectNameView = (EditText) findViewById(R.id.project_name);
        mUsersView = (EditText) findViewById(R.id.usernames);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        Button submitButton = (Button) findViewById(R.id.create_project);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit();
            }
        });
    }

    private void submit() {
        // Reset errors.
        mProjectNameView.setError(null);
        mUsersView.setError(null);


        // Store values at the time of the login attempt.
        String projectName = mProjectNameView.getText().toString();
        String users = mUsersView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(projectName)) {
            mProjectNameView.setError(getString(R.string.error_field_required));
            focusView = mProjectNameView;
            cancel = true;
        }

        // Check for valid users
        users.replaceAll("\\s+","");
        String[] usersArray = users.split(",");


        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
        }
    }
}

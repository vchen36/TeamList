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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NewProjectActivity extends AppCompatActivity {

    private EditText mProjectNameView;
    private EditText mUsersView;
    private Project newProj;
    private DatabaseReference mDatabase;
    private String currUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_project);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (toolbar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Bundle data = getIntent().getExtras();
        if (data != null) {
            currUser = data.getString("user");
        }

        newProj = new Project();

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

        users.replaceAll("\\s+", "");
        String[] usersArray = users.split(",");
        for (int i = 0; i < usersArray.length; i++) {
            String trimmed = usersArray[i].split("@")[0];
            if (mDatabase.child("users").child(trimmed) == null) {
                cancel = true;
                focusView = mUsersView;
                mUsersView.setError(getString(R.string.add_users_failed));
            }
        }


        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            newProj.setName(projectName);
            newProj.addUser(currUser);
            for (int i = 0; i < usersArray.length; i++) {
                newProj.addUser(usersArray[i].split("@")[0]);
            }
            mDatabase.child("projects")
            Intent i = new Intent(NewProjectActivity.this, ProjectsActivity.class);
            startActivity(i);
            finish();


        }
    }
}

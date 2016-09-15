package com.teamlist.victor.teamlist;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ProjectsActivity extends AppCompatActivity {

    private static final String TAG = "ProjectsActivity";

    private String user;
    private List<String> myProjects = new ArrayList<>();
    private ListView listView;
    private DatabaseReference mDatabase;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);

        //Get and save the user ID
        Bundle data = getIntent().getExtras();
        if (data != null) {
            user = data.getString("email");
        } else {
            user = FirebaseAuth.getInstance().getCurrentUser().getEmail().split("@")[0];
        }

        listView = (ListView)findViewById(R.id.project_listview);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ProjectsActivity.this, ViewProjectsActivity.class);
                intent.putExtra("selected", myProjects.get(i));
                startActivity(intent);
            }
        });

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("users").child(user).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                myProjects = new ArrayList<>(user.getmProjects().keySet());
                Log.d("SIZE OF PROJ", "" + myProjects.size());
                adapter = new ArrayAdapter<String>(ProjectsActivity.this, R.layout.project_rows, R.id.project_item, myProjects);
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d(TAG, "loadProjects:onCancelled", databaseError.toException());
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProjectsActivity.this, NewProjectActivity.class);
                i.putExtra("creator", user);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_projects, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                logout();
                break;
            case R.id.action_settings:
                //TODO: make settings page
                break;
            case R.id.sign_out:
                logout();
                break;
        }
        return (super.onOptionsItemSelected(item));
    }

    private void logout() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.logout_dialog)
                .setMessage("Are you sure you want to log out?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Intent i = new Intent(ProjectsActivity.this, Login.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        FirebaseAuth.getInstance().signOut();
                        startActivity(i);
                        finish();
                    }
                    })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}

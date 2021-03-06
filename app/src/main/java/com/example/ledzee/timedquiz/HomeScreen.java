package com.example.ledzee.timedquiz;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


public class HomeScreen extends ActionBarActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen_activity);
        initDrawerView();
        if (toolbar != null) {
            toolbar.setTitle("Contact Docket");
            setSupportActionBar(toolbar);
        }


        Button simpleModeButton;
        Button challengeModeButton;
        Button inviteFriends;


        challengeModeButton = (Button) findViewById(R.id.challegeModeButton);
        inviteFriends = (Button) findViewById(R.id.inviteFriendsbutton);
        simpleModeButton = (Button) findViewById(R.id.simpleModeButton);

        simpleModeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startSimpleMode = new Intent(HomeScreen.this, MainActivity.class);
                startActivity(startSimpleMode);
            }
        });


    }

    private void initDrawerView() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

package com.cricket.admin_2.cricketerdetails;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.cricket.admin_2.cricketerdetails.adapter.PlayerAdapter;
import com.cricket.admin_2.cricketerdetails.player.AddPlayer;
public class CricketActivity extends AppCompatActivity {
    private PlayerAdapter playerAdapter;
    private AddPlayer addPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cricket);
        ProgressBar pb=(ProgressBar)findViewById(R.id.progressBar2);
        pb.setVisibility(View.VISIBLE);
        ListView listView = findViewById(R.id.player_list);
        playerAdapter = new PlayerAdapter(getApplicationContext());
        listView.setAdapter(playerAdapter);
        addPlayer = new AddPlayer();
        addPlayer.getPlayerDetails(playerAdapter,pb);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add_cricketer_detail);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CricketActivity.this, AddPlayerActivity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cricket, menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
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

package com.cricket.admin_2.cricketerdetails;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.cricket.admin_2.cricketerdetails.player.AddPlayer;

public class AddPlayerActivity extends AppCompatActivity {
EditText playerName, jerseyNumber;
String playerType;
    AddPlayer addPlayer = new AddPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.
                activity_add_player);

        playerName = findViewById(R.id.player_name);
        jerseyNumber = findViewById(R.id.jersey_number);
        Button addPlayerButton = findViewById(R.id.add_player);
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                playerType = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        addPlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPlayer.addNewPlayer(playerName.getText().toString().trim(), Integer.parseInt(jerseyNumber.getText()
                        .toString().trim()),playerType);
                Toast.makeText(AddPlayerActivity.this, getString(R.string.Player_added), Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}

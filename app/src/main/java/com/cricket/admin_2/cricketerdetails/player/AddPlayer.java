package com.cricket.admin_2.cricketerdetails.player;

import android.service.autofill.Dataset;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;

import com.cricket.admin_2.cricketerdetails.adapter.PlayerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by admin_2 on 12/02/2018.
 */

public class AddPlayer {
    public static ArrayList<Player> players=new ArrayList<>();
    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;

    public void addNewPlayer(String playerName, int jereyNumber, String playerType) {
        final Player localplayer = new Player(playerName, jereyNumber, playerType);
        databaseReference = firebaseDatabase.getInstance().getReference("playerDetails");
        /*databaseReference.child("playerName").setValue(playerName);
        databaseReference.child("jereynumber").setValue(jereyNumber);*/
        String id = databaseReference.push().getKey();
        databaseReference.child(id).setValue(localplayer);
    }

    public void getPlayerDetails(PlayerAdapter playerAdapter, ProgressBar pb) {
        databaseReference = firebaseDatabase.getInstance().getReference("playerDetails");
        final PlayerAdapter adapterref=playerAdapter;
        final ProgressBar progressBar = pb;
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                players.clear();
                for(DataSnapshot refDataSnap : dataSnapshot.getChildren()) {
                    Player player = refDataSnap.getValue(Player.class);
                    players.add(player);
                }
                adapterref.notifyDataSetChanged();
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}

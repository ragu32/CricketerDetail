package com.cricket.admin_2.cricketerdetails.player;

import java.util.ArrayList;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by admin_2 on 12/02/2018.
 */

public class AddPlayer {
    public static ArrayList<Player> players=new ArrayList<>();
    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;

    public void addNewPlayer(String playerName, int jereyNumber, String playerType) {
        Player localplayer = new Player(playerName, jereyNumber, playerType);
        databaseReference = FirebaseDatabase.getInstance().getReference("https://cricketerdetails.firebaseio.com/playerlist");
        databaseReference.child("playerName").setValue(playerName);
        databaseReference.child("jereynumber").setValue(jereyNumber);
    }
}

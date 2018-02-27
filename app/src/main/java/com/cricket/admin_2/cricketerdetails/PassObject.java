package com.cricket.admin_2.cricketerdetails;

import android.view.View;

import com.cricket.admin_2.cricketerdetails.player.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin_2 on 26/02/2018.
 */

public class PassObject {
    View view;
    Player player;
    ArrayList<Player> srcList;

    PassObject(View v, Player i, ArrayList<Player> s) {
        view = v;
        player = i;
        srcList = s;
    }
}

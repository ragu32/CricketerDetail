package com.cricket.admin_2.cricketerdetails.adapter;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cricket.admin_2.cricketerdetails.AddPlayerActivity;
import com.cricket.admin_2.cricketerdetails.ItemOnDragListener;
import com.cricket.admin_2.cricketerdetails.PassObject;
import com.cricket.admin_2.cricketerdetails.player.AddPlayer;
import com.cricket.admin_2.cricketerdetails.player.Player;
import com.cricket.admin_2.cricketerdetails.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by admin_2 on 12/02/2018.
 */

public class PlayerAdapter extends ArrayAdapter<Player> {
    private ArrayList<Player> players = AddPlayer.players;
    private Context context;
    ViewHolder viewHolder;
    public PlayerAdapter(Context context, ArrayList<Player> players) {
        super(context, R.layout.player_add_in_listview);
        this.context = context;
    }
    public PlayerAdapter(Context context) {
        super(context, R.layout.player_add_in_listview);
        this.context = context;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.player_add_in_listview, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.playerName = convertView.findViewById(R.id.player_name);
            viewHolder.jerseyNumber = convertView.findViewById(R.id.jersey_number);
            viewHolder.playerType = convertView.findViewById(R.id.player_type);
            convertView.setTag(viewHolder);
            Log.v("Checking", "in getView method");
        }
        else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        final Player player = players.get(position);
        viewHolder.playerName.setText(player.getPlayerName());
        viewHolder.jerseyNumber.setText(player.getJerseyNumber()+"");
        if(player.getPlayerType().equals("Bowler")) {
            viewHolder.playerType.setImageDrawable(context.getDrawable(R.drawable.bowler));
        }
        else if(player.getPlayerType().equals("Batsman")) {
            viewHolder.playerType.setImageDrawable(context.getDrawable(R.drawable.batsman));
        }
        else {
            viewHolder.playerType.setImageDrawable(context.getDrawable(R.drawable.all_rounder));
        }

        convertView.setOnDragListener(new ItemOnDragListener(player, context));
        return convertView;
    }

    public int getCount() {
        return players.size();
    }

    public ArrayList<Player> getList() {
        return players;
    }

    static class ViewHolder {
        TextView playerName, jerseyNumber;
        ImageView playerType;
    }
}

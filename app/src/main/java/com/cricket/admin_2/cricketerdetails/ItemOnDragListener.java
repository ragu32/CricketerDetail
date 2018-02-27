package com.cricket.admin_2.cricketerdetails;

import android.content.Context;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cricket.admin_2.cricketerdetails.adapter.PlayerAdapter;
import com.cricket.admin_2.cricketerdetails.player.Player;

import java.util.ArrayList;

/**
 * Created by admin_2 on 24/02/2018.
 */

public class ItemOnDragListener implements OnDragListener {
    Player player;
    TextView playerName;
    int resumeColor;
    private Context context;
    public ItemOnDragListener(Player i, Context context){
        player = i;
        this.context=context;
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        switch (event.getAction()) {
            case DragEvent.ACTION_DRAG_STARTED:
                /*playerName.append("Item ACTION_DRAG_STARTED: " + "\n");*/
                break;
            case DragEvent.ACTION_DRAG_ENTERED:
                /*playerName.append("Item ACTION_DRAG_ENTERED: " + "\n");*/
                v.setBackgroundColor(0x30000000);
                break;
            case DragEvent.ACTION_DRAG_EXITED:
                /*playerName.append("Item ACTION_DRAG_EXITED: " + "\n");*/
                //v.setBackgroundColor(resumeColor);
                break;
            case DragEvent.ACTION_DROP:

                //playerName.append("Item ACTION_DROP: " + "\n");
                PassObject passObj = (PassObject)event.getLocalState();
                View view = passObj.view;
                Player passedItem = passObj.player;
                //Player passedItem = passObj.player;
                ArrayList<Player> srcList = passObj.srcList;
                ListView oldParent = (ListView)view.getParent();
                PlayerAdapter srcAdapter = (PlayerAdapter) (oldParent.getAdapter());

                ListView newParent = (ListView)v.getParent();
                PlayerAdapter destAdapter = (PlayerAdapter) (newParent.getAdapter());
                ArrayList<Player> destList = destAdapter.getList();

                int removeLocation = srcList.indexOf(passedItem);
                int insertLocation = destList.indexOf(player);
                Toast.makeText(context,Integer.toString(removeLocation)+" "+ Integer.toString(insertLocation),Toast.LENGTH_SHORT).show();
     /** If drag and drop on the same list, same position,
     * ignore*/

                if(srcList != destList || removeLocation != insertLocation){
                    if(removeItemToList(srcList, passedItem)){
                        destList.add(insertLocation, passedItem);
                    }
                    srcAdapter.notifyDataSetChanged();
                    destAdapter.notifyDataSetChanged();
                }

                //.setBackgroundColor(resumeColor);

                break;
            case DragEvent.ACTION_DRAG_ENDED:
                //playerName.append("Item ACTION_DRAG_ENDED: "  + "\n");
                //v.setBackgroundColor(resumeColor);
            default:
                break;
        }

        return true;
    }

    private boolean removeItemToList(ArrayList<Player> srcList, Player passedItem) {
        boolean result = srcList.remove(passedItem);
        return result;
    }

}

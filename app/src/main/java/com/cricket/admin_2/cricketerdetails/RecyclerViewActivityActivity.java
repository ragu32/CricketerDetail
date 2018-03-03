package com.cricket.admin_2.cricketerdetails;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.cricket.admin_2.cricketerdetails.adapter.CardViewAdapter;

public class RecyclerViewActivityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_activity);
        RecyclerView recyclerView = findViewById(R.id.card_List);
        CardViewAdapter cardViewAdapter = new CardViewAdapter(getApplicationContext());
        recyclerView.setAdapter(cardViewAdapter);

    }
}

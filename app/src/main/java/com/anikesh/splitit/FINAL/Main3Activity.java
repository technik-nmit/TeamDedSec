package com.anikesh.splitit.FINAL;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;


public class Main3Activity extends AppCompatActivity{

    //LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
    ArrayList<String> listItems=new ArrayList<String>();

    //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW
    ArrayAdapter<String> adapter;

    //RECORDING HOW MANY TIMES THE BUTTON HAS BEEN CLICKED
    int clickCounter=0;
    FirebaseDatabase DB;
    DatabaseReference DR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main3);
        DB = FirebaseDatabase.getInstance();
        DR = DB.getReference();
        adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);

        //setListAdapter(adapter);t
        ListView lv=(ListView)findViewById(R.id.list);
        lv.setAdapter(adapter);

        DR.child("Trip").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for(DataSnapshot child : children)
                {
                    listItems.add(child.getKey().toString()+" : "+child.getValue().toString());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        FloatingActionButton floatingActionButton;
        floatingActionButton = (FloatingActionButton)findViewById(R.id.floatingActionButton);


        ObjectClass o = (ObjectClass)getIntent().getSerializableExtra("key");
        TextView src,dest,std,find;
        src=(TextView)findViewById(R.id.sourceTV);
        dest=(TextView)findViewById(R.id.destTV);
        std=(TextView)findViewById(R.id.startTV);
        find=(TextView)findViewById(R.id.finTV);
        src.setText(o.source_obj);
        dest.setText(o.dest_obj);
        std.setText(o.st_obj);
        find.setText(o.fin_obj);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main3Activity.this,Main4Activity.class);
                startActivity(intent);


            }
        });

    }
   /* //METHOD WHICH WILL HANDLE DYNAMIC INSERTION

    public void addItems(View v) {
        listItems.add("Clicked : "+clickCounter++);
        adapter.notifyDataSetChanged();
    */
    }




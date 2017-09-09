package com.anikesh.splititmatrix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    int[][] split2 = new int[5][5];
    int[] spent2 = new int[5];
    String[][] splitStr = new String[5][5];
    String[] spentStr = new String[5];
    DatabaseReference myRef;
    List arList = new ArrayList<String>();
    String[] in = {"one","two","three","four","five"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Firebase mref = new Firebase("https://splititone.firebaseio.com/");

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        //DatabaseReference myRef;
        //List arList = new ArrayList<String>(Arrays.asList(arry));
        //myRef.setValue(arList);
        //Map<String, Double> map = new HashMap<String, Double>();
        final String[] indexStr = {"A","B","C","D","E"};
        for(int i=0;i<5;i++) {
            spent2[i]=0;
            for (int j = 0; j < 5; j++) {
                split2[i][j] = i * j;
                //map.put((indexStr[i]+indexStr[j]),1.0);
                //splitStr[i][j]=Integer.toString(split2[i][j]);
            }
        }
        Map<String, Object> mapM = new HashMap<String,Object>();
        Double[] test = {1.0,2.0,3.0,4.0,5.0};
        Matrix mat = new Matrix(split2, spent2);
        Arrayonly newarr = new Arrayonly(spent2);
        mapM.put("test1", mat);
        myRef=database.getReference("MATRIX3");
        //myRef.setValue(newarr);
        //myRef.setValue(mapM);
        //String[] in = {"one","two","three","four","five"};
        /*for(int i=0;i<5;i++) {
            myRef=database.getReference("array/"+in[i]);
            arList=Arrays.asList(splitStr[i]);
            myRef.setValue(arList);
        }*/
        final Map<String, Double> map2 = new HashMap<String, Double>();
        myRef.child("MATRIX3").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                /*Map map = dataSnapshot.getValue(Map.class);
                for(int i=0;i<5;i++)
                    for(int j=0;j<5;j++)
                        Log.d("OUT", map.get("AB").toString());*/
                //Iterator<DataSnapshot> children = dataSnapshot.getChildren();
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    Map mapv = postSnapshot.getValue(Map.class);
                    //map2.put(mapv.get)
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
        /*Map<String, Double> map2 = new HashMap<String, Double>();
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map map2 = dataSnapshot.getValue(Map.class);
                //for(int i=0;i<5;i++)
                 //   for(int j=0;j<5;j++)
                  //      Log.d("OUT", map2.get(indexStr[i]+indexStr[j]).toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("OUT", "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };
        myRef.addValueEventListener(postListener);*/













    }
}

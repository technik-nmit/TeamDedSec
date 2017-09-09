package com.anikesh.splitit.FINAL;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main4Activity extends AppCompatActivity {

   // EditText UN;
    FirebaseDatabase database, DB;
    DatabaseReference myRef, DR;
    Float cred;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        final EditText actPay,supPay,num;
        Button update;
        actPay = (EditText)findViewById(R.id.actPay);
        num = (EditText)findViewById(R.id.num);
        supPay = (EditText)findViewById(R.id.supPay);
        update = (Button)findViewById(R.id.update);

        String ACT,SUP;
        ACT = actPay.getText().toString();
        SUP = supPay.getText().toString();
        database = FirebaseDatabase.getInstance();
        DB = FirebaseDatabase.getInstance();
        DR = DB.getReference();

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //update matrix;
                cred = Float.valueOf(0);
                if(!actPay.getText().toString().isEmpty() && !supPay.getText().toString().isEmpty())
                {
                    myRef = database.getReference("Trip");
                    DR.child("Trip").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                            for(DataSnapshot child:children)
                            {
                                if(child.getKey().toString()==num.getText().toString())
                                {
                                    cred = Float.valueOf(child.getValue().toString());
                                    Toast.makeText(Main4Activity.this, "Key found", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                cred += (new Float(supPay.getText().toString()).floatValue())-(new Float(actPay.getText().toString()).floatValue());
                myRef.child(num.getText().toString()).setValue(cred);
                Toast.makeText(Main4Activity.this, "Updated successfully", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}

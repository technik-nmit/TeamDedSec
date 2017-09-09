package com.anikesh.splitit.FINAL;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;




public class Main2Activity extends AppCompatActivity{

    EditText source, dest, st, fin;
    ObjectClass o = new ObjectClass();
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //Intent intent = getIntent();

        source = (EditText) findViewById(R.id.sourceET);
        dest = (EditText) findViewById(R.id.destET);
        st = (EditText) findViewById(R.id.st_dateET);
        fin = (EditText) findViewById(R.id.fin_dateET);


        submit = (Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                o.source_obj=source.getText().toString();
                o.dest_obj=dest.getText().toString();
                o.st_obj=st.getText().toString();
                o.fin_obj=fin.getText().toString();
                //Toast.makeText(Main2Activity.this, "This is the first worst", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(Main2Activity.this,Main3Activity.class);
                //Toast.makeText(Main2Activity.this, "This is the worst", Toast.LENGTH_LONG).show();
                intent.putExtra("key",o);
                startActivity(intent);
            }
        });
    }
}

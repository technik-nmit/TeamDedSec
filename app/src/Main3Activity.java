package com.example.chirag.createtrip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;

public class Main3Activity extends AppCompatActivity implements Serializable{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

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


    }
}

package com.example.kashyap.loginscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText UN, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UN = (EditText) findViewById(R.id.UN);
        pass = (EditText) findViewById(R.id.pass);
    }
    authcred loginObject;
    public void login(View view) {

    }

    public void register(View view) {
        FirebaseDatabase DB = FirebaseDatabase.getInstance();
        DatabaseReference ref = DB.getReference("Auth");
        if(!UN.getText().toString().isEmpty() || !pass.getText().toString().isEmpty())
        {
            loginObject.getdata(UN.getText().toString(),pass.getText().toString());
            ref.setValue(loginObject);

        }
        else
            Toast.makeText(this, "No data entered", Toast.LENGTH_SHORT).show();
    }
}

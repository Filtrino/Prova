package com.example.alessio.primaapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


public class MainActivity extends AppCompatActivity {

    TextView mostra;
    EditText editNome;
    EditText editCognome;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");  // serve per ipostare l id dell elemento


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button invio = (Button)findViewById(R.id.bottone);
        mostra =(TextView)findViewById(R.id.textViewMostra);
        editNome = (EditText)findViewById(R.id.editTextNome);
        editCognome =(EditText)findViewById(R.id.editTextCognome);

        invio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nome;
                String cognome;

                nome = editNome.getText().toString();
                cognome=editCognome.getText().toString();
                mostra.setText(nome+cognome);

                myRef.setValue(mostra.getText().toString());




            }
        });



    }




    }


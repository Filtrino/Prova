package com.example.alessio.primaapp;


import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FirstWindow extends AppCompatActivity {

    FragmentManager fragmentManager ;
    Registrati registrati;
    Button bReg;
    Button bEntra;
    String TAG = "hola";
    TypeWriter typeWriter ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_window);
        MediaPlayer mediaPlayer = MediaPlayer.create(FirstWindow.this,R.raw.hodor); // ricoda di creare la cartella raw  e metterci l mp3


      //  mediaPlayer.start();
        //mediaPlayer.setLooping(true);


        fragmentManager = getSupportFragmentManager();
        registrati = new Registrati();



        ImageView migliore = (ImageView)findViewById(R.id.imageViewMigliore);
        migliore.setImageResource(R.drawable.migliore);
        bEntra = (Button)findViewById(R.id.entra);
        bReg =(Button) findViewById(R.id.registrati);
        typeWriter = findViewById(R.id.textView);

        typeWriter.setText("");
        typeWriter.setCharacterDelay(150);
        typeWriter.animateText("C'e solo un migliore");

        bReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                registrati.show(fragmentManager,"we");

            }
        });




    }
}

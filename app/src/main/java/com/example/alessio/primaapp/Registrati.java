package com.example.alessio.primaapp;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 *
 *
 */

 class  Persona {
    String nome;
    String cognome ;
    String email;
    String password;

}



public class Registrati extends DialogFragment {

    String EmailPasswordActivity ;
     FirebaseAuth mAuth;
    TextView nome ;
    TextView cognome;
    TextView email;
    TextView password; 
    Button inoltra;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("IdPersona");  // serve per ipostare l id dell elemento
    FirebaseAuth.AuthStateListener mAuthListener;





    public Registrati() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_registrati, container, false); // devo mettere sta roba senno


        nome = view.findViewById(R.id.Rnome);
        cognome =(TextView)view.findViewById(R.id.Rcognome);
        email =(TextView)view.findViewById(R.id.Remail);
        password =(TextView)view.findViewById(R.id.Rpassword);
        inoltra=(Button)view.findViewById(R.id.Rinoltra);

        mAuth = FirebaseAuth.getInstance();



        inoltra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Sucesso", Toast.LENGTH_SHORT).show();
                Persona utente = new Persona();
                utente.nome =nome.getText().toString();
                utente.cognome = cognome.getText().toString();
                utente.email= email.getText().toString();
                utente.password =password.getText().toString();




                mAuth.createUserWithEmailAndPassword(email.getText().toString(), "asdasdasdasd")
                        .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(getActivity(), R.string.auth_failed,
                                            Toast.LENGTH_SHORT).show();
                                }

                                // ...
                            }
                        });


            }
        });



        return view;


        // Inflate the layout for this fragment

    }


}

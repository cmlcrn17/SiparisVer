package com.cerenerdem.siparisver;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    EditText eposta;
    EditText sifre;

    FirebaseAuth mAuth_KullaniciYoneticisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eposta = (EditText) findViewById(R.id.edt_eposta);
        sifre = (EditText) findViewById(R.id.edt_sifre);

        mAuth_KullaniciYoneticisi = FirebaseAuth.getInstance();

        FirebaseUser user = mAuth_KullaniciYoneticisi.getCurrentUser();

        if (user != null){

            Intent int_GirisSayfasi = new Intent(getApplicationContext(), GirisSayfasi.class);
            startActivity(int_GirisSayfasi);

        }
    }


    public void UyeKaydet(View view) {

        mAuth_KullaniciYoneticisi.createUserWithEmailAndPassword(eposta.getText().toString(), sifre.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {

                    Toast.makeText(MainActivity.this, "Kullanıcı Oluşturuldu.", Toast.LENGTH_SHORT).show();
                    Intent int_GirisSayfasi = new Intent(getApplicationContext(), GirisSayfasi.class);
                    startActivity(int_GirisSayfasi);

                }

            }
        }).addOnFailureListener(this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    public void OturumAc(View view) {

        mAuth_KullaniciYoneticisi.signInWithEmailAndPassword(eposta.getText().toString(), sifre.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    Intent int_GirisSayfasi = new Intent(getApplicationContext(), GirisSayfasi.class);
                    startActivity(int_GirisSayfasi);

                }
            }
        }).addOnFailureListener(this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}

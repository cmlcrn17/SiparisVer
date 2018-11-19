package com.cerenerdem.siparisver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class SiparisVer extends AppCompatActivity {

    String secilenurun = "";

    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;
    DatabaseReference dbRef;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siparis_ver);

        Spinner spn_urun = (Spinner) findViewById(R.id.spn_urunler);

        firebaseDatabase = FirebaseDatabase.getInstance();
        myRef = firebaseDatabase.getReference();
        mAuth = FirebaseAuth.getInstance();


        spn_urun.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String seciliOgeMetni = (String) parent.getItemAtPosition(position);
                secilenurun =  seciliOgeMetni;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    public void SiparisKaydet(View view){

        UUID uuid = UUID.randomUUID();
        String uuid_metni = uuid.toString();

        FirebaseUser kullanici = mAuth.getCurrentUser();

        String fkullanici,fsecilenurun;
        fkullanici = kullanici.getEmail();
        fsecilenurun = secilenurun.toString();

        myRef.child("Siparis").child(uuid_metni).child("kullaniciemail").setValue(fkullanici);
        myRef.child("Siparis").child(uuid_metni).child("secilenurun").setValue(fsecilenurun);


        Toast.makeText(SiparisVer.this, "Sipariş Oluşturuldu.", Toast.LENGTH_SHORT).show();
    }
}

package com.cerenerdem.siparisver;

import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SiparisListele extends AppCompatActivity {

    ListView lstsiparisler;
    ArrayList<ModelSiparisListele> siparisler;
    ListAdapter listAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siparis_listele);

        siparisler = new ArrayList<>();
        lstsiparisler = (ListView) findViewById(R.id.lst_siparisler);
        lstsiparisler.setAdapter(listAdapter);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        myRef.child("Siparis").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    ModelSiparisListele siparis = snapshot.getValue(ModelSiparisListele.class);
                    siparisler.add(
                            new ModelSiparisListele(
                                    siparis.getKullaniciemail(),
                                    siparis.getSecilenurun()
                            )
                    );
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {}

        });

    }
}

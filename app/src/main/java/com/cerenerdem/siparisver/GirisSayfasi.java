package com.cerenerdem.siparisver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GirisSayfasi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_sayfasi);

    }



    public void SiparisVer(View view){

        Intent int_SiparisVer = new Intent(getApplicationContext(), SiparisVer.class);
        startActivity(int_SiparisVer);

    }


    public void SiparisListele(View view){

        Intent int_SiparisListele= new Intent(getApplicationContext(), SiparisListele.class);
        startActivity(int_SiparisListele);

    }
}

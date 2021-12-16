package com.hakanerdogmus.storingdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText yasGir;
    TextView yasGöster;
    SharedPreferences depo;
    int yas;
    int kaydedilenYas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yasGir=findViewById(R.id.yasGir);
        yasGöster=findViewById(R.id.yasGöster);

        depo = this.getSharedPreferences("com.hakanerdogmus.storingdata", Context.MODE_PRIVATE);

         kaydedilenYas = depo.getInt("kaydedilenYas",0);

        if(kaydedilenYas == 0){
            yasGöster.setText("Senin Yaşın:");
        }
        else {
            yasGöster.setText("Senin Yaşın: " + kaydedilenYas);
        }


    }


    public void kaydet(View view){
        if(!yasGir.getText().toString().matches("")){
            yas=Integer.parseInt(yasGir.getText().toString());
            yasGöster.setText("Senin Yaşın: " + yas);
        }
        depo.edit().putInt("kaydedilenYas", yas).apply();

            }

    //veri silmek için kendim yazdığım kısım emin değilim.
    public void  sil (View view){
        kaydedilenYas = 0 ;
        yasGöster.setText("Senin Yaşın: ");
        depo.edit().putInt("kaydedilenYas",kaydedilenYas).apply();
    }

}
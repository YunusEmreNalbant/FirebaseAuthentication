package com.yunus.dizifilmapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText kullaniciadiText, sifreText;
    Button girisyap,kayitol;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kullaniciadiText = findViewById(R.id.emailtext);
        sifreText = findViewById(R.id.sifretext);
        girisyap = findViewById(R.id.girisyap);
        kayitol = findViewById(R.id.kayitol);
        mAuth = FirebaseAuth.getInstance();


    }


    public void girisyap(View view) {

        mAuth.signInWithEmailAndPassword(kullaniciadiText.getText().toString(),sifreText.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {


                    Toast.makeText(MainActivity.this, "Giriş başarılı... ", Toast.LENGTH_LONG).show();


                }else {
                    Toast.makeText(MainActivity.this, "Giriş başarısız... Bilgilerinizi lütfen kontrol edin...", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void kayitol(View view) {
        mAuth.createUserWithEmailAndPassword(kullaniciadiText.getText().toString(),sifreText.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {

                    Toast.makeText(MainActivity.this, "Kayıt başarılı! Şimdi giriş yapabilirsin...", Toast.LENGTH_LONG).show();



                }else {
                    Toast.makeText(MainActivity.this, "Böyle bir kayıt zaten var... Lütfen bilgilerinizi tekrar kontrol edin...", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}

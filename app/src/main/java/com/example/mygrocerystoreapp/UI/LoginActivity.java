package com.example.mygrocerystoreapp.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mygrocerystoreapp.R;
import com.example.mygrocerystoreapp.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_login);
    }

    public void Login(View view) {
        String email = binding.etEmail.getText().toString();
        if (email.isEmpty()) {
            Toast.makeText(LoginActivity.this, "email required", Toast.LENGTH_SHORT).show();
            return;
        }
        String password = binding.etPassword.getText().toString();
        if (password.isEmpty()) {
            Toast.makeText(LoginActivity.this, "password required", Toast.LENGTH_SHORT).show();
            return;
        }
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                   intent=new Intent(LoginActivity.this,MainActivity.class);
                   startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, "You must Make Account", Toast.LENGTH_SHORT).show();

                }

            }
        });


    }
    public void Register (View view){
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
}
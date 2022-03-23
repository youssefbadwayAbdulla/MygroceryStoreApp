package com.example.mygrocerystoreapp.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mygrocerystoreapp.R;
import com.example.mygrocerystoreapp.databinding.ActivityRegisterBinding;
import com.example.mygrocerystoreapp.model.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    private static final String TAG = "Register";
    ActivityRegisterBinding binding;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    StorageReference storageReference = FirebaseStorage.getInstance().getReference();
    FirebaseFirestore fireStore = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void Register(View view) {
        String name = binding.etRegisterName.getText().toString();
        if (name.isEmpty()) {
            Toast.makeText(RegisterActivity.this, "Name required", Toast.LENGTH_SHORT).show();
        }

        String phone = binding.etRegisterPhone.getText().toString();
        if (phone.isEmpty()) {
            Toast.makeText(RegisterActivity.this, "Phone required", Toast.LENGTH_SHORT).show();
        }

        String email = binding.etRegisterEmail.getText().toString();
        if (email.isEmpty()) {
            Toast.makeText(RegisterActivity.this, "email required", Toast.LENGTH_SHORT).show();
        }
        String password = binding.etRegisterPassword.getText().toString();
        if (password.isEmpty()) {
            Toast.makeText(RegisterActivity.this, "password required", Toast.LENGTH_SHORT).show();
        }
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(authResult -> {
           // SaveUserDataOnFirebase(name, phone, email);
           // firebaseAuth.signOut();
            finish();

        }).addOnFailureListener(e -> {
            String errorMessage = e.getLocalizedMessage();
            Toast.makeText(RegisterActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
        });


    }

//    private void SaveUserDataOnFirebase(String name, String phone, String email) {
//        Map<String, Object> user = new HashMap<>();
//        user.put("name", name);
//        user.put("phone", phone);
//        user.put("email", email);
//        fireStore.collection("Users").document(firebaseAuth.getCurrentUser().getUid())
//                .set(user).addOnSuccessListener(unused -> {
//            Toast.makeText(RegisterActivity.this, "Account created", Toast.LENGTH_SHORT).show();
//                }).addOnFailureListener(e -> {
//            String errorMessage = e.getLocalizedMessage();
//            Toast.makeText(RegisterActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
//                });
//
//    }
}
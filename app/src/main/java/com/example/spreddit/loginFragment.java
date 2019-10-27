package com.example.spreddit;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class loginFragment extends Fragment {
    private FirebaseAuth firebaseAuth;
    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        firebaseAuth = FirebaseAuth.getInstance();
        Button button =view.findViewById(R.id.loginButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(v);
            }
        });
        return view;
    }

    public void login(View view){
        EditText editEmail = getActivity().findViewById(R.id.editEmail);
        EditText pass = getActivity().findViewById(R.id.editPassword);
        String email = editEmail.getText().toString().trim();
        String password = pass.getText().toString().trim();

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent mainActivity = new Intent(getActivity(), MainActivity.class);
                            startActivity(mainActivity);
                        }
                        else{
                            Toast.makeText(getActivity(), "Enter valid credentials.", Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }
}
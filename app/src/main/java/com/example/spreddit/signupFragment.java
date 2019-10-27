package com.example.spreddit;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
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


public class signupFragment extends Fragment {

    private FirebaseAuth firebaseAuth;
    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        firebaseAuth = FirebaseAuth.getInstance();
        Button button = view.findViewById(R.id.signupButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register(v);
            }
        });

        return view;
    }

    public void register(View view){
        EditText editEmail = getActivity().findViewById(R.id.signEmail);
        EditText pass1 = getActivity().findViewById(R.id.signPassword);
        EditText pass2 = getActivity().findViewById(R.id.signPassword2);
        String email = editEmail.getText().toString().trim();
        String password1 = pass1.getText().toString().trim();
        String password2 = pass2.getText().toString().trim();
        if(TextUtils.isEmpty(email)){
            Toast.makeText(view.getContext(), "Enter email address", Toast.LENGTH_LONG).show();
            return;
        }
//        TODO: add ccndiiton to check email
        if(TextUtils.isEmpty(password1)){
            Toast.makeText(view.getContext(), "Enter valid password", Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(password2)){
            Toast.makeText(view.getContext(), "Enter valid password", Toast.LENGTH_LONG).show();
            return;
        }
        if(!password1.equals(password2)){
            Toast.makeText(view.getContext(), "Password fields should match", Toast.LENGTH_LONG).show();
            return;
        }
        firebaseAuth.createUserWithEmailAndPassword(email, password1)
            .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Intent mainActivity = new Intent(getActivity(), MainActivity.class);
                        startActivity(mainActivity);
                    }
                    else {
                        Toast.makeText(getActivity(),"Sign up failed",Toast.LENGTH_LONG).show();
                    }
                }
        });
    }
}
package com.example.midyear;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Fragment001 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_001, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setButton(view);
    }

    public void setButton(View view) {
        Button button = view.findViewById(R.id.button);
        EditText username = view.findViewById(R.id.usernameInput);
        EditText password = view.findViewById(R.id.passwordInput);
        TextView resultTv = view.findViewById(R.id.resultId);

        button.setOnClickListener(v -> {
            String passwordText = password.getText().toString();
            String usernameText = username.getText().toString();
            if (passwordText.equals("123456") && usernameText.equals("admin")) {
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentContainerView2, new Fragment002());
                transaction.commit();
            } else {
                resultTv.setText("login failed. password was incorrect.");
            }
        });
    }

}
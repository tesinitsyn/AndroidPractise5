package com.example.androidpractise5.UI.views;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.androidpractise5.R;
import com.example.androidpractise5.UI.viewModels.RegistrationViewModels;
import com.google.android.material.textfield.TextInputEditText;

import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;


public class Registration extends Fragment {


    public Registration() {
        // Required empty public constructor
    }

    public static Registration newInstance() {
        Registration fragment = new Registration();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //appSpecificStorage
        try {
            String filename = "appSpecificStorage";
            File file = new File(getActivity().getFilesDir() + filename);
            Log.d(filename, String.valueOf(file.createNewFile()));
            file.delete();
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        TextInputEditText name = view.findViewById(R.id.Name);
        TextInputEditText surname = view.findViewById(R.id.surname);
        TextInputEditText email = view.findViewById(R.id.email);

        Button submit = view.findViewById(R.id.submit_button);

        submit.setOnClickListener(v ->{
            Bundle profileInfo = new Bundle();
            profileInfo.putString("name", Objects.requireNonNull(name.getText()).toString());
            profileInfo.putString("surname", Objects.requireNonNull(surname.getText()).toString());
            profileInfo.putString("email", Objects.requireNonNull(email.getText()).toString());
            Navigation.findNavController(view).navigate(R.id.action_registration_to_profile, profileInfo);
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        RegistrationViewModels model = new ViewModelProvider(this).get(RegistrationViewModels.class);
        model.getUsers().observe(getViewLifecycleOwner(), (value) -> {
        });
    }
}
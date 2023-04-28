package com.example.androidpractise5.UI.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.androidpractise5.data.repositories.UserRepository;
import com.example.androidpractise5.data.models.User;

import java.util.List;

public class RegistrationViewModels extends androidx.lifecycle.ViewModel {
    private UserRepository userRepository;
    private LiveData<List<User>> users;

    public LiveData<List<User>> getUsers() {
        return users;
    }
//    public void addUser(String email, String password, String name, String surname) {
//        mItems.setValue(
//        );
}
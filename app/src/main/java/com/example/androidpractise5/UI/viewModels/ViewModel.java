package com.example.androidpractise5.UI.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.androidpractise5.data.Repository;
import com.example.androidpractise5.data.dataSourceRepository.User;

public class ViewModel extends androidx.lifecycle.ViewModel {
    private final MutableLiveData<Repository> userID = new MutableLiveData(new Repository(
            new User(null, null, null, null)));

    public LiveData<Repository> getUserID(){
        return userID
    }

    public void addUser(String email, String password, String name, String surname){
        userID.setValue(
                new Repository(new User(email, password, name, surname))
        );
    }
}

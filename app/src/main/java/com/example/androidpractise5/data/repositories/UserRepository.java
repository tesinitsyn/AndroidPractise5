package com.example.androidpractise5.data.repositories;

import androidx.lifecycle.LiveData;

import com.example.androidpractise5.data.DataSource.UsersDataSource;
import com.example.androidpractise5.data.models.User;

import java.util.List;

public class UserRepository {

    private UsersDataSource usersDataSource;
    private User user;
    public UserRepository(User user) {
        this.user = user;
    }

    public LiveData<List<User>> getUser() {
        return usersDataSource.items();
    }

    public void setUser(User user) {
        this.user = user;
    }


}

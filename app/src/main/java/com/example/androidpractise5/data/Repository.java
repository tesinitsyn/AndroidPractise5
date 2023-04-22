package com.example.androidpractise5.data;

import com.example.androidpractise5.data.dataSourceRepository.User;

public class Repository {
    private User user

    public Repository(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

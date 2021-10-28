package com.intro.programming;

import com.intro.programming.data.AdminModel;
import com.intro.programming.data.CustomerModel;
import com.intro.programming.data.DataStore;
import com.intro.programming.data.UserModel;

public class UserAuth {
    private final DataStore dataStore;
    private UserModel userSession;

    public UserAuth(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    public void setSession(UserModel userData) {
        this.userSession = userData;
    }

    public UserModel getUserSession() {
        return userSession;
    }

    public boolean isCorrectUser(UserModel userData) {
        return dataStore.getUserList()
                .stream()
                .anyMatch(user -> user.getUsername().equals(userData.getUsername())
                        && user.getPassword().equals(userData.getPassword())
                );
    }

    public boolean isAdmin(UserModel userData) {
        if (!isCorrectUser(userData))
            return false;

        return dataStore.findUserByUserName(userData.getUsername()) instanceof AdminModel;
    }

    public boolean isCustomer(UserModel userData) {
        if (!isCorrectUser(userData))
            return false;

        return dataStore.findUserByUserName(userData.getUsername()) instanceof CustomerModel;
    }
}

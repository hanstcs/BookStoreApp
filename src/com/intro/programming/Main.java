package com.intro.programming;

import com.intro.programming.data.DataStore;

public class Main {

    public static void main(String[] args) {
        DataStore dataStore = new DataStore();
        Presenter presenter = new Presenter(new View(), dataStore, new UserAuth(dataStore));
        presenter.showLandingPage();
    }
}

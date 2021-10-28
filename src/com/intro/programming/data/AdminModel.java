package com.intro.programming.data;

public class AdminModel extends UserModel {
    private final String nik;

    public AdminModel(String username, String password, String nik) {
        super(username, password);
        this.nik = nik;
    }

    public String getNik() {
        return nik;
    }
}

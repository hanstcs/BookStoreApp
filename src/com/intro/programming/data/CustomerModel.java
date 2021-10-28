package com.intro.programming.data;

public class CustomerModel extends UserModel {
    private final String name;
    private final String phoneNum;

    public CustomerModel(String username, String password, String name, String phoneNum) {
        super(username, password);
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }
}

package com.example.contactbook.model;

import androidx.annotation.NonNull;

public class Contact {
    private final String name;
    private final String email;
    private final String phone;

    public Contact(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}

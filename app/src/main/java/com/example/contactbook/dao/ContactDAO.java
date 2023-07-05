package com.example.contactbook.dao;

import com.example.contactbook.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactDAO {
    private final static List<Contact> contacts = new ArrayList<>();

    public void save(Contact contact) {
        contacts.add(contact);
    }

    public List<Contact> getContacts() {
        return new ArrayList<>(contacts);
    }
}

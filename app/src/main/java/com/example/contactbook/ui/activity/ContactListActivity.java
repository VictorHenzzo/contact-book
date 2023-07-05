package com.example.contactbook.ui.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.contactbook.R;
import com.example.contactbook.dao.ContactDAO;

public class ContactList extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        setTitle("Contact Book");

        ContactDAO contactDAO = new ContactDAO();
        ListView contactList = findViewById(R.id.activity_contact_list_view);
        contactList.setAdapter(
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1,
                        contactDAO.getContacts())
        );
    }
}

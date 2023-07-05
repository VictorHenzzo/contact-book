package com.example.contactbook.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.contactbook.R;
import com.example.contactbook.dao.ContactDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ContactListActivity extends AppCompatActivity {
    private final ContactDAO contactDAO = new ContactDAO();
    private static final String APP_BAR_TITLE = "Contact Book";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        setTitle(APP_BAR_TITLE);
        configureFabAction();
    }

    private void configureFabAction() {
        FloatingActionButton fab = findViewById(R.id.activity_contact_list_fab_new_contact);
        fab.setOnClickListener(view -> startActivity(
                new Intent(
                        ContactListActivity.this,
                        NewContactFormActivity.class
                )));
    }

    @Override
    protected void onResume() {
        super.onResume();
        buildContactList();
    }

    private void buildContactList() {
        ListView contactList = findViewById(R.id.activity_contact_list_view);
        contactList.setAdapter(
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_list_item_1,
                        contactDAO.getContacts()
                )
        );
    }
}

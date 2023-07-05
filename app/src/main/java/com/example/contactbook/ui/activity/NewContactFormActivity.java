package com.example.contactbook.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.contactbook.R;
import com.example.contactbook.dao.ContactDAO;
import com.example.contactbook.model.Contact;

public class NewContactFormActivity extends AppCompatActivity {
    private static final String APP_BAR_TITLE = "New contact";
    private EditText nameController;
    private EditText emailController;
    private EditText phoneController;
    final private ContactDAO dao = new ContactDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact_form);

        setTitle(APP_BAR_TITLE);
        configureOnSave();
    }


    private void configureOnSave(){
        initializeControllers();

        Button saveContactButton = findViewById(R.id.activity_new_contact_form_confirm_button);
        saveContactButton.setOnClickListener(
                view -> {
                    Contact newContact = createContact();
                    saveContact(newContact);
                    finish();
                }
        );
    }

    private void initializeControllers() {
        nameController = findViewById(R.id.activity_new_contact_form_name);
        emailController = findViewById(R.id.activity_new_contact_form_email);
        phoneController = findViewById(R.id.activity_new_contact_form_phone);
    }

    @NonNull
    private Contact createContact() {
        String name = nameController.getText().toString();
        String email = emailController.getText().toString();
        String phone = phoneController.getText().toString();

        return new Contact(name,email,phone);
    }

    private void saveContact(Contact contact) {
        dao.save(contact);
    }
}
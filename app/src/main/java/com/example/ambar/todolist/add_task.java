package com.example.ambar.todolist;

/**
 * Created by Ambar on 11/19/2016.
 */

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.EditText;


public class add_task extends AppCompatActivity {
    Intent lastIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_layout);

        lastIntent = getIntent();

    }

    public void onSendNewTaskName(View view) {

        EditText newNameET = (EditText) findViewById(R.id.kata);
        String newName = String.valueOf(newNameET.getText());

        Intent goBack = new Intent();
        goBack.putExtra("New Name",newName);
        setResult(RESULT_OK, goBack);

        finish();
    }
}
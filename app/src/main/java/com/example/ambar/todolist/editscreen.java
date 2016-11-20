package com.example.ambar.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Ambar on 11/19/2016.
 */

public class editscreen extends AppCompatActivity {
    Intent lastIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.edit_layout);

        lastIntent = getIntent();

        EditText newNameET = (EditText) findViewById(R.id.kata);
        newNameET.setText(lastIntent.getExtras().getString("Name of ToDoList"));

    }

    public void onSendNewTaskName(View view) {

        EditText newNameET = (EditText) findViewById(R.id.kata);
        String newName = String.valueOf(newNameET.getText());

        int index = lastIntent.getExtras().getInt("Index of ToDoList");

        Intent goBack = new Intent();
        goBack.putExtra("New Name",newName);
        goBack.putExtra("Index of ToDoList",index);
        setResult(RESULT_OK, goBack);

        finish();
    }
}

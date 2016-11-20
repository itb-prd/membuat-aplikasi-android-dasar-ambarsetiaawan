package com.example.ambar.todolist;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ArrayList<String> ui = new ArrayList<String>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent getNewNameIntent = new Intent(view.getContext(), add_task.class);
                final int result = 2;

                startActivityForResult(getNewNameIntent, result);
            }
        });
        displ(); // Menampilkan todo list di listview
    }

    public void displ() {

        ListAdapter abc =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ui);
        ListView unk =(ListView) findViewById(R.id.list);
        unk =(ListView) findViewById(R.id.ToDoListView);
        unk.setAdapter(abc);

        unk.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int place, long id) {
                DialogFragment newFragment = edit.newInstance(place,ui.get(place));
                newFragment.show(getFragmentManager(),"dialog");
                displ();

            }
        }) ;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Menambahkan item ke bar
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Saat bar di klik pada bagian ini akan
        // secara otomatis mengklik Home/Up button
        // yang secara spesifik menentukan kegiatan di AndroidManifest.xml
        int id = item.getItemId();

        //Pernyataan untuk noinspection
        if (id == R.id.setting) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && data != null) {
            // Mengedit Kegiatan
            int index = data.getExtras().getInt("Index of ToDoList");

            String newToDo =data.getExtras().getString("New Name");
            ui.set(index, newToDo);

        } else if (requestCode == 2 && data != null) {
            // Menambah kegiatan baru
            String newToDo = data.getExtras().getString("New Name");
            ui.add(newToDo);

        } else if (requestCode == 3 && data != null) {
            // Menghapus kegiatan yang ada
            ui.remove(data.getExtras().getInt("Index of ToDoList"));
        }
        displ(); // Mengupdate isi List


    }
}
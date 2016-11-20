package com.example.ambar.todolist;

/**
 * Created by Ambar on 11/19/2016.
 */

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;

public class edit extends DialogFragment {
    int mNum;
    String mName;

    static edit newInstance(int num, String name) {
        edit f = new edit();

        Bundle args = new Bundle();
        args.putInt("num",num);
        args.putString("name",name);

        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mNum = getArguments().getInt("num");
        mName = getArguments().getString("name");

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setMessage(Html.fromHtml("Apa yang akan Anda lakukan dengan <b>'"+mName+"'</b> ?"))
                .setPositiveButton("UBAH",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent getNewNameIntent = new Intent(getActivity(), editscreen.class);
                        final int result = 1;
                        getNewNameIntent.putExtra("Index of ToDoList", mNum);
                        getNewNameIntent.putExtra("Name of ToDoList", mName);

                        getActivity().startActivityForResult(getNewNameIntent, result);

                    }
                })
                .setNegativeButton("HAPUS",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent deleteIntent = new Intent(getActivity(), delete.class);
                        final int result = 3;
                        deleteIntent.putExtra("Index of ToDoList", mNum);

                        getActivity().startActivityForResult(deleteIntent, result);

                    }
                })
                .create();
    }
}
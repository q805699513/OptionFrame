package com.longsh.optionframelibrary;

import android.app.AlertDialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.longsh.optionframelibrary.adapter.CenterDialogAdapter;

import java.util.ArrayList;

/**
 * Created by q805699513 on 2017/3/1.
 */

public class OptionCenterDialog {
    private AlertDialog albumDialog;
    private ListView dialog_lv;

    public void show(Context context, ArrayList<String> longData) {
        albumDialog = new AlertDialog.Builder(context).create();
        albumDialog.setCanceledOnTouchOutside(true);
        albumDialog.setCancelable(true);
        View v = LayoutInflater.from(context).inflate(
                R.layout.__picker_dialog_photo_pager, null);
        albumDialog.show();
        albumDialog.setContentView(v);
        albumDialog.getWindow().setGravity(Gravity.CENTER);
        albumDialog.getWindow().setBackgroundDrawableResource(R.drawable.__picker_bg_dialog);
        dialog_lv = (ListView) v.findViewById(R.id.dialog_lv);

        CenterDialogAdapter photoDialogAdapter = new CenterDialogAdapter(context, longData);
        dialog_lv.setAdapter(photoDialogAdapter);
//        dialog_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//                albumDialog.dismiss();
//            }
//        });
    }

    public void setItemClickListener(AdapterView.OnItemClickListener listener) {
        dialog_lv.setOnItemClickListener(listener);
    }

    public void dismiss(){
        albumDialog.dismiss();
    }

}

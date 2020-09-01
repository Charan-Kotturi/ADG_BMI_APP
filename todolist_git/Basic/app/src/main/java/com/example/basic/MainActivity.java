package com.example.basic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements samplePlanDialog.dialogInterface {

    private FloatingActionButton btnAdd;
    private ListView ListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        btnAdd = findViewById(R.id.btnAdd);
        ListView = findViewById(R.id.ListView);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                samplePlanDialog dialog = new samplePlanDialog();
                dialog.show(getSupportFragmentManager(), "Here we are in the dialog");
            }
        });
    }

    @Override
    public void getPlan(Plan plan) {
        if (Utils.addPlan(plan)) {
            Toast.makeText(this, "added "+ plan.getName(), Toast.LENGTH_SHORT).show();
            Utils.addString(plan.getName());

            ArrayList<String> strings1 = Utils.getStr();

            final ArrayAdapter<String> adaptor = new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_list_item_1,
                    strings1
            );

            ListView.setAdapter(adaptor);

            ListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    Utils.getStr().remove(position);
                    adaptor.notifyDataSetChanged();
                    return true;
                }
            });

        }

    }
}
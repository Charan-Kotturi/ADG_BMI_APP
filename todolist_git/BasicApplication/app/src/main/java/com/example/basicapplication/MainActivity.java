package com.example.basicapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.StringSearch;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button btnAdd;
    private ListView listView;
    private ArrayList<String> listArray;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        listArray = new ArrayList<>();

        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                listArray
        );

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                if(!(str.equals(""))) {
                    adapter.add(str);
                    editText.setText("");
                }
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, listArray.get(position) +"Removed", Toast.LENGTH_SHORT).show();
                listArray.remove(position);
                adapter.notifyDataSetChanged();

                return true;
            }
        });

        listView.setAdapter(adapter);

    }
    private void initView(){
        btnAdd = findViewById(R.id.btnAdd);
        editText = findViewById(R.id.editTxt);
        listView = findViewById(R.id.ListView);
    }
}
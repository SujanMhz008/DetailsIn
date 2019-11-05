package com.sujanmaharjan008.detailsin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.sujanmaharjan008.detailsin.adapter.DetailsAdapter;
import com.sujanmaharjan008.detailsin.model.Details;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtAge;
    RadioGroup radioGroup;
    Button btnSave;
    Spinner spinImage;
    RecyclerView recyclerView;
    String name, age, gender;
    int imageId;
    String image[] = {"Cat", "Dog", "Lion", "Hamster", "Tiger",};
    int imageValue[] = {R.drawable.cat, R.drawable.dog, R.drawable.lion, R.drawable.hamster, R.drawable.tiger};
    Map<String, Integer> imageMap;
    final List<Details> detailsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);
        radioGroup = findViewById(R.id.radioGroup);
        btnSave = findViewById(R.id.btnSave);
        spinImage = findViewById(R.id.spinImage);
        recyclerView = findViewById(R.id.recyclerView);

        imageMap = new HashMap<>();
        for (int i = 0; i < image.length; i += 1) {
            imageMap.put(image[i], imageValue[i]);
        }

        ArrayAdapter<String> imageAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList<>(imageMap.keySet())
        );
        spinImage.setAdapter(imageAdapter);

        spinImage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String imagePos = parent.getItemAtPosition(position).toString();

                imageId = imageMap.get(imagePos);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = edtName.getText().toString();

                age = edtAge.getText().toString();

                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == R.id.rdMale) {
                    gender = "M";
                } else if (selectedId == R.id.rdFemale) {
                    gender = "F";
                } else if (selectedId == R.id.rdOthers) {
                    gender = "O";
                }

                detailsList.add(new Details(name, gender, age, imageId, R.drawable.delete));

                DetailsAdapter detailsAdapter = new DetailsAdapter(MainActivity.this, detailsList);
                recyclerView.setAdapter(detailsAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            }
        });
    }
}

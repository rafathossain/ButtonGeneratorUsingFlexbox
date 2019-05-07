package com.shoutlab.buttongeneratorusingflexbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerViewButton;
    ButtonAdapter buttonAdapter;

    ArrayList<ButtonItems> buttonItems = new ArrayList<>();

    EditText buttons;

    Button generate_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttons = findViewById(R.id.button_numbers);
        generate_btn = findViewById(R.id.generate);
        recyclerViewButton = findViewById(R.id.recyclerViewButton);

        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(MainActivity.this);
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setAlignItems(AlignItems.STRETCH);

        recyclerViewButton.setLayoutManager(layoutManager);

        generate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = Integer.valueOf(buttons.getText().toString());

                buttonItems = new ArrayList<>();

                // create instance of Random class
                Random rand = new Random();

                for(int i = 0 ; i < count ; i++){
                    // Generate random integers in range 0 to 999
                    int rand_int1 = rand.nextInt(1000000);

                    buttonItems.add(new ButtonItems(String.valueOf(i)));
                }

                buttonAdapter = new ButtonAdapter(MainActivity.this, buttonItems);
                recyclerViewButton.setAdapter(buttonAdapter);
            }
        });
    }
}

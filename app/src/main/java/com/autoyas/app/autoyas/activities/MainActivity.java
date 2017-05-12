package com.autoyas.app.autoyas.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.autoyas.app.autoyas.R;
import com.github.mikephil.charting.charts.LineChart;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LineChart chart = (LineChart) findViewById(R.id.chart);
    }
}

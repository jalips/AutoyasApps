package com.autoyas.app.autoyas.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.autoyas.app.autoyas.R;
import com.autoyas.app.autoyas.utils.asyncTaskManager.asyncTasks.AsyncGetDeviceGet;
import com.autoyas.app.autoyas.utils.asyncTaskManager.asyncTasks.AsyncGetStats;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.List;

public class ChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        Intent intent = getIntent();
        int device_id = intent.getIntExtra("device_id", 0);

        if(device_id > 0){
            Toast toast = Toast.makeText(this, "This is stats for device : "+device_id, Toast.LENGTH_SHORT);
            toast.show();

            // in this example, a LineChart is initialized from xml
            LineChart chart = (LineChart) findViewById(R.id.chart);

            // Call api to get devices
            AsyncGetStats asyncGetStats = new AsyncGetStats(this, findViewById(android.R.id.content), device_id, chart);
            asyncGetStats.execute();

        }else{
            Toast toast = Toast.makeText(this, "Device and stats not found", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}

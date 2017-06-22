package com.autoyas.app.autoyas.utils.asyncTaskManager.asyncTasks;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.autoyas.app.autoyas.R;
import com.autoyas.app.autoyas.activities.listView.recyclerAdapter.MainRecyclerAdapter;
import com.autoyas.app.autoyas.entities.Device;
import com.autoyas.app.autoyas.entities.Stat;
import com.autoyas.app.autoyas.utils.asyncTaskManager.AsyncTaskApiGet;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by link on 22/06/17.
 */

public class AsyncGetStats extends AsyncTaskApiGet {

    private View rootView;
    private LineChart chart;

    /**
     * Constructor
     * @param context Current context
     * @param rootView Current view
     * @param chart LineChart chart
     */
    public AsyncGetStats(Context context, View rootView, int device_id, LineChart chart) {
        this.context = context;
        this.rootView = rootView;
        this.chart = chart;

        this.apiMethod = "GET";
        this.apiUrl = context.getResources().getString(R.string.apiUrl)+"/statistics";
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        try {

            //final ProgressBar progress = (ProgressBar) rootView.findViewById(R.id.progress);
            //progress.setVisibility(View.GONE);

            JSONArray array = new JSONArray(result);
            List<Entry> entriesTemp = new ArrayList<Entry>();
            List<Entry> entriesHydro = new ArrayList<Entry>();
            List<Entry> entriesValve = new ArrayList<Entry>();
            List<Stat> stats = new ArrayList<Stat>();
            String statType = "Label";
            for(int n = 0; n < array.length()-1; n++)
            {
                JSONObject object = array.getJSONObject(n);
                Log.i("AsyncGetAuthGet", "OnPostExecute jObject : "+object.toString());

                JSONObject statistic_type = object.getJSONObject("statistic_type");
                statType = statistic_type.getString("name");

                Stat stat = new Stat();
                stat.setId(object.getInt("id"));
                stat.setData(object.getInt("data"));
                stat.setCreatedAt(object.getString("created_at"));
                stat.setStatisticType(statType);

                stats.add(stat);

                if(stat.getStatisticType().equals("temp")){
                    entriesTemp.add(new Entry(n, stat.getData()));
                }else if(stat.getStatisticType().equals("hydro")){
                    entriesHydro.add(new Entry(n, stat.getData()));
                }else if(stat.getStatisticType().equals("valve")) {
                    entriesValve.add(new Entry(n, stat.getData()));
                }

            }

            // add entries to dataset
            LineDataSet dataSetTemp = new LineDataSet(entriesTemp, "temp");
            LineDataSet dataSetHydro = new LineDataSet(entriesHydro, "hydro");
            LineDataSet dataSetValve = new LineDataSet(entriesValve, "valve");
            dataSetHydro.setColor(R.color.green);
            dataSetValve.setColor(R.color.red);
            //dataSet.setValueTextColor(...);

            // use the interface ILineDataSet
            List<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
            dataSets.add(dataSetTemp);
            dataSets.add(dataSetHydro);
            dataSets.add(dataSetValve);

            LineData lineData = new LineData(dataSets);
            chart.setData(lineData);
            // refresh
            chart.invalidate();

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}

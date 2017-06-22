package com.autoyas.app.autoyas.utils.asyncTaskManager;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.autoyas.app.autoyas.R;
import com.autoyas.app.autoyas.activities.listView.recyclerAdapter.MainRecyclerAdapter;
import com.autoyas.app.autoyas.entities.Device;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by link on 22/06/17.
 */

public class AsyncGetDeviceGet extends AsyncTaskApiGet {

    private View rootView;
    private MainRecyclerAdapter adapter;

    /**
     * Constructor
     * @param context Current context
     * @param rootView Current view
     * @param user_id User login
     */
    public AsyncGetDeviceGet(Context context, View rootView, int user_id, MainRecyclerAdapter adapter) {
        this.context = context;
        this.rootView = rootView;
        this.adapter = adapter;

        this.apiMethod = "GET";
        this.apiUrl = context.getResources().getString(R.string.apiUrl)+"/devices";
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        try {

            //final ProgressBar progress = (ProgressBar) rootView.findViewById(R.id.progress);
            //progress.setVisibility(View.GONE);

            JSONArray array = new JSONArray(result);
            List<Device> devices = new ArrayList<>();
            for(int n = 0; n < array.length(); n++)
            {
                JSONObject object = array.getJSONObject(n);
                Log.i("AsyncGetAuthGet", "OnPostExecute jObject : "+object.toString());

                Device device = new Device();
                device.setId(object.getInt("id"));
                device.setMacAdress(object.getString("mac_adress"));
                device.setStatus(object.getBoolean("status"));

                devices.add(device);
            }

            adapter.setListItems(devices);
            adapter.notifyDataSetChanged();

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}

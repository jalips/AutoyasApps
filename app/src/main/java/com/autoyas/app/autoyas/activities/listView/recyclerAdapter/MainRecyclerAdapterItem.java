package com.autoyas.app.autoyas.activities.listView.recyclerAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.autoyas.app.autoyas.activities.ChartActivity;
import com.autoyas.app.autoyas.activities.LoginActivity;
import com.autoyas.app.autoyas.activities.MainActivity;
import com.autoyas.app.autoyas.activities.listView.ListFragment;
import com.autoyas.app.autoyas.entities.Device;
import com.autoyas.app.autoyas.R;

/**
 * Class Item for MainRecyclerAdapter binding view with data
 */
public class MainRecyclerAdapterItem extends RecyclerView.ViewHolder{

    private final TextView text_device_info;
    private Device currentPair;

    public MainRecyclerAdapterItem(final Context context, final View itemView) {
        super(itemView);

        text_device_info = ((TextView) itemView.findViewById(R.id.text_device_info));

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), ChartActivity.class);
                intent.putExtra("device_id", currentPair.getId());
                view.getContext().startActivity(intent);
            }
        });
    }

    /**
     * Bind view param to actual article data
     * @param device
     */
    public void display(Device device, Context context) {
        currentPair = device;
        text_device_info.setText(device.getMacAdress());
    }
}

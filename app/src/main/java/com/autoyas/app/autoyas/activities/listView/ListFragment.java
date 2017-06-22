package com.autoyas.app.autoyas.activities.listView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.autoyas.app.autoyas.activities.listView.recyclerAdapter.MainRecyclerAdapter;
import com.autoyas.app.autoyas.entities.DeviceDAO;
import com.autoyas.app.autoyas.R;
import com.autoyas.app.autoyas.utils.asyncTaskManager.asyncTasks.AsyncGetDeviceGet;

/**
 *
 */
public class ListFragment extends Fragment {

    private int numberOfArticle = 1;
    private Toolbar toolbar;

    private MainRecyclerAdapter adapter;

    public MainRecyclerAdapter getAdapter() {
        return adapter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Creation for recycler view and it adapter
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.list_view);

        // Plug into adapter
        adapter = new MainRecyclerAdapter(this.getContext(), DeviceDAO.findNone());
        recyclerView.setAdapter(adapter);

        // Call api to get devices
        AsyncGetDeviceGet asyncGetDevice = new AsyncGetDeviceGet(this.getContext(), view, 1, adapter);
        asyncGetDevice.execute();

        // Display grid manager with the right number
        final GridLayoutManager manager = new GridLayoutManager(this.getContext(), 1);
        // Set the layout to recyclerView
        recyclerView.setLayoutManager(manager);

        return view;
    }

}

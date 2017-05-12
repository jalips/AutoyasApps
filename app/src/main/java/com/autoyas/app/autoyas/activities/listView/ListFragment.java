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
        adapter = new MainRecyclerAdapter(this.getContext(), DeviceDAO.findAllFake());
        recyclerView.setAdapter(adapter);

        // Display grid manager with the right number
        final GridLayoutManager manager = new GridLayoutManager(this.getContext(), 1);
        // Set the layout to recyclerView
        recyclerView.setLayoutManager(manager);

        // Bind action for swipe
        /*
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if(Network.isInternet(MainActivity.this)) {
                    // Call API to update pdf
                    ManagePdf managePdf = new ManagePdf(MainActivity.this);
                    managePdf.setmSwipeRefreshLayout(mSwipeRefreshLayout);
                    managePdf.setProgress(adapter);
                    managePdf.handlingInit();
                }else{
                    mSwipeRefreshLayout.setRefreshing(false);

                    // Display some toast
                    Toast toast = Toast.makeText(MainActivity.this, "Connection internet requise.", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                    toast.show();
                }
            }
        });
        */

        return view;
    }

}

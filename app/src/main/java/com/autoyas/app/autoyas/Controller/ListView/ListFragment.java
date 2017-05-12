package com.autoyas.app.autoyas.Controller.ListView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.autoyas.app.autoyas.R;
import com.autoyas.app.autoyas.Utils.Network;

/**
 *
 */
public class ListFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Creation for recycler view and it adapter
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.list_view);

        // Plug into adapter
        ArticleDAO articleDAO = new ArticleDAO(this);
        adapter = new MainRecyclerAdapter(this, articleDAO.findAll());
        recyclerView.setAdapter(adapter);

        // Display grid manager with the right number
        final GridLayoutManager manager = new GridLayoutManager(this, 1);
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

    }

}

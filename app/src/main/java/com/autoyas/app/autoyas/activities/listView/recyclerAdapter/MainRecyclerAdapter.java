package com.autoyas.app.autoyas.activities.listView.recyclerAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.autoyas.app.autoyas.entities.Device;
import com.autoyas.app.autoyas.R;

import java.util.List;


/**
 * Class Adapter to create and bind RecyclerView
 */
public class MainRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM = 1;

    private Context context;
    private List<Device> listItems;

    public void setListItems(List<Device> listItems) {
        this.listItems = listItems;
    }

    /**
     * Constructor
     * @param context
     * @param listItems
     */
    public MainRecyclerAdapter(Context context, List<Device> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    /**
     * Count the number of item
     * Increasing getItemcount to 1. This will be the row of header.
     * @return
     */
    @Override
    /*
    public int getItemCount() {
      return listItems.size()+1;
    }
    */
    public int getItemCount() {
        return listItems.size();
    }

    /**
     * Get item position
     * @param position
     * @return
     */
    private Device getItem(int position)
    {
        return listItems.get(position);
    }

    /**
     * Return the type of item - ITEM or HEADER(need to override this method)
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        return TYPE_ITEM;
    }

    /**
     * Create the view (switch for header to item)
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_ITEM) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
            return new MainRecyclerAdapterItem(context, v);
        }
        throw new RuntimeException("there is no type that matches the type " + viewType + " + make sure your using types correctly");
    }

    /**
     * Override method call each time a row is visible (switch for header to item)
     * @param holder
     * @param position
     * @return
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof MainRecyclerAdapterItem) {
            //Device currentItem = getItem(position-1);
            Device currentItem = getItem(position);
            MainRecyclerAdapterItem VHitem = (MainRecyclerAdapterItem)holder;
            VHitem.display(currentItem, context);
        }
    }

}

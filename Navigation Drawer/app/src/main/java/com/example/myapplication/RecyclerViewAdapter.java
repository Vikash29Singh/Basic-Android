package com.example.myapplication;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>  {
    private Context mContext;
    private ArrayList<Model> modelList;
    //private ClickAdapterListener listener;
    private SparseBooleanArray selectedItems;


    private static int currentSelectedIndex = -1;

    public class MyViewHolder extends RecyclerView.ViewHolder /*implements View.OnLongClickListener*/ {
        public TextView textView, textView1, textView2;
        ImageView iv,btn_favorites;
        public LinearLayout linearLayout;

        public MyViewHolder(View view) {
            super(view);
            textView =  view.findViewById(R.id.textView);
            textView1 = view.findViewById(R.id.textView1);
            textView2 = view.findViewById(R.id.textView2);
            iv = view.findViewById(R.id.iv);
            btn_favorites = view.findViewById(R.id.btn_favorites);
            linearLayout = view.findViewById(R.id.linearLayout);
           // view.setOnLongClickListener(this);
        }

/*
        @Override
        public boolean onLongClick(View view) {
            listener.onRowLongClicked(getAdapterPosition());
            view.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
            return true;
        }
*/
    }


    public RecyclerViewAdapter(Context mContext, ArrayList<Model> modelList /*ClickAdapterListener listener*/) {
        this.mContext = mContext;
        this.modelList = modelList;
        //this.listener = listener;
        selectedItems = new SparseBooleanArray();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        //String text = modelList.get(position).text;
        Model model = modelList.get(position);
        holder.textView.setText(model.getName());
        holder.textView1.setText(model.getManufacturer());
        holder.textView2.setText(model.getPrice());
        holder.iv.setImageResource(model.getImage());
        holder.btn_favorites.setImageResource(model.getFav());

        //holder.textView.setText(text);

        //favorites System


        /*if (modelList.get(position).colored)
            holder.textView.setTextColor(mContext.getResources().getColor(android.R.color.holo_red_dark));

        holder.itemView.setActivated(selectedItems.get(position, false));
*/
        //applyClickEvents(holder, position);
    }

    /*private void applyClickEvents(MyViewHolder holder, final int position) {
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onRowClicked(position);
            }
        });

        holder.linearLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                listener.onRowLongClicked(position);
                view.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
                return true;
            }
        });
    }
*/

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    /*public void toggleSelection(int pos) {
        currentSelectedIndex = pos;
        if (selectedItems.get(pos, false)) {
            selectedItems.delete(pos);
        } else {
            selectedItems.put(pos, true);
        }
        notifyItemChanged(pos);
    }

    public void selectAll() {

        for (int i = 0; i < getItemCount(); i++)
            selectedItems.put(i, true);
        notifyDataSetChanged();

    }


    public void clearSelections() {
        selectedItems.clear();
        notifyDataSetChanged();
    }


    public int getSelectedItemCount() {
        return selectedItems.size();
    }

    public List<Integer> getSelectedItems() {
        List<Integer> items =
                new ArrayList(selectedItems.size());
        for (int i = 0; i < selectedItems.size(); i++) {
            items.add(selectedItems.keyAt(i));
        }
        return items;
    }

    public void removeData(int position) {
        modelList.remove(position);
        resetCurrentIndex();
    }

    public void updateData(int position) {
        modelList.get(position).colored = true;
        resetCurrentIndex();
    }

    private void resetCurrentIndex() {
        currentSelectedIndex = -1;
    }

    public interface ClickAdapterListener {

        void onRowClicked(int position);

        void onRowLongClicked(int position);
    }*/
}
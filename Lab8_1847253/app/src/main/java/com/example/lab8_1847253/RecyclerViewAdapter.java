package com.example.lab8_1847253;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.HapticFeedbackConstants;
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
    private ClickAdapterListener listener;
    private SparseBooleanArray selectedItems;

    private static int currentSelectedIndex = -1;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {
        public TextView textView, textView1, textView2, textView3;
        private ImageView imageView;
        public LinearLayout linearLayout;


        public MyViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.textView);
            textView1 = (TextView) view.findViewById(R.id.textView1);
            textView2 = (TextView) view.findViewById(R.id.textView2);
            textView3 = (TextView) view.findViewById(R.id.textView3);
            imageView = (ImageView) view.findViewById(R.id.imageView);

            linearLayout = (LinearLayout) view.findViewById(R.id.relativeLayout);
            view.setOnLongClickListener(this);
        }

        @Override
        public boolean onLongClick(View view) {
            listener.onRowLongClicked(getAdapterPosition(), view);
            view.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
            return true;
        }
    }


    public RecyclerViewAdapter(Context mContext, ArrayList<Model> modelList, ClickAdapterListener listener) {
        this.mContext = mContext;
        this.modelList = modelList;
        this.listener = listener;
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
        Model model = modelList.get(position);
        holder.textView.setText(model.getTitle());
        holder.textView1.setText(model.getGenre());
        holder.textView2.setText(model.getYear());
        holder.textView3.setText(model.getRating());
        holder.imageView.setImageResource(model.getImage());

        if (modelList.get(position).colored)
            holder.textView.setTextColor(mContext.getResources().getColor(android.R.color.holo_red_dark));

        holder.itemView.setActivated(selectedItems.get(position, false));

        applyClickEvents(holder, position);
    }

    private void applyClickEvents(MyViewHolder holder, final int position) {
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onRowClicked(position, view);
            }
        });

        holder.linearLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                listener.onRowLongClicked(position, view);
                view.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
                return true;
            }
        });
    }


    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public void toggleSelection(int pos) {
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

    public ArrayList<Integer> getSelectedItems() {
        ArrayList<Integer> items =
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

        void onRowClicked(int position, View v);

        void onRowLongClicked(int position, View v);
    }
}
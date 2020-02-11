package com.example.Travelprogram;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        public TextView textView, textView1, textView2,dept_time,arival_time;
        ImageView iv,btn_favorites;
       // public LinearLayout linearLayout;

        public MyViewHolder(View view) {
            super(view);
            textView =  view.findViewById(R.id.textView);
            textView1 = view.findViewById(R.id.textView1);
            textView2 = view.findViewById(R.id.textView2);
            arival_time= view.findViewById(R.id.arrival_time);
            dept_time= view.findViewById(R.id.dept_time);

            iv = view.findViewById(R.id.iv);
            //btn_favorites = view.findViewById(R.id.btn_favorites);

        }

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
        holder.textView1.setText(model.getDestination());
        holder.textView2.setText(model.getPrice());
        holder.arival_time.setText(model.getArival_time());
        holder.dept_time.setText(model.getDept_time());

        holder.iv.setImageResource(model.getImage());
       // holder.btn_favorites.setImageResource(model.getFav());


    }



    @Override
    public int getItemCount() {
        return modelList.size();
    }


}
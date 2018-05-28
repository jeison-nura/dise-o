package com.example.jeison.entrega2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.jeison.entrega2.R;
import com.example.jeison.entrega2.Reminder;

import java.util.List;

public class ReminderAdapter extends RecyclerView.Adapter<ReminderAdapter.MyViewHolder> {

    private Context mContext;
    private List<Reminder> reminderList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        private View elementView;



        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.info);
            elementView = view;
        }
    }


    public ReminderAdapter(Context mContext, List<Reminder> reminderList) {
        this.mContext = mContext;
        this.reminderList = reminderList;
    }


    //@Override
    //public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    //    View itemView = LayoutInflater.from(parent.getContext())
    //            .inflate(R.layout.reminder_card, parent, false);
    //
    //    return new MyViewHolder(itemView);
    //}

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reminder_r_view,null,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Reminder reminder = reminderList.get(position);

        holder.elementView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"Info: "+reminder.getName(),Toast.LENGTH_SHORT).show();

            }
        });
        holder.title.setText(reminder.getName());

    }

    @Override
    public int getItemCount() {
        return reminderList.size();
    }
}

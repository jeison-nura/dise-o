package com.example.jeison.entrega2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jorge_000 on 1/05/2018.
 */

public class TagAdapter extends RecyclerView.Adapter<TagAdapter.MyViewHolder>{
    private Context mContext;
    private List<Tag> tagList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        private View elementView;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.infoTag);
            elementView = view;
        }
    }


    public TagAdapter(Context mContext, List<Tag> tagList) {
        this.mContext = mContext;
        this.tagList = tagList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tag_r_view,null,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Tag tag = tagList.get(position);

        holder.elementView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(mContext,"Click seleccionando: "+serie.getName(),Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(mContext,Main2Activity.class );
                //intent.putExtra("name", serie.getName());
                //intent.putExtra("numOfSongs", serie.getNumOfSeasons());
                //intent.putExtra("thumbnail", serie.getThumbnail());
                //mContext.startActivity(intent);
            }
        });
        holder.title.setText(tag.getName());

    }

    @Override
    public int getItemCount() {
        return tagList.size();
    }
}

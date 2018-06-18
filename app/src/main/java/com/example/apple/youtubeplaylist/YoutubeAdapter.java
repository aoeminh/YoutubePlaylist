package com.example.apple.youtubeplaylist;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apple.youtubeplaylist.model.Item;

import java.util.ArrayList;
import java.util.List;

public class YoutubeAdapter extends RecyclerView.Adapter<YoutubeAdapter.ViewHolder> {
private List<Item> itemList = new ArrayList<Item>();
private PlayVideo playVideo;
private Context context;

public YoutubeAdapter( List<Item> items, PlayVideo playVideo, Context context){
    this.itemList = items;
    this.playVideo = playVideo;
    this.context = context;
}
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

    View rowView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.activity_item_list,parent,false);

        return new ViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = itemList.get(position);
        String urlImage = item.getSnippet().getThumbnails().getMedium().getUrl();
        ApUtils.setThumnailForVideo(holder.thumbnails_im,urlImage,context);
        holder.title_tv.setText(item.getSnippet().getTitle());
        holder.date_tv.setText(item.getSnippet().getPublishedAt().substring(0,10));


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView thumbnails_im;
        public TextView title_tv;
        public TextView date_tv;

        public ViewHolder(View itemView) {
            super(itemView);

            thumbnails_im = (ImageView)itemView.findViewById(R.id.im_item_list);
            title_tv =(TextView)itemView.findViewById(R.id.tv_title_item);
            date_tv =(TextView)itemView.findViewById(R.id.tv_date_item);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playVideo.playVideo(getAdapterPosition());
                }
            });
        }


    }

    interface PlayVideo{
        void playVideo(int itemPosition);
    }
}

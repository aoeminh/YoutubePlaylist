package com.example.apple.youtubeplaylist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apple.youtubeplaylist.model.Item;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Main2Activity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener{
    private YouTubePlayerView youTubePlayer;
    private TextView title;
    private TextView date;
    private TextView description;
    private final String API_KEY = "AIzaSyDf4dTkN1wUrdD6NCdei1T5kdHeSnKqQZc";
    private static Item item = new Item();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        youTubePlayer = (YouTubePlayerView) this.findViewById(R.id.yp_play);
        title =(TextView) this.findViewById(R.id.tv_title_play);
        date = (TextView)this.findViewById(R.id.tv_date_play);
        description = (TextView)this.findViewById(R.id.tv_description_play);

        int itempositon =   getIntent().getExtras().getInt("position");
        item = MainActivity.list.get(itempositon);

        String idVideo = item.getId();
        title.setText(item.getSnippet().getTitle());
        date.setText("Public at: "+item.getSnippet().getPublishedAt().substring(0,10));
        description.setText(item.getSnippet().getDescription());
        youTubePlayer.initialize(API_KEY,this);


    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
    youTubePlayer.cueVideo(item.getSnippet().getResourceId().getVideoId());
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if(youTubeInitializationResult.isUserRecoverableError()){

        }


    }
}

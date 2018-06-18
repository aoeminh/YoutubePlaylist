package com.example.apple.youtubeplaylist;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ApUtils {

    public final static String BASE_URL= "https://www.googleapis.com/youtube/v3/";

    public static YoutubeAPI getYoutubeAPI(){
       return RetrofitClient.getRetrofiClient(BASE_URL).create(YoutubeAPI.class);
    }

    public static void setThumnailForVideo(ImageView imageView , String url, Context context){

        Glide.with(context)
                .load(url)
                .into(imageView);
    }
}

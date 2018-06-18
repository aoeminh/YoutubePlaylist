package com.example.apple.youtubeplaylist;

import com.example.apple.youtubeplaylist.model.Data;
import com.example.apple.youtubeplaylist.model.Item;
import com.example.apple.youtubeplaylist.model.ListData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface YoutubeAPI  {

    @GET("playlistItems?part=snippet&playlistId=PLBQ8ujkg6pabDekAr8omYj_HvOsoePBrr&key=AIzaSyDf4dTkN1wUrdD6NCdei1T5kdHeSnKqQZc&maxResults=50")
    Call<ListData> getItem();

}
